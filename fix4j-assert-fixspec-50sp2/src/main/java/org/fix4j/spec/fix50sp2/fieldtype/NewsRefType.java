package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class NewsRefType extends BaseFieldType {
    public static final NewsRefType INSTANCE = new NewsRefType();

    private NewsRefType() {
        super(
            "NewsRefType",
            1477,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field COMPLIMENTARY = new Field(NewsRefType.INSTANCE, Values.COMPLIMENTARY.getOrdinal());
        public final Field OTHER_LANGUAGE = new Field(NewsRefType.INSTANCE, Values.OTHER_LANGUAGE.getOrdinal());
        public final Field REPLACEMENT = new Field(NewsRefType.INSTANCE, Values.REPLACEMENT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        COMPLIMENTARY("2"),
        OTHER_LANGUAGE("1"),
        REPLACEMENT("0");

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
