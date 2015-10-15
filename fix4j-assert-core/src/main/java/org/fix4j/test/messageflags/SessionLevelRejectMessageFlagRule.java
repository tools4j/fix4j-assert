package org.fix4j.test.messageflags;

import org.fix4j.test.expression.FlexibleMessageExpressionParser;
import org.fix4j.test.fixmodel.Field;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.matching.matchers.FixMessageMatcher;
import org.fix4j.test.util.Consts;

/**
 * User: ben
 * Date: 1/10/2014
 * Time: 6:04 AM
 */
public class SessionLevelRejectMessageFlagRule implements MessageFlagRule {
    private final FixMessageMatcher matcher;
    private final FixSpecification fixSpecification;

    public SessionLevelRejectMessageFlagRule(final FixSpecification fixSpecification) {
        this.fixSpecification = fixSpecification;
        final FlexibleMessageExpressionParser messageExpressionParser = new FlexibleMessageExpressionParser(fixSpecification);
        matcher = messageExpressionParser.parse("35=3");// "Session level reject
    }

    @Override
    public boolean isTriggered(final FixMessage fixMessage){
        return matcher.getMatchResult(fixMessage).matches();
    }

    @Override
    public MessageFlags getMessageFlags(final FixMessage fixMessage){
        final Field sessionRejectReason = fixMessage.getBody().getField(fixSpecification.getFieldTypeByName("SessionRejectReason"));
        final Field text = fixMessage.getBody().getField(fixSpecification.getFieldTypeByName("Text"));
        final Field refTagId = fixMessage.getBody().getField(fixSpecification.getFieldTypeByName("RefTagID"));
        String refTagName;
        if(refTagId != null){
            try {
                int refTagIdInt = Integer.valueOf(refTagId.getValue());
                refTagName = fixSpecification.getFieldTypeByTag(refTagIdInt).getName();
            } catch(NumberFormatException e){
                refTagName = null;
            }
        } else {
            refTagName = null;
        }

        String message = "Session level reject::";
        message += (sessionRejectReason != null ? sessionRejectReason.toStringWithDescriptors() + "::": "");
        message += (text != null ? text.toStringWithDescriptors(): "");
        if(refTagId != null){
            message += refTagId.toStringWithDescriptors();
            if(refTagName != null){
                message += "[" + refTagName + "]";
            }
            message += "::";
        }
        message += Consts.EOL;
        message += fixMessage.toPrettyString();

        return MessageFlags.singleFlag(fixMessage, message);
    }
}
