package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RoutingType extends BaseFieldType {
    public static final RoutingType INSTANCE = new RoutingType();

    private RoutingType() {
        super(
            "RoutingType",
            216,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BLOCK_FIRM = new Field(RoutingType.INSTANCE, Values.BLOCK_FIRM.getOrdinal());
        public final Field TARGET_LIST = new Field(RoutingType.INSTANCE, Values.TARGET_LIST.getOrdinal());
        public final Field TARGET_FIRM = new Field(RoutingType.INSTANCE, Values.TARGET_FIRM.getOrdinal());
        public final Field BLOCK_LIST = new Field(RoutingType.INSTANCE, Values.BLOCK_LIST.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BLOCK_FIRM("3"),
        TARGET_LIST("2"),
        TARGET_FIRM("1"),
        BLOCK_LIST("4");

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
