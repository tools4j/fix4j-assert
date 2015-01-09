package org.fix4j.test.fixspec;

import org.fix4j.test.fixmodel.FixMessage;

/**
 * User: ben
 * Date: 28/08/2014
 * Time: 5:21 AM
 */
public interface FixSpecification {
    Integer MSG_TYPE_TAG_NUMBER = 35;
    FieldType getFieldTypeByTag(Tag<Integer> tag);
    FieldType getFieldTypeByTag(int tag);
    FieldAndGroupTypes getStandardHeaderType();
    FieldAndGroupTypes getStandardTrailerType();
    int getMsgTypeTagNumber();
    Tag<Integer> getMsgTypeTag();
    MsgType getMsgTypeByTag(Tag<String> tag);
    MsgType getMsgTypeByTag(String tagValue);
    GroupType getGroupTypeByKey(GroupKey groupKey);
    FieldType getFieldTypeByName(String fieldName);
    FieldType getMsgTypeFieldType();
    FixMessage parse(final String expression);
    MsgType getMsgTypeByName(String msgTypeName);
}
