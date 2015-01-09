package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OrdType extends BaseFieldType {
    public static final OrdType INSTANCE = new OrdType();

    private OrdType() {
        super(
            "OrdType",
            40,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PREVIOUSLY_QUOTED = new Field(OrdType.INSTANCE, Values.PREVIOUSLY_QUOTED.getOrdinal());
        public final Field PREVIOUSLY_INDICATED = new Field(OrdType.INSTANCE, Values.PREVIOUSLY_INDICATED.getOrdinal());
        public final Field FOREX_LIMIT_NO_LONGER_USED = new Field(OrdType.INSTANCE, Values.FOREX_LIMIT_NO_LONGER_USED.getOrdinal());
        public final Field FOREX_SWAP = new Field(OrdType.INSTANCE, Values.FOREX_SWAP.getOrdinal());
        public final Field ON_CLOSE_NO_LONGER_USED = new Field(OrdType.INSTANCE, Values.ON_CLOSE_NO_LONGER_USED.getOrdinal());
        public final Field LIMIT_ON_CLOSE_NO_LONGER_USED = new Field(OrdType.INSTANCE, Values.LIMIT_ON_CLOSE_NO_LONGER_USED.getOrdinal());
        public final Field FOREX_MARKET_NO_LONGER_USED = new Field(OrdType.INSTANCE, Values.FOREX_MARKET_NO_LONGER_USED.getOrdinal());
        public final Field PREVIOUS_FUND_VALUATION_POINT_HISTORIC_PRICING_FOR_CIV = new Field(OrdType.INSTANCE, Values.PREVIOUS_FUND_VALUATION_POINT_HISTORIC_PRICING_FOR_CIV.getOrdinal());
        public final Field NEXT_FUND_VALUATION_POINT_FORWARD_PRICING_FOR_CIV = new Field(OrdType.INSTANCE, Values.NEXT_FUND_VALUATION_POINT_FORWARD_PRICING_FOR_CIV.getOrdinal());
        public final Field FOREX_PREVIOUSLY_QUOTED_NO_LONGER_USED = new Field(OrdType.INSTANCE, Values.FOREX_PREVIOUSLY_QUOTED_NO_LONGER_USED.getOrdinal());
        public final Field FUNARI_LIMIT_DAY_ORDER_WITH_UNEXECUTED_PORTION_HANDLES_AS_MARKET = new Field(OrdType.INSTANCE, Values.FUNARI_LIMIT_DAY_ORDER_WITH_UNEXECUTED_PORTION_HANDLES_AS_MARKET.getOrdinal());
        public final Field MARKET_IF_TOUCHED_MIT = new Field(OrdType.INSTANCE, Values.MARKET_IF_TOUCHED_MIT.getOrdinal());
        public final Field MARKET_WITH_LEFT_OVER_AS_LIMIT_MARKET_ORDER_WITH_UNEXECUTED_QUAN = new Field(OrdType.INSTANCE, Values.MARKET_WITH_LEFT_OVER_AS_LIMIT_MARKET_ORDER_WITH_UNEXECUTED_QUAN.getOrdinal());
        public final Field STOP__STOP_LOSS = new Field(OrdType.INSTANCE, Values.STOP__STOP_LOSS.getOrdinal());
        public final Field LIMIT = new Field(OrdType.INSTANCE, Values.LIMIT.getOrdinal());
        public final Field MARKET = new Field(OrdType.INSTANCE, Values.MARKET.getOrdinal());
        public final Field COUNTERORDER_SELECTION = new Field(OrdType.INSTANCE, Values.COUNTERORDER_SELECTION.getOrdinal());
        public final Field LIMIT_OR_BETTER = new Field(OrdType.INSTANCE, Values.LIMIT_OR_BETTER.getOrdinal());
        public final Field PEGGED = new Field(OrdType.INSTANCE, Values.PEGGED.getOrdinal());
        public final Field WITH_OR_WITHOUT = new Field(OrdType.INSTANCE, Values.WITH_OR_WITHOUT.getOrdinal());
        public final Field MARKET_ON_CLOSE_NO_LONGER_USED = new Field(OrdType.INSTANCE, Values.MARKET_ON_CLOSE_NO_LONGER_USED.getOrdinal());
        public final Field STOP_LIMIT = new Field(OrdType.INSTANCE, Values.STOP_LIMIT.getOrdinal());
        public final Field ON_BASIS = new Field(OrdType.INSTANCE, Values.ON_BASIS.getOrdinal());
        public final Field LIMIT_WITH_OR_WITHOUT = new Field(OrdType.INSTANCE, Values.LIMIT_WITH_OR_WITHOUT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PREVIOUSLY_QUOTED("D"),
        PREVIOUSLY_INDICATED("E"),
        FOREX_LIMIT_NO_LONGER_USED("F"),
        FOREX_SWAP("G"),
        ON_CLOSE_NO_LONGER_USED("A"),
        LIMIT_ON_CLOSE_NO_LONGER_USED("B"),
        FOREX_MARKET_NO_LONGER_USED("C"),
        PREVIOUS_FUND_VALUATION_POINT_HISTORIC_PRICING_FOR_CIV("L"),
        NEXT_FUND_VALUATION_POINT_FORWARD_PRICING_FOR_CIV("M"),
        FOREX_PREVIOUSLY_QUOTED_NO_LONGER_USED("H"),
        FUNARI_LIMIT_DAY_ORDER_WITH_UNEXECUTED_PORTION_HANDLES_AS_MARKET("I"),
        MARKET_IF_TOUCHED_MIT("J"),
        MARKET_WITH_LEFT_OVER_AS_LIMIT_MARKET_ORDER_WITH_UNEXECUTED_QUAN("K"),
        STOP__STOP_LOSS("3"),
        LIMIT("2"),
        MARKET("1"),
        COUNTERORDER_SELECTION("Q"),
        LIMIT_OR_BETTER("7"),
        PEGGED("P"),
        WITH_OR_WITHOUT("6"),
        MARKET_ON_CLOSE_NO_LONGER_USED("5"),
        STOP_LIMIT("4"),
        ON_BASIS("9"),
        LIMIT_WITH_OR_WITHOUT("8");

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
