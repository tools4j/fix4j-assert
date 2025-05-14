package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DealingCapacity extends BaseFieldType {
    public static final DealingCapacity INSTANCE = new DealingCapacity();

    private DealingCapacity() {
        super(
            "DealingCapacity",
            1048,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PRINCIPAL = new Field(DealingCapacity.INSTANCE, Values.PRINCIPAL.getOrdinal());
        public final Field AGENT = new Field(DealingCapacity.INSTANCE, Values.AGENT.getOrdinal());
        public final Field RISKLESS_PRINCIPAL = new Field(DealingCapacity.INSTANCE, Values.RISKLESS_PRINCIPAL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PRINCIPAL("P"),
        AGENT("A"),
        RISKLESS_PRINCIPAL("R");

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
