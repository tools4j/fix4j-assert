package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.fixspec.GroupKey;
import org.fix4j.test.fixspec.GroupType;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.util.Asserts;
import org.fix4j.test.util.PeekableIterator;

import java.util.Collection;

/**
 * User: ben
 * Date: 17/10/2014
 * Time: 7:39 PM
 */
public class BaseFixMessageBuilder {
    private final FixSpecification fixSpecification;
    private MsgType msgType;
    private FieldsAndGroupsBuilder body = new FieldsAndGroupsBuilder();
    private FieldsAndGroupsBuilder header = new FieldsAndGroupsBuilder();
    private FieldsAndGroupsBuilder trailer = new FieldsAndGroupsBuilder();

    public BaseFixMessageBuilder(final FixSpecification fixSpecification){
        this.fixSpecification = fixSpecification;
    }

    public BaseFixMessageBuilder withFields(final Collection<Field> fields){
        try {
            msgType = lookForMsgTypeInFields(fields);
            final PeekableIterator<Field> iterator = new PeekableIterator<>(fields);

            while (iterator.hasNext()) {
                addNextFieldOrGroupToBuilder(iterator);
            }
            return this;
        } catch(Exception e){
            throw new IllegalArgumentException("Could not build message for fields:" + fields, e);
        }
    }

    public FieldsAndGroupsBuilder getCurrentBuilder(final FieldType nextFieldType) {
        if (fixSpecification.getStandardHeaderType().containsRecursively(nextFieldType)) {
            return header;
        } else if (fixSpecification.getStandardTrailerType().containsRecursively(nextFieldType)) {
            return trailer;
        } else {
            return body;
        }
    }

    public void addNextFieldOrGroupToBuilder(final PeekableIterator<Field> iterator) {
        final FieldsAndGroupsBuilder currentBuilder = getCurrentBuilder(iterator.peek().getFieldType());
        if (iterator.peek().getFieldType().isNumInGroup()) {
            currentBuilder.withGroup(buildGroup(iterator));
        } else {
            currentBuilder.withField(iterator.next());
        }
    }

    public void addNextGroupMemberToBuilder(final FieldsAndGroupsBuilder currentBuilder, final PeekableIterator<Field> iterator) {
        if (iterator.peek().getFieldType().isNumInGroup()) {
            currentBuilder.withGroup(buildGroup(iterator));
        } else {
            currentBuilder.withField(iterator.next());
        }
    }

    private MsgType lookForMsgTypeInFields(final Collection<Field> fields){
        for(final Field field: fields){
            if(field.getTag().equals(fixSpecification.getMsgTypeTag())){
                final MsgType msgTypeByTag = fixSpecification.getMsgTypeByTag(field.getValue());
                if(msgTypeByTag == null){
                    throw new IllegalArgumentException("Could not find msgType for tag:" + field.getValue() + " in fix specification.");
                }
                return msgTypeByTag;
            }
        }
        throw new IllegalArgumentException("MsgType[tag=" + fixSpecification.getMsgTypeTagNumber() + "] not found.  This field is mandatory when defining a message.  Fields provided:" + fields);
    }

    private Group buildGroup(final PeekableIterator<Field> iterator){
        Asserts.assertNotNull(msgType);
        final Field noOfField = iterator.next();
        Asserts.assertTrue(noOfField.getFieldType().isNumInGroup());
        final GroupKey groupKey = new GroupKey(msgType, noOfField.getFieldType());
        final GroupType groupType = fixSpecification.getGroupTypeByKey(groupKey);
        Asserts.assertNotNull("Group type not found with group key: " + groupKey, groupType);
        final GroupBuilder groupBuilder = new GroupBuilder();
        groupBuilder.withNoOfField(noOfField);
        groupBuilder.withGroupType(groupType);

        while(iterator.hasNext() && iterator.peek().getFieldType().equals(groupType.getFirstChildTypeOfRepeatingGroup())){
            groupBuilder.withRepeat(buildGroupRepeat(groupType, iterator));
        }
        return groupBuilder.build();
    }

    private FieldsAndGroups buildGroupRepeat(final GroupType groupType, final PeekableIterator<Field> iterator) {
        final FieldsAndGroupsBuilder groupRepeatBuilder = new FieldsAndGroupsBuilder();
        final Field firstChildOfRepeatingGroup = iterator.next();
        Asserts.assertEquals(firstChildOfRepeatingGroup.getFieldType(), groupType.getFirstChildTypeOfRepeatingGroup());
        groupRepeatBuilder.withField(firstChildOfRepeatingGroup);

        //While, there is at least one more element
        while(iterator.hasNext()
              //and that element is not the start of the next repeat
              && !iterator.peek().getFieldType().equals(groupType.getFirstChildTypeOfRepeatingGroup())
              //and that element is still part of this group (could have reached the end of the group)
              && groupType.containsChild(iterator.peek().getFieldType())){

            //Then add the field or group
            addNextGroupMemberToBuilder(groupRepeatBuilder, iterator);
        }
        return groupRepeatBuilder.build();
    }

    public BaseFixMessage build(){
        Asserts.assertNotNull(msgType);
        final FieldsAndGroups header = this.header.build();
        final FieldsAndGroups trailer = this.trailer.build();
        final FieldsAndGroups body = this.body.build();
        return new BaseFixMessage(fixSpecification.getMsgTypeByTag(msgType.getTag()), header, body, trailer);
    }
}
