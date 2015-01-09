package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PegPriceType extends BaseFieldType {
    public static final PegPriceType INSTANCE = new PegPriceType();

    private PegPriceType() {
        super(
            "PegPriceType",
            1094,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field OPENING_PEG = new Field(PegPriceType.INSTANCE, Values.OPENING_PEG.getOrdinal());
        public final Field MIDPRICE_PEG_MIDPRICE_OF_INSIDE_QUOTE = new Field(PegPriceType.INSTANCE, Values.MIDPRICE_PEG_MIDPRICE_OF_INSIDE_QUOTE.getOrdinal());
        public final Field LAST_PEG_LAST_SALE = new Field(PegPriceType.INSTANCE, Values.LAST_PEG_LAST_SALE.getOrdinal());
        public final Field PEG_TO_VWAP = new Field(PegPriceType.INSTANCE, Values.PEG_TO_VWAP.getOrdinal());
        public final Field PRIMARY_PEG_PRIMARY_MARKET__BUY_AT_BID_OR_SELL_AT_OFFER = new Field(PegPriceType.INSTANCE, Values.PRIMARY_PEG_PRIMARY_MARKET__BUY_AT_BID_OR_SELL_AT_OFFER.getOrdinal());
        public final Field MARKET_PEG = new Field(PegPriceType.INSTANCE, Values.MARKET_PEG.getOrdinal());
        public final Field PEG_TO_LIMIT_PRICE = new Field(PegPriceType.INSTANCE, Values.PEG_TO_LIMIT_PRICE.getOrdinal());
        public final Field TRAILING_STOP_PEG = new Field(PegPriceType.INSTANCE, Values.TRAILING_STOP_PEG.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        OPENING_PEG("3"),
        MIDPRICE_PEG_MIDPRICE_OF_INSIDE_QUOTE("2"),
        LAST_PEG_LAST_SALE("1"),
        PEG_TO_VWAP("7"),
        PRIMARY_PEG_PRIMARY_MARKET__BUY_AT_BID_OR_SELL_AT_OFFER("5"),
        MARKET_PEG("4"),
        PEG_TO_LIMIT_PRICE("9"),
        TRAILING_STOP_PEG("8");

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
