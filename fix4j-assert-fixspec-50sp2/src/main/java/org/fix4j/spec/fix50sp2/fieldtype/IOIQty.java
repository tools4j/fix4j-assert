package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class IOIQty extends BaseFieldType {
    public static final IOIQty INSTANCE = new IOIQty();

    private IOIQty() {
        super(
            "IOIQty",
            27,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field UNDISCLOSED_QUANTITY = new Field(IOIQty.INSTANCE, Values.UNDISCLOSED_QUANTITY.getOrdinal());
        public final Field I1000000000 = new Field(IOIQty.INSTANCE, Values.I1000000000.getOrdinal());
        public final Field SMALL = new Field(IOIQty.INSTANCE, Values.SMALL.getOrdinal());
        public final Field LARGE = new Field(IOIQty.INSTANCE, Values.LARGE.getOrdinal());
        public final Field MEDIUM = new Field(IOIQty.INSTANCE, Values.MEDIUM.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        UNDISCLOSED_QUANTITY("U"),
        I1000000000("0"),
        SMALL("S"),
        LARGE("L"),
        MEDIUM("M");

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
