package org.fix4j.test.integration;

import org.fix4j.test.session.FixSessionId;

/**
 * User: ben
 * Date: 14/08/2014
 * Time: 2:53 PM
 */
public interface FixSessionIdConverter<S> {
    FixSessionId toFixSessionId(S sessionId);
    S fromFixSessionId(FixSessionId fixSessionId);
}
