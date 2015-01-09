package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class Side extends BaseFieldType {
    public static final Side INSTANCE = new Side();

    private Side() {
        super(
            "Side",
            54,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SUBSCRIBE_EG_CIV = new Field(Side.INSTANCE, Values.SUBSCRIBE_EG_CIV.getOrdinal());
        public final Field REDEEM_EG_CIV = new Field(Side.INSTANCE, Values.REDEEM_EG_CIV.getOrdinal());
        public final Field LEND_FINANCING__IDENTIFIES_DIRECTION_OF_COLLATERAL = new Field(Side.INSTANCE, Values.LEND_FINANCING__IDENTIFIES_DIRECTION_OF_COLLATERAL.getOrdinal());
        public final Field BORROW_FINANCING__IDENTIFIES_DIRECTION_OF_COLLATERAL = new Field(Side.INSTANCE, Values.BORROW_FINANCING__IDENTIFIES_DIRECTION_OF_COLLATERAL.getOrdinal());
        public final Field CROSS_SHORT_EXEMPT = new Field(Side.INSTANCE, Values.CROSS_SHORT_EXEMPT.getOrdinal());
        public final Field AS_DEFINED_FOR_USE_WITH_MULTILEG_INSTRUMENTS = new Field(Side.INSTANCE, Values.AS_DEFINED_FOR_USE_WITH_MULTILEG_INSTRUMENTS.getOrdinal());
        public final Field OPPOSITE_FOR_USE_WITH_MULTILEG_INSTRUMENTS = new Field(Side.INSTANCE, Values.OPPOSITE_FOR_USE_WITH_MULTILEG_INSTRUMENTS.getOrdinal());
        public final Field BUY_MINUS = new Field(Side.INSTANCE, Values.BUY_MINUS.getOrdinal());
        public final Field SELL = new Field(Side.INSTANCE, Values.SELL.getOrdinal());
        public final Field BUY = new Field(Side.INSTANCE, Values.BUY.getOrdinal());
        public final Field UNDISCLOSED_VALID_FOR_IOI_AND_LIST_ORDER_MESSAGES_ONLY = new Field(Side.INSTANCE, Values.UNDISCLOSED_VALID_FOR_IOI_AND_LIST_ORDER_MESSAGES_ONLY.getOrdinal());
        public final Field SELL_SHORT_EXEMPT = new Field(Side.INSTANCE, Values.SELL_SHORT_EXEMPT.getOrdinal());
        public final Field SELL_SHORT = new Field(Side.INSTANCE, Values.SELL_SHORT.getOrdinal());
        public final Field SELL_PLUS = new Field(Side.INSTANCE, Values.SELL_PLUS.getOrdinal());
        public final Field CROSS_SHORT = new Field(Side.INSTANCE, Values.CROSS_SHORT.getOrdinal());
        public final Field CROSS_ORDERS_WHERE_COUNTERPARTY_IS_AN_EXCHANGE_VALID_FOR_ALL_MES = new Field(Side.INSTANCE, Values.CROSS_ORDERS_WHERE_COUNTERPARTY_IS_AN_EXCHANGE_VALID_FOR_ALL_MES.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SUBSCRIBE_EG_CIV("D"),
        REDEEM_EG_CIV("E"),
        LEND_FINANCING__IDENTIFIES_DIRECTION_OF_COLLATERAL("F"),
        BORROW_FINANCING__IDENTIFIES_DIRECTION_OF_COLLATERAL("G"),
        CROSS_SHORT_EXEMPT("A"),
        AS_DEFINED_FOR_USE_WITH_MULTILEG_INSTRUMENTS("B"),
        OPPOSITE_FOR_USE_WITH_MULTILEG_INSTRUMENTS("C"),
        BUY_MINUS("3"),
        SELL("2"),
        BUY("1"),
        UNDISCLOSED_VALID_FOR_IOI_AND_LIST_ORDER_MESSAGES_ONLY("7"),
        SELL_SHORT_EXEMPT("6"),
        SELL_SHORT("5"),
        SELL_PLUS("4"),
        CROSS_SHORT("9"),
        CROSS_ORDERS_WHERE_COUNTERPARTY_IS_AN_EXCHANGE_VALID_FOR_ALL_MES("8");

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
