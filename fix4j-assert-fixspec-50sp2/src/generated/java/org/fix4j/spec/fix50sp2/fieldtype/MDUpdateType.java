package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MDUpdateType extends BaseFieldType {
    public static final MDUpdateType INSTANCE = new MDUpdateType();

    private MDUpdateType() {
        super(
            "MDUpdateType",
            265,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INCREMENTAL_REFRESH = new Field(MDUpdateType.INSTANCE, Values.INCREMENTAL_REFRESH.getOrdinal());
        public final Field FULL_REFRESH = new Field(MDUpdateType.INSTANCE, Values.FULL_REFRESH.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INCREMENTAL_REFRESH("1"),
        FULL_REFRESH("0");

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
