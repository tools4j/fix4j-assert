package org.fix4j.test.integration;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 5:42 PM
 */
public interface FixEngineSessionFactory {
    /**
     * To clarify how messages should be routed to and from the test client.
     *
     * When creating a FixEngineSession:
     *
     * INBOUND (from network):
     * -- Arrival: of the fix message to the FixEngineSession is a matter for the implementing code.
     * -- Departure: of the fix message must be to the consumer which is passed in via the constructor below "toTestClient".  e.g. toTestClient.accept(FixMessage)
     *
     * OUTBOUND (to network):
     * -- Arrival: of the fix message coming from the test client is via FixEngineSession#accept(FixMessage) method.
     * -- Departure: of the fix message is a matter for the implementing code.
     *
     * @param sessionId The sessionId for the fix session to create.
     * @param fixConnectionMode Whether this fix session should be the INITIATOR of the fix connection, or the ACCEPTOR.
     * @param toTestClient This is where INBOUND fix messages should be sent.  e.g. toTestClient.accept(inboundFixMessage)
     */
    FixEngineSession createSession(final FixSessionId sessionId, final FixConnectionMode fixConnectionMode, final Consumer<FixMessage> toTestClient);
}
