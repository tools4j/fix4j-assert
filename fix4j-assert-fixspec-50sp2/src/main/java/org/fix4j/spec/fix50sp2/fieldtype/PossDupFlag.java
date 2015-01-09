package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PossDupFlag extends BaseFieldType {
    public static final PossDupFlag INSTANCE = new PossDupFlag();

    private PossDupFlag() {
        super(
            "PossDupFlag",
            43,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ORIGINAL_TRANSMISSION = new Field(PossDupFlag.INSTANCE, Values.ORIGINAL_TRANSMISSION.getOrdinal());
        public final Field POSSIBLE_DUPLICATE = new Field(PossDupFlag.INSTANCE, Values.POSSIBLE_DUPLICATE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ORIGINAL_TRANSMISSION("N"),
        POSSIBLE_DUPLICATE("Y");

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
