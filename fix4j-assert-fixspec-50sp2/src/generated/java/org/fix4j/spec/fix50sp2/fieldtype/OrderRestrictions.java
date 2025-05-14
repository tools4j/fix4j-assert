package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OrderRestrictions extends BaseFieldType {
    public static final OrderRestrictions INSTANCE = new OrderRestrictions();

    private OrderRestrictions() {
        super(
            "OrderRestrictions",
            529,
            FieldClassLookup.lookup("MULTIPLECHARVALUE"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NONALGORITHMIC = new Field(OrderRestrictions.INSTANCE, Values.NONALGORITHMIC.getOrdinal());
        public final Field ALGORITHMIC = new Field(OrderRestrictions.INSTANCE, Values.ALGORITHMIC.getOrdinal());
        public final Field CROSS = new Field(OrderRestrictions.INSTANCE, Values.CROSS.getOrdinal());
        public final Field RISKLESS_ARBITRAGE = new Field(OrderRestrictions.INSTANCE, Values.RISKLESS_ARBITRAGE.getOrdinal());
        public final Field ISSUER_HOLDING = new Field(OrderRestrictions.INSTANCE, Values.ISSUER_HOLDING.getOrdinal());
        public final Field ISSUE_PRICE_STABILIZATION = new Field(OrderRestrictions.INSTANCE, Values.ISSUE_PRICE_STABILIZATION.getOrdinal());
        public final Field NONINDEX_ARBITRAGE = new Field(OrderRestrictions.INSTANCE, Values.NONINDEX_ARBITRAGE.getOrdinal());
        public final Field INDEX_ARBITRAGE = new Field(OrderRestrictions.INSTANCE, Values.INDEX_ARBITRAGE.getOrdinal());
        public final Field PROGRAM_TRADE = new Field(OrderRestrictions.INSTANCE, Values.PROGRAM_TRADE.getOrdinal());
        public final Field FOREIGN_ENTITY_OF_FOREIGN_GOVERNMENT_OR_REGULATORY_JURISDICTION = new Field(OrderRestrictions.INSTANCE, Values.FOREIGN_ENTITY_OF_FOREIGN_GOVERNMENT_OR_REGULATORY_JURISDICTION.getOrdinal());
        public final Field ACTING_AS_MARKET_MAKER_OR_SPECIALIST_IN_THE_UNDERLYING_SECURITY_ = new Field(OrderRestrictions.INSTANCE, Values.ACTING_AS_MARKET_MAKER_OR_SPECIALIST_IN_THE_UNDERLYING_SECURITY_.getOrdinal());
        public final Field ACTING_AS_MARKET_MAKER_OR_SPECIALIST_IN_THE_SECURITY = new Field(OrderRestrictions.INSTANCE, Values.ACTING_AS_MARKET_MAKER_OR_SPECIALIST_IN_THE_SECURITY.getOrdinal());
        public final Field COMPETING_MARKET_MAKER = new Field(OrderRestrictions.INSTANCE, Values.COMPETING_MARKET_MAKER.getOrdinal());
        public final Field EXTERNAL_INTERCONNECTED_MARKET_LINKAGE = new Field(OrderRestrictions.INSTANCE, Values.EXTERNAL_INTERCONNECTED_MARKET_LINKAGE.getOrdinal());
        public final Field EXTERNAL_MARKET_PARTICIPANT = new Field(OrderRestrictions.INSTANCE, Values.EXTERNAL_MARKET_PARTICIPANT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NONALGORITHMIC("D"),
        ALGORITHMIC("E"),
        CROSS("F"),
        RISKLESS_ARBITRAGE("A"),
        ISSUER_HOLDING("B"),
        ISSUE_PRICE_STABILIZATION("C"),
        NONINDEX_ARBITRAGE("3"),
        INDEX_ARBITRAGE("2"),
        PROGRAM_TRADE("1"),
        FOREIGN_ENTITY_OF_FOREIGN_GOVERNMENT_OR_REGULATORY_JURISDICTION("7"),
        ACTING_AS_MARKET_MAKER_OR_SPECIALIST_IN_THE_UNDERLYING_SECURITY_("6"),
        ACTING_AS_MARKET_MAKER_OR_SPECIALIST_IN_THE_SECURITY("5"),
        COMPETING_MARKET_MAKER("4"),
        EXTERNAL_INTERCONNECTED_MARKET_LINKAGE("9"),
        EXTERNAL_MARKET_PARTICIPANT("8");

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
