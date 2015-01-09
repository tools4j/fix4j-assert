package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocNoOrdersType extends BaseFieldType {
    public static final AllocNoOrdersType INSTANCE = new AllocNoOrdersType();

    private AllocNoOrdersType() {
        super(
            "AllocNoOrdersType",
            857,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXPLICIT_LIST_PROVIDED = new Field(AllocNoOrdersType.INSTANCE, Values.EXPLICIT_LIST_PROVIDED.getOrdinal());
        public final Field NOT_SPECIFIED = new Field(AllocNoOrdersType.INSTANCE, Values.NOT_SPECIFIED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXPLICIT_LIST_PROVIDED("1"),
        NOT_SPECIFIED("0");

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
