package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OddLot extends BaseFieldType {
    public static final OddLot INSTANCE = new OddLot();

    private OddLot() {
        super(
            "OddLot",
            575,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TREAT_AS_ROUND_LOT_DEFAULT = new Field(OddLot.INSTANCE, Values.TREAT_AS_ROUND_LOT_DEFAULT.getOrdinal());
        public final Field TREAT_AS_ODD_LOT = new Field(OddLot.INSTANCE, Values.TREAT_AS_ODD_LOT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TREAT_AS_ROUND_LOT_DEFAULT("N"),
        TREAT_AS_ODD_LOT("Y");

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
