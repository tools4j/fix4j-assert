package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class IOINaturalFlag extends BaseFieldType {
    public static final IOINaturalFlag INSTANCE = new IOINaturalFlag();

    private IOINaturalFlag() {
        super(
            "IOINaturalFlag",
            130,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NOT_NATURAL = new Field(IOINaturalFlag.INSTANCE, Values.NOT_NATURAL.getOrdinal());
        public final Field NATURAL = new Field(IOINaturalFlag.INSTANCE, Values.NATURAL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NOT_NATURAL("N"),
        NATURAL("Y");

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
