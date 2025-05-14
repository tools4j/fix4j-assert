package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MaturityMonthYearIncrementUnits extends BaseFieldType {
    public static final MaturityMonthYearIncrementUnits INSTANCE = new MaturityMonthYearIncrementUnits();

    private MaturityMonthYearIncrementUnits() {
        super(
            "MaturityMonthYearIncrementUnits",
            1302,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field YEARS = new Field(MaturityMonthYearIncrementUnits.INSTANCE, Values.YEARS.getOrdinal());
        public final Field WEEKS = new Field(MaturityMonthYearIncrementUnits.INSTANCE, Values.WEEKS.getOrdinal());
        public final Field DAYS = new Field(MaturityMonthYearIncrementUnits.INSTANCE, Values.DAYS.getOrdinal());
        public final Field MONTHS = new Field(MaturityMonthYearIncrementUnits.INSTANCE, Values.MONTHS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        YEARS("3"),
        WEEKS("2"),
        DAYS("1"),
        MONTHS("0");

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
