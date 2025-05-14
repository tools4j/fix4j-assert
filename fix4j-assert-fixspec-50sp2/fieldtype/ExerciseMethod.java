package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExerciseMethod extends BaseFieldType {
    public static final ExerciseMethod INSTANCE = new ExerciseMethod();

    private ExerciseMethod() {
        super(
            "ExerciseMethod",
            747,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field AUTOMATIC = new Field(ExerciseMethod.INSTANCE, Values.AUTOMATIC.getOrdinal());
        public final Field MANUAL = new Field(ExerciseMethod.INSTANCE, Values.MANUAL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        AUTOMATIC("A"),
        MANUAL("M");

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
