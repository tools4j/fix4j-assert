package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DayBookingInst extends BaseFieldType {
    public static final DayBookingInst INSTANCE = new DayBookingInst();

    private DayBookingInst() {
        super(
            "DayBookingInst",
            589,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ACCUMULATE = new Field(DayBookingInst.INSTANCE, Values.ACCUMULATE.getOrdinal());
        public final Field SPEAK_WITH_ORDER_INITIATOR_BEFORE_BOOKING_SPEAK_FIRST = new Field(DayBookingInst.INSTANCE, Values.SPEAK_WITH_ORDER_INITIATOR_BEFORE_BOOKING_SPEAK_FIRST.getOrdinal());
        public final Field CAN_TRIGGER_BOOKING_WITHOUT_REFERENCE_TO_THE_ORDER_INITIATOR_AUT = new Field(DayBookingInst.INSTANCE, Values.CAN_TRIGGER_BOOKING_WITHOUT_REFERENCE_TO_THE_ORDER_INITIATOR_AUT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ACCUMULATE("2"),
        SPEAK_WITH_ORDER_INITIATOR_BEFORE_BOOKING_SPEAK_FIRST("1"),
        CAN_TRIGGER_BOOKING_WITHOUT_REFERENCE_TO_THE_ORDER_INITIATOR_AUT("0");

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
