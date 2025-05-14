package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ApplResponseError extends BaseFieldType {
    public static final ApplResponseError INSTANCE = new ApplResponseError();

    private ApplResponseError() {
        super(
            "ApplResponseError",
            1354,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field USER_NOT_AUTHORIZED_FOR_APPLICATION = new Field(ApplResponseError.INSTANCE, Values.USER_NOT_AUTHORIZED_FOR_APPLICATION.getOrdinal());
        public final Field MESSAGES_REQUESTED_ARE_NOT_AVAILABLE = new Field(ApplResponseError.INSTANCE, Values.MESSAGES_REQUESTED_ARE_NOT_AVAILABLE.getOrdinal());
        public final Field APPLICATION_DOES_NOT_EXIST = new Field(ApplResponseError.INSTANCE, Values.APPLICATION_DOES_NOT_EXIST.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        USER_NOT_AUTHORIZED_FOR_APPLICATION("2"),
        MESSAGES_REQUESTED_ARE_NOT_AVAILABLE("1"),
        APPLICATION_DOES_NOT_EXIST("0");

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
