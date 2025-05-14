package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradeCondition extends BaseFieldType {
    public static final TradeCondition INSTANCE = new TradeCondition();

    private TradeCondition() {
        super(
            "TradeCondition",
            277,
            FieldClassLookup.lookup("MULTIPLESTRINGVALUE"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BURST_BASKET = new Field(TradeCondition.INSTANCE, Values.BURST_BASKET.getOrdinal());
        public final Field BASKET_INDEX = new Field(TradeCondition.INSTANCE, Values.BASKET_INDEX.getOrdinal());
        public final Field FORM_T = new Field(TradeCondition.INSTANCE, Values.FORM_T.getOrdinal());
        public final Field AUTOMATIC_EXECUTION = new Field(TradeCondition.INSTANCE, Values.AUTOMATIC_EXECUTION.getOrdinal());
        public final Field OUTSIDE_SPREAD = new Field(TradeCondition.INSTANCE, Values.OUTSIDE_SPREAD.getOrdinal());
        public final Field MULT_ASSET_CLASS_MULTILEG_TRADE = new Field(TradeCondition.INSTANCE, Values.MULT_ASSET_CLASS_MULTILEG_TRADE.getOrdinal());
        public final Field STRADDLE = new Field(TradeCondition.INSTANCE, Values.STRADDLE.getOrdinal());
        public final Field MARKETPLACE_ENTERED_TRADE = new Field(TradeCondition.INSTANCE, Values.MARKETPLACE_ENTERED_TRADE.getOrdinal());
        public final Field STRADDLE_ETH = new Field(TradeCondition.INSTANCE, Values.STRADDLE_ETH.getOrdinal());
        public final Field IMPLIED_TRADE = new Field(TradeCondition.INSTANCE, Values.IMPLIED_TRADE.getOrdinal());
        public final Field SPREAD = new Field(TradeCondition.INSTANCE, Values.SPREAD.getOrdinal());
        public final Field SPREAD_ETH = new Field(TradeCondition.INSTANCE, Values.SPREAD_ETH.getOrdinal());
        public final Field CANCEL = new Field(TradeCondition.INSTANCE, Values.CANCEL.getOrdinal());
        public final Field REGULAR_ETH = new Field(TradeCondition.INSTANCE, Values.REGULAR_ETH.getOrdinal());
        public final Field COMBO = new Field(TradeCondition.INSTANCE, Values.COMBO.getOrdinal());
        public final Field STOPPED = new Field(TradeCondition.INSTANCE, Values.STOPPED.getOrdinal());
        public final Field MULTILEGTOMULTILEG_TRADE = new Field(TradeCondition.INSTANCE, Values.MULTILEGTOMULTILEG_TRADE.getOrdinal());
        public final Field STOPPED_ETH = new Field(TradeCondition.INSTANCE, Values.STOPPED_ETH.getOrdinal());
        public final Field PRIOR_REFERENCE_PRICE = new Field(TradeCondition.INSTANCE, Values.PRIOR_REFERENCE_PRICE.getOrdinal());
        public final Field STOPPED_SOLD_LAST = new Field(TradeCondition.INSTANCE, Values.STOPPED_SOLD_LAST.getOrdinal());
        public final Field COMBO_ETH = new Field(TradeCondition.INSTANCE, Values.COMBO_ETH.getOrdinal());
        public final Field OFFICIAL_CLOSING_PRICE = new Field(TradeCondition.INSTANCE, Values.OFFICIAL_CLOSING_PRICE.getOrdinal());
        public final Field CROSSED_DUPLICATE_ENUMERATION__USE_X_INSTEAD = new Field(TradeCondition.INSTANCE, Values.CROSSED_DUPLICATE_ENUMERATION__USE_X_INSTEAD.getOrdinal());
        public final Field FAST_MARKET = new Field(TradeCondition.INSTANCE, Values.FAST_MARKET.getOrdinal());
        public final Field STOPPED_OUT_OF_SEQUENCE = new Field(TradeCondition.INSTANCE, Values.STOPPED_OUT_OF_SEQUENCE.getOrdinal());
        public final Field OFFICAL_CLOSING_PRICE_DUPLICATE_ENUMERATION__USE_AJ_INSTEAD = new Field(TradeCondition.INSTANCE, Values.OFFICAL_CLOSING_PRICE_DUPLICATE_ENUMERATION__USE_AJ_INSTEAD.getOrdinal());
        public final Field NEXT_DAY_ONLYMARKET = new Field(TradeCondition.INSTANCE, Values.NEXT_DAY_ONLYMARKET.getOrdinal());
        public final Field OPENINGREOPENING_TRADE_DETAIL = new Field(TradeCondition.INSTANCE, Values.OPENINGREOPENING_TRADE_DETAIL.getOrdinal());
        public final Field INTRADAY_TRADE_DETAIL = new Field(TradeCondition.INSTANCE, Values.INTRADAY_TRADE_DETAIL.getOrdinal());
        public final Field RULE_127_TRADE_NYSE = new Field(TradeCondition.INSTANCE, Values.RULE_127_TRADE_NYSE.getOrdinal());
        public final Field CASH_ONLY_MARKET = new Field(TradeCondition.INSTANCE, Values.CASH_ONLY_MARKET.getOrdinal());
        public final Field AVERAGE_PRICE_TRADE = new Field(TradeCondition.INSTANCE, Values.AVERAGE_PRICE_TRADE.getOrdinal());
        public final Field CASH_TRADE_SAME_DAY_CLEARING = new Field(TradeCondition.INSTANCE, Values.CASH_TRADE_SAME_DAY_CLEARING.getOrdinal());
        public final Field SELLER = new Field(TradeCondition.INSTANCE, Values.SELLER.getOrdinal());
        public final Field SOLD_OUT_OF_SEQUENCE = new Field(TradeCondition.INSTANCE, Values.SOLD_OUT_OF_SEQUENCE.getOrdinal());
        public final Field STOPPED_STOCK_GUARANTEE_OF_PRICE_BUT_DOES_NOT_EXECUTE_THE_ORDER = new Field(TradeCondition.INSTANCE, Values.STOPPED_STOCK_GUARANTEE_OF_PRICE_BUT_DOES_NOT_EXECUTE_THE_ORDER.getOrdinal());
        public final Field RULE_155_TRADE_AMEX = new Field(TradeCondition.INSTANCE, Values.RULE_155_TRADE_AMEX.getOrdinal());
        public final Field SOLD_LAST_LATE_REPORTING = new Field(TradeCondition.INSTANCE, Values.SOLD_LAST_LATE_REPORTING.getOrdinal());
        public final Field NEXT_DAY_TRADE_NEXT_DAY_CLEARING = new Field(TradeCondition.INSTANCE, Values.NEXT_DAY_TRADE_NEXT_DAY_CLEARING.getOrdinal());
        public final Field OPENED_LATE_REPORT_OF_OPENED_TRADE = new Field(TradeCondition.INSTANCE, Values.OPENED_LATE_REPORT_OF_OPENED_TRADE.getOrdinal());
        public final Field EXCHANGE_LAST = new Field(TradeCondition.INSTANCE, Values.EXCHANGE_LAST.getOrdinal());
        public final Field CONVERTED_PRICE_INDICATOR = new Field(TradeCondition.INSTANCE, Values.CONVERTED_PRICE_INDICATOR.getOrdinal());
        public final Field EXPIT = new Field(TradeCondition.INSTANCE, Values.EXPIT.getOrdinal());
        public final Field FINAL_PRICE_OF_SESSION = new Field(TradeCondition.INSTANCE, Values.FINAL_PRICE_OF_SESSION.getOrdinal());
        public final Field IMBALANCE_MORE_SELLERS_CANNOT_BE_USED_IN_COMBINATION_WITH_P = new Field(TradeCondition.INSTANCE, Values.IMBALANCE_MORE_SELLERS_CANNOT_BE_USED_IN_COMBINATION_WITH_P.getOrdinal());
        public final Field IMBALANCE_MORE_BUYERS_CANNOT_BE_USED_IN_COMBINATION_WITH_Q = new Field(TradeCondition.INSTANCE, Values.IMBALANCE_MORE_BUYERS_CANNOT_BE_USED_IN_COMBINATION_WITH_Q.getOrdinal());
        public final Field BARGAIN_CONDITION_LSE = new Field(TradeCondition.INSTANCE, Values.BARGAIN_CONDITION_LSE.getOrdinal());
        public final Field OPENING_PRICE = new Field(TradeCondition.INSTANCE, Values.OPENING_PRICE.getOrdinal());
        public final Field TRADES_RESULTING_FROM_MANUALSLOW_QUOTE = new Field(TradeCondition.INSTANCE, Values.TRADES_RESULTING_FROM_MANUALSLOW_QUOTE.getOrdinal());
        public final Field CROSSED = new Field(TradeCondition.INSTANCE, Values.CROSSED.getOrdinal());
        public final Field TRADES_RESULTING_FROM_INTERMARKET_SWEEP = new Field(TradeCondition.INSTANCE, Values.TRADES_RESULTING_FROM_INTERMARKET_SWEEP.getOrdinal());
        public final Field BUNCHED_SALE = new Field(TradeCondition.INSTANCE, Values.BUNCHED_SALE.getOrdinal());
        public final Field SPLIT_TRADE = new Field(TradeCondition.INSTANCE, Values.SPLIT_TRADE.getOrdinal());
        public final Field BUNCHED = new Field(TradeCondition.INSTANCE, Values.BUNCHED.getOrdinal());
        public final Field DISTRIBUTION = new Field(TradeCondition.INSTANCE, Values.DISTRIBUTION.getOrdinal());
        public final Field DIRECT_PLUS = new Field(TradeCondition.INSTANCE, Values.DIRECT_PLUS.getOrdinal());
        public final Field ACQUISITION = new Field(TradeCondition.INSTANCE, Values.ACQUISITION.getOrdinal());
        public final Field VOLUME_ONLY = new Field(TradeCondition.INSTANCE, Values.VOLUME_ONLY.getOrdinal());
        public final Field CANCEL_LAST = new Field(TradeCondition.INSTANCE, Values.CANCEL_LAST.getOrdinal());
        public final Field SOLD_LAST_SALE = new Field(TradeCondition.INSTANCE, Values.SOLD_LAST_SALE.getOrdinal());
        public final Field CANCEL_LAST_ETH = new Field(TradeCondition.INSTANCE, Values.CANCEL_LAST_ETH.getOrdinal());
        public final Field SOLD_LAST_SALE_ETH = new Field(TradeCondition.INSTANCE, Values.SOLD_LAST_SALE_ETH.getOrdinal());
        public final Field CANCEL_STOPPED_ETH = new Field(TradeCondition.INSTANCE, Values.CANCEL_STOPPED_ETH.getOrdinal());
        public final Field OUT_OF_SEQUENCE_ETH = new Field(TradeCondition.INSTANCE, Values.OUT_OF_SEQUENCE_ETH.getOrdinal());
        public final Field CANCEL_STOPPED = new Field(TradeCondition.INSTANCE, Values.CANCEL_STOPPED.getOrdinal());
        public final Field CANCEL_ETH = new Field(TradeCondition.INSTANCE, Values.CANCEL_ETH.getOrdinal());
        public final Field REOPEN = new Field(TradeCondition.INSTANCE, Values.REOPEN.getOrdinal());
        public final Field AUTO_EXECUTION_ETH = new Field(TradeCondition.INSTANCE, Values.AUTO_EXECUTION_ETH.getOrdinal());
        public final Field LATE_OPEN_ETH = new Field(TradeCondition.INSTANCE, Values.LATE_OPEN_ETH.getOrdinal());
        public final Field CANCEL_ONLY_ETH = new Field(TradeCondition.INSTANCE, Values.CANCEL_ONLY_ETH.getOrdinal());
        public final Field CANCEL_ONLY = new Field(TradeCondition.INSTANCE, Values.CANCEL_ONLY.getOrdinal());
        public final Field OPENED_SALE_ETH = new Field(TradeCondition.INSTANCE, Values.OPENED_SALE_ETH.getOrdinal());
        public final Field CANCEL_OPEN_ETH = new Field(TradeCondition.INSTANCE, Values.CANCEL_OPEN_ETH.getOrdinal());
        public final Field CANCEL_OPEN = new Field(TradeCondition.INSTANCE, Values.CANCEL_OPEN.getOrdinal());
        public final Field ADJUSTED_ETH = new Field(TradeCondition.INSTANCE, Values.ADJUSTED_ETH.getOrdinal());
        public final Field ADJUSTED = new Field(TradeCondition.INSTANCE, Values.ADJUSTED.getOrdinal());
        public final Field REOPEN_ETH = new Field(TradeCondition.INSTANCE, Values.REOPEN_ETH.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BURST_BASKET("AT"),
        BASKET_INDEX("AS"),
        FORM_T("AR"),
        AUTOMATIC_EXECUTION("AQ"),
        OUTSIDE_SPREAD("AV"),
        MULT_ASSET_CLASS_MULTILEG_TRADE("3"),
        STRADDLE("AC"),
        MARKETPLACE_ENTERED_TRADE("2"),
        STRADDLE_ETH("AD"),
        IMPLIED_TRADE("1"),
        SPREAD("AA"),
        SPREAD_ETH("AB"),
        CANCEL("0"),
        REGULAR_ETH("AG"),
        COMBO("AH"),
        STOPPED("AE"),
        MULTILEGTOMULTILEG_TRADE("4"),
        STOPPED_ETH("AF"),
        PRIOR_REFERENCE_PRICE("AK"),
        STOPPED_SOLD_LAST("AL"),
        COMBO_ETH("AI"),
        OFFICIAL_CLOSING_PRICE("AJ"),
        CROSSED_DUPLICATE_ENUMERATION__USE_X_INSTEAD("AO"),
        FAST_MARKET("AP"),
        STOPPED_OUT_OF_SEQUENCE("AM"),
        OFFICAL_CLOSING_PRICE_DUPLICATE_ENUMERATION__USE_AJ_INSTEAD("AN"),
        NEXT_DAY_ONLYMARKET("D"),
        OPENINGREOPENING_TRADE_DETAIL("E"),
        INTRADAY_TRADE_DETAIL("F"),
        RULE_127_TRADE_NYSE("G"),
        CASH_ONLY_MARKET("A"),
        AVERAGE_PRICE_TRADE("B"),
        CASH_TRADE_SAME_DAY_CLEARING("C"),
        SELLER("L"),
        SOLD_OUT_OF_SEQUENCE("M"),
        STOPPED_STOCK_GUARANTEE_OF_PRICE_BUT_DOES_NOT_EXECUTE_THE_ORDER("N"),
        RULE_155_TRADE_AMEX("H"),
        SOLD_LAST_LATE_REPORTING("I"),
        NEXT_DAY_TRADE_NEXT_DAY_CLEARING("J"),
        OPENED_LATE_REPORT_OF_OPENED_TRADE("K"),
        EXCHANGE_LAST("U"),
        CONVERTED_PRICE_INDICATOR("T"),
        EXPIT("W"),
        FINAL_PRICE_OF_SESSION("V"),
        IMBALANCE_MORE_SELLERS_CANNOT_BE_USED_IN_COMBINATION_WITH_P("Q"),
        IMBALANCE_MORE_BUYERS_CANNOT_BE_USED_IN_COMBINATION_WITH_Q("P"),
        BARGAIN_CONDITION_LSE("S"),
        OPENING_PRICE("R"),
        TRADES_RESULTING_FROM_MANUALSLOW_QUOTE("Y"),
        CROSSED("X"),
        TRADES_RESULTING_FROM_INTERMARKET_SWEEP("Z"),
        BUNCHED_SALE("f"),
        SPLIT_TRADE("g"),
        BUNCHED("d"),
        DISTRIBUTION("e"),
        DIRECT_PLUS("b"),
        ACQUISITION("c"),
        VOLUME_ONLY("a"),
        CANCEL_LAST("n"),
        SOLD_LAST_SALE("o"),
        CANCEL_LAST_ETH("l"),
        SOLD_LAST_SALE_ETH("m"),
        CANCEL_STOPPED_ETH("j"),
        OUT_OF_SEQUENCE_ETH("k"),
        CANCEL_STOPPED("h"),
        CANCEL_ETH("i"),
        REOPEN("w"),
        AUTO_EXECUTION_ETH("v"),
        LATE_OPEN_ETH("u"),
        CANCEL_ONLY_ETH("t"),
        CANCEL_ONLY("s"),
        OPENED_SALE_ETH("r"),
        CANCEL_OPEN_ETH("q"),
        CANCEL_OPEN("p"),
        ADJUSTED_ETH("z"),
        ADJUSTED("y"),
        REOPEN_ETH("x");

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
