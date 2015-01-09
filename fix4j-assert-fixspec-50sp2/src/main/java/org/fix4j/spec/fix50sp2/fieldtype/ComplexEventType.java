package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ComplexEventType extends BaseFieldType {
    public static final ComplexEventType INSTANCE = new ComplexEventType();

    private ComplexEventType() {
        super(
            "ComplexEventType",
            1484,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field KNOCKIN_UP = new Field(ComplexEventType.INSTANCE, Values.KNOCKIN_UP.getOrdinal());
        public final Field TRIGGER = new Field(ComplexEventType.INSTANCE, Values.TRIGGER.getOrdinal());
        public final Field CAPPED = new Field(ComplexEventType.INSTANCE, Values.CAPPED.getOrdinal());
        public final Field UNDERLYING = new Field(ComplexEventType.INSTANCE, Values.UNDERLYING.getOrdinal());
        public final Field KNOCKOUT_DOWN = new Field(ComplexEventType.INSTANCE, Values.KNOCKOUT_DOWN.getOrdinal());
        public final Field KNOCKOUT_UP = new Field(ComplexEventType.INSTANCE, Values.KNOCKOUT_UP.getOrdinal());
        public final Field KOCKIN_DOWN = new Field(ComplexEventType.INSTANCE, Values.KOCKIN_DOWN.getOrdinal());
        public final Field ROLLING_BARRIER = new Field(ComplexEventType.INSTANCE, Values.ROLLING_BARRIER.getOrdinal());
        public final Field RESET_BARRIER = new Field(ComplexEventType.INSTANCE, Values.RESET_BARRIER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        KNOCKIN_UP("3"),
        TRIGGER("2"),
        CAPPED("1"),
        UNDERLYING("7"),
        KNOCKOUT_DOWN("6"),
        KNOCKOUT_UP("5"),
        KOCKIN_DOWN("4"),
        ROLLING_BARRIER("9"),
        RESET_BARRIER("8");

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
