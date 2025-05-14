package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class HandlInst extends BaseFieldType {
    public static final HandlInst INSTANCE = new HandlInst();

    private HandlInst() {
        super(
            "HandlInst",
            21,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MANUAL_ORDER_BEST_EXECUTION = new Field(HandlInst.INSTANCE, Values.MANUAL_ORDER_BEST_EXECUTION.getOrdinal());
        public final Field AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK = new Field(HandlInst.INSTANCE, Values.AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK.getOrdinal());
        public final Field AUTOMATED_EXECUTION_ORDER_PRIVATE_NO_BROKER_INTERVENTION = new Field(HandlInst.INSTANCE, Values.AUTOMATED_EXECUTION_ORDER_PRIVATE_NO_BROKER_INTERVENTION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MANUAL_ORDER_BEST_EXECUTION("3"),
        AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK("2"),
        AUTOMATED_EXECUTION_ORDER_PRIVATE_NO_BROKER_INTERVENTION("1");

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
