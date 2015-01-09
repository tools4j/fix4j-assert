package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MaturityMonthYearFormat extends BaseFieldType {
    public static final MaturityMonthYearFormat INSTANCE = new MaturityMonthYearFormat();

    private MaturityMonthYearFormat() {
        super(
            "MaturityMonthYearFormat",
            1303,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field YEARMONTHWEEK = new Field(MaturityMonthYearFormat.INSTANCE, Values.YEARMONTHWEEK.getOrdinal());
        public final Field YEARMONTHDAY = new Field(MaturityMonthYearFormat.INSTANCE, Values.YEARMONTHDAY.getOrdinal());
        public final Field YEARMONTH_ONLY_DEFAULT = new Field(MaturityMonthYearFormat.INSTANCE, Values.YEARMONTH_ONLY_DEFAULT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        YEARMONTHWEEK("2"),
        YEARMONTHDAY("1"),
        YEARMONTH_ONLY_DEFAULT("0");

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
