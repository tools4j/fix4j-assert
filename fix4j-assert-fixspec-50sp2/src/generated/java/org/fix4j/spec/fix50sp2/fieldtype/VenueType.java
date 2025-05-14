package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class VenueType extends BaseFieldType {
    public static final VenueType INSTANCE = new VenueType();

    private VenueType() {
        super(
            "VenueType",
            1430,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ELECTRONIC = new Field(VenueType.INSTANCE, Values.ELECTRONIC.getOrdinal());
        public final Field PIT = new Field(VenueType.INSTANCE, Values.PIT.getOrdinal());
        public final Field EXPIT = new Field(VenueType.INSTANCE, Values.EXPIT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ELECTRONIC("E"),
        PIT("P"),
        EXPIT("X");

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
