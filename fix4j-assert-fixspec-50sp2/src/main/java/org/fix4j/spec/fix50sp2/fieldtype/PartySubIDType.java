package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PartySubIDType extends BaseFieldType {
    public static final PartySubIDType INSTANCE = new PartySubIDType();

    private PartySubIDType() {
        super(
            "PartySubIDType",
            803,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FUND_ACCOUNT_NAME = new Field(PartySubIDType.INSTANCE, Values.FUND_ACCOUNT_NAME.getOrdinal());
        public final Field CSD_PARTICIPANT_MEMBER_CODE = new Field(PartySubIDType.INSTANCE, Values.CSD_PARTICIPANT_MEMBER_CODE.getOrdinal());
        public final Field REGISTERED_ADDRESS = new Field(PartySubIDType.INSTANCE, Values.REGISTERED_ADDRESS.getOrdinal());
        public final Field CURRENCY_DELIVERY_IDENTIFIER = new Field(PartySubIDType.INSTANCE, Values.CURRENCY_DELIVERY_IDENTIFIER.getOrdinal());
        public final Field CASH_ACCOUNT_NUMBER_FOR_SETTLEMENT_INSTRUCTIONS = new Field(PartySubIDType.INSTANCE, Values.CASH_ACCOUNT_NUMBER_FOR_SETTLEMENT_INSTRUCTIONS.getOrdinal());
        public final Field BIC = new Field(PartySubIDType.INSTANCE, Values.BIC.getOrdinal());
        public final Field REGULATORY_STATUS_FOR_CONFIRMATION_PURPOSES = new Field(PartySubIDType.INSTANCE, Values.REGULATORY_STATUS_FOR_CONFIRMATION_PURPOSES.getOrdinal());
        public final Field REGISTRATION_NAME_FOR_SETTLEMENT_INSTRUCTIONS = new Field(PartySubIDType.INSTANCE, Values.REGISTRATION_NAME_FOR_SETTLEMENT_INSTRUCTIONS.getOrdinal());
        public final Field REGISTRATION_NUMBER_FOR_SETTLEMENT_INSTRUCTIONS_AND_CONFIRMATION = new Field(PartySubIDType.INSTANCE, Values.REGISTRATION_NUMBER_FOR_SETTLEMENT_INSTRUCTIONS_AND_CONFIRMATION.getOrdinal());
        public final Field REGISTERED_ADDRESS_FOR_CONFIRMATION_PURPOSES = new Field(PartySubIDType.INSTANCE, Values.REGISTERED_ADDRESS_FOR_CONFIRMATION_PURPOSES.getOrdinal());
        public final Field FAX_NUMBER = new Field(PartySubIDType.INSTANCE, Values.FAX_NUMBER.getOrdinal());
        public final Field TELEX_NUMBER = new Field(PartySubIDType.INSTANCE, Values.TELEX_NUMBER.getOrdinal());
        public final Field SECURITIES_ACCOUNT_NAME = new Field(PartySubIDType.INSTANCE, Values.SECURITIES_ACCOUNT_NAME.getOrdinal());
        public final Field CASH_ACCOUNT_NAME = new Field(PartySubIDType.INSTANCE, Values.CASH_ACCOUNT_NAME.getOrdinal());
        public final Field DEPARTMENT = new Field(PartySubIDType.INSTANCE, Values.DEPARTMENT.getOrdinal());
        public final Field LOCATION_DESK = new Field(PartySubIDType.INSTANCE, Values.LOCATION_DESK.getOrdinal());
        public final Field POSITION_ACCOUNT_TYPE = new Field(PartySubIDType.INSTANCE, Values.POSITION_ACCOUNT_TYPE.getOrdinal());
        public final Field SECURITY_LOCATE_ID = new Field(PartySubIDType.INSTANCE, Values.SECURITY_LOCATE_ID.getOrdinal());
        public final Field MARKET_MAKER = new Field(PartySubIDType.INSTANCE, Values.MARKET_MAKER.getOrdinal());
        public final Field ELIGIBLE_COUNTERPARTY = new Field(PartySubIDType.INSTANCE, Values.ELIGIBLE_COUNTERPARTY.getOrdinal());
        public final Field SYSTEM = new Field(PartySubIDType.INSTANCE, Values.SYSTEM.getOrdinal());
        public final Field PERSON = new Field(PartySubIDType.INSTANCE, Values.PERSON.getOrdinal());
        public final Field SECURITIES_ACCOUNT_NUMBER_FOR_SETTLEMENT_INSTRUCTIONS = new Field(PartySubIDType.INSTANCE, Values.SECURITIES_ACCOUNT_NUMBER_FOR_SETTLEMENT_INSTRUCTIONS.getOrdinal());
        public final Field FIRM = new Field(PartySubIDType.INSTANCE, Values.FIRM.getOrdinal());
        public final Field PROFESSIONAL_CLIENT = new Field(PartySubIDType.INSTANCE, Values.PROFESSIONAL_CLIENT.getOrdinal());
        public final Field PHONE_NUMBER = new Field(PartySubIDType.INSTANCE, Values.PHONE_NUMBER.getOrdinal());
        public final Field POSTAL_ADDRESS = new Field(PartySubIDType.INSTANCE, Values.POSTAL_ADDRESS.getOrdinal());
        public final Field EXECUTION_VENUE = new Field(PartySubIDType.INSTANCE, Values.EXECUTION_VENUE.getOrdinal());
        public final Field FULL_LEGAL_NAME_OF_FIRM = new Field(PartySubIDType.INSTANCE, Values.FULL_LEGAL_NAME_OF_FIRM.getOrdinal());
        public final Field LOCATION = new Field(PartySubIDType.INSTANCE, Values.LOCATION.getOrdinal());
        public final Field APPLICATION = new Field(PartySubIDType.INSTANCE, Values.APPLICATION.getOrdinal());
        public final Field CONTACT_NAME = new Field(PartySubIDType.INSTANCE, Values.CONTACT_NAME.getOrdinal());
        public final Field EMAIL_ADDRESS = new Field(PartySubIDType.INSTANCE, Values.EMAIL_ADDRESS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FUND_ACCOUNT_NAME("19"),
        CSD_PARTICIPANT_MEMBER_CODE("17"),
        REGISTERED_ADDRESS("18"),
        CURRENCY_DELIVERY_IDENTIFIER("33"),
        CASH_ACCOUNT_NUMBER_FOR_SETTLEMENT_INSTRUCTIONS("15"),
        BIC("16"),
        REGULATORY_STATUS_FOR_CONFIRMATION_PURPOSES("13"),
        REGISTRATION_NAME_FOR_SETTLEMENT_INSTRUCTIONS("14"),
        REGISTRATION_NUMBER_FOR_SETTLEMENT_INSTRUCTIONS_AND_CONFIRMATION("11"),
        REGISTERED_ADDRESS_FOR_CONFIRMATION_PURPOSES("12"),
        FAX_NUMBER("21"),
        TELEX_NUMBER("20"),
        SECURITIES_ACCOUNT_NAME("22"),
        CASH_ACCOUNT_NAME("23"),
        DEPARTMENT("24"),
        LOCATION_DESK("25"),
        POSITION_ACCOUNT_TYPE("26"),
        SECURITY_LOCATE_ID("27"),
        MARKET_MAKER("28"),
        ELIGIBLE_COUNTERPARTY("29"),
        SYSTEM("3"),
        PERSON("2"),
        SECURITIES_ACCOUNT_NUMBER_FOR_SETTLEMENT_INSTRUCTIONS("10"),
        FIRM("1"),
        PROFESSIONAL_CLIENT("30"),
        PHONE_NUMBER("7"),
        POSTAL_ADDRESS("6"),
        EXECUTION_VENUE("32"),
        FULL_LEGAL_NAME_OF_FIRM("5"),
        LOCATION("31"),
        APPLICATION("4"),
        CONTACT_NAME("9"),
        EMAIL_ADDRESS("8");

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
