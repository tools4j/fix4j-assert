package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ContAmtType extends BaseFieldType {
    public static final ContAmtType INSTANCE = new ContAmtType();

    private ContAmtType() {
        super(
            "ContAmtType",
            519,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NET_SETTLEMENT_AMOUNT = new Field(ContAmtType.INSTANCE, Values.NET_SETTLEMENT_AMOUNT.getOrdinal());
        public final Field FUNDBASED_RENEWAL_COMMISSION_AMOUNT_BASED_ON_ORDER_VALUE = new Field(ContAmtType.INSTANCE, Values.FUNDBASED_RENEWAL_COMMISSION_AMOUNT_BASED_ON_ORDER_VALUE.getOrdinal());
        public final Field FUNDBASED_RENEWAL_COMMISSION_AMOUNT_BASED_ON_PROJECTED_FUND_VALU = new Field(ContAmtType.INSTANCE, Values.FUNDBASED_RENEWAL_COMMISSION_AMOUNT_BASED_ON_PROJECTED_FUND_VALU.getOrdinal());
        public final Field FUNDBASED_RENEWAL_COMMISSION_PERCENT_AKA_TRAIL_COMMISSION = new Field(ContAmtType.INSTANCE, Values.FUNDBASED_RENEWAL_COMMISSION_PERCENT_AKA_TRAIL_COMMISSION.getOrdinal());
        public final Field PROJECTED_FUND_VALUE_IE_FOR_INVESTMENTS_INTENDED_TO_REALISE_OR_E = new Field(ContAmtType.INSTANCE, Values.PROJECTED_FUND_VALUE_IE_FOR_INVESTMENTS_INTENDED_TO_REALISE_OR_E.getOrdinal());
        public final Field INITIAL_CHARGE_AMOUNT = new Field(ContAmtType.INSTANCE, Values.INITIAL_CHARGE_AMOUNT.getOrdinal());
        public final Field COMMISSION_PERCENT_ACTUAL = new Field(ContAmtType.INSTANCE, Values.COMMISSION_PERCENT_ACTUAL.getOrdinal());
        public final Field COMMISSION_AMOUNT_ACTUAL = new Field(ContAmtType.INSTANCE, Values.COMMISSION_AMOUNT_ACTUAL.getOrdinal());
        public final Field EXIT_CHARGE_PERCENT = new Field(ContAmtType.INSTANCE, Values.EXIT_CHARGE_PERCENT.getOrdinal());
        public final Field DILUTION_LEVY_AMOUNT = new Field(ContAmtType.INSTANCE, Values.DILUTION_LEVY_AMOUNT.getOrdinal());
        public final Field DISCOUNT_PERCENT = new Field(ContAmtType.INSTANCE, Values.DISCOUNT_PERCENT.getOrdinal());
        public final Field DISCOUNT_AMOUNT = new Field(ContAmtType.INSTANCE, Values.DISCOUNT_AMOUNT.getOrdinal());
        public final Field INITIAL_CHARGE_PERCENT = new Field(ContAmtType.INSTANCE, Values.INITIAL_CHARGE_PERCENT.getOrdinal());
        public final Field EXIT_CHARGE_AMOUNT = new Field(ContAmtType.INSTANCE, Values.EXIT_CHARGE_AMOUNT.getOrdinal());
        public final Field DILUTION_LEVY_PERCENT = new Field(ContAmtType.INSTANCE, Values.DILUTION_LEVY_PERCENT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NET_SETTLEMENT_AMOUNT("15"),
        FUNDBASED_RENEWAL_COMMISSION_AMOUNT_BASED_ON_ORDER_VALUE("13"),
        FUNDBASED_RENEWAL_COMMISSION_AMOUNT_BASED_ON_PROJECTED_FUND_VALU("14"),
        FUNDBASED_RENEWAL_COMMISSION_PERCENT_AKA_TRAIL_COMMISSION("11"),
        PROJECTED_FUND_VALUE_IE_FOR_INVESTMENTS_INTENDED_TO_REALISE_OR_E("12"),
        INITIAL_CHARGE_AMOUNT("3"),
        COMMISSION_PERCENT_ACTUAL("2"),
        COMMISSION_AMOUNT_ACTUAL("1"),
        EXIT_CHARGE_PERCENT("10"),
        DILUTION_LEVY_AMOUNT("7"),
        DISCOUNT_PERCENT("6"),
        DISCOUNT_AMOUNT("5"),
        INITIAL_CHARGE_PERCENT("4"),
        EXIT_CHARGE_AMOUNT("9"),
        DILUTION_LEVY_PERCENT("8");

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
