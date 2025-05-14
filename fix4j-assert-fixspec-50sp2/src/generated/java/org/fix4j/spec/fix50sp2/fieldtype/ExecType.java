package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExecType extends BaseFieldType {
    public static final ExecType INSTANCE = new ExecType();

    private ExecType() {
        super(
            "ExecType",
            150,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field RESTATED_EXECUTION_REPORT_SENT_UNSOLICITED_BY_SELLSIDE_WITH_EXEC = new Field(ExecType.INSTANCE, Values.RESTATED_EXECUTION_REPORT_SENT_UNSOLICITED_BY_SELLSIDE_WITH_EXEC.getOrdinal());
        public final Field PENDING_REPLACE_EG_RESULT_OF_ORDER_CANCELREPLACE_REQUEST = new Field(ExecType.INSTANCE, Values.PENDING_REPLACE_EG_RESULT_OF_ORDER_CANCELREPLACE_REQUEST.getOrdinal());
        public final Field TRADE_PARTIAL_FILL_OR_FILL = new Field(ExecType.INSTANCE, Values.TRADE_PARTIAL_FILL_OR_FILL.getOrdinal());
        public final Field TRADE_CORRECT = new Field(ExecType.INSTANCE, Values.TRADE_CORRECT.getOrdinal());
        public final Field PENDING_NEW = new Field(ExecType.INSTANCE, Values.PENDING_NEW.getOrdinal());
        public final Field CALCULATED = new Field(ExecType.INSTANCE, Values.CALCULATED.getOrdinal());
        public final Field EXPIRED = new Field(ExecType.INSTANCE, Values.EXPIRED.getOrdinal());
        public final Field TRIGGERED_OR_ACTIVATED_BY_SYSTEM = new Field(ExecType.INSTANCE, Values.TRIGGERED_OR_ACTIVATED_BY_SYSTEM.getOrdinal());
        public final Field TRADE_CANCEL = new Field(ExecType.INSTANCE, Values.TRADE_CANCEL.getOrdinal());
        public final Field ORDER_STATUS = new Field(ExecType.INSTANCE, Values.ORDER_STATUS.getOrdinal());
        public final Field TRADE_IN_A_CLEARING_HOLD = new Field(ExecType.INSTANCE, Values.TRADE_IN_A_CLEARING_HOLD.getOrdinal());
        public final Field TRADE_HAS_BEEN_RELEASED_TO_CLEARING = new Field(ExecType.INSTANCE, Values.TRADE_HAS_BEEN_RELEASED_TO_CLEARING.getOrdinal());
        public final Field DONE_FOR_DAY = new Field(ExecType.INSTANCE, Values.DONE_FOR_DAY.getOrdinal());
        public final Field NEW = new Field(ExecType.INSTANCE, Values.NEW.getOrdinal());
        public final Field STOPPED = new Field(ExecType.INSTANCE, Values.STOPPED.getOrdinal());
        public final Field PENDING_CANCEL_EG_RESULT_OF_ORDER_CANCEL_REQUEST = new Field(ExecType.INSTANCE, Values.PENDING_CANCEL_EG_RESULT_OF_ORDER_CANCEL_REQUEST.getOrdinal());
        public final Field REPLACED = new Field(ExecType.INSTANCE, Values.REPLACED.getOrdinal());
        public final Field CANCELED = new Field(ExecType.INSTANCE, Values.CANCELED.getOrdinal());
        public final Field SUSPENDED = new Field(ExecType.INSTANCE, Values.SUSPENDED.getOrdinal());
        public final Field REJECTED = new Field(ExecType.INSTANCE, Values.REJECTED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        RESTATED_EXECUTION_REPORT_SENT_UNSOLICITED_BY_SELLSIDE_WITH_EXEC("D"),
        PENDING_REPLACE_EG_RESULT_OF_ORDER_CANCELREPLACE_REQUEST("E"),
        TRADE_PARTIAL_FILL_OR_FILL("F"),
        TRADE_CORRECT("G"),
        PENDING_NEW("A"),
        CALCULATED("B"),
        EXPIRED("C"),
        TRIGGERED_OR_ACTIVATED_BY_SYSTEM("L"),
        TRADE_CANCEL("H"),
        ORDER_STATUS("I"),
        TRADE_IN_A_CLEARING_HOLD("J"),
        TRADE_HAS_BEEN_RELEASED_TO_CLEARING("K"),
        DONE_FOR_DAY("3"),
        NEW("0"),
        STOPPED("7"),
        PENDING_CANCEL_EG_RESULT_OF_ORDER_CANCEL_REQUEST("6"),
        REPLACED("5"),
        CANCELED("4"),
        SUSPENDED("9"),
        REJECTED("8");

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
