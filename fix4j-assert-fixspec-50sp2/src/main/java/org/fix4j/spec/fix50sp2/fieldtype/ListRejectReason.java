package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ListRejectReason extends BaseFieldType {
    public static final ListRejectReason INSTANCE = new ListRejectReason();

    private ListRejectReason() {
        super(
            "ListRejectReason",
            1386,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXCHANGE_CLOSED = new Field(ListRejectReason.INSTANCE, Values.EXCHANGE_CLOSED.getOrdinal());
        public final Field BROKER__EXCHANGE_OPTION = new Field(ListRejectReason.INSTANCE, Values.BROKER__EXCHANGE_OPTION.getOrdinal());
        public final Field DUPLICATE_ORDER_EG_DUPE_CLORDID = new Field(ListRejectReason.INSTANCE, Values.DUPLICATE_ORDER_EG_DUPE_CLORDID.getOrdinal());
        public final Field UNKNOWN_ORDER = new Field(ListRejectReason.INSTANCE, Values.UNKNOWN_ORDER.getOrdinal());
        public final Field TOO_LATE_TO_ENTER = new Field(ListRejectReason.INSTANCE, Values.TOO_LATE_TO_ENTER.getOrdinal());
        public final Field OTHER = new Field(ListRejectReason.INSTANCE, Values.OTHER.getOrdinal());
        public final Field UNSUPPORTED_ORDER_CHARACTERISTIC = new Field(ListRejectReason.INSTANCE, Values.UNSUPPORTED_ORDER_CHARACTERISTIC.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXCHANGE_CLOSED("2"),
        BROKER__EXCHANGE_OPTION("0"),
        DUPLICATE_ORDER_EG_DUPE_CLORDID("6"),
        UNKNOWN_ORDER("5"),
        TOO_LATE_TO_ENTER("4"),
        OTHER("99"),
        UNSUPPORTED_ORDER_CHARACTERISTIC("11");

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
