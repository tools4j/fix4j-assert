package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradSesMethod extends BaseFieldType {
    public static final TradSesMethod INSTANCE = new TradSesMethod();

    private TradSesMethod() {
        super(
            "TradSesMethod",
            338,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TWO_PARTY = new Field(TradSesMethod.INSTANCE, Values.TWO_PARTY.getOrdinal());
        public final Field OPEN_OUTCRY = new Field(TradSesMethod.INSTANCE, Values.OPEN_OUTCRY.getOrdinal());
        public final Field ELECTRONIC = new Field(TradSesMethod.INSTANCE, Values.ELECTRONIC.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TWO_PARTY("3"),
        OPEN_OUTCRY("2"),
        ELECTRONIC("1");

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
