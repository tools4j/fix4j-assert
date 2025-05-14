package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocHandlInst extends BaseFieldType {
    public static final AllocHandlInst INSTANCE = new AllocHandlInst();

    private AllocHandlInst() {
        super(
            "AllocHandlInst",
            209,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FORWARD_AND_MATCH = new Field(AllocHandlInst.INSTANCE, Values.FORWARD_AND_MATCH.getOrdinal());
        public final Field FORWARD = new Field(AllocHandlInst.INSTANCE, Values.FORWARD.getOrdinal());
        public final Field MATCH = new Field(AllocHandlInst.INSTANCE, Values.MATCH.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FORWARD_AND_MATCH("3"),
        FORWARD("2"),
        MATCH("1");

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
