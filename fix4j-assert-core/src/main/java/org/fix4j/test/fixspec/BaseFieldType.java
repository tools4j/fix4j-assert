package org.fix4j.test.fixspec;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: ben
 * Date: 4/09/2014
 * Time: 4:42 PM
 */
public class BaseFieldType implements FieldType {
    private final String name;
    private final FieldClass fieldClass;
    private final Map<String, String> enumValues;
    private Tag<Integer> tag;

    public BaseFieldType(final String name, final int tag, final FieldClass fieldClass, final Map<String, String> enumValues) {
        this(name, BaseTag.create(tag), fieldClass, enumValues);
    }

    public BaseFieldType(final String name, final int tag, final FieldClass fieldClass, final String[] enumOrdinals, final String[] enumDescriptions) {
        this(name, BaseTag.create(tag), fieldClass, enumOrdinals, enumDescriptions);
    }

    public BaseFieldType(final String name, final Tag<Integer> tag, final FieldClass fieldClass, final Map<String, String> enumValues) {
        this.name = name;
        this.tag = tag;
        this.fieldClass = fieldClass;
        this.enumValues = enumValues;
    }

    public BaseFieldType(final String name, final Tag<Integer> tag, final FieldClass fieldClass, final String[] enumOrdinals, final String[] enumDescriptions) {
        this.name = name;
        this.tag = tag;
        this.fieldClass = fieldClass;
        this.enumValues = extractEnumValues(enumOrdinals, enumDescriptions);
    }

    public BaseFieldType(final String name, final int tag) {
        this.name = name;
        this.tag = new BaseTag<Integer>(tag);
        this.enumValues = new HashMap<String, String>();
        this.fieldClass = FieldClass.STRING;
    }

    public BaseFieldType(final String name, final int tag, final FieldClass fieldClass, final Class<? extends Enum<?>> enumClass) {
        if(!enumClass.isEnum()){
            throw new IllegalArgumentException("class must be an enum:" + enumClass);
        }
        final Map<String,String> enumValues = new LinkedHashMap<>();
        for(final Enum<?> enumValue: enumClass.getEnumConstants()){
            if(!(enumValue instanceof FieldTypeValueEnum)){
                throw new IllegalArgumentException("Enum must implement FieldTypeValueEnum:" + enumClass);
            }
            final FieldTypeValueEnum fieldTypeValueEnum = (FieldTypeValueEnum) enumValue;
            enumValues.put(fieldTypeValueEnum.getOrdinal(), enumValue.name());
        }
        this.name = name;
        this.tag = new BaseTag<>(tag);
        this.fieldClass = fieldClass;
        this.enumValues = enumValues;
    }

    private Map<String, String> extractEnumValues(final String[] enumOrdinals, final String[] enumDescriptions) {
        final Map<String, String> mutableEnumValues = new LinkedHashMap<String, String>();

        if((enumOrdinals == null) != (enumDescriptions == null)) {
            throw new IllegalArgumentException("Either both enumOrdinals and enumDescriptions must be given, or both must be not given.");

        } else if((enumOrdinals != null) && (enumOrdinals.length != enumDescriptions.length )){
            throw new IllegalArgumentException("Cannot create FieldType:" + name + " the number of enumOrdinals differs to the number of enumDescriptions.  enumOrdinals:" + enumOrdinals + " enumDescriptions:" + enumDescriptions);

        } else if(enumOrdinals != null) {
            for (int i = 0; i < enumOrdinals.length; i++) {
                mutableEnumValues.put(enumOrdinals[i], enumDescriptions[i]);
            }
        }
        return Collections.unmodifiableMap(mutableEnumValues);
    }

    @Override
    public Tag<Integer> getTag() {
        return tag;
    }

    @Override
    public String toPrettyString() {
        return "[" + name + "]" + tag;
    }

    @Override
    public boolean isNumInGroup() {
        return fieldClass == FieldClass.NUMINGROUP;
    }

    @Override
    public boolean isKnownValue(final String ordinal) {
        return enumValues.containsKey(ordinal);
    }

    @Override
    public String getDescriptionForKnownValue(final String ordinal, final String defaultIfNotKnown) {
        final String knownDescription =  enumValues.get(ordinal);
        return knownDescription != null ? knownDescription: defaultIfNotKnown;
    }

    @Override
    public String getDescriptionForKnownValue(final String ordinal) {
        return enumValues.get(ordinal);
    }

    @Override
    public FieldClass getFieldClass() {
        return fieldClass;
    }

    @Override
    public String formatValue(final String value) {
        if(value == null){
            return "null";
        }
        final String description = getDescriptionForKnownValue(value);
        if(description != null){
            return value + "[" + description + "]";
        } else {
            return value;
        }
    }

    @Override
    public Map<String, String> getEnumValues() {
        return enumValues;
    }

    @Override
    public MemberFieldType required(final boolean required) {
        return new MemberFieldType(this, required);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return toPrettyString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldType)) return false;
        final FieldType that = (FieldType) o;
        if (!tag.equals(that.getTag())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }
}
