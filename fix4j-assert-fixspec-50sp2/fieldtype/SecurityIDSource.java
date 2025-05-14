package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityIDSource extends BaseFieldType {
    public static final SecurityIDSource INSTANCE = new SecurityIDSource();

    private SecurityIDSource() {
        super(
            "SecurityIDSource",
            22,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field VALOREN = new Field(SecurityIDSource.INSTANCE, Values.VALOREN.getOrdinal());
        public final Field SICOVAM = new Field(SecurityIDSource.INSTANCE, Values.SICOVAM.getOrdinal());
        public final Field BELGIAN = new Field(SecurityIDSource.INSTANCE, Values.BELGIAN.getOrdinal());
        public final Field COMMON_CLEARSTREAM_AND_EUROCLEAR = new Field(SecurityIDSource.INSTANCE, Values.COMMON_CLEARSTREAM_AND_EUROCLEAR.getOrdinal());
        public final Field BLOOMBERG_SYMBOL = new Field(SecurityIDSource.INSTANCE, Values.BLOOMBERG_SYMBOL.getOrdinal());
        public final Field WERTPAPIER = new Field(SecurityIDSource.INSTANCE, Values.WERTPAPIER.getOrdinal());
        public final Field DUTCH = new Field(SecurityIDSource.INSTANCE, Values.DUTCH.getOrdinal());
        public final Field LETTER_OF_CREDIT = new Field(SecurityIDSource.INSTANCE, Values.LETTER_OF_CREDIT.getOrdinal());
        public final Field MARKETPLACEASSIGNED_IDENTIFIER = new Field(SecurityIDSource.INSTANCE, Values.MARKETPLACEASSIGNED_IDENTIFIER.getOrdinal());
        public final Field CLEARING_HOUSE__CLEARING_ORGANIZATION = new Field(SecurityIDSource.INSTANCE, Values.CLEARING_HOUSE__CLEARING_ORGANIZATION.getOrdinal());
        public final Field ISDAFPML_PRODUCT_SPECIFICATION_XML_IN_ENCODEDSECURITYDESC = new Field(SecurityIDSource.INSTANCE, Values.ISDAFPML_PRODUCT_SPECIFICATION_XML_IN_ENCODEDSECURITYDESC.getOrdinal());
        public final Field OPTION_PRICE_REPORTING_AUTHORITY = new Field(SecurityIDSource.INSTANCE, Values.OPTION_PRICE_REPORTING_AUTHORITY.getOrdinal());
        public final Field ISDAFPML_PRODUCT_URL_URL_IN_SECURITYID = new Field(SecurityIDSource.INSTANCE, Values.ISDAFPML_PRODUCT_URL_URL_IN_SECURITYID.getOrdinal());
        public final Field QUIK = new Field(SecurityIDSource.INSTANCE, Values.QUIK.getOrdinal());
        public final Field SEDOL = new Field(SecurityIDSource.INSTANCE, Values.SEDOL.getOrdinal());
        public final Field CUSIP = new Field(SecurityIDSource.INSTANCE, Values.CUSIP.getOrdinal());
        public final Field ISO_COUNTRY_CODE = new Field(SecurityIDSource.INSTANCE, Values.ISO_COUNTRY_CODE.getOrdinal());
        public final Field ISO_CURRENCY_CODE = new Field(SecurityIDSource.INSTANCE, Values.ISO_CURRENCY_CODE.getOrdinal());
        public final Field RIC_CODE = new Field(SecurityIDSource.INSTANCE, Values.RIC_CODE.getOrdinal());
        public final Field ISIN_NUMBER = new Field(SecurityIDSource.INSTANCE, Values.ISIN_NUMBER.getOrdinal());
        public final Field CONSOLIDATED_TAPE_ASSOCIATION_CTA_SYMBOL_SIAC_CTSCQS_LINE_FORMAT = new Field(SecurityIDSource.INSTANCE, Values.CONSOLIDATED_TAPE_ASSOCIATION_CTA_SYMBOL_SIAC_CTSCQS_LINE_FORMAT.getOrdinal());
        public final Field EXCHANGE_SYMBOL = new Field(SecurityIDSource.INSTANCE, Values.EXCHANGE_SYMBOL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        VALOREN("D"),
        SICOVAM("E"),
        BELGIAN("F"),
        COMMON_CLEARSTREAM_AND_EUROCLEAR("G"),
        BLOOMBERG_SYMBOL("A"),
        WERTPAPIER("B"),
        DUTCH("C"),
        LETTER_OF_CREDIT("L"),
        MARKETPLACEASSIGNED_IDENTIFIER("M"),
        CLEARING_HOUSE__CLEARING_ORGANIZATION("H"),
        ISDAFPML_PRODUCT_SPECIFICATION_XML_IN_ENCODEDSECURITYDESC("I"),
        OPTION_PRICE_REPORTING_AUTHORITY("J"),
        ISDAFPML_PRODUCT_URL_URL_IN_SECURITYID("K"),
        QUIK("3"),
        SEDOL("2"),
        CUSIP("1"),
        ISO_COUNTRY_CODE("7"),
        ISO_CURRENCY_CODE("6"),
        RIC_CODE("5"),
        ISIN_NUMBER("4"),
        CONSOLIDATED_TAPE_ASSOCIATION_CTA_SYMBOL_SIAC_CTSCQS_LINE_FORMAT("9"),
        EXCHANGE_SYMBOL("8");

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
