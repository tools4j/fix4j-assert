package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RateSourceType extends BaseFieldType {
    public static final RateSourceType INSTANCE = new RateSourceType();

    private RateSourceType() {
        super(
            "RateSourceType",
            1447,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SECONDARY = new Field(RateSourceType.INSTANCE, Values.SECONDARY.getOrdinal());
        public final Field PRIMARY = new Field(RateSourceType.INSTANCE, Values.PRIMARY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SECONDARY("1"),
        PRIMARY("0");

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
