package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuotePriceType extends BaseFieldType {
    public static final QuotePriceType INSTANCE = new QuotePriceType();

    private QuotePriceType() {
        super(
            "QuotePriceType",
            692,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FIXED_AMOUNT_ABSOLUTE_VALUE = new Field(QuotePriceType.INSTANCE, Values.FIXED_AMOUNT_ABSOLUTE_VALUE.getOrdinal());
        public final Field PER_SHARE_EG_CENTS_PER_SHARE = new Field(QuotePriceType.INSTANCE, Values.PER_SHARE_EG_CENTS_PER_SHARE.getOrdinal());
        public final Field YIELD = new Field(QuotePriceType.INSTANCE, Values.YIELD.getOrdinal());
        public final Field PERCENT_PERCENT_OF_PAR = new Field(QuotePriceType.INSTANCE, Values.PERCENT_PERCENT_OF_PAR.getOrdinal());
        public final Field TED_PRICE = new Field(QuotePriceType.INSTANCE, Values.TED_PRICE.getOrdinal());
        public final Field SPREAD__BASIS_POINTS_RELATIVE_TO_BENCHMARK = new Field(QuotePriceType.INSTANCE, Values.SPREAD__BASIS_POINTS_RELATIVE_TO_BENCHMARK.getOrdinal());
        public final Field PREMIUM__PERCENTAGE_POINTS_OVER_PAR = new Field(QuotePriceType.INSTANCE, Values.PREMIUM__PERCENTAGE_POINTS_OVER_PAR.getOrdinal());
        public final Field DISCOUNT__PERCENTAGE_POINTS_BELOW_PAR = new Field(QuotePriceType.INSTANCE, Values.DISCOUNT__PERCENTAGE_POINTS_BELOW_PAR.getOrdinal());
        public final Field YIELD_SPREAD_SWAPS = new Field(QuotePriceType.INSTANCE, Values.YIELD_SPREAD_SWAPS.getOrdinal());
        public final Field TED_YIELD = new Field(QuotePriceType.INSTANCE, Values.TED_YIELD.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FIXED_AMOUNT_ABSOLUTE_VALUE("3"),
        PER_SHARE_EG_CENTS_PER_SHARE("2"),
        YIELD("10"),
        PERCENT_PERCENT_OF_PAR("1"),
        TED_PRICE("7"),
        SPREAD__BASIS_POINTS_RELATIVE_TO_BENCHMARK("6"),
        PREMIUM__PERCENTAGE_POINTS_OVER_PAR("5"),
        DISCOUNT__PERCENTAGE_POINTS_BELOW_PAR("4"),
        YIELD_SPREAD_SWAPS("9"),
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
