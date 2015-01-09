package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RoundingDirection extends BaseFieldType {
    public static final RoundingDirection INSTANCE = new RoundingDirection();

    private RoundingDirection() {
        super(
            "RoundingDirection",
            468,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ROUND_UP = new Field(RoundingDirection.INSTANCE, Values.ROUND_UP.getOrdinal());
        public final Field ROUND_DOWN = new Field(RoundingDirection.INSTANCE, Values.ROUND_DOWN.getOrdinal());
        public final Field ROUND_TO_NEAREST = new Field(RoundingDirection.INSTANCE, Values.ROUND_TO_NEAREST.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ROUND_UP("2"),
        ROUND_DOWN("1"),
        ROUND_TO_NEAREST("0");

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
