package org.fix4j.test.messageflags;

import org.fix4j.test.expression.MessageExpression;
import org.fix4j.test.expression.FlexibleMessageExpressionParser;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.matching.matchers.FixMessageMatcher;
import org.fix4j.test.matching.matchers.MsgTypeMatcher;

/**
 * User: ben
 * Date: 1/10/2014
 * Time: 6:04 AM
 */
public class SimpleMessageFlagRule implements MessageFlagRule {
    private final FixMessageMatcher matcher;
    private final String alert;

    public SimpleMessageFlagRule(final FixMessageMatcher matcher, final String alert) {
        this.matcher = matcher;
        this.alert = alert;
    }

    public SimpleMessageFlagRule(final MsgType msgType, final String alert) {
        this(new MsgTypeMatcher(msgType), alert);
    }

    public SimpleMessageFlagRule(final FixSpecification fixSpecification, final String expression, final String alert) {
        this(new FlexibleMessageExpressionParser(fixSpecification).parse(expression), alert);
    }

    @Override
    public boolean isTriggered(final FixMessage fixMessage){
        return matcher.getMatchResult(fixMessage).matches();
    }

    @Override
    public MessageFlags getMessageFlags(final FixMessage fixMessage){
        return MessageFlags.singleFlag(fixMessage, alert);
    }

    public static MessageFlagRule forAnyValueOfField(final FieldType fieldType, final String message) {
        return new SimpleMessageFlagRule(MessageExpression.forAnyValueOfField(fieldType), message);
    }
}
