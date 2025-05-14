package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ApplResponseType extends BaseFieldType {
    public static final ApplResponseType INSTANCE = new ApplResponseType();

    private ApplResponseType() {
        super(
            "ApplResponseType",
            1348,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MESSAGES_NOT_AVAILABLE = new Field(ApplResponseType.INSTANCE, Values.MESSAGES_NOT_AVAILABLE.getOrdinal());
        public final Field APPLICATION_DOES_NOT_EXIST = new Field(ApplResponseType.INSTANCE, Values.APPLICATION_DOES_NOT_EXIST.getOrdinal());
        public final Field REQUEST_SUCCESSFULLY_PROCESSED = new Field(ApplResponseType.INSTANCE, Values.REQUEST_SUCCESSFULLY_PROCESSED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MESSAGES_NOT_AVAILABLE("2"),
        APPLICATION_DOES_NOT_EXIST("1"),
        REQUEST_SUCCESSFULLY_PROCESSED("0");

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
