package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuoteCancelType extends BaseFieldType {
    public static final QuoteCancelType INSTANCE = new QuoteCancelType();

    private QuoteCancelType() {
        super(
            "QuoteCancelType",
            298,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CANCEL_FOR_UNDERLYING_SECURITY = new Field(QuoteCancelType.INSTANCE, Values.CANCEL_FOR_UNDERLYING_SECURITY.getOrdinal());
        public final Field CANCEL_FOR_SECURITY_TYPES = new Field(QuoteCancelType.INSTANCE, Values.CANCEL_FOR_SECURITY_TYPES.getOrdinal());
        public final Field CANCEL_FOR_ONE_OR_MORE_SECURITIES = new Field(QuoteCancelType.INSTANCE, Values.CANCEL_FOR_ONE_OR_MORE_SECURITIES.getOrdinal());
        public final Field CANCEL_FOR_SECURITY_ISSUER = new Field(QuoteCancelType.INSTANCE, Values.CANCEL_FOR_SECURITY_ISSUER.getOrdinal());
        public final Field CANCEL_BY_QUOTETYPE537 = new Field(QuoteCancelType.INSTANCE, Values.CANCEL_BY_QUOTETYPE537.getOrdinal());
        public final Field CANCEL_QUOTE_SPECIFIED_IN_QUOTEID = new Field(QuoteCancelType.INSTANCE, Values.CANCEL_QUOTE_SPECIFIED_IN_QUOTEID.getOrdinal());
        public final Field CANCEL_ALL_QUOTES = new Field(QuoteCancelType.INSTANCE, Values.CANCEL_ALL_QUOTES.getOrdinal());
        public final Field CANCEL_FOR_ISSUER_OF_UNDERLYING_SECURITY = new Field(QuoteCancelType.INSTANCE, Values.CANCEL_FOR_ISSUER_OF_UNDERLYING_SECURITY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CANCEL_FOR_UNDERLYING_SECURITY("3"),
        CANCEL_FOR_SECURITY_TYPES("2"),
        CANCEL_FOR_ONE_OR_MORE_SECURITIES("1"),
        CANCEL_FOR_SECURITY_ISSUER("7"),
        CANCEL_BY_QUOTETYPE537("6"),
        CANCEL_QUOTE_SPECIFIED_IN_QUOTEID("5"),
        CANCEL_ALL_QUOTES("4"),
        CANCEL_FOR_ISSUER_OF_UNDERLYING_SECURITY("8");

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
