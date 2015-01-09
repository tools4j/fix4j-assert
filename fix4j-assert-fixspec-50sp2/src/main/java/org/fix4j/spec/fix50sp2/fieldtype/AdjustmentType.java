package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AdjustmentType extends BaseFieldType {
    public static final AdjustmentType INSTANCE = new AdjustmentType();

    private AdjustmentType() {
        super(
            "AdjustmentType",
            718,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FINAL = new Field(AdjustmentType.INSTANCE, Values.FINAL.getOrdinal());
        public final Field DELTA_MINUS = new Field(AdjustmentType.INSTANCE, Values.DELTA_MINUS.getOrdinal());
        public final Field DELTA_PLUS = new Field(AdjustmentType.INSTANCE, Values.DELTA_PLUS.getOrdinal());
        public final Field PROCESS_REQUEST_AS_MARGIN_DISPOSITION = new Field(AdjustmentType.INSTANCE, Values.PROCESS_REQUEST_AS_MARGIN_DISPOSITION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FINAL("3"),
        DELTA_MINUS("2"),
        DELTA_PLUS("1"),
        PROCESS_REQUEST_AS_MARGIN_DISPOSITION("0");

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
