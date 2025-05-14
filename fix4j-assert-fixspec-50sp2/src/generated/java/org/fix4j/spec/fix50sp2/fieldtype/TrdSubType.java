package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TrdSubType extends BaseFieldType {
    public static final TrdSubType INSTANCE = new TrdSubType();

    private TrdSubType() {
        super(
            "TrdSubType",
            829,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field N_NONPROTECTED_PORTFOLIO_TRANSACTION_OR_A_FULLY_DISCLOSED_PORTFO = new Field(TrdSubType.INSTANCE, Values.N_NONPROTECTED_PORTFOLIO_TRANSACTION_OR_A_FULLY_DISCLOSED_PORTFO.getOrdinal());
        public final Field OTC_QUOTE = new Field(TrdSubType.INSTANCE, Values.OTC_QUOTE.getOrdinal());
        public final Field LC_CORRECTION_SUBMITTED_MORE_THAN_THREE_DAYS_AFTER_PUBLICATION_O = new Field(TrdSubType.INSTANCE, Values.LC_CORRECTION_SUBMITTED_MORE_THAN_THREE_DAYS_AFTER_PUBLICATION_O.getOrdinal());
        public final Field CONVERTED_SWAP = new Field(TrdSubType.INSTANCE, Values.CONVERTED_SWAP.getOrdinal());
        public final Field M_TRANSACTION_OTHER_THAN_A_TRANSACTION_RESULTING_FROM_A_STOCK_SW = new Field(TrdSubType.INSTANCE, Values.M_TRANSACTION_OTHER_THAN_A_TRANSACTION_RESULTING_FROM_A_STOCK_SW.getOrdinal());
        public final Field OFF_HOURS_TRADE = new Field(TrdSubType.INSTANCE, Values.OFF_HOURS_TRADE.getOrdinal());
        public final Field B_TRANSACTION_BETWEEN_TWO_MEMBER_FIRMS_WHERE_NEITHER_MEMBER_FIRM = new Field(TrdSubType.INSTANCE, Values.B_TRANSACTION_BETWEEN_TWO_MEMBER_FIRMS_WHERE_NEITHER_MEMBER_FIRM.getOrdinal());
        public final Field ON_HOURS_TRADE = new Field(TrdSubType.INSTANCE, Values.ON_HOURS_TRADE.getOrdinal());
        public final Field K_TRANSACTION_USING_BLOCK_TRADE_FACILITY = new Field(TrdSubType.INSTANCE, Values.K_TRANSACTION_USING_BLOCK_TRADE_FACILITY.getOrdinal());
        public final Field LARGE_IN_SCALE_L = new Field(TrdSubType.INSTANCE, Values.LARGE_IN_SCALE_L.getOrdinal());
        public final Field AI_AUTOMATED_INPUT_FACILITY_DISABLED_IN_RESPONSE_TO_AN_EXCHANGE_ = new Field(TrdSubType.INSTANCE, Values.AI_AUTOMATED_INPUT_FACILITY_DISABLED_IN_RESPONSE_TO_AN_EXCHANGE_.getOrdinal());
        public final Field CROSSED_TRADE_X = new Field(TrdSubType.INSTANCE, Values.CROSSED_TRADE_X.getOrdinal());
        public final Field ACATS = new Field(TrdSubType.INSTANCE, Values.ACATS.getOrdinal());
        public final Field INTERIM_PROTECTED_TRADE_I = new Field(TrdSubType.INSTANCE, Values.INTERIM_PROTECTED_TRADE_I.getOrdinal());
        public final Field NR_NONRISK_TRANSACTION_IN_A_SEATS_SECURITY_OTHER_THAN_AN_AIM_SEC = new Field(TrdSubType.INSTANCE, Values.NR_NONRISK_TRANSACTION_IN_A_SEATS_SECURITY_OTHER_THAN_AN_AIM_SEC.getOrdinal());
        public final Field NM__I_TRANSACTION_WHERE_EXCHANGE_HAS_GRANTED_PERMISSION_FOR_NONP = new Field(TrdSubType.INSTANCE, Values.NM__I_TRANSACTION_WHERE_EXCHANGE_HAS_GRANTED_PERMISSION_FOR_NONP.getOrdinal());
        public final Field P_PROTECTED_PORTFOLIO_TRANSACTION_OR_A_WORKED_PRINCIPAL_AGREEMEN = new Field(TrdSubType.INSTANCE, Values.P_PROTECTED_PORTFOLIO_TRANSACTION_OR_A_WORKED_PRINCIPAL_AGREEMEN.getOrdinal());
        public final Field PA_PROTECTED_TRANSACTION_NOTIFICATION = new Field(TrdSubType.INSTANCE, Values.PA_PROTECTED_TRANSACTION_NOTIFICATION.getOrdinal());
        public final Field PC_CONTRA_TRADE_FOR_TRANSACTION_WHICH_TOOK_PLACE_ON_A_PREVIOUS_D = new Field(TrdSubType.INSTANCE, Values.PC_CONTRA_TRADE_FOR_TRANSACTION_WHICH_TOOK_PLACE_ON_A_PREVIOUS_D.getOrdinal());
        public final Field PN_WORKED_PRINCIPAL_NOTIFICATION_FOR_A_PORTFOLIO_TRANSACTION_WHI = new Field(TrdSubType.INSTANCE, Values.PN_WORKED_PRINCIPAL_NOTIFICATION_FOR_A_PORTFOLIO_TRANSACTION_WHI.getOrdinal());
        public final Field R__I_RISKLESS_PRINCIPAL_TRANSACTION_BETWEEN_NONMEMBERS_WHERE_THE = new Field(TrdSubType.INSTANCE, Values.R__I_RISKLESS_PRINCIPAL_TRANSACTION_BETWEEN_NONMEMBERS_WHERE_THE.getOrdinal());
        public final Field RO_TRANSACTION_WHICH_RESULTED_FROM_THE_EXERCISE_OF_A_TRADITIONAL = new Field(TrdSubType.INSTANCE, Values.RO_TRANSACTION_WHICH_RESULTED_FROM_THE_EXERCISE_OF_A_TRADITIONAL.getOrdinal());
        public final Field RT_RISK_TRANSACTION_IN_A_SEATS_SECURITY_EXCLUDING_AIM_SECURITY_R = new Field(TrdSubType.INSTANCE, Values.RT_RISK_TRANSACTION_IN_A_SEATS_SECURITY_EXCLUDING_AIM_SECURITY_R.getOrdinal());
        public final Field SW_TRANSACTIONS_RESULTING_FROM_STOCK_SWAP_OR_A_STOCK_SWITCH_ONE_ = new Field(TrdSubType.INSTANCE, Values.SW_TRANSACTIONS_RESULTING_FROM_STOCK_SWAP_OR_A_STOCK_SWITCH_ONE_.getOrdinal());
        public final Field REJECT_FOR_SUBMITTING_SIDE = new Field(TrdSubType.INSTANCE, Values.REJECT_FOR_SUBMITTING_SIDE.getOrdinal());
        public final Field EXTERNAL_TRANSFER_OR_TRANSFER_OF_ACCOUNT = new Field(TrdSubType.INSTANCE, Values.EXTERNAL_TRANSFER_OR_TRANSFER_OF_ACCOUNT.getOrdinal());
        public final Field TRANSACTION_FROM_ASSIGNMENT = new Field(TrdSubType.INSTANCE, Values.TRANSACTION_FROM_ASSIGNMENT.getOrdinal());
        public final Field INTERNAL_TRANSFER_OR_ADJUSTMENT = new Field(TrdSubType.INSTANCE, Values.INTERNAL_TRANSFER_OR_ADJUSTMENT.getOrdinal());
        public final Field CMTA = new Field(TrdSubType.INSTANCE, Values.CMTA.getOrdinal());
        public final Field T_IF_REPORTING_A_SINGLE_PROTECTED_TRANSACTION = new Field(TrdSubType.INSTANCE, Values.T_IF_REPORTING_A_SINGLE_PROTECTED_TRANSACTION.getOrdinal());
        public final Field DIFFERENTIAL_SPREAD = new Field(TrdSubType.INSTANCE, Values.DIFFERENTIAL_SPREAD.getOrdinal());
        public final Field ONSET_DUE_TO_AN_ALLOCATION = new Field(TrdSubType.INSTANCE, Values.ONSET_DUE_TO_AN_ALLOCATION.getOrdinal());
        public final Field WT_WORKED_PRINCIPAL_TRANSACTION_OTHER_THAN_A_PORTFOLIO_TRANSACTI = new Field(TrdSubType.INSTANCE, Values.WT_WORKED_PRINCIPAL_TRANSACTION_OTHER_THAN_A_PORTFOLIO_TRANSACTI.getOrdinal());
        public final Field OFFSET_DUE_TO_AN_ALLOCATION = new Field(TrdSubType.INSTANCE, Values.OFFSET_DUE_TO_AN_ALLOCATION.getOrdinal());
        public final Field WN_WORKED_PRINCIPAL_NOTIFICATION_FOR_A_SINGLE_ORDER_BOOK_SECURIT = new Field(TrdSubType.INSTANCE, Values.WN_WORKED_PRINCIPAL_NOTIFICATION_FOR_A_SINGLE_ORDER_BOOK_SECURIT.getOrdinal());
        public final Field ADVISORY_FOR_CONTRA_SIDE = new Field(TrdSubType.INSTANCE, Values.ADVISORY_FOR_CONTRA_SIDE.getOrdinal());
        public final Field TRANSACTION_FROM_EXERCISE = new Field(TrdSubType.INSTANCE, Values.TRANSACTION_FROM_EXERCISE.getOrdinal());
        public final Field IMPLIED_SPREAD_LEG_EXECUTED_AGAINST_AN_OUTRIGHT = new Field(TrdSubType.INSTANCE, Values.IMPLIED_SPREAD_LEG_EXECUTED_AGAINST_AN_OUTRIGHT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        N_NONPROTECTED_PORTFOLIO_TRANSACTION_OR_A_FULLY_DISCLOSED_PORTFO("19"),
        OTC_QUOTE("35"),
        LC_CORRECTION_SUBMITTED_MORE_THAN_THREE_DAYS_AFTER_PUBLICATION_O("17"),
        CONVERTED_SWAP("36"),
        M_TRANSACTION_OTHER_THAN_A_TRANSACTION_RESULTING_FROM_A_STOCK_SW("18"),
        OFF_HOURS_TRADE("33"),
        B_TRANSACTION_BETWEEN_TWO_MEMBER_FIRMS_WHERE_NEITHER_MEMBER_FIRM("15"),
        ON_HOURS_TRADE("34"),
        K_TRANSACTION_USING_BLOCK_TRADE_FACILITY("16"),
        LARGE_IN_SCALE_L("39"),
        AI_AUTOMATED_INPUT_FACILITY_DISABLED_IN_RESPONSE_TO_AN_EXCHANGE_("14"),
        CROSSED_TRADE_X("37"),
        ACATS("11"),
        INTERIM_PROTECTED_TRADE_I("38"),
        NR_NONRISK_TRANSACTION_IN_A_SEATS_SECURITY_OTHER_THAN_AN_AIM_SEC("21"),
        NM__I_TRANSACTION_WHERE_EXCHANGE_HAS_GRANTED_PERMISSION_FOR_NONP("20"),
        P_PROTECTED_PORTFOLIO_TRANSACTION_OR_A_WORKED_PRINCIPAL_AGREEMEN("22"),
        PA_PROTECTED_TRANSACTION_NOTIFICATION("23"),
        PC_CONTRA_TRADE_FOR_TRANSACTION_WHICH_TOOK_PLACE_ON_A_PREVIOUS_D("24"),
        PN_WORKED_PRINCIPAL_NOTIFICATION_FOR_A_PORTFOLIO_TRANSACTION_WHI("25"),
        R__I_RISKLESS_PRINCIPAL_TRANSACTION_BETWEEN_NONMEMBERS_WHERE_THE("26"),
        RO_TRANSACTION_WHICH_RESULTED_FROM_THE_EXERCISE_OF_A_TRADITIONAL("27"),
        RT_RISK_TRANSACTION_IN_A_SEATS_SECURITY_EXCLUDING_AIM_SECURITY_R("28"),
        SW_TRANSACTIONS_RESULTING_FROM_STOCK_SWAP_OR_A_STOCK_SWITCH_ONE_("29"),
        REJECT_FOR_SUBMITTING_SIDE("3"),
        EXTERNAL_TRANSFER_OR_TRANSFER_OF_ACCOUNT("2"),
        TRANSACTION_FROM_ASSIGNMENT("10"),
        INTERNAL_TRANSFER_OR_ADJUSTMENT("1"),
        CMTA("0"),
        T_IF_REPORTING_A_SINGLE_PROTECTED_TRANSACTION("30"),
        DIFFERENTIAL_SPREAD("7"),
        ONSET_DUE_TO_AN_ALLOCATION("6"),
        WT_WORKED_PRINCIPAL_TRANSACTION_OTHER_THAN_A_PORTFOLIO_TRANSACTI("32"),
        OFFSET_DUE_TO_AN_ALLOCATION("5"),
        WN_WORKED_PRINCIPAL_NOTIFICATION_FOR_A_SINGLE_ORDER_BOOK_SECURIT("31"),
        ADVISORY_FOR_CONTRA_SIDE("4"),
        TRANSACTION_FROM_EXERCISE("9"),
        IMPLIED_SPREAD_LEG_EXECUTED_AGAINST_AN_OUTRIGHT("8");

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
