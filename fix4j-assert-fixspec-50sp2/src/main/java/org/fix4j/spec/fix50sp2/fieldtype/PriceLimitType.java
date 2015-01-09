package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PriceLimitType extends BaseFieldType {
    public static final PriceLimitType INSTANCE = new PriceLimitType();

    private PriceLimitType() {
        super(
            "PriceLimitType",
            1306,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PERCENTAGE = new Field(PriceLimitType.INSTANCE, Values.PERCENTAGE.getOrdinal());
        public final Field TICKS = new Field(PriceLimitType.INSTANCE, Values.TICKS.getOrdinal());
        public final Field PRICE = new Field(PriceLimitType.INSTANCE, Values.PRICE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PERCENTAGE("2"),
        TICKS("1"),
        PRICE("0");

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
