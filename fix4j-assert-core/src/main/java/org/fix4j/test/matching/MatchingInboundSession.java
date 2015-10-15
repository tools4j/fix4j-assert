package org.fix4j.test.matching;

import org.fix4j.test.expression.FlexibleMessageExpressionParser;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.matching.matchactivity.DiscardUntilFirstMatchThenRunSecondMatchProcessor;
import org.fix4j.test.matching.matchactivity.DiscardUntilMatchProcessor;
import org.fix4j.test.matching.matchactivity.MatchActivity;
import org.fix4j.test.matching.matchactivity.MatchActivityMessageProcessor;
import org.fix4j.test.matching.matchactivity.MatchActivityResult;
import org.fix4j.test.matching.matchactivity.MustMatchFirstMessage;
import org.fix4j.test.matching.matchers.FixMessageMatcher;
import org.fix4j.test.matching.matchers.MsgTypeMatcher;
import org.fix4j.test.plumbing.Supplier;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.properties.PropertyKeysAndDefaultValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 14/08/2014
 * Time: 9:33 AM
 */
public class MatchingInboundSession {
    private final static Logger LOGGER = LoggerFactory.getLogger(MatchingInboundSession.class);
    private final Supplier<FixMessage> messages;
    private final FlexibleMessageExpressionParser matcherParser;

    public MatchingInboundSession(final FixSpecification fixSpecification, final Supplier<FixMessage> messages) {
        this.messages = messages;
        this.matcherParser = new FlexibleMessageExpressionParser(fixSpecification);
    }

    /**
     * This method will check the first message in the queue to see if it matches
     * the expression.  (If the queue is empty, then it will wait until a message arrives).
     *
     * If that message does not match, then a failure will be thrown.  The type
     * of failure depends on the test framework being used.
     */
    public synchronized MatchActivityResult expect(final String expression){
        final FixMessageMatcher fixMessageMatcher = matcherParser.parse(expression);
        return getMatchActivity(new MustMatchFirstMessage(fixMessageMatcher)).run();
    }

    /**
     * This method will check the first message in the queue to see if it is of the
     * given message type.  (If the queue is empty, then it will wait until a message arrives).
     *
     * If that message does not match, then a failure will be thrown.  The type
     * of failure depends on the test framework being used.
     */
    public synchronized MatchActivityResult expect(final MsgType msgType) {
        final FixMessageMatcher fixMessageMatcher = new MsgTypeMatcher(msgType);
        return getMatchActivity(new MustMatchFirstMessage(fixMessageMatcher)).run();
    }


    /**
     * This method will check messages in the queue, until it either finds one that matches
     * the given expression, or, a timeout occurs (whichever occurs first).
     *
     * Any messages examined which do not match are discarded.
     */
    public synchronized MatchActivityResult discardUntilExpected(final String expression){
        final FixMessageMatcher fixMessageMatcher = matcherParser.parse(expression);
        return getMatchActivity(new DiscardUntilMatchProcessor(fixMessageMatcher)).run();
    }

    /**
     * This method will check messages in the queue, until it finds one that matches the given message type.
     *
     * --If no message of the given type is received before the timeout expires, then a failure will occur
     * --If a message of the given type is received, but it does not match the given expression, then a failure will occur
     * --If a message of the given type is received, and it matches the given expression, NO failure will occur
     */
    public synchronized MatchActivityResult discardUntilTypeOfMsgReceived(final MsgType expectedMessageType, final String expression){
        final FixMessageMatcher fixMessageMatcher = matcherParser.parse(expression);
        return getMatchActivity(new DiscardUntilFirstMatchThenRunSecondMatchProcessor(new MsgTypeMatcher(expectedMessageType), fixMessageMatcher)).run();
    }

    /**
     * This method will check messages in the queue, until it finds one that matches the given message type.
     *
     * --If no message of the given type is NOT found during the timeout period then a failure will occur.
     * --If a message IS found of the given type, then it is returned.
     */
    public synchronized MatchActivityResult discardUntilTypeOfMessageReceived(final MsgType expectedMessageType){
        return getMatchActivity(new DiscardUntilMatchProcessor(new MsgTypeMatcher(expectedMessageType))).run();
    }

    private MatchActivity getMatchActivity(final MatchActivityMessageProcessor messageProcessor){
        return new MatchActivity(messages, messageProcessor);
    }

    public FixMessage getNextMessage() {
        return messages.get(ApplicationProperties.Singleton.instance().getAsLong(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS.getKey()));
    }

    public FixMessage getNextMessage(final long waitTimeoutInMs) {
        return messages.get(waitTimeoutInMs);
    }
}
