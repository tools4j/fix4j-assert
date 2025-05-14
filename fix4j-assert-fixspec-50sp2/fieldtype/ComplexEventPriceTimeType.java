package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ComplexEventPriceTimeType extends BaseFieldType {
    public static final ComplexEventPriceTimeType INSTANCE = new ComplexEventPriceTimeType();

    private ComplexEventPriceTimeType() {
        super(
            "ComplexEventPriceTimeType",
            1489,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SPECIFIED_DATETIME = new Field(ComplexEventPriceTimeType.INSTANCE, Values.SPECIFIED_DATETIME.getOrdinal());
        public final Field IMMEDIATE_AT_ANY_TIME = new Field(ComplexEventPriceTimeType.INSTANCE, Values.IMMEDIATE_AT_ANY_TIME.getOrdinal());
        public final Field EXPIRATION = new Field(ComplexEventPriceTimeType.INSTANCE, Values.EXPIRATION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SPECIFIED_DATETIME("3"),
        IMMEDIATE_AT_ANY_TIME("2"),
        EXPIRATION("1");

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
