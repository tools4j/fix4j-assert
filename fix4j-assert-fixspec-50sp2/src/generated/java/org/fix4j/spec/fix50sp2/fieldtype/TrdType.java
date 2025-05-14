package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TrdType extends BaseFieldType {
    public static final TrdType INSTANCE = new TrdType();

    private TrdType() {
        super(
            "TrdType",
            828,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SPECIAL_EX_CAPITAL_REPAYMENTS_XP = new Field(TrdType.INSTANCE, Values.SPECIAL_EX_CAPITAL_REPAYMENTS_XP.getOrdinal());
        public final Field SPECIAL_CUM_BONUS_CB = new Field(TrdType.INSTANCE, Values.SPECIAL_CUM_BONUS_CB.getOrdinal());
        public final Field SPECIAL_EX_RIGHTS_XR = new Field(TrdType.INSTANCE, Values.SPECIAL_EX_RIGHTS_XR.getOrdinal());
        public final Field SPECIAL_CUM_CAPITAL_REPAYMENTS_CP = new Field(TrdType.INSTANCE, Values.SPECIAL_CUM_CAPITAL_REPAYMENTS_CP.getOrdinal());
        public final Field WORKED_PRINCIPAL_TRADE_UKSPECIFIC = new Field(TrdType.INSTANCE, Values.WORKED_PRINCIPAL_TRADE_UKSPECIFIC.getOrdinal());
        public final Field SPECIAL_EX_BONUS_XB = new Field(TrdType.INSTANCE, Values.SPECIAL_EX_BONUS_XB.getOrdinal());
        public final Field BLOCK_TRADE_SAME_AS_LARGE_TRADE = new Field(TrdType.INSTANCE, Values.BLOCK_TRADE_SAME_AS_LARGE_TRADE.getOrdinal());
        public final Field PROROGATION_BUY__EURONEXT_PARIS_ONLY_IS_USED_TO_DEFER_SETTLEMENT = new Field(TrdType.INSTANCE, Values.PROROGATION_BUY__EURONEXT_PARIS_ONLY_IS_USED_TO_DEFER_SETTLEMENT.getOrdinal());
        public final Field PORTFOLIO_TRANSFER = new Field(TrdType.INSTANCE, Values.PORTFOLIO_TRANSFER.getOrdinal());
        public final Field NAME_CHANGE = new Field(TrdType.INSTANCE, Values.NAME_CHANGE.getOrdinal());
        public final Field BLOCK_TRADES__AFTER_MARKET = new Field(TrdType.INSTANCE, Values.BLOCK_TRADES__AFTER_MARKET.getOrdinal());
        public final Field PRIVATELY_NEGOTIATED_TRADES = new Field(TrdType.INSTANCE, Values.PRIVATELY_NEGOTIATED_TRADES.getOrdinal());
        public final Field SUBSTITUTION_OF_FUTURES_FOR_FORWARDS = new Field(TrdType.INSTANCE, Values.SUBSTITUTION_OF_FUTURES_FOR_FORWARDS.getOrdinal());
        public final Field ERROR_TRADE = new Field(TrdType.INSTANCE, Values.ERROR_TRADE.getOrdinal());
        public final Field SPECIAL_CUM_DIVIDEND_CD = new Field(TrdType.INSTANCE, Values.SPECIAL_CUM_DIVIDEND_CD.getOrdinal());
        public final Field SPECIAL_EX_DIVIDEND_XD = new Field(TrdType.INSTANCE, Values.SPECIAL_EX_DIVIDEND_XD.getOrdinal());
        public final Field SPECIAL_CUM_COUPON_CC = new Field(TrdType.INSTANCE, Values.SPECIAL_CUM_COUPON_CC.getOrdinal());
        public final Field SPECIAL_EX_COUPON_XC = new Field(TrdType.INSTANCE, Values.SPECIAL_EX_COUPON_XC.getOrdinal());
        public final Field CASH_SETTLEMENT_CS = new Field(TrdType.INSTANCE, Values.CASH_SETTLEMENT_CS.getOrdinal());
        public final Field TRANSFER = new Field(TrdType.INSTANCE, Values.TRANSFER.getOrdinal());
        public final Field EFP_EXCHANGE_FOR_PHYSICAL = new Field(TrdType.INSTANCE, Values.EFP_EXCHANGE_FOR_PHYSICAL.getOrdinal());
        public final Field BLOCK_TRADE = new Field(TrdType.INSTANCE, Values.BLOCK_TRADE.getOrdinal());
        public final Field REGULAR_TRADE = new Field(TrdType.INSTANCE, Values.REGULAR_TRADE.getOrdinal());
        public final Field BUNCHED_TRADE = new Field(TrdType.INSTANCE, Values.BUNCHED_TRADE.getOrdinal());
        public final Field SPECIAL_PRICE_USUALLY_NET_OR_ALLIN_PRICE_SP = new Field(TrdType.INSTANCE, Values.SPECIAL_PRICE_USUALLY_NET_OR_ALLIN_PRICE_SP.getOrdinal());
        public final Field WEIGHTED_AVERAGE_PRICE_TRADE = new Field(TrdType.INSTANCE, Values.WEIGHTED_AVERAGE_PRICE_TRADE.getOrdinal());
        public final Field T_TRADE = new Field(TrdType.INSTANCE, Values.T_TRADE.getOrdinal());
        public final Field SPECIAL_CUM_RIGHTS_CR = new Field(TrdType.INSTANCE, Values.SPECIAL_CUM_RIGHTS_CR.getOrdinal());
        public final Field LATE_TRADE = new Field(TrdType.INSTANCE, Values.LATE_TRADE.getOrdinal());
        public final Field GUARANTEED_DELIVERY_GD = new Field(TrdType.INSTANCE, Values.GUARANTEED_DELIVERY_GD.getOrdinal());
        public final Field PRIOR_REFERENCE_PRICE_TRADE = new Field(TrdType.INSTANCE, Values.PRIOR_REFERENCE_PRICE_TRADE.getOrdinal());
        public final Field LATE_BUNCHED_TRADE = new Field(TrdType.INSTANCE, Values.LATE_BUNCHED_TRADE.getOrdinal());
        public final Field OPTION_INTERIM_TRADE = new Field(TrdType.INSTANCE, Values.OPTION_INTERIM_TRADE.getOrdinal());
        public final Field EXCHANGE_BASIS_FACILITY_EBF = new Field(TrdType.INSTANCE, Values.EXCHANGE_BASIS_FACILITY_EBF.getOrdinal());
        public final Field FUTURES_LARGE_ORDER_EXECUTION = new Field(TrdType.INSTANCE, Values.FUTURES_LARGE_ORDER_EXECUTION.getOrdinal());
        public final Field EXCHANGE_OF_FUTURES_FOR_FUTURES_EXTERNAL_MARKET_EFF = new Field(TrdType.INSTANCE, Values.EXCHANGE_OF_FUTURES_FOR_FUTURES_EXTERNAL_MARKET_EFF.getOrdinal());
        public final Field TRADING_AT_SETTLEMENT = new Field(TrdType.INSTANCE, Values.TRADING_AT_SETTLEMENT.getOrdinal());
        public final Field ALL_OR_NONE = new Field(TrdType.INSTANCE, Values.ALL_OR_NONE.getOrdinal());
        public final Field EXCHANGE_OF_FUTURES_FOR_IN_MARKET_FUTURES_EFM__EG_FULL_SIZED_FOR = new Field(TrdType.INSTANCE, Values.EXCHANGE_OF_FUTURES_FOR_IN_MARKET_FUTURES_EFM__EG_FULL_SIZED_FOR.getOrdinal());
        public final Field EXCHANGE_OF_OPTIONS_FOR_OPTIONS_EOO = new Field(TrdType.INSTANCE, Values.EXCHANGE_OF_OPTIONS_FOR_OPTIONS_EOO.getOrdinal());
        public final Field EXCHANGE_FOR_RISK_EFR = new Field(TrdType.INSTANCE, Values.EXCHANGE_FOR_RISK_EFR.getOrdinal());
        public final Field EXCHANGE_FOR_SWAP_EFS_ = new Field(TrdType.INSTANCE, Values.EXCHANGE_FOR_SWAP_EFS_.getOrdinal());
        public final Field OPTION_CABINET_TRADE = new Field(TrdType.INSTANCE, Values.OPTION_CABINET_TRADE.getOrdinal());
        public final Field DERIVATIVE_RELATED_TRANSACTION = new Field(TrdType.INSTANCE, Values.DERIVATIVE_RELATED_TRANSACTION.getOrdinal());
        public final Field NONSTANDARD_SETTLEMENT = new Field(TrdType.INSTANCE, Values.NONSTANDARD_SETTLEMENT.getOrdinal());
        public final Field OPTION_EXERCISE = new Field(TrdType.INSTANCE, Values.OPTION_EXERCISE.getOrdinal());
        public final Field PROROGATION_SELL__SEE_PROROGATION_BUY = new Field(TrdType.INSTANCE, Values.PROROGATION_SELL__SEE_PROROGATION_BUY.getOrdinal());
        public final Field FINANCING_TRANSACTION_INCLUDES_REPO_AND_STOCK_LENDING = new Field(TrdType.INSTANCE, Values.FINANCING_TRANSACTION_INCLUDES_REPO_AND_STOCK_LENDING.getOrdinal());
        public final Field DELTA_NEUTRAL_TRANSACTION = new Field(TrdType.INSTANCE, Values.DELTA_NEUTRAL_TRANSACTION.getOrdinal());
        public final Field AFTER_HOURS_TRADE = new Field(TrdType.INSTANCE, Values.AFTER_HOURS_TRADE.getOrdinal());
        public final Field VOLUME_WEIGHTED_AVERAGE_TRADE = new Field(TrdType.INSTANCE, Values.VOLUME_WEIGHTED_AVERAGE_TRADE.getOrdinal());
        public final Field EXCHANGE_GRANTED_TRADE = new Field(TrdType.INSTANCE, Values.EXCHANGE_GRANTED_TRADE.getOrdinal());
        public final Field REPURCHASE_AGREEMENT = new Field(TrdType.INSTANCE, Values.REPURCHASE_AGREEMENT.getOrdinal());
        public final Field OTC = new Field(TrdType.INSTANCE, Values.OTC.getOrdinal());
        public final Field PORTFOLIO_TRADE = new Field(TrdType.INSTANCE, Values.PORTFOLIO_TRADE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SPECIAL_EX_CAPITAL_REPAYMENTS_XP("35"),
        SPECIAL_CUM_BONUS_CB("36"),
        SPECIAL_EX_RIGHTS_XR("33"),
        SPECIAL_CUM_CAPITAL_REPAYMENTS_CP("34"),
        WORKED_PRINCIPAL_TRADE_UKSPECIFIC("39"),
        SPECIAL_EX_BONUS_XB("37"),
        BLOCK_TRADE_SAME_AS_LARGE_TRADE("38"),
        PROROGATION_BUY__EURONEXT_PARIS_ONLY_IS_USED_TO_DEFER_SETTLEMENT("43"),
        PORTFOLIO_TRANSFER("42"),
        NAME_CHANGE("41"),
        BLOCK_TRADES__AFTER_MARKET("40"),
        PRIVATELY_NEGOTIATED_TRADES("22"),
        SUBSTITUTION_OF_FUTURES_FOR_FORWARDS("23"),
        ERROR_TRADE("24"),
        SPECIAL_CUM_DIVIDEND_CD("25"),
        SPECIAL_EX_DIVIDEND_XD("26"),
        SPECIAL_CUM_COUPON_CC("27"),
        SPECIAL_EX_COUPON_XC("28"),
        CASH_SETTLEMENT_CS("29"),
        TRANSFER("3"),
        EFP_EXCHANGE_FOR_PHYSICAL("2"),
        BLOCK_TRADE("1"),
        REGULAR_TRADE("0"),
        BUNCHED_TRADE("7"),
        SPECIAL_PRICE_USUALLY_NET_OR_ALLIN_PRICE_SP("30"),
        WEIGHTED_AVERAGE_PRICE_TRADE("6"),
        T_TRADE("5"),
        SPECIAL_CUM_RIGHTS_CR("32"),
        LATE_TRADE("4"),
        GUARANTEED_DELIVERY_GD("31"),
        PRIOR_REFERENCE_PRICE_TRADE("9"),
        LATE_BUNCHED_TRADE("8"),
        OPTION_INTERIM_TRADE("19"),
        EXCHANGE_BASIS_FACILITY_EBF("55"),
        FUTURES_LARGE_ORDER_EXECUTION("17"),
        EXCHANGE_OF_FUTURES_FOR_FUTURES_EXTERNAL_MARKET_EFF("18"),
        TRADING_AT_SETTLEMENT("15"),
        ALL_OR_NONE("16"),
        EXCHANGE_OF_FUTURES_FOR_IN_MARKET_FUTURES_EFM__EG_FULL_SIZED_FOR("13"),
        EXCHANGE_OF_OPTIONS_FOR_OPTIONS_EOO("14"),
        EXCHANGE_FOR_RISK_EFR("11"),
        EXCHANGE_FOR_SWAP_EFS_("12"),
        OPTION_CABINET_TRADE("20"),
        DERIVATIVE_RELATED_TRANSACTION("49"),
        NONSTANDARD_SETTLEMENT("48"),
        OPTION_EXERCISE("45"),
        PROROGATION_SELL__SEE_PROROGATION_BUY("44"),
        FINANCING_TRANSACTION_INCLUDES_REPO_AND_STOCK_LENDING("47"),
        DELTA_NEUTRAL_TRANSACTION("46"),
        AFTER_HOURS_TRADE("10"),
        VOLUME_WEIGHTED_AVERAGE_TRADE("51"),
        EXCHANGE_GRANTED_TRADE("52"),
        REPURCHASE_AGREEMENT("53"),
        OTC("54"),
        PORTFOLIO_TRADE("50");

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
