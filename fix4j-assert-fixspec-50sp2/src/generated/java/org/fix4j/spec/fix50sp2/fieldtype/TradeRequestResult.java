package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradeRequestResult extends BaseFieldType {
    public static final TradeRequestResult INSTANCE = new TradeRequestResult();

    private TradeRequestResult() {
        super(
            "TradeRequestResult",
            749,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INVALID_PARTIES = new Field(TradeRequestResult.INSTANCE, Values.INVALID_PARTIES.getOrdinal());
        public final Field INVALID_TYPE_OF_TRADE_REQUESTED = new Field(TradeRequestResult.INSTANCE, Values.INVALID_TYPE_OF_TRADE_REQUESTED.getOrdinal());
        public final Field INVALID_OR_UNKNOWN_INSTRUMENT = new Field(TradeRequestResult.INSTANCE, Values.INVALID_OR_UNKNOWN_INSTRUMENT.getOrdinal());
        public final Field SUCCESSFUL_DEFAULT = new Field(TradeRequestResult.INSTANCE, Values.SUCCESSFUL_DEFAULT.getOrdinal());
        public final Field INVALID_DESTINATION_REQUESTED = new Field(TradeRequestResult.INSTANCE, Values.INVALID_DESTINATION_REQUESTED.getOrdinal());
        public final Field INVALID_TRANSPORT_TYPE_REQUESTED = new Field(TradeRequestResult.INSTANCE, Values.INVALID_TRANSPORT_TYPE_REQUESTED.getOrdinal());
        public final Field NOT_AUTHORIZED = new Field(TradeRequestResult.INSTANCE, Values.NOT_AUTHORIZED.getOrdinal());
        public final Field TRADEREQUESTTYPE_NOT_SUPPORTED = new Field(TradeRequestResult.INSTANCE, Values.TRADEREQUESTTYPE_NOT_SUPPORTED.getOrdinal());
        public final Field OTHER = new Field(TradeRequestResult.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INVALID_PARTIES("3"),
        INVALID_TYPE_OF_TRADE_REQUESTED("2"),
        INVALID_OR_UNKNOWN_INSTRUMENT("1"),
        SUCCESSFUL_DEFAULT("0"),
        INVALID_DESTINATION_REQUESTED("5"),
        INVALID_TRANSPORT_TYPE_REQUESTED("4"),
        NOT_AUTHORIZED("9"),
        TRADEREQUESTTYPE_NOT_SUPPORTED("8"),
        OTHER("99");

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
