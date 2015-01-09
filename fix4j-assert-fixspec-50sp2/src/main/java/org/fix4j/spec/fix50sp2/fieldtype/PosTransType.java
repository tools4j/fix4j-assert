package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PosTransType extends BaseFieldType {
    public static final PosTransType INSTANCE = new PosTransType();

    private PosTransType() {
        super(
            "PosTransType",
            709,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field POSITION_ADJUSTMENT = new Field(PosTransType.INSTANCE, Values.POSITION_ADJUSTMENT.getOrdinal());
        public final Field DO_NOT_EXERCISE = new Field(PosTransType.INSTANCE, Values.DO_NOT_EXERCISE.getOrdinal());
        public final Field EXERCISE = new Field(PosTransType.INSTANCE, Values.EXERCISE.getOrdinal());
        public final Field LARGE_TRADER_SUBMISSION = new Field(PosTransType.INSTANCE, Values.LARGE_TRADER_SUBMISSION.getOrdinal());
        public final Field PLEDGE = new Field(PosTransType.INSTANCE, Values.PLEDGE.getOrdinal());
        public final Field POSITION_CHANGE_SUBMISSIONMARGIN_DISPOSITION = new Field(PosTransType.INSTANCE, Values.POSITION_CHANGE_SUBMISSIONMARGIN_DISPOSITION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        POSITION_ADJUSTMENT("3"),
        DO_NOT_EXERCISE("2"),
        EXERCISE("1"),
        LARGE_TRADER_SUBMISSION("6"),
        PLEDGE("5"),
        POSITION_CHANGE_SUBMISSIONMARGIN_DISPOSITION("4");

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
