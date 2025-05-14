package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AggregatedBook extends BaseFieldType {
    public static final AggregatedBook INSTANCE = new AggregatedBook();

    private AggregatedBook() {
        super(
            "AggregatedBook",
            266,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BOOK_ENTRIES_SHOULD_NOT_BE_AGGREGATED = new Field(AggregatedBook.INSTANCE, Values.BOOK_ENTRIES_SHOULD_NOT_BE_AGGREGATED.getOrdinal());
        public final Field BOOK_ENTRIES_TO_BE_AGGREGATED = new Field(AggregatedBook.INSTANCE, Values.BOOK_ENTRIES_TO_BE_AGGREGATED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BOOK_ENTRIES_SHOULD_NOT_BE_AGGREGATED("N"),
        BOOK_ENTRIES_TO_BE_AGGREGATED("Y");

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
