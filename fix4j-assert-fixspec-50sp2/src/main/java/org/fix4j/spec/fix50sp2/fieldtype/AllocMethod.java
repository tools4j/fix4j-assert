package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocMethod extends BaseFieldType {
    public static final AllocMethod INSTANCE = new AllocMethod();

    private AllocMethod() {
        super(
            "AllocMethod",
            1002,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MANUAL = new Field(AllocMethod.INSTANCE, Values.MANUAL.getOrdinal());
        public final Field GUARANTOR = new Field(AllocMethod.INSTANCE, Values.GUARANTOR.getOrdinal());
        public final Field AUTOMATIC = new Field(AllocMethod.INSTANCE, Values.AUTOMATIC.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MANUAL("3"),
        GUARANTOR("2"),
        AUTOMATIC("1");

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
