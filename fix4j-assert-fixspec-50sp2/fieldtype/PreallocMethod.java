package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PreallocMethod extends BaseFieldType {
    public static final PreallocMethod INSTANCE = new PreallocMethod();

    private PreallocMethod() {
        super(
            "PreallocMethod",
            591,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DO_NOT_PRORATA__DISCUSS_FIRST = new Field(PreallocMethod.INSTANCE, Values.DO_NOT_PRORATA__DISCUSS_FIRST.getOrdinal());
        public final Field PRORATA = new Field(PreallocMethod.INSTANCE, Values.PRORATA.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DO_NOT_PRORATA__DISCUSS_FIRST("1"),
        PRORATA("0");

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
