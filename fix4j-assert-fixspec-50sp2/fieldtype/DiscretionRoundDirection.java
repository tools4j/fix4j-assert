package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DiscretionRoundDirection extends BaseFieldType {
    public static final DiscretionRoundDirection INSTANCE = new DiscretionRoundDirection();

    private DiscretionRoundDirection() {
        super(
            "DiscretionRoundDirection",
            844,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MORE_PASSIVE__ON_A_BUY_ORDER_ROUND_DOWN_TO_THE_NEAREST_TICK_ON_A = new Field(DiscretionRoundDirection.INSTANCE, Values.MORE_PASSIVE__ON_A_BUY_ORDER_ROUND_DOWN_TO_THE_NEAREST_TICK_ON_A.getOrdinal());
        public final Field MORE_AGGRESSIVE__ON_A_BUY_ORDER_ROUND_THE_PRICE_UP_TO_THE_NEARES = new Field(DiscretionRoundDirection.INSTANCE, Values.MORE_AGGRESSIVE__ON_A_BUY_ORDER_ROUND_THE_PRICE_UP_TO_THE_NEARES.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MORE_PASSIVE__ON_A_BUY_ORDER_ROUND_DOWN_TO_THE_NEAREST_TICK_ON_A("2"),
        MORE_AGGRESSIVE__ON_A_BUY_ORDER_ROUND_THE_PRICE_UP_TO_THE_NEARES("1");

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
