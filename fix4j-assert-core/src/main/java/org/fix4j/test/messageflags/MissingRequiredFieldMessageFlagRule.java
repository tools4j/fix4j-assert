package org.fix4j.test.messageflags;

import org.fix4j.test.fixmodel.FieldsAndGroups;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.Group;
import org.fix4j.test.fixspec.FieldAndGroupTypes;
import org.fix4j.test.fixspec.GroupType;
import org.fix4j.test.fixspec.MemberFieldType;
import org.fix4j.test.matching.matchers.MatchEveryMessageMatcher;
import org.fix4j.test.matching.matchers.FixMessageMatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ben
 * Date: 1/10/2014
 * Time: 6:04 AM
 */
public class MissingRequiredFieldMessageFlagRule implements MessageFlagRule {
    private final FixMessageMatcher matcher;

    public MissingRequiredFieldMessageFlagRule() {
        matcher = new MatchEveryMessageMatcher();
    }

    @Override
    public boolean isTriggered(final FixMessage fixMessage){
        return matcher.getMatchResult(fixMessage).matches();
    }

    @Override
    public MessageFlags getMessageFlags(final FixMessage fixMessage){
        final List<String> messageFlagStrings = new ArrayList<>();
        messageFlagStrings.addAll(getMissingRequiredFields(fixMessage.getTypeOfMessage(), fixMessage.getBody()));

        final List<MessageFlag> messageFlags = new ArrayList<>();
        for (final String messageFlagStr : messageFlagStrings) {
            messageFlags.add(new MessageFlag(fixMessage, messageFlagStr));
        }
        return new MessageFlags(fixMessage, messageFlags);
    }

    private List<String> getMissingRequiredFields(final FieldAndGroupTypes fieldAndGroupTypes, final FieldsAndGroups fieldAndGroupValues){
        final List<String> messageFlags = new ArrayList<>();
        for (final MemberFieldType fieldType : fieldAndGroupTypes.getFieldTypes()) {
            if(fieldType.isRequired()){
                if(fieldAndGroupValues.getField(fieldType) == null){
                    messageFlags.add("Required field not found: " + fieldType.toPrettyString());
                }
            }
        }
        for (final GroupType groupType : fieldAndGroupTypes.getGroupTypes()) {
            if(groupType.isRequired()){
                final Group group = fieldAndGroupValues.getGroup(groupType);
                if(group == null){
                    messageFlags.add("Required group not found: " + groupType.getNoOfFieldType().toPrettyString());
                } else {
                    for (final FieldsAndGroups fieldsAndGroups : group.getRepeats()) {
                        messageFlags.addAll(getMissingRequiredFields(groupType, fieldsAndGroups));
                    }
                }
            }
        }
        return messageFlags;
    }
}
