package org.fix4j.test.examples.servers;

import org.fix4j.spec.fix50sp2.FieldTypes;
import org.fix4j.spec.fix50sp2.FixSpec;
import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.Handler;
import org.fix4j.test.properties.PropertyKeysAndDefaultValues;
import org.fix4j.test.session.DispatchingSession;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.MatchingSession;
import org.fix4j.test.session.TestSessionHelper;
import org.fix4j.test.util.StringUtils;
import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * This example demonstrates a test which deals with multiple client and server sessions.
 *
 * Currently it is a limitation of the QuickFix integration that it's not possible to have multiple sessions
 * using the same port.  i.e. there can be no more than one senderCompId/targetCompId combination using a port.
 *
 * We plan to fix this in a future release.
 *
 */
public class MultipleSessionsTest implements Handler {
    private final static Logger LOGGER = LoggerFactory.getLogger(MultipleSessionsTest.class);

    public final static String MARKET_DATA_REQUEST =
            "[MsgType]35=V[MARKETDATAREQUEST]|" +
            "[MDReqID]262=${requestId}|" +
            "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
            "[MarketDepth]264=20|" +
            "[NoMDEntryTypes]267=2|" +
                "[MDEntryType]269=0[BID]|" +
                "[MDEntryType]269=1[OFFER]|" +
            "[NoRelatedSym]146=2|" +
                "[Symbol]55=${symbol}|";

    public static final String MARKET_DATA_INCREMENTAL_REFRESH =
            "[MsgType]35=X[MARKETDATAINCREMENTALREFRESH]|" +
            "[MDReqID]262=${requestId}|" +
            "[NoMDEntries]268=4|" +
                "[MDUpdateAction]279=0[NEW]|" +
                "[MDEntryType]269=0[BID]|" +
                "[Symbol]55=${symbol}|" +
                "[MDEntryPx]270=1.12345|" +
                "[MDUpdateAction]279=0[NEW]|" +
                "[MDEntryType]269=1[OFFER]|" +
                "[Symbol]55=${symbol}|" +
                "[MDEntryPx]270=1.12355|" +
                "[MDUpdateAction]279=0[NEW]|" +
                "[MDEntryType]269=0[BID]|" +
                "[Symbol]55=${symbol}|" +
                "[MDEntryPx]270=1.12335|" +
                "[MDUpdateAction]279=0[NEW]|" +
                "[MDEntryType]269=1[OFFER]|" +
                "[Symbol]55=${symbol}|" +
                "[MDEntryPx]270=1.12365|";

    private HashMap<FixSessionId, DispatchingSession> servers = new LinkedHashMap<>();

    @Test
    public void runTest() {
        System.setProperty(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS.getKey(), "20000");

        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());

        createAndRegisterServer(helper, new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID_1"), 9880);
        createAndRegisterServer(helper, new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID_2"), 9881);
        createAndRegisterServer(helper, new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID_3"), 9882);

        final MatchingSession clientSession1 = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID_1", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR, StringUtils.parseMap("fix4j.quickfix.socket.connect.port:9880"));
        final MatchingSession clientSession2 = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID_2", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR, StringUtils.parseMap("fix4j.quickfix.socket.connect.port:9881"));
        final MatchingSession clientSession3 = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID_3", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR, StringUtils.parseMap("fix4j.quickfix.socket.connect.port:9882"));

        clientSession1.send(StringUtils.substituteVariables(MARKET_DATA_REQUEST, StringUtils.parseMap("symbol:AUD/USD,requestId:1234")));
        clientSession2.send(StringUtils.substituteVariables(MARKET_DATA_REQUEST, StringUtils.parseMap("symbol:GBP/USD,requestId:2345")));
        clientSession3.send(StringUtils.substituteVariables(MARKET_DATA_REQUEST, StringUtils.parseMap("symbol:USD/CAD,requestId:3456")));

        LOGGER.info("Now assert that each of the client sessions have recieved the right price");
        final FixMessage priceForClient1 = clientSession1.discardUntil(MsgTypes.MarketDataIncrementalRefresh);
        priceForClient1.getFields(FieldTypes.Symbol).get(0).assertValueEquals("AUD/USD");

        final FixMessage priceForClient2 = clientSession2.discardUntil(MsgTypes.MarketDataIncrementalRefresh);
        priceForClient2.getFields(FieldTypes.Symbol).get(0).assertValueEquals("GBP/USD");

        final FixMessage priceForClient3 = clientSession3.discardUntil(MsgTypes.MarketDataIncrementalRefresh);
        priceForClient3.getFields(FieldTypes.Symbol).get(0).assertValueEquals("USD/CAD");
    }

    @After
    public void tearDown(){
        for (final DispatchingSession dispatchingSession : servers.values()) {
            dispatchingSession.shutdown();
        }
    }

    private DispatchingSession createAndRegisterServer(final TestSessionHelper helper, final FixSessionId fixSessionId, final int acceptorPort) {
        final DispatchingSession server = helper.createDispatchingSession(fixSessionId, FixConnectionMode.ACCEPTOR, StringUtils.parseMap("fix4j.quickfix.socket.accept.port:" + acceptorPort), this);
        servers.put(fixSessionId, server);
        return server;
    }

    public void onMarketDataRequest(final FixMessage marketDataRequest){
        final String symbol = marketDataRequest.getField(FieldTypes.Symbol).getValue();
        final String requestId = marketDataRequest.getField(FieldTypes.MDReqID).getValue();

        final FixSessionId sessionId = marketDataRequest.getSessionId();
        final DispatchingSession session = servers.get(sessionId.reverse());
        final String messageStr = StringUtils.substituteVariables(MARKET_DATA_INCREMENTAL_REFRESH, StringUtils.listToMap("symbol", symbol, "requestId", requestId));
        System.out.println(FixSpec.INSTANCE.parse(messageStr).toDelimitedMessageWithDescriptors());
        session.send(messageStr);
    }

    public void onLogon(final FixMessage logon){
        //Do nothing
    }

    public void onLogout(final FixMessage logout){
        //Do nothing
    }
}
