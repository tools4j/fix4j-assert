package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MatchType extends BaseFieldType {
    public static final MatchType INSTANCE = new MatchType();

    private MatchType() {
        super(
            "MatchType",
            574,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field _PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_FOUR_BADGES = new Field(MatchType.INSTANCE, Values._PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_FOUR_BADGES.getOrdinal());
        public final Field _PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_FOUR_BADGES_A = new Field(MatchType.INSTANCE, Values._PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_FOUR_BADGES_A.getOrdinal());
        public final Field ACT_M6_MATCH = new Field(MatchType.INSTANCE, Values.ACT_M6_MATCH.getOrdinal());
        public final Field _PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_TWO_BADGES = new Field(MatchType.INSTANCE, Values._PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_TWO_BADGES.getOrdinal());
        public final Field ACT_DEFAULT_AFTER_M2 = new Field(MatchType.INSTANCE, Values.ACT_DEFAULT_AFTER_M2.getOrdinal());
        public final Field _PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_TWO_BADGES_AN = new Field(MatchType.INSTANCE, Values._PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_TWO_BADGES_AN.getOrdinal());
        public final Field _PRICE_TRADETYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_EXECUTION_TIME = new Field(MatchType.INSTANCE, Values._PRICE_TRADETYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_EXECUTION_TIME.getOrdinal());
        public final Field SUMMARIZED_MATCH_USING_A2_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I = new Field(MatchType.INSTANCE, Values.SUMMARIZED_MATCH_USING_A2_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I.getOrdinal());
        public final Field SUMMARIZED_MATCH_USING_A1_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I = new Field(MatchType.INSTANCE, Values.SUMMARIZED_MATCH_USING_A1_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I.getOrdinal());
        public final Field ACT_DEFAULT_TRADE = new Field(MatchType.INSTANCE, Values.ACT_DEFAULT_TRADE.getOrdinal());
        public final Field ACT_ACCEPTED_TRADE = new Field(MatchType.INSTANCE, Values.ACT_ACCEPTED_TRADE.getOrdinal());
        public final Field SUMMARIZED_MATCH_MINUS_BADGES_AND_TIMES_ACT_M2_MATCH = new Field(MatchType.INSTANCE, Values.SUMMARIZED_MATCH_MINUS_BADGES_AND_TIMES_ACT_M2_MATCH.getOrdinal());
        public final Field _PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_MINUS_BADGES_AND_T = new Field(MatchType.INSTANCE, Values._PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_MINUS_BADGES_AND_T.getOrdinal());
        public final Field COMPARED_RECORDS_RESULTING_FROM_STAMPED_ADVISORIES_OR_SPECIALIST = new Field(MatchType.INSTANCE, Values.COMPARED_RECORDS_RESULTING_FROM_STAMPED_ADVISORIES_OR_SPECIALIST.getOrdinal());
        public final Field OCS_LOCKED_IN_NONACT = new Field(MatchType.INSTANCE, Values.OCS_LOCKED_IN_NONACT.getOrdinal());
        public final Field SUMMARIZED_MATCH_USING_A3_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I = new Field(MatchType.INSTANCE, Values.SUMMARIZED_MATCH_USING_A3_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I.getOrdinal());
        public final Field CONFIRMED_TRADE_REPORT_REPORTING_FROM_RECOGNIZED_MARKETS = new Field(MatchType.INSTANCE, Values.CONFIRMED_TRADE_REPORT_REPORTING_FROM_RECOGNIZED_MARKETS.getOrdinal());
        public final Field SUMMARIZED_MATCH_USING_A4_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I = new Field(MatchType.INSTANCE, Values.SUMMARIZED_MATCH_USING_A4_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I.getOrdinal());
        public final Field TWOPARTY_TRADE_REPORT_PRIVATELY_NEGOTIATED_TRADE = new Field(MatchType.INSTANCE, Values.TWOPARTY_TRADE_REPORT_PRIVATELY_NEGOTIATED_TRADE.getOrdinal());
        public final Field SUMMARIZED_MATCH_USING_A5_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I = new Field(MatchType.INSTANCE, Values.SUMMARIZED_MATCH_USING_A5_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I.getOrdinal());
        public final Field ONEPARTY_TRADE_REPORT_PRIVATELY_NEGOTIATED_TRADE = new Field(MatchType.INSTANCE, Values.ONEPARTY_TRADE_REPORT_PRIVATELY_NEGOTIATED_TRADE.getOrdinal());
        public final Field CALL_AUCTION = new Field(MatchType.INSTANCE, Values.CALL_AUCTION.getOrdinal());
        public final Field COUNTERORDER_SELECTION = new Field(MatchType.INSTANCE, Values.COUNTERORDER_SELECTION.getOrdinal());
        public final Field CROSS_AUCTION = new Field(MatchType.INSTANCE, Values.CROSS_AUCTION.getOrdinal());
        public final Field AUTOMATCH = new Field(MatchType.INSTANCE, Values.AUTOMATCH.getOrdinal());
        public final Field ISSUINGBUY_BACK_AUCTION = new Field(MatchType.INSTANCE, Values.ISSUINGBUY_BACK_AUCTION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        _PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_FOUR_BADGES("A2"),
        _PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_FOUR_BADGES_A("A1"),
        ACT_M6_MATCH("M6"),
        _PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_TWO_BADGES("A4"),
        ACT_DEFAULT_AFTER_M2("M5"),
        _PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_TWO_BADGES_AN("A3"),
        _PRICE_TRADETYPE_AND_SPECIAL_TRADE_INDICATOR_PLUS_EXECUTION_TIME("A5"),
        SUMMARIZED_MATCH_USING_A2_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I("S2"),
        SUMMARIZED_MATCH_USING_A1_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I("S1"),
        ACT_DEFAULT_TRADE("M4"),
        ACT_ACCEPTED_TRADE("M3"),
        SUMMARIZED_MATCH_MINUS_BADGES_AND_TIMES_ACT_M2_MATCH("M2"),
        _PRICE_TRADE_TYPE_AND_SPECIAL_TRADE_INDICATOR_MINUS_BADGES_AND_T("M1"),
        COMPARED_RECORDS_RESULTING_FROM_STAMPED_ADVISORIES_OR_SPECIALIST("AQ"),
        OCS_LOCKED_IN_NONACT("MT"),
        SUMMARIZED_MATCH_USING_A3_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I("S3"),
        CONFIRMED_TRADE_REPORT_REPORTING_FROM_RECOGNIZED_MARKETS("3"),
        SUMMARIZED_MATCH_USING_A4_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I("S4"),
        TWOPARTY_TRADE_REPORT_PRIVATELY_NEGOTIATED_TRADE("2"),
        SUMMARIZED_MATCH_USING_A5_EXACT_MATCH_CRITERIA_EXCEPT_QUANTITY_I("S5"),
        ONEPARTY_TRADE_REPORT_PRIVATELY_NEGOTIATED_TRADE("1"),
        CALL_AUCTION("7"),
        COUNTERORDER_SELECTION("6"),
        CROSS_AUCTION("5"),
        AUTOMATCH("4"),
        ISSUINGBUY_BACK_AUCTION("8");

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
