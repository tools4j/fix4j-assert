package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AssignmentMethod extends BaseFieldType {
    public static final AssignmentMethod INSTANCE = new AssignmentMethod();

    private AssignmentMethod() {
        super(
            "AssignmentMethod",
            744,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PRORATA = new Field(AssignmentMethod.INSTANCE, Values.PRORATA.getOrdinal());
        public final Field RANDOM = new Field(AssignmentMethod.INSTANCE, Values.RANDOM.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PRORATA("P"),
        RANDOM("R");

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
