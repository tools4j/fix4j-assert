package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DiscretionInst extends BaseFieldType {
    public static final DiscretionInst INSTANCE = new DiscretionInst();

    private DiscretionInst() {
        super(
            "DiscretionInst",
            388,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field RELATED_TO_LOCAL_PRIMARY_PRICE = new Field(DiscretionInst.INSTANCE, Values.RELATED_TO_LOCAL_PRIMARY_PRICE.getOrdinal());
        public final Field RELATED_TO_PRIMARY_PRICE = new Field(DiscretionInst.INSTANCE, Values.RELATED_TO_PRIMARY_PRICE.getOrdinal());
        public final Field RELATED_TO_MARKET_PRICE = new Field(DiscretionInst.INSTANCE, Values.RELATED_TO_MARKET_PRICE.getOrdinal());
        public final Field RELATED_TO_DISPLAYED_PRICE = new Field(DiscretionInst.INSTANCE, Values.RELATED_TO_DISPLAYED_PRICE.getOrdinal());
        public final Field AVERAGE_PRICE_GUARANTEE = new Field(DiscretionInst.INSTANCE, Values.AVERAGE_PRICE_GUARANTEE.getOrdinal());
        public final Field RELATED_TO_VWAP = new Field(DiscretionInst.INSTANCE, Values.RELATED_TO_VWAP.getOrdinal());
        public final Field RELATED_TO_LAST_TRADE_PRICE = new Field(DiscretionInst.INSTANCE, Values.RELATED_TO_LAST_TRADE_PRICE.getOrdinal());
        public final Field RELATED_TO_MIDPOINT_PRICE = new Field(DiscretionInst.INSTANCE, Values.RELATED_TO_MIDPOINT_PRICE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        RELATED_TO_LOCAL_PRIMARY_PRICE("3"),
        RELATED_TO_PRIMARY_PRICE("2"),
        RELATED_TO_MARKET_PRICE("1"),
        RELATED_TO_DISPLAYED_PRICE("0"),
        AVERAGE_PRICE_GUARANTEE("7"),
        RELATED_TO_VWAP("6"),
        RELATED_TO_LAST_TRADE_PRICE("5"),
        RELATED_TO_MIDPOINT_PRICE("4");

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
