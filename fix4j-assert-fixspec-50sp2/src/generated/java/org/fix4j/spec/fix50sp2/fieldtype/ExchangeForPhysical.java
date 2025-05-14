package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExchangeForPhysical extends BaseFieldType {
    public static final ExchangeForPhysical INSTANCE = new ExchangeForPhysical();

    private ExchangeForPhysical() {
        super(
            "ExchangeForPhysical",
            411,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FALSE = new Field(ExchangeForPhysical.INSTANCE, Values.FALSE.getOrdinal());
        public final Field TRUE = new Field(ExchangeForPhysical.INSTANCE, Values.TRUE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FALSE("N"),
        TRUE("Y");

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
