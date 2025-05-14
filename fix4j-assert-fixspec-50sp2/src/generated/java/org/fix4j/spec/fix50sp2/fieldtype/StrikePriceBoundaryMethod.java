package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StrikePriceBoundaryMethod extends BaseFieldType {
    public static final StrikePriceBoundaryMethod INSTANCE = new StrikePriceBoundaryMethod();

    private StrikePriceBoundaryMethod() {
        super(
            "StrikePriceBoundaryMethod",
            1479,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EQUAL_TO_THE_UNDERLYING_PRICE_IS_INTHEMONEYITM = new Field(StrikePriceBoundaryMethod.INSTANCE, Values.EQUAL_TO_THE_UNDERLYING_PRICE_IS_INTHEMONEYITM.getOrdinal());
        public final Field LESS_THAN_OR_EQUAL_TO_THE_UNDERLYING_PRICE_IS_INTHEMONEYITM = new Field(StrikePriceBoundaryMethod.INSTANCE, Values.LESS_THAN_OR_EQUAL_TO_THE_UNDERLYING_PRICE_IS_INTHEMONEYITM.getOrdinal());
        public final Field LESS_THAN_UNDERLYING_PRICE_IS_INTHEMONEY_ITM = new Field(StrikePriceBoundaryMethod.INSTANCE, Values.LESS_THAN_UNDERLYING_PRICE_IS_INTHEMONEY_ITM.getOrdinal());
        public final Field GREATER_THAN_UNDERLYING_IS_INTHEMONEYITM = new Field(StrikePriceBoundaryMethod.INSTANCE, Values.GREATER_THAN_UNDERLYING_IS_INTHEMONEYITM.getOrdinal());
        public final Field GREATER_THAN_OR_EQUAL_TO_UNDERLYING_PRICE_IS_INTHEMONEYITM = new Field(StrikePriceBoundaryMethod.INSTANCE, Values.GREATER_THAN_OR_EQUAL_TO_UNDERLYING_PRICE_IS_INTHEMONEYITM.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EQUAL_TO_THE_UNDERLYING_PRICE_IS_INTHEMONEYITM("3"),
        LESS_THAN_OR_EQUAL_TO_THE_UNDERLYING_PRICE_IS_INTHEMONEYITM("2"),
        LESS_THAN_UNDERLYING_PRICE_IS_INTHEMONEY_ITM("1"),
        GREATER_THAN_UNDERLYING_IS_INTHEMONEYITM("5"),
        GREATER_THAN_OR_EQUAL_TO_UNDERLYING_PRICE_IS_INTHEMONEYITM("4");

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
