package org.fix4j.test.examples.config;

import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.TestMessages;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.integration.FixEngineSession;
import org.fix4j.test.integration.FixEngineSessionFactory;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.MatchingSession;
import org.fix4j.test.session.TestSessionHelper;
import org.junit.After;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * By default, fix4j-assert uses QuickFix to send and receive messages.  QuickFix uses the fix
 * protocol.  The application under test doesn't need to be using QuickFix.  As long as it is compatible with
 * the fix protocol, and with QuickFix, then all is good.
 *
 * However if the user has the need to test an application which is not compatible with QuickFix, then the
 * fix engine can be swapped out.  See the _very_ rudimentary example below.
 *
 * User: ben
 */
public class CustomFixEngine {
    private MatchingSession client;
    private MatchingSession server;

    /**
     * Define a custom fix engine.
     *
     * This very simple fix session will simply forward the fix message to the other fix
     * session stored under the targetCompId.
     */
    private static class MyFixSession implements FixEngineSession{

        private FixSessionId fixSessionId;
        private Consumer<FixMessage> toTestClient;
        private static Map<String, MyFixSession> fixSessions = new HashMap<>();

        public MyFixSession(final FixSessionId fixSessionId, final Consumer<FixMessage> toTestClient) {
            this.fixSessionId = fixSessionId;
            this.toTestClient = toTestClient;
            fixSessions.put(fixSessionId.getSenderCompId(), this);
        }

        @Override
        public void shutdown() {
            System.out.println("Shutting down:" + fixSessionId);
        }

        @Override
        public void shutdown(final boolean force) {
            System.out.println("Shutting down:" + fixSessionId);
        }

        @Override
        public void startup() {
            System.out.println("Starting up:" + fixSessionId);
        }

        @Override
        public void accept(final FixMessage fixMessage) {
            System.out.println("Got outbound message:" + fixSessionId + ":" + fixMessage.toPrettyString());
            final MyFixSession destinationSession = fixSessions.get(fixSessionId.getTargetCompId());
            if(destinationSession == null) throw new IllegalStateException("Cannot find fixSession for compId:" + fixSessionId.getTargetCompId() + " fixSessions:" + fixSessions);

            System.out.println("Sending fixMessage to other session");
            destinationSession.toTestClient.accept(fixMessage);
        }

        @Override
        public void logon() {
            System.out.println("Logging in:" + fixSessionId);
        }

        @Override
        public void logout() {
            System.out.println("Logging out:" + fixSessionId);
        }
    }


    @Test
    public void runTest() {
        //Here we wire in the additional processor
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory(){
            @Override
            protected FixEngineSessionFactory createFixEngineSessionFactory(final FixSpecification fixSpecification) {
                return new FixEngineSessionFactory() {
                    @Override
                    public FixEngineSession createSession(final FixSessionId sessionId, final FixConnectionMode connectionMode, final Consumer<FixMessage> consumerToTestClient) {
                        return new MyFixSession(sessionId, consumerToTestClient);
                    }
                };
            }
        });

        server = helper.createMatchingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        client = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);

        //Send a MarketDataRequest
        final FixMessage fixMessage = helper.parse(TestMessages.MARKET_DATA_REQUEST_1);
        client.send(fixMessage);

        //Wait for it to arrive at the server, all is good
        final FixMessage mdr = server.discardUntil(MsgTypes.MarketDataRequest);

        //Got it!
        assertEquals(fixMessage, mdr);
    }

    @After
    public void teardown() throws InterruptedException {
        client.shutdown();
        server.shutdown();
    }
}
