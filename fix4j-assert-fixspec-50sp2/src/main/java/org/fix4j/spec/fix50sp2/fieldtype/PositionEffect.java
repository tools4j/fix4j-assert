package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PositionEffect extends BaseFieldType {
    public static final PositionEffect INSTANCE = new PositionEffect();

    private PositionEffect() {
        super(
            "PositionEffect",
            77,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DEFAULT = new Field(PositionEffect.INSTANCE, Values.DEFAULT.getOrdinal());
        public final Field FIFO = new Field(PositionEffect.INSTANCE, Values.FIFO.getOrdinal());
        public final Field ROLLED = new Field(PositionEffect.INSTANCE, Values.ROLLED.getOrdinal());
        public final Field CLOSE = new Field(PositionEffect.INSTANCE, Values.CLOSE.getOrdinal());
        public final Field CLOSE_BUT_NOTIFY_ON_OPEN = new Field(PositionEffect.INSTANCE, Values.CLOSE_BUT_NOTIFY_ON_OPEN.getOrdinal());
        public final Field OPEN = new Field(PositionEffect.INSTANCE, Values.OPEN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DEFAULT("D"),
        FIFO("F"),
        ROLLED("R"),
        CLOSE("C"),
        CLOSE_BUT_NOTIFY_ON_OPEN("N"),
        OPEN("O");

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
