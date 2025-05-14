package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DiscretionScope extends BaseFieldType {
    public static final DiscretionScope INSTANCE = new DiscretionScope();

    private DiscretionScope() {
        super(
            "DiscretionScope",
            846,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field GLOBAL = new Field(DiscretionScope.INSTANCE, Values.GLOBAL.getOrdinal());
        public final Field NATIONAL = new Field(DiscretionScope.INSTANCE, Values.NATIONAL.getOrdinal());
        public final Field LOCAL_EXCHANGE_ECN_ATS = new Field(DiscretionScope.INSTANCE, Values.LOCAL_EXCHANGE_ECN_ATS.getOrdinal());
        public final Field NATIONAL_EXCLUDING_LOCAL = new Field(DiscretionScope.INSTANCE, Values.NATIONAL_EXCLUDING_LOCAL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        GLOBAL("3"),
        NATIONAL("2"),
        LOCAL_EXCHANGE_ECN_ATS("1"),
        NATIONAL_EXCLUDING_LOCAL("4");

        private final String ordinal;

        private Values(final String ordinal) {
            this.ordinal = ordinal;
        }

        @Override
        public String getOrdinal() {
            return ordinal;
        }
    }
}
