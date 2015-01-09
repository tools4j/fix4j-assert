package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CollApplType extends BaseFieldType {
    public static final CollApplType INSTANCE = new CollApplType();

    private CollApplType() {
        super(
            "CollApplType",
            1043,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field GENERAL = new Field(CollApplType.INSTANCE, Values.GENERAL.getOrdinal());
        public final Field SPECIFIC_DEPOSIT = new Field(CollApplType.INSTANCE, Values.SPECIFIC_DEPOSIT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        GENERAL("1"),
        SPECIFIC_DEPOSIT("0");

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
