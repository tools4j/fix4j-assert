package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MsgDirection extends BaseFieldType {
    public static final MsgDirection INSTANCE = new MsgDirection();

    private MsgDirection() {
        super(
            "MsgDirection",
            385,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SEND = new Field(MsgDirection.INSTANCE, Values.SEND.getOrdinal());
        public final Field RECEIVE = new Field(MsgDirection.INSTANCE, Values.RECEIVE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SEND("S"),
        RECEIVE("R");

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
