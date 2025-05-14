package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityRequestType extends BaseFieldType {
    public static final SecurityRequestType INSTANCE = new SecurityRequestType();

    private SecurityRequestType() {
        super(
            "SecurityRequestType",
            321,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REQUEST_LIST_SECURITIES_CAN_BE_QUALIFIED_WITH_SYMBOL_SECURITYTYP = new Field(SecurityRequestType.INSTANCE, Values.REQUEST_LIST_SECURITIES_CAN_BE_QUALIFIED_WITH_SYMBOL_SECURITYTYP.getOrdinal());
        public final Field REQUEST_LIST_SECURITY_TYPES = new Field(SecurityRequestType.INSTANCE, Values.REQUEST_LIST_SECURITY_TYPES.getOrdinal());
        public final Field REQUEST_SECURITY_IDENTITY_FOR_THE_SPECIFICATIONS_PROVIDED_NAME_O = new Field(SecurityRequestType.INSTANCE, Values.REQUEST_SECURITY_IDENTITY_FOR_THE_SPECIFICATIONS_PROVIDED_NAME_O.getOrdinal());
        public final Field REQUEST_SECURITY_IDENTITY_AND_SPECIFICATIONS = new Field(SecurityRequestType.INSTANCE, Values.REQUEST_SECURITY_IDENTITY_AND_SPECIFICATIONS.getOrdinal());
        public final Field TRADINGSESSIONID = new Field(SecurityRequestType.INSTANCE, Values.TRADINGSESSIONID.getOrdinal());
        public final Field PRODUCT = new Field(SecurityRequestType.INSTANCE, Values.PRODUCT.getOrdinal());
        public final Field SECURITYTYPE_AND_OR_CFICODE = new Field(SecurityRequestType.INSTANCE, Values.SECURITYTYPE_AND_OR_CFICODE.getOrdinal());
        public final Field SYMBOL = new Field(SecurityRequestType.INSTANCE, Values.SYMBOL.getOrdinal());
        public final Field MARKETID_OR_MARKETID__MARKETSEGMENTID = new Field(SecurityRequestType.INSTANCE, Values.MARKETID_OR_MARKETID__MARKETSEGMENTID.getOrdinal());
        public final Field ALL_SECURITIES = new Field(SecurityRequestType.INSTANCE, Values.ALL_SECURITIES.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REQUEST_LIST_SECURITIES_CAN_BE_QUALIFIED_WITH_SYMBOL_SECURITYTYP("3"),
        REQUEST_LIST_SECURITY_TYPES("2"),
        REQUEST_SECURITY_IDENTITY_FOR_THE_SPECIFICATIONS_PROVIDED_NAME_O("1"),
        REQUEST_SECURITY_IDENTITY_AND_SPECIFICATIONS("0"),
        TRADINGSESSIONID("7"),
        PRODUCT("6"),
        SECURITYTYPE_AND_OR_CFICODE("5"),
        SYMBOL("4"),
        MARKETID_OR_MARKETID__MARKETSEGMENTID("9"),
        ALL_SECURITIES("8");

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
