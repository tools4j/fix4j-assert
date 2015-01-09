package org.fix4j.test.fixspec;

import org.fix4j.test.util.Consts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User: ben
 * Date: 16/10/2014
 * Time: 9:22 PM
 */
public class BaseFieldAndGroupTypes implements FieldAndGroupTypes {
    private final Map<Integer, GroupType> groupTypes;
    private final Map<Integer, MemberFieldType> fieldTypes;
    private final List<Integer> fieldOrder;

    public BaseFieldAndGroupTypes(final MessageChildType ... childTypes) {
        this(Arrays.asList(childTypes));
    }

    public BaseFieldAndGroupTypes(final List<MessageChildType> childTypes) {
        final Map<Integer, MemberFieldType> fieldTypeMap = new LinkedHashMap<>();
        final Map<Integer, GroupType> groupTypeMap = new LinkedHashMap<>();
        final List<Integer> fieldOrder = new ArrayList<>();

        for (final MessageChildType childType : childTypes) {
            fieldOrder.add(childType.getTag().getValue());
            if(childType instanceof MemberFieldType){
                final MemberFieldType fieldType = (MemberFieldType) childType;
                fieldTypeMap.put(fieldType.getTag().getValue(), fieldType);
            } else if(childType instanceof GroupType){
                final GroupType groupType = (GroupType) childType;
                groupTypeMap.put(groupType.getTag().getValue(), groupType);
            } else {
                throw new IllegalArgumentException("Unknown type:" + childType);
            }
        }

        this.fieldOrder = Collections.unmodifiableList(fieldOrder);
        this.groupTypes = Collections.unmodifiableMap(groupTypeMap);
        this.fieldTypes = Collections.unmodifiableMap(fieldTypeMap);
    }

    @Override
    public List<MemberFieldType> getFieldTypes() {
        return new ArrayList<>(fieldTypes.values());
    }

    @Override
    public List<GroupType> getGroupTypes() {
        return new ArrayList<>(groupTypes.values());
    }

    @Override
    public MemberFieldType getFieldType(final int tag) {
        return getAllFieldTypesByTagRecursively().get(tag);
    }

    @Override
    public GroupType getGroupType(final int tag) {
        return getAllGroupTypesByTagRecursively().get(tag);
    }

    @Override
    public boolean containsChild(final FieldType type) {
        final Integer typeTag = type.getTag().getValue();
        return fieldTypes.containsKey(typeTag) || groupTypes.containsKey(typeTag);
    }

    @Override
    public boolean containsRecursively(final FieldType type) {
        return getAllFieldTypesRecursively().contains(type);
    }

    @Override
    public List<Integer> getFieldOrder() {
        return fieldOrder;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final MemberFieldType fieldType : fieldTypes.values()) {
            if(sb.length() > 0) sb.append(Consts.FIX_FIELD_DISPLAY_DELIM);
            sb.append(fieldType);
        }
        for (final GroupType groupType : groupTypes.values()) {
            if(sb.length() > 0) sb.append(Consts.FIX_FIELD_DISPLAY_DELIM);
            sb.append(groupType).append(Consts.FIX_FIELD_DISPLAY_DELIM);
        }
        return "{" + sb.toString() + "}";
    }

    @Override
    public String toPrettyString() {
        if(fieldTypes.isEmpty() && groupTypes.isEmpty()){
            return "<empty>" + Consts.EOL;
        }
        final StringBuilder sb = new StringBuilder();
        for (final MemberFieldType fieldType : fieldTypes.values()) {
            sb.append(fieldType.toPrettyString()).append(Consts.EOL);
        }
        for (final GroupType groupType : groupTypes.values()) {
            sb.append(groupType.toPrettyString()).append(Consts.EOL);
        }
        return sb.toString();
    }

    @Override
    public Set<MemberFieldType> getAllFieldTypesRecursively() {
        final Set<MemberFieldType> allFieldTypes = new LinkedHashSet<>(fieldTypes.values());
        for (final GroupType groupType : groupTypes.values()) {
            allFieldTypes.addAll(groupType.getAllFieldTypesRecursively());
        }
        return allFieldTypes;
    }

    @Override
    public Map<Integer, MemberFieldType> getAllFieldTypesByTagRecursively() {
        final Map<Integer, MemberFieldType> allFieldTypes = new LinkedHashMap<>(fieldTypes);
        for (final GroupType groupType : groupTypes.values()) {
            allFieldTypes.putAll(groupType.getAllFieldTypesByTagRecursively());
        }
        return allFieldTypes;
    }

    @Override
    public Set<GroupType> getAllGroupTypesRecursively() {
        final Set<GroupType> allGroupTypes = new LinkedHashSet<>(groupTypes.values());
        for (final GroupType groupType : groupTypes.values()) {
            allGroupTypes.addAll(groupType.getAllGroupTypesRecursively());
        }
        return allGroupTypes;
    }

    @Override
    public Map<Integer, GroupType> getAllGroupTypesByTagRecursively() {
        final Map<Integer, GroupType> allGroupTypes = new LinkedHashMap<>(groupTypes);
        for (final GroupType groupType : groupTypes.values()) {
            allGroupTypes.putAll(groupType.getAllGroupTypesByTagRecursively());
        }
        return allGroupTypes;
    }
}
