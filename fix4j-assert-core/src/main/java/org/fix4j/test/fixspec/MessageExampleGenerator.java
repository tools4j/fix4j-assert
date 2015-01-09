package org.fix4j.test.fixspec;

import org.fix4j.test.fixmodel.BaseFieldsAndGroups;
import org.fix4j.test.fixmodel.BaseFixMessage;
import org.fix4j.test.fixmodel.BaseGroup;
import org.fix4j.test.fixmodel.Field;
import org.fix4j.test.fixmodel.FieldsAndGroups;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.Group;
import org.fix4j.test.util.Consts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * A very rough-and-ready generator of example messages.
 *
 * It creates a message with example field values (see FieldClass.java).  It generates a fixed number of repeats per
 * group according to Consts#DEFAULT_NUM_OF_GROUP_REPEATS_IN_EXAMPLE_GENERATOR
 *
 * The only field at the moment, which does not contain an arbitrary value is the MsgType field which has been overridden
 * to contain the msgType requested in the method.
 *
 * This generator has MANY shortcomings, and is not meant to generate usable messages.  The intent is more to give the
 * user an example of what the structure of the message might look like.  E.g.:
 *  --BeingString should contain a fix protocol version.
 *  --BodyLength should contain the actual body length (not a hard coded number).
 *  --CheckSum should be a valid checksum (not a hard coded number).
 *  --etc etc etc
 *
 *  If you want more accuracy in any of these standard fields, feel free to override them like I have for
 *  msgType field below.
 */
public class MessageExampleGenerator {

    public FixMessage generateExampleMessage(final FixSpecification fixSpecification, final MsgType msgType){
        return generateExampleMessage(fixSpecification, msgType.getTag().getValue());
    }

    public FixMessage generateExampleMessage(final FixSpecification fixSpecification, final String msgTypeTag){
        final MsgType msgType = fixSpecification.getMsgTypeByTag(msgTypeTag);
        final FieldsAndGroups header = generateExampleGroupsAndFields(fixSpecification.getStandardHeaderType());
        final FieldsAndGroups body = generateExampleGroupsAndFields(msgType);
        final FieldsAndGroups trailer = generateExampleGroupsAndFields(fixSpecification.getStandardTrailerType());

        //We have to make one change.  At the moment, the header contains an "example" message type.  We need to override this
        final FieldsAndGroups headerWithSubsitutedMsgType = header.withField(new Field(fixSpecification.getMsgTypeFieldType(), msgTypeTag));

        return new BaseFixMessage(msgType, headerWithSubsitutedMsgType, body, trailer);
    }

    private List<Field> generateExampleFields(final Collection<MemberFieldType> fieldTypes) {
        final List<Field> fields = new ArrayList<>();
        for (final MemberFieldType fieldType : fieldTypes) {
            if(fieldType.isRequired()) {
                fields.add(generateExampleField(fieldType));
            }
        }
        return fields;
    }

    private Field generateExampleField(final FieldType fieldType) {
        final String fieldValue;
        final Map<String, String> fieldTypeEnumValues = fieldType.getEnumValues();
        if(fieldTypeEnumValues != null && fieldTypeEnumValues.size() > 0){
            fieldValue = fieldTypeEnumValues.keySet().iterator().next();
        } else {
            fieldValue = fieldType.getFieldClass().getExampleValue();
        }
        return new Field(fieldType, fieldValue);
    }

    private List<Group> generateExampleGroups(final Collection<GroupType> groupTypes) {
        final List<Group> groups = new ArrayList<>();
        for (final GroupType groupType : groupTypes) {
            if(groupType.isRequired()) {
                groups.add(generateExampleGroup(groupType));
            }
        }
        return groups;
    }

    private Group generateExampleGroup(final GroupType groupType){
        final Field noOfField = new Field(groupType.getNoOfFieldType(), ""+Consts.DEFAULT_NUM_OF_GROUP_REPEATS_IN_EXAMPLE_GENERATOR);

        //Generate repeats
        final List<FieldsAndGroups> repeats = new ArrayList<>(Consts.DEFAULT_NUM_OF_GROUP_REPEATS_IN_EXAMPLE_GENERATOR);
        for(int i=0; i<Consts.DEFAULT_NUM_OF_GROUP_REPEATS_IN_EXAMPLE_GENERATOR; i++){
            repeats.add(generateExampleGroupsAndFields(groupType));
        }
        return new BaseGroup(groupType, noOfField, repeats);
    }

    private BaseFieldsAndGroups generateExampleGroupsAndFields(final FieldAndGroupTypes fieldAndGroupTypes) {
        return new BaseFieldsAndGroups(generateExampleFields(fieldAndGroupTypes.getFieldTypes()), generateExampleGroups(fieldAndGroupTypes.getGroupTypes()));
    }
}
