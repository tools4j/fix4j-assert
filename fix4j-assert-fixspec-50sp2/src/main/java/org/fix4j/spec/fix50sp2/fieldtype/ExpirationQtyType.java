package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExpirationQtyType extends BaseFieldType {
    public static final ExpirationQtyType INSTANCE = new ExpirationQtyType();

    private ExpirationQtyType() {
        super(
            "ExpirationQtyType",
            982,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FINAL_WILL_BE_EXERCISED = new Field(ExpirationQtyType.INSTANCE, Values.FINAL_WILL_BE_EXERCISED.getOrdinal());
        public final Field NON_AUTO_EXERCISE = new Field(ExpirationQtyType.INSTANCE, Values.NON_AUTO_EXERCISE.getOrdinal());
        public final Field AUTO_EXERCISE = new Field(ExpirationQtyType.INSTANCE, Values.AUTO_EXERCISE.getOrdinal());
        public final Field DIFFERENCE = new Field(ExpirationQtyType.INSTANCE, Values.DIFFERENCE.getOrdinal());
        public final Field CONTRARY_INTENTION = new Field(ExpirationQtyType.INSTANCE, Values.CONTRARY_INTENTION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FINAL_WILL_BE_EXERCISED("3"),
        NON_AUTO_EXERCISE("2"),
        AUTO_EXERCISE("1"),
        DIFFERENCE("5"),
        CONTRARY_INTENTION("4");

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
