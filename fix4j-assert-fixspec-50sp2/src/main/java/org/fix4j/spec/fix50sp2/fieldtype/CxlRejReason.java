package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CxlRejReason extends BaseFieldType {
    public static final CxlRejReason INSTANCE = new CxlRejReason();

    private CxlRejReason() {
        super(
            "CxlRejReason",
            102,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ORDER_ALREADY_IN_PENDING_CANCEL_OR_PENDING_REPLACE_STATUS = new Field(CxlRejReason.INSTANCE, Values.ORDER_ALREADY_IN_PENDING_CANCEL_OR_PENDING_REPLACE_STATUS.getOrdinal());
        public final Field BROKER__EXCHANGE_OPTION = new Field(CxlRejReason.INSTANCE, Values.BROKER__EXCHANGE_OPTION.getOrdinal());
        public final Field UNKNOWN_ORDER = new Field(CxlRejReason.INSTANCE, Values.UNKNOWN_ORDER.getOrdinal());
        public final Field TOO_LATE_TO_CANCEL = new Field(CxlRejReason.INSTANCE, Values.TOO_LATE_TO_CANCEL.getOrdinal());
        public final Field PRICE_EXCEEDS_CURRENT_PRICE = new Field(CxlRejReason.INSTANCE, Values.PRICE_EXCEEDS_CURRENT_PRICE.getOrdinal());
        public final Field DUPLICATE_CLORDID_11_RECEIVED = new Field(CxlRejReason.INSTANCE, Values.DUPLICATE_CLORDID_11_RECEIVED.getOrdinal());
        public final Field ORIGORDMODTIME_586_DID_NOT_MATCH_LAST_TRANSACTTIME_60_OF_ORDER = new Field(CxlRejReason.INSTANCE, Values.ORIGORDMODTIME_586_DID_NOT_MATCH_LAST_TRANSACTTIME_60_OF_ORDER.getOrdinal());
        public final Field UNABLE_TO_PROCESS_ORDER_MASS_CANCEL_REQUEST = new Field(CxlRejReason.INSTANCE, Values.UNABLE_TO_PROCESS_ORDER_MASS_CANCEL_REQUEST.getOrdinal());
        public final Field INVALID_PRICE_INCREMENT = new Field(CxlRejReason.INSTANCE, Values.INVALID_PRICE_INCREMENT.getOrdinal());
        public final Field PRICE_EXCEEDS_CURRENT_PRICE_BAND = new Field(CxlRejReason.INSTANCE, Values.PRICE_EXCEEDS_CURRENT_PRICE_BAND.getOrdinal());
        public final Field OTHER = new Field(CxlRejReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ORDER_ALREADY_IN_PENDING_CANCEL_OR_PENDING_REPLACE_STATUS("3"),
        BROKER__EXCHANGE_OPTION("2"),
        UNKNOWN_ORDER("1"),
        TOO_LATE_TO_CANCEL("0"),
        PRICE_EXCEEDS_CURRENT_PRICE("7"),
        DUPLICATE_CLORDID_11_RECEIVED("6"),
        ORIGORDMODTIME_586_DID_NOT_MATCH_LAST_TRANSACTTIME_60_OF_ORDER("5"),
        UNABLE_TO_PROCESS_ORDER_MASS_CANCEL_REQUEST("4"),
        INVALID_PRICE_INCREMENT("18"),
        PRICE_EXCEEDS_CURRENT_PRICE_BAND("8"),
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
