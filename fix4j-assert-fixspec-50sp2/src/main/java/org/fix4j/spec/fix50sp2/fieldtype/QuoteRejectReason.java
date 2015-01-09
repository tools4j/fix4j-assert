package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuoteRejectReason extends BaseFieldType {
    public static final QuoteRejectReason INSTANCE = new QuoteRejectReason();

    private QuoteRejectReason() {
        super(
            "QuoteRejectReason",
            300,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INVALID_OR_UNKNOWN_ISSUER_OF_UNDERLYING_SECURITY = new Field(QuoteRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_ISSUER_OF_UNDERLYING_SECURITY.getOrdinal());
        public final Field QUOTE_LOCKED__UNABLE_TO_UPDATECANCEL = new Field(QuoteRejectReason.INSTANCE, Values.QUOTE_LOCKED__UNABLE_TO_UPDATECANCEL.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_SECURITY_ISSUER = new Field(QuoteRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_SECURITY_ISSUER.getOrdinal());
        public final Field QUOTE_REQUEST_EXCEEDS_LIMIT = new Field(QuoteRejectReason.INSTANCE, Values.QUOTE_REQUEST_EXCEEDS_LIMIT.getOrdinal());
        public final Field EXCHANGE_SECURITY_CLOSED = new Field(QuoteRejectReason.INSTANCE, Values.EXCHANGE_SECURITY_CLOSED.getOrdinal());
        public final Field UNKNOWN_SYMBOL_SECURITY = new Field(QuoteRejectReason.INSTANCE, Values.UNKNOWN_SYMBOL_SECURITY.getOrdinal());
        public final Field PRICE_EXCEEDS_CURRENT_PRICE_BAND = new Field(QuoteRejectReason.INSTANCE, Values.PRICE_EXCEEDS_CURRENT_PRICE_BAND.getOrdinal());
        public final Field INVALID_BIDASK_SPREAD = new Field(QuoteRejectReason.INSTANCE, Values.INVALID_BIDASK_SPREAD.getOrdinal());
        public final Field DUPLICATE_QUOTE = new Field(QuoteRejectReason.INSTANCE, Values.DUPLICATE_QUOTE.getOrdinal());
        public final Field UNKNOWN_QUOTE = new Field(QuoteRejectReason.INSTANCE, Values.UNKNOWN_QUOTE.getOrdinal());
        public final Field TOO_LATE_TO_ENTER = new Field(QuoteRejectReason.INSTANCE, Values.TOO_LATE_TO_ENTER.getOrdinal());
        public final Field NOT_AUTHORIZED_TO_QUOTE_SECURITY = new Field(QuoteRejectReason.INSTANCE, Values.NOT_AUTHORIZED_TO_QUOTE_SECURITY.getOrdinal());
        public final Field INVALID_PRICE = new Field(QuoteRejectReason.INSTANCE, Values.INVALID_PRICE.getOrdinal());
        public final Field OTHER = new Field(QuoteRejectReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INVALID_OR_UNKNOWN_ISSUER_OF_UNDERLYING_SECURITY("13"),
        QUOTE_LOCKED__UNABLE_TO_UPDATECANCEL("11"),
        INVALID_OR_UNKNOWN_SECURITY_ISSUER("12"),
        QUOTE_REQUEST_EXCEEDS_LIMIT("3"),
        EXCHANGE_SECURITY_CLOSED("2"),
        UNKNOWN_SYMBOL_SECURITY("1"),
        PRICE_EXCEEDS_CURRENT_PRICE_BAND("10"),
        INVALID_BIDASK_SPREAD("7"),
        DUPLICATE_QUOTE("6"),
        UNKNOWN_QUOTE("5"),
        TOO_LATE_TO_ENTER("4"),
        NOT_AUTHORIZED_TO_QUOTE_SECURITY("9"),
        INVALID_PRICE("8"),
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
