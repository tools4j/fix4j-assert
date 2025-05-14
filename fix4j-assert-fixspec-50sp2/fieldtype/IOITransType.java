package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class IOITransType extends BaseFieldType {
    public static final IOITransType INSTANCE = new IOITransType();

    private IOITransType() {
        super(
            "IOITransType",
            28,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REPLACE = new Field(IOITransType.INSTANCE, Values.REPLACE.getOrdinal());
        public final Field CANCEL = new Field(IOITransType.INSTANCE, Values.CANCEL.getOrdinal());
        public final Field NEW = new Field(IOITransType.INSTANCE, Values.NEW.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REPLACE("R"),
        CANCEL("C"),
        NEW("N");

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
