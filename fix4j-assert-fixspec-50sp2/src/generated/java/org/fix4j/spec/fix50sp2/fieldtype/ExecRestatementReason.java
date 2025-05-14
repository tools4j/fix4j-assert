package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExecRestatementReason extends BaseFieldType {
    public static final ExecRestatementReason INSTANCE = new ExecRestatementReason();

    private ExecRestatementReason() {
        super(
            "ExecRestatementReason",
            378,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PEG_REFRESH = new Field(ExecRestatementReason.INSTANCE, Values.PEG_REFRESH.getOrdinal());
        public final Field REPRICING_OF_ORDER = new Field(ExecRestatementReason.INSTANCE, Values.REPRICING_OF_ORDER.getOrdinal());
        public final Field VERBAL_CHANGE = new Field(ExecRestatementReason.INSTANCE, Values.VERBAL_CHANGE.getOrdinal());
        public final Field GT_RENEWAL__RESTATEMENT_NO_CORPORATE_ACTION = new Field(ExecRestatementReason.INSTANCE, Values.GT_RENEWAL__RESTATEMENT_NO_CORPORATE_ACTION.getOrdinal());
        public final Field WAREHOUSE_RECAP = new Field(ExecRestatementReason.INSTANCE, Values.WAREHOUSE_RECAP.getOrdinal());
        public final Field GT_CORPORATE_ACTION = new Field(ExecRestatementReason.INSTANCE, Values.GT_CORPORATE_ACTION.getOrdinal());
        public final Field CANCEL_ON_SYSTEM_FAILURE = new Field(ExecRestatementReason.INSTANCE, Values.CANCEL_ON_SYSTEM_FAILURE.getOrdinal());
        public final Field CANCEL_ON_TRADING_HALT = new Field(ExecRestatementReason.INSTANCE, Values.CANCEL_ON_TRADING_HALT.getOrdinal());
        public final Field PARTIAL_DECLINE_OF_ORDERQTY_EG_EXCHANGE_INITIATED_PARTIAL_CANCEL = new Field(ExecRestatementReason.INSTANCE, Values.PARTIAL_DECLINE_OF_ORDERQTY_EG_EXCHANGE_INITIATED_PARTIAL_CANCEL.getOrdinal());
        public final Field BROKER_OPTION = new Field(ExecRestatementReason.INSTANCE, Values.BROKER_OPTION.getOrdinal());
        public final Field CANCELED_NOT_BEST = new Field(ExecRestatementReason.INSTANCE, Values.CANCELED_NOT_BEST.getOrdinal());
        public final Field MARKET_EXCHANGE_OPTION = new Field(ExecRestatementReason.INSTANCE, Values.MARKET_EXCHANGE_OPTION.getOrdinal());
        public final Field OTHER = new Field(ExecRestatementReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PEG_REFRESH("11"),
        REPRICING_OF_ORDER("3"),
        VERBAL_CHANGE("2"),
        GT_RENEWAL__RESTATEMENT_NO_CORPORATE_ACTION("1"),
        WAREHOUSE_RECAP("10"),
        GT_CORPORATE_ACTION("0"),
        CANCEL_ON_SYSTEM_FAILURE("7"),
        CANCEL_ON_TRADING_HALT("6"),
        PARTIAL_DECLINE_OF_ORDERQTY_EG_EXCHANGE_INITIATED_PARTIAL_CANCEL("5"),
        BROKER_OPTION("4"),
        CANCELED_NOT_BEST("9"),
        MARKET_EXCHANGE_OPTION("8"),
        OTHER("99");

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
