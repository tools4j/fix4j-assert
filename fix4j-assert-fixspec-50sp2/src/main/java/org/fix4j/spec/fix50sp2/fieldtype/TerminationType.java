package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TerminationType extends BaseFieldType {
    public static final TerminationType INSTANCE = new TerminationType();

    private TerminationType() {
        super(
            "TerminationType",
            788,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FLEXIBLE = new Field(TerminationType.INSTANCE, Values.FLEXIBLE.getOrdinal());
        public final Field TERM = new Field(TerminationType.INSTANCE, Values.TERM.getOrdinal());
        public final Field OVERNIGHT = new Field(TerminationType.INSTANCE, Values.OVERNIGHT.getOrdinal());
        public final Field OPEN = new Field(TerminationType.INSTANCE, Values.OPEN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FLEXIBLE("3"),
        TERM("2"),
        OVERNIGHT("1"),
        OPEN("4");

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
