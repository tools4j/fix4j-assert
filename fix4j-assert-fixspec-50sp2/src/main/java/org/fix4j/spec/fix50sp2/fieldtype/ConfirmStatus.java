package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ConfirmStatus extends BaseFieldType {
    public static final ConfirmStatus INSTANCE = new ConfirmStatus();

    private ConfirmStatus() {
        super(
            "ConfirmStatus",
            665,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MISSING_SETTLEMENT_INSTRUCTIONS = new Field(ConfirmStatus.INSTANCE, Values.MISSING_SETTLEMENT_INSTRUCTIONS.getOrdinal());
        public final Field MISMATCHED_ACCOUNT = new Field(ConfirmStatus.INSTANCE, Values.MISMATCHED_ACCOUNT.getOrdinal());
        public final Field RECEIVED = new Field(ConfirmStatus.INSTANCE, Values.RECEIVED.getOrdinal());
        public final Field REQUEST_REJECTED = new Field(ConfirmStatus.INSTANCE, Values.REQUEST_REJECTED.getOrdinal());
        public final Field CONFIRMED = new Field(ConfirmStatus.INSTANCE, Values.CONFIRMED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MISSING_SETTLEMENT_INSTRUCTIONS("3"),
        MISMATCHED_ACCOUNT("2"),
        RECEIVED("1"),
        REQUEST_REJECTED("5"),
        CONFIRMED("4");

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
