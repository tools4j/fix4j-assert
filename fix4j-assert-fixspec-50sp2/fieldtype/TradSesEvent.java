package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradSesEvent extends BaseFieldType {
    public static final TradSesEvent INSTANCE = new TradSesEvent();

    private TradSesEvent() {
        super(
            "TradSesEvent",
            1368,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CHANGE_OF_TRADING_STATUS = new Field(TradSesEvent.INSTANCE, Values.CHANGE_OF_TRADING_STATUS.getOrdinal());
        public final Field CHANGE_OF_TRADING_SUBSESSION = new Field(TradSesEvent.INSTANCE, Values.CHANGE_OF_TRADING_SUBSESSION.getOrdinal());
        public final Field CHANGE_OF_TRADING_SESSION = new Field(TradSesEvent.INSTANCE, Values.CHANGE_OF_TRADING_SESSION.getOrdinal());
        public final Field TRADING_RESUMES_AFTER_HALT = new Field(TradSesEvent.INSTANCE, Values.TRADING_RESUMES_AFTER_HALT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CHANGE_OF_TRADING_STATUS("3"),
        CHANGE_OF_TRADING_SUBSESSION("2"),
        CHANGE_OF_TRADING_SESSION("1"),
        TRADING_RESUMES_AFTER_HALT("0");

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
