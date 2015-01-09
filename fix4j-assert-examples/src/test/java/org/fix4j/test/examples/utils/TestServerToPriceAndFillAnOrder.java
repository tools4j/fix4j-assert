package org.fix4j.test.examples.utils;

import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.TestMessages;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.properties.PropertyKeysAndDefaultValues;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.MatchingSession;
import org.fix4j.test.session.TestSessionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Can be used by a client test to:
 * --Receive a MarketDataRequest
 * --Respond with a dummy price
 * --Receive an order
 * --Fill that order.
 *
 * Only runs through this sequence once.
 */
public class TestServerToPriceAndFillAnOrder implements Runnable {
    private final static Logger LOGGER = LoggerFactory.getLogger(TestServerToPriceAndFillAnOrder.class);
    private MatchingSession server;

    public static void main(String[] args) {
        new Thread(new TestServerToPriceAndFillAnOrder()).start();
    }

    public void run() {
        System.setProperty(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS.getKey(), "20000");
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
        server = helper.createMatchingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);

        LOGGER.info("Waiting for MarketDataRequest...");
        final FixMessage marketDataRequest = server.discardUntil(MsgTypes.MarketDataRequest);

        LOGGER.info("Got MDR: " + marketDataRequest.toPrettyString());
        LOGGER.info("Sending back price.");
        
        server.send(TestMessages.MARKET_DATA_INCREMENTAL_REFRESH);

        LOGGER.info("Sent price, waiting for order...");
        final FixMessage newOrder = server.discardUntil(MsgTypes.NewOrderSingle);

        LOGGER.info("Got order: " + newOrder.toPrettyString() + "\nSending fill...");
        server.send("35=8|55=CVS|37=ORD10001/03232009|11=ORD10001|17=12345678|150=3|39=2|150=2|54=1|38=1000|40=1|59=1|31=1.12355|32=1000|14=0|6=0|151=0|60=20070123-19:01:17|58=Fill|30=N|207=N|63=0|");
    }


    public void shutdown() {
        server.shutdown();
    }
}
