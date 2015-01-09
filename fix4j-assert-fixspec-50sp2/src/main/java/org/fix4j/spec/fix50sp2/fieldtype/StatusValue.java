package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StatusValue extends BaseFieldType {
    public static final StatusValue INSTANCE = new StatusValue();

    private StatusValue() {
        super(
            "StatusValue",
            928,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NOT_CONNECTED__DOWN_EXPECTED_DOWN = new Field(StatusValue.INSTANCE, Values.NOT_CONNECTED__DOWN_EXPECTED_DOWN.getOrdinal());
        public final Field NOT_CONNECTED__DOWN_EXPECTED_UP = new Field(StatusValue.INSTANCE, Values.NOT_CONNECTED__DOWN_EXPECTED_UP.getOrdinal());
        public final Field CONNECTED = new Field(StatusValue.INSTANCE, Values.CONNECTED.getOrdinal());
        public final Field IN_PROCESS = new Field(StatusValue.INSTANCE, Values.IN_PROCESS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NOT_CONNECTED__DOWN_EXPECTED_DOWN("3"),
        NOT_CONNECTED__DOWN_EXPECTED_UP("2"),
        CONNECTED("1"),
        IN_PROCESS("4");

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
