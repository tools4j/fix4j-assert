package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ComplexEventCondition extends BaseFieldType {
    public static final ComplexEventCondition INSTANCE = new ComplexEventCondition();

    private ComplexEventCondition() {
        super(
            "ComplexEventCondition",
            1490,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field OR = new Field(ComplexEventCondition.INSTANCE, Values.OR.getOrdinal());
        public final Field AND = new Field(ComplexEventCondition.INSTANCE, Values.AND.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        OR("2"),
        AND("1");

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
