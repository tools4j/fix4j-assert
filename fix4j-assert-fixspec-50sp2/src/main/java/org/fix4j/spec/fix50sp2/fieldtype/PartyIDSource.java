package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PartyIDSource extends BaseFieldType {
    public static final PartyIDSource INSTANCE = new PartyIDSource();

    private PartyIDSource() {
        super(
            "PartyIDSource",
            447,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PROPRIETARY__CUSTOM_CODE = new Field(PartyIDSource.INSTANCE, Values.PROPRIETARY__CUSTOM_CODE.getOrdinal());
        public final Field ISO_COUNTRY_CODE = new Field(PartyIDSource.INSTANCE, Values.ISO_COUNTRY_CODE.getOrdinal());
        public final Field SETTLEMENT_ENTITY_LOCATION_NOTE_IF_LOCAL_MARKET_SETTLEMENT_USE_E = new Field(PartyIDSource.INSTANCE, Values.SETTLEMENT_ENTITY_LOCATION_NOTE_IF_LOCAL_MARKET_SETTLEMENT_USE_E.getOrdinal());
        public final Field MIC_ISO_10383__MARKET_IDENTIFICER_CODE_SEE_APPENDIX_6C = new Field(PartyIDSource.INSTANCE, Values.MIC_ISO_10383__MARKET_IDENTIFICER_CODE_SEE_APPENDIX_6C.getOrdinal());
        public final Field AUSTRALIAN_TAX_FILE_NUMBER = new Field(PartyIDSource.INSTANCE, Values.AUSTRALIAN_TAX_FILE_NUMBER.getOrdinal());
        public final Field BIC_BANK_IDENTIFICATION_CODE__SWIFT_MANAGED_CODE_ISO9362__SEE_AP = new Field(PartyIDSource.INSTANCE, Values.BIC_BANK_IDENTIFICATION_CODE__SWIFT_MANAGED_CODE_ISO9362__SEE_AP.getOrdinal());
        public final Field GENERALLY_ACCEPTED_MARKET_PARTICIPANT_IDENTIFIER_EG_NASD_MNEMONI = new Field(PartyIDSource.INSTANCE, Values.GENERALLY_ACCEPTED_MARKET_PARTICIPANT_IDENTIFIER_EG_NASD_MNEMONI.getOrdinal());
        public final Field CSD_PARTICIPANTMEMBER_CODE_EG_EUROCLEAR_DTC_CREST_OR_KASSENVEREI = new Field(PartyIDSource.INSTANCE, Values.CSD_PARTICIPANTMEMBER_CODE_EG_EUROCLEAR_DTC_CREST_OR_KASSENVEREI.getOrdinal());
        public final Field DIRECTED_BROKER_THREE_CHARACTER_ACRONYM_AS_DEFINED_IN_ISITC_ETC_ = new Field(PartyIDSource.INSTANCE, Values.DIRECTED_BROKER_THREE_CHARACTER_ACRONYM_AS_DEFINED_IN_ISITC_ETC_.getOrdinal());
        public final Field TAIWANESE_TRADING_ACCT = new Field(PartyIDSource.INSTANCE, Values.TAIWANESE_TRADING_ACCT.getOrdinal());
        public final Field TAIWANESE_QUALIFIED_FOREIGN_INVESTOR_ID_QFIIFID = new Field(PartyIDSource.INSTANCE, Values.TAIWANESE_QUALIFIED_FOREIGN_INVESTOR_ID_QFIIFID.getOrdinal());
        public final Field KOREAN_INVESTOR_ID = new Field(PartyIDSource.INSTANCE, Values.KOREAN_INVESTOR_ID.getOrdinal());
        public final Field US_SOCIAL_SECURITY_NUMBER = new Field(PartyIDSource.INSTANCE, Values.US_SOCIAL_SECURITY_NUMBER.getOrdinal());
        public final Field UK_NATIONAL_INSURANCE_OR_PENSION_NUMBER = new Field(PartyIDSource.INSTANCE, Values.UK_NATIONAL_INSURANCE_OR_PENSION_NUMBER.getOrdinal());
        public final Field CHINESE_INVESTOR_ID = new Field(PartyIDSource.INSTANCE, Values.CHINESE_INVESTOR_ID.getOrdinal());
        public final Field MALAYSIAN_CENTRAL_DEPOSITORY_MCD_NUMBER = new Field(PartyIDSource.INSTANCE, Values.MALAYSIAN_CENTRAL_DEPOSITORY_MCD_NUMBER.getOrdinal());
        public final Field AUSTRALIAN_BUSINESS_NUMBER = new Field(PartyIDSource.INSTANCE, Values.AUSTRALIAN_BUSINESS_NUMBER.getOrdinal());
        public final Field US_EMPLOYER_OR_TAX_ID_NUMBER = new Field(PartyIDSource.INSTANCE, Values.US_EMPLOYER_OR_TAX_ID_NUMBER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PROPRIETARY__CUSTOM_CODE("D"),
        ISO_COUNTRY_CODE("E"),
        SETTLEMENT_ENTITY_LOCATION_NOTE_IF_LOCAL_MARKET_SETTLEMENT_USE_E("F"),
        MIC_ISO_10383__MARKET_IDENTIFICER_CODE_SEE_APPENDIX_6C("G"),
        AUSTRALIAN_TAX_FILE_NUMBER("A"),
        BIC_BANK_IDENTIFICATION_CODE__SWIFT_MANAGED_CODE_ISO9362__SEE_AP("B"),
        GENERALLY_ACCEPTED_MARKET_PARTICIPANT_IDENTIFIER_EG_NASD_MNEMONI("C"),
        CSD_PARTICIPANTMEMBER_CODE_EG_EUROCLEAR_DTC_CREST_OR_KASSENVEREI("H"),
        DIRECTED_BROKER_THREE_CHARACTER_ACRONYM_AS_DEFINED_IN_ISITC_ETC_("I"),
        TAIWANESE_TRADING_ACCT("3"),
        TAIWANESE_QUALIFIED_FOREIGN_INVESTOR_ID_QFIIFID("2"),
        KOREAN_INVESTOR_ID("1"),
        US_SOCIAL_SECURITY_NUMBER("7"),
        UK_NATIONAL_INSURANCE_OR_PENSION_NUMBER("6"),
        CHINESE_INVESTOR_ID("5"),
        MALAYSIAN_CENTRAL_DEPOSITORY_MCD_NUMBER("4"),
        AUSTRALIAN_BUSINESS_NUMBER("9"),
        US_EMPLOYER_OR_TAX_ID_NUMBER("8");

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
