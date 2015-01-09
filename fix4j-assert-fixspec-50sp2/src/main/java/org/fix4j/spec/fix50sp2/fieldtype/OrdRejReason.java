package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OrdRejReason extends BaseFieldType {
    public static final OrdRejReason INSTANCE = new OrdRejReason();

    private OrdRejReason() {
        super(
            "OrdRejReason",
            103,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INVALID_PRICE_INCREMENT = new Field(OrdRejReason.INSTANCE, Values.INVALID_PRICE_INCREMENT.getOrdinal());
        public final Field UNKNOWN_ACCOUNTS = new Field(OrdRejReason.INSTANCE, Values.UNKNOWN_ACCOUNTS.getOrdinal());
        public final Field PRICE_EXCEEDS_CURRENT_PRICE_BAND = new Field(OrdRejReason.INSTANCE, Values.PRICE_EXCEEDS_CURRENT_PRICE_BAND.getOrdinal());
        public final Field INCORRECT_QUANTITY = new Field(OrdRejReason.INSTANCE, Values.INCORRECT_QUANTITY.getOrdinal());
        public final Field INCORRECT_ALLOCATED_QUANTITY = new Field(OrdRejReason.INSTANCE, Values.INCORRECT_ALLOCATED_QUANTITY.getOrdinal());
        public final Field UNSUPPORTED_ORDER_CHARACTERISTIC = new Field(OrdRejReason.INSTANCE, Values.UNSUPPORTED_ORDER_CHARACTERISTIC.getOrdinal());
        public final Field SURVEILLENCE_OPTION = new Field(OrdRejReason.INSTANCE, Values.SURVEILLENCE_OPTION.getOrdinal());
        public final Field ORDER_EXCEEDS_LIMIT = new Field(OrdRejReason.INSTANCE, Values.ORDER_EXCEEDS_LIMIT.getOrdinal());
        public final Field EXCHANGE_CLOSED = new Field(OrdRejReason.INSTANCE, Values.EXCHANGE_CLOSED.getOrdinal());
        public final Field UNKNOWN_SYMBOL = new Field(OrdRejReason.INSTANCE, Values.UNKNOWN_SYMBOL.getOrdinal());
        public final Field INVALID_INVESTOR_ID = new Field(OrdRejReason.INSTANCE, Values.INVALID_INVESTOR_ID.getOrdinal());
        public final Field BROKER__EXCHANGE_OPTION = new Field(OrdRejReason.INSTANCE, Values.BROKER__EXCHANGE_OPTION.getOrdinal());
        public final Field DUPLICATE_OF_A_VERBALLY_COMMUNICATED_ORDER = new Field(OrdRejReason.INSTANCE, Values.DUPLICATE_OF_A_VERBALLY_COMMUNICATED_ORDER.getOrdinal());
        public final Field DUPLICATE_ORDER_EG_DUPE_CLORDID = new Field(OrdRejReason.INSTANCE, Values.DUPLICATE_ORDER_EG_DUPE_CLORDID.getOrdinal());
        public final Field UNKNOWN_ORDER = new Field(OrdRejReason.INSTANCE, Values.UNKNOWN_ORDER.getOrdinal());
        public final Field TOO_LATE_TO_ENTER = new Field(OrdRejReason.INSTANCE, Values.TOO_LATE_TO_ENTER.getOrdinal());
        public final Field TRADE_ALONG_REQUIRED = new Field(OrdRejReason.INSTANCE, Values.TRADE_ALONG_REQUIRED.getOrdinal());
        public final Field STALE_ORDER = new Field(OrdRejReason.INSTANCE, Values.STALE_ORDER.getOrdinal());
        public final Field OTHER = new Field(OrdRejReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INVALID_PRICE_INCREMENT("18"),
        UNKNOWN_ACCOUNTS("15"),
        PRICE_EXCEEDS_CURRENT_PRICE_BAND("16"),
        INCORRECT_QUANTITY("13"),
        INCORRECT_ALLOCATED_QUANTITY("14"),
        UNSUPPORTED_ORDER_CHARACTERISTIC("11"),
        SURVEILLENCE_OPTION("12"),
        ORDER_EXCEEDS_LIMIT("3"),
        EXCHANGE_CLOSED("2"),
        UNKNOWN_SYMBOL("1"),
        INVALID_INVESTOR_ID("10"),
        BROKER__EXCHANGE_OPTION("0"),
        DUPLICATE_OF_A_VERBALLY_COMMUNICATED_ORDER("7"),
        DUPLICATE_ORDER_EG_DUPE_CLORDID("6"),
        UNKNOWN_ORDER("5"),
        TOO_LATE_TO_ENTER("4"),
        TRADE_ALONG_REQUIRED("9"),
        STALE_ORDER("8"),
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
