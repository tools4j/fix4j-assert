package org.fix4j.test.session;

import org.fix4j.test.fixspec.FixSpecification;

/**
 * User: ben
 * Date: 2/12/14
 * Time: 5:59 AM
 */
public interface TestClientSession {
    void shutdown();
    FixSpecification getFixSpecification();
    FixSessionId getSessionId();
}
