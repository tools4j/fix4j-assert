package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class Urgency extends BaseFieldType {
    public static final Urgency INSTANCE = new Urgency();

    private Urgency() {
        super(
            "Urgency",
            61,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BACKGROUND = new Field(Urgency.INSTANCE, Values.BACKGROUND.getOrdinal());
        public final Field FLASH = new Field(Urgency.INSTANCE, Values.FLASH.getOrdinal());
        public final Field NORMAL = new Field(Urgency.INSTANCE, Values.NORMAL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BACKGROUND("2"),
        FLASH("1"),
        NORMAL("0");

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
