package org.fix4j.test.acceptance;

import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.MatchingSession;
import org.fix4j.test.session.TestSessionHelper
import spock.lang.Specification

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * User: ben
 * Date: 13/08/2014
 * Time: 8:57 PM
 */
public class MatchingSessionTest extends Specification{
    private static MatchingSession server;
    private static MatchingSession client;

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
            "9999=CustomField";

    public void setupSpec() throws InterruptedException {
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
        server = helper.createMatchingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        client = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);
        client.discardUntil(MsgTypes.Logon);
        server.discardUntil(MsgTypes.Logon);
    }

    public void cleanupSpec() throws InterruptedException {
        client.shutdown();
        server.shutdown();
    }

    /*
    =====================================================================================
    =====================================================================================
    =====================================================================================
    TEST OF discardUntilExpected(final MsgType msgType, final String fixExpression)
     */

    public void testDiscardUntilExpected_matchOnMsgTypeThenFullExpression_passes_fullMsgAsExpression() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);

        then:
        final FixMessage fixMessage = server.discardUntil(MsgTypes.MarketDataRequest, MARKET_DATA_REQUEST);
        assert fixMessage.getTypeOfMessage(), MsgTypes.MarketDataRequest;
    }

    public void testDiscardUntilExpected_matchOnMsgTypeThenFullExpression_passes_wildcard() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);
        final FixMessage fixMessage = server.discardUntil(MsgTypes.MarketDataRequest, "35=/.*/");

        then:
        assert fixMessage.getTypeOfMessage() == MsgTypes.MarketDataRequest;
    }

    public void testDiscardUntilExpected_matchOnMsgTypeThenFullExpression_passes_twoRegexes() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);
        final FixMessage fixMessage = server.discardUntil(MsgTypes.MarketDataRequest, "262=/AASD[JKG]+79\\d/");

        then:
        assert fixMessage.getTypeOfMessage() == MsgTypes.MarketDataRequest;
    }

    public void testDiscardUntilExpected_matchOnMsgTypeThenFullExpression_passes_matchInTwoRepeats() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);
        final FixMessage fixMessage = server.discardUntil(MsgTypes.MarketDataRequest, "55=GBP/USD|55=AUD/USD");

        then:
        assert fixMessage.getTypeOfMessage() == MsgTypes.MarketDataRequest;
    }

    public void testDiscardUntilExpected_matchOnMsgTypeThenFullExpression_fails() throws InterruptedException {
        expect:
        client.send(MARKET_DATA_REQUEST);
        try{
            server.discardUntil(MsgTypes.MarketDataRequest, "[MsgType]35=D[NEWORDERSINGLE]");
        } catch(final AssertionError e){
            assertTrue(e.getMessage().contains("Found message that matches"));
            assertTrue(e.getMessage().contains("But message does not match"));
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    /*
    =====================================================================================
    =====================================================================================
    =====================================================================================
    TEST OF discardUntilExpected(final String fixExpression)
     */

    public void testMatchOnAFewFields_passes_matchOnAFewFields() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);
        final FixMessage fixMessage = server.discardUntil(
                "[MsgType]35=V[MARKETDATAREQUEST]|" +
                "[MDReqID]262=AASDJKG790|" +
                "[SubscriptionRequestType]263=0[SNAPSHOT]|");

        then:
        assert fixMessage.getTypeOfMessage() == MsgTypes.MarketDataRequest;
    }

    public void testDiscardUntilMatch_passes_discardingFirstMessage_thenMatchesOnSecond() throws InterruptedException {
        when:
        client.send(NEW_ORDER_SINGLE);
        client.send(MARKET_DATA_REQUEST);
        final FixMessage fixMessage = server.discardUntil(MARKET_DATA_REQUEST);

        then:
        assert fixMessage.getTypeOfMessage() == MsgTypes.MarketDataRequest;
    }

    public void testDiscardUntilExpected_passes_matchOnWholeExpression() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);
        final FixMessage fixMessage = server.discardUntil(MARKET_DATA_REQUEST);

        then:
        assert fixMessage.getTypeOfMessage() == MsgTypes.MarketDataRequest;
    }


    /*
    =====================================================================================
    =====================================================================================
    =====================================================================================
    TEST OF discardUntilMsgTypeReceived(final MsgType msgType)
     */

    public void testDiscardUntilMessageTypeReceived_discardingFirstMessage_thenMatches() throws InterruptedException {
        when:
        client.send(NEW_ORDER_SINGLE);
        client.send(MARKET_DATA_REQUEST);
        final FixMessage fixMessage = server.discardUntil(MsgTypes.MarketDataRequest);

        then:
        assert fixMessage.getTypeOfMessage() == MsgTypes.MarketDataRequest;
    }


     /*
    =====================================================================================
    =====================================================================================
    =====================================================================================
    TEST OF expect(final String fixExpression)
     */

    public void testExpectExpression_passes_matchOnWholeExpression() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);
        final FixMessage fixMessage = server.expect(MARKET_DATA_REQUEST);

        then:
        assert fixMessage.getTypeOfMessage() == MsgTypes.MarketDataRequest;
    }

    public void testExpectExpression_passes_matchInTwoRepeats() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);
        final FixMessage fixMessage = server.expect("55=GBP/USD|55=AUD/USD");

        then:
        assert fixMessage.getTypeOfMessage() == MsgTypes.MarketDataRequest;
    }

    public void testExpectExpression_fails_matchInTwoRepeats_howeverMatchesAreInWrongOrder() throws InterruptedException {
        expect:
        client.send(MARKET_DATA_REQUEST);
        try {
            server.expect("55=AUD/USD|55=GBP/USD");
        } catch (final AssertionError e) {
            assertContains(e.getMessage(), "Message does not match");
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    public void testExpectExpression_fails() throws InterruptedException {
        expect:
        client.send(MARKET_DATA_REQUEST);
        try {
            server.expect(NEW_ORDER_SINGLE);
        } catch (final AssertionError e) {
            assertContains(e.getMessage(), "Message does not match");
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    /*
    =====================================================================================
    =====================================================================================
    =====================================================================================
    TEST OF expect(final MsgType msgType)
     */

    public void testExpectMsgType_passes() throws InterruptedException {
        when:
        client.send(MARKET_DATA_REQUEST);
        final FixMessage fixMessage = server.expect(MsgTypes.MarketDataRequest);

        then:
        assert fixMessage.getTypeOfMessage() == MsgTypes.MarketDataRequest;
    }

    public void testExpectMsgType_fails() throws InterruptedException {
        expect:
        client.send(MARKET_DATA_REQUEST);
        try {
            server.expect(MsgTypes.NewOrderSingle);
        } catch (final AssertionError e) {
            assertContains(e.getMessage(), "Message does not match");
            return;
        }
        fail("Should not reach here.  AssertionError should have been thrown.");
    }

    private void assertContains(final String string, final String contains) {
        if(!string.contains(contains)){
            fail("String:'" + string + "' does not contain '" + contains + "'");
        }
    }
}
