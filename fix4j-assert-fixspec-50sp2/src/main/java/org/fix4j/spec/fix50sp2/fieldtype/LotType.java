package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class LotType extends BaseFieldType {
    public static final LotType INSTANCE = new LotType();

    private LotType() {
        super(
            "LotType",
            1093,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BLOCK_LOT = new Field(LotType.INSTANCE, Values.BLOCK_LOT.getOrdinal());
        public final Field ROUND_LOT = new Field(LotType.INSTANCE, Values.ROUND_LOT.getOrdinal());
        public final Field ODD_LOT = new Field(LotType.INSTANCE, Values.ODD_LOT.getOrdinal());
        public final Field ROUND_LOT_BASED_UPON_UNITOFMEASURE996 = new Field(LotType.INSTANCE, Values.ROUND_LOT_BASED_UPON_UNITOFMEASURE996.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BLOCK_LOT("3"),
        ROUND_LOT("2"),
        ODD_LOT("1"),
        ROUND_LOT_BASED_UPON_UNITOFMEASURE996("4");

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
