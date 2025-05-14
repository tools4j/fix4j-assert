package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class LastCapacity extends BaseFieldType {
    public static final LastCapacity INSTANCE = new LastCapacity();

    private LastCapacity() {
        super(
            "LastCapacity",
            29,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CROSS_AS_PRINCIPAL = new Field(LastCapacity.INSTANCE, Values.CROSS_AS_PRINCIPAL.getOrdinal());
        public final Field CROSS_AS_AGENT = new Field(LastCapacity.INSTANCE, Values.CROSS_AS_AGENT.getOrdinal());
        public final Field AGENT = new Field(LastCapacity.INSTANCE, Values.AGENT.getOrdinal());
        public final Field PRINCIPAL = new Field(LastCapacity.INSTANCE, Values.PRINCIPAL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CROSS_AS_PRINCIPAL("3"),
        CROSS_AS_AGENT("2"),
        AGENT("1"),
        PRINCIPAL("4");

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
