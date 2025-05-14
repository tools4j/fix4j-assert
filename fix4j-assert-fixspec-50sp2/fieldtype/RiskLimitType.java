package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RiskLimitType extends BaseFieldType {
    public static final RiskLimitType INSTANCE = new RiskLimitType();

    private RiskLimitType() {
        super(
            "RiskLimitType",
            1530,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXPOSURE = new Field(RiskLimitType.INSTANCE, Values.EXPOSURE.getOrdinal());
        public final Field NET_LIMIT = new Field(RiskLimitType.INSTANCE, Values.NET_LIMIT.getOrdinal());
        public final Field GROSS_LIMIT = new Field(RiskLimitType.INSTANCE, Values.GROSS_LIMIT.getOrdinal());
        public final Field SHORT_LIMIT = new Field(RiskLimitType.INSTANCE, Values.SHORT_LIMIT.getOrdinal());
        public final Field LONG_LIMIT = new Field(RiskLimitType.INSTANCE, Values.LONG_LIMIT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXPOSURE("3"),
        NET_LIMIT("2"),
        GROSS_LIMIT("1"),
        SHORT_LIMIT("5"),
        LONG_LIMIT("4");

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
