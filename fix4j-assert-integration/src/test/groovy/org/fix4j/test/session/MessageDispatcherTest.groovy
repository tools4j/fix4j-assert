package org.fix4j.test.session

import org.fix4j.spec.fix50sp2.FixSpec
import org.fix4j.test.TestMessages
import org.fix4j.test.fixmodel.FixMessage
import org.fix4j.test.fixmodel.Handler
import spock.lang.Specification

/**
 * User: ben
 * Date: 22/12/14
 * Time: 11:46 AM
 */
class MessageDispatcherTest extends Specification {
    def "Accept"() {
        given:
        final MyMessageHandler handler = new MyMessageHandler()
        final FixMessage marketDataRequest1 = FixSpec.INSTANCE.parse(TestMessages.MARKET_DATA_REQUEST_1)
        final FixMessage marketDataRequest2 = FixSpec.INSTANCE.parse(TestMessages.MARKET_DATA_REQUEST_2)
        final FixMessage newOrderSingle  = FixSpec.INSTANCE.parse(TestMessages.NEW_ORDER_SINGLE)

        when:
        final MessageDispatcher messageDispatcher = new MessageDispatcher(FixSpec.INSTANCE, handler);

        then:
        assert handler.marketDataRequest == null && handler.newOrderSingle == null;

        when:
        messageDispatcher.accept(marketDataRequest1);

        then:
        assert handler.marketDataRequest != null && handler.newOrderSingle == null;
        assert handler.marketDataRequest == marketDataRequest1;

        when:
        messageDispatcher.accept(newOrderSingle);

        then:
        assert handler.marketDataRequest != null && handler.newOrderSingle != null;
        assert handler.newOrderSingle == newOrderSingle;

        when:
        messageDispatcher.accept(marketDataRequest2);

        then:
        assert handler.marketDataRequest != null && handler.newOrderSingle != null;
        assert handler.marketDataRequest == marketDataRequest2;
    }

    def "Accept - when message being accepted has not got a corresponding handler method"() {
        given:
        final MyMessageHandler handler = new MyMessageHandler()
        final FixMessage marketDataRequest = FixSpec.INSTANCE.parse(TestMessages.MARKET_DATA_REQUEST_1)
        final FixMessage marketDataIncrementalRefresh = FixSpec.INSTANCE.parse(TestMessages.MARKET_DATA_INCREMENTAL_REFRESH);

        when:
        final MessageDispatcher messageDispatcher = new MessageDispatcher(FixSpec.INSTANCE, handler);

        then:
        assert handler.marketDataRequest == null && handler.newOrderSingle == null;

        when:
        messageDispatcher.accept(marketDataRequest);

        then:
        assert handler.marketDataRequest != null && handler.newOrderSingle == null;
        assert handler.marketDataRequest == marketDataRequest;

        when:
        messageDispatcher.accept(marketDataIncrementalRefresh);

        then:
        final IllegalArgumentException e = thrown();
        assert e.getMessage().contains("Unsupported message type:X[MarketDataIncrementalRefresh]. Methods have been found for MsgTypes:[D[NewOrderSingle], V[MarketDataRequest]] be sure to implement a method matching signature 'public void onMarketDataIncrementalRefresh(FixMessage message)");
    }

    private static class MyMessageHandler implements Handler {
        public FixMessage marketDataRequest;
        public FixMessage newOrderSingle

        public void onMarketDataRequest(final FixMessage marketDataRequest){
            this.marketDataRequest = marketDataRequest;
        }

        public void onNewOrderSingle(final FixMessage newOrderSingle){
            this.newOrderSingle = newOrderSingle;
        }
    }
}
