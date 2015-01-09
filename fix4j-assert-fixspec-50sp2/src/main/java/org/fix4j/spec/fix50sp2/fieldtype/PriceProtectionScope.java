package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PriceProtectionScope extends BaseFieldType {
    public static final PriceProtectionScope INSTANCE = new PriceProtectionScope();

    private PriceProtectionScope() {
        super(
            "PriceProtectionScope",
            1092,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field GLOBAL_ACROSS_ALL_MARKETS = new Field(PriceProtectionScope.INSTANCE, Values.GLOBAL_ACROSS_ALL_MARKETS.getOrdinal());
        public final Field NATIONAL_ACROSS_ALL_NATIONAL_MARKETS = new Field(PriceProtectionScope.INSTANCE, Values.NATIONAL_ACROSS_ALL_NATIONAL_MARKETS.getOrdinal());
        public final Field LOCAL_EXCHANGE_ECN_ATS = new Field(PriceProtectionScope.INSTANCE, Values.LOCAL_EXCHANGE_ECN_ATS.getOrdinal());
        public final Field NONE = new Field(PriceProtectionScope.INSTANCE, Values.NONE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        GLOBAL_ACROSS_ALL_MARKETS("3"),
        NATIONAL_ACROSS_ALL_NATIONAL_MARKETS("2"),
        LOCAL_EXCHANGE_ECN_ATS("1"),
        NONE("0");

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
