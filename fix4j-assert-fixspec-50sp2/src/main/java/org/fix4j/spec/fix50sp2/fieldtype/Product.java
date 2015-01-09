package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class Product extends BaseFieldType {
    public static final Product INSTANCE = new Product();

    private Product() {
        super(
            "Product",
            460,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FINANCING = new Field(Product.INSTANCE, Values.FINANCING.getOrdinal());
        public final Field MUNICIPAL = new Field(Product.INSTANCE, Values.MUNICIPAL.getOrdinal());
        public final Field OTHER = new Field(Product.INSTANCE, Values.OTHER.getOrdinal());
        public final Field CORPORATE = new Field(Product.INSTANCE, Values.CORPORATE.getOrdinal());
        public final Field COMMODITY = new Field(Product.INSTANCE, Values.COMMODITY.getOrdinal());
        public final Field AGENCY = new Field(Product.INSTANCE, Values.AGENCY.getOrdinal());
        public final Field MORTGAGE = new Field(Product.INSTANCE, Values.MORTGAGE.getOrdinal());
        public final Field INDEX = new Field(Product.INSTANCE, Values.INDEX.getOrdinal());
        public final Field GOVERNMENT = new Field(Product.INSTANCE, Values.GOVERNMENT.getOrdinal());
        public final Field EQUITY = new Field(Product.INSTANCE, Values.EQUITY.getOrdinal());
        public final Field CURRENCY = new Field(Product.INSTANCE, Values.CURRENCY.getOrdinal());
        public final Field MONEYMARKET = new Field(Product.INSTANCE, Values.MONEYMARKET.getOrdinal());
        public final Field LOAN = new Field(Product.INSTANCE, Values.LOAN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FINANCING("13"),
        MUNICIPAL("11"),
        OTHER("12"),
        CORPORATE("3"),
        COMMODITY("2"),
        AGENCY("1"),
        MORTGAGE("10"),
        INDEX("7"),
        GOVERNMENT("6"),
        EQUITY("5"),
        CURRENCY("4"),
        MONEYMARKET("9"),
        LOAN("8");

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
