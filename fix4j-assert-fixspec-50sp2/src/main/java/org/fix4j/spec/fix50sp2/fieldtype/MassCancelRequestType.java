package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MassCancelRequestType extends BaseFieldType {
    public static final MassCancelRequestType INSTANCE = new MassCancelRequestType();

    private MassCancelRequestType() {
        super(
            "MassCancelRequestType",
            530,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CANCEL_ORDERS_FOR_A_PRODUCT = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_ORDERS_FOR_A_PRODUCT.getOrdinal());
        public final Field CANCEL_ORDERS_FOR_AN_UNDERLYING_SECURITY = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_ORDERS_FOR_AN_UNDERLYING_SECURITY.getOrdinal());
        public final Field CANCEL_ORDERS_FOR_A_SECURITY = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_ORDERS_FOR_A_SECURITY.getOrdinal());
        public final Field CANCEL_ALL_ORDERS = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_ALL_ORDERS.getOrdinal());
        public final Field CANCEL_ORDERS_FOR_A_SECURITY_GROUP = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_ORDERS_FOR_A_SECURITY_GROUP.getOrdinal());
        public final Field CANCEL_ORDERS_FOR_A_TRADING_SESSION = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_ORDERS_FOR_A_TRADING_SESSION.getOrdinal());
        public final Field CANCEL_FOR_SECURITY_ISSUER = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_FOR_SECURITY_ISSUER.getOrdinal());
        public final Field CANCEL_ORDERS_FOR_A_SECURITYTYPE = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_ORDERS_FOR_A_SECURITYTYPE.getOrdinal());
        public final Field CANCEL_FOR_ISSUER_OF_UNDERLYING_SECURITY = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_FOR_ISSUER_OF_UNDERLYING_SECURITY.getOrdinal());
        public final Field CANCEL_ORDERS_FOR_A_CFICODE = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_ORDERS_FOR_A_CFICODE.getOrdinal());
        public final Field CANCEL_ORDERS_FOR_A_MARKET_SEGMENT = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_ORDERS_FOR_A_MARKET_SEGMENT.getOrdinal());
        public final Field CANCEL_ORDERS_FOR_A_MARKET = new Field(MassCancelRequestType.INSTANCE, Values.CANCEL_ORDERS_FOR_A_MARKET.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CANCEL_ORDERS_FOR_A_PRODUCT("3"),
        CANCEL_ORDERS_FOR_AN_UNDERLYING_SECURITY("2"),
        CANCEL_ORDERS_FOR_A_SECURITY("1"),
        CANCEL_ALL_ORDERS("7"),
        CANCEL_ORDERS_FOR_A_SECURITY_GROUP("A"),
        CANCEL_ORDERS_FOR_A_TRADING_SESSION("6"),
        CANCEL_FOR_SECURITY_ISSUER("B"),
        CANCEL_ORDERS_FOR_A_SECURITYTYPE("5"),
        CANCEL_FOR_ISSUER_OF_UNDERLYING_SECURITY("C"),
        CANCEL_ORDERS_FOR_A_CFICODE("4"),
        CANCEL_ORDERS_FOR_A_MARKET_SEGMENT("9"),
        CANCEL_ORDERS_FOR_A_MARKET("8");

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
