package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuoteRequestRejectReason extends BaseFieldType {
    public static final QuoteRequestRejectReason INSTANCE = new QuoteRequestRejectReason();

    private QuoteRequestRejectReason() {
        super(
            "QuoteRequestRejectReason",
            658,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field QUOTE_REQUEST_EXCEEDS_LIMIT = new Field(QuoteRequestRejectReason.INSTANCE, Values.QUOTE_REQUEST_EXCEEDS_LIMIT.getOrdinal());
        public final Field EXCHANGE_SECURITY_CLOSED = new Field(QuoteRequestRejectReason.INSTANCE, Values.EXCHANGE_SECURITY_CLOSED.getOrdinal());
        public final Field PASS = new Field(QuoteRequestRejectReason.INSTANCE, Values.PASS.getOrdinal());
        public final Field UNKNOWN_SYMBOL_SECURITY = new Field(QuoteRequestRejectReason.INSTANCE, Values.UNKNOWN_SYMBOL_SECURITY.getOrdinal());
        public final Field NO_MATCH_FOR_INQUIRY = new Field(QuoteRequestRejectReason.INSTANCE, Values.NO_MATCH_FOR_INQUIRY.getOrdinal());
        public final Field NOT_AUTHORIZED_TO_REQUEST_QUOTE = new Field(QuoteRequestRejectReason.INSTANCE, Values.NOT_AUTHORIZED_TO_REQUEST_QUOTE.getOrdinal());
        public final Field INVALID_PRICE = new Field(QuoteRequestRejectReason.INSTANCE, Values.INVALID_PRICE.getOrdinal());
        public final Field TOO_LATE_TO_ENTER = new Field(QuoteRequestRejectReason.INSTANCE, Values.TOO_LATE_TO_ENTER.getOrdinal());
        public final Field NO_INVENTORY = new Field(QuoteRequestRejectReason.INSTANCE, Values.NO_INVENTORY.getOrdinal());
        public final Field NO_MARKET_FOR_INSTRUMENT = new Field(QuoteRequestRejectReason.INSTANCE, Values.NO_MARKET_FOR_INSTRUMENT.getOrdinal());
        public final Field OTHER = new Field(QuoteRequestRejectReason.INSTANCE, Values.OTHER.getOrdinal());
        public final Field INSUFFICIENT_CREDIT = new Field(QuoteRequestRejectReason.INSTANCE, Values.INSUFFICIENT_CREDIT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        QUOTE_REQUEST_EXCEEDS_LIMIT("3"),
        EXCHANGE_SECURITY_CLOSED("2"),
        PASS("10"),
        UNKNOWN_SYMBOL_SECURITY("1"),
        NO_MATCH_FOR_INQUIRY("7"),
        NOT_AUTHORIZED_TO_REQUEST_QUOTE("6"),
        INVALID_PRICE("5"),
        TOO_LATE_TO_ENTER("4"),
        NO_INVENTORY("9"),
        NO_MARKET_FOR_INSTRUMENT("8"),
        OTHER("99"),
        INSUFFICIENT_CREDIT("11");

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
