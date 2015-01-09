package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityTradingEvent extends BaseFieldType {
    public static final SecurityTradingEvent INSTANCE = new SecurityTradingEvent();

    private SecurityTradingEvent() {
        super(
            "SecurityTradingEvent",
            1174,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PRICE_VOLATILITY_INTERRUPTION = new Field(SecurityTradingEvent.INSTANCE, Values.PRICE_VOLATILITY_INTERRUPTION.getOrdinal());
        public final Field TRADING_RESUMES_AFTER_HALT = new Field(SecurityTradingEvent.INSTANCE, Values.TRADING_RESUMES_AFTER_HALT.getOrdinal());
        public final Field ORDER_IMBALANCE_AUCTION_IS_EXTENDED = new Field(SecurityTradingEvent.INSTANCE, Values.ORDER_IMBALANCE_AUCTION_IS_EXTENDED.getOrdinal());
        public final Field CHANGE_OF_BOOK_TYPE = new Field(SecurityTradingEvent.INSTANCE, Values.CHANGE_OF_BOOK_TYPE.getOrdinal());
        public final Field CHANGE_OF_SECURITY_TRADING_STATUS = new Field(SecurityTradingEvent.INSTANCE, Values.CHANGE_OF_SECURITY_TRADING_STATUS.getOrdinal());
        public final Field CHANGE_OF_TRADING_SUBSESSION = new Field(SecurityTradingEvent.INSTANCE, Values.CHANGE_OF_TRADING_SUBSESSION.getOrdinal());
        public final Field CHANGE_OF_TRADING_SESSION = new Field(SecurityTradingEvent.INSTANCE, Values.CHANGE_OF_TRADING_SESSION.getOrdinal());
        public final Field CHANGE_OF_MARKET_DEPTH = new Field(SecurityTradingEvent.INSTANCE, Values.CHANGE_OF_MARKET_DEPTH.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PRICE_VOLATILITY_INTERRUPTION("3"),
        TRADING_RESUMES_AFTER_HALT("2"),
        ORDER_IMBALANCE_AUCTION_IS_EXTENDED("1"),
        CHANGE_OF_BOOK_TYPE("7"),
        CHANGE_OF_SECURITY_TRADING_STATUS("6"),
        CHANGE_OF_TRADING_SUBSESSION("5"),
        CHANGE_OF_TRADING_SESSION("4"),
        CHANGE_OF_MARKET_DEPTH("8");

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
