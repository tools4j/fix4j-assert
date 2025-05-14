package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CommType extends BaseFieldType {
    public static final CommType INSTANCE = new CommType();

    private CommType() {
        super(
            "CommType",
            13,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ABSOLUTE_TOTAL_MONETARY_AMOUNT = new Field(CommType.INSTANCE, Values.ABSOLUTE_TOTAL_MONETARY_AMOUNT.getOrdinal());
        public final Field PERCENT = new Field(CommType.INSTANCE, Values.PERCENT.getOrdinal());
        public final Field PER_UNIT_IMPLYING_SHARES_PAR_CURRENCY_ETC = new Field(CommType.INSTANCE, Values.PER_UNIT_IMPLYING_SHARES_PAR_CURRENCY_ETC.getOrdinal());
        public final Field POINTS_PER_BOND_OR_CONTRACT_SUPPLY_CONTRACTMULTIPLIER_231_IN_THE = new Field(CommType.INSTANCE, Values.POINTS_PER_BOND_OR_CONTRACT_SUPPLY_CONTRACTMULTIPLIER_231_IN_THE.getOrdinal());
        public final Field PERCENTAGE_WAIVED__ENHANCED_UNITS_FOR_CIV_BUY_ORDERS = new Field(CommType.INSTANCE, Values.PERCENTAGE_WAIVED__ENHANCED_UNITS_FOR_CIV_BUY_ORDERS.getOrdinal());
        public final Field PERCENTAGE_WAIVED__CASH_DISCOUNT_FOR_CIV_BUY_ORDERS = new Field(CommType.INSTANCE, Values.PERCENTAGE_WAIVED__CASH_DISCOUNT_FOR_CIV_BUY_ORDERS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ABSOLUTE_TOTAL_MONETARY_AMOUNT("3"),
        PERCENT("2"),
        PER_UNIT_IMPLYING_SHARES_PAR_CURRENCY_ETC("1"),
        POINTS_PER_BOND_OR_CONTRACT_SUPPLY_CONTRACTMULTIPLIER_231_IN_THE("6"),
        PERCENTAGE_WAIVED__ENHANCED_UNITS_FOR_CIV_BUY_ORDERS("5"),
        PERCENTAGE_WAIVED__CASH_DISCOUNT_FOR_CIV_BUY_ORDERS("4");

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
