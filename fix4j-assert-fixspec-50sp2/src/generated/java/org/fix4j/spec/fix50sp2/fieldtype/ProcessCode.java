package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ProcessCode extends BaseFieldType {
    public static final ProcessCode INSTANCE = new ProcessCode();

    private ProcessCode() {
        super(
            "ProcessCode",
            81,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field STEPOUT = new Field(ProcessCode.INSTANCE, Values.STEPOUT.getOrdinal());
        public final Field STEPIN = new Field(ProcessCode.INSTANCE, Values.STEPIN.getOrdinal());
        public final Field SOFT_DOLLAR = new Field(ProcessCode.INSTANCE, Values.SOFT_DOLLAR.getOrdinal());
        public final Field REGULAR = new Field(ProcessCode.INSTANCE, Values.REGULAR.getOrdinal());
        public final Field PLAN_SPONSOR = new Field(ProcessCode.INSTANCE, Values.PLAN_SPONSOR.getOrdinal());
        public final Field SOFTDOLLAR_STEPOUT = new Field(ProcessCode.INSTANCE, Values.SOFTDOLLAR_STEPOUT.getOrdinal());
        public final Field SOFTDOLLAR_STEPIN = new Field(ProcessCode.INSTANCE, Values.SOFTDOLLAR_STEPIN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        STEPOUT("3"),
        STEPIN("2"),
        SOFT_DOLLAR("1"),
        REGULAR("0"),
        PLAN_SPONSOR("6"),
        SOFTDOLLAR_STEPOUT("5"),
        SOFTDOLLAR_STEPIN("4");

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
