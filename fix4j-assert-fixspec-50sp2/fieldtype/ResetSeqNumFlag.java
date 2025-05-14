package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ResetSeqNumFlag extends BaseFieldType {
    public static final ResetSeqNumFlag INSTANCE = new ResetSeqNumFlag();

    private ResetSeqNumFlag() {
        super(
            "ResetSeqNumFlag",
            141,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NO = new Field(ResetSeqNumFlag.INSTANCE, Values.NO.getOrdinal());
        public final Field YES_RESET_SEQUENCE_NUMBERS = new Field(ResetSeqNumFlag.INSTANCE, Values.YES_RESET_SEQUENCE_NUMBERS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NO("N"),
        YES_RESET_SEQUENCE_NUMBERS("Y");

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
