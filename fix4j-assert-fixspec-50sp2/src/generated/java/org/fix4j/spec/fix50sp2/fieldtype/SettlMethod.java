package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlMethod extends BaseFieldType {
    public static final SettlMethod INSTANCE = new SettlMethod();

    private SettlMethod() {
        super(
            "SettlMethod",
            1193,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PHYSICAL_SETTLEMENT_REQUIRED = new Field(SettlMethod.INSTANCE, Values.PHYSICAL_SETTLEMENT_REQUIRED.getOrdinal());
        public final Field CASH_SETTLEMENT_REQUIRED = new Field(SettlMethod.INSTANCE, Values.CASH_SETTLEMENT_REQUIRED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PHYSICAL_SETTLEMENT_REQUIRED("P"),
        CASH_SETTLEMENT_REQUIRED("C");

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
