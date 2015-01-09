package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuoteResponseLevel extends BaseFieldType {
    public static final QuoteResponseLevel INSTANCE = new QuoteResponseLevel();

    private QuoteResponseLevel() {
        super(
            "QuoteResponseLevel",
            301,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SUMMARY_ACKNOWLEDGEMENT = new Field(QuoteResponseLevel.INSTANCE, Values.SUMMARY_ACKNOWLEDGEMENT.getOrdinal());
        public final Field ACKNOWLEDGE_EACH_QUOTE_MESSAGE = new Field(QuoteResponseLevel.INSTANCE, Values.ACKNOWLEDGE_EACH_QUOTE_MESSAGE.getOrdinal());
        public final Field ACKNOWLEDGE_ONLY_NEGATIVE_OR_ERRONEOUS_QUOTES = new Field(QuoteResponseLevel.INSTANCE, Values.ACKNOWLEDGE_ONLY_NEGATIVE_OR_ERRONEOUS_QUOTES.getOrdinal());
        public final Field NO_ACKNOWLEDGEMENT = new Field(QuoteResponseLevel.INSTANCE, Values.NO_ACKNOWLEDGEMENT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SUMMARY_ACKNOWLEDGEMENT("3"),
        ACKNOWLEDGE_EACH_QUOTE_MESSAGE("2"),
        ACKNOWLEDGE_ONLY_NEGATIVE_OR_ERRONEOUS_QUOTES("1"),
        NO_ACKNOWLEDGEMENT("0");

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
