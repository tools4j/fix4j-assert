package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradSesStatus extends BaseFieldType {
    public static final TradSesStatus INSTANCE = new TradSesStatus();

    private TradSesStatus() {
        super(
            "TradSesStatus",
            340,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CLOSED = new Field(TradSesStatus.INSTANCE, Values.CLOSED.getOrdinal());
        public final Field OPEN = new Field(TradSesStatus.INSTANCE, Values.OPEN.getOrdinal());
        public final Field HALTED = new Field(TradSesStatus.INSTANCE, Values.HALTED.getOrdinal());
        public final Field UNKNOWN = new Field(TradSesStatus.INSTANCE, Values.UNKNOWN.getOrdinal());
        public final Field REQUEST_REJECTED = new Field(TradSesStatus.INSTANCE, Values.REQUEST_REJECTED.getOrdinal());
        public final Field PRECLOSE = new Field(TradSesStatus.INSTANCE, Values.PRECLOSE.getOrdinal());
        public final Field PREOPEN = new Field(TradSesStatus.INSTANCE, Values.PREOPEN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CLOSED("3"),
        OPEN("2"),
        HALTED("1"),
        UNKNOWN("0"),
        REQUEST_REJECTED("6"),
        PRECLOSE("5"),
        PREOPEN("4");

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
