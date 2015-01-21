package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.GroupType;
import org.fix4j.test.util.Consts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: ben
 * Date: 16/10/2014
 * Time: 9:22 PM
 */
public class BaseFieldsAndGroups implements FieldsAndGroups {
    private final Map<Integer, Group> groups;
    private final Map<Integer, Field> fields;

    private BaseFieldsAndGroups(final Map<Integer, Field> fields, final Map<Integer, Group> groups) {
        this.fields = Collections.unmodifiableMap(fields);
        this.groups = Collections.unmodifiableMap(groups);
    }

    public BaseFieldsAndGroups(final List<Field> fields, final List<Group> groups) {
        final Map<Integer, Field> fieldMap = new LinkedHashMap<>(fields.size());
        for (final Field field : fields) {
            fieldMap.put(field.getTag().getValue(), field);
        }

        final Map<Integer, Group> groupMap = new LinkedHashMap<>(groups.size());
        for (final Group group : groups) {
            groupMap.put(group.getTag().getValue(), group);
        }
        
        this.groups = Collections.unmodifiableMap(groupMap);
        this.fields = Collections.unmodifiableMap(fieldMap);
    }

    @Override
    public List<Field> getFields() {
        return new ArrayList<>(fields.values());
    }

    @Override
    public List<Group> getGroups() {
        return new ArrayList<>(groups.values());
    }

    @Override
    public Field getField(final FieldType fieldType) {
        return fields.get(fieldType.getTag().getValue());
    }

    @Override
    public Group getGroup(final GroupType groupType) {
        return groups.get(groupType.getTag().getValue());
    }

    @Override
    public Field getField(final int tag) {
        return fields.get(tag);
    }

    @Override
    public FieldsAndGroups withField(final Field field) {
        final Map<Integer, Group> newGroups = new LinkedHashMap<>(groups);
        final Map<Integer, Field> newFields = new LinkedHashMap<>(fields);
        newFields.put(field.getTag().getValue(), field);
        return new BaseFieldsAndGroups(newFields, newGroups);
    }

    @Override
    public List<Field> getAllFieldsRecursively() {
        final List<Field> allFields = new ArrayList<>();
        for (final Field field : getFields()) {
            allFields.add(field);
        }
        for (final Group group : getGroups()) {
            allFields.addAll(group.getAllFieldsRecursively());
        }
        return allFields;
    }

    @Override
    public Map<String, Field> getFieldReferenceMap() {
        final Map<String, Field> map = new LinkedHashMap<>();
        for (final Field field : fields.values()) {
            map.putAll(field.getFieldReferenceMap());
        }
        for (final Group group : groups.values()) {
            map.putAll(group.getFieldReferenceMap());
        }
        return map;
    }

    @Override
    public String toString() {
        return "BaseFieldsAndGroups{" +
                "groups=" + groups +
                ", fields=" + fields +
                '}';
    }

    @Override
    public String toPrettyString() {
        if(fields.isEmpty() && groups.isEmpty()){
            return "<empty>" + Consts.EOL;
        }

        final StringBuilder sb = new StringBuilder();
        for (final Field field : fields.values()) {
            sb.append(field.toPrettyString());
        }
        for (final Group group : groups.values()) {
            sb.append(group.toPrettyString());
        }
        return sb.toString();
    }
}
