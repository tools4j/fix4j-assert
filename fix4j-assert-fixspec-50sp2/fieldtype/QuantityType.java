package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuantityType extends BaseFieldType {
    public static final QuantityType INSTANCE = new QuantityType();

    private QuantityType() {
        super(
            "QuantityType",
            465,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CURRENTFACE = new Field(QuantityType.INSTANCE, Values.CURRENTFACE.getOrdinal());
        public final Field BONDS = new Field(QuantityType.INSTANCE, Values.BONDS.getOrdinal());
        public final Field SHARES = new Field(QuantityType.INSTANCE, Values.SHARES.getOrdinal());
        public final Field OTHER = new Field(QuantityType.INSTANCE, Values.OTHER.getOrdinal());
        public final Field CONTRACTS = new Field(QuantityType.INSTANCE, Values.CONTRACTS.getOrdinal());
        public final Field CURRENCY = new Field(QuantityType.INSTANCE, Values.CURRENCY.getOrdinal());
        public final Field ORIGINALFACE = new Field(QuantityType.INSTANCE, Values.ORIGINALFACE.getOrdinal());
        public final Field PAR = new Field(QuantityType.INSTANCE, Values.PAR.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CURRENTFACE("3"),
        BONDS("2"),
        SHARES("1"),
        OTHER("7"),
        CONTRACTS("6"),
        CURRENCY("5"),
        ORIGINALFACE("4"),
        PAR("8");

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
