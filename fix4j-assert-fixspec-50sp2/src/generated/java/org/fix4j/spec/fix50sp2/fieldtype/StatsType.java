package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StatsType extends BaseFieldType {
    public static final StatsType INSTANCE = new StatsType();

    private StatsType() {
        super(
            "StatsType",
            1176,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field AVERAGE_PRICE_VWAP_TWAP__ = new Field(StatsType.INSTANCE, Values.AVERAGE_PRICE_VWAP_TWAP__.getOrdinal());
        public final Field HIGH__LOW_PRICE = new Field(StatsType.INSTANCE, Values.HIGH__LOW_PRICE.getOrdinal());
        public final Field EXCHANGE_LAST = new Field(StatsType.INSTANCE, Values.EXCHANGE_LAST.getOrdinal());
        public final Field TURNOVER_PRICE__QTY = new Field(StatsType.INSTANCE, Values.TURNOVER_PRICE__QTY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        AVERAGE_PRICE_VWAP_TWAP__("3"),
        HIGH__LOW_PRICE("2"),
        EXCHANGE_LAST("1"),
        TURNOVER_PRICE__QTY("4");

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
