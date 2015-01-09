package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MDQuoteType extends BaseFieldType {
    public static final MDQuoteType INSTANCE = new MDQuoteType();

    private MDQuoteType() {
        super(
            "MDQuoteType",
            1070,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field COUNTER = new Field(MDQuoteType.INSTANCE, Values.COUNTER.getOrdinal());
        public final Field RESTRICTED_TRADEABLE = new Field(MDQuoteType.INSTANCE, Values.RESTRICTED_TRADEABLE.getOrdinal());
        public final Field TRADEABLE = new Field(MDQuoteType.INSTANCE, Values.TRADEABLE.getOrdinal());
        public final Field INDICATIVE = new Field(MDQuoteType.INSTANCE, Values.INDICATIVE.getOrdinal());
        public final Field INDICATIVE_AND_TRADEABLE = new Field(MDQuoteType.INSTANCE, Values.INDICATIVE_AND_TRADEABLE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        COUNTER("3"),
        RESTRICTED_TRADEABLE("2"),
        TRADEABLE("1"),
        INDICATIVE("0"),
        INDICATIVE_AND_TRADEABLE("4");

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
