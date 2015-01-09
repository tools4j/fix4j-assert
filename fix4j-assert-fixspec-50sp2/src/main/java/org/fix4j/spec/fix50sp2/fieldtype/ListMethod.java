package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ListMethod extends BaseFieldType {
    public static final ListMethod INSTANCE = new ListMethod();

    private ListMethod() {
        super(
            "ListMethod",
            1198,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field USER_REQUESTED = new Field(ListMethod.INSTANCE, Values.USER_REQUESTED.getOrdinal());
        public final Field PRELISTED_ONLY = new Field(ListMethod.INSTANCE, Values.PRELISTED_ONLY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        USER_REQUESTED("1"),
        PRELISTED_ONLY("0");

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
