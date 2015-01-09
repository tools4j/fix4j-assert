package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PriceType extends BaseFieldType {
    public static final PriceType INSTANCE = new PriceType();

    private PriceType() {
        super(
            "PriceType",
            423,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PRODUCT_TICKS_IN_ONETWENTYEIGHTS = new Field(PriceType.INSTANCE, Values.PRODUCT_TICKS_IN_ONETWENTYEIGHTS.getOrdinal());
        public final Field PRODUCT_TICKS_IN_THIRTYSECONDS = new Field(PriceType.INSTANCE, Values.PRODUCT_TICKS_IN_THIRTYSECONDS.getOrdinal());
        public final Field PRODUCT_TICKS_IN_SIXTYFORTHS = new Field(PriceType.INSTANCE, Values.PRODUCT_TICKS_IN_SIXTYFORTHS.getOrdinal());
        public final Field PRODUCT_TICKS_IN_EIGHTS = new Field(PriceType.INSTANCE, Values.PRODUCT_TICKS_IN_EIGHTS.getOrdinal());
        public final Field PRODUCT_TICKS_IN_SIXTEENTHS = new Field(PriceType.INSTANCE, Values.PRODUCT_TICKS_IN_SIXTEENTHS.getOrdinal());
        public final Field PRODUCT_TICKS_IN_HALFS = new Field(PriceType.INSTANCE, Values.PRODUCT_TICKS_IN_HALFS.getOrdinal());
        public final Field PRODUCT_TICKS_IN_FOURTHS = new Field(PriceType.INSTANCE, Values.PRODUCT_TICKS_IN_FOURTHS.getOrdinal());
        public final Field VARIABLE_CABINET_TRADE_PRICE_PRIMARILY_FOR_LISTED_FUTURES_AND_OP = new Field(PriceType.INSTANCE, Values.VARIABLE_CABINET_TRADE_PRICE_PRIMARILY_FOR_LISTED_FUTURES_AND_OP.getOrdinal());
        public final Field FIXED_AMOUNT_ABSOLUTE_VALUE = new Field(PriceType.INSTANCE, Values.FIXED_AMOUNT_ABSOLUTE_VALUE.getOrdinal());
        public final Field PER_UNIT_IE_PER_SHARE_OR_CONTRACT = new Field(PriceType.INSTANCE, Values.PER_UNIT_IE_PER_SHARE_OR_CONTRACT.getOrdinal());
        public final Field PERCENTAGE_IE_PERCENT_OF_PAR_OFTEN_CALLED_DOLLAR_PRICE_FOR_FIXED = new Field(PriceType.INSTANCE, Values.PERCENTAGE_IE_PERCENT_OF_PAR_OFTEN_CALLED_DOLLAR_PRICE_FOR_FIXED.getOrdinal());
        public final Field FIXED_CABINET_TRADE_PRICE_PRIMARILY_FOR_LISTED_FUTURES_AND_OPTIO = new Field(PriceType.INSTANCE, Values.FIXED_CABINET_TRADE_PRICE_PRIMARILY_FOR_LISTED_FUTURES_AND_OPTIO.getOrdinal());
        public final Field TED_PRICE = new Field(PriceType.INSTANCE, Values.TED_PRICE.getOrdinal());
        public final Field SPREAD_BASIS_POINTS_SPREAD = new Field(PriceType.INSTANCE, Values.SPREAD_BASIS_POINTS_SPREAD.getOrdinal());
        public final Field PREMIUM__PERCENTAGE_POINTS_OVER_PAR = new Field(PriceType.INSTANCE, Values.PREMIUM__PERCENTAGE_POINTS_OVER_PAR.getOrdinal());
        public final Field DISCOUNT__PERCENTAGE_POINTS_BELOW_PAR = new Field(PriceType.INSTANCE, Values.DISCOUNT__PERCENTAGE_POINTS_BELOW_PAR.getOrdinal());
        public final Field YIELD = new Field(PriceType.INSTANCE, Values.YIELD.getOrdinal());
        public final Field TED_YIELD = new Field(PriceType.INSTANCE, Values.TED_YIELD.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PRODUCT_TICKS_IN_ONETWENTYEIGHTS("19"),
        PRODUCT_TICKS_IN_THIRTYSECONDS("17"),
        PRODUCT_TICKS_IN_SIXTYFORTHS("18"),
        PRODUCT_TICKS_IN_EIGHTS("15"),
        PRODUCT_TICKS_IN_SIXTEENTHS("16"),
        PRODUCT_TICKS_IN_HALFS("13"),
        PRODUCT_TICKS_IN_FOURTHS("14"),
        VARIABLE_CABINET_TRADE_PRICE_PRIMARILY_FOR_LISTED_FUTURES_AND_OP("11"),
        FIXED_AMOUNT_ABSOLUTE_VALUE("3"),
        PER_UNIT_IE_PER_SHARE_OR_CONTRACT("2"),
        PERCENTAGE_IE_PERCENT_OF_PAR_OFTEN_CALLED_DOLLAR_PRICE_FOR_FIXED("1"),
        FIXED_CABINET_TRADE_PRICE_PRIMARILY_FOR_LISTED_FUTURES_AND_OPTIO("10"),
        TED_PRICE("7"),
        SPREAD_BASIS_POINTS_SPREAD("6"),
        PREMIUM__PERCENTAGE_POINTS_OVER_PAR("5"),
        DISCOUNT__PERCENTAGE_POINTS_BELOW_PAR("4"),
        YIELD("9"),
        TED_YIELD("8");

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
