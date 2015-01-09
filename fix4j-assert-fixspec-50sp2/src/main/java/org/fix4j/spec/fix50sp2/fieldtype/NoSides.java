package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class NoSides extends BaseFieldType {
    public static final NoSides INSTANCE = new NoSides();

    private NoSides() {
        super(
            "NoSides",
            552,
            FieldClassLookup.lookup("NUMINGROUP"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BOTH_SIDES = new Field(NoSides.INSTANCE, Values.BOTH_SIDES.getOrdinal());
        public final Field ONE_SIDE = new Field(NoSides.INSTANCE, Values.ONE_SIDE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BOTH_SIDES("2"),
        ONE_SIDE("1");

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
