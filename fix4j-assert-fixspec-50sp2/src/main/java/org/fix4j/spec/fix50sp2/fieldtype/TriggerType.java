package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TriggerType extends BaseFieldType {
    public static final TriggerType INSTANCE = new TriggerType();

    private TriggerType() {
        super(
            "TriggerType",
            1100,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NEXT_AUCTION = new Field(TriggerType.INSTANCE, Values.NEXT_AUCTION.getOrdinal());
        public final Field SPECIFIED_TRADING_SESSION = new Field(TriggerType.INSTANCE, Values.SPECIFIED_TRADING_SESSION.getOrdinal());
        public final Field PARTIAL_EXECUTION = new Field(TriggerType.INSTANCE, Values.PARTIAL_EXECUTION.getOrdinal());
        public final Field PRICE_MOVEMENT = new Field(TriggerType.INSTANCE, Values.PRICE_MOVEMENT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NEXT_AUCTION("3"),
        SPECIFIED_TRADING_SESSION("2"),
        PARTIAL_EXECUTION("1"),
        PRICE_MOVEMENT("4");

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
