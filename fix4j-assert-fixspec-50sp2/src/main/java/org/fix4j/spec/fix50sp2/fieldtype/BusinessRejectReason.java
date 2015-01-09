package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class BusinessRejectReason extends BaseFieldType {
    public static final BusinessRejectReason INSTANCE = new BusinessRejectReason();

    private BusinessRejectReason() {
        super(
            "BusinessRejectReason",
            380,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field UNSUPPORTED_MESSAGE_TYPE = new Field(BusinessRejectReason.INSTANCE, Values.UNSUPPORTED_MESSAGE_TYPE.getOrdinal());
        public final Field UNKNOWN_SECURITY = new Field(BusinessRejectReason.INSTANCE, Values.UNKNOWN_SECURITY.getOrdinal());
        public final Field UNKNOWN_ID = new Field(BusinessRejectReason.INSTANCE, Values.UNKNOWN_ID.getOrdinal());
        public final Field OTHER = new Field(BusinessRejectReason.INSTANCE, Values.OTHER.getOrdinal());
        public final Field DELIVERTO_FIRM_NOT_AVAILABLE_AT_THIS_TIME = new Field(BusinessRejectReason.INSTANCE, Values.DELIVERTO_FIRM_NOT_AVAILABLE_AT_THIS_TIME.getOrdinal());
        public final Field NOT_AUTHORIZED = new Field(BusinessRejectReason.INSTANCE, Values.NOT_AUTHORIZED.getOrdinal());
        public final Field CONDITIONALLY_REQUIRED_FIELD_MISSING = new Field(BusinessRejectReason.INSTANCE, Values.CONDITIONALLY_REQUIRED_FIELD_MISSING.getOrdinal());
        public final Field APPLICATION_NOT_AVAILABLE = new Field(BusinessRejectReason.INSTANCE, Values.APPLICATION_NOT_AVAILABLE.getOrdinal());
        public final Field INVALID_PRICE_INCREMENT = new Field(BusinessRejectReason.INSTANCE, Values.INVALID_PRICE_INCREMENT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        UNSUPPORTED_MESSAGE_TYPE("3"),
        UNKNOWN_SECURITY("2"),
        UNKNOWN_ID("1"),
        OTHER("0"),
        DELIVERTO_FIRM_NOT_AVAILABLE_AT_THIS_TIME("7"),
        NOT_AUTHORIZED("6"),
        CONDITIONALLY_REQUIRED_FIELD_MISSING("5"),
        APPLICATION_NOT_AVAILABLE("4"),
        INVALID_PRICE_INCREMENT("18");

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
