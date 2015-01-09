package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MassCancelRejectReason extends BaseFieldType {
    public static final MassCancelRejectReason INSTANCE = new MassCancelRejectReason();

    private MassCancelRejectReason() {
        super(
            "MassCancelRejectReason",
            532,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INVALID_OR_UNKNOWN_ISSUER_OF_UNDERLYING_SECURITY = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_ISSUER_OF_UNDERLYING_SECURITY.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_PRODUCT = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_PRODUCT.getOrdinal());
        public final Field INVALID_OR_UNKOWN_UNDERLYING_SECURITY = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKOWN_UNDERLYING_SECURITY.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_SECURITY = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_SECURITY.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_SECURITY_ISSUER = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_SECURITY_ISSUER.getOrdinal());
        public final Field MASS_CANCEL_NOT_SUPPORTED = new Field(MassCancelRejectReason.INSTANCE, Values.MASS_CANCEL_NOT_SUPPORTED.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_MARKET = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_MARKET.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_TRADING_SESSION = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_TRADING_SESSION.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_SECURITYTYPE = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_SECURITYTYPE.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_CFICODE = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_CFICODE.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_SECURITY_GROUP = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKNOWN_SECURITY_GROUP.getOrdinal());
        public final Field INVALID_OR_UNKOWN_MARKET_SEGMENT = new Field(MassCancelRejectReason.INSTANCE, Values.INVALID_OR_UNKOWN_MARKET_SEGMENT.getOrdinal());
        public final Field OTHER = new Field(MassCancelRejectReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INVALID_OR_UNKNOWN_ISSUER_OF_UNDERLYING_SECURITY("11"),
        INVALID_OR_UNKNOWN_PRODUCT("3"),
        INVALID_OR_UNKOWN_UNDERLYING_SECURITY("2"),
        INVALID_OR_UNKNOWN_SECURITY("1"),
        INVALID_OR_UNKNOWN_SECURITY_ISSUER("10"),
        MASS_CANCEL_NOT_SUPPORTED("0"),
        INVALID_OR_UNKNOWN_MARKET("7"),
        INVALID_OR_UNKNOWN_TRADING_SESSION("6"),
        INVALID_OR_UNKNOWN_SECURITYTYPE("5"),
        INVALID_OR_UNKNOWN_CFICODE("4"),
        INVALID_OR_UNKNOWN_SECURITY_GROUP("9"),
        INVALID_OR_UNKOWN_MARKET_SEGMENT("8"),
        OTHER("99");

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
