package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ShortSaleReason extends BaseFieldType {
    public static final ShortSaleReason INSTANCE = new ShortSaleReason();

    private ShortSaleReason() {
        super(
            "ShortSaleReason",
            853,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SELLING_CUSTOMER_SOLD_SHORT_EXEMPT = new Field(ShortSaleReason.INSTANCE, Values.SELLING_CUSTOMER_SOLD_SHORT_EXEMPT.getOrdinal());
        public final Field SELLING_CUSTOMER_SOLD_SHORT = new Field(ShortSaleReason.INSTANCE, Values.SELLING_CUSTOMER_SOLD_SHORT.getOrdinal());
        public final Field DEALER_SOLD_SHORT_EXEMPT = new Field(ShortSaleReason.INSTANCE, Values.DEALER_SOLD_SHORT_EXEMPT.getOrdinal());
        public final Field DEALER_SOLD_SHORT = new Field(ShortSaleReason.INSTANCE, Values.DEALER_SOLD_SHORT.getOrdinal());
        public final Field QSR_OR_AGU_CONTRA_SIDE_SOLD_SHORT_EXEMPT = new Field(ShortSaleReason.INSTANCE, Values.QSR_OR_AGU_CONTRA_SIDE_SOLD_SHORT_EXEMPT.getOrdinal());
        public final Field QUALIFIED_SERVICE_REPRESENTATIVE_QSR_OR_AUTOMATIC_GIVEUP_AGU_CON = new Field(ShortSaleReason.INSTANCE, Values.QUALIFIED_SERVICE_REPRESENTATIVE_QSR_OR_AUTOMATIC_GIVEUP_AGU_CON.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SELLING_CUSTOMER_SOLD_SHORT_EXEMPT("3"),
        SELLING_CUSTOMER_SOLD_SHORT("2"),
        DEALER_SOLD_SHORT_EXEMPT("1"),
        DEALER_SOLD_SHORT("0"),
        QSR_OR_AGU_CONTRA_SIDE_SOLD_SHORT_EXEMPT("5"),
        QUALIFIED_SERVICE_REPRESENTATIVE_QSR_OR_AUTOMATIC_GIVEUP_AGU_CON("4");

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
