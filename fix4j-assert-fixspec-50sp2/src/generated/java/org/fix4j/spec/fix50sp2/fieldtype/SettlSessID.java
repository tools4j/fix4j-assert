package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlSessID extends BaseFieldType {
    public static final SettlSessID INSTANCE = new SettlSessID();

    private SettlSessID() {
        super(
            "SettlSessID",
            716,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ELECTRONIC_TRADING_HOURS = new Field(SettlSessID.INSTANCE, Values.ELECTRONIC_TRADING_HOURS.getOrdinal());
        public final Field INTRADAY = new Field(SettlSessID.INSTANCE, Values.INTRADAY.getOrdinal());
        public final Field REGULAR_TRADING_HOURS = new Field(SettlSessID.INSTANCE, Values.REGULAR_TRADING_HOURS.getOrdinal());
        public final Field END_OF_DAY = new Field(SettlSessID.INSTANCE, Values.END_OF_DAY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ELECTRONIC_TRADING_HOURS("ETH"),
        INTRADAY("ITD"),
        REGULAR_TRADING_HOURS("RTH"),
        END_OF_DAY("EOD");

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
