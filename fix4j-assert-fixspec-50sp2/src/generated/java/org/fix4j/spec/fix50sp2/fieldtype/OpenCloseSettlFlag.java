package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OpenCloseSettlFlag extends BaseFieldType {
    public static final OpenCloseSettlFlag INSTANCE = new OpenCloseSettlFlag();

    private OpenCloseSettlFlag() {
        super(
            "OpenCloseSettlFlag",
            286,
            FieldClassLookup.lookup("MULTIPLECHARVALUE"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXPECTED_ENTRY = new Field(OpenCloseSettlFlag.INSTANCE, Values.EXPECTED_ENTRY.getOrdinal());
        public final Field DELIVERY_SETTLEMENT_ENTRY = new Field(OpenCloseSettlFlag.INSTANCE, Values.DELIVERY_SETTLEMENT_ENTRY.getOrdinal());
        public final Field SESSION_OPEN__CLOSE__SETTLEMENT_ENTRY = new Field(OpenCloseSettlFlag.INSTANCE, Values.SESSION_OPEN__CLOSE__SETTLEMENT_ENTRY.getOrdinal());
        public final Field DAILY_OPEN__CLOSE__SETTLEMENT_ENTRY = new Field(OpenCloseSettlFlag.INSTANCE, Values.DAILY_OPEN__CLOSE__SETTLEMENT_ENTRY.getOrdinal());
        public final Field THEORETICAL_PRICE_VALUE = new Field(OpenCloseSettlFlag.INSTANCE, Values.THEORETICAL_PRICE_VALUE.getOrdinal());
        public final Field ENTRY_FROM_PREVIOUS_BUSINESS_DAY = new Field(OpenCloseSettlFlag.INSTANCE, Values.ENTRY_FROM_PREVIOUS_BUSINESS_DAY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXPECTED_ENTRY("3"),
        DELIVERY_SETTLEMENT_ENTRY("2"),
        SESSION_OPEN__CLOSE__SETTLEMENT_ENTRY("1"),
        DAILY_OPEN__CLOSE__SETTLEMENT_ENTRY("0"),
        THEORETICAL_PRICE_VALUE("5"),
        ENTRY_FROM_PREVIOUS_BUSINESS_DAY("4");

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
