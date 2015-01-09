package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MDEntryType extends BaseFieldType {
    public static final MDEntryType INSTANCE = new MDEntryType();

    private MDEntryType() {
        super(
            "MDEntryType",
            269,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field COMPOSITE_UNDERLYING_PRICE = new Field(MDEntryType.INSTANCE, Values.COMPOSITE_UNDERLYING_PRICE.getOrdinal());
        public final Field SIMULATED_SELL_PRICE = new Field(MDEntryType.INSTANCE, Values.SIMULATED_SELL_PRICE.getOrdinal());
        public final Field SIMULATED_BUY_PRICE = new Field(MDEntryType.INSTANCE, Values.SIMULATED_BUY_PRICE.getOrdinal());
        public final Field MARGIN_RATE = new Field(MDEntryType.INSTANCE, Values.MARGIN_RATE.getOrdinal());
        public final Field IMBALANCE = new Field(MDEntryType.INSTANCE, Values.IMBALANCE.getOrdinal());
        public final Field TRADE_VOLUME = new Field(MDEntryType.INSTANCE, Values.TRADE_VOLUME.getOrdinal());
        public final Field OPEN_INTEREST = new Field(MDEntryType.INSTANCE, Values.OPEN_INTEREST.getOrdinal());
        public final Field SETTLE_LOW_PRICE = new Field(MDEntryType.INSTANCE, Values.SETTLE_LOW_PRICE.getOrdinal());
        public final Field PRIOR_SETTLE_PRICE = new Field(MDEntryType.INSTANCE, Values.PRIOR_SETTLE_PRICE.getOrdinal());
        public final Field SESSION_HIGH_BID = new Field(MDEntryType.INSTANCE, Values.SESSION_HIGH_BID.getOrdinal());
        public final Field SESSION_LOW_OFFER = new Field(MDEntryType.INSTANCE, Values.SESSION_LOW_OFFER.getOrdinal());
        public final Field MID_PRICE = new Field(MDEntryType.INSTANCE, Values.MID_PRICE.getOrdinal());
        public final Field EMPTY_BOOK = new Field(MDEntryType.INSTANCE, Values.EMPTY_BOOK.getOrdinal());
        public final Field SETTLE_HIGH_PRICE = new Field(MDEntryType.INSTANCE, Values.SETTLE_HIGH_PRICE.getOrdinal());
        public final Field DAILY_VALUE_ADJUSTMENT_FOR_SHORT_POSITIONS = new Field(MDEntryType.INSTANCE, Values.DAILY_VALUE_ADJUSTMENT_FOR_SHORT_POSITIONS.getOrdinal());
        public final Field CUMULATIVE_VALUE_ADJUSTMENT_FOR_LONG_POSITIONS = new Field(MDEntryType.INSTANCE, Values.CUMULATIVE_VALUE_ADJUSTMENT_FOR_LONG_POSITIONS.getOrdinal());
        public final Field FIXING_PRICE = new Field(MDEntryType.INSTANCE, Values.FIXING_PRICE.getOrdinal());
        public final Field CUMULATIVE_VALUE_ADJUSTMENT_FOR_SHORT_POSITIONS = new Field(MDEntryType.INSTANCE, Values.CUMULATIVE_VALUE_ADJUSTMENT_FOR_SHORT_POSITIONS.getOrdinal());
        public final Field AUCTION_CLEARING_PRICE = new Field(MDEntryType.INSTANCE, Values.AUCTION_CLEARING_PRICE.getOrdinal());
        public final Field EARLY_PRICES = new Field(MDEntryType.INSTANCE, Values.EARLY_PRICES.getOrdinal());
        public final Field SWAP_VALUE_FACTOR_SVP_FOR_SWAPS_CLEARED_THROUGH_A_CENTRAL_COUNTE = new Field(MDEntryType.INSTANCE, Values.SWAP_VALUE_FACTOR_SVP_FOR_SWAPS_CLEARED_THROUGH_A_CENTRAL_COUNTE.getOrdinal());
        public final Field DAILY_VALUE_ADJUSTMENT_FOR_LONG_POSITIONS = new Field(MDEntryType.INSTANCE, Values.DAILY_VALUE_ADJUSTMENT_FOR_LONG_POSITIONS.getOrdinal());
        public final Field RECOVERY_RATE = new Field(MDEntryType.INSTANCE, Values.RECOVERY_RATE.getOrdinal());
        public final Field CASH_RATE = new Field(MDEntryType.INSTANCE, Values.CASH_RATE.getOrdinal());
        public final Field RECOVERY_RATE_FOR_LONG = new Field(MDEntryType.INSTANCE, Values.RECOVERY_RATE_FOR_LONG.getOrdinal());
        public final Field RECOVERY_RATE_FOR_SHORT = new Field(MDEntryType.INSTANCE, Values.RECOVERY_RATE_FOR_SHORT.getOrdinal());
        public final Field INDEX_VALUE = new Field(MDEntryType.INSTANCE, Values.INDEX_VALUE.getOrdinal());
        public final Field TRADE = new Field(MDEntryType.INSTANCE, Values.TRADE.getOrdinal());
        public final Field OFFER = new Field(MDEntryType.INSTANCE, Values.OFFER.getOrdinal());
        public final Field BID = new Field(MDEntryType.INSTANCE, Values.BID.getOrdinal());
        public final Field TRADING_SESSION_HIGH_PRICE = new Field(MDEntryType.INSTANCE, Values.TRADING_SESSION_HIGH_PRICE.getOrdinal());
        public final Field SETTLEMENT_PRICE = new Field(MDEntryType.INSTANCE, Values.SETTLEMENT_PRICE.getOrdinal());
        public final Field CLOSING_PRICE = new Field(MDEntryType.INSTANCE, Values.CLOSING_PRICE.getOrdinal());
        public final Field OPENING_PRICE = new Field(MDEntryType.INSTANCE, Values.OPENING_PRICE.getOrdinal());
        public final Field TRADING_SESSION_VWAP_PRICE = new Field(MDEntryType.INSTANCE, Values.TRADING_SESSION_VWAP_PRICE.getOrdinal());
        public final Field TRADING_SESSION_LOW_PRICE = new Field(MDEntryType.INSTANCE, Values.TRADING_SESSION_LOW_PRICE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        COMPOSITE_UNDERLYING_PRICE("D"),
        SIMULATED_SELL_PRICE("E"),
        SIMULATED_BUY_PRICE("F"),
        MARGIN_RATE("G"),
        IMBALANCE("A"),
        TRADE_VOLUME("B"),
        OPEN_INTEREST("C"),
        SETTLE_LOW_PRICE("L"),
        PRIOR_SETTLE_PRICE("M"),
        SESSION_HIGH_BID("N"),
        SESSION_LOW_OFFER("O"),
        MID_PRICE("H"),
        EMPTY_BOOK("J"),
        SETTLE_HIGH_PRICE("K"),
        DAILY_VALUE_ADJUSTMENT_FOR_SHORT_POSITIONS("U"),
        CUMULATIVE_VALUE_ADJUSTMENT_FOR_LONG_POSITIONS("T"),
        FIXING_PRICE("W"),
        CUMULATIVE_VALUE_ADJUSTMENT_FOR_SHORT_POSITIONS("V"),
        AUCTION_CLEARING_PRICE("Q"),
        EARLY_PRICES("P"),
        SWAP_VALUE_FACTOR_SVP_FOR_SWAPS_CLEARED_THROUGH_A_CENTRAL_COUNTE("S"),
        DAILY_VALUE_ADJUSTMENT_FOR_LONG_POSITIONS("R"),
        RECOVERY_RATE("Y"),
        CASH_RATE("X"),
        RECOVERY_RATE_FOR_LONG("Z"),
        RECOVERY_RATE_FOR_SHORT("a"),
        INDEX_VALUE("3"),
        TRADE("2"),
        OFFER("1"),
        BID("0"),
        TRADING_SESSION_HIGH_PRICE("7"),
        SETTLEMENT_PRICE("6"),
        CLOSING_PRICE("5"),
        OPENING_PRICE("4"),
        TRADING_SESSION_VWAP_PRICE("9"),
        TRADING_SESSION_LOW_PRICE("8");

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
