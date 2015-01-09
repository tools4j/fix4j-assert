package org.fix4j.test.matching.matchers;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.MsgType;


/**
 * User: ben
 * Date: 20/11/14
 * Time: 1:22 AM
 */
public class MsgTypeMatcher implements FixMessageMatcher {
    private final MsgType expectedMsgType;

    public MsgTypeMatcher(final MsgType expectedMsgType) {
        this.expectedMsgType = expectedMsgType;
    }

    @Override
    public MatchResult getMatchResult(final FixMessage message) {
        if(message.isOfType(expectedMsgType)){
            return new BaseMatchResult(true, "Message is of type: " + expectedMsgType);
        } else {
            return new BaseMatchResult(false, "Message is NOT of type: " + expectedMsgType);
        }
    }

    @Override
    public String toString() {
        return "MsgTypeMatcher{" +
                "expectedMsgType=" + expectedMsgType +
                '}';
    }
}
