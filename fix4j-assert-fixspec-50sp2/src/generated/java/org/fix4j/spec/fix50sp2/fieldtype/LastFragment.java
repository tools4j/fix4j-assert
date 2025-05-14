package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class LastFragment extends BaseFieldType {
    public static final LastFragment INSTANCE = new LastFragment();

    private LastFragment() {
        super(
            "LastFragment",
            893,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NOT_LAST_MESSAGE = new Field(LastFragment.INSTANCE, Values.NOT_LAST_MESSAGE.getOrdinal());
        public final Field LAST_MESSAGE = new Field(LastFragment.INSTANCE, Values.LAST_MESSAGE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NOT_LAST_MESSAGE("N"),
        LAST_MESSAGE("Y");

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
