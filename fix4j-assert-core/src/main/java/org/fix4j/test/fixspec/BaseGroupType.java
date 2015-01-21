package org.fix4j.test.fixspec;

import org.fix4j.test.util.Asserts;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.StringUtils;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * User: ben
 * Date: 28/08/2014
 * Time: 5:42 AM
 */
public class BaseGroupType extends BaseFieldAndGroupTypes implements GroupType {
    private final MemberFieldType noOfFieldType;
    private final MessageChildType firstFieldOfRepeatingGroup;

    public BaseGroupType(final MemberFieldType noOfFieldType, final List<MessageChildType> childTypes) {
        super(childTypes);
        Asserts.assertNotNull(noOfFieldType);
        Asserts.assertNotNull(childTypes);
        Asserts.assertFalse(childTypes.isEmpty());
        firstFieldOfRepeatingGroup = childTypes.get(0);
        this.noOfFieldType = noOfFieldType;
    }

    public BaseGroupType(final MemberFieldType noOfFieldType, final MessageChildType ... childTypes) {
        this(noOfFieldType, Arrays.asList(childTypes));
    }

    @Override
    public FieldType getNoOfFieldType() {
        return noOfFieldType;
    }

    @Override
    public GroupKey getGroupKey(final MsgType msgType) {
        return new GroupKey(msgType, this.noOfFieldType);
    }

    @Override
    public MessageChildType getFirstChildTypeOfRepeatingGroup() {
        return firstFieldOfRepeatingGroup;
    }

    @Override
    public String getName() {
        return noOfFieldType.getName();
    }

    @Override
    public Tag<Integer> getTag() {
        return getNoOfFieldType().getTag();
    }

    @Override
    public boolean isRequired() {
        return noOfFieldType.isRequired();
    }

    @Override
    public String toString() {
        return "BaseGroupType{" +
                "noOfFieldType=" + noOfFieldType +
                ", firstFieldOfRepeatingGroup=" + firstFieldOfRepeatingGroup +
                ", fieldTypes=" + super.getFieldTypes() +
                ", groupTypes=" + super.getGroupTypes() +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseGroupType)) return false;
        final BaseGroupType that = (BaseGroupType) o;
        if (!noOfFieldType.equals(that.noOfFieldType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return noOfFieldType.hashCode();
    }

    @Override
    public String toPrettyString() {
        return noOfFieldType.toPrettyString() + Consts.EOL + StringUtils.indentAllLines(super.toPrettyString());
    }

    @Override
    public Set<? extends FieldType> getAllFieldTypesRecursively() {
        final Set<FieldType> fieldTypes = new LinkedHashSet<FieldType>();
        fieldTypes.add(this.noOfFieldType);
        fieldTypes.addAll(super.getAllFieldTypesRecursively());
        return fieldTypes;
    }
}
