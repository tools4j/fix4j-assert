package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class Adjustment extends BaseFieldType {
    public static final Adjustment INSTANCE = new Adjustment();

    private Adjustment() {
        super(
            "Adjustment",
            334,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CORRECTION = new Field(Adjustment.INSTANCE, Values.CORRECTION.getOrdinal());
        public final Field ERROR = new Field(Adjustment.INSTANCE, Values.ERROR.getOrdinal());
        public final Field CANCEL = new Field(Adjustment.INSTANCE, Values.CANCEL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CORRECTION("3"),
        ERROR("2"),
        CANCEL("1");

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
