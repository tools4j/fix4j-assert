package org.fix4j.test.fixspec;


import org.omg.CORBA.UNKNOWN;

import java.util.Map;

/**
 * User: ben
 * Date: 25/08/2014
 * Time: 10:24 PM
 */
public interface FieldType extends MessageChildType {
    boolean isNumInGroup();
    boolean isKnownValue(final String ordinal);
    String getDescriptionForKnownValue(final String ordinal);
    String getDescriptionForKnownValue(final String ordinal, final String defaultIfNotFound);
    FieldClass getFieldClass();
    String formatValue(final String value);
    Tag<Integer> getTag();
    Map<String, String> getEnumValues();
    MemberFieldType required(boolean required);

    public static class Factory{
        private Factory() {}

        public static FieldType forCustomTag(final int tag){
            return new BaseFieldType("CUSTOM", tag);
        }
    }
}
