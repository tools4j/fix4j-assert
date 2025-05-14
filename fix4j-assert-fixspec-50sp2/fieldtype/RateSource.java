package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RateSource extends BaseFieldType {
    public static final RateSource INSTANCE = new RateSource();

    private RateSource() {
        super(
            "RateSource",
            1446,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TELERATE = new Field(RateSource.INSTANCE, Values.TELERATE.getOrdinal());
        public final Field REUTERS = new Field(RateSource.INSTANCE, Values.REUTERS.getOrdinal());
        public final Field BLOOMBERG = new Field(RateSource.INSTANCE, Values.BLOOMBERG.getOrdinal());
        public final Field OTHER = new Field(RateSource.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TELERATE("2"),
        REUTERS("1"),
        BLOOMBERG("0"),
        OTHER("99");

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
