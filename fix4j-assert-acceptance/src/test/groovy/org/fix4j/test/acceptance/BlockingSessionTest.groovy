package org.fix4j.test.acceptance;

import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.session.BlockingSession;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.TestSessionHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test
import spock.lang.Specification;

import static org.junit.Assert.assertEquals;

/**
 * User: ben
 * Date: 13/08/2014
 * Time: 8:57 PM
 */
public class BlockingSessionTest extends Specification {
    private static BlockingSession server;
    private static BlockingSession client;

    final String MARKET_DATA_REQUEST =
            "[MsgType]35=V[MARKETDATAREQUEST]|" +
            "[MDReqID]262=AASDJKG790|" +
            "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
            "[MarketDepth]264=20|" +
            "[NoMDEntryTypes]267=2|" +
                "[MDEntryType]269=0[BID]|" +
                "[MDEntryType]269=1[OFFER]|" +
            "[NoRelatedSym]146=3|" +
                "[Symbol]55=GBP/USD|" +
                "[Symbol]55=AUD/USD|" +
                "[Symbol]55=USD/JPY|" +
            "9999=CustomField";

    final String NEW_ORDER_SINGLE =
            "[MsgType]35=D[NEWORDERSINGLE]|" +
            "[OrderQty]38=1000|" +
            "[TimeInForce]59=1[GOOD_TILL_CANCEL_GTC]|" +
            "[ExDestination]100=N|" +
            "[OrdType]40=1[MARKET]|" +
            "[ClOrdID]11=ORD10001|" +
            "[TransactTime]60=20070123-19:01:17|" +
            "[Symbol]55=HPQ|" +
            "[Side]54=1[BUY]|" +
            "[HandlInst]21=2[AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK]|" +
            "9999=CustomField";

    public void setupSpec() throws InterruptedException {
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
        server = helper.createBlockingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        client = helper.createBlockingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);

        //Consume up the logon messages
        while(!client.getNextMessage().getTypeOfMessage().equals(MsgTypes.Logon));
        while(!server.getNextMessage().getTypeOfMessage().equals(MsgTypes.Logon));
    }

    public void cleanupSpec() throws InterruptedException {
        client.shutdown();
        server.shutdown();
    }

    @Test
    public void testClientSendsServerMessage() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);
        final FixMessage msg = server.getNextMessage();

        then:
        assertEquals(MsgTypes.MarketDataRequest, msg.getTypeOfMessage());
    }

    @Test
    public void testServerSendsClientMessage() throws InterruptedException {
        when:
        server.send(NEW_ORDER_SINGLE);
        final FixMessage msg = client.getNextMessage();

        then:
        assertEquals(MsgTypes.NewOrderSingle, msg.getTypeOfMessage());
    }
}
