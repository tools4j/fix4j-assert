package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradeReportType extends BaseFieldType {
    public static final TradeReportType INSTANCE = new TradeReportType();

    private TradeReportType() {
        super(
            "TradeReportType",
            856,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ALLEGED_LOCKEDIN_TRADE_BREAK = new Field(TradeReportType.INSTANCE, Values.ALLEGED_LOCKEDIN_TRADE_BREAK.getOrdinal());
        public final Field ALLEGED_NOWAS = new Field(TradeReportType.INSTANCE, Values.ALLEGED_NOWAS.getOrdinal());
        public final Field ALLEGED_TRADE_REPORT_CANCEL = new Field(TradeReportType.INSTANCE, Values.ALLEGED_TRADE_REPORT_CANCEL.getOrdinal());
        public final Field ALLEGED_NEW = new Field(TradeReportType.INSTANCE, Values.ALLEGED_NEW.getOrdinal());
        public final Field ALLEGED_ADDENDUM = new Field(TradeReportType.INSTANCE, Values.ALLEGED_ADDENDUM.getOrdinal());
        public final Field DECLINE = new Field(TradeReportType.INSTANCE, Values.DECLINE.getOrdinal());
        public final Field ACCEPT = new Field(TradeReportType.INSTANCE, Values.ACCEPT.getOrdinal());
        public final Field ALLEGED = new Field(TradeReportType.INSTANCE, Values.ALLEGED.getOrdinal());
        public final Field PENDED = new Field(TradeReportType.INSTANCE, Values.PENDED.getOrdinal());
        public final Field SUBMIT = new Field(TradeReportType.INSTANCE, Values.SUBMIT.getOrdinal());
        public final Field LOCKEDIN_TRADE_BREAK = new Field(TradeReportType.INSTANCE, Values.LOCKEDIN_TRADE_BREAK.getOrdinal());
        public final Field TRADE_REPORT_CANCEL = new Field(TradeReportType.INSTANCE, Values.TRADE_REPORT_CANCEL.getOrdinal());
        public final Field NOWAS = new Field(TradeReportType.INSTANCE, Values.NOWAS.getOrdinal());
        public final Field ADDENDUM = new Field(TradeReportType.INSTANCE, Values.ADDENDUM.getOrdinal());
        public final Field INVALID_CMTA = new Field(TradeReportType.INSTANCE, Values.INVALID_CMTA.getOrdinal());
        public final Field DEFAULTED = new Field(TradeReportType.INSTANCE, Values.DEFAULTED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ALLEGED_LOCKEDIN_TRADE_BREAK("15"),
        ALLEGED_NOWAS("13"),
        ALLEGED_TRADE_REPORT_CANCEL("14"),
        ALLEGED_NEW("11"),
        ALLEGED_ADDENDUM("12"),
        DECLINE("3"),
        ACCEPT("2"),
        ALLEGED("1"),
        PENDED("10"),
        SUBMIT("0"),
        LOCKEDIN_TRADE_BREAK("7"),
        TRADE_REPORT_CANCEL("6"),
        NOWAS("5"),
        ADDENDUM("4"),
        INVALID_CMTA("9"),
        DEFAULTED("8");

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
