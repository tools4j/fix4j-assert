package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradingSessionID extends BaseFieldType {
    public static final TradingSessionID INSTANCE = new TradingSessionID();

    private TradingSessionID() {
        super(
            "TradingSessionID",
            336,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MORNING = new Field(TradingSessionID.INSTANCE, Values.MORNING.getOrdinal());
        public final Field HALFDAY = new Field(TradingSessionID.INSTANCE, Values.HALFDAY.getOrdinal());
        public final Field DAY = new Field(TradingSessionID.INSTANCE, Values.DAY.getOrdinal());
        public final Field AFTERHOURS = new Field(TradingSessionID.INSTANCE, Values.AFTERHOURS.getOrdinal());
        public final Field EVENING = new Field(TradingSessionID.INSTANCE, Values.EVENING.getOrdinal());
        public final Field AFTERNOON = new Field(TradingSessionID.INSTANCE, Values.AFTERNOON.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MORNING("3"),
        HALFDAY("2"),
        DAY("1"),
        AFTERHOURS("6"),
        EVENING("5"),
        AFTERNOON("4");

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
