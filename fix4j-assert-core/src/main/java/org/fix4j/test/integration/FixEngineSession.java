package org.fix4j.test.integration;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.session.FixSession;

/**
 * User: ben
 * Date: 25/09/2014
 * Time: 5:41 AM
 */
public interface FixEngineSession extends FixSession, Consumer<FixMessage> {
    void shutdown();
    void shutdown(boolean force);
    void startup();

    /**
     * Overriding for documentation purposes only.
     *
     * This accept method will be called for OUTBOUND fix messages.  i.e. message which are coming
     * from the test client, and need to go out to the "network".
     *
     * @param fixMessage
     */
    @Override
    void accept(FixMessage fixMessage);
}
