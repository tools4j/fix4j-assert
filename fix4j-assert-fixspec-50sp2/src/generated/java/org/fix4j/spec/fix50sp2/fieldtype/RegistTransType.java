package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RegistTransType extends BaseFieldType {
    public static final RegistTransType INSTANCE = new RegistTransType();

    private RegistTransType() {
        super(
            "RegistTransType",
            514,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CANCEL = new Field(RegistTransType.INSTANCE, Values.CANCEL.getOrdinal());
        public final Field REPLACE = new Field(RegistTransType.INSTANCE, Values.REPLACE.getOrdinal());
        public final Field NEW = new Field(RegistTransType.INSTANCE, Values.NEW.getOrdinal());
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
