package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SideValueInd extends BaseFieldType {
    public static final SideValueInd INSTANCE = new SideValueInd();

    private SideValueInd() {
        super(
            "SideValueInd",
            401,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SIDE_VALUE_2 = new Field(SideValueInd.INSTANCE, Values.SIDE_VALUE_2.getOrdinal());
        public final Field SIDE_VALUE_1 = new Field(SideValueInd.INSTANCE, Values.SIDE_VALUE_1.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SIDE_VALUE_2("2"),
        SIDE_VALUE_1("1");

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
