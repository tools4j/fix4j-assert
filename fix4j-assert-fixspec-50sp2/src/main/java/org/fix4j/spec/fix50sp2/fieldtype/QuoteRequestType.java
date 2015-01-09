package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuoteRequestType extends BaseFieldType {
    public static final QuoteRequestType INSTANCE = new QuoteRequestType();

    private QuoteRequestType() {
        super(
            "QuoteRequestType",
            303,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field AUTOMATIC = new Field(QuoteRequestType.INSTANCE, Values.AUTOMATIC.getOrdinal());
        public final Field MANUAL = new Field(QuoteRequestType.INSTANCE, Values.MANUAL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        AUTOMATIC("2"),
        MANUAL("1");

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
