package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class BidTradeType extends BaseFieldType {
    public static final BidTradeType INSTANCE = new BidTradeType();

    private BidTradeType() {
        super(
            "BidTradeType",
            418,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field VWAP_GUARANTEE = new Field(BidTradeType.INSTANCE, Values.VWAP_GUARANTEE.getOrdinal());
        public final Field AGENCY = new Field(BidTradeType.INSTANCE, Values.AGENCY.getOrdinal());
        public final Field RISK_TRADE = new Field(BidTradeType.INSTANCE, Values.RISK_TRADE.getOrdinal());
        public final Field GUARANTEED_CLOSE = new Field(BidTradeType.INSTANCE, Values.GUARANTEED_CLOSE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        VWAP_GUARANTEE("G"),
        AGENCY("A"),
        RISK_TRADE("R"),
        GUARANTEED_CLOSE("J");

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
