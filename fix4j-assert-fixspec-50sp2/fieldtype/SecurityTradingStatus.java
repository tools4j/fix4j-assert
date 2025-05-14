package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityTradingStatus extends BaseFieldType {
    public static final SecurityTradingStatus INSTANCE = new SecurityTradingStatus();

    private SecurityTradingStatus() {
        super(
            "SecurityTradingStatus",
            326,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NOT_TRADED_ON_THIS_MARKET = new Field(SecurityTradingStatus.INSTANCE, Values.NOT_TRADED_ON_THIS_MARKET.getOrdinal());
        public final Field READY_TO_TRADE_START_OF_SESSION = new Field(SecurityTradingStatus.INSTANCE, Values.READY_TO_TRADE_START_OF_SESSION.getOrdinal());
        public final Field NOT_AVAILABLE_FOR_TRADING_END_OF_SESSION = new Field(SecurityTradingStatus.INSTANCE, Values.NOT_AVAILABLE_FOR_TRADING_END_OF_SESSION.getOrdinal());
        public final Field NEW_PRICE_INDICATION = new Field(SecurityTradingStatus.INSTANCE, Values.NEW_PRICE_INDICATION.getOrdinal());
        public final Field TRADE_DISSEMINATION_TIME = new Field(SecurityTradingStatus.INSTANCE, Values.TRADE_DISSEMINATION_TIME.getOrdinal());
        public final Field NO_MARKET_ON_CLOSE_IMBALANCE = new Field(SecurityTradingStatus.INSTANCE, Values.NO_MARKET_ON_CLOSE_IMBALANCE.getOrdinal());
        public final Field ITS_PREOPENING = new Field(SecurityTradingStatus.INSTANCE, Values.ITS_PREOPENING.getOrdinal());
        public final Field NOT_ASSIGNED = new Field(SecurityTradingStatus.INSTANCE, Values.NOT_ASSIGNED.getOrdinal());
        public final Field NO_MARKET_IMBALANCE = new Field(SecurityTradingStatus.INSTANCE, Values.NO_MARKET_IMBALANCE.getOrdinal());
        public final Field PREOPEN = new Field(SecurityTradingStatus.INSTANCE, Values.PREOPEN.getOrdinal());
        public final Field UNKNOWN_OR_INVALID = new Field(SecurityTradingStatus.INSTANCE, Values.UNKNOWN_OR_INVALID.getOrdinal());
        public final Field OPENING_ROTATION = new Field(SecurityTradingStatus.INSTANCE, Values.OPENING_ROTATION.getOrdinal());
        public final Field FAST_MARKET = new Field(SecurityTradingStatus.INSTANCE, Values.FAST_MARKET.getOrdinal());
        public final Field PRECROSS__SYSTEM_IS_IN_A_PRECROSS_STATE_ALLOWING_MARKET_TO_RESPO = new Field(SecurityTradingStatus.INSTANCE, Values.PRECROSS__SYSTEM_IS_IN_A_PRECROSS_STATE_ALLOWING_MARKET_TO_RESPO.getOrdinal());
        public final Field CROSS__SYSTEM_HAS_CROSSED_A_PERCENTAGE_OF_THE_ORDERS_AND_ALLOWS_ = new Field(SecurityTradingStatus.INSTANCE, Values.CROSS__SYSTEM_HAS_CROSSED_A_PERCENTAGE_OF_THE_ORDERS_AND_ALLOWS_.getOrdinal());
        public final Field POSTCLOSE = new Field(SecurityTradingStatus.INSTANCE, Values.POSTCLOSE.getOrdinal());
        public final Field RESUME = new Field(SecurityTradingStatus.INSTANCE, Values.RESUME.getOrdinal());
        public final Field TRADING_HALT = new Field(SecurityTradingStatus.INSTANCE, Values.TRADING_HALT.getOrdinal());
        public final Field MARKET_ON_CLOSE_IMBALANCE_SELL = new Field(SecurityTradingStatus.INSTANCE, Values.MARKET_ON_CLOSE_IMBALANCE_SELL.getOrdinal());
        public final Field OPENING_DELAY = new Field(SecurityTradingStatus.INSTANCE, Values.OPENING_DELAY.getOrdinal());
        public final Field MARKET_IMBALANCE_BUY = new Field(SecurityTradingStatus.INSTANCE, Values.MARKET_IMBALANCE_BUY.getOrdinal());
        public final Field TRADING_RANGE_INDICATION = new Field(SecurityTradingStatus.INSTANCE, Values.TRADING_RANGE_INDICATION.getOrdinal());
        public final Field PRICE_INDICATION = new Field(SecurityTradingStatus.INSTANCE, Values.PRICE_INDICATION.getOrdinal());
        public final Field NO_OPEN__NO_RESUME = new Field(SecurityTradingStatus.INSTANCE, Values.NO_OPEN__NO_RESUME.getOrdinal());
        public final Field MARKET_ON_CLOSE_IMBALANCE_BUY = new Field(SecurityTradingStatus.INSTANCE, Values.MARKET_ON_CLOSE_IMBALANCE_BUY.getOrdinal());
        public final Field MARKET_IMBALANCE_SELL = new Field(SecurityTradingStatus.INSTANCE, Values.MARKET_IMBALANCE_SELL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NOT_TRADED_ON_THIS_MARKET("19"),
        READY_TO_TRADE_START_OF_SESSION("17"),
        NOT_AVAILABLE_FOR_TRADING_END_OF_SESSION("18"),
        NEW_PRICE_INDICATION("15"),
        TRADE_DISSEMINATION_TIME("16"),
        NO_MARKET_ON_CLOSE_IMBALANCE("13"),
        ITS_PREOPENING("14"),
        NOT_ASSIGNED("11"),
        NO_MARKET_IMBALANCE("12"),
        PREOPEN("21"),
        UNKNOWN_OR_INVALID("20"),
        OPENING_ROTATION("22"),
        FAST_MARKET("23"),
        PRECROSS__SYSTEM_IS_IN_A_PRECROSS_STATE_ALLOWING_MARKET_TO_RESPO("24"),
        CROSS__SYSTEM_HAS_CROSSED_A_PERCENTAGE_OF_THE_ORDERS_AND_ALLOWS_("25"),
        POSTCLOSE("26"),
        RESUME("3"),
        TRADING_HALT("2"),
        MARKET_ON_CLOSE_IMBALANCE_SELL("10"),
        OPENING_DELAY("1"),
        MARKET_IMBALANCE_BUY("7"),
        TRADING_RANGE_INDICATION("6"),
        PRICE_INDICATION("5"),
        NO_OPEN__NO_RESUME("4"),
        MARKET_ON_CLOSE_IMBALANCE_BUY("9"),
        MARKET_IMBALANCE_SELL("8");

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
