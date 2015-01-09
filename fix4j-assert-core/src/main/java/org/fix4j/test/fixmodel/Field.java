package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.Tag;
import org.fix4j.test.util.Consts;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * User: ben
 * Date: 2/09/2014
 * Time: 4:51 PM
 */
public class Field implements FieldSource, Part, PrettyPrintable {
    private final FieldType fieldType;
    private final String value;

    public Field(final FieldType fieldType, final String value) {
        this.fieldType = fieldType;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Tag<Integer> getTag() {
        return fieldType.getTag();
    }

    @Override
    public FieldType getType() {
        return fieldType;
    }


    public FieldType getFieldType() {
        return fieldType;
    }

    public boolean isOfTag(final Tag tag){
        return this.fieldType.getTag().equals(tag);
    }

    @Override
    public String toString() {
        return toStringWithDescriptors();
    }

    public String toStringWithDescriptors() {
        return fieldType + "=" + getFormattedValue();
    }

    public String getFormattedValue() {
        return fieldType.formatValue(value);
    }

    public String toStringWithRawValues(){
        return fieldType.getTag().getValue() + "=" + value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Field)) return false;

        final Field that = (Field) o;

        if (!fieldType.getTag().equals(that.fieldType.getTag())) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fieldType.getTag().hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public List<Field> getAllFieldsRecursively() {
        return Collections.singletonList(this);
    }

    @Override
    public Map<String, Field> getFieldReferenceMap() {
        Map<String, Field> map = new LinkedHashMap<>();
        map.put(fieldType.getName(), this);
        map.put(""+fieldType.getTag().getValue(), this);
        return map;
    }

    @Override
    public String toPrettyString() {
        return toString() + Consts.EOL;
    }

    public boolean isOfType(final FieldType fieldType) {
        return this.fieldType.equals(fieldType);
    }

    public boolean isOfTag(final int tag) {
        return this.fieldType.getTag().getValue() == tag;
    }

    public void assertValueEquals(final String value) {
        if(!value.equals(this.value)){
            throw new AssertionError("Actual value '" + this.value + "' does not equal expected value '" + value + "'");
        }
    }

    public void assertValueContains(final String text) {
        if(!this.value.contains(text)){
            throw new AssertionError("Actual value '" + this.value + "' does not contain regex '" + value + "'");
        }
    }

    public void assertValueEquals(final double dbl) {
        if(!this.value.equals(String.valueOf(dbl))){
            throw new AssertionError("Actual value '" + this.value + "' does not equal '" + dbl + "'");
        }
    }

    public boolean matchesValueOf(final Field actual) {
        //If both values are null or zero length
        if((this.getValue() == null || this.getValue().length() == 0) && (actual.getValue() == null || actual.getValue().length() == 0)){
            return true;

        //If only one of the values is null or zero length
        } else if((this.getValue() == null || this.getValue().length() == 0) || (actual.getValue() == null || actual.getValue().length() == 0)){
            return false;

        //Otherwise check actual value
        } else {
            return this.getValue().equals(actual.getValue());
        }
    }
}
