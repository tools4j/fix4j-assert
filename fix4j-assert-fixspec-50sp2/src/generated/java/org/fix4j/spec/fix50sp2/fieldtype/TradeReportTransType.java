package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradeReportTransType extends BaseFieldType {
    public static final TradeReportTransType INSTANCE = new TradeReportTransType();

    private TradeReportTransType() {
        super(
            "TradeReportTransType",
            487,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field RELEASE = new Field(TradeReportTransType.INSTANCE, Values.RELEASE.getOrdinal());
        public final Field REPLACE = new Field(TradeReportTransType.INSTANCE, Values.REPLACE.getOrdinal());
        public final Field CANCEL = new Field(TradeReportTransType.INSTANCE, Values.CANCEL.getOrdinal());
        public final Field NEW = new Field(TradeReportTransType.INSTANCE, Values.NEW.getOrdinal());
        public final Field CANCEL_DUE_TO_BACK_OUT_OF_TRADE = new Field(TradeReportTransType.INSTANCE, Values.CANCEL_DUE_TO_BACK_OUT_OF_TRADE.getOrdinal());
        public final Field REVERSE = new Field(TradeReportTransType.INSTANCE, Values.REVERSE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        RELEASE("3"),
        REPLACE("2"),
        CANCEL("1"),
        NEW("0"),
        CANCEL_DUE_TO_BACK_OUT_OF_TRADE("5"),
        REVERSE("4");

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
