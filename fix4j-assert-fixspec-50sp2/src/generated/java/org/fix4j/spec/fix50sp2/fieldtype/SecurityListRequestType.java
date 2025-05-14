package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityListRequestType extends BaseFieldType {
    public static final SecurityListRequestType INSTANCE = new SecurityListRequestType();

    private SecurityListRequestType() {
        super(
            "SecurityListRequestType",
            559,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TRADINGSESSIONID = new Field(SecurityListRequestType.INSTANCE, Values.TRADINGSESSIONID.getOrdinal());
        public final Field PRODUCT = new Field(SecurityListRequestType.INSTANCE, Values.PRODUCT.getOrdinal());
        public final Field SECURITYTYPE_ANDOR_CFICODE = new Field(SecurityListRequestType.INSTANCE, Values.SECURITYTYPE_ANDOR_CFICODE.getOrdinal());
        public final Field SYMBOL = new Field(SecurityListRequestType.INSTANCE, Values.SYMBOL.getOrdinal());
        public final Field MARKETID_OR_MARKETID__MARKETSEGMENTID = new Field(SecurityListRequestType.INSTANCE, Values.MARKETID_OR_MARKETID__MARKETSEGMENTID.getOrdinal());
        public final Field ALL_SECURITIES = new Field(SecurityListRequestType.INSTANCE, Values.ALL_SECURITIES.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TRADINGSESSIONID("3"),
        PRODUCT("2"),
        SECURITYTYPE_ANDOR_CFICODE("1"),
        SYMBOL("0"),
        MARKETID_OR_MARKETID__MARKETSEGMENTID("5"),
        ALL_SECURITIES("4");

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
