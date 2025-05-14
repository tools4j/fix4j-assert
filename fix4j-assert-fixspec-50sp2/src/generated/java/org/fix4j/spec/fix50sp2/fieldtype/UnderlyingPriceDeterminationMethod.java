package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class UnderlyingPriceDeterminationMethod extends BaseFieldType {
    public static final UnderlyingPriceDeterminationMethod INSTANCE = new UnderlyingPriceDeterminationMethod();

    private UnderlyingPriceDeterminationMethod() {
        super(
            "UnderlyingPriceDeterminationMethod",
            1481,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field OPTIMAL_VALUE_LOOKBACK = new Field(UnderlyingPriceDeterminationMethod.INSTANCE, Values.OPTIMAL_VALUE_LOOKBACK.getOrdinal());
        public final Field SPECIAL_REFERENCE = new Field(UnderlyingPriceDeterminationMethod.INSTANCE, Values.SPECIAL_REFERENCE.getOrdinal());
        public final Field REGULAR = new Field(UnderlyingPriceDeterminationMethod.INSTANCE, Values.REGULAR.getOrdinal());
        public final Field AVERAGE_VALUE_ASIAN_OPTION = new Field(UnderlyingPriceDeterminationMethod.INSTANCE, Values.AVERAGE_VALUE_ASIAN_OPTION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        OPTIMAL_VALUE_LOOKBACK("3"),
        SPECIAL_REFERENCE("2"),
        REGULAR("1"),
        AVERAGE_VALUE_ASIAN_OPTION("4");

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
