package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocPositionEffect extends BaseFieldType {
    public static final AllocPositionEffect INSTANCE = new AllocPositionEffect();

    private AllocPositionEffect() {
        super(
            "AllocPositionEffect",
            1047,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FIFO = new Field(AllocPositionEffect.INSTANCE, Values.FIFO.getOrdinal());
        public final Field ROLLED = new Field(AllocPositionEffect.INSTANCE, Values.ROLLED.getOrdinal());
        public final Field CLOSE = new Field(AllocPositionEffect.INSTANCE, Values.CLOSE.getOrdinal());
        public final Field OPEN = new Field(AllocPositionEffect.INSTANCE, Values.OPEN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FIFO("F"),
        ROLLED("R"),
        CLOSE("C"),
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
