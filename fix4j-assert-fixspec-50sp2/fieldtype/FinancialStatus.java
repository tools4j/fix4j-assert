package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class FinancialStatus extends BaseFieldType {
    public static final FinancialStatus INSTANCE = new FinancialStatus();

    private FinancialStatus() {
        super(
            "FinancialStatus",
            291,
            FieldClassLookup.lookup("MULTIPLECHARVALUE"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field RESTRICTED = new Field(FinancialStatus.INSTANCE, Values.RESTRICTED.getOrdinal());
        public final Field PENDING_DELISTING = new Field(FinancialStatus.INSTANCE, Values.PENDING_DELISTING.getOrdinal());
        public final Field BANKRUPT = new Field(FinancialStatus.INSTANCE, Values.BANKRUPT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        RESTRICTED("3"),
        PENDING_DELISTING("2"),
        BANKRUPT("1");

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
