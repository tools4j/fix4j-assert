package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PartyRelationship extends BaseFieldType {
    public static final PartyRelationship INSTANCE = new PartyRelationship();

    private PartyRelationship() {
        super(
            "PartyRelationship",
            1515,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INVESTS_FOR = new Field(PartyRelationship.INSTANCE, Values.INVESTS_FOR.getOrdinal());
        public final Field BENEFICIAL_OWNER_OF = new Field(PartyRelationship.INSTANCE, Values.BENEFICIAL_OWNER_OF.getOrdinal());
        public final Field PROVIDES_QUOTES_TO = new Field(PartyRelationship.INSTANCE, Values.PROVIDES_QUOTES_TO.getOrdinal());
        public final Field OWNED_BY_BENEFICIAL = new Field(PartyRelationship.INSTANCE, Values.OWNED_BY_BENEFICIAL.getOrdinal());
        public final Field REQUESTS_QUOTES_FROM = new Field(PartyRelationship.INSTANCE, Values.REQUESTS_QUOTES_FROM.getOrdinal());
        public final Field LEGAL__TITLED_OWNER_OF = new Field(PartyRelationship.INSTANCE, Values.LEGAL__TITLED_OWNER_OF.getOrdinal());
        public final Field ENTERS_TRADES_FOR = new Field(PartyRelationship.INSTANCE, Values.ENTERS_TRADES_FOR.getOrdinal());
        public final Field OWNED_BY_LEGAL__TITLE = new Field(PartyRelationship.INSTANCE, Values.OWNED_BY_LEGAL__TITLE.getOrdinal());
        public final Field ENTERS_TRADES_THROUGH = new Field(PartyRelationship.INSTANCE, Values.ENTERS_TRADES_THROUGH.getOrdinal());
        public final Field CARRIES_POSITIONS_FOR = new Field(PartyRelationship.INSTANCE, Values.CARRIES_POSITIONS_FOR.getOrdinal());
        public final Field POSTS_TRADES_TO = new Field(PartyRelationship.INSTANCE, Values.POSTS_TRADES_TO.getOrdinal());
        public final Field PROVIDES_MARKETPLACE_FOR = new Field(PartyRelationship.INSTANCE, Values.PROVIDES_MARKETPLACE_FOR.getOrdinal());
        public final Field PARTICIPANT_OF_MARKETPLACE = new Field(PartyRelationship.INSTANCE, Values.PARTICIPANT_OF_MARKETPLACE.getOrdinal());
        public final Field BROKERS_TRADES_FOR = new Field(PartyRelationship.INSTANCE, Values.BROKERS_TRADES_FOR.getOrdinal());
        public final Field INVESTS_THROUGH = new Field(PartyRelationship.INSTANCE, Values.INVESTS_THROUGH.getOrdinal());
        public final Field BROKERS_TRADES_THROUGH = new Field(PartyRelationship.INSTANCE, Values.BROKERS_TRADES_THROUGH.getOrdinal());
        public final Field PROVIDES_TRADING_SERVICES_FOR = new Field(PartyRelationship.INSTANCE, Values.PROVIDES_TRADING_SERVICES_FOR.getOrdinal());
        public final Field USES_TRADING_SERVICES_OF = new Field(PartyRelationship.INSTANCE, Values.USES_TRADING_SERVICES_OF.getOrdinal());
        public final Field APPROVES_OF = new Field(PartyRelationship.INSTANCE, Values.APPROVES_OF.getOrdinal());
        public final Field APPROVED_BY = new Field(PartyRelationship.INSTANCE, Values.APPROVED_BY.getOrdinal());
        public final Field PARENT_FIRM_FOR = new Field(PartyRelationship.INSTANCE, Values.PARENT_FIRM_FOR.getOrdinal());
        public final Field SUBSIDIARY_OF = new Field(PartyRelationship.INSTANCE, Values.SUBSIDIARY_OF.getOrdinal());
        public final Field REGULATORY_OWNER_OF = new Field(PartyRelationship.INSTANCE, Values.REGULATORY_OWNER_OF.getOrdinal());
        public final Field TRADES_FOR = new Field(PartyRelationship.INSTANCE, Values.TRADES_FOR.getOrdinal());
        public final Field CLEARS_THROUGH = new Field(PartyRelationship.INSTANCE, Values.CLEARS_THROUGH.getOrdinal());
        public final Field HAS_MEMBERS = new Field(PartyRelationship.INSTANCE, Values.HAS_MEMBERS.getOrdinal());
        public final Field CLEARS_FOR = new Field(PartyRelationship.INSTANCE, Values.CLEARS_FOR.getOrdinal());
        public final Field IS_ALSO = new Field(PartyRelationship.INSTANCE, Values.IS_ALSO.getOrdinal());
        public final Field OWNED_BY_REGULATORY = new Field(PartyRelationship.INSTANCE, Values.OWNED_BY_REGULATORY.getOrdinal());
        public final Field PROVIDES_GUARANTEE_FOR = new Field(PartyRelationship.INSTANCE, Values.PROVIDES_GUARANTEE_FOR.getOrdinal());
        public final Field SPONSORED_THROUGH = new Field(PartyRelationship.INSTANCE, Values.SPONSORED_THROUGH.getOrdinal());
        public final Field IS_CONTROLLED_BY = new Field(PartyRelationship.INSTANCE, Values.IS_CONTROLLED_BY.getOrdinal());
        public final Field SPONSORS = new Field(PartyRelationship.INSTANCE, Values.SPONSORS.getOrdinal());
        public final Field CONTROLS = new Field(PartyRelationship.INSTANCE, Values.CONTROLS.getOrdinal());
        public final Field TRADES_THROUGH = new Field(PartyRelationship.INSTANCE, Values.TRADES_THROUGH.getOrdinal());
        public final Field MEMBER_OF = new Field(PartyRelationship.INSTANCE, Values.MEMBER_OF.getOrdinal());
        public final Field IS_GUARANTEED_BY = new Field(PartyRelationship.INSTANCE, Values.IS_GUARANTEED_BY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INVESTS_FOR("19"),
        BENEFICIAL_OWNER_OF("35"),
        PROVIDES_QUOTES_TO("17"),
        OWNED_BY_BENEFICIAL("36"),
        REQUESTS_QUOTES_FROM("18"),
        LEGAL__TITLED_OWNER_OF("33"),
        ENTERS_TRADES_FOR("15"),
        OWNED_BY_LEGAL__TITLE("34"),
        ENTERS_TRADES_THROUGH("16"),
        CARRIES_POSITIONS_FOR("13"),
        POSTS_TRADES_TO("14"),
        PROVIDES_MARKETPLACE_FOR("11"),
        PARTICIPANT_OF_MARKETPLACE("12"),
        BROKERS_TRADES_FOR("21"),
        INVESTS_THROUGH("20"),
        BROKERS_TRADES_THROUGH("22"),
        PROVIDES_TRADING_SERVICES_FOR("23"),
        USES_TRADING_SERVICES_OF("24"),
        APPROVES_OF("25"),
        APPROVED_BY("26"),
        PARENT_FIRM_FOR("27"),
        SUBSIDIARY_OF("28"),
        REGULATORY_OWNER_OF("29"),
        TRADES_FOR("3"),
        CLEARS_THROUGH("2"),
        HAS_MEMBERS("10"),
        CLEARS_FOR("1"),
        IS_ALSO("0"),
        OWNED_BY_REGULATORY("30"),
        PROVIDES_GUARANTEE_FOR("7"),
        SPONSORED_THROUGH("6"),
        IS_CONTROLLED_BY("32"),
        SPONSORS("5"),
        CONTROLS("31"),
        TRADES_THROUGH("4"),
        MEMBER_OF("9"),
        IS_GUARANTEED_BY("8");

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
