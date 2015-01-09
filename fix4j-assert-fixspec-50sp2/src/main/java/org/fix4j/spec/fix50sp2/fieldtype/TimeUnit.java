package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TimeUnit extends BaseFieldType {
    public static final TimeUnit INSTANCE = new TimeUnit();

    private TimeUnit() {
        super(
            "TimeUnit",
            997,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DAY = new Field(TimeUnit.INSTANCE, Values.DAY.getOrdinal());
        public final Field SECOND = new Field(TimeUnit.INSTANCE, Values.SECOND.getOrdinal());
        public final Field YEAR = new Field(TimeUnit.INSTANCE, Values.YEAR.getOrdinal());
        public final Field HOUR = new Field(TimeUnit.INSTANCE, Values.HOUR.getOrdinal());
        public final Field MONTH = new Field(TimeUnit.INSTANCE, Values.MONTH.getOrdinal());
        public final Field WEEK = new Field(TimeUnit.INSTANCE, Values.WEEK.getOrdinal());
        public final Field MINUTE = new Field(TimeUnit.INSTANCE, Values.MINUTE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DAY("D"),
        SECOND("S"),
        YEAR("Yr"),
        HOUR("H"),
        MONTH("Mo"),
        WEEK("Wk"),
        MINUTE("Min");

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
