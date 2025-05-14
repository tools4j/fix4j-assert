package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlLocation extends BaseFieldType {
    public static final SettlLocation INSTANCE = new SettlLocation();

    private SettlLocation() {
        super(
            "SettlLocation",
            166,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EURO_CLEAR = new Field(SettlLocation.INSTANCE, Values.EURO_CLEAR.getOrdinal());
        public final Field PHYSICAL = new Field(SettlLocation.INSTANCE, Values.PHYSICAL.getOrdinal());
        public final Field CEDEL = new Field(SettlLocation.INSTANCE, Values.CEDEL.getOrdinal());
        public final Field DEPOSITORY_TRUST_COMPANY = new Field(SettlLocation.INSTANCE, Values.DEPOSITORY_TRUST_COMPANY.getOrdinal());
        public final Field PARTICIPANT_TRUST_COMPANY = new Field(SettlLocation.INSTANCE, Values.PARTICIPANT_TRUST_COMPANY.getOrdinal());
        public final Field FEDERAL_BOOK_ENTRY = new Field(SettlLocation.INSTANCE, Values.FEDERAL_BOOK_ENTRY.getOrdinal());
        public final Field LOCAL_MARKET_SETTLE_LOCATION = new Field(SettlLocation.INSTANCE, Values.LOCAL_MARKET_SETTLE_LOCATION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EURO_CLEAR("EUR"),
        PHYSICAL("PNY"),
        CEDEL("CED"),
        DEPOSITORY_TRUST_COMPANY("DTC"),
        PARTICIPANT_TRUST_COMPANY("PTC"),
        FEDERAL_BOOK_ENTRY("FED"),
        LOCAL_MARKET_SETTLE_LOCATION("ISO_Country_Code");

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
