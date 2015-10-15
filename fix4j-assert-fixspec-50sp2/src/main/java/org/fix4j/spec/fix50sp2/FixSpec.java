package org.fix4j.spec.fix50sp2;

import org.fix4j.test.expression.RawFixMessageExpressionParser;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.BaseTag;
import org.fix4j.test.fixspec.FieldAndGroupTypes;
import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.fixspec.GroupKey;
import org.fix4j.test.fixspec.GroupType;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.fixspec.Tag;
import org.fix4j.test.expression.FlexibleMessageExpressionParser;

public class FixSpec implements FixSpecification {
    public static final FixSpec INSTANCE = new FixSpec();

    private FixSpec() {}

    @Override
    public FieldType getFieldTypeByTag(final Tag<Integer> tag) {
        return FieldTypes.getFieldTypeByTag(tag.getValue());
    }

    @Override
    public FieldType getFieldTypeByTag(final int tag) {
        return FieldTypes.getFieldTypeByTag(tag);
    }

    @Override
    public FieldAndGroupTypes getStandardHeaderType() {
        return new StandardHeader();
    }

    @Override
    public FieldAndGroupTypes getStandardTrailerType() {
        return new StandardTrailer();
    }

    @Override
    public int getMsgTypeTagNumber() {
        return MSG_TYPE_TAG_NUMBER;
    }

    @Override
    public Tag<Integer> getMsgTypeTag() {
        return FieldTypes.MsgType.getTag();
    }

    @Override
    public MsgType getMsgTypeByTag(final Tag<String> tag) {
        return MsgTypes.getMsgTypeByTag(tag);
    }

    @Override
    public MsgType getMsgTypeByTag(final String tagValue) {
        return MsgTypes.getMsgTypeByTag(new BaseTag<String>(tagValue));
    }

    @Override
    public GroupType getGroupTypeByKey(final GroupKey groupKey) {
        GroupType groupTypeByKey = MsgTypes.getGroupTypeByKey(groupKey);
        if(groupTypeByKey != null){
            return groupTypeByKey;
        }

        groupTypeByKey = getStandardHeaderType().getGroupType(groupKey.getNoOfFieldType().getTag().getValue());
        if(groupTypeByKey != null){
            return groupTypeByKey;
        }

        groupTypeByKey = getStandardTrailerType().getGroupType(groupKey.getNoOfFieldType().getTag().getValue());
        if(groupTypeByKey != null){
            return groupTypeByKey;
        }

        return null;
    }

    @Override
    public FieldType getFieldTypeByName(final String fieldName) {
        try {
            return FieldTypes.getFieldTypeByName(fieldName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown field type: '" + fieldName + "'. If you wish to use a tag not in this specification, then please create a custom field using FieldType.Factory.forCustomTag(int).");
        }
    }

    @Override
    public FieldType getMsgTypeFieldType() {
        return FieldTypes.MsgType;
    }

    @Override
    public FixMessage parse(final String expression) {
        return (new FlexibleMessageExpressionParser(this)).parse(expression).asMessage(this);
    }

    @Override
    public FixMessage parseRawFix(final String expression) {
        return (new RawFixMessageExpressionParser(this)).parse(expression).asMessage(this);
    }

    @Override
    public MsgType getMsgTypeByName(final String msgTypeName) {
        return MsgTypes.getMsgTypeByName(msgTypeName);
    }
}
