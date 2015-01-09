package org.fix4j.test.examples.servers;

import org.fix4j.spec.fix50sp2.FieldTypes;
import org.fix4j.spec.fix50sp2.FixSpec;
import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.TestMessages;
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
 * This example demonstrates the use of a DispatcherSession to dispatch messages using reflection.
 *
 * A DispatchingSession can be useful if writing a server to use for testing.
 *
 */
public class DispatchingSessionsTest implements Handler {
    private MatchingSession client;
    private DispatchingSession server;

    @Test
    public void runTest() {
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());

        this.server = helper.createDispatchingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR, StringUtils.parseMap("quickfix.socket.accept.port:" + 9880), this);
        this.client = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR, StringUtils.parseMap("quickfix.socket.connect.port:9880"));

        client.send(TestMessages.MARKET_DATA_REQUEST_1);
        client.discardUntil(MsgTypes.MarketDataIncrementalRefresh);

        client.send(TestMessages.NEW_ORDER_SINGLE);
        client.discardUntil(MsgTypes.ExecutionReport);
    }

    @After
    public void tearDown(){
        client.shutdown();;
        server.shutdown();
    }

    public void onMarketDataRequest(final FixMessage marketDataRequest){
        System.out.println("Got an MDR, and sending back a price!");
        server.send(TestMessages.MARKET_DATA_INCREMENTAL_REFRESH);
    }

    public void onNewOrderSingle(final FixMessage marketDataRequest){
        System.out.println("Got an order!, sending back an execution report!");
        server.send(TestMessages.EXECUTION_REPORT);
    }

    public void onLogon(final FixMessage logon){
        //Do nothing
    }

    public void onLogout(final FixMessage logout){
        //Do nothing
    }
}
