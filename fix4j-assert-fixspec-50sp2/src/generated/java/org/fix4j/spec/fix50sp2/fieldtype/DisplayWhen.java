package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DisplayWhen extends BaseFieldType {
    public static final DisplayWhen INSTANCE = new DisplayWhen();

    private DisplayWhen() {
        super(
            "DisplayWhen",
            1083,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXHAUST_WHEN_DISPLAYQTY__0 = new Field(DisplayWhen.INSTANCE, Values.EXHAUST_WHEN_DISPLAYQTY__0.getOrdinal());
        public final Field IMMEDIATE_AFTER_EACH_FILL = new Field(DisplayWhen.INSTANCE, Values.IMMEDIATE_AFTER_EACH_FILL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXHAUST_WHEN_DISPLAYQTY__0("2"),
        IMMEDIATE_AFTER_EACH_FILL("1");

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
