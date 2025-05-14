package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CancellationRights extends BaseFieldType {
    public static final CancellationRights INSTANCE = new CancellationRights();

    private CancellationRights() {
        super(
            "CancellationRights",
            480,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NO__WAIVER_AGREEMENT = new Field(CancellationRights.INSTANCE, Values.NO__WAIVER_AGREEMENT.getOrdinal());
        public final Field NO__EXECUTION_ONLY = new Field(CancellationRights.INSTANCE, Values.NO__EXECUTION_ONLY.getOrdinal());
        public final Field NO__INSTITUTIONAL = new Field(CancellationRights.INSTANCE, Values.NO__INSTITUTIONAL.getOrdinal());
        public final Field YES = new Field(CancellationRights.INSTANCE, Values.YES.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NO__WAIVER_AGREEMENT("M"),
        NO__EXECUTION_ONLY("N"),
        NO__INSTITUTIONAL("O"),
        YES("Y");

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
