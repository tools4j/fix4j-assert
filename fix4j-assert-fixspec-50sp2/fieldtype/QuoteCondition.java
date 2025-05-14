package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuoteCondition extends BaseFieldType {
    public static final QuoteCondition INSTANCE = new QuoteCondition();

    private QuoteCondition() {
        super(
            "QuoteCondition",
            276,
            FieldClassLookup.lookup("MULTIPLESTRINGVALUE"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REST_OF_BOOK_VWAP = new Field(QuoteCondition.INSTANCE, Values.REST_OF_BOOK_VWAP.getOrdinal());
        public final Field RESTRICTED = new Field(QuoteCondition.INSTANCE, Values.RESTRICTED.getOrdinal());
        public final Field NO_ACTIVE_SAM = new Field(QuoteCondition.INSTANCE, Values.NO_ACTIVE_SAM.getOrdinal());
        public final Field RESERVED_SAM = new Field(QuoteCondition.INSTANCE, Values.RESERVED_SAM.getOrdinal());
        public final Field FLAT_CURVE = new Field(QuoteCondition.INSTANCE, Values.FLAT_CURVE.getOrdinal());
        public final Field FULL_CURVE = new Field(QuoteCondition.INSTANCE, Values.FULL_CURVE.getOrdinal());
        public final Field MEDIAN_PRICE = new Field(QuoteCondition.INSTANCE, Values.MEDIAN_PRICE.getOrdinal());
        public final Field BETTER_PRICES_IN_CONDITIONAL_ORDERS = new Field(QuoteCondition.INSTANCE, Values.BETTER_PRICES_IN_CONDITIONAL_ORDERS.getOrdinal());
        public final Field CONSOLIDATED_BEST = new Field(QuoteCondition.INSTANCE, Values.CONSOLIDATED_BEST.getOrdinal());
        public final Field LOCKED = new Field(QuoteCondition.INSTANCE, Values.LOCKED.getOrdinal());
        public final Field CROSSED = new Field(QuoteCondition.INSTANCE, Values.CROSSED.getOrdinal());
        public final Field DEPTH = new Field(QuoteCondition.INSTANCE, Values.DEPTH.getOrdinal());
        public final Field OPENACTIVE = new Field(QuoteCondition.INSTANCE, Values.OPENACTIVE.getOrdinal());
        public final Field CLOSEDINACTIVE = new Field(QuoteCondition.INSTANCE, Values.CLOSEDINACTIVE.getOrdinal());
        public final Field EXCHANGE_BEST = new Field(QuoteCondition.INSTANCE, Values.EXCHANGE_BEST.getOrdinal());
        public final Field MANUALSLOW_QUOTE = new Field(QuoteCondition.INSTANCE, Values.MANUALSLOW_QUOTE.getOrdinal());
        public final Field DEPTH_ON_OFFER = new Field(QuoteCondition.INSTANCE, Values.DEPTH_ON_OFFER.getOrdinal());
        public final Field DEPTH_ON_BID = new Field(QuoteCondition.INSTANCE, Values.DEPTH_ON_BID.getOrdinal());
        public final Field CLOSING = new Field(QuoteCondition.INSTANCE, Values.CLOSING.getOrdinal());
        public final Field FAST_TRADING = new Field(QuoteCondition.INSTANCE, Values.FAST_TRADING.getOrdinal());
        public final Field NONFIRM = new Field(QuoteCondition.INSTANCE, Values.NONFIRM.getOrdinal());
        public final Field OUTRIGHT_PRICE = new Field(QuoteCondition.INSTANCE, Values.OUTRIGHT_PRICE.getOrdinal());
        public final Field IMPLIED_PRICE = new Field(QuoteCondition.INSTANCE, Values.IMPLIED_PRICE.getOrdinal());
        public final Field ADDITIONAL_INFO = new Field(QuoteCondition.INSTANCE, Values.ADDITIONAL_INFO.getOrdinal());
        public final Field NEWS_PENDING = new Field(QuoteCondition.INSTANCE, Values.NEWS_PENDING.getOrdinal());
        public final Field RESUME = new Field(QuoteCondition.INSTANCE, Values.RESUME.getOrdinal());
        public final Field ADDITIONAL_INFO_DUE_TO_RELATED = new Field(QuoteCondition.INSTANCE, Values.ADDITIONAL_INFO_DUE_TO_RELATED.getOrdinal());
        public final Field TRADING_RANGE = new Field(QuoteCondition.INSTANCE, Values.TRADING_RANGE.getOrdinal());
        public final Field NEWS_DISSEMINATION = new Field(QuoteCondition.INSTANCE, Values.NEWS_DISSEMINATION.getOrdinal());
        public final Field DUE_TO_RELATED = new Field(QuoteCondition.INSTANCE, Values.DUE_TO_RELATED.getOrdinal());
        public final Field ORDER_INFLUX = new Field(QuoteCondition.INSTANCE, Values.ORDER_INFLUX.getOrdinal());
        public final Field VOLUME_ALERT = new Field(QuoteCondition.INSTANCE, Values.VOLUME_ALERT.getOrdinal());
        public final Field VIEW_OF_COMMON = new Field(QuoteCondition.INSTANCE, Values.VIEW_OF_COMMON.getOrdinal());
        public final Field ORDER_IMBALANCE = new Field(QuoteCondition.INSTANCE, Values.ORDER_IMBALANCE.getOrdinal());
        public final Field FAST_MARKET_ETH = new Field(QuoteCondition.INSTANCE, Values.FAST_MARKET_ETH.getOrdinal());
        public final Field INACTIVE_ETH = new Field(QuoteCondition.INSTANCE, Values.INACTIVE_ETH.getOrdinal());
        public final Field AUTOMATIC_EXECUTION = new Field(QuoteCondition.INSTANCE, Values.AUTOMATIC_EXECUTION.getOrdinal());
        public final Field AUTOMATIC_EXECUTION_ETH = new Field(QuoteCondition.INSTANCE, Values.AUTOMATIC_EXECUTION_ETH.getOrdinal());
        public final Field NO_OPEN__NO_RESUME = new Field(QuoteCondition.INSTANCE, Values.NO_OPEN__NO_RESUME.getOrdinal());
        public final Field REGULAR_ETH = new Field(QuoteCondition.INSTANCE, Values.REGULAR_ETH.getOrdinal());
        public final Field EQUIPMENT_CHANGEOVER = new Field(QuoteCondition.INSTANCE, Values.EQUIPMENT_CHANGEOVER.getOrdinal());
        public final Field TRADING_RESUME = new Field(QuoteCondition.INSTANCE, Values.TRADING_RESUME.getOrdinal());
        public final Field OUT_OF_SEQUENCE = new Field(QuoteCondition.INSTANCE, Values.OUT_OF_SEQUENCE.getOrdinal());
        public final Field DUE_TO_NEWS_DISSEMINATION = new Field(QuoteCondition.INSTANCE, Values.DUE_TO_NEWS_DISSEMINATION.getOrdinal());
        public final Field DUE_TO_NEWS_PENDING = new Field(QuoteCondition.INSTANCE, Values.DUE_TO_NEWS_PENDING.getOrdinal());
        public final Field HALT = new Field(QuoteCondition.INSTANCE, Values.HALT.getOrdinal());
        public final Field HALT_ETH = new Field(QuoteCondition.INSTANCE, Values.HALT_ETH.getOrdinal());
        public final Field ROTATION = new Field(QuoteCondition.INSTANCE, Values.ROTATION.getOrdinal());
        public final Field ROTATION_ETH = new Field(QuoteCondition.INSTANCE, Values.ROTATION_ETH.getOrdinal());
        public final Field OPENING_SAM = new Field(QuoteCondition.INSTANCE, Values.OPENING_SAM.getOrdinal());
        public final Field PREOPENING_SAM = new Field(QuoteCondition.INSTANCE, Values.PREOPENING_SAM.getOrdinal());
        public final Field FROZEN_SAM = new Field(QuoteCondition.INSTANCE, Values.FROZEN_SAM.getOrdinal());
        public final Field FORBIDDEN_SAM = new Field(QuoteCondition.INSTANCE, Values.FORBIDDEN_SAM.getOrdinal());
        public final Field END_OF_DAY_SAM = new Field(QuoteCondition.INSTANCE, Values.END_OF_DAY_SAM.getOrdinal());
        public final Field BID_OFFER_SPECIALIST = new Field(QuoteCondition.INSTANCE, Values.BID_OFFER_SPECIALIST.getOrdinal());
        public final Field OFFER_SPECIALIST = new Field(QuoteCondition.INSTANCE, Values.OFFER_SPECIALIST.getOrdinal());
        public final Field BID_SPECIALIST = new Field(QuoteCondition.INSTANCE, Values.BID_SPECIALIST.getOrdinal());
        public final Field SUSPENDED_SAM = new Field(QuoteCondition.INSTANCE, Values.SUSPENDED_SAM.getOrdinal());
        public final Field SURVEILLANCE_SAM = new Field(QuoteCondition.INSTANCE, Values.SURVEILLANCE_SAM.getOrdinal());
        public final Field OPEN_SAM = new Field(QuoteCondition.INSTANCE, Values.OPEN_SAM.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REST_OF_BOOK_VWAP("3"),
        RESTRICTED("2"),
        NO_ACTIVE_SAM("1"),
        RESERVED_SAM("0"),
        FLAT_CURVE("7"),
        FULL_CURVE("6"),
        MEDIAN_PRICE("5"),
        BETTER_PRICES_IN_CONDITIONAL_ORDERS("4"),
        CONSOLIDATED_BEST("D"),
        LOCKED("E"),
        CROSSED("F"),
        DEPTH("G"),
        OPENACTIVE("A"),
        CLOSEDINACTIVE("B"),
        EXCHANGE_BEST("C"),
        MANUALSLOW_QUOTE("L"),
        DEPTH_ON_OFFER("M"),
        DEPTH_ON_BID("N"),
        CLOSING("O"),
        FAST_TRADING("H"),
        NONFIRM("I"),
        OUTRIGHT_PRICE("J"),
        IMPLIED_PRICE("K"),
        ADDITIONAL_INFO("U"),
        NEWS_PENDING("T"),
        RESUME("W"),
        ADDITIONAL_INFO_DUE_TO_RELATED("V"),
        TRADING_RANGE("Q"),
        NEWS_DISSEMINATION("P"),
        DUE_TO_RELATED("S"),
        ORDER_INFLUX("R"),
        VOLUME_ALERT("Y"),
        VIEW_OF_COMMON("X"),
        ORDER_IMBALANCE("Z"),
        FAST_MARKET_ETH("f"),
        INACTIVE_ETH("g"),
        AUTOMATIC_EXECUTION("d"),
        AUTOMATIC_EXECUTION_ETH("e"),
        NO_OPEN__NO_RESUME("b"),
        REGULAR_ETH("c"),
        EQUIPMENT_CHANGEOVER("a"),
        TRADING_RESUME("n"),
        OUT_OF_SEQUENCE("o"),
        DUE_TO_NEWS_DISSEMINATION("l"),
        DUE_TO_NEWS_PENDING("m"),
        HALT("j"),
        HALT_ETH("k"),
        ROTATION("h"),
        ROTATION_ETH("i"),
        OPENING_SAM("w"),
        PREOPENING_SAM("v"),
        FROZEN_SAM("u"),
        FORBIDDEN_SAM("t"),
        END_OF_DAY_SAM("s"),
        BID_OFFER_SPECIALIST("r"),
        OFFER_SPECIALIST("q"),
        BID_SPECIALIST("p"),
        SUSPENDED_SAM("z"),
        SURVEILLANCE_SAM("y"),
        OPEN_SAM("x");

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
