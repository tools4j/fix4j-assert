package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TrdRegTimestampType extends BaseFieldType {
    public static final TrdRegTimestampType INSTANCE = new TrdRegTimestampType();

    private TrdRegTimestampType() {
        super(
            "TrdRegTimestampType",
            770,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TIME_OUT = new Field(TrdRegTimestampType.INSTANCE, Values.TIME_OUT.getOrdinal());
        public final Field TIME_IN = new Field(TrdRegTimestampType.INSTANCE, Values.TIME_IN.getOrdinal());
        public final Field EXECUTION_TIME = new Field(TrdRegTimestampType.INSTANCE, Values.EXECUTION_TIME.getOrdinal());
        public final Field SUBMISSION_TO_CLEARING = new Field(TrdRegTimestampType.INSTANCE, Values.SUBMISSION_TO_CLEARING.getOrdinal());
        public final Field DESK_RECEIPT = new Field(TrdRegTimestampType.INSTANCE, Values.DESK_RECEIPT.getOrdinal());
        public final Field BROKER_EXECUTION = new Field(TrdRegTimestampType.INSTANCE, Values.BROKER_EXECUTION.getOrdinal());
        public final Field BROKER_RECEIPT = new Field(TrdRegTimestampType.INSTANCE, Values.BROKER_RECEIPT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TIME_OUT("3"),
        TIME_IN("2"),
        EXECUTION_TIME("1"),
        SUBMISSION_TO_CLEARING("7"),
        DESK_RECEIPT("6"),
        BROKER_EXECUTION("5"),
        BROKER_RECEIPT("4");

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
