package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RegistRejReasonCode extends BaseFieldType {
    public static final RegistRejReasonCode INSTANCE = new RegistRejReasonCode();

    private RegistRejReasonCode() {
        super(
            "RegistRejReasonCode",
            507,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INVALIDUNACCEPTABLE_CASH_DISTRIB_AGENT_CODE = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_CASH_DISTRIB_AGENT_CODE.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_CASH_DISTRIB_AGENT_ACCT_NUM = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_CASH_DISTRIB_AGENT_ACCT_NUM.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_DISTRIB_PAYMENT_METHOD = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_DISTRIB_PAYMENT_METHOD.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_CASH_DISTRIB_AGENT_ACCT_NAME = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_CASH_DISTRIB_AGENT_ACCT_NAME.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_NO_DISTRIB_INSTNS = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_NO_DISTRIB_INSTNS.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_DISTRIB_PERCENTAGE = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_DISTRIB_PERCENTAGE.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_DATE_OF_BIRTH = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_DATE_OF_BIRTH.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_INVESTOR_COUNTRY_OF_RESIDENCE = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_INVESTOR_COUNTRY_OF_RESIDENCE.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_OWNERSHIP_TYPE = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_OWNERSHIP_TYPE.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_TAX_EXEMPT_TYPE = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_TAX_EXEMPT_TYPE.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_ACCOUNT_TYPE = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_ACCOUNT_TYPE.getOrdinal());
        public final Field INVALIDUNACEEPTABLE_INVESTOR_ID_SOURCE = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACEEPTABLE_INVESTOR_ID_SOURCE.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_MAILING_DETAILS = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_MAILING_DETAILS.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_REG_DETAILS = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_REG_DETAILS.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_REG_SEQ_NO = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_REG_SEQ_NO.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_NO_REG_DETAILS = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_NO_REG_DETAILS.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_INVESTOR_ID = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_INVESTOR_ID.getOrdinal());
        public final Field INVALIDUNACCEPTABLE_MAILING_INSTRUCTIONS = new Field(RegistRejReasonCode.INSTANCE, Values.INVALIDUNACCEPTABLE_MAILING_INSTRUCTIONS.getOrdinal());
        public final Field OTHER = new Field(RegistRejReasonCode.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INVALIDUNACCEPTABLE_CASH_DISTRIB_AGENT_CODE("17"),
        INVALIDUNACCEPTABLE_CASH_DISTRIB_AGENT_ACCT_NUM("18"),
        INVALIDUNACCEPTABLE_DISTRIB_PAYMENT_METHOD("15"),
        INVALIDUNACCEPTABLE_CASH_DISTRIB_AGENT_ACCT_NAME("16"),
        INVALIDUNACCEPTABLE_NO_DISTRIB_INSTNS("13"),
        INVALIDUNACCEPTABLE_DISTRIB_PERCENTAGE("14"),
        INVALIDUNACCEPTABLE_DATE_OF_BIRTH("11"),
        INVALIDUNACCEPTABLE_INVESTOR_COUNTRY_OF_RESIDENCE("12"),
        INVALIDUNACCEPTABLE_OWNERSHIP_TYPE("3"),
        INVALIDUNACCEPTABLE_TAX_EXEMPT_TYPE("2"),
        INVALIDUNACCEPTABLE_ACCOUNT_TYPE("1"),
        INVALIDUNACEEPTABLE_INVESTOR_ID_SOURCE("10"),
        INVALIDUNACCEPTABLE_MAILING_DETAILS("7"),
        INVALIDUNACCEPTABLE_REG_DETAILS("6"),
        INVALIDUNACCEPTABLE_REG_SEQ_NO("5"),
        INVALIDUNACCEPTABLE_NO_REG_DETAILS("4"),
        INVALIDUNACCEPTABLE_INVESTOR_ID("9"),
        INVALIDUNACCEPTABLE_MAILING_INSTRUCTIONS("8"),
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
