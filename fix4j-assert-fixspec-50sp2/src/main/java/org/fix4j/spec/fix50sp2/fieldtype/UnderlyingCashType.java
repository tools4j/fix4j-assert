package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class UnderlyingCashType extends BaseFieldType {
    public static final UnderlyingCashType INSTANCE = new UnderlyingCashType();

    private UnderlyingCashType() {
        super(
            "UnderlyingCashType",
            974,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DIFF = new Field(UnderlyingCashType.INSTANCE, Values.DIFF.getOrdinal());
        public final Field FIXED = new Field(UnderlyingCashType.INSTANCE, Values.FIXED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DIFF("DIFF"),
        FIXED("FIXED");

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
