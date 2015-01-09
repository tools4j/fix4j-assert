package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AdvSide extends BaseFieldType {
    public static final AdvSide INSTANCE = new AdvSide();

    private AdvSide() {
        super(
            "AdvSide",
            4,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TRADE = new Field(AdvSide.INSTANCE, Values.TRADE.getOrdinal());
        public final Field SELL = new Field(AdvSide.INSTANCE, Values.SELL.getOrdinal());
        public final Field BUY = new Field(AdvSide.INSTANCE, Values.BUY.getOrdinal());
        public final Field CROSS = new Field(AdvSide.INSTANCE, Values.CROSS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TRADE("T"),
        SELL("S"),
        BUY("B"),
        CROSS("X");

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
