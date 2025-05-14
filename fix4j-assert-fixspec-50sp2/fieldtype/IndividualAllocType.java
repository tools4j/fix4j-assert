package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class IndividualAllocType extends BaseFieldType {
    public static final IndividualAllocType INSTANCE = new IndividualAllocType();

    private IndividualAllocType() {
        super(
            "IndividualAllocType",
            992,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field THIRD_PARTY_ALLOCATION = new Field(IndividualAllocType.INSTANCE, Values.THIRD_PARTY_ALLOCATION.getOrdinal());
        public final Field SUB_ALLOCATE = new Field(IndividualAllocType.INSTANCE, Values.SUB_ALLOCATE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        THIRD_PARTY_ALLOCATION("2"),
        SUB_ALLOCATE("1");

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
