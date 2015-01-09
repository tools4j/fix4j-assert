package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradeReportRejectReason extends BaseFieldType {
    public static final TradeReportRejectReason INSTANCE = new TradeReportRejectReason();

    private TradeReportRejectReason() {
        super(
            "TradeReportRejectReason",
            751,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field UNAUTHORIZED_TO_REPORT_TRADES = new Field(TradeReportRejectReason.INSTANCE, Values.UNAUTHORIZED_TO_REPORT_TRADES.getOrdinal());
        public final Field UNKNOWN_INSTRUMENT = new Field(TradeReportRejectReason.INSTANCE, Values.UNKNOWN_INSTRUMENT.getOrdinal());
        public final Field INVALID_PARTY_ONFORMATION = new Field(TradeReportRejectReason.INSTANCE, Values.INVALID_PARTY_ONFORMATION.getOrdinal());
        public final Field SUCCESSFUL_DEFAULT = new Field(TradeReportRejectReason.INSTANCE, Values.SUCCESSFUL_DEFAULT.getOrdinal());
        public final Field INVALID_TRADE_TYPE = new Field(TradeReportRejectReason.INSTANCE, Values.INVALID_TRADE_TYPE.getOrdinal());
        public final Field OTHER = new Field(TradeReportRejectReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        UNAUTHORIZED_TO_REPORT_TRADES("3"),
        UNKNOWN_INSTRUMENT("2"),
        INVALID_PARTY_ONFORMATION("1"),
        SUCCESSFUL_DEFAULT("0"),
        INVALID_TRADE_TYPE("4"),
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
