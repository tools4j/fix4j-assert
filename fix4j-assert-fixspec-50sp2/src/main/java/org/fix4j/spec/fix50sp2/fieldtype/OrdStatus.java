package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OrdStatus extends BaseFieldType {
    public static final OrdStatus INSTANCE = new OrdStatus();

    private OrdStatus() {
        super(
            "OrdStatus",
            39,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ACCEPTED_FOR_BIDDING = new Field(OrdStatus.INSTANCE, Values.ACCEPTED_FOR_BIDDING.getOrdinal());
        public final Field PENDING_REPLACE_IE_RESULT_OF_ORDER_CANCELREPLACE_REQUEST = new Field(OrdStatus.INSTANCE, Values.PENDING_REPLACE_IE_RESULT_OF_ORDER_CANCELREPLACE_REQUEST.getOrdinal());
        public final Field PENDING_NEW = new Field(OrdStatus.INSTANCE, Values.PENDING_NEW.getOrdinal());
        public final Field CALCULATED = new Field(OrdStatus.INSTANCE, Values.CALCULATED.getOrdinal());
        public final Field EXPIRED = new Field(OrdStatus.INSTANCE, Values.EXPIRED.getOrdinal());
        public final Field DONE_FOR_DAY = new Field(OrdStatus.INSTANCE, Values.DONE_FOR_DAY.getOrdinal());
        public final Field FILLED = new Field(OrdStatus.INSTANCE, Values.FILLED.getOrdinal());
        public final Field PARTIALLY_FILLED = new Field(OrdStatus.INSTANCE, Values.PARTIALLY_FILLED.getOrdinal());
        public final Field NEW = new Field(OrdStatus.INSTANCE, Values.NEW.getOrdinal());
        public final Field STOPPED = new Field(OrdStatus.INSTANCE, Values.STOPPED.getOrdinal());
        public final Field PENDING_CANCEL_IE_RESULT_OF_ORDER_CANCEL_REQUEST = new Field(OrdStatus.INSTANCE, Values.PENDING_CANCEL_IE_RESULT_OF_ORDER_CANCEL_REQUEST.getOrdinal());
        public final Field REPLACED_NO_LONGER_USED = new Field(OrdStatus.INSTANCE, Values.REPLACED_NO_LONGER_USED.getOrdinal());
        public final Field CANCELED = new Field(OrdStatus.INSTANCE, Values.CANCELED.getOrdinal());
        public final Field SUSPENDED = new Field(OrdStatus.INSTANCE, Values.SUSPENDED.getOrdinal());
        public final Field REJECTED = new Field(OrdStatus.INSTANCE, Values.REJECTED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ACCEPTED_FOR_BIDDING("D"),
        PENDING_REPLACE_IE_RESULT_OF_ORDER_CANCELREPLACE_REQUEST("E"),
        PENDING_NEW("A"),
        CALCULATED("B"),
        EXPIRED("C"),
        DONE_FOR_DAY("3"),
        FILLED("2"),
        PARTIALLY_FILLED("1"),
        NEW("0"),
        STOPPED("7"),
        PENDING_CANCEL_IE_RESULT_OF_ORDER_CANCEL_REQUEST("6"),
        REPLACED_NO_LONGER_USED("5"),
        CANCELED("4"),
        SUSPENDED("9"),
        REJECTED("8");

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
