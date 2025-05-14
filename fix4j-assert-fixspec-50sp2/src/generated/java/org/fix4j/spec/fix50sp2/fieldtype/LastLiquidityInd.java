package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class LastLiquidityInd extends BaseFieldType {
    public static final LastLiquidityInd INSTANCE = new LastLiquidityInd();

    private LastLiquidityInd() {
        super(
            "LastLiquidityInd",
            851,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field LIQUIDITY_ROUTED_OUT = new Field(LastLiquidityInd.INSTANCE, Values.LIQUIDITY_ROUTED_OUT.getOrdinal());
        public final Field REMOVED_LIQUIDITY = new Field(LastLiquidityInd.INSTANCE, Values.REMOVED_LIQUIDITY.getOrdinal());
        public final Field ADDED_LIQUIDITY = new Field(LastLiquidityInd.INSTANCE, Values.ADDED_LIQUIDITY.getOrdinal());
        public final Field AUCTION = new Field(LastLiquidityInd.INSTANCE, Values.AUCTION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        LIQUIDITY_ROUTED_OUT("3"),
        REMOVED_LIQUIDITY("2"),
        ADDED_LIQUIDITY("1"),
        AUCTION("4");

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
