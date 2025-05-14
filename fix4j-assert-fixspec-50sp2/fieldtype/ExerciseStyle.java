package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExerciseStyle extends BaseFieldType {
    public static final ExerciseStyle INSTANCE = new ExerciseStyle();

    private ExerciseStyle() {
        super(
            "ExerciseStyle",
            1194,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BERMUDA = new Field(ExerciseStyle.INSTANCE, Values.BERMUDA.getOrdinal());
        public final Field AMERICAN = new Field(ExerciseStyle.INSTANCE, Values.AMERICAN.getOrdinal());
        public final Field EUROPEAN = new Field(ExerciseStyle.INSTANCE, Values.EUROPEAN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BERMUDA("2"),
        AMERICAN("1"),
        EUROPEAN("0");

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
