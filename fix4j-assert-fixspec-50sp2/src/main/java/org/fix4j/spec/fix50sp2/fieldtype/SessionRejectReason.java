package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SessionRejectReason extends BaseFieldType {
    public static final SessionRejectReason INSTANCE = new SessionRejectReason();

    private SessionRejectReason() {
        super(
            "SessionRejectReason",
            373,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NON_DATA_VALUE_INCLUDES_FIELD_DELIMITER_SOH_CHARACTER = new Field(SessionRejectReason.INSTANCE, Values.NON_DATA_VALUE_INCLUDES_FIELD_DELIMITER_SOH_CHARACTER.getOrdinal());
        public final Field INVALIDUNSUPPORTED_APPLICATION_VERSION = new Field(SessionRejectReason.INSTANCE, Values.INVALIDUNSUPPORTED_APPLICATION_VERSION.getOrdinal());
        public final Field REPEATING_GROUP_FIELDS_OUT_OF_ORDER = new Field(SessionRejectReason.INSTANCE, Values.REPEATING_GROUP_FIELDS_OUT_OF_ORDER.getOrdinal());
        public final Field INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP = new Field(SessionRejectReason.INSTANCE, Values.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP.getOrdinal());
        public final Field TAG_APPEARS_MORE_THAN_ONCE = new Field(SessionRejectReason.INSTANCE, Values.TAG_APPEARS_MORE_THAN_ONCE.getOrdinal());
        public final Field TAG_SPECIFIED_OUT_OF_REQUIRED_ORDER = new Field(SessionRejectReason.INSTANCE, Values.TAG_SPECIFIED_OUT_OF_REQUIRED_ORDER.getOrdinal());
        public final Field INVALID_MSGTYPE = new Field(SessionRejectReason.INSTANCE, Values.INVALID_MSGTYPE.getOrdinal());
        public final Field XML_VALIDATION_ERROR = new Field(SessionRejectReason.INSTANCE, Values.XML_VALIDATION_ERROR.getOrdinal());
        public final Field UNDEFINED_TAG = new Field(SessionRejectReason.INSTANCE, Values.UNDEFINED_TAG.getOrdinal());
        public final Field TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE = new Field(SessionRejectReason.INSTANCE, Values.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE.getOrdinal());
        public final Field REQUIRED_TAG_MISSING = new Field(SessionRejectReason.INSTANCE, Values.REQUIRED_TAG_MISSING.getOrdinal());
        public final Field SENDINGTIME_ACCURACY_PROBLEM = new Field(SessionRejectReason.INSTANCE, Values.SENDINGTIME_ACCURACY_PROBLEM.getOrdinal());
        public final Field INVALID_TAG_NUMBER = new Field(SessionRejectReason.INSTANCE, Values.INVALID_TAG_NUMBER.getOrdinal());
        public final Field DECRYPTION_PROBLEM = new Field(SessionRejectReason.INSTANCE, Values.DECRYPTION_PROBLEM.getOrdinal());
        public final Field INCORRECT_DATA_FORMAT_FOR_VALUE = new Field(SessionRejectReason.INSTANCE, Values.INCORRECT_DATA_FORMAT_FOR_VALUE.getOrdinal());
        public final Field VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG = new Field(SessionRejectReason.INSTANCE, Values.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG.getOrdinal());
        public final Field TAG_SPECIFIED_WITHOUT_A_VALUE = new Field(SessionRejectReason.INSTANCE, Values.TAG_SPECIFIED_WITHOUT_A_VALUE.getOrdinal());
        public final Field COMPID_PROBLEM = new Field(SessionRejectReason.INSTANCE, Values.COMPID_PROBLEM.getOrdinal());
        public final Field SIGNATURE_PROBLEM = new Field(SessionRejectReason.INSTANCE, Values.SIGNATURE_PROBLEM.getOrdinal());
        public final Field OTHER = new Field(SessionRejectReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NON_DATA_VALUE_INCLUDES_FIELD_DELIMITER_SOH_CHARACTER("17"),
        INVALIDUNSUPPORTED_APPLICATION_VERSION("18"),
        REPEATING_GROUP_FIELDS_OUT_OF_ORDER("15"),
        INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP("16"),
        TAG_APPEARS_MORE_THAN_ONCE("13"),
        TAG_SPECIFIED_OUT_OF_REQUIRED_ORDER("14"),
        INVALID_MSGTYPE("11"),
        XML_VALIDATION_ERROR("12"),
        UNDEFINED_TAG("3"),
        TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE("2"),
        REQUIRED_TAG_MISSING("1"),
        SENDINGTIME_ACCURACY_PROBLEM("10"),
        INVALID_TAG_NUMBER("0"),
        DECRYPTION_PROBLEM("7"),
        INCORRECT_DATA_FORMAT_FOR_VALUE("6"),
        VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG("5"),
        TAG_SPECIFIED_WITHOUT_A_VALUE("4"),
        COMPID_PROBLEM("9"),
        SIGNATURE_PROBLEM("8"),
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
