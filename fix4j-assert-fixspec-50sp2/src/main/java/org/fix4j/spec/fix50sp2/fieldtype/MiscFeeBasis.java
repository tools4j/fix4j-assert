package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MiscFeeBasis extends BaseFieldType {
    public static final MiscFeeBasis INSTANCE = new MiscFeeBasis();

    private MiscFeeBasis() {
        super(
            "MiscFeeBasis",
            891,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PERCENTAGE = new Field(MiscFeeBasis.INSTANCE, Values.PERCENTAGE.getOrdinal());
        public final Field PER_UNIT = new Field(MiscFeeBasis.INSTANCE, Values.PER_UNIT.getOrdinal());
        public final Field ABSOLUTE = new Field(MiscFeeBasis.INSTANCE, Values.ABSOLUTE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PERCENTAGE("2"),
        PER_UNIT("1"),
        ABSOLUTE("0");

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
