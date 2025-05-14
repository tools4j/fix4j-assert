package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ModelType extends BaseFieldType {
    public static final ModelType INSTANCE = new ModelType();

    private ModelType() {
        super(
            "ModelType",
            1434,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PROPRIETARY_USER_SUPPLIED_MODEL = new Field(ModelType.INSTANCE, Values.PROPRIETARY_USER_SUPPLIED_MODEL.getOrdinal());
        public final Field UTILITY_PROVIDED_STANDARD_MODEL = new Field(ModelType.INSTANCE, Values.UTILITY_PROVIDED_STANDARD_MODEL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PROPRIETARY_USER_SUPPLIED_MODEL("1"),
        UTILITY_PROVIDED_STANDARD_MODEL("0");

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
