package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ConfirmTransType extends BaseFieldType {
    public static final ConfirmTransType INSTANCE = new ConfirmTransType();

    private ConfirmTransType() {
        super(
            "ConfirmTransType",
            666,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CANCEL = new Field(ConfirmTransType.INSTANCE, Values.CANCEL.getOrdinal());
        public final Field REPLACE = new Field(ConfirmTransType.INSTANCE, Values.REPLACE.getOrdinal());
        public final Field NEW = new Field(ConfirmTransType.INSTANCE, Values.NEW.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CANCEL("2"),
        REPLACE("1"),
        NEW("0");

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
