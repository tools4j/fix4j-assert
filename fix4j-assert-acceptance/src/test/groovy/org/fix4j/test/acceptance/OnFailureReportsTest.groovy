package org.fix4j.test.acceptance

import org.fix4j.spec.fix50sp2.MsgTypes
import org.fix4j.test.DefaultContextFactory
import org.fix4j.test.TestMessages
import org.fix4j.test.fixmodel.FixMessage
import org.fix4j.test.session.*
import org.fix4j.test.util.Consts
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

import static org.junit.Assert.fail

/**
 * User: ben
 * Date: 13/08/2014
 * Time: 8:57 PM
 */
class OnFailureReportsTest extends Specification {
    private final static Logger LOGGER = LoggerFactory.getLogger(OnFailureReportsTest.class);

    private static MatchingSession server;
    private static MatchingSession client;

    private final static String MARKET_DATA_REQUEST_1 =
            "[MsgType]35=V[MARKETDATAREQUEST]|" +
            "[MDReqID]262=12345|" +
            "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
            "[MarketDepth]264=20|" +
            "[NoMDEntryTypes]267=2|" +
            "[MDEntryType]269=0[BID]|" +
            "[MDEntryType]269=1[OFFER]|" +
            "[NoRelatedSym]146=3|" +
            "[Symbol]55=GBP/USD|" +
            "[Symbol]55=AUD/USD|" +
            "[Symbol]55=USD/JPY|";

    private final static String MARKET_DATA_REQUEST_2 =
            "[MsgType]35=V[MARKETDATAREQUEST]|" +
            "[MDReqID]262=45678|" +
            "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
            "[MarketDepth]264=20|" +
            "[NoMDEntryTypes]267=2|" +
            "[MDEntryType]269=0[BID]|" +
            "[MDEntryType]269=1[OFFER]|" +
            "[NoRelatedSym]146=3|" +
            "[Symbol]55=GBP/USD|" +
            "[Symbol]55=USD/JPY|";

    private final static String NEW_ORDER_SINGLE_1 =
            "[MsgType]35=D[NEWORDERSINGLE]|" +
            "[OrderQty]38=1000000|" +
            "[TimeInForce]59=1[GOOD_TILL_CANCEL_GTC]|" +
            "[ExDestination]100=N|" +
            "[OrdType]40=1[MARKET]|" +
            "[ClOrdID]11=ORD10001|" +
            "[TransactTime]60=20070123-19:01:17|" +
            "[Symbol]55=HPQ|" +
            "[Side]54=1[BUY]|" +
            "[HandlInst]21=2[AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK]|";

    private final static String NEW_ORDER_SINGLE_2 =
            "[MsgType]35=D[NEWORDERSINGLE]|" +
            "[OrderQty]38=3000000|" +
            "[TimeInForce]59=1[GOOD_TILL_CANCEL_GTC]|" +
            "[ExDestination]100=N|" +
            "[OrdType]40=1[MARKET]|" +
            "[ClOrdID]11=ORD10001|" +
            "[TransactTime]60=20070123-19:01:17|" +
            "[Symbol]55=HPQ|" +
            "[Side]54=1[BUY]|" +
            "[HandlInst]21=2[AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK]|";

    private static FixMessage marketDataRequest1;
    private static FixMessage marketDataRequest2;
    private static FixMessage newOrderSingle1;
    private static FixMessage newOrderSingle2;

    public void setup() throws InterruptedException {
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());

        marketDataRequest1 = helper.parse(MARKET_DATA_REQUEST_1);
        marketDataRequest2 = helper.parse(MARKET_DATA_REQUEST_2);
        newOrderSingle1 = helper.parse(NEW_ORDER_SINGLE_1);
        newOrderSingle2 = helper.parse(NEW_ORDER_SINGLE_2);

        server = helper.createMatchingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        client = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);
    }

    public void cleanup() throws InterruptedException {
        client.shutdown();
        server.shutdown();
    }

    public void testDiscardUntilExpected_msgType_thenExpression(){
        when:
        client.discardUntil(MsgTypes.Logon);
        server.discardUntil(MsgTypes.Logon);
        client.send(marketDataRequest1);
        server.discardUntil(MsgTypes.MarketDataRequest, "[MsgType]35=D[NEWORDERSINGLE]");

        then:
        def e = thrown(AssertionError);
        LOGGER.info(e.getMessage())
        assertContainsBlockOfText(e.getMessage(),
                "FIX.4.4:SERVER_COMP_ID->CLIENT_COMP_ID: \n" +
                "    1. Found message that matches: MsgTypeMatcher{expectedMsgType=V[MarketDataRequest]}\n" +
                "    2. But message does not match: [MsgType]35=D[NEWORDERSINGLE]|\n");
    }


    public void testRecentOutboundMessages(){
        when:
        final FixMessage clientLogon = client.discardUntil(MsgTypes.Logon);
        final FixMessage serverLogon = server.discardUntil(MsgTypes.Logon);

        server.send(marketDataRequest1);
        server.send(newOrderSingle1);
        client.send(marketDataRequest2);
        server.discardUntil(MsgTypes.MarketDataRequest, "[MsgType]35=D[NEWORDERSINGLE]");

        then:
        def e = thrown(AssertionError);
        LOGGER.info(e.getMessage())
        assertContainsBlockOfText(e.getMessage(),
                    "RECENT OUTBOUND MESSAGES\n" +
                    "    1. ${marketDataRequest1.toDelimitedMessageWithDescriptors()}\n" +
                    "    2. ${newOrderSingle1.toDelimitedMessageWithDescriptors()}");
    }

    public void testSendingAFieldWhichShouldNotBePopulated(){
        when:
        client.discardUntil(MsgTypes.Logon);
        server.discardUntil(MsgTypes.Logon);

        client.send("[SenderCompID]49=CLIENT_COMP_ID|" +
                    "[TargetCompID]56=SERVER_COMP_ID|" +
                    "[MsgType]35=V[MARKETDATAREQUEST]|" +
                    "[MDReqID]262=12345|" +
                    "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
                    "[MarketDepth]264=20|" +
                    "[NoMDEntryTypes]267=2|" +
                    "[MDEntryType]269=0[BID]|" +
                    "[MDEntryType]269=1[OFFER]|" +
                    "[NoRelatedSym]146=3|" +
                    "[Symbol]55=GBP/USD|" +
                    "[Symbol]55=AUD/USD|" +
                    "[Symbol]55=USD/JPY|");

        then:
        def e = thrown(AssertionError);
        LOGGER.info(e.getMessage())
        assertContainsBlockOfText(e.getMessage(),
                "1.   [SenderCompID]49: Field was explicitly set in message. Unless explicitly testing such functionality, this field should be left to the fix engine.\n" +
                "2.   [TargetCompID]56: Field was explicitly set in message. Unless explicitly testing such functionality, this field should be left to the fix engine.\n");
    }

    public void testRecentInboundMessages(){
        when:
        final FixMessage clientLogon = client.discardUntil(MsgTypes.Logon);
        final FixMessage serverLogon = server.discardUntil(MsgTypes.Logon);

        client.send(newOrderSingle1);
        client.send(newOrderSingle2);
        client.send(marketDataRequest2);

        final recievedNewOrderSingle1 = server.discardUntil(MsgTypes.NewOrderSingle);
        final recievedNewOrderSingle2 = server.discardUntil(MsgTypes.NewOrderSingle);

        //Cause a failure by waiting for a MarketDataRequest, but assert it contains a newOrderSingle tag
        server.discardUntil(MsgTypes.MarketDataRequest, "[MsgType]35=D[NEWORDERSINGLE]");

        then:
        final Failure f = thrown(Failure);
        LOGGER.info(f.getMessage())
        assertContainsBlockOfText(f.getMessage(),
                    "RECENT INBOUND MESSAGES\n" +
                    "    1. ${serverLogon.toDelimitedMessageWithDescriptors()}\n" +
                    "    2. ${recievedNewOrderSingle1.toDelimitedMessageWithDescriptors()}\n" +
                    "    3. ${recievedNewOrderSingle2.toDelimitedMessageWithDescriptors()}\n" +
                    "    4. ${f.getFixMessage().toDelimitedMessageWithDescriptors()}\n");
    }



    public void testContainsBlockOfText_pass_startingHalfwayThroughLine(){
        given:
        final String str = "a12a34567890a\n" +
                           "b12b34567890b\n" +
                           "c12c34567890c\n" +
                           "d12d34567890d\n" +
                           "e12e34567890e\n" +
                           "f12f34567890f\n";

        final String block = "c34567890c\n" +
                              "d34567890d\n" +
                              "e34567890e\n";

        expect:
        assertContainsBlockOfText(str, block);
    }

    public void testContainsBlockOfText_pass_startingAtStartOfLine(){
        given:
        final String str =
                "a12a34567890a\n" +
                "b12b34567890b\n" +
                "c12c34567890c\n" +
                "d12d34567890d\n" +
                "e12e34567890e\n" +
                "f12f34567890f\n";

        final String block =
                "c12c34567890c\n" +
                "d12d34567890d\n" +
                "e12e34567890e\n";

        expect:
        assertContainsBlockOfText(str, block);
    }

    public void testContainsBlockOfText_fail(){
        given:
        final String str = "a12a34567890a\n" +
                "b12b34567890b\n" +
                "c12c34567890c\n" +
                "d12d34567890d\n" +
                "e12e34567890e\n" +
                "f12f34567890f\n";

        final String block = "c3456\n" +
                "d3456\n" +
                "e3456\n";

        when:
        assertContainsBlockOfText(str, block);

        then:
        thrown AssertionError;
    }


    public void assertContainsBlockOfText(final String str, final String block){
        if(str.count(block) > 1){
            fail("The block of text exists inside the string more than once.  Block:" + block + " str:" + str);
        }
        final List<String> blockLines = block.readLines();
        final List<String> strLines = str.readLines();
        final String firstLineOfBlock = blockLines.get(0)

        if(!str.contains(firstLineOfBlock)){
            fail("The given string does not contain the first line of the block of text.  First line:" + firstLineOfBlock + " str:" + str);
        }

        int strLineWhereBlockStarts = 0;
        for (final String strLine : strLines) {
            if(strLine.contains(firstLineOfBlock)){
                break;
            }
            strLineWhereBlockStarts++;
        }

        if(strLines.size() - strLineWhereBlockStarts < blockLines.size()){
            fail("The given string does not contain enough lines to hold the block of text, from where the first line of the block of text was found.");
        }

        final List<String> strLinesContainingBlock = new ArrayList<>();
        for(int i=strLineWhereBlockStarts; i<(strLineWhereBlockStarts + blockLines.size()); i++){
            strLinesContainingBlock.add(strLines.get(i));
        }

        int charWhereBlockStartsInStr = strLinesContainingBlock.get(0).indexOf(firstLineOfBlock);
        //Strip away first x characters of each line
        final List<String> strippedLinesContainingBlock = new ArrayList<>();
        for (final String line: strLinesContainingBlock) {
            strippedLinesContainingBlock.add(line.substring(charWhereBlockStartsInStr));
        }

        String blockFromStringWhichResemblesBlock = strippedLinesContainingBlock.join(Consts.EOL);
        if((strLineWhereBlockStarts + blockLines.size()) < strLines.size()){
            blockFromStringWhichResemblesBlock += '\n';
        }

        assert blockFromStringWhichResemblesBlock == block;
    }
}
