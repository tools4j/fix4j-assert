package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CoveredOrUncovered extends BaseFieldType {
    public static final CoveredOrUncovered INSTANCE = new CoveredOrUncovered();

    private CoveredOrUncovered() {
        super(
            "CoveredOrUncovered",
            203,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field UNCOVERED = new Field(CoveredOrUncovered.INSTANCE, Values.UNCOVERED.getOrdinal());
        public final Field COVERED = new Field(CoveredOrUncovered.INSTANCE, Values.COVERED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        UNCOVERED("1"),
        COVERED("0");

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
