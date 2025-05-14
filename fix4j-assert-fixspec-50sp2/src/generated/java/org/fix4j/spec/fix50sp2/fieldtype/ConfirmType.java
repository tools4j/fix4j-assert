package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ConfirmType extends BaseFieldType {
    public static final ConfirmType INSTANCE = new ConfirmType();

    private ConfirmType() {
        super(
            "ConfirmType",
            773,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CONFIRMATION_REQUEST_REJECTED_REASON_CAN_BE_STATED_IN_TEXT_58_FI = new Field(ConfirmType.INSTANCE, Values.CONFIRMATION_REQUEST_REJECTED_REASON_CAN_BE_STATED_IN_TEXT_58_FI.getOrdinal());
        public final Field CONFIRMATION = new Field(ConfirmType.INSTANCE, Values.CONFIRMATION.getOrdinal());
        public final Field STATUS = new Field(ConfirmType.INSTANCE, Values.STATUS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CONFIRMATION_REQUEST_REJECTED_REASON_CAN_BE_STATED_IN_TEXT_58_FI("3"),
        CONFIRMATION("2"),
        STATUS("1");

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
