package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CrossPrioritization extends BaseFieldType {
    public static final CrossPrioritization INSTANCE = new CrossPrioritization();

    private CrossPrioritization() {
        super(
            "CrossPrioritization",
            550,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SELL_SIDE_IS_PRIORITIZED = new Field(CrossPrioritization.INSTANCE, Values.SELL_SIDE_IS_PRIORITIZED.getOrdinal());
        public final Field BUY_SIDE_IS_PRIORITIZED = new Field(CrossPrioritization.INSTANCE, Values.BUY_SIDE_IS_PRIORITIZED.getOrdinal());
        public final Field NONE = new Field(CrossPrioritization.INSTANCE, Values.NONE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SELL_SIDE_IS_PRIORITIZED("2"),
        BUY_SIDE_IS_PRIORITIZED("1"),
        NONE("0");

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
