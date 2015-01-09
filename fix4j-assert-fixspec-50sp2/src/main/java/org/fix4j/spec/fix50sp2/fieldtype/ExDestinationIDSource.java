package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExDestinationIDSource extends BaseFieldType {
    public static final ExDestinationIDSource INSTANCE = new ExDestinationIDSource();

    private ExDestinationIDSource() {
        super(
            "ExDestinationIDSource",
            1133,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PROPRIETARY__CUSTOM_CODE = new Field(ExDestinationIDSource.INSTANCE, Values.PROPRIETARY__CUSTOM_CODE.getOrdinal());
        public final Field ISO_COUNTRY_CODE = new Field(ExDestinationIDSource.INSTANCE, Values.ISO_COUNTRY_CODE.getOrdinal());
        public final Field MIC_ISO_10383__MARKET_IDENTIFIER_CODE = new Field(ExDestinationIDSource.INSTANCE, Values.MIC_ISO_10383__MARKET_IDENTIFIER_CODE.getOrdinal());
        public final Field BIC_BANK_IDENTIFICATION_CODE_ISO_9362 = new Field(ExDestinationIDSource.INSTANCE, Values.BIC_BANK_IDENTIFICATION_CODE_ISO_9362.getOrdinal());
        public final Field GENERALLY_ACCEPTED_MARKET_PARTICIPANT_IDENTIFIER_EG_NASD_MNEMONI = new Field(ExDestinationIDSource.INSTANCE, Values.GENERALLY_ACCEPTED_MARKET_PARTICIPANT_IDENTIFIER_EG_NASD_MNEMONI.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PROPRIETARY__CUSTOM_CODE("D"),
        ISO_COUNTRY_CODE("E"),
        MIC_ISO_10383__MARKET_IDENTIFIER_CODE("G"),
        BIC_BANK_IDENTIFICATION_CODE_ISO_9362("B"),
        GENERALLY_ACCEPTED_MARKET_PARTICIPANT_IDENTIFIER_EG_NASD_MNEMONI("C");

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
