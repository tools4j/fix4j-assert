package org.fix4j.test.fixspec;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User: ben
 * Date: 29/08/2014
 * Time: 4:50 PM
 */
public class BaseMsgType implements MsgType {
    private final String name;
    private final String messageCategory;
    private Tag<String> tag;
    private final FieldAndGroupTypes fieldAndGroupTypes;

    public BaseMsgType(final String name, final String abbreviation, String messageCategory, MessageChildType ... messageChildTypes) {
        this.tag = new BaseTag<>(abbreviation);
        this.name = name;
        this.messageCategory = messageCategory;
        this.fieldAndGroupTypes = new BaseFieldAndGroupTypes(Arrays.asList(messageChildTypes));
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public List<MemberFieldType> getFieldTypes() {
        return fieldAndGroupTypes.getFieldTypes();
    }

    @Override
    public List<GroupType> getGroupTypes() {
        return fieldAndGroupTypes.getGroupTypes();
    }

    @Override
    public GroupType getGroupType(final int tag) {
        return fieldAndGroupTypes.getGroupType(tag);
    }

    @Override
    public Tag<String> getTag() {
        return tag;
    }

    @Override
    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("******************************************************").append(Consts.EOL);
        sb.append(this.name).append(Consts.EOL);
        sb.append("******************************************************").append(Consts.EOL);
        sb.append(StringUtils.indentAllLines(fieldAndGroupTypes.toPrettyString()));
        return sb.toString();
    }

    @Override
    public boolean containsChild(final FieldType type) {
        return fieldAndGroupTypes.containsChild(type);
    }

    @Override
    public boolean containsRecursively(final FieldType type) {
        return getAllFieldTypesRecursively().contains(type);
    }

    @Override
    public List<Integer> getFieldOrder() {
        return fieldAndGroupTypes.getFieldOrder();
    }

    @Override
    public FixMessage generateExampleMessage(final FixSpecification fixSpecification) {
        return (new MessageExampleGenerator()).generateExampleMessage(fixSpecification, this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof MsgType)) return false;
        final MsgType that = (MsgType) o;
        if (!tag.equals(that.getTag())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }

    @Override
    public String toString() {
        return tag + "[" + name + "]";
    }

    @Override
    public Set<? extends FieldType> getAllFieldTypesRecursively() {
        return fieldAndGroupTypes.getAllFieldTypesRecursively();
    }

    @Override
    public Map<Integer, MemberFieldType> getAllFieldTypesByTagRecursively() {
        return fieldAndGroupTypes.getAllFieldTypesByTagRecursively();
    }

    @Override
    public Set<GroupType> getAllGroupTypesRecursively() {
        return fieldAndGroupTypes.getAllGroupTypesRecursively();
    }

    @Override
    public Map<Integer, GroupType> getAllGroupTypesByTagRecursively() {
        return fieldAndGroupTypes.getAllGroupTypesByTagRecursively();
    }
}
