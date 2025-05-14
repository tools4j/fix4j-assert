package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DeliveryType extends BaseFieldType {
    public static final DeliveryType INSTANCE = new DeliveryType();

    private DeliveryType() {
        super(
            "DeliveryType",
            919,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field HOLD_IN_CUSTODY = new Field(DeliveryType.INSTANCE, Values.HOLD_IN_CUSTODY.getOrdinal());
        public final Field TRIPARTY = new Field(DeliveryType.INSTANCE, Values.TRIPARTY.getOrdinal());
        public final Field FREE_DELIVER_IF_SELL_OR_RECEIVE_IF_BUY_FREE = new Field(DeliveryType.INSTANCE, Values.FREE_DELIVER_IF_SELL_OR_RECEIVE_IF_BUY_FREE.getOrdinal());
        public final Field VERSUS_PAYMENT_DELIVER_IF_SELL_OR_RECEIVE_IF_BUY_VS_AGAINST_PAYM = new Field(DeliveryType.INSTANCE, Values.VERSUS_PAYMENT_DELIVER_IF_SELL_OR_RECEIVE_IF_BUY_VS_AGAINST_PAYM.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        HOLD_IN_CUSTODY("3"),
        TRIPARTY("2"),
        FREE_DELIVER_IF_SELL_OR_RECEIVE_IF_BUY_FREE("1"),
        VERSUS_PAYMENT_DELIVER_IF_SELL_OR_RECEIVE_IF_BUY_VS_AGAINST_PAYM("0");

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
