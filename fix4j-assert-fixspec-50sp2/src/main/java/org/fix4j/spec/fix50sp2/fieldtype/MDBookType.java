package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MDBookType extends BaseFieldType {
    public static final MDBookType INSTANCE = new MDBookType();

    private MDBookType() {
        super(
            "MDBookType",
            1021,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ORDER_DEPTH = new Field(MDBookType.INSTANCE, Values.ORDER_DEPTH.getOrdinal());
        public final Field PRICE_DEPTH = new Field(MDBookType.INSTANCE, Values.PRICE_DEPTH.getOrdinal());
        public final Field TOP_OF_BOOK = new Field(MDBookType.INSTANCE, Values.TOP_OF_BOOK.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ORDER_DEPTH("3"),
        PRICE_DEPTH("2"),
        TOP_OF_BOOK("1");

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
