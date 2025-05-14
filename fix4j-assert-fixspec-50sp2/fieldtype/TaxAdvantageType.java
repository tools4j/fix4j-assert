package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TaxAdvantageType extends BaseFieldType {
    public static final TaxAdvantageType INSTANCE = new TaxAdvantageType();

    private TaxAdvantageType() {
        super(
            "TaxAdvantageType",
            495,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PROFIT_SHARING_PLAN_US = new Field(TaxAdvantageType.INSTANCE, Values.PROFIT_SHARING_PLAN_US.getOrdinal());
        public final Field INDIVIDUAL_RETIREMENT_ACCOUNT__ROLLOVER_US = new Field(TaxAdvantageType.INSTANCE, Values.INDIVIDUAL_RETIREMENT_ACCOUNT__ROLLOVER_US.getOrdinal());
        public final Field KEOGH_US = new Field(TaxAdvantageType.INSTANCE, Values.KEOGH_US.getOrdinal());
        public final Field DEFINED_CONTRIBUTION_PLAN_US = new Field(TaxAdvantageType.INSTANCE, Values.DEFINED_CONTRIBUTION_PLAN_US.getOrdinal());
        public final Field INDIVIDUAL_RETIREMENT_ACCOUNT_US = new Field(TaxAdvantageType.INSTANCE, Values.INDIVIDUAL_RETIREMENT_ACCOUNT_US.getOrdinal());
        public final Field NONFUND_PROTOTYPE_IRA_US = new Field(TaxAdvantageType.INSTANCE, Values.NONFUND_PROTOTYPE_IRA_US.getOrdinal());
        public final Field NONFUND_QUALIFIED_PLAN_US = new Field(TaxAdvantageType.INSTANCE, Values.NONFUND_QUALIFIED_PLAN_US.getOrdinal());
        public final Field EMPLOYER__PRIOR_YEAR_US = new Field(TaxAdvantageType.INSTANCE, Values.EMPLOYER__PRIOR_YEAR_US.getOrdinal());
        public final Field EMPLOYER__CURRENT_YEAR_US = new Field(TaxAdvantageType.INSTANCE, Values.EMPLOYER__CURRENT_YEAR_US.getOrdinal());
        public final Field SELFDIRECTED_IRA_US = new Field(TaxAdvantageType.INSTANCE, Values.SELFDIRECTED_IRA_US.getOrdinal());
        public final Field I401K_US = new Field(TaxAdvantageType.INSTANCE, Values.I401K_US.getOrdinal());
        public final Field I403B_US = new Field(TaxAdvantageType.INSTANCE, Values.I403B_US.getOrdinal());
        public final Field I457_US = new Field(TaxAdvantageType.INSTANCE, Values.I457_US.getOrdinal());
        public final Field ROTH_IRA_FUND_PROTOTYPE_US = new Field(TaxAdvantageType.INSTANCE, Values.ROTH_IRA_FUND_PROTOTYPE_US.getOrdinal());
        public final Field ROTH_IRA_NONPROTOTYPE_US = new Field(TaxAdvantageType.INSTANCE, Values.ROTH_IRA_NONPROTOTYPE_US.getOrdinal());
        public final Field ROTH_CONVERSION_IRA_FUND_PROTOTYPE_US = new Field(TaxAdvantageType.INSTANCE, Values.ROTH_CONVERSION_IRA_FUND_PROTOTYPE_US.getOrdinal());
        public final Field ROTH_CONVERSION_IRA_NONPROTOTYPE_US = new Field(TaxAdvantageType.INSTANCE, Values.ROTH_CONVERSION_IRA_NONPROTOTYPE_US.getOrdinal());
        public final Field EDUCATION_IRA_FUND_PROTOTYPE_US = new Field(TaxAdvantageType.INSTANCE, Values.EDUCATION_IRA_FUND_PROTOTYPE_US.getOrdinal());
        public final Field EDUCATION_IRA_NONPROTOTYPE_US = new Field(TaxAdvantageType.INSTANCE, Values.EDUCATION_IRA_NONPROTOTYPE_US.getOrdinal());
        public final Field MINI_CASH_ISA_UK = new Field(TaxAdvantageType.INSTANCE, Values.MINI_CASH_ISA_UK.getOrdinal());
        public final Field TESSA_UK = new Field(TaxAdvantageType.INSTANCE, Values.TESSA_UK.getOrdinal());
        public final Field EMPLOYEE__CURRENT_YEAR_US = new Field(TaxAdvantageType.INSTANCE, Values.EMPLOYEE__CURRENT_YEAR_US.getOrdinal());
        public final Field MAXI_ISA_UK = new Field(TaxAdvantageType.INSTANCE, Values.MAXI_ISA_UK.getOrdinal());
        public final Field NONENOT_APPLICABLE_DEFAULT = new Field(TaxAdvantageType.INSTANCE, Values.NONENOT_APPLICABLE_DEFAULT.getOrdinal());
        public final Field PRIOR_YEAR_PAYMENT_US = new Field(TaxAdvantageType.INSTANCE, Values.PRIOR_YEAR_PAYMENT_US.getOrdinal());
        public final Field CURRENT_YEAR_PAYMENT_US = new Field(TaxAdvantageType.INSTANCE, Values.CURRENT_YEAR_PAYMENT_US.getOrdinal());
        public final Field MINI_INSURANCE_ISA_UK = new Field(TaxAdvantageType.INSTANCE, Values.MINI_INSURANCE_ISA_UK.getOrdinal());
        public final Field MINI_STOCKS_AND_SHARES_ISA_UK = new Field(TaxAdvantageType.INSTANCE, Values.MINI_STOCKS_AND_SHARES_ISA_UK.getOrdinal());
        public final Field EMPLOYEE__PRIOR_YEAR_US = new Field(TaxAdvantageType.INSTANCE, Values.EMPLOYEE__PRIOR_YEAR_US.getOrdinal());
        public final Field ASSET_TRANSFER_US = new Field(TaxAdvantageType.INSTANCE, Values.ASSET_TRANSFER_US.getOrdinal());
        public final Field OTHER = new Field(TaxAdvantageType.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PROFIT_SHARING_PLAN_US("19"),
        INDIVIDUAL_RETIREMENT_ACCOUNT__ROLLOVER_US("17"),
        KEOGH_US("18"),
        DEFINED_CONTRIBUTION_PLAN_US("15"),
        INDIVIDUAL_RETIREMENT_ACCOUNT_US("16"),
        NONFUND_PROTOTYPE_IRA_US("13"),
        NONFUND_QUALIFIED_PLAN_US("14"),
        EMPLOYER__PRIOR_YEAR_US("11"),
        EMPLOYER__CURRENT_YEAR_US("12"),
        SELFDIRECTED_IRA_US("21"),
        I401K_US("20"),
        I403B_US("22"),
        I457_US("23"),
        ROTH_IRA_FUND_PROTOTYPE_US("24"),
        ROTH_IRA_NONPROTOTYPE_US("25"),
        ROTH_CONVERSION_IRA_FUND_PROTOTYPE_US("26"),
        ROTH_CONVERSION_IRA_NONPROTOTYPE_US("27"),
        EDUCATION_IRA_FUND_PROTOTYPE_US("28"),
        EDUCATION_IRA_NONPROTOTYPE_US("29"),
        MINI_CASH_ISA_UK("3"),
        TESSA_UK("2"),
        EMPLOYEE__CURRENT_YEAR_US("10"),
        MAXI_ISA_UK("1"),
        NONENOT_APPLICABLE_DEFAULT("0"),
        PRIOR_YEAR_PAYMENT_US("7"),
        CURRENT_YEAR_PAYMENT_US("6"),
        MINI_INSURANCE_ISA_UK("5"),
        MINI_STOCKS_AND_SHARES_ISA_UK("4"),
        EMPLOYEE__PRIOR_YEAR_US("9"),
        ASSET_TRANSFER_US("8"),
        OTHER("999");

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
