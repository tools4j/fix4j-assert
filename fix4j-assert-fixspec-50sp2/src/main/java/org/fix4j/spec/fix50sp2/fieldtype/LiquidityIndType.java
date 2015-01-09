package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class LiquidityIndType extends BaseFieldType {
    public static final LiquidityIndType INSTANCE = new LiquidityIndType();

    private LiquidityIndType() {
        super(
            "LiquidityIndType",
            409,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NORMAL_MARKET_SIZE = new Field(LiquidityIndType.INSTANCE, Values.NORMAL_MARKET_SIZE.getOrdinal());
        public final Field I20DAY_MOVING_AVERAGE = new Field(LiquidityIndType.INSTANCE, Values.I20DAY_MOVING_AVERAGE.getOrdinal());
        public final Field I5DAY_MOVING_AVERAGE = new Field(LiquidityIndType.INSTANCE, Values.I5DAY_MOVING_AVERAGE.getOrdinal());
        public final Field OTHER = new Field(LiquidityIndType.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NORMAL_MARKET_SIZE("3"),
        I20DAY_MOVING_AVERAGE("2"),
        I5DAY_MOVING_AVERAGE("1"),
        OTHER("4");

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
