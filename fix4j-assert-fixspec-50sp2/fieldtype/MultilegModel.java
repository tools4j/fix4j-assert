package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MultilegModel extends BaseFieldType {
    public static final MultilegModel INSTANCE = new MultilegModel();

    private MultilegModel() {
        super(
            "MultilegModel",
            1377,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field USERDEFINED_NONSECURITIZED_MULTILEG = new Field(MultilegModel.INSTANCE, Values.USERDEFINED_NONSECURITIZED_MULTILEG.getOrdinal());
        public final Field USERDEFINED_MULTLEG_SECURITY = new Field(MultilegModel.INSTANCE, Values.USERDEFINED_MULTLEG_SECURITY.getOrdinal());
        public final Field PREDEFINED_MULTILEG_SECURITY = new Field(MultilegModel.INSTANCE, Values.PREDEFINED_MULTILEG_SECURITY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        USERDEFINED_NONSECURITIZED_MULTILEG("2"),
        USERDEFINED_MULTLEG_SECURITY("1"),
        PREDEFINED_MULTILEG_SECURITY("0");

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
