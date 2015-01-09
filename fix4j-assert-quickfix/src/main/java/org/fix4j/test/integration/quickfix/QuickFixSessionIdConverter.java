package org.fix4j.test.integration.quickfix;

import org.fix4j.test.integration.FixSessionIdConverter;
import org.fix4j.test.session.FixSessionId;
import quickfix.SessionID;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 5:50 AM
 */
public class QuickFixSessionIdConverter implements FixSessionIdConverter<SessionID> {
    @Override
    public FixSessionId toFixSessionId(final SessionID sessionId) {
        return new FixSessionId(sessionId.getBeginString(), sessionId.getSenderCompID(), sessionId.getTargetCompID());
    }

    @Override
    public SessionID fromFixSessionId(final FixSessionId fixSessionId) {
        return new SessionID(fixSessionId.getBeginString(), fixSessionId.getSenderCompId(), fixSessionId.getTargetCompId());
    }
}
