package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DeskOrderHandlingInst extends BaseFieldType {
    public static final DeskOrderHandlingInst INSTANCE = new DeskOrderHandlingInst();

    private DeskOrderHandlingInst() {
        super(
            "DeskOrderHandlingInst",
            1035,
            FieldClassLookup.lookup("MULTIPLESTRINGVALUE"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXCHANGE_FOR_PHYSICAL_TRANSACTION = new Field(DeskOrderHandlingInst.INSTANCE, Values.EXCHANGE_FOR_PHYSICAL_TRANSACTION.getOrdinal());
        public final Field STOP_STOCK_TRANSACTION = new Field(DeskOrderHandlingInst.INSTANCE, Values.STOP_STOCK_TRANSACTION.getOrdinal());
        public final Field LIMIT_ON_OPEN = new Field(DeskOrderHandlingInst.INSTANCE, Values.LIMIT_ON_OPEN.getOrdinal());
        public final Field TIME_ORDER = new Field(DeskOrderHandlingInst.INSTANCE, Values.TIME_ORDER.getOrdinal());
        public final Field MARKET_ON_OPEN = new Field(DeskOrderHandlingInst.INSTANCE, Values.MARKET_ON_OPEN.getOrdinal());
        public final Field PEGGED = new Field(DeskOrderHandlingInst.INSTANCE, Values.PEGGED.getOrdinal());
        public final Field MINIMUM_QUANTITY = new Field(DeskOrderHandlingInst.INSTANCE, Values.MINIMUM_QUANTITY.getOrdinal());
        public final Field IMBALANCE_ONLY = new Field(DeskOrderHandlingInst.INSTANCE, Values.IMBALANCE_ONLY.getOrdinal());
        public final Field IMMEDIATE_OR_CANCEL = new Field(DeskOrderHandlingInst.INSTANCE, Values.IMMEDIATE_OR_CANCEL.getOrdinal());
        public final Field WORK = new Field(DeskOrderHandlingInst.INSTANCE, Values.WORK.getOrdinal());
        public final Field MARKET_ON_CLOSE = new Field(DeskOrderHandlingInst.INSTANCE, Values.MARKET_ON_CLOSE.getOrdinal());
        public final Field MARKET_AT_OPEN = new Field(DeskOrderHandlingInst.INSTANCE, Values.MARKET_AT_OPEN.getOrdinal());
        public final Field ALL_OR_NONE = new Field(DeskOrderHandlingInst.INSTANCE, Values.ALL_OR_NONE.getOrdinal());
        public final Field DIRECTED_ORDER = new Field(DeskOrderHandlingInst.INSTANCE, Values.DIRECTED_ORDER.getOrdinal());
        public final Field TRAILING_STOP = new Field(DeskOrderHandlingInst.INSTANCE, Values.TRAILING_STOP.getOrdinal());
        public final Field SCALE = new Field(DeskOrderHandlingInst.INSTANCE, Values.SCALE.getOrdinal());
        public final Field LIMIT_ON_CLOSE = new Field(DeskOrderHandlingInst.INSTANCE, Values.LIMIT_ON_CLOSE.getOrdinal());
        public final Field NOT_HELD = new Field(DeskOrderHandlingInst.INSTANCE, Values.NOT_HELD.getOrdinal());
        public final Field CASH_NOT_HELD = new Field(DeskOrderHandlingInst.INSTANCE, Values.CASH_NOT_HELD.getOrdinal());
        public final Field RESERVE_SIZE_ORDER = new Field(DeskOrderHandlingInst.INSTANCE, Values.RESERVE_SIZE_ORDER.getOrdinal());
        public final Field FILL_OR_KILL = new Field(DeskOrderHandlingInst.INSTANCE, Values.FILL_OR_KILL.getOrdinal());
        public final Field OVER_THE_DAY = new Field(DeskOrderHandlingInst.INSTANCE, Values.OVER_THE_DAY.getOrdinal());
        public final Field MARKET_AT_CLOSE = new Field(DeskOrderHandlingInst.INSTANCE, Values.MARKET_AT_CLOSE.getOrdinal());
        public final Field ADDON_ORDER = new Field(DeskOrderHandlingInst.INSTANCE, Values.ADDON_ORDER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXCHANGE_FOR_PHYSICAL_TRANSACTION("E.W"),
        STOP_STOCK_TRANSACTION("S.W"),
        LIMIT_ON_OPEN("LOO"),
        TIME_ORDER("TMO"),
        MARKET_ON_OPEN("MOO"),
        PEGGED("PEG"),
        MINIMUM_QUANTITY("MQT"),
        IMBALANCE_ONLY("IO"),
        IMMEDIATE_OR_CANCEL("IOC"),
        WORK("WRK"),
        MARKET_ON_CLOSE("MOC"),
        MARKET_AT_OPEN("MAO"),
        ALL_OR_NONE("AON"),
        DIRECTED_ORDER("DIR"),
        TRAILING_STOP("TS"),
        SCALE("SCL"),
        LIMIT_ON_CLOSE("LOC"),
        NOT_HELD("NH"),
        CASH_NOT_HELD("CNH"),
        RESERVE_SIZE_ORDER("RSV"),
        FILL_OR_KILL("FOK"),
        OVER_THE_DAY("OVD"),
        MARKET_AT_CLOSE("MAC"),
        ADDON_ORDER("ADD");

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
