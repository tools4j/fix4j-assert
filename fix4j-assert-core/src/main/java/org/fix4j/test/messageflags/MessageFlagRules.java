package org.fix4j.test.messageflags;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FieldType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * User: ben
 * Date: 1/10/2014
 * Time: 6:10 AM
 */
public class MessageFlagRules {
    public static final MessageFlagRules EMPTY = new MessageFlagRules(new ArrayList<MessageFlagRule>(0));
    private final List<MessageFlagRule> messageFlagRules;

    public MessageFlagRules(final List<MessageFlagRule> messageFlagRules) {
        this.messageFlagRules = Collections.unmodifiableList(messageFlagRules);
    }

    public MessageFlags getFlagsForMessage(final FixMessage fixMessage){
        final List<MessageFlag> messageFlags = new ArrayList<>();
        for (final MessageFlagRule rule : messageFlagRules) {
            if(rule.isTriggered(fixMessage)){
                messageFlags.addAll(rule.getMessageFlags(fixMessage).getFlags());
            }
        }
        return new MessageFlags(fixMessage, messageFlags);
    }

    public static Collection<? extends MessageFlagRule> fieldsShouldNotBeSet(final String messagePostfix, final FieldType ... fieldTypes) {
        final List<MessageFlagRule> messageFlagRules = new ArrayList<>(fieldTypes.length);
        for (final FieldType fieldType : fieldTypes) {
            messageFlagRules.add(SimpleMessageFlagRule.forAnyValueOfField(fieldType, fieldType.toString() + ": " + messagePostfix));
        }
        return messageFlagRules;
    }
}
