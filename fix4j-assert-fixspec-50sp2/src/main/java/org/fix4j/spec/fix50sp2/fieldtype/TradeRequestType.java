package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradeRequestType extends BaseFieldType {
    public static final TradeRequestType INSTANCE = new TradeRequestType();

    private TradeRequestType() {
        super(
            "TradeRequestType",
            569,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field UNREPORTED_TRADES_THAT_MATCH_CRITERIA = new Field(TradeRequestType.INSTANCE, Values.UNREPORTED_TRADES_THAT_MATCH_CRITERIA.getOrdinal());
        public final Field UNMATCHED_TRADES_THAT_MATCH_CRITERIA = new Field(TradeRequestType.INSTANCE, Values.UNMATCHED_TRADES_THAT_MATCH_CRITERIA.getOrdinal());
        public final Field MATCHED_TRADES_MATCHING_CRITERIA_PROVIDED_ON_REQUEST_PARTIES_EXE = new Field(TradeRequestType.INSTANCE, Values.MATCHED_TRADES_MATCHING_CRITERIA_PROVIDED_ON_REQUEST_PARTIES_EXE.getOrdinal());
        public final Field ALL_TRADES = new Field(TradeRequestType.INSTANCE, Values.ALL_TRADES.getOrdinal());
        public final Field ADVISORIES_THAT_MATCH_CRITERIA = new Field(TradeRequestType.INSTANCE, Values.ADVISORIES_THAT_MATCH_CRITERIA.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        UNREPORTED_TRADES_THAT_MATCH_CRITERIA("3"),
        UNMATCHED_TRADES_THAT_MATCH_CRITERIA("2"),
        MATCHED_TRADES_MATCHING_CRITERIA_PROVIDED_ON_REQUEST_PARTIES_EXE("1"),
        ALL_TRADES("0"),
        ADVISORIES_THAT_MATCH_CRITERIA("4");

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
