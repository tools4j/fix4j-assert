package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StrikePriceDeterminationMethod extends BaseFieldType {
    public static final StrikePriceDeterminationMethod INSTANCE = new StrikePriceDeterminationMethod();

    private StrikePriceDeterminationMethod() {
        super(
            "StrikePriceDeterminationMethod",
            1478,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field STRIKE_SET_TO_AVERAGE_OF_UNDERLYING_SETTLEMENT_PRICE_ACROSS_THE_ = new Field(StrikePriceDeterminationMethod.INSTANCE, Values.STRIKE_SET_TO_AVERAGE_OF_UNDERLYING_SETTLEMENT_PRICE_ACROSS_THE_.getOrdinal());
        public final Field STRIKE_SET_AT_EXPIRATION_TO_UNDERLYING_OR_OTHER_VALUE_LOOKBACK_F = new Field(StrikePriceDeterminationMethod.INSTANCE, Values.STRIKE_SET_AT_EXPIRATION_TO_UNDERLYING_OR_OTHER_VALUE_LOOKBACK_F.getOrdinal());
        public final Field FIXED_STRIKE = new Field(StrikePriceDeterminationMethod.INSTANCE, Values.FIXED_STRIKE.getOrdinal());
        public final Field STRIKE_SET_TO_OPTIMAL_VALUE = new Field(StrikePriceDeterminationMethod.INSTANCE, Values.STRIKE_SET_TO_OPTIMAL_VALUE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        STRIKE_SET_TO_AVERAGE_OF_UNDERLYING_SETTLEMENT_PRICE_ACROSS_THE_("3"),
        STRIKE_SET_AT_EXPIRATION_TO_UNDERLYING_OR_OTHER_VALUE_LOOKBACK_F("2"),
        FIXED_STRIKE("1"),
        STRIKE_SET_TO_OPTIMAL_VALUE("4");

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
