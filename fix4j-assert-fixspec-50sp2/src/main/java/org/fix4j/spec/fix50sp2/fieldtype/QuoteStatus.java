package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuoteStatus extends BaseFieldType {
    public static final QuoteStatus INSTANCE = new QuoteStatus();

    private QuoteStatus() {
        super(
            "QuoteStatus",
            297,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PENDING_END_TRADE = new Field(QuoteStatus.INSTANCE, Values.PENDING_END_TRADE.getOrdinal());
        public final Field CANCELED = new Field(QuoteStatus.INSTANCE, Values.CANCELED.getOrdinal());
        public final Field UNSOLICITED_QUOTE_REPLENISHMENT = new Field(QuoteStatus.INSTANCE, Values.UNSOLICITED_QUOTE_REPLENISHMENT.getOrdinal());
        public final Field CANCELED_DUE_TO_CROSS_MARKET = new Field(QuoteStatus.INSTANCE, Values.CANCELED_DUE_TO_CROSS_MARKET.getOrdinal());
        public final Field ACTIVE = new Field(QuoteStatus.INSTANCE, Values.ACTIVE.getOrdinal());
        public final Field CROSS_MARKET_WARNING = new Field(QuoteStatus.INSTANCE, Values.CROSS_MARKET_WARNING.getOrdinal());
        public final Field CANCELED_DUE_TO_LOCK_MARKET = new Field(QuoteStatus.INSTANCE, Values.CANCELED_DUE_TO_LOCK_MARKET.getOrdinal());
        public final Field PASS = new Field(QuoteStatus.INSTANCE, Values.PASS.getOrdinal());
        public final Field LOCKED_MARKET_WARNING = new Field(QuoteStatus.INSTANCE, Values.LOCKED_MARKET_WARNING.getOrdinal());
        public final Field CANCELED_FOR_UNDERLYING = new Field(QuoteStatus.INSTANCE, Values.CANCELED_FOR_UNDERLYING.getOrdinal());
        public final Field TOO_LATE_TO_END = new Field(QuoteStatus.INSTANCE, Values.TOO_LATE_TO_END.getOrdinal());
        public final Field CANCELED_FOR_SECURITY_TYPES = new Field(QuoteStatus.INSTANCE, Values.CANCELED_FOR_SECURITY_TYPES.getOrdinal());
        public final Field CANCEL_FOR_SYMBOLS = new Field(QuoteStatus.INSTANCE, Values.CANCEL_FOR_SYMBOLS.getOrdinal());
        public final Field PENDING = new Field(QuoteStatus.INSTANCE, Values.PENDING.getOrdinal());
        public final Field ACCEPTED = new Field(QuoteStatus.INSTANCE, Values.ACCEPTED.getOrdinal());
        public final Field EXPIRED = new Field(QuoteStatus.INSTANCE, Values.EXPIRED.getOrdinal());
        public final Field REMOVED_FROM_MARKET = new Field(QuoteStatus.INSTANCE, Values.REMOVED_FROM_MARKET.getOrdinal());
        public final Field REJECTED = new Field(QuoteStatus.INSTANCE, Values.REJECTED.getOrdinal());
        public final Field CANCELED_ALL = new Field(QuoteStatus.INSTANCE, Values.CANCELED_ALL.getOrdinal());
        public final Field QUOTE_NOT_FOUND = new Field(QuoteStatus.INSTANCE, Values.QUOTE_NOT_FOUND.getOrdinal());
        public final Field QUERY = new Field(QuoteStatus.INSTANCE, Values.QUERY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PENDING_END_TRADE("19"),
        CANCELED("17"),
        UNSOLICITED_QUOTE_REPLENISHMENT("18"),
        CANCELED_DUE_TO_CROSS_MARKET("15"),
        ACTIVE("16"),
        CROSS_MARKET_WARNING("13"),
        CANCELED_DUE_TO_LOCK_MARKET("14"),
        PASS("11"),
        LOCKED_MARKET_WARNING("12"),
        CANCELED_FOR_UNDERLYING("3"),
        TOO_LATE_TO_END("20"),
        CANCELED_FOR_SECURITY_TYPES("2"),
        CANCEL_FOR_SYMBOLS("1"),
        PENDING("10"),
        ACCEPTED("0"),
        EXPIRED("7"),
        REMOVED_FROM_MARKET("6"),
        REJECTED("5"),
        CANCELED_ALL("4"),
        QUOTE_NOT_FOUND("9"),
        QUERY("8");

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
