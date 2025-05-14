package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class LegSwapType extends BaseFieldType {
    public static final LegSwapType INSTANCE = new LegSwapType();

    private LegSwapType() {
        super(
            "LegSwapType",
            690,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MODIFIED_DURATION = new Field(LegSwapType.INSTANCE, Values.MODIFIED_DURATION.getOrdinal());
        public final Field PAR_FOR_PAR = new Field(LegSwapType.INSTANCE, Values.PAR_FOR_PAR.getOrdinal());
        public final Field PROCEEDS = new Field(LegSwapType.INSTANCE, Values.PROCEEDS.getOrdinal());
        public final Field RISK = new Field(LegSwapType.INSTANCE, Values.RISK.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MODIFIED_DURATION("2"),
        PAR_FOR_PAR("1"),
        PROCEEDS("5"),
        RISK("4");

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
