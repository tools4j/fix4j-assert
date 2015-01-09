package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class EventType extends BaseFieldType {
    public static final EventType INSTANCE = new EventType();

    private EventType() {
        super(
            "EventType",
            865,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field POSITION_REMOVAL_DATE = new Field(EventType.INSTANCE, Values.POSITION_REMOVAL_DATE.getOrdinal());
        public final Field FIRST_INTENT_DATE = new Field(EventType.INSTANCE, Values.FIRST_INTENT_DATE.getOrdinal());
        public final Field LAST_INTENT_DATE = new Field(EventType.INSTANCE, Values.LAST_INTENT_DATE.getOrdinal());
        public final Field INITIAL_INVENTORY_DUE_DATE = new Field(EventType.INSTANCE, Values.INITIAL_INVENTORY_DUE_DATE.getOrdinal());
        public final Field FINAL_INVENTORY_DUE_DATE = new Field(EventType.INSTANCE, Values.FINAL_INVENTORY_DUE_DATE.getOrdinal());
        public final Field FIRST_DELIVERY_DATE = new Field(EventType.INSTANCE, Values.FIRST_DELIVERY_DATE.getOrdinal());
        public final Field LAST_DELIVERY_DATE = new Field(EventType.INSTANCE, Values.LAST_DELIVERY_DATE.getOrdinal());
        public final Field SWAP_NEXT_START_DATE = new Field(EventType.INSTANCE, Values.SWAP_NEXT_START_DATE.getOrdinal());
        public final Field SWAP_NEXT_ROLL_DATE = new Field(EventType.INSTANCE, Values.SWAP_NEXT_ROLL_DATE.getOrdinal());
        public final Field TENDER = new Field(EventType.INSTANCE, Values.TENDER.getOrdinal());
        public final Field CALL = new Field(EventType.INSTANCE, Values.CALL.getOrdinal());
        public final Field PUT = new Field(EventType.INSTANCE, Values.PUT.getOrdinal());
        public final Field SWAP_ROLL_DATE = new Field(EventType.INSTANCE, Values.SWAP_ROLL_DATE.getOrdinal());
        public final Field LAST_ELIGIBLE_TRADE_DATE = new Field(EventType.INSTANCE, Values.LAST_ELIGIBLE_TRADE_DATE.getOrdinal());
        public final Field INACTIVIATION = new Field(EventType.INSTANCE, Values.INACTIVIATION.getOrdinal());
        public final Field ACTIVATION = new Field(EventType.INSTANCE, Values.ACTIVATION.getOrdinal());
        public final Field SINKING_FUND_CALL = new Field(EventType.INSTANCE, Values.SINKING_FUND_CALL.getOrdinal());
        public final Field SWAP_END_DATE = new Field(EventType.INSTANCE, Values.SWAP_END_DATE.getOrdinal());
        public final Field SWAP_START_DATE = new Field(EventType.INSTANCE, Values.SWAP_START_DATE.getOrdinal());
        public final Field OTHER = new Field(EventType.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        POSITION_REMOVAL_DATE("19"),
        FIRST_INTENT_DATE("17"),
        LAST_INTENT_DATE("18"),
        INITIAL_INVENTORY_DUE_DATE("15"),
        FINAL_INVENTORY_DUE_DATE("16"),
        FIRST_DELIVERY_DATE("13"),
        LAST_DELIVERY_DATE("14"),
        SWAP_NEXT_START_DATE("11"),
        SWAP_NEXT_ROLL_DATE("12"),
        TENDER("3"),
        CALL("2"),
        PUT("1"),
        SWAP_ROLL_DATE("10"),
        LAST_ELIGIBLE_TRADE_DATE("7"),
        INACTIVIATION("6"),
        ACTIVATION("5"),
        SINKING_FUND_CALL("4"),
        SWAP_END_DATE("9"),
        SWAP_START_DATE("8"),
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
