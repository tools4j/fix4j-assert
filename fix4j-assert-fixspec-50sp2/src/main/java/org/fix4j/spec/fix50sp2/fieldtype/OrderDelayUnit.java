package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OrderDelayUnit extends BaseFieldType {
    public static final OrderDelayUnit INSTANCE = new OrderDelayUnit();

    private OrderDelayUnit() {
        super(
            "OrderDelayUnit",
            1429,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MILLISECONDS = new Field(OrderDelayUnit.INSTANCE, Values.MILLISECONDS.getOrdinal());
        public final Field HUNDREDTHS_OF_A_SECOND = new Field(OrderDelayUnit.INSTANCE, Values.HUNDREDTHS_OF_A_SECOND.getOrdinal());
        public final Field MINUTES = new Field(OrderDelayUnit.INSTANCE, Values.MINUTES.getOrdinal());
        public final Field TENTHS_OF_A_SECOND = new Field(OrderDelayUnit.INSTANCE, Values.TENTHS_OF_A_SECOND.getOrdinal());
        public final Field SECONDS_DEFAULT_IF_NOT_SPECIFIED = new Field(OrderDelayUnit.INSTANCE, Values.SECONDS_DEFAULT_IF_NOT_SPECIFIED.getOrdinal());
        public final Field NANOSECONDS = new Field(OrderDelayUnit.INSTANCE, Values.NANOSECONDS.getOrdinal());
        public final Field MICROSECONDS = new Field(OrderDelayUnit.INSTANCE, Values.MICROSECONDS.getOrdinal());
        public final Field YEARS = new Field(OrderDelayUnit.INSTANCE, Values.YEARS.getOrdinal());
        public final Field WEEKS = new Field(OrderDelayUnit.INSTANCE, Values.WEEKS.getOrdinal());
        public final Field MONTHS = new Field(OrderDelayUnit.INSTANCE, Values.MONTHS.getOrdinal());
        public final Field HOURS = new Field(OrderDelayUnit.INSTANCE, Values.HOURS.getOrdinal());
        public final Field DAYS = new Field(OrderDelayUnit.INSTANCE, Values.DAYS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MILLISECONDS("3"),
        HUNDREDTHS_OF_A_SECOND("2"),
        MINUTES("10"),
        TENTHS_OF_A_SECOND("1"),
        SECONDS_DEFAULT_IF_NOT_SPECIFIED("0"),
        NANOSECONDS("5"),
        MICROSECONDS("4"),
        YEARS("15"),
        WEEKS("13"),
        MONTHS("14"),
        HOURS("11"),
        DAYS("12");

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
