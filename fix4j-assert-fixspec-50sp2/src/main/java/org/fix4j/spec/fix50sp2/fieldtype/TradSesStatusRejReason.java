package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradSesStatusRejReason extends BaseFieldType {
    public static final TradSesStatusRejReason INSTANCE = new TradSesStatusRejReason();

    private TradSesStatusRejReason() {
        super(
            "TradSesStatusRejReason",
            567,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field UNKNOWN_OR_INVALID_TRADINGSESSIONID = new Field(TradSesStatusRejReason.INSTANCE, Values.UNKNOWN_OR_INVALID_TRADINGSESSIONID.getOrdinal());
        public final Field OTHER = new Field(TradSesStatusRejReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        UNKNOWN_OR_INVALID_TRADINGSESSIONID("1"),
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
