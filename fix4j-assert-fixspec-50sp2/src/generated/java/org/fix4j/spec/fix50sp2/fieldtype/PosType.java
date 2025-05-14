package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PosType extends BaseFieldType {
    public static final PosType INSTANCE = new PosType();

    private PosType() {
        super(
            "PosType",
            703,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NET_DELTA_QTY = new Field(PosType.INSTANCE, Values.NET_DELTA_QTY.getOrdinal());
        public final Field INTEGRAL_SPLIT = new Field(PosType.INSTANCE, Values.INTEGRAL_SPLIT.getOrdinal());
        public final Field DELIVERY_QTY = new Field(PosType.INSTANCE, Values.DELIVERY_QTY.getOrdinal());
        public final Field ASOF_TRADE_QTY = new Field(PosType.INSTANCE, Values.ASOF_TRADE_QTY.getOrdinal());
        public final Field CREDIT_EVENT_ADJUSTMENT = new Field(PosType.INSTANCE, Values.CREDIT_EVENT_ADJUSTMENT.getOrdinal());
        public final Field TRANSACTION_QUANTITY = new Field(PosType.INSTANCE, Values.TRANSACTION_QUANTITY.getOrdinal());
        public final Field TRANSFER_TRADE_QTY = new Field(PosType.INSTANCE, Values.TRANSFER_TRADE_QTY.getOrdinal());
        public final Field CROSS_MARGIN_QTY = new Field(PosType.INSTANCE, Values.CROSS_MARGIN_QTY.getOrdinal());
        public final Field CORPORATE_ACTION_ADJUSTMENT = new Field(PosType.INSTANCE, Values.CORPORATE_ACTION_ADJUSTMENT.getOrdinal());
        public final Field ELECTRONIC_TRADE_QTY = new Field(PosType.INSTANCE, Values.ELECTRONIC_TRADE_QTY.getOrdinal());
        public final Field DELIVERY_NOTICE_QTY = new Field(PosType.INSTANCE, Values.DELIVERY_NOTICE_QTY.getOrdinal());
        public final Field PIT_TRADE_QTY = new Field(PosType.INSTANCE, Values.PIT_TRADE_QTY.getOrdinal());
        public final Field PRIVATELY_NEGOTIATED_TRADE_QTY_NONREGULATED = new Field(PosType.INSTANCE, Values.PRIVATELY_NEGOTIATED_TRADE_QTY_NONREGULATED.getOrdinal());
        public final Field ALLOCATION_TRADE_QTY = new Field(PosType.INSTANCE, Values.ALLOCATION_TRADE_QTY.getOrdinal());
        public final Field ENDOFDAY_QTY = new Field(PosType.INSTANCE, Values.ENDOFDAY_QTY.getOrdinal());
        public final Field TRANSACTION_FROM_ASSIGNMENT = new Field(PosType.INSTANCE, Values.TRANSACTION_FROM_ASSIGNMENT.getOrdinal());
        public final Field OPTION_ASSIGNMENT = new Field(PosType.INSTANCE, Values.OPTION_ASSIGNMENT.getOrdinal());
        public final Field STARTOFDAY_QTY = new Field(PosType.INSTANCE, Values.STARTOFDAY_QTY.getOrdinal());
        public final Field OPTION_EXERCISE_QTY = new Field(PosType.INSTANCE, Values.OPTION_EXERCISE_QTY.getOrdinal());
        public final Field RECEIVE_QUANTITY = new Field(PosType.INSTANCE, Values.RECEIVE_QUANTITY.getOrdinal());
        public final Field EXCHANGE_FOR_PHYSICAL_QTY = new Field(PosType.INSTANCE, Values.EXCHANGE_FOR_PHYSICAL_QTY.getOrdinal());
        public final Field TOTAL_TRANSACTION_QTY = new Field(PosType.INSTANCE, Values.TOTAL_TRANSACTION_QTY.getOrdinal());
        public final Field SUCCESSION_EVENT_ADJUSTMENT = new Field(PosType.INSTANCE, Values.SUCCESSION_EVENT_ADJUSTMENT.getOrdinal());
        public final Field INTERSPREAD_QTY = new Field(PosType.INSTANCE, Values.INTERSPREAD_QTY.getOrdinal());
        public final Field TRANSACTION_FROM_EXERCISE = new Field(PosType.INSTANCE, Values.TRANSACTION_FROM_EXERCISE.getOrdinal());
        public final Field INTRASPREAD_QTY = new Field(PosType.INSTANCE, Values.INTRASPREAD_QTY.getOrdinal());
        public final Field ADJUSTMENT_QTY = new Field(PosType.INSTANCE, Values.ADJUSTMENT_QTY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NET_DELTA_QTY("DLT"),
        INTEGRAL_SPLIT("SPL"),
        DELIVERY_QTY("DLV"),
        ASOF_TRADE_QTY("ASF"),
        CREDIT_EVENT_ADJUSTMENT("CEA"),
        TRANSACTION_QUANTITY("TQ"),
        TRANSFER_TRADE_QTY("TRF"),
        CROSS_MARGIN_QTY("XM"),
        CORPORATE_ACTION_ADJUSTMENT("CAA"),
        ELECTRONIC_TRADE_QTY("ETR"),
        DELIVERY_NOTICE_QTY("DN"),
        PIT_TRADE_QTY("PIT"),
        PRIVATELY_NEGOTIATED_TRADE_QTY_NONREGULATED("PNTN"),
        ALLOCATION_TRADE_QTY("ALC"),
        ENDOFDAY_QTY("FIN"),
        TRANSACTION_FROM_ASSIGNMENT("TA"),
        OPTION_ASSIGNMENT("AS"),
        STARTOFDAY_QTY("SOD"),
        OPTION_EXERCISE_QTY("EX"),
        RECEIVE_QUANTITY("RCV"),
        EXCHANGE_FOR_PHYSICAL_QTY("EP"),
        TOTAL_TRANSACTION_QTY("TOT"),
        SUCCESSION_EVENT_ADJUSTMENT("SEA"),
        INTERSPREAD_QTY("IES"),
        TRANSACTION_FROM_EXERCISE("TX"),
        INTRASPREAD_QTY("IAS"),
        ADJUSTMENT_QTY("PA");

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
