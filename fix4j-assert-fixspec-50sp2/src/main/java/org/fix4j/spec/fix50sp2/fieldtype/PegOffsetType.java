package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PegOffsetType extends BaseFieldType {
    public static final PegOffsetType INSTANCE = new PegOffsetType();

    private PegOffsetType() {
        super(
            "PegOffsetType",
            836,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PRICE_TIER__LEVEL = new Field(PegOffsetType.INSTANCE, Values.PRICE_TIER__LEVEL.getOrdinal());
        public final Field TICKS = new Field(PegOffsetType.INSTANCE, Values.TICKS.getOrdinal());
        public final Field BASIS_POINTS = new Field(PegOffsetType.INSTANCE, Values.BASIS_POINTS.getOrdinal());
        public final Field PRICE_DEFAULT = new Field(PegOffsetType.INSTANCE, Values.PRICE_DEFAULT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PRICE_TIER__LEVEL("3"),
        TICKS("2"),
        BASIS_POINTS("1"),
        PRICE_DEFAULT("0");

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
