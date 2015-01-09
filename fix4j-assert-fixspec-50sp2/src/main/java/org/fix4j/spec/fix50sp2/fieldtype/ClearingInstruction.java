package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ClearingInstruction extends BaseFieldType {
    public static final ClearingInstruction INSTANCE = new ClearingInstruction();

    private ClearingInstruction() {
        super(
            "ClearingInstruction",
            577,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SELF_CLEARING = new Field(ClearingInstruction.INSTANCE, Values.SELF_CLEARING.getOrdinal());
        public final Field QUALIFIED_SERVICE_REPRESENTATIVE_QSR = new Field(ClearingInstruction.INSTANCE, Values.QUALIFIED_SERVICE_REPRESENTATIVE_QSR.getOrdinal());
        public final Field CUSTOMER_TRADE = new Field(ClearingInstruction.INSTANCE, Values.CUSTOMER_TRADE.getOrdinal());
        public final Field EX_CLEARING = new Field(ClearingInstruction.INSTANCE, Values.EX_CLEARING.getOrdinal());
        public final Field BILATERAL_NETTING_ONLY = new Field(ClearingInstruction.INSTANCE, Values.BILATERAL_NETTING_ONLY.getOrdinal());
        public final Field EXCLUDE_FROM_ALL_NETTING = new Field(ClearingInstruction.INSTANCE, Values.EXCLUDE_FROM_ALL_NETTING.getOrdinal());
        public final Field AUTOMATIC_GIVEUP_MODE_TRADE_GIVEUP_TO_THE_GIVEUP_DESTINATION_NUM = new Field(ClearingInstruction.INSTANCE, Values.AUTOMATIC_GIVEUP_MODE_TRADE_GIVEUP_TO_THE_GIVEUP_DESTINATION_NUM.getOrdinal());
        public final Field PROCESS_NORMALLY = new Field(ClearingInstruction.INSTANCE, Values.PROCESS_NORMALLY.getOrdinal());
        public final Field EXCLUDE_FROM_CENTRAL_COUNTERPARTY = new Field(ClearingInstruction.INSTANCE, Values.EXCLUDE_FROM_CENTRAL_COUNTERPARTY.getOrdinal());
        public final Field CLEAR_AGAINST_CENTRAL_COUNTERPARTY = new Field(ClearingInstruction.INSTANCE, Values.CLEAR_AGAINST_CENTRAL_COUNTERPARTY.getOrdinal());
        public final Field MULTILATERAL_NETTING = new Field(ClearingInstruction.INSTANCE, Values.MULTILATERAL_NETTING.getOrdinal());
        public final Field SPECIAL_TRADE = new Field(ClearingInstruction.INSTANCE, Values.SPECIAL_TRADE.getOrdinal());
        public final Field AUTOMATIC_POSTING_MODE_TRADE_POSTING_TO_THE_POSITION_ACCOUNT_NUM = new Field(ClearingInstruction.INSTANCE, Values.AUTOMATIC_POSTING_MODE_TRADE_POSTING_TO_THE_POSITION_ACCOUNT_NUM.getOrdinal());
        public final Field MANUAL_MODE_PREPOSTING_ANDOR_PREGIVEUP = new Field(ClearingInstruction.INSTANCE, Values.MANUAL_MODE_PREPOSTING_ANDOR_PREGIVEUP.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SELF_CLEARING("13"),
        QUALIFIED_SERVICE_REPRESENTATIVE_QSR("11"),
        CUSTOMER_TRADE("12"),
        EX_CLEARING("3"),
        BILATERAL_NETTING_ONLY("2"),
        EXCLUDE_FROM_ALL_NETTING("1"),
        AUTOMATIC_GIVEUP_MODE_TRADE_GIVEUP_TO_THE_GIVEUP_DESTINATION_NUM("10"),
        PROCESS_NORMALLY("0"),
        EXCLUDE_FROM_CENTRAL_COUNTERPARTY("7"),
        CLEAR_AGAINST_CENTRAL_COUNTERPARTY("6"),
        MULTILATERAL_NETTING("5"),
        SPECIAL_TRADE("4"),
        AUTOMATIC_POSTING_MODE_TRADE_POSTING_TO_THE_POSITION_ACCOUNT_NUM("9"),
        MANUAL_MODE_PREPOSTING_ANDOR_PREGIVEUP("8");

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
