package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradeHandlingInstr extends BaseFieldType {
    public static final TradeHandlingInstr INSTANCE = new TradeHandlingInstr();

    private TradeHandlingInstr() {
        super(
            "TradeHandlingInstr",
            1123,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ONEPARTY_REPORT_FOR_PASS_THROUGH = new Field(TradeHandlingInstr.INSTANCE, Values.ONEPARTY_REPORT_FOR_PASS_THROUGH.getOrdinal());
        public final Field ONEPARTY_REPORT_FOR_MATCHING = new Field(TradeHandlingInstr.INSTANCE, Values.ONEPARTY_REPORT_FOR_MATCHING.getOrdinal());
        public final Field TWOPARTY_REPORT = new Field(TradeHandlingInstr.INSTANCE, Values.TWOPARTY_REPORT.getOrdinal());
        public final Field TRADE_CONFIRMATION = new Field(TradeHandlingInstr.INSTANCE, Values.TRADE_CONFIRMATION.getOrdinal());
        public final Field TWO_PARTY_REPORT_FOR_CLAIM = new Field(TradeHandlingInstr.INSTANCE, Values.TWO_PARTY_REPORT_FOR_CLAIM.getOrdinal());
        public final Field AUTOMATED_FLOOR_ORDER_ROUTING = new Field(TradeHandlingInstr.INSTANCE, Values.AUTOMATED_FLOOR_ORDER_ROUTING.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ONEPARTY_REPORT_FOR_PASS_THROUGH("3"),
        ONEPARTY_REPORT_FOR_MATCHING("2"),
        TWOPARTY_REPORT("1"),
        TRADE_CONFIRMATION("0"),
        TWO_PARTY_REPORT_FOR_CLAIM("5"),
        AUTOMATED_FLOOR_ORDER_ROUTING("4");

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
