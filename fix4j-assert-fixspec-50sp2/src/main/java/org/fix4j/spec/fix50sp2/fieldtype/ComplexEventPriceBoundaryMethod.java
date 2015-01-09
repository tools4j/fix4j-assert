package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ComplexEventPriceBoundaryMethod extends BaseFieldType {
    public static final ComplexEventPriceBoundaryMethod INSTANCE = new ComplexEventPriceBoundaryMethod();

    private ComplexEventPriceBoundaryMethod() {
        super(
            "ComplexEventPriceBoundaryMethod",
            1487,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EQUAL_TO_COMPLEXEVENTPRICE1486 = new Field(ComplexEventPriceBoundaryMethod.INSTANCE, Values.EQUAL_TO_COMPLEXEVENTPRICE1486.getOrdinal());
        public final Field LESS_THAN_OR_EQUAL_TO_COMPLEXEVENTPRICE1486 = new Field(ComplexEventPriceBoundaryMethod.INSTANCE, Values.LESS_THAN_OR_EQUAL_TO_COMPLEXEVENTPRICE1486.getOrdinal());
        public final Field LESS_THAN_COMPLEXEVENTPRICE1486 = new Field(ComplexEventPriceBoundaryMethod.INSTANCE, Values.LESS_THAN_COMPLEXEVENTPRICE1486.getOrdinal());
        public final Field GREATER_THAN_COMPLEXEVENTPRICE1486 = new Field(ComplexEventPriceBoundaryMethod.INSTANCE, Values.GREATER_THAN_COMPLEXEVENTPRICE1486.getOrdinal());
        public final Field GREATER_THAN_OR_EQUAL_TO_COMPLEXEVENTPRICE1486 = new Field(ComplexEventPriceBoundaryMethod.INSTANCE, Values.GREATER_THAN_OR_EQUAL_TO_COMPLEXEVENTPRICE1486.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EQUAL_TO_COMPLEXEVENTPRICE1486("3"),
        LESS_THAN_OR_EQUAL_TO_COMPLEXEVENTPRICE1486("2"),
        LESS_THAN_COMPLEXEVENTPRICE1486("1"),
        GREATER_THAN_COMPLEXEVENTPRICE1486("5"),
        GREATER_THAN_OR_EQUAL_TO_COMPLEXEVENTPRICE1486("4");

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
