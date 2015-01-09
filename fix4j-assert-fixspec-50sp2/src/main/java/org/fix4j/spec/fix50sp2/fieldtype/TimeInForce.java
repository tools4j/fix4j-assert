package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TimeInForce extends BaseFieldType {
    public static final TimeInForce INSTANCE = new TimeInForce();

    private TimeInForce() {
        super(
            "TimeInForce",
            59,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field IMMEDIATE_OR_CANCEL_IOC = new Field(TimeInForce.INSTANCE, Values.IMMEDIATE_OR_CANCEL_IOC.getOrdinal());
        public final Field AT_THE_OPENING_OPG = new Field(TimeInForce.INSTANCE, Values.AT_THE_OPENING_OPG.getOrdinal());
        public final Field GOOD_TILL_CANCEL_GTC = new Field(TimeInForce.INSTANCE, Values.GOOD_TILL_CANCEL_GTC.getOrdinal());
        public final Field DAY_OR_SESSION = new Field(TimeInForce.INSTANCE, Values.DAY_OR_SESSION.getOrdinal());
        public final Field AT_THE_CLOSE = new Field(TimeInForce.INSTANCE, Values.AT_THE_CLOSE.getOrdinal());
        public final Field GOOD_TILL_DATE_GTD = new Field(TimeInForce.INSTANCE, Values.GOOD_TILL_DATE_GTD.getOrdinal());
        public final Field GOOD_TILL_CROSSING_GTX = new Field(TimeInForce.INSTANCE, Values.GOOD_TILL_CROSSING_GTX.getOrdinal());
        public final Field FILL_OR_KILL_FOK = new Field(TimeInForce.INSTANCE, Values.FILL_OR_KILL_FOK.getOrdinal());
        public final Field AT_CROSSING = new Field(TimeInForce.INSTANCE, Values.AT_CROSSING.getOrdinal());
        public final Field GOOD_THROUGH_CROSSING = new Field(TimeInForce.INSTANCE, Values.GOOD_THROUGH_CROSSING.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        IMMEDIATE_OR_CANCEL_IOC("3"),
        AT_THE_OPENING_OPG("2"),
        GOOD_TILL_CANCEL_GTC("1"),
        DAY_OR_SESSION("0"),
        AT_THE_CLOSE("7"),
        GOOD_TILL_DATE_GTD("6"),
        GOOD_TILL_CROSSING_GTX("5"),
        FILL_OR_KILL_FOK("4"),
        AT_CROSSING("9"),
        GOOD_THROUGH_CROSSING("8");

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
