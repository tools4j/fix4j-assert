package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExecPriceType extends BaseFieldType {
    public static final ExecPriceType INSTANCE = new ExecPriceType();

    private ExecPriceType() {
        super(
            "ExecPriceType",
            484,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CREATION_PRICE_PLUS_ADJUSTMENT_PERCENT = new Field(ExecPriceType.INSTANCE, Values.CREATION_PRICE_PLUS_ADJUSTMENT_PERCENT.getOrdinal());
        public final Field CREATION_PRICE_PLUS_ADJUSTMENT_AMOUNT = new Field(ExecPriceType.INSTANCE, Values.CREATION_PRICE_PLUS_ADJUSTMENT_AMOUNT.getOrdinal());
        public final Field OFFER_PRICE_MINUS_ADJUSTMENT_AMOUNT = new Field(ExecPriceType.INSTANCE, Values.OFFER_PRICE_MINUS_ADJUSTMENT_AMOUNT.getOrdinal());
        public final Field OFFER_PRICE_MINUS_ADJUSTMENT_PERCENT = new Field(ExecPriceType.INSTANCE, Values.OFFER_PRICE_MINUS_ADJUSTMENT_PERCENT.getOrdinal());
        public final Field SINGLE_PRICE = new Field(ExecPriceType.INSTANCE, Values.SINGLE_PRICE.getOrdinal());
        public final Field BID_PRICE = new Field(ExecPriceType.INSTANCE, Values.BID_PRICE.getOrdinal());
        public final Field CREATION_PRICE = new Field(ExecPriceType.INSTANCE, Values.CREATION_PRICE.getOrdinal());
        public final Field OFFER_PRICE = new Field(ExecPriceType.INSTANCE, Values.OFFER_PRICE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CREATION_PRICE_PLUS_ADJUSTMENT_PERCENT("D"),
        CREATION_PRICE_PLUS_ADJUSTMENT_AMOUNT("E"),
        OFFER_PRICE_MINUS_ADJUSTMENT_AMOUNT("Q"),
        OFFER_PRICE_MINUS_ADJUSTMENT_PERCENT("P"),
        SINGLE_PRICE("S"),
        BID_PRICE("B"),
        CREATION_PRICE("C"),
        OFFER_PRICE("O");

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
