package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PosReqStatus extends BaseFieldType {
    public static final PosReqStatus INSTANCE = new PosReqStatus();

    private PosReqStatus() {
        super(
            "PosReqStatus",
            729,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REJECTED = new Field(PosReqStatus.INSTANCE, Values.REJECTED.getOrdinal());
        public final Field COMPLETED_WITH_WARNINGS = new Field(PosReqStatus.INSTANCE, Values.COMPLETED_WITH_WARNINGS.getOrdinal());
        public final Field COMPLETED = new Field(PosReqStatus.INSTANCE, Values.COMPLETED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REJECTED("2"),
        COMPLETED_WITH_WARNINGS("1"),
        COMPLETED("0");

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
