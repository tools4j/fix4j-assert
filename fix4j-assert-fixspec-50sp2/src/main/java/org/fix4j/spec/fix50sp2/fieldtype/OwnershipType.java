package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OwnershipType extends BaseFieldType {
    public static final OwnershipType INSTANCE = new OwnershipType();

    private OwnershipType() {
        super(
            "OwnershipType",
            517,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TENANTS_IN_COMMON = new Field(OwnershipType.INSTANCE, Values.TENANTS_IN_COMMON.getOrdinal());
        public final Field JOINT_TRUSTEES = new Field(OwnershipType.INSTANCE, Values.JOINT_TRUSTEES.getOrdinal());
        public final Field JOINT_INVESTORS = new Field(OwnershipType.INSTANCE, Values.JOINT_INVESTORS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TENANTS_IN_COMMON("T"),
        JOINT_TRUSTEES("2"),
        JOINT_INVESTORS("J");

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
