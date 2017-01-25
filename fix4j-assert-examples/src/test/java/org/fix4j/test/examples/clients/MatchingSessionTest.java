package org.fix4j.test.examples.clients;

import org.fix4j.spec.fix50sp2.FieldTypes;
import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.examples.utils.TestServerToPriceAndFillAnOrder;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.MatchingSession;
import org.fix4j.test.session.TestSessionHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * User: ben
 * Date: 13/08/2014
 * Time: 8:57 PM
 */
public class MatchingSessionTest {
    private TestServerToPriceAndFillAnOrder server;
    private MatchingSession client;

    @Before
    public void setup(){
        /*
        Start the test server - usually if you are testing your own fix application, you wouldn't
        need a test server.  At this point, you would start your own application that you are
        testing.
         */
        server = new TestServerToPriceAndFillAnOrder();
        new Thread(server).start();
    }

    @Test
    public void testMatchingSession() {
        //Set the timeout to wait during a match before throwing an exception
        System.setProperty("fix4j.default.fix.msg.wait.timeout.ms", "20000");
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());

        //Create a new session which initiates connection to the server
        client = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);

        //Discard all messages until a Logon message is received
        client.discardUntil(MsgTypes.Logon);

        //Send a MarketDataRequest
        client.send("35=V|262=request123|263=0|264=20|267=2|269=0|269=1|146=1|55=AUD/USD|");

        //Discard all messages until a MarketDataIncrementalRefresh is received, with a symbol of AUD/USD");
        final FixMessage quote = client.discardUntil(MsgTypes.MarketDataIncrementalRefresh, "55=AUD/USD");
        quote.getField("NoMDEntries[2].MDEntryPx").assertValueEquals(1.12335);

        //Now send an order...");
        client.send("35=D|38=1000|59=1|100=N|40=1|11=ORD10001|60=20070123-19:01:17|55=AUD/USD|54=1|9004=asdf");

        //Waiting for fill
        final FixMessage fill = client.discardUntil(MsgTypes.ExecutionReport);

        //Got fill, finished! (Assert ClientOrderId just because)
        fill.getField(FieldTypes.ClOrdID).assertValueEquals("ORD10001");
    }

    @After
    public void shutdown(){
        client.shutdown();
        server.shutdown();;
    }
}
