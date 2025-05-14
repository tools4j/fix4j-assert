package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PosReqType extends BaseFieldType {
    public static final PosReqType INSTANCE = new PosReqType();

    private PosReqType() {
        super(
            "PosReqType",
            724,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ASSIGNMENTS = new Field(PosReqType.INSTANCE, Values.ASSIGNMENTS.getOrdinal());
        public final Field EXERCISES = new Field(PosReqType.INSTANCE, Values.EXERCISES.getOrdinal());
        public final Field TRADES = new Field(PosReqType.INSTANCE, Values.TRADES.getOrdinal());
        public final Field POSITIONS = new Field(PosReqType.INSTANCE, Values.POSITIONS.getOrdinal());
        public final Field DELTA_POSITIONS = new Field(PosReqType.INSTANCE, Values.DELTA_POSITIONS.getOrdinal());
        public final Field BACKOUT_MESSAGE = new Field(PosReqType.INSTANCE, Values.BACKOUT_MESSAGE.getOrdinal());
        public final Field SETTLEMENT_ACTIVITY = new Field(PosReqType.INSTANCE, Values.SETTLEMENT_ACTIVITY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ASSIGNMENTS("3"),
        EXERCISES("2"),
        TRADES("1"),
        POSITIONS("0"),
        DELTA_POSITIONS("6"),
        BACKOUT_MESSAGE("5"),
        SETTLEMENT_ACTIVITY("4");

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
