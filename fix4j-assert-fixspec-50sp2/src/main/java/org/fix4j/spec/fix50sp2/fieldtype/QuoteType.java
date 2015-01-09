package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuoteType extends BaseFieldType {
    public static final QuoteType INSTANCE = new QuoteType();

    private QuoteType() {
        super(
            "QuoteType",
            537,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field COUNTER_TRADEABLE = new Field(QuoteType.INSTANCE, Values.COUNTER_TRADEABLE.getOrdinal());
        public final Field RESTRICTED_TRADEABLE = new Field(QuoteType.INSTANCE, Values.RESTRICTED_TRADEABLE.getOrdinal());
        public final Field TRADEABLE = new Field(QuoteType.INSTANCE, Values.TRADEABLE.getOrdinal());
        public final Field INDICATIVE = new Field(QuoteType.INSTANCE, Values.INDICATIVE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        COUNTER_TRADEABLE("3"),
        RESTRICTED_TRADEABLE("2"),
        TRADEABLE("1"),
        INDICATIVE("0");

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
