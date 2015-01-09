package org.fix4j.test.fixspec;

import java.util.Map;

/**
 * User: ben
 * Date: 12/11/2014
 * Time: 5:12 PM
 */
public class MemberFieldType implements FieldType {
    private final boolean required;
    private final FieldType fieldType;

    public MemberFieldType(final FieldType fieldType, final boolean required) {
        this.required = required;
        this.fieldType = fieldType;
    }

    public boolean isRequired() {
        return required;
    }

    public Tag<Integer> getTag() {
        return fieldType.getTag();
    }

    public String toPrettyString() {
        return fieldType.toPrettyString();
    }

    public boolean isNumInGroup() {
        return fieldType.isNumInGroup();
    }

    public boolean isKnownValue(final String ordinal) {
        return fieldType.isKnownValue(ordinal);
    }

    public String getDescriptionForKnownValue(final String ordinal, final String defaultIfNotKnown) {
        return fieldType.getDescriptionForKnownValue(ordinal, defaultIfNotKnown);
    }

    public String getDescriptionForKnownValue(final String ordinal) {
        return fieldType.getDescriptionForKnownValue(ordinal);
    }

    public FieldClass getFieldClass() {
        return fieldType.getFieldClass();
    }

    public String formatValue(final String value) {
        return fieldType.formatValue(value);
    }

    public Map<String, String> getEnumValues() {
        return fieldType.getEnumValues();
    }

    @Override
    public MemberFieldType required(final boolean required) {
        throw new UnsupportedOperationException("Already a MemberFieldType!  A MemberFieldType is effectively a wrapper of a FieldType with an added 'required' field.  (The same goes for GroupType to GroupType).  Therefore you should not be wrapping a wrapper!  Please only call this on a descendent of FieldType which is NOT already a MemberFieldType.");
    }

    public String getName() {
        return fieldType.getName();
    }

    public String toString() {
        return fieldType.toString();
    }

    public boolean equals(final Object o) {
        return fieldType.equals(o);
    }

    public int hashCode() {
        return fieldType.hashCode();
    }
}
