package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PartyDetailsRequestResult extends BaseFieldType {
    public static final PartyDetailsRequestResult INSTANCE = new PartyDetailsRequestResult();

    private PartyDetailsRequestResult() {
        super(
            "PartyDetailsRequestResult",
            1511,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field UNSUPPORTED_PARTYLISTRESPONSETYPE = new Field(PartyDetailsRequestResult.INSTANCE, Values.UNSUPPORTED_PARTYLISTRESPONSETYPE.getOrdinal());
        public final Field NO_PARTIES_OR_PARTY_DETAILS_FOUND_THAT_MATCH_SELECTION_CRITERIA = new Field(PartyDetailsRequestResult.INSTANCE, Values.NO_PARTIES_OR_PARTY_DETAILS_FOUND_THAT_MATCH_SELECTION_CRITERIA.getOrdinal());
        public final Field INVALID_OR_UNSUPPORTED_REQUEST = new Field(PartyDetailsRequestResult.INSTANCE, Values.INVALID_OR_UNSUPPORTED_REQUEST.getOrdinal());
        public final Field VALID_REQUEST = new Field(PartyDetailsRequestResult.INSTANCE, Values.VALID_REQUEST.getOrdinal());
        public final Field REQUEST_FOR_PARTIES_DATA_NOT_SUPPORTED = new Field(PartyDetailsRequestResult.INSTANCE, Values.REQUEST_FOR_PARTIES_DATA_NOT_SUPPORTED.getOrdinal());
        public final Field PARTIES_OR_PARTY_DETAILS_DATA_TEMPORARILY_UNAVAILABLE = new Field(PartyDetailsRequestResult.INSTANCE, Values.PARTIES_OR_PARTY_DETAILS_DATA_TEMPORARILY_UNAVAILABLE.getOrdinal());
        public final Field NOT_AUTHORIZED_TO_RETRIEVE_PARTIES_OR_PARTY_DETAILS_DATA = new Field(PartyDetailsRequestResult.INSTANCE, Values.NOT_AUTHORIZED_TO_RETRIEVE_PARTIES_OR_PARTY_DETAILS_DATA.getOrdinal());
        public final Field OTHER_FURTHER_INFORMATION_IN_TEXT_58_FIELD = new Field(PartyDetailsRequestResult.INSTANCE, Values.OTHER_FURTHER_INFORMATION_IN_TEXT_58_FIELD.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        UNSUPPORTED_PARTYLISTRESPONSETYPE("3"),
        NO_PARTIES_OR_PARTY_DETAILS_FOUND_THAT_MATCH_SELECTION_CRITERIA("2"),
        INVALID_OR_UNSUPPORTED_REQUEST("1"),
        VALID_REQUEST("0"),
        REQUEST_FOR_PARTIES_DATA_NOT_SUPPORTED("6"),
        PARTIES_OR_PARTY_DETAILS_DATA_TEMPORARILY_UNAVAILABLE("5"),
        NOT_AUTHORIZED_TO_RETRIEVE_PARTIES_OR_PARTY_DETAILS_DATA("4"),
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
