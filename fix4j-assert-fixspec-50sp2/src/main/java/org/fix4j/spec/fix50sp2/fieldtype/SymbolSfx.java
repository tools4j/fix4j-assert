package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SymbolSfx extends BaseFieldType {
    public static final SymbolSfx INSTANCE = new SymbolSfx();

    private SymbolSfx() {
        super(
            "SymbolSfx",
            65,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EUCP_WITH_LUMPSUM_INTEREST_RATHER_THAN_DISCOUNT_PRICE = new Field(SymbolSfx.INSTANCE, Values.EUCP_WITH_LUMPSUM_INTEREST_RATHER_THAN_DISCOUNT_PRICE.getOrdinal());
        public final Field WHEN_ISSUED_FOR_A_SECURITY_TO_BE_REISSUED_UNDER_AN_OLD_CUSIP_OR_ = new Field(SymbolSfx.INSTANCE, Values.WHEN_ISSUED_FOR_A_SECURITY_TO_BE_REISSUED_UNDER_AN_OLD_CUSIP_OR_.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EUCP_WITH_LUMPSUM_INTEREST_RATHER_THAN_DISCOUNT_PRICE("CD"),
        WHEN_ISSUED_FOR_A_SECURITY_TO_BE_REISSUED_UNDER_AN_OLD_CUSIP_OR_("WI");

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
