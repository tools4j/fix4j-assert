package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.GroupType;
import org.fix4j.test.fixspec.Tag;
import org.fix4j.test.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * User: ben
 * Date: 25/09/2014
 * Time: 5:16 PM
 */
public class BaseGroup implements Group {
    private final GroupType groupType;
    private final Field noOfField;
    private final List<FieldsAndGroups> repeats;

    public BaseGroup(final GroupType groupType, final Field noOfField, final List<FieldsAndGroups> repeats) {
        this.groupType = groupType;
        this.noOfField = noOfField;
        this.repeats = repeats;
    }

    public Tag<Integer> getTag() {
        return noOfField.getTag();
    }

    @Override
    public GroupType getType() {
        return groupType;
    }

    @Override
    public Field getNoOfField() {
        return noOfField;
    }

    @Override
    public List<FieldsAndGroups> getRepeats() {
        return repeats;
    }

    @Override
    public List<Field> getAllFieldsRecursively() {
        final List<Field> fields = new ArrayList<>();
        fields.add(noOfField);
        for (final FieldsAndGroups repeat : repeats) {
            fields.addAll(repeat.getAllFieldsRecursively());
        }
        return fields;
    }

    @Override
    public Map<String, Field> getFieldReferenceMap() {
        final Map<String, Field> map = new LinkedHashMap<>();
        int i=0;
        map.putAll(noOfField.getFieldReferenceMap());
        for (final FieldsAndGroups repeat : repeats) {
            map.putAll(StringUtils.prefixAllKeysWith(noOfField.getType().getName() + "[" + i + "].", repeat.getFieldReferenceMap()));
            map.putAll(StringUtils.prefixAllKeysWith(noOfField.getType().getTag().getValue() + "[" + i + "].", repeat.getFieldReferenceMap()));
            i++;
        }
        return map;
    }

    @Override
    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(noOfField.toPrettyString());
        int i=1;
        for (final FieldsAndGroups repeat : repeats) {
            sb.append(StringUtils.indentAllLinesWithFirstLinesIndentEndingIn("" + i++ + ".", repeat.toPrettyString()));
        }
        return sb.toString();
    }
}
