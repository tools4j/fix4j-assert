package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TrdRptStatus extends BaseFieldType {
    public static final TrdRptStatus INSTANCE = new TrdRptStatus();

    private TrdRptStatus() {
        super(
            "TrdRptStatus",
            939,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ACCEPTED_WITH_ERRORS = new Field(TrdRptStatus.INSTANCE, Values.ACCEPTED_WITH_ERRORS.getOrdinal());
        public final Field REJECTED = new Field(TrdRptStatus.INSTANCE, Values.REJECTED.getOrdinal());
        public final Field ACCEPTED = new Field(TrdRptStatus.INSTANCE, Values.ACCEPTED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ACCEPTED_WITH_ERRORS("3"),
        REJECTED("1"),
        ACCEPTED("0");

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
