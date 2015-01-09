package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocSettlInstType extends BaseFieldType {
    public static final AllocSettlInstType INSTANCE = new AllocSettlInstType();

    private AllocSettlInstType() {
        super(
            "AllocSettlInstType",
            780,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SSI_DB_IDS_PROVIDED = new Field(AllocSettlInstType.INSTANCE, Values.SSI_DB_IDS_PROVIDED.getOrdinal());
        public final Field FULL_DETAILS_PROVIDED = new Field(AllocSettlInstType.INSTANCE, Values.FULL_DETAILS_PROVIDED.getOrdinal());
        public final Field DERIVE_FROM_PARAMETERS_PROVIDED = new Field(AllocSettlInstType.INSTANCE, Values.DERIVE_FROM_PARAMETERS_PROVIDED.getOrdinal());
        public final Field USE_DEFAULT_INSTRUCTIONS = new Field(AllocSettlInstType.INSTANCE, Values.USE_DEFAULT_INSTRUCTIONS.getOrdinal());
        public final Field PHONE_FOR_INSTRUCTIONS = new Field(AllocSettlInstType.INSTANCE, Values.PHONE_FOR_INSTRUCTIONS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SSI_DB_IDS_PROVIDED("3"),
        FULL_DETAILS_PROVIDED("2"),
        DERIVE_FROM_PARAMETERS_PROVIDED("1"),
        USE_DEFAULT_INSTRUCTIONS("0"),
        PHONE_FOR_INSTRUCTIONS("4");

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
