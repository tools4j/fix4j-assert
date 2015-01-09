package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DKReason extends BaseFieldType {
    public static final DKReason INSTANCE = new DKReason();

    private DKReason() {
        super(
            "DKReason",
            127,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NO_MATCHING_ORDER = new Field(DKReason.INSTANCE, Values.NO_MATCHING_ORDER.getOrdinal());
        public final Field PRICE_EXCEEDS_LIMIT = new Field(DKReason.INSTANCE, Values.PRICE_EXCEEDS_LIMIT.getOrdinal());
        public final Field CALCULATION_DIFFERENCE = new Field(DKReason.INSTANCE, Values.CALCULATION_DIFFERENCE.getOrdinal());
        public final Field UNKNOWN_SYMBOL = new Field(DKReason.INSTANCE, Values.UNKNOWN_SYMBOL.getOrdinal());
        public final Field WRONG_SIDE = new Field(DKReason.INSTANCE, Values.WRONG_SIDE.getOrdinal());
        public final Field QUANTITY_EXCEEDS_ORDER = new Field(DKReason.INSTANCE, Values.QUANTITY_EXCEEDS_ORDER.getOrdinal());
        public final Field OTHER = new Field(DKReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NO_MATCHING_ORDER("D"),
        PRICE_EXCEEDS_LIMIT("E"),
        CALCULATION_DIFFERENCE("F"),
        UNKNOWN_SYMBOL("A"),
        WRONG_SIDE("B"),
        QUANTITY_EXCEEDS_ORDER("C"),
        OTHER("Z");

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
