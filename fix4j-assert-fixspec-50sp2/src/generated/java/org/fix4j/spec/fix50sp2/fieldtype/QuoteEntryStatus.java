package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuoteEntryStatus extends BaseFieldType {
    public static final QuoteEntryStatus INSTANCE = new QuoteEntryStatus();

    private QuoteEntryStatus() {
        super(
            "QuoteEntryStatus",
            1167,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ACCEPTED = new Field(QuoteEntryStatus.INSTANCE, Values.ACCEPTED.getOrdinal());
        public final Field EXPIRED = new Field(QuoteEntryStatus.INSTANCE, Values.EXPIRED.getOrdinal());
        public final Field REMOVED_FROM_MARKET = new Field(QuoteEntryStatus.INSTANCE, Values.REMOVED_FROM_MARKET.getOrdinal());
        public final Field REJECTED = new Field(QuoteEntryStatus.INSTANCE, Values.REJECTED.getOrdinal());
        public final Field CANCELED_DUE_TO_CROSS_MARKET = new Field(QuoteEntryStatus.INSTANCE, Values.CANCELED_DUE_TO_CROSS_MARKET.getOrdinal());
        public final Field ACTIVE = new Field(QuoteEntryStatus.INSTANCE, Values.ACTIVE.getOrdinal());
        public final Field CROSS_MARKET_WARNING = new Field(QuoteEntryStatus.INSTANCE, Values.CROSS_MARKET_WARNING.getOrdinal());
        public final Field CANCELED_DUE_TO_LOCK_MARKET = new Field(QuoteEntryStatus.INSTANCE, Values.CANCELED_DUE_TO_LOCK_MARKET.getOrdinal());
        public final Field LOCKED_MARKET_WARNING = new Field(QuoteEntryStatus.INSTANCE, Values.LOCKED_MARKET_WARNING.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ACCEPTED("0"),
        EXPIRED("7"),
        REMOVED_FROM_MARKET("6"),
        REJECTED("5"),
        CANCELED_DUE_TO_CROSS_MARKET("15"),
        ACTIVE("16"),
        CROSS_MARKET_WARNING("13"),
        CANCELED_DUE_TO_LOCK_MARKET("14"),
        LOCKED_MARKET_WARNING("12");

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
