package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradingSessionSubID extends BaseFieldType {
    public static final TradingSessionSubID INSTANCE = new TradingSessionSubID();

    private TradingSessionSubID() {
        super(
            "TradingSessionSubID",
            625,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CONTINUOUS_TRADING = new Field(TradingSessionSubID.INSTANCE, Values.CONTINUOUS_TRADING.getOrdinal());
        public final Field OPENING_OR_OPENING_AUCTION = new Field(TradingSessionSubID.INSTANCE, Values.OPENING_OR_OPENING_AUCTION.getOrdinal());
        public final Field PRETRADING = new Field(TradingSessionSubID.INSTANCE, Values.PRETRADING.getOrdinal());
        public final Field QUIESCENT = new Field(TradingSessionSubID.INSTANCE, Values.QUIESCENT.getOrdinal());
        public final Field INTRADAY_AUCTION = new Field(TradingSessionSubID.INSTANCE, Values.INTRADAY_AUCTION.getOrdinal());
        public final Field POSTTRADING = new Field(TradingSessionSubID.INSTANCE, Values.POSTTRADING.getOrdinal());
        public final Field CLOSING_OR_CLOSING_AUCTION = new Field(TradingSessionSubID.INSTANCE, Values.CLOSING_OR_CLOSING_AUCTION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CONTINUOUS_TRADING("3"),
        OPENING_OR_OPENING_AUCTION("2"),
        PRETRADING("1"),
        QUIESCENT("7"),
        INTRADAY_AUCTION("6"),
        POSTTRADING("5"),
        CLOSING_OR_CLOSING_AUCTION("4");

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
