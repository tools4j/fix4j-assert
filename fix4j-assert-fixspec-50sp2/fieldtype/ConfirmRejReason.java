package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ConfirmRejReason extends BaseFieldType {
    public static final ConfirmRejReason INSTANCE = new ConfirmRejReason();

    private ConfirmRejReason() {
        super(
            "ConfirmRejReason",
            774,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MISSING_SETTLEMENT_INSTRUCTIONS = new Field(ConfirmRejReason.INSTANCE, Values.MISSING_SETTLEMENT_INSTRUCTIONS.getOrdinal());
        public final Field MISMATCHED_ACCOUNT = new Field(ConfirmRejReason.INSTANCE, Values.MISMATCHED_ACCOUNT.getOrdinal());
        public final Field OTHER = new Field(ConfirmRejReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MISSING_SETTLEMENT_INSTRUCTIONS("2"),
        MISMATCHED_ACCOUNT("1"),
        OTHER("99");

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
