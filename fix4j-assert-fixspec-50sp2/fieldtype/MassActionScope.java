package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MassActionScope extends BaseFieldType {
    public static final MassActionScope INSTANCE = new MassActionScope();

    private MassActionScope() {
        super(
            "MassActionScope",
            1374,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ALL_ORDERS_FOR_A_PRODUCT = new Field(MassActionScope.INSTANCE, Values.ALL_ORDERS_FOR_A_PRODUCT.getOrdinal());
        public final Field ALL_ORDERS_FOR_AN_UNDERLYING_SECURITY = new Field(MassActionScope.INSTANCE, Values.ALL_ORDERS_FOR_AN_UNDERLYING_SECURITY.getOrdinal());
        public final Field ALL_ORDERS_FOR_A_SECURITY_GROUP = new Field(MassActionScope.INSTANCE, Values.ALL_ORDERS_FOR_A_SECURITY_GROUP.getOrdinal());
        public final Field ALL_ORDERS_FOR_A_SECURITY = new Field(MassActionScope.INSTANCE, Values.ALL_ORDERS_FOR_A_SECURITY.getOrdinal());
        public final Field ALL_ORDERS = new Field(MassActionScope.INSTANCE, Values.ALL_ORDERS.getOrdinal());
        public final Field ALL_ORDERS_FOR_A_TRADING_SESSION = new Field(MassActionScope.INSTANCE, Values.ALL_ORDERS_FOR_A_TRADING_SESSION.getOrdinal());
        public final Field ALL_ORDERS_FOR_A_SECURITYTYPE = new Field(MassActionScope.INSTANCE, Values.ALL_ORDERS_FOR_A_SECURITYTYPE.getOrdinal());
        public final Field ALL_ORDERS_FOR_A_CFICODE = new Field(MassActionScope.INSTANCE, Values.ALL_ORDERS_FOR_A_CFICODE.getOrdinal());
        public final Field ALL_ORDERS_FOR_A_MARKET_SEGMENT = new Field(MassActionScope.INSTANCE, Values.ALL_ORDERS_FOR_A_MARKET_SEGMENT.getOrdinal());
        public final Field ALL_ORDERS_FOR_A_MARKET = new Field(MassActionScope.INSTANCE, Values.ALL_ORDERS_FOR_A_MARKET.getOrdinal());
        public final Field CANCEL_FOR_SECURITY_ISSUER = new Field(MassActionScope.INSTANCE, Values.CANCEL_FOR_SECURITY_ISSUER.getOrdinal());
        public final Field CANCEL_FOR_ISSUER_OF_UNDERLYING_SECURITY = new Field(MassActionScope.INSTANCE, Values.CANCEL_FOR_ISSUER_OF_UNDERLYING_SECURITY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ALL_ORDERS_FOR_A_PRODUCT("3"),
        ALL_ORDERS_FOR_AN_UNDERLYING_SECURITY("2"),
        ALL_ORDERS_FOR_A_SECURITY_GROUP("10"),
        ALL_ORDERS_FOR_A_SECURITY("1"),
        ALL_ORDERS("7"),
        ALL_ORDERS_FOR_A_TRADING_SESSION("6"),
        ALL_ORDERS_FOR_A_SECURITYTYPE("5"),
        ALL_ORDERS_FOR_A_CFICODE("4"),
        ALL_ORDERS_FOR_A_MARKET_SEGMENT("9"),
        ALL_ORDERS_FOR_A_MARKET("8"),
        CANCEL_FOR_SECURITY_ISSUER("11"),
        CANCEL_FOR_ISSUER_OF_UNDERLYING_SECURITY("12");

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
