package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityListTypeSource extends BaseFieldType {
    public static final SecurityListTypeSource INSTANCE = new SecurityListTypeSource();

    private SecurityListTypeSource() {
        super(
            "SecurityListTypeSource",
            1471,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field GICS_GLOBAL_INDUSTRY_CLASSIFICATION_STANDARD_PUBLISHED_BY_STANDA = new Field(SecurityListTypeSource.INSTANCE, Values.GICS_GLOBAL_INDUSTRY_CLASSIFICATION_STANDARD_PUBLISHED_BY_STANDA.getOrdinal());
        public final Field NAICS_NORTH_AMERICAN_INDUSTRY_CLASSIFICATION_SYSTEM_REPLACED_SIC = new Field(SecurityListTypeSource.INSTANCE, Values.NAICS_NORTH_AMERICAN_INDUSTRY_CLASSIFICATION_SYSTEM_REPLACED_SIC.getOrdinal());
        public final Field ICB_INDUSTRY_CLASSIFICATION_BENCHMARK_PUBLISHED_BY_DOW_JONES_AND = new Field(SecurityListTypeSource.INSTANCE, Values.ICB_INDUSTRY_CLASSIFICATION_BENCHMARK_PUBLISHED_BY_DOW_JONES_AND.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        GICS_GLOBAL_INDUSTRY_CLASSIFICATION_STANDARD_PUBLISHED_BY_STANDA("3"),
        NAICS_NORTH_AMERICAN_INDUSTRY_CLASSIFICATION_SYSTEM_REPLACED_SIC("2"),
        ICB_INDUSTRY_CLASSIFICATION_BENCHMARK_PUBLISHED_BY_DOW_JONES_AND("1");

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
