package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MultilegPriceMethod extends BaseFieldType {
    public static final MultilegPriceMethod INSTANCE = new MultilegPriceMethod();

    private MultilegPriceMethod() {
        super(
            "MultilegPriceMethod",
            1378,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INDIVIDUAL = new Field(MultilegPriceMethod.INSTANCE, Values.INDIVIDUAL.getOrdinal());
        public final Field YIELD_DIFFERENCE = new Field(MultilegPriceMethod.INSTANCE, Values.YIELD_DIFFERENCE.getOrdinal());
        public final Field REVERSED_NET_PRICE = new Field(MultilegPriceMethod.INSTANCE, Values.REVERSED_NET_PRICE.getOrdinal());
        public final Field NET_PRICE = new Field(MultilegPriceMethod.INSTANCE, Values.NET_PRICE.getOrdinal());
        public final Field MULTIPLIED_PRICE = new Field(MultilegPriceMethod.INSTANCE, Values.MULTIPLIED_PRICE.getOrdinal());
        public final Field CONTRACT_WEIGHTED_AVERAGE_PRICE = new Field(MultilegPriceMethod.INSTANCE, Values.CONTRACT_WEIGHTED_AVERAGE_PRICE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INDIVIDUAL("3"),
        YIELD_DIFFERENCE("2"),
        REVERSED_NET_PRICE("1"),
        NET_PRICE("0"),
        MULTIPLIED_PRICE("5"),
        CONTRACT_WEIGHTED_AVERAGE_PRICE("4");

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
