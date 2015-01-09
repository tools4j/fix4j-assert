package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DerivativeSecurityListRequestType extends BaseFieldType {
    public static final DerivativeSecurityListRequestType INSTANCE = new DerivativeSecurityListRequestType();

    private DerivativeSecurityListRequestType() {
        super(
            "DerivativeSecurityListRequestType",
            1307,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TRADINGSESSIONID = new Field(DerivativeSecurityListRequestType.INSTANCE, Values.TRADINGSESSIONID.getOrdinal());
        public final Field PRODUCT = new Field(DerivativeSecurityListRequestType.INSTANCE, Values.PRODUCT.getOrdinal());
        public final Field SECURITYTYPE_AND_OR_CFICODE = new Field(DerivativeSecurityListRequestType.INSTANCE, Values.SECURITYTYPE_AND_OR_CFICODE.getOrdinal());
        public final Field SYMBOL = new Field(DerivativeSecurityListRequestType.INSTANCE, Values.SYMBOL.getOrdinal());
        public final Field UNDERLYING_PRODUCT = new Field(DerivativeSecurityListRequestType.INSTANCE, Values.UNDERLYING_PRODUCT.getOrdinal());
        public final Field UNDERLYING_SECURITYTYPE_AND_OR_CFICODE = new Field(DerivativeSecurityListRequestType.INSTANCE, Values.UNDERLYING_SECURITYTYPE_AND_OR_CFICODE.getOrdinal());
        public final Field UNDELYINGSYMBOL = new Field(DerivativeSecurityListRequestType.INSTANCE, Values.UNDELYINGSYMBOL.getOrdinal());
        public final Field ALL_SECURITIES = new Field(DerivativeSecurityListRequestType.INSTANCE, Values.ALL_SECURITIES.getOrdinal());
        public final Field MARKETID_OR_MARKETID__MARKETSEGMENTID = new Field(DerivativeSecurityListRequestType.INSTANCE, Values.MARKETID_OR_MARKETID__MARKETSEGMENTID.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TRADINGSESSIONID("3"),
        PRODUCT("2"),
        SECURITYTYPE_AND_OR_CFICODE("1"),
        SYMBOL("0"),
        UNDERLYING_PRODUCT("7"),
        UNDERLYING_SECURITYTYPE_AND_OR_CFICODE("6"),
        UNDELYINGSYMBOL("5"),
        ALL_SECURITIES("4"),
        MARKETID_OR_MARKETID__MARKETSEGMENTID("8");

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
