package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PosMaintResult extends BaseFieldType {
    public static final PosMaintResult INSTANCE = new PosMaintResult();

    private PosMaintResult() {
        super(
            "PosMaintResult",
            723,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REJECTED = new Field(PosMaintResult.INSTANCE, Values.REJECTED.getOrdinal());
        public final Field SUCCESSFUL_COMPLETION__NO_WARNINGS_OR_ERRORS = new Field(PosMaintResult.INSTANCE, Values.SUCCESSFUL_COMPLETION__NO_WARNINGS_OR_ERRORS.getOrdinal());
        public final Field OTHER = new Field(PosMaintResult.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REJECTED("1"),
        SUCCESSFUL_COMPLETION__NO_WARNINGS_OR_ERRORS("0"),
        OTHER("99");

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
