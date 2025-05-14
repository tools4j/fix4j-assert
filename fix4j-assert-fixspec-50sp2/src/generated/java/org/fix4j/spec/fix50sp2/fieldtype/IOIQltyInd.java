package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class IOIQltyInd extends BaseFieldType {
    public static final IOIQltyInd INSTANCE = new IOIQltyInd();

    private IOIQltyInd() {
        super(
            "IOIQltyInd",
            25,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field LOW = new Field(IOIQltyInd.INSTANCE, Values.LOW.getOrdinal());
        public final Field MEDIUM = new Field(IOIQltyInd.INSTANCE, Values.MEDIUM.getOrdinal());
        public final Field HIGH = new Field(IOIQltyInd.INSTANCE, Values.HIGH.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        LOW("L"),
        MEDIUM("M"),
        HIGH("H");

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
