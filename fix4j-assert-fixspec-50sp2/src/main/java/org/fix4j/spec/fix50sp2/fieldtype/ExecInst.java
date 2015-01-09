package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExecInst extends BaseFieldType {
    public static final ExecInst INSTANCE = new ExecInst();

    private ExecInst() {
        super(
            "ExecInst",
            18,
            FieldClassLookup.lookup("MULTIPLECHARVALUE"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field GO_ALONG = new Field(ExecInst.INSTANCE, Values.GO_ALONG.getOrdinal());
        public final Field WORK = new Field(ExecInst.INSTANCE, Values.WORK.getOrdinal());
        public final Field NOT_HELD = new Field(ExecInst.INSTANCE, Values.NOT_HELD.getOrdinal());
        public final Field STAY_ON_OFFER_SIDE = new Field(ExecInst.INSTANCE, Values.STAY_ON_OFFER_SIDE.getOrdinal());
        public final Field STRICT_SCALE = new Field(ExecInst.INSTANCE, Values.STRICT_SCALE.getOrdinal());
        public final Field PARTICIPANT_DONT_INITIATE = new Field(ExecInst.INSTANCE, Values.PARTICIPANT_DONT_INITIATE.getOrdinal());
        public final Field HELD = new Field(ExecInst.INSTANCE, Values.HELD.getOrdinal());
        public final Field OVER_THE_DAY = new Field(ExecInst.INSTANCE, Values.OVER_THE_DAY.getOrdinal());
        public final Field STAY_ON_BID_SIDE = new Field(ExecInst.INSTANCE, Values.STAY_ON_BID_SIDE.getOrdinal());
        public final Field TRY_TO_SCALE = new Field(ExecInst.INSTANCE, Values.TRY_TO_SCALE.getOrdinal());
        public final Field PERCENT_OF_VOLUME_INDICATES_THAT_THE_SENDER_DOES_NOT_WANT_TO_BE_ = new Field(ExecInst.INSTANCE, Values.PERCENT_OF_VOLUME_INDICATES_THAT_THE_SENDER_DOES_NOT_WANT_TO_BE_.getOrdinal());
        public final Field DO_NOT_INCREASE__DNI = new Field(ExecInst.INSTANCE, Values.DO_NOT_INCREASE__DNI.getOrdinal());
        public final Field DO_NOT_REDUCE__DNR = new Field(ExecInst.INSTANCE, Values.DO_NOT_REDUCE__DNR.getOrdinal());
        public final Field ALL_OR_NONE__AON = new Field(ExecInst.INSTANCE, Values.ALL_OR_NONE__AON.getOrdinal());
        public final Field NO_CROSS_CROSS_IS_FORBIDDEN = new Field(ExecInst.INSTANCE, Values.NO_CROSS_CROSS_IS_FORBIDDEN.getOrdinal());
        public final Field OK_TO_CROSS = new Field(ExecInst.INSTANCE, Values.OK_TO_CROSS.getOrdinal());
        public final Field CALL_FIRST = new Field(ExecInst.INSTANCE, Values.CALL_FIRST.getOrdinal());
        public final Field LAST_PEG_LAST_SALE = new Field(ExecInst.INSTANCE, Values.LAST_PEG_LAST_SALE.getOrdinal());
        public final Field MIDPRICE_PEG_MIDPRICE_OF_INSIDE_QUOTE = new Field(ExecInst.INSTANCE, Values.MIDPRICE_PEG_MIDPRICE_OF_INSIDE_QUOTE.getOrdinal());
        public final Field NONNEGOTIABLE = new Field(ExecInst.INSTANCE, Values.NONNEGOTIABLE.getOrdinal());
        public final Field OPENING_PEG = new Field(ExecInst.INSTANCE, Values.OPENING_PEG.getOrdinal());
        public final Field REINSTATE_ON_SYSTEM_FAILURE_MUTUALLY_EXCLUSIVE_WITH_Q_AND_L = new Field(ExecInst.INSTANCE, Values.REINSTATE_ON_SYSTEM_FAILURE_MUTUALLY_EXCLUSIVE_WITH_Q_AND_L.getOrdinal());
        public final Field INSTITUTIONS_ONLY = new Field(ExecInst.INSTANCE, Values.INSTITUTIONS_ONLY.getOrdinal());
        public final Field REINSTATE_ON_TRADING_HALT_MUTUALLY_EXCLUSIVE_WITH_K_AND_M = new Field(ExecInst.INSTANCE, Values.REINSTATE_ON_TRADING_HALT_MUTUALLY_EXCLUSIVE_WITH_K_AND_M.getOrdinal());
        public final Field CANCEL_ON_TRADING_HALT_MUTUALLY_EXCLUSIVE_WITH_J_AND_M = new Field(ExecInst.INSTANCE, Values.CANCEL_ON_TRADING_HALT_MUTUALLY_EXCLUSIVE_WITH_J_AND_M.getOrdinal());
        public final Field CUSTOMER_DISPLAY_INSTRUCTION_RULE_11AC114 = new Field(ExecInst.INSTANCE, Values.CUSTOMER_DISPLAY_INSTRUCTION_RULE_11AC114.getOrdinal());
        public final Field FIXED_PEG_TO_LOCAL_BEST_BID_OR_OFFER_AT_TIME_OF_ORDER = new Field(ExecInst.INSTANCE, Values.FIXED_PEG_TO_LOCAL_BEST_BID_OR_OFFER_AT_TIME_OF_ORDER.getOrdinal());
        public final Field PEG_TO_VWAP = new Field(ExecInst.INSTANCE, Values.PEG_TO_VWAP.getOrdinal());
        public final Field NETTING_FOR_FOREX = new Field(ExecInst.INSTANCE, Values.NETTING_FOR_FOREX.getOrdinal());
        public final Field CANCEL_ON_SYSTEM_FAILURE_MUTUALLY_EXCLUSIVE_WITH_H_AND_L = new Field(ExecInst.INSTANCE, Values.CANCEL_ON_SYSTEM_FAILURE_MUTUALLY_EXCLUSIVE_WITH_H_AND_L.getOrdinal());
        public final Field MARKET_PEG = new Field(ExecInst.INSTANCE, Values.MARKET_PEG.getOrdinal());
        public final Field SUSPEND = new Field(ExecInst.INSTANCE, Values.SUSPEND.getOrdinal());
        public final Field PRIMARY_PEG_PRIMARY_MARKET__BUY_AT_BIDSELL_AT_OFFER = new Field(ExecInst.INSTANCE, Values.PRIMARY_PEG_PRIMARY_MARKET__BUY_AT_BIDSELL_AT_OFFER.getOrdinal());
        public final Field TRY_TO_STOP = new Field(ExecInst.INSTANCE, Values.TRY_TO_STOP.getOrdinal());
        public final Field TRADE_ALONG = new Field(ExecInst.INSTANCE, Values.TRADE_ALONG.getOrdinal());
        public final Field CANCEL_IF_NOT_BEST = new Field(ExecInst.INSTANCE, Values.CANCEL_IF_NOT_BEST.getOrdinal());
        public final Field INTERMARKET_SWEEP = new Field(ExecInst.INSTANCE, Values.INTERMARKET_SWEEP.getOrdinal());
        public final Field EXTERNAL_ROUTING_ALLOWED = new Field(ExecInst.INSTANCE, Values.EXTERNAL_ROUTING_ALLOWED.getOrdinal());
        public final Field PEG_TO_LIMIT_PRICE = new Field(ExecInst.INSTANCE, Values.PEG_TO_LIMIT_PRICE.getOrdinal());
        public final Field WORK_TO_TARGET_STRATEGY = new Field(ExecInst.INSTANCE, Values.WORK_TO_TARGET_STRATEGY.getOrdinal());
        public final Field STRICT_LIMIT_NO_PRICE_IMPROVEMENT = new Field(ExecInst.INSTANCE, Values.STRICT_LIMIT_NO_PRICE_IMPROVEMENT.getOrdinal());
        public final Field IGNORE_PRICE_VALIDITY_CHECKS = new Field(ExecInst.INSTANCE, Values.IGNORE_PRICE_VALIDITY_CHECKS.getOrdinal());
        public final Field TRAILING_STOP_PEG = new Field(ExecInst.INSTANCE, Values.TRAILING_STOP_PEG.getOrdinal());
        public final Field REINSTATE_ON_CONNECTION_LOSS_MUTUALLY_EXCLUSIVE_WITH_O_AND_P = new Field(ExecInst.INSTANCE, Values.REINSTATE_ON_CONNECTION_LOSS_MUTUALLY_EXCLUSIVE_WITH_O_AND_P.getOrdinal());
        public final Field CANCEL_ON_CONNECTION_LOSS_MUTUALLY_EXCLUSIVE_WITH_N_AND_P = new Field(ExecInst.INSTANCE, Values.CANCEL_ON_CONNECTION_LOSS_MUTUALLY_EXCLUSIVE_WITH_N_AND_P.getOrdinal());
        public final Field SUSPEND_ON_SYSTEM_FAILURE_MUTUALLY_EXCLUSIVE_WITH_H_AND_Q = new Field(ExecInst.INSTANCE, Values.SUSPEND_ON_SYSTEM_FAILURE_MUTUALLY_EXCLUSIVE_WITH_H_AND_Q.getOrdinal());
        public final Field SUSPEND_ON_TRADING_HALT_MUTUALLY_EXCLUSIVE_WITH_J_AND_K = new Field(ExecInst.INSTANCE, Values.SUSPEND_ON_TRADING_HALT_MUTUALLY_EXCLUSIVE_WITH_J_AND_K.getOrdinal());
        public final Field SINGLE_EXECUTION_REQUESTED_FOR_BLOCK_TRADE = new Field(ExecInst.INSTANCE, Values.SINGLE_EXECUTION_REQUESTED_FOR_BLOCK_TRADE.getOrdinal());
        public final Field BEST_EXECUTION = new Field(ExecInst.INSTANCE, Values.BEST_EXECUTION.getOrdinal());
        public final Field EXTERNAL_ROUTING_NOT_ALLOWED = new Field(ExecInst.INSTANCE, Values.EXTERNAL_ROUTING_NOT_ALLOWED.getOrdinal());
        public final Field IMBALANCE_ONLY = new Field(ExecInst.INSTANCE, Values.IMBALANCE_ONLY.getOrdinal());
        public final Field EXECUTE_AS_FX_NEUTRAL = new Field(ExecInst.INSTANCE, Values.EXECUTE_AS_FX_NEUTRAL.getOrdinal());
        public final Field EXECUTE_AS_DURATION_NEUTRAL = new Field(ExecInst.INSTANCE, Values.EXECUTE_AS_DURATION_NEUTRAL.getOrdinal());
        public final Field EXECUTE_AS_DELTA_NEUTRAL_USING_VOLATILITY_PROVIDED = new Field(ExecInst.INSTANCE, Values.EXECUTE_AS_DELTA_NEUTRAL_USING_VOLATILITY_PROVIDED.getOrdinal());
        public final Field RELEASE_FROM_SUSPENSION_MUTUALLY_EXCLUSIVE_WITH_S = new Field(ExecInst.INSTANCE, Values.RELEASE_FROM_SUSPENSION_MUTUALLY_EXCLUSIVE_WITH_S.getOrdinal());
        public final Field SUSPEND_ON_CONNECTION_LOSS_MUTUALLY_EXCLUSIVE_WITH_N_AND_O = new Field(ExecInst.INSTANCE, Values.SUSPEND_ON_CONNECTION_LOSS_MUTUALLY_EXCLUSIVE_WITH_N_AND_O.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        GO_ALONG("3"),
        WORK("2"),
        NOT_HELD("1"),
        STAY_ON_OFFER_SIDE("0"),
        STRICT_SCALE("7"),
        PARTICIPANT_DONT_INITIATE("6"),
        HELD("5"),
        OVER_THE_DAY("4"),
        STAY_ON_BID_SIDE("9"),
        TRY_TO_SCALE("8"),
        PERCENT_OF_VOLUME_INDICATES_THAT_THE_SENDER_DOES_NOT_WANT_TO_BE_("D"),
        DO_NOT_INCREASE__DNI("E"),
        DO_NOT_REDUCE__DNR("F"),
        ALL_OR_NONE__AON("G"),
        NO_CROSS_CROSS_IS_FORBIDDEN("A"),
        OK_TO_CROSS("B"),
        CALL_FIRST("C"),
        LAST_PEG_LAST_SALE("L"),
        MIDPRICE_PEG_MIDPRICE_OF_INSIDE_QUOTE("M"),
        NONNEGOTIABLE("N"),
        OPENING_PEG("O"),
        REINSTATE_ON_SYSTEM_FAILURE_MUTUALLY_EXCLUSIVE_WITH_Q_AND_L("H"),
        INSTITUTIONS_ONLY("I"),
        REINSTATE_ON_TRADING_HALT_MUTUALLY_EXCLUSIVE_WITH_K_AND_M("J"),
        CANCEL_ON_TRADING_HALT_MUTUALLY_EXCLUSIVE_WITH_J_AND_M("K"),
        CUSTOMER_DISPLAY_INSTRUCTION_RULE_11AC114("U"),
        FIXED_PEG_TO_LOCAL_BEST_BID_OR_OFFER_AT_TIME_OF_ORDER("T"),
        PEG_TO_VWAP("W"),
        NETTING_FOR_FOREX("V"),
        CANCEL_ON_SYSTEM_FAILURE_MUTUALLY_EXCLUSIVE_WITH_H_AND_L("Q"),
        MARKET_PEG("P"),
        SUSPEND("S"),
        PRIMARY_PEG_PRIMARY_MARKET__BUY_AT_BIDSELL_AT_OFFER("R"),
        TRY_TO_STOP("Y"),
        TRADE_ALONG("X"),
        CANCEL_IF_NOT_BEST("Z"),
        INTERMARKET_SWEEP("f"),
        EXTERNAL_ROUTING_ALLOWED("g"),
        PEG_TO_LIMIT_PRICE("d"),
        WORK_TO_TARGET_STRATEGY("e"),
        STRICT_LIMIT_NO_PRICE_IMPROVEMENT("b"),
        IGNORE_PRICE_VALIDITY_CHECKS("c"),
        TRAILING_STOP_PEG("a"),
        REINSTATE_ON_CONNECTION_LOSS_MUTUALLY_EXCLUSIVE_WITH_O_AND_P("n"),
        CANCEL_ON_CONNECTION_LOSS_MUTUALLY_EXCLUSIVE_WITH_N_AND_P("o"),
        SUSPEND_ON_SYSTEM_FAILURE_MUTUALLY_EXCLUSIVE_WITH_H_AND_Q("l"),
        SUSPEND_ON_TRADING_HALT_MUTUALLY_EXCLUSIVE_WITH_J_AND_K("m"),
        SINGLE_EXECUTION_REQUESTED_FOR_BLOCK_TRADE("j"),
        BEST_EXECUTION("k"),
        EXTERNAL_ROUTING_NOT_ALLOWED("h"),
        IMBALANCE_ONLY("i"),
        EXECUTE_AS_FX_NEUTRAL("t"),
        EXECUTE_AS_DURATION_NEUTRAL("s"),
        EXECUTE_AS_DELTA_NEUTRAL_USING_VOLATILITY_PROVIDED("r"),
        RELEASE_FROM_SUSPENSION_MUTUALLY_EXCLUSIVE_WITH_S("q"),
        SUSPEND_ON_CONNECTION_LOSS_MUTUALLY_EXCLUSIVE_WITH_N_AND_O("p");

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
