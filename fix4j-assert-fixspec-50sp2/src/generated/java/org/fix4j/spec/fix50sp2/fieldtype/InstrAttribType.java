package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class InstrAttribType extends BaseFieldType {
    public static final InstrAttribType INSTANCE = new InstrAttribType();

    private InstrAttribType() {
        super(
            "InstrAttribType",
            871,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SUBJECT_TO_ALTERNATIVE_MINIMUM_TAX = new Field(InstrAttribType.INSTANCE, Values.SUBJECT_TO_ALTERNATIVE_MINIMUM_TAX.getOrdinal());
        public final Field TAXABLE = new Field(InstrAttribType.INSTANCE, Values.TAXABLE.getOrdinal());
        public final Field INDEXED = new Field(InstrAttribType.INSTANCE, Values.INDEXED.getOrdinal());
        public final Field IN_DEFAULT = new Field(InstrAttribType.INSTANCE, Values.IN_DEFAULT.getOrdinal());
        public final Field UNRATED = new Field(InstrAttribType.INSTANCE, Values.UNRATED.getOrdinal());
        public final Field ESCROWED_TO_REDEMPTION_DATE__CALLABLE_SUPPLY_REDEMPTION_DATE_IN_ = new Field(InstrAttribType.INSTANCE, Values.ESCROWED_TO_REDEMPTION_DATE__CALLABLE_SUPPLY_REDEMPTION_DATE_IN_.getOrdinal());
        public final Field PREREFUNDED = new Field(InstrAttribType.INSTANCE, Values.PREREFUNDED.getOrdinal());
        public final Field CALLABLE_PUTTABLE = new Field(InstrAttribType.INSTANCE, Values.CALLABLE_PUTTABLE.getOrdinal());
        public final Field ESCROWED_TO_MATURITY = new Field(InstrAttribType.INSTANCE, Values.ESCROWED_TO_MATURITY.getOrdinal());
        public final Field CALLABLE_BELOW_MATURITY_VALUE = new Field(InstrAttribType.INSTANCE, Values.CALLABLE_BELOW_MATURITY_VALUE.getOrdinal());
        public final Field ORIGINAL_ISSUE_DISCOUNT_PRICE_SUPPLY_PRICE_IN_THE_INSTRATTRIBVAL = new Field(InstrAttribType.INSTANCE, Values.ORIGINAL_ISSUE_DISCOUNT_PRICE_SUPPLY_PRICE_IN_THE_INSTRATTRIBVAL.getOrdinal());
        public final Field TEXT_SUPPLY_THE_TEXT_OF_THE_ATTRIBUTE_OR_DISCLAIMER_IN_THE_INSTR = new Field(InstrAttribType.INSTANCE, Values.TEXT_SUPPLY_THE_TEXT_OF_THE_ATTRIBUTE_OR_DISCLAIMER_IN_THE_INSTR.getOrdinal());
        public final Field CALLABLE_WITHOUT_NOTICE_BY_MAIL_TO_HOLDER_UNLESS_REGISTERED = new Field(InstrAttribType.INSTANCE, Values.CALLABLE_WITHOUT_NOTICE_BY_MAIL_TO_HOLDER_UNLESS_REGISTERED.getOrdinal());
        public final Field PRICE_TICK_RULES_FOR_SECURITY = new Field(InstrAttribType.INSTANCE, Values.PRICE_TICK_RULES_FOR_SECURITY.getOrdinal());
        public final Field TRADE_TYPE_ELIGIBILITY_DETAILS_FOR_SECURITY = new Field(InstrAttribType.INSTANCE, Values.TRADE_TYPE_ELIGIBILITY_DETAILS_FOR_SECURITY.getOrdinal());
        public final Field INSTRUMENT_DENOMINATOR = new Field(InstrAttribType.INSTANCE, Values.INSTRUMENT_DENOMINATOR.getOrdinal());
        public final Field INSTRUMENT_NUMERATOR = new Field(InstrAttribType.INSTANCE, Values.INSTRUMENT_NUMERATOR.getOrdinal());
        public final Field INSTRUMENT_PRICE_PRECISION = new Field(InstrAttribType.INSTANCE, Values.INSTRUMENT_PRICE_PRECISION.getOrdinal());
        public final Field INSTRUMENT_STRIKE_PRICE = new Field(InstrAttribType.INSTANCE, Values.INSTRUMENT_STRIKE_PRICE.getOrdinal());
        public final Field TRADEABLE_INDICATOR = new Field(InstrAttribType.INSTANCE, Values.TRADEABLE_INDICATOR.getOrdinal());
        public final Field INTEREST_BEARING_FOR_EURO_COMMERCIAL_PAPER_WHEN_NOT_ISSUED_AT_DI = new Field(InstrAttribType.INSTANCE, Values.INTEREST_BEARING_FOR_EURO_COMMERCIAL_PAPER_WHEN_NOT_ISSUED_AT_DI.getOrdinal());
        public final Field ZERO_COUPON = new Field(InstrAttribType.INSTANCE, Values.ZERO_COUPON.getOrdinal());
        public final Field ORIGINAL_ISSUE_DISCOUNT = new Field(InstrAttribType.INSTANCE, Values.ORIGINAL_ISSUE_DISCOUNT.getOrdinal());
        public final Field FLAT_SECURITIES_PAY_INTEREST_ON_A_CURRENT_BASIS_BUT_ARE_TRADED_W = new Field(InstrAttribType.INSTANCE, Values.FLAT_SECURITIES_PAY_INTEREST_ON_A_CURRENT_BASIS_BUT_ARE_TRADED_W.getOrdinal());
        public final Field STEPPED_COUPON = new Field(InstrAttribType.INSTANCE, Values.STEPPED_COUPON.getOrdinal());
        public final Field LESS_FEE_FOR_PUT = new Field(InstrAttribType.INSTANCE, Values.LESS_FEE_FOR_PUT.getOrdinal());
        public final Field VARIABLE_RATE = new Field(InstrAttribType.INSTANCE, Values.VARIABLE_RATE.getOrdinal());
        public final Field NO_PERIODIC_PAYMENTS = new Field(InstrAttribType.INSTANCE, Values.NO_PERIODIC_PAYMENTS.getOrdinal());
        public final Field WHEN_AND_IF_ISSUED = new Field(InstrAttribType.INSTANCE, Values.WHEN_AND_IF_ISSUED.getOrdinal());
        public final Field COUPON_PERIOD_IF_NOT_SEMIANNUAL_SUPPLY_REDEMPTION_DATE_IN_THE_IN = new Field(InstrAttribType.INSTANCE, Values.COUPON_PERIOD_IF_NOT_SEMIANNUAL_SUPPLY_REDEMPTION_DATE_IN_THE_IN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SUBJECT_TO_ALTERNATIVE_MINIMUM_TAX("19"),
        TAXABLE("17"),
        INDEXED("18"),
        IN_DEFAULT("15"),
        UNRATED("16"),
        ESCROWED_TO_REDEMPTION_DATE__CALLABLE_SUPPLY_REDEMPTION_DATE_IN_("13"),
        PREREFUNDED("14"),
        CALLABLE_PUTTABLE("11"),
        ESCROWED_TO_MATURITY("12"),
        CALLABLE_BELOW_MATURITY_VALUE("21"),
        ORIGINAL_ISSUE_DISCOUNT_PRICE_SUPPLY_PRICE_IN_THE_INSTRATTRIBVAL("20"),
        TEXT_SUPPLY_THE_TEXT_OF_THE_ATTRIBUTE_OR_DISCLAIMER_IN_THE_INSTR("99"),
        CALLABLE_WITHOUT_NOTICE_BY_MAIL_TO_HOLDER_UNLESS_REGISTERED("22"),
        PRICE_TICK_RULES_FOR_SECURITY("23"),
        TRADE_TYPE_ELIGIBILITY_DETAILS_FOR_SECURITY("24"),
        INSTRUMENT_DENOMINATOR("25"),
        INSTRUMENT_NUMERATOR("26"),
        INSTRUMENT_PRICE_PRECISION("27"),
        INSTRUMENT_STRIKE_PRICE("28"),
        TRADEABLE_INDICATOR("29"),
        INTEREST_BEARING_FOR_EURO_COMMERCIAL_PAPER_WHEN_NOT_ISSUED_AT_DI("3"),
        ZERO_COUPON("2"),
        ORIGINAL_ISSUE_DISCOUNT("10"),
        FLAT_SECURITIES_PAY_INTEREST_ON_A_CURRENT_BASIS_BUT_ARE_TRADED_W("1"),
        STEPPED_COUPON("7"),
        LESS_FEE_FOR_PUT("6"),
        VARIABLE_RATE("5"),
        NO_PERIODIC_PAYMENTS("4"),
        WHEN_AND_IF_ISSUED("9"),
        COUPON_PERIOD_IF_NOT_SEMIANNUAL_SUPPLY_REDEMPTION_DATE_IN_THE_IN("8");

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
