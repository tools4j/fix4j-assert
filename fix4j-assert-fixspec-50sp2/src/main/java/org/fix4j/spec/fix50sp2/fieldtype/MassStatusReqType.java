package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MassStatusReqType extends BaseFieldType {
    public static final MassStatusReqType INSTANCE = new MassStatusReqType();

    private MassStatusReqType() {
        super(
            "MassStatusReqType",
            585,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field STATUS_FOR_ORDERS_FOR_A_PRODUCT = new Field(MassStatusReqType.INSTANCE, Values.STATUS_FOR_ORDERS_FOR_A_PRODUCT.getOrdinal());
        public final Field STATUS_FOR_ORDERS_FOR_AN_UNDERLYING_SECURITY = new Field(MassStatusReqType.INSTANCE, Values.STATUS_FOR_ORDERS_FOR_AN_UNDERLYING_SECURITY.getOrdinal());
        public final Field STATUS_FOR_ISSUER_OF_UNDERLYING_SECURITY = new Field(MassStatusReqType.INSTANCE, Values.STATUS_FOR_ISSUER_OF_UNDERLYING_SECURITY.getOrdinal());
        public final Field STATUS_FOR_ORDERS_FOR_A_SECURITY = new Field(MassStatusReqType.INSTANCE, Values.STATUS_FOR_ORDERS_FOR_A_SECURITY.getOrdinal());
        public final Field STATUS_FOR_ALL_ORDERS = new Field(MassStatusReqType.INSTANCE, Values.STATUS_FOR_ALL_ORDERS.getOrdinal());
        public final Field STATUS_FOR_ORDERS_FOR_A_TRADING_SESSION = new Field(MassStatusReqType.INSTANCE, Values.STATUS_FOR_ORDERS_FOR_A_TRADING_SESSION.getOrdinal());
        public final Field STATUS_FOR_ORDERS_FOR_A_SECURITYTYPE = new Field(MassStatusReqType.INSTANCE, Values.STATUS_FOR_ORDERS_FOR_A_SECURITYTYPE.getOrdinal());
        public final Field STATUS_FOR_ORDERS_FOR_A_CFICODE = new Field(MassStatusReqType.INSTANCE, Values.STATUS_FOR_ORDERS_FOR_A_CFICODE.getOrdinal());
        public final Field STATUS_FOR_SECURITY_ISSUER = new Field(MassStatusReqType.INSTANCE, Values.STATUS_FOR_SECURITY_ISSUER.getOrdinal());
        public final Field STATUS_FOR_ORDERS_FOR_A_PARTYID = new Field(MassStatusReqType.INSTANCE, Values.STATUS_FOR_ORDERS_FOR_A_PARTYID.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        STATUS_FOR_ORDERS_FOR_A_PRODUCT("3"),
        STATUS_FOR_ORDERS_FOR_AN_UNDERLYING_SECURITY("2"),
        STATUS_FOR_ISSUER_OF_UNDERLYING_SECURITY("10"),
        STATUS_FOR_ORDERS_FOR_A_SECURITY("1"),
        STATUS_FOR_ALL_ORDERS("7"),
        STATUS_FOR_ORDERS_FOR_A_TRADING_SESSION("6"),
        STATUS_FOR_ORDERS_FOR_A_SECURITYTYPE("5"),
        STATUS_FOR_ORDERS_FOR_A_CFICODE("4"),
        STATUS_FOR_SECURITY_ISSUER("9"),
        STATUS_FOR_ORDERS_FOR_A_PARTYID("8");

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
