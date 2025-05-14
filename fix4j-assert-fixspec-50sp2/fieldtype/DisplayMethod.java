package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DisplayMethod extends BaseFieldType {
    public static final DisplayMethod INSTANCE = new DisplayMethod();

    private DisplayMethod() {
        super(
            "DisplayMethod",
            1084,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field RANDOM_RANDOMIZE_VALUE = new Field(DisplayMethod.INSTANCE, Values.RANDOM_RANDOMIZE_VALUE.getOrdinal());
        public final Field NEW_USE_REFRESHQTY = new Field(DisplayMethod.INSTANCE, Values.NEW_USE_REFRESHQTY.getOrdinal());
        public final Field INITIAL_USE_ORIGINAL_DISPLAYQTY = new Field(DisplayMethod.INSTANCE, Values.INITIAL_USE_ORIGINAL_DISPLAYQTY.getOrdinal());
        public final Field UNDISCLOSED_INVISIBLE_ORDER = new Field(DisplayMethod.INSTANCE, Values.UNDISCLOSED_INVISIBLE_ORDER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        RANDOM_RANDOMIZE_VALUE("3"),
        NEW_USE_REFRESHQTY("2"),
        INITIAL_USE_ORIGINAL_DISPLAYQTY("1"),
        UNDISCLOSED_INVISIBLE_ORDER("4");

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
