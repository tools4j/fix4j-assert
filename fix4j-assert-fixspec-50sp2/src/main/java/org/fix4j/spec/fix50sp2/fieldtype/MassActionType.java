package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MassActionType extends BaseFieldType {
    public static final MassActionType INSTANCE = new MassActionType();

    private MassActionType() {
        super(
            "MassActionType",
            1373,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CANCEL_ORDERS = new Field(MassActionType.INSTANCE, Values.CANCEL_ORDERS.getOrdinal());
        public final Field RELEASE_ORDERS_FROM_SUSPENSION = new Field(MassActionType.INSTANCE, Values.RELEASE_ORDERS_FROM_SUSPENSION.getOrdinal());
        public final Field SUSPEND_ORDERS = new Field(MassActionType.INSTANCE, Values.SUSPEND_ORDERS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CANCEL_ORDERS("3"),
        RELEASE_ORDERS_FROM_SUSPENSION("2"),
        SUSPEND_ORDERS("1");

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
