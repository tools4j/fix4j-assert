package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class FlowScheduleType extends BaseFieldType {
    public static final FlowScheduleType INSTANCE = new FlowScheduleType();

    private FlowScheduleType() {
        super(
            "FlowScheduleType",
            1439,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NERC_EASTERN_PEAK = new Field(FlowScheduleType.INSTANCE, Values.NERC_EASTERN_PEAK.getOrdinal());
        public final Field NERC_CALENDARALL_DAYS_IN_MONTH = new Field(FlowScheduleType.INSTANCE, Values.NERC_CALENDARALL_DAYS_IN_MONTH.getOrdinal());
        public final Field NERC_WESTERN_OFFPEAK = new Field(FlowScheduleType.INSTANCE, Values.NERC_WESTERN_OFFPEAK.getOrdinal());
        public final Field NERC_EASTERN_OFFPEAK = new Field(FlowScheduleType.INSTANCE, Values.NERC_EASTERN_OFFPEAK.getOrdinal());
        public final Field NERC_WESTERN_PEAK = new Field(FlowScheduleType.INSTANCE, Values.NERC_WESTERN_PEAK.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NERC_EASTERN_PEAK("3"),
        NERC_CALENDARALL_DAYS_IN_MONTH("2"),
        NERC_WESTERN_OFFPEAK("1"),
        NERC_EASTERN_OFFPEAK("0"),
        NERC_WESTERN_PEAK("4");

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
