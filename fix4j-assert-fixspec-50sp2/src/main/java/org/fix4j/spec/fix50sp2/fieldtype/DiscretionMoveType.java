package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DiscretionMoveType extends BaseFieldType {
    public static final DiscretionMoveType INSTANCE = new DiscretionMoveType();

    private DiscretionMoveType() {
        super(
            "DiscretionMoveType",
            841,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FIXED = new Field(DiscretionMoveType.INSTANCE, Values.FIXED.getOrdinal());
        public final Field FLOATING_DEFAULT = new Field(DiscretionMoveType.INSTANCE, Values.FLOATING_DEFAULT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FIXED("1"),
        FLOATING_DEFAULT("0");

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
