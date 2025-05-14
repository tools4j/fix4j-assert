package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class YieldType extends BaseFieldType {
    public static final YieldType INSTANCE = new YieldType();

    private YieldType() {
        super(
            "YieldType",
            235,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TAX_EQUIVALENT_YIELD = new Field(YieldType.INSTANCE, Values.TAX_EQUIVALENT_YIELD.getOrdinal());
        public final Field CLOSING_YIELD_MOST_RECENT_MONTH = new Field(YieldType.INSTANCE, Values.CLOSING_YIELD_MOST_RECENT_MONTH.getOrdinal());
        public final Field MARK_TO_MARKET_YIELD = new Field(YieldType.INSTANCE, Values.MARK_TO_MARKET_YIELD.getOrdinal());
        public final Field SEMIANNUAL_YIELD = new Field(YieldType.INSTANCE, Values.SEMIANNUAL_YIELD.getOrdinal());
        public final Field CLOSING_YIELD_MOST_RECENT_QUARTER = new Field(YieldType.INSTANCE, Values.CLOSING_YIELD_MOST_RECENT_QUARTER.getOrdinal());
        public final Field YIELD_TO_NEXT_REFUND_SINKING_FUND_BONDS = new Field(YieldType.INSTANCE, Values.YIELD_TO_NEXT_REFUND_SINKING_FUND_BONDS.getOrdinal());
        public final Field BOOK_YIELD = new Field(YieldType.INSTANCE, Values.BOOK_YIELD.getOrdinal());
        public final Field YIELD_TO_TENDER_DATE = new Field(YieldType.INSTANCE, Values.YIELD_TO_TENDER_DATE.getOrdinal());
        public final Field CLOSING_YIELD_MOST_RECENT_YEAR = new Field(YieldType.INSTANCE, Values.CLOSING_YIELD_MOST_RECENT_YEAR.getOrdinal());
        public final Field YIELD_TO_LONGEST_AVERAGE_LIFE = new Field(YieldType.INSTANCE, Values.YIELD_TO_LONGEST_AVERAGE_LIFE.getOrdinal());
        public final Field PREVIOUS_CLOSE_YIELD = new Field(YieldType.INSTANCE, Values.PREVIOUS_CLOSE_YIELD.getOrdinal());
        public final Field TRUE_YIELD = new Field(YieldType.INSTANCE, Values.TRUE_YIELD.getOrdinal());
        public final Field YIELD_TO_WORST = new Field(YieldType.INSTANCE, Values.YIELD_TO_WORST.getOrdinal());
        public final Field CURRENT_YIELD = new Field(YieldType.INSTANCE, Values.CURRENT_YIELD.getOrdinal());
        public final Field COMPOUND_YIELD = new Field(YieldType.INSTANCE, Values.COMPOUND_YIELD.getOrdinal());
        public final Field YIELD_CHANGE_SINCE_CLOSE = new Field(YieldType.INSTANCE, Values.YIELD_CHANGE_SINCE_CLOSE.getOrdinal());
        public final Field AFTER_TAX_YIELD_MUNICIPALS = new Field(YieldType.INSTANCE, Values.AFTER_TAX_YIELD_MUNICIPALS.getOrdinal());
        public final Field TRUE_GROSS_YIELD = new Field(YieldType.INSTANCE, Values.TRUE_GROSS_YIELD.getOrdinal());
        public final Field ANNUAL_YIELD = new Field(YieldType.INSTANCE, Values.ANNUAL_YIELD.getOrdinal());
        public final Field OPEN_AVERAGE_YIELD = new Field(YieldType.INSTANCE, Values.OPEN_AVERAGE_YIELD.getOrdinal());
        public final Field PROCEEDS_YIELD = new Field(YieldType.INSTANCE, Values.PROCEEDS_YIELD.getOrdinal());
        public final Field YIELD_TO_SHORTEST_AVERAGE_LIFE = new Field(YieldType.INSTANCE, Values.YIELD_TO_SHORTEST_AVERAGE_LIFE.getOrdinal());
        public final Field MOST_RECENT_CLOSING_YIELD = new Field(YieldType.INSTANCE, Values.MOST_RECENT_CLOSING_YIELD.getOrdinal());
        public final Field CLOSING_YIELD = new Field(YieldType.INSTANCE, Values.CLOSING_YIELD.getOrdinal());
        public final Field YIELD_TO_AVG_MATURITY = new Field(YieldType.INSTANCE, Values.YIELD_TO_AVG_MATURITY.getOrdinal());
        public final Field YIELD_AT_ISSUE_MUNICIPALS = new Field(YieldType.INSTANCE, Values.YIELD_AT_ISSUE_MUNICIPALS.getOrdinal());
        public final Field YIELD_VALUE_OF_132 = new Field(YieldType.INSTANCE, Values.YIELD_VALUE_OF_132.getOrdinal());
        public final Field GVNT_EQUIVALENT_YIELD = new Field(YieldType.INSTANCE, Values.GVNT_EQUIVALENT_YIELD.getOrdinal());
        public final Field YIELD_TO_NEXT_CALL = new Field(YieldType.INSTANCE, Values.YIELD_TO_NEXT_CALL.getOrdinal());
        public final Field YIELD_TO_MATURITY = new Field(YieldType.INSTANCE, Values.YIELD_TO_MATURITY.getOrdinal());
        public final Field YIELD_WITH_INFLATION_ASSUMPTION = new Field(YieldType.INSTANCE, Values.YIELD_WITH_INFLATION_ASSUMPTION.getOrdinal());
        public final Field INVERSE_FLOATER_BOND_YIELD = new Field(YieldType.INSTANCE, Values.INVERSE_FLOATER_BOND_YIELD.getOrdinal());
        public final Field SIMPLE_YIELD = new Field(YieldType.INSTANCE, Values.SIMPLE_YIELD.getOrdinal());
        public final Field YIELD_TO_NEXT_PUT = new Field(YieldType.INSTANCE, Values.YIELD_TO_NEXT_PUT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TAX_EQUIVALENT_YIELD("TAXEQUIV"),
        CLOSING_YIELD_MOST_RECENT_MONTH("LASTMONTH"),
        MARK_TO_MARKET_YIELD("MARK"),
        SEMIANNUAL_YIELD("SEMIANNUAL"),
        CLOSING_YIELD_MOST_RECENT_QUARTER("LASTQUARTER"),
        YIELD_TO_NEXT_REFUND_SINKING_FUND_BONDS("NEXTREFUND"),
        BOOK_YIELD("BOOK"),
        YIELD_TO_TENDER_DATE("TENDER"),
        CLOSING_YIELD_MOST_RECENT_YEAR("LASTYEAR"),
        YIELD_TO_LONGEST_AVERAGE_LIFE("LONGAVGLIFE"),
        PREVIOUS_CLOSE_YIELD("PREVCLOSE"),
        TRUE_YIELD("TRUE"),
        YIELD_TO_WORST("WORST"),
        CURRENT_YIELD("CURRENT"),
        COMPOUND_YIELD("COMPOUND"),
        YIELD_CHANGE_SINCE_CLOSE("CHANGE"),
        AFTER_TAX_YIELD_MUNICIPALS("AFTERTAX"),
        TRUE_GROSS_YIELD("GROSS"),
        ANNUAL_YIELD("ANNUAL"),
        OPEN_AVERAGE_YIELD("OPENAVG"),
        PROCEEDS_YIELD("PROCEEDS"),
        YIELD_TO_SHORTEST_AVERAGE_LIFE("SHORTAVGLIFE"),
        MOST_RECENT_CLOSING_YIELD("LASTCLOSE"),
        CLOSING_YIELD("CLOSE"),
        YIELD_TO_AVG_MATURITY("AVGMATURITY"),
        YIELD_AT_ISSUE_MUNICIPALS("ATISSUE"),
        YIELD_VALUE_OF_132("VALUE1_32"),
        GVNT_EQUIVALENT_YIELD("GOVTEQUIV"),
        YIELD_TO_NEXT_CALL("CALL"),
        YIELD_TO_MATURITY("MATURITY"),
        YIELD_WITH_INFLATION_ASSUMPTION("INFLATION"),
        INVERSE_FLOATER_BOND_YIELD("INVERSEFLOATER"),
        SIMPLE_YIELD("SIMPLE"),
        YIELD_TO_NEXT_PUT("PUT");

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
