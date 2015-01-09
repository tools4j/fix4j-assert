package org.fix4j.test.acceptance;

import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.session.ConsumerSession;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.TestSessionHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test
import spock.lang.Specification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: ben
 * Date: 13/08/2014
 * Time: 8:57 PM
 */
public class ConsumerSessionTest extends Specification{
    private static ConsumerSession server;
    private static ConsumerSession client;
    private static TestConsumer clientConsumer;
    private static TestConsumer serverConsumer;

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
                "[Symbol]55=USD/JPY|";
    
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
            "[HandlInst]21=2[AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK]|";


    private static class TestConsumer implements Consumer<FixMessage>{
        public FixMessage receivedMsg;

        @Override
        public void accept(final FixMessage fixMessage) {
            this.receivedMsg = fixMessage;
        }
    };

    public void setupSpec() throws InterruptedException {
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());

        clientConsumer = new TestConsumer();
        serverConsumer = new TestConsumer();

        client = helper.createConsumerSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR, clientConsumer);
        server = helper.createConsumerSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR, serverConsumer);

        //Consume up the logon messages
        while(clientConsumer.receivedMsg == null || !clientConsumer.receivedMsg.isOfType(MsgTypes.Logon)) Thread.sleep(100);
        while(serverConsumer.receivedMsg == null || !serverConsumer.receivedMsg.isOfType(MsgTypes.Logon)) Thread.sleep(100);

        //Wipe them out
        clientConsumer.receivedMsg = null;
        new TestConsumer().receivedMsg = null;
    }

    public void cleanupSpec() throws InterruptedException {
        client.shutdown();
        server.shutdown();
    }

    public void testClientSendsServerMessage() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);
        Thread.sleep(1000);

        then:
        assert serverConsumer.receivedMsg != null;
        assert MsgTypes.MarketDataRequest == serverConsumer.receivedMsg.getTypeOfMessage();
    }

    public void testServerSendsClientMessage() throws InterruptedException {
        when:
        server.send(NEW_ORDER_SINGLE);
        Thread.sleep(1000);

        then:
        assert clientConsumer.receivedMsg != null;
        assert MsgTypes.NewOrderSingle ==clientConsumer.receivedMsg.getTypeOfMessage();
    }
}
