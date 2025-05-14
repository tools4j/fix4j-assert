package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PosAmtType extends BaseFieldType {
    public static final PosAmtType INSTANCE = new PosAmtType();

    private PosAmtType() {
        super(
            "PosAmtType",
            707,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INCREMENTAL_MARKTOMARKET_AMOUNT = new Field(PosAmtType.INSTANCE, Values.INCREMENTAL_MARKTOMARKET_AMOUNT.getOrdinal());
        public final Field INCREMENTAL_ACCRUED_COUPON = new Field(PosAmtType.INSTANCE, Values.INCREMENTAL_ACCRUED_COUPON.getOrdinal());
        public final Field COMPENSATION_AMOUNT = new Field(PosAmtType.INSTANCE, Values.COMPENSATION_AMOUNT.getOrdinal());
        public final Field COLLATERALIZED_MARK_TO_MARKET = new Field(PosAmtType.INSTANCE, Values.COLLATERALIZED_MARK_TO_MARKET.getOrdinal());
        public final Field TOTAL_COLLATERALIZED_AMOUNT = new Field(PosAmtType.INSTANCE, Values.TOTAL_COLLATERALIZED_AMOUNT.getOrdinal());
        public final Field COUPON_AMOUNT = new Field(PosAmtType.INSTANCE, Values.COUPON_AMOUNT.getOrdinal());
        public final Field INCREMENTAL_COLLATERALIZED_MARK_TO_MARKET = new Field(PosAmtType.INSTANCE, Values.INCREMENTAL_COLLATERALIZED_MARK_TO_MARKET.getOrdinal());
        public final Field PREMIUM_AMOUNT = new Field(PosAmtType.INSTANCE, Values.PREMIUM_AMOUNT.getOrdinal());
        public final Field FINAL_MARKTOMARKET_AMOUNT = new Field(PosAmtType.INSTANCE, Values.FINAL_MARKTOMARKET_AMOUNT.getOrdinal());
        public final Field CASH_AMOUNT_CORPORATE_EVENT = new Field(PosAmtType.INSTANCE, Values.CASH_AMOUNT_CORPORATE_EVENT.getOrdinal());
        public final Field CASH_RESIDUAL_AMOUNT = new Field(PosAmtType.INSTANCE, Values.CASH_RESIDUAL_AMOUNT.getOrdinal());
        public final Field ACCRUED_COUPON_AMOUNT = new Field(PosAmtType.INSTANCE, Values.ACCRUED_COUPON_AMOUNT.getOrdinal());
        public final Field TOTAL_BANKED_AMOUNT = new Field(PosAmtType.INSTANCE, Values.TOTAL_BANKED_AMOUNT.getOrdinal());
        public final Field VALUE_ADJUSTED_AMOUNT = new Field(PosAmtType.INSTANCE, Values.VALUE_ADJUSTED_AMOUNT.getOrdinal());
        public final Field TRADE_VARIATION_AMOUNT = new Field(PosAmtType.INSTANCE, Values.TRADE_VARIATION_AMOUNT.getOrdinal());
        public final Field SETTLEMENT_VALUE = new Field(PosAmtType.INSTANCE, Values.SETTLEMENT_VALUE.getOrdinal());
        public final Field STARTOFDAY_MARKTOMARKET_AMOUNT = new Field(PosAmtType.INSTANCE, Values.STARTOFDAY_MARKTOMARKET_AMOUNT.getOrdinal());
        public final Field INITIAL_TRADE_COUPON_AMOUNT = new Field(PosAmtType.INSTANCE, Values.INITIAL_TRADE_COUPON_AMOUNT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INCREMENTAL_MARKTOMARKET_AMOUNT("IMTM"),
        INCREMENTAL_ACCRUED_COUPON("IACPN"),
        COMPENSATION_AMOUNT("DLV"),
        COLLATERALIZED_MARK_TO_MARKET("CMTM"),
        TOTAL_COLLATERALIZED_AMOUNT("COLAT"),
        COUPON_AMOUNT("CPN"),
        INCREMENTAL_COLLATERALIZED_MARK_TO_MARKET("ICMTM"),
        PREMIUM_AMOUNT("PREM"),
        FINAL_MARKTOMARKET_AMOUNT("FMTM"),
        CASH_AMOUNT_CORPORATE_EVENT("CASH"),
        CASH_RESIDUAL_AMOUNT("CRES"),
        ACCRUED_COUPON_AMOUNT("ACPN"),
        TOTAL_BANKED_AMOUNT("BANK"),
        VALUE_ADJUSTED_AMOUNT("VADJ"),
        TRADE_VARIATION_AMOUNT("TVAR"),
        SETTLEMENT_VALUE("SETL"),
        STARTOFDAY_MARKTOMARKET_AMOUNT("SMTM"),
        INITIAL_TRADE_COUPON_AMOUNT("ICPN");

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
