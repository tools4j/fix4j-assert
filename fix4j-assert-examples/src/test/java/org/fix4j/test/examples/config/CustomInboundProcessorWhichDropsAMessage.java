package org.fix4j.test.examples.config;

import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.TestMessages;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.Processor;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.session.ContextFactory;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.MatchingSession;
import org.fix4j.test.session.TestSessionHelper;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ben
 */
public class CustomInboundProcessorWhichDropsAMessage {
    private MatchingSession client;
    private MatchingSession server;

    private ContextFactory contextFactory = new DefaultContextFactory() {
        @Override
        protected List<Processor<FixMessage>> createInboundProcessors(final ApplicationProperties properties) {
            //Get the default inboundProcessors from the super class
            final List<Processor<FixMessage>> inboundProcessors = new ArrayList<>(super.createInboundProcessors(properties));

            //Add our own processor to raise a failure if a new order is sent
            inboundProcessors.add(new Processor<FixMessage>() {
                @Override
                public FixMessage process(final FixMessage message) {
                    if (message.isOfType(MsgTypes.NewOrderSingle)) {
                        System.out.println("Dropping this message:" + message);
                        return null;
                    } else {
                        return message;
                    }
                }
            });
            return inboundProcessors;
        }
    };


    @Test
    public void runTest() {
        //Here we wire in the additional processor
        final TestSessionHelper helper = new TestSessionHelper(contextFactory);


        server = helper.createMatchingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        client = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);
        client.discardUntil(MsgTypes.Logon);
        server.discardUntil(MsgTypes.Logon);

        //Send a NewOrderSingle, expect this to be dropped
        client.send(TestMessages.NEW_ORDER_SINGLE);

        //Send an MDR.  This should NOT be dropped
        client.send(TestMessages.MARKET_DATA_REQUEST_1);

        //We expect that the first message to arrive at the server will be an MDR, as the order should have been dropped
        server.expect(MsgTypes.MarketDataRequest);
    }

    @After
    public void teardown() throws InterruptedException {
        client.shutdown();
        server.shutdown();
    }
}
