package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradedFlatSwitch extends BaseFieldType {
    public static final TradedFlatSwitch INSTANCE = new TradedFlatSwitch();

    private TradedFlatSwitch() {
        super(
            "TradedFlatSwitch",
            258,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NOT_TRADED_FLAT = new Field(TradedFlatSwitch.INSTANCE, Values.NOT_TRADED_FLAT.getOrdinal());
        public final Field TRADED_FLAT = new Field(TradedFlatSwitch.INSTANCE, Values.TRADED_FLAT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NOT_TRADED_FLAT("N"),
        TRADED_FLAT("Y");

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
