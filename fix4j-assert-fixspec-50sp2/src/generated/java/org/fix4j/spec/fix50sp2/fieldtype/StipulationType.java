package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StipulationType extends BaseFieldType {
    public static final StipulationType INSTANCE = new StipulationType();

    private StipulationType() {
        super(
            "StipulationType",
            233,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field YEAR_OR_YEARMONTH_OF_ISSUE_EX_234200209 = new Field(StipulationType.INSTANCE, Values.YEAR_OR_YEARMONTH_OF_ISSUE_EX_234200209.getOrdinal());
        public final Field ALTERNATIVE_MINIMUM_TAX_YN = new Field(StipulationType.INSTANCE, Values.ALTERNATIVE_MINIMUM_TAX_YN.getOrdinal());
        public final Field MARKET_SECTOR = new Field(StipulationType.INSTANCE, Values.MARKET_SECTOR.getOrdinal());
        public final Field THE_MINIMUM_RESIDUAL_OFFER_QUANTITY = new Field(StipulationType.INSTANCE, Values.THE_MINIMUM_RESIDUAL_OFFER_QUANTITY.getOrdinal());
        public final Field INSURED_YN = new Field(StipulationType.INSTANCE, Values.INSURED_YN.getOrdinal());
        public final Field PAYMENT_FREQUENCY_CALENDAR = new Field(StipulationType.INSTANCE, Values.PAYMENT_FREQUENCY_CALENDAR.getOrdinal());
        public final Field PERCENT_OF_BMA_PREPAYMENT_CURVE = new Field(StipulationType.INSTANCE, Values.PERCENT_OF_BMA_PREPAYMENT_CURVE.getOrdinal());
        public final Field SUBSTITUTIONS_LEFT_REPO = new Field(StipulationType.INSTANCE, Values.SUBSTITUTIONS_LEFT_REPO.getOrdinal());
        public final Field WEIGHTED_AVERAGE_LOAN_AGE__VALUE_IN_MONTHS_EXACT_OR_RANGE = new Field(StipulationType.INSTANCE, Values.WEIGHTED_AVERAGE_LOAN_AGE__VALUE_IN_MONTHS_EXACT_OR_RANGE.getOrdinal());
        public final Field GEOGRAPHICS_AND__RANGE_EX_234CA_080_MINIMUM_OF_80_CALIFORNIA_ASS = new Field(StipulationType.INSTANCE, Values.GEOGRAPHICS_AND__RANGE_EX_234CA_080_MINIMUM_OF_80_CALIFORNIA_ASS.getOrdinal());
        public final Field PRICING_FREQUENCY = new Field(StipulationType.INSTANCE, Values.PRICING_FREQUENCY.getOrdinal());
        public final Field LOT_VARIANCE_VALUE_IN_PERCENT_MAXIMUM_OVER_OR_UNDERALLOCATION_AL = new Field(StipulationType.INSTANCE, Values.LOT_VARIANCE_VALUE_IN_PERCENT_MAXIMUM_OVER_OR_UNDERALLOCATION_AL.getOrdinal());
        public final Field MATURITY_YEAR_AND_MONTH = new Field(StipulationType.INSTANCE, Values.MATURITY_YEAR_AND_MONTH.getOrdinal());
        public final Field PRINCIPAL_OF_ROLLING_OR_CLOSING_TRADE = new Field(StipulationType.INSTANCE, Values.PRINCIPAL_OF_ROLLING_OR_CLOSING_TRADE.getOrdinal());
        public final Field EXPLICIT_LOT_IDENTIFIER = new Field(StipulationType.INSTANCE, Values.EXPLICIT_LOT_IDENTIFIER.getOrdinal());
        public final Field AVERAGE_FICO_SCORE = new Field(StipulationType.INSTANCE, Values.AVERAGE_FICO_SCORE.getOrdinal());
        public final Field FINAL_CPR_OF_HOME_EQUITY_PREPAYMENT_CURVE = new Field(StipulationType.INSTANCE, Values.FINAL_CPR_OF_HOME_EQUITY_PREPAYMENT_CURVE.getOrdinal());
        public final Field MAXIMUM_ORDER_SIZE = new Field(StipulationType.INSTANCE, Values.MAXIMUM_ORDER_SIZE.getOrdinal());
        public final Field MAXIMUM_SUBSTITUTIONS_REPO = new Field(StipulationType.INSTANCE, Values.MAXIMUM_SUBSTITUTIONS_REPO.getOrdinal());
        public final Field ORDER_QUANTITY_INCREMENT = new Field(StipulationType.INSTANCE, Values.ORDER_QUANTITY_INCREMENT.getOrdinal());
        public final Field WEIGHTED_AVERAGE_LIFE_COUPON__VALUE_IN_PERCENT_EXACT_OR_RANGE = new Field(StipulationType.INSTANCE, Values.WEIGHTED_AVERAGE_LIFE_COUPON__VALUE_IN_PERCENT_EXACT_OR_RANGE.getOrdinal());
        public final Field WEIGHTED_AVERAGE_MATURITY__VALUE_IN_MONTHS_EXACT_OR_RANGE = new Field(StipulationType.INSTANCE, Values.WEIGHTED_AVERAGE_MATURITY__VALUE_IN_MONTHS_EXACT_OR_RANGE.getOrdinal());
        public final Field MINIMUM_INCREMENT = new Field(StipulationType.INSTANCE, Values.MINIMUM_INCREMENT.getOrdinal());
        public final Field LOOKBACK_DAYS = new Field(StipulationType.INSTANCE, Values.LOOKBACK_DAYS.getOrdinal());
        public final Field PRODUCTION_YEAR = new Field(StipulationType.INSTANCE, Values.PRODUCTION_YEAR.getOrdinal());
        public final Field YIELD_RANGE = new Field(StipulationType.INSTANCE, Values.YIELD_RANGE.getOrdinal());
        public final Field TYPE_OF_REDEMPTION__VALUES_ARE_NONCALLABLE_PREFUNDED_ESCROWEDTOM = new Field(StipulationType.INSTANCE, Values.TYPE_OF_REDEMPTION__VALUES_ARE_NONCALLABLE_PREFUNDED_ESCROWEDTOM.getOrdinal());
        public final Field REFERENCE_TO_ROLLING_OR_CLOSING_TRADE = new Field(StipulationType.INSTANCE, Values.REFERENCE_TO_ROLLING_OR_CLOSING_TRADE.getOrdinal());
        public final Field TRADERS_CREDIT = new Field(StipulationType.INSTANCE, Values.TRADERS_CREDIT.getOrdinal());
        public final Field TRADE_VARIANCE_VALUE_IN_PERCENT_MAXIMUM_OVER_OR_UNDERALLOCATION_ = new Field(StipulationType.INSTANCE, Values.TRADE_VARIANCE_VALUE_IN_PERCENT_MAXIMUM_OVER_OR_UNDERALLOCATION_.getOrdinal());
        public final Field CALL_PROTECTION = new Field(StipulationType.INSTANCE, Values.CALL_PROTECTION.getOrdinal());
        public final Field SECURITY_TYPE_INCLUDED_OR_EXCLUDED = new Field(StipulationType.INSTANCE, Values.SECURITY_TYPE_INCLUDED_OR_EXCLUDED.getOrdinal());
        public final Field SINGLE_MONTHLY_MORTALITY = new Field(StipulationType.INSTANCE, Values.SINGLE_MONTHLY_MORTALITY.getOrdinal());
        public final Field AVERAGE_LOAN_SIZE = new Field(StipulationType.INSTANCE, Values.AVERAGE_LOAN_SIZE.getOrdinal());
        public final Field COUPON_RANGE = new Field(StipulationType.INSTANCE, Values.COUPON_RANGE.getOrdinal());
        public final Field RATING_SOURCE_AND_RANGE = new Field(StipulationType.INSTANCE, Values.RATING_SOURCE_AND_RANGE.getOrdinal());
        public final Field YIELD_TO_MATURITY_WHEN_YIELDTYPE235_AND_YIELD236_SHOW_A_DIFFEREN = new Field(StipulationType.INSTANCE, Values.YIELD_TO_MATURITY_WHEN_YIELDTYPE235_AND_YIELD236_SHOW_A_DIFFEREN.getOrdinal());
        public final Field INTEREST_OF_ROLLING_OR_CLOSING_TRADE = new Field(StipulationType.INSTANCE, Values.INTEREST_OF_ROLLING_OR_CLOSING_TRADE.getOrdinal());
        public final Field AUTO_REINVESTMENT_AT_RATE_OR_BETTER = new Field(StipulationType.INSTANCE, Values.AUTO_REINVESTMENT_AT_RATE_OR_BETTER.getOrdinal());
        public final Field CONSTANT_PREPAYMENT_PENALTY = new Field(StipulationType.INSTANCE, Values.CONSTANT_PREPAYMENT_PENALTY.getOrdinal());
        public final Field PRICE_RANGE = new Field(StipulationType.INSTANCE, Values.PRICE_RANGE.getOrdinal());
        public final Field VALUATION_DISCOUNT = new Field(StipulationType.INSTANCE, Values.VALUATION_DISCOUNT.getOrdinal());
        public final Field POOL_IDENTIFIER = new Field(StipulationType.INSTANCE, Values.POOL_IDENTIFIER.getOrdinal());
        public final Field CONSTANT_PREPAYMENT_RATE = new Field(StipulationType.INSTANCE, Values.CONSTANT_PREPAYMENT_RATE.getOrdinal());
        public final Field MINIMUM_DENOMINATION = new Field(StipulationType.INSTANCE, Values.MINIMUM_DENOMINATION.getOrdinal());
        public final Field CONSTANT_PREPAYMENT_YIELD = new Field(StipulationType.INSTANCE, Values.CONSTANT_PREPAYMENT_YIELD.getOrdinal());
        public final Field POOLS_PER_TRADE = new Field(StipulationType.INSTANCE, Values.POOLS_PER_TRADE.getOrdinal());
        public final Field PURPOSE = new Field(StipulationType.INSTANCE, Values.PURPOSE.getOrdinal());
        public final Field ISSUE_SIZE_RANGE = new Field(StipulationType.INSTANCE, Values.ISSUE_SIZE_RANGE.getOrdinal());
        public final Field BANK_QUALIFIED_YN = new Field(StipulationType.INSTANCE, Values.BANK_QUALIFIED_YN.getOrdinal());
        public final Field OFFER_QUANTITY_TO_BE_SHOWN_TO_INTERNAL_BROKERS = new Field(StipulationType.INSTANCE, Values.OFFER_QUANTITY_TO_BE_SHOWN_TO_INTERNAL_BROKERS.getOrdinal());
        public final Field RESTRICTED_YN = new Field(StipulationType.INSTANCE, Values.RESTRICTED_YN.getOrdinal());
        public final Field STRUCTURE = new Field(StipulationType.INSTANCE, Values.STRUCTURE.getOrdinal());
        public final Field BROKER_SALES_CREDIT_OVERRIDE = new Field(StipulationType.INSTANCE, Values.BROKER_SALES_CREDIT_OVERRIDE.getOrdinal());
        public final Field PRIMARY_OR_SECONDARY_MARKET_INDICATOR = new Field(StipulationType.INSTANCE, Values.PRIMARY_OR_SECONDARY_MARKET_INDICATOR.getOrdinal());
        public final Field BROKERS_SALES_CREDIT = new Field(StipulationType.INSTANCE, Values.BROKERS_SALES_CREDIT.getOrdinal());
        public final Field POOLS_PER_LOT = new Field(StipulationType.INSTANCE, Values.POOLS_PER_LOT.getOrdinal());
        public final Field FREEFORM_TEXT = new Field(StipulationType.INSTANCE, Values.FREEFORM_TEXT.getOrdinal());
        public final Field POOLS_PER_MILLION = new Field(StipulationType.INSTANCE, Values.POOLS_PER_MILLION.getOrdinal());
        public final Field SUBSTITUTIONS_FREQUENCY_REPO = new Field(StipulationType.INSTANCE, Values.SUBSTITUTIONS_FREQUENCY_REPO.getOrdinal());
        public final Field NUMBER_OF_PIECES = new Field(StipulationType.INSTANCE, Values.NUMBER_OF_PIECES.getOrdinal());
        public final Field PERCENT_OF_PROSPECTUS_PREPAYMENT_CURVE = new Field(StipulationType.INSTANCE, Values.PERCENT_OF_PROSPECTUS_PREPAYMENT_CURVE.getOrdinal());
        public final Field WEIGHTED_AVERAGE_COUPON__VALUE_IN_PERCENT_EXACT_OR_RANGE_PLUS_GR = new Field(StipulationType.INSTANCE, Values.WEIGHTED_AVERAGE_COUPON__VALUE_IN_PERCENT_EXACT_OR_RANGE_PLUS_GR.getOrdinal());
        public final Field TYPE_OF_ROLL_TRADE = new Field(StipulationType.INSTANCE, Values.TYPE_OF_ROLL_TRADE.getOrdinal());
        public final Field DISCOUNT_RATE_WHEN_PRICE_IS_DENOMINATED_IN_PERCENT_OF_PAR = new Field(StipulationType.INSTANCE, Values.DISCOUNT_RATE_WHEN_PRICE_IS_DENOMINATED_IN_PERCENT_OF_PAR.getOrdinal());
        public final Field WHOLE_POOL_YN = new Field(StipulationType.INSTANCE, Values.WHOLE_POOL_YN.getOrdinal());
        public final Field ISSUERS_TICKER = new Field(StipulationType.INSTANCE, Values.ISSUERS_TICKER.getOrdinal());
        public final Field ABSOLUTE_PREPAYMENT_SPEED = new Field(StipulationType.INSTANCE, Values.ABSOLUTE_PREPAYMENT_SPEED.getOrdinal());
        public final Field CUSTOM_STARTEND_DATE = new Field(StipulationType.INSTANCE, Values.CUSTOM_STARTEND_DATE.getOrdinal());
        public final Field AVAILABLE_OFFER_QUANTITY_TO_BE_SHOWN_TO_THE_STREET = new Field(StipulationType.INSTANCE, Values.AVAILABLE_OFFER_QUANTITY_TO_BE_SHOWN_TO_THE_STREET.getOrdinal());
        public final Field BENCHMARK_PRICE_SOURCE = new Field(StipulationType.INSTANCE, Values.BENCHMARK_PRICE_SOURCE.getOrdinal());
        public final Field MAXIMUM_LOAN_BALANCE = new Field(StipulationType.INSTANCE, Values.MAXIMUM_LOAN_BALANCE.getOrdinal());
        public final Field BARGAIN_CONDITIONS_SEE_STIPULATIONVALUE_234_FOR_VALUES = new Field(StipulationType.INSTANCE, Values.BARGAIN_CONDITIONS_SEE_STIPULATIONVALUE_234_FOR_VALUES.getOrdinal());
        public final Field POOLS_MAXIMUM = new Field(StipulationType.INSTANCE, Values.POOLS_MAXIMUM.getOrdinal());
        public final Field PERCENT_OF_MANUFACTURED_HOUSING_PREPAYMENT_CURVE = new Field(StipulationType.INSTANCE, Values.PERCENT_OF_MANUFACTURED_HOUSING_PREPAYMENT_CURVE.getOrdinal());
        public final Field ISO_CURRENCY_CODE = new Field(StipulationType.INSTANCE, Values.ISO_CURRENCY_CODE.getOrdinal());
        public final Field MATURITY_RANGE = new Field(StipulationType.INSTANCE, Values.MATURITY_RANGE.getOrdinal());
        public final Field MINIMUM_QUANTITY = new Field(StipulationType.INSTANCE, Values.MINIMUM_QUANTITY.getOrdinal());
        public final Field MONTHLY_PREPAYMENT_RATE = new Field(StipulationType.INSTANCE, Values.MONTHLY_PREPAYMENT_RATE.getOrdinal());
        public final Field OFFER_PRICE_TO_BE_SHOWN_TO_INTERNAL_BROKERS = new Field(StipulationType.INSTANCE, Values.OFFER_PRICE_TO_BE_SHOWN_TO_INTERNAL_BROKERS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        YEAR_OR_YEARMONTH_OF_ISSUE_EX_234200209("ISSUE"),
        ALTERNATIVE_MINIMUM_TAX_YN("AMT"),
        MARKET_SECTOR("SECTOR"),
        THE_MINIMUM_RESIDUAL_OFFER_QUANTITY("LEAVEQTY"),
        INSURED_YN("INSURED"),
        PAYMENT_FREQUENCY_CALENDAR("PAYFREQ"),
        PERCENT_OF_BMA_PREPAYMENT_CURVE("PSA"),
        SUBSTITUTIONS_LEFT_REPO("SUBSLEFT"),
        WEIGHTED_AVERAGE_LOAN_AGE__VALUE_IN_MONTHS_EXACT_OR_RANGE("WALA"),
        GEOGRAPHICS_AND__RANGE_EX_234CA_080_MINIMUM_OF_80_CALIFORNIA_ASS("GEOG"),
        PRICING_FREQUENCY("PRICEFREQ"),
        LOT_VARIANCE_VALUE_IN_PERCENT_MAXIMUM_OVER_OR_UNDERALLOCATION_AL("LOTVAR"),
        MATURITY_YEAR_AND_MONTH("MAT"),
        PRINCIPAL_OF_ROLLING_OR_CLOSING_TRADE("REFPRIN"),
        EXPLICIT_LOT_IDENTIFIER("LOT"),
        AVERAGE_FICO_SCORE("AVFICO"),
        FINAL_CPR_OF_HOME_EQUITY_PREPAYMENT_CURVE("HEP"),
        MAXIMUM_ORDER_SIZE("MAXORDQTY"),
        MAXIMUM_SUBSTITUTIONS_REPO("MAXSUBS"),
        ORDER_QUANTITY_INCREMENT("ORDRINCR"),
        WEIGHTED_AVERAGE_LIFE_COUPON__VALUE_IN_PERCENT_EXACT_OR_RANGE("WAL"),
        WEIGHTED_AVERAGE_MATURITY__VALUE_IN_MONTHS_EXACT_OR_RANGE("WAM"),
        MINIMUM_INCREMENT("MININCR"),
        LOOKBACK_DAYS("LOOKBACK"),
        PRODUCTION_YEAR("PROD"),
        YIELD_RANGE("YIELD"),
        TYPE_OF_REDEMPTION__VALUES_ARE_NONCALLABLE_PREFUNDED_ESCROWEDTOM("REDEMPTION"),
        REFERENCE_TO_ROLLING_OR_CLOSING_TRADE("REFTRADE"),
        TRADERS_CREDIT("TRADERCREDIT"),
        TRADE_VARIANCE_VALUE_IN_PERCENT_MAXIMUM_OVER_OR_UNDERALLOCATION_("TRDVAR"),
        CALL_PROTECTION("PROTECT"),
        SECURITY_TYPE_INCLUDED_OR_EXCLUDED("SECTYPE"),
        SINGLE_MONTHLY_MORTALITY("SMM"),
        AVERAGE_LOAN_SIZE("AVSIZE"),
        COUPON_RANGE("COUPON"),
        RATING_SOURCE_AND_RANGE("RATING"),
        YIELD_TO_MATURITY_WHEN_YIELDTYPE235_AND_YIELD236_SHOW_A_DIFFEREN("YTM"),
        INTEREST_OF_ROLLING_OR_CLOSING_TRADE("REFINT"),
        AUTO_REINVESTMENT_AT_RATE_OR_BETTER("AUTOREINV"),
        CONSTANT_PREPAYMENT_PENALTY("CPP"),
        PRICE_RANGE("PRICE"),
        VALUATION_DISCOUNT("HAIRCUT"),
        POOL_IDENTIFIER("POOL"),
        CONSTANT_PREPAYMENT_RATE("CPR"),
        MINIMUM_DENOMINATION("MINDNOM"),
        CONSTANT_PREPAYMENT_YIELD("CPY"),
        POOLS_PER_TRADE("PPT"),
        PURPOSE("PURPOSE"),
        ISSUE_SIZE_RANGE("ISSUESIZE"),
        BANK_QUALIFIED_YN("BANKQUAL"),
        OFFER_QUANTITY_TO_BE_SHOWN_TO_INTERNAL_BROKERS("INTERNALQTY"),
        RESTRICTED_YN("RESTRICTED"),
        STRUCTURE("STRUCT"),
        BROKER_SALES_CREDIT_OVERRIDE("SALESCREDITOVR"),
        PRIMARY_OR_SECONDARY_MARKET_INDICATOR("PRIMARY"),
        BROKERS_SALES_CREDIT("BROKERCREDIT"),
        POOLS_PER_LOT("PPL"),
        FREEFORM_TEXT("TEXT"),
        POOLS_PER_MILLION("PPM"),
        SUBSTITUTIONS_FREQUENCY_REPO("SUBSFREQ"),
        NUMBER_OF_PIECES("PIECES"),
        PERCENT_OF_PROSPECTUS_PREPAYMENT_CURVE("PPC"),
        WEIGHTED_AVERAGE_COUPON__VALUE_IN_PERCENT_EXACT_OR_RANGE_PLUS_GR("WAC"),
        TYPE_OF_ROLL_TRADE("ROLLTYPE"),
        DISCOUNT_RATE_WHEN_PRICE_IS_DENOMINATED_IN_PERCENT_OF_PAR("DISCOUNT"),
        WHOLE_POOL_YN("WHOLE"),
        ISSUERS_TICKER("ISSUER"),
        ABSOLUTE_PREPAYMENT_SPEED("ABS"),
        CUSTOM_STARTEND_DATE("CUSTOMDATE"),
        AVAILABLE_OFFER_QUANTITY_TO_BE_SHOWN_TO_THE_STREET("AVAILQTY"),
        BENCHMARK_PRICE_SOURCE("PXSOURCE"),
        MAXIMUM_LOAN_BALANCE("MAXBAL"),
        BARGAIN_CONDITIONS_SEE_STIPULATIONVALUE_234_FOR_VALUES("BGNCON"),
        POOLS_MAXIMUM("PMAX"),
        PERCENT_OF_MANUFACTURED_HOUSING_PREPAYMENT_CURVE("MHP"),
        ISO_CURRENCY_CODE("CURRENCY"),
        MATURITY_RANGE("MATURITY"),
        MINIMUM_QUANTITY("MINQTY"),
        MONTHLY_PREPAYMENT_RATE("MPR"),
        OFFER_PRICE_TO_BE_SHOWN_TO_INTERNAL_BROKERS("INTERNALPX");

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
