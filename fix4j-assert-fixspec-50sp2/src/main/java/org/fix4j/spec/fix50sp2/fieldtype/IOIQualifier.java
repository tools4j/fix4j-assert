package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class IOIQualifier extends BaseFieldType {
    public static final IOIQualifier INSTANCE = new IOIQualifier();

    private IOIQualifier() {
        super(
            "IOIQualifier",
            104,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field VWAP_VOLUME_WEIGHTED_AVERAGE_PRICE = new Field(IOIQualifier.INSTANCE, Values.VWAP_VOLUME_WEIGHTED_AVERAGE_PRICE.getOrdinal());
        public final Field ALL_OR_NONE_AON = new Field(IOIQualifier.INSTANCE, Values.ALL_OR_NONE_AON.getOrdinal());
        public final Field MARKET_ON_CLOSE_MOC_HELD_TO_CLOSE = new Field(IOIQualifier.INSTANCE, Values.MARKET_ON_CLOSE_MOC_HELD_TO_CLOSE.getOrdinal());
        public final Field AT_THE_CLOSE_AROUNDNOT_HELD_TO_CLOSE = new Field(IOIQualifier.INSTANCE, Values.AT_THE_CLOSE_AROUNDNOT_HELD_TO_CLOSE.getOrdinal());
        public final Field LIMIT = new Field(IOIQualifier.INSTANCE, Values.LIMIT.getOrdinal());
        public final Field MORE_BEHIND = new Field(IOIQualifier.INSTANCE, Values.MORE_BEHIND.getOrdinal());
        public final Field AT_THE_OPEN = new Field(IOIQualifier.INSTANCE, Values.AT_THE_OPEN.getOrdinal());
        public final Field IN_TOUCH_WITH = new Field(IOIQualifier.INSTANCE, Values.IN_TOUCH_WITH.getOrdinal());
        public final Field THROUGH_THE_DAY = new Field(IOIQualifier.INSTANCE, Values.THROUGH_THE_DAY.getOrdinal());
        public final Field INDICATION__WORKING_AWAY = new Field(IOIQualifier.INSTANCE, Values.INDICATION__WORKING_AWAY.getOrdinal());
        public final Field VERSUS = new Field(IOIQualifier.INSTANCE, Values.VERSUS.getOrdinal());
        public final Field AT_THE_MARKET_PREVIOUSLY_CALLED_CURRENT_QUOTE = new Field(IOIQualifier.INSTANCE, Values.AT_THE_MARKET_PREVIOUSLY_CALLED_CURRENT_QUOTE.getOrdinal());
        public final Field TAKING_A_POSITION = new Field(IOIQualifier.INSTANCE, Values.TAKING_A_POSITION.getOrdinal());
        public final Field PORTFOLIO_SHOWN = new Field(IOIQualifier.INSTANCE, Values.PORTFOLIO_SHOWN.getOrdinal());
        public final Field READY_TO_TRADE = new Field(IOIQualifier.INSTANCE, Values.READY_TO_TRADE.getOrdinal());
        public final Field AT_THE_MIDPOINT = new Field(IOIQualifier.INSTANCE, Values.AT_THE_MIDPOINT.getOrdinal());
        public final Field CROSSING_OPPORTUNITY = new Field(IOIQualifier.INSTANCE, Values.CROSSING_OPPORTUNITY.getOrdinal());
        public final Field PREOPEN = new Field(IOIQualifier.INSTANCE, Values.PREOPEN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        VWAP_VOLUME_WEIGHTED_AVERAGE_PRICE("D"),
        ALL_OR_NONE_AON("A"),
        MARKET_ON_CLOSE_MOC_HELD_TO_CLOSE("B"),
        AT_THE_CLOSE_AROUNDNOT_HELD_TO_CLOSE("C"),
        LIMIT("L"),
        MORE_BEHIND("M"),
        AT_THE_OPEN("O"),
        IN_TOUCH_WITH("I"),
        THROUGH_THE_DAY("T"),
        INDICATION__WORKING_AWAY("W"),
        VERSUS("V"),
        AT_THE_MARKET_PREVIOUSLY_CALLED_CURRENT_QUOTE("Q"),
        TAKING_A_POSITION("P"),
        PORTFOLIO_SHOWN("S"),
        READY_TO_TRADE("R"),
        AT_THE_MIDPOINT("Y"),
        CROSSING_OPPORTUNITY("X"),
        PREOPEN("Z");

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
