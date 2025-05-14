package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PartyListResponseType extends BaseFieldType {
    public static final PartyListResponseType INSTANCE = new PartyListResponseType();

    private PartyListResponseType() {
        super(
            "PartyListResponseType",
            1507,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INCLUDE_RISK_LIMIT_INFORMATION = new Field(PartyListResponseType.INSTANCE, Values.INCLUDE_RISK_LIMIT_INFORMATION.getOrdinal());
        public final Field INCLUDE_INFORMATION_ON_RELATED_PARTIES = new Field(PartyListResponseType.INSTANCE, Values.INCLUDE_INFORMATION_ON_RELATED_PARTIES.getOrdinal());
        public final Field RETURN_ONLY_PARTY_INFORMATION_EXCLUDES_INFORMATION_LIKE_RISK_LIM = new Field(PartyListResponseType.INSTANCE, Values.RETURN_ONLY_PARTY_INFORMATION_EXCLUDES_INFORMATION_LIKE_RISK_LIM.getOrdinal());
        public final Field RETURN_ALL_AVAILABLE_INFORMATION_ON_PARTIES_AND_RELATED_PARTIES_ = new Field(PartyListResponseType.INSTANCE, Values.RETURN_ALL_AVAILABLE_INFORMATION_ON_PARTIES_AND_RELATED_PARTIES_.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INCLUDE_RISK_LIMIT_INFORMATION("3"),
        INCLUDE_INFORMATION_ON_RELATED_PARTIES("2"),
        RETURN_ONLY_PARTY_INFORMATION_EXCLUDES_INFORMATION_LIKE_RISK_LIM("1"),
        RETURN_ALL_AVAILABLE_INFORMATION_ON_PARTIES_AND_RELATED_PARTIES_("0");

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
