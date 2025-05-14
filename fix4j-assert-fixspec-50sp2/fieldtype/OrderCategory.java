package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OrderCategory extends BaseFieldType {
    public static final OrderCategory INSTANCE = new OrderCategory();

    private OrderCategory() {
        super(
            "OrderCategory",
            1115,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PRIVATELY_NEGOTIATED_TRADE = new Field(OrderCategory.INSTANCE, Values.PRIVATELY_NEGOTIATED_TRADE.getOrdinal());
        public final Field QUOTE = new Field(OrderCategory.INSTANCE, Values.QUOTE.getOrdinal());
        public final Field ORDER = new Field(OrderCategory.INSTANCE, Values.ORDER.getOrdinal());
        public final Field IMPLIED_ORDER = new Field(OrderCategory.INSTANCE, Values.IMPLIED_ORDER.getOrdinal());
        public final Field QUOTE_REQUEST = new Field(OrderCategory.INSTANCE, Values.QUOTE_REQUEST.getOrdinal());
        public final Field LINKED_ORDER = new Field(OrderCategory.INSTANCE, Values.LINKED_ORDER.getOrdinal());
        public final Field MULTILEG_ORDER = new Field(OrderCategory.INSTANCE, Values.MULTILEG_ORDER.getOrdinal());
        public final Field STREAMING_PRICE_QUOTE = new Field(OrderCategory.INSTANCE, Values.STREAMING_PRICE_QUOTE.getOrdinal());
        public final Field CROSS_ORDER = new Field(OrderCategory.INSTANCE, Values.CROSS_ORDER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PRIVATELY_NEGOTIATED_TRADE("3"),
        QUOTE("2"),
        ORDER("1"),
        IMPLIED_ORDER("7"),
        QUOTE_REQUEST("6"),
        LINKED_ORDER("5"),
        MULTILEG_ORDER("4"),
        STREAMING_PRICE_QUOTE("9"),
        CROSS_ORDER("8");

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
