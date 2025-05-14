package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CollInquiryResult extends BaseFieldType {
    public static final CollInquiryResult INSTANCE = new CollInquiryResult();

    private CollInquiryResult() {
        super(
            "CollInquiryResult",
            946,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INVALID_PARTIES = new Field(CollInquiryResult.INSTANCE, Values.INVALID_PARTIES.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_COLLATERAL_TYPE = new Field(CollInquiryResult.INSTANCE, Values.INVALID_OR_UNKNOWN_COLLATERAL_TYPE.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_INSTRUMENT = new Field(CollInquiryResult.INSTANCE, Values.INVALID_OR_UNKNOWN_INSTRUMENT.getOrdinal());
        public final Field SUCCESSFUL_DEFAULT = new Field(CollInquiryResult.INSTANCE, Values.SUCCESSFUL_DEFAULT.getOrdinal());
        public final Field NO_COLLATERAL_FOUND_FOR_THE_ORDER_SPECIFIED = new Field(CollInquiryResult.INSTANCE, Values.NO_COLLATERAL_FOUND_FOR_THE_ORDER_SPECIFIED.getOrdinal());
        public final Field NO_COLLATERAL_FOUND_FOR_THE_TRADE_SPECIFIED = new Field(CollInquiryResult.INSTANCE, Values.NO_COLLATERAL_FOUND_FOR_THE_TRADE_SPECIFIED.getOrdinal());
        public final Field INVALID_DESTINATION_REQUESTED = new Field(CollInquiryResult.INSTANCE, Values.INVALID_DESTINATION_REQUESTED.getOrdinal());
        public final Field INVALID_TRANSPORT_TYPE_REQUESTED = new Field(CollInquiryResult.INSTANCE, Values.INVALID_TRANSPORT_TYPE_REQUESTED.getOrdinal());
        public final Field UNAUTHORIZED_FOR_COLLATERAL_INQUIRY = new Field(CollInquiryResult.INSTANCE, Values.UNAUTHORIZED_FOR_COLLATERAL_INQUIRY.getOrdinal());
        public final Field COLLATERAL_INQUIRY_TYPE_NOT_SUPPORTED = new Field(CollInquiryResult.INSTANCE, Values.COLLATERAL_INQUIRY_TYPE_NOT_SUPPORTED.getOrdinal());
        public final Field OTHER_FURTHER_INFORMATION_IN_TEXT_58_FIELD = new Field(CollInquiryResult.INSTANCE, Values.OTHER_FURTHER_INFORMATION_IN_TEXT_58_FIELD.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INVALID_PARTIES("3"),
        INVALID_OR_UNKNOWN_COLLATERAL_TYPE("2"),
        INVALID_OR_UNKNOWN_INSTRUMENT("1"),
        SUCCESSFUL_DEFAULT("0"),
        NO_COLLATERAL_FOUND_FOR_THE_ORDER_SPECIFIED("7"),
        NO_COLLATERAL_FOUND_FOR_THE_TRADE_SPECIFIED("6"),
        INVALID_DESTINATION_REQUESTED("5"),
        INVALID_TRANSPORT_TYPE_REQUESTED("4"),
        UNAUTHORIZED_FOR_COLLATERAL_INQUIRY("9"),
        COLLATERAL_INQUIRY_TYPE_NOT_SUPPORTED("8"),
        OTHER_FURTHER_INFORMATION_IN_TEXT_58_FIELD("99");

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
