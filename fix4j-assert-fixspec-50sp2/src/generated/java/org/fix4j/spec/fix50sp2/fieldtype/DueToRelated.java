package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DueToRelated extends BaseFieldType {
    public static final DueToRelated INSTANCE = new DueToRelated();

    private DueToRelated() {
        super(
            "DueToRelated",
            329,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field HALT_WAS_NOT_RELATED_TO_A_HALT_OF_THE_RELATED_SECURITY = new Field(DueToRelated.INSTANCE, Values.HALT_WAS_NOT_RELATED_TO_A_HALT_OF_THE_RELATED_SECURITY.getOrdinal());
        public final Field HALT_WAS_DUE_TO_RELATED_SECURITY_BEING_HALTED = new Field(DueToRelated.INSTANCE, Values.HALT_WAS_DUE_TO_RELATED_SECURITY_BEING_HALTED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        HALT_WAS_NOT_RELATED_TO_A_HALT_OF_THE_RELATED_SECURITY("N"),
        HALT_WAS_DUE_TO_RELATED_SECURITY_BEING_HALTED("Y");

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
