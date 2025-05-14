package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OptPayoutType extends BaseFieldType {
    public static final OptPayoutType INSTANCE = new OptPayoutType();

    private OptPayoutType() {
        super(
            "OptPayoutType",
            1482,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BINARY = new Field(OptPayoutType.INSTANCE, Values.BINARY.getOrdinal());
        public final Field CAPPED = new Field(OptPayoutType.INSTANCE, Values.CAPPED.getOrdinal());
        public final Field VANILLA = new Field(OptPayoutType.INSTANCE, Values.VANILLA.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BINARY("3"),
        CAPPED("2"),
        VANILLA("1");

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
