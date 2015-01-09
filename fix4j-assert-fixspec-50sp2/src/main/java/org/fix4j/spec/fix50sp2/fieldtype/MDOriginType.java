package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MDOriginType extends BaseFieldType {
    public static final MDOriginType INSTANCE = new MDOriginType();

    private MDOriginType() {
        super(
            "MDOriginType",
            1024,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CROSS = new Field(MDOriginType.INSTANCE, Values.CROSS.getOrdinal());
        public final Field OFFBOOK = new Field(MDOriginType.INSTANCE, Values.OFFBOOK.getOrdinal());
        public final Field BOOK = new Field(MDOriginType.INSTANCE, Values.BOOK.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CROSS("2"),
        OFFBOOK("1"),
        BOOK("0");

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
