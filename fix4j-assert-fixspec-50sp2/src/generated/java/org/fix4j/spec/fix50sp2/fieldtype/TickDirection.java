package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TickDirection extends BaseFieldType {
    public static final TickDirection INSTANCE = new TickDirection();

    private TickDirection() {
        super(
            "TickDirection",
            274,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ZEROMINUS_TICK = new Field(TickDirection.INSTANCE, Values.ZEROMINUS_TICK.getOrdinal());
        public final Field MINUS_TICK = new Field(TickDirection.INSTANCE, Values.MINUS_TICK.getOrdinal());
        public final Field ZEROPLUS_TICK = new Field(TickDirection.INSTANCE, Values.ZEROPLUS_TICK.getOrdinal());
        public final Field PLUS_TICK = new Field(TickDirection.INSTANCE, Values.PLUS_TICK.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ZEROMINUS_TICK("3"),
        MINUS_TICK("2"),
        ZEROPLUS_TICK("1"),
        PLUS_TICK("0");

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
