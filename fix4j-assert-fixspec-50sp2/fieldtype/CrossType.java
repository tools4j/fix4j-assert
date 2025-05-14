package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CrossType extends BaseFieldType {
    public static final CrossType INSTANCE = new CrossType();

    private CrossType() {
        super(
            "CrossType",
            549,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CROSS_ONE_SIDE__CROSS_TRADE_WHICH_IS_PARTIALLY_EXECUTED_WITH_THE = new Field(CrossType.INSTANCE, Values.CROSS_ONE_SIDE__CROSS_TRADE_WHICH_IS_PARTIALLY_EXECUTED_WITH_THE.getOrdinal());
        public final Field CROSS_IOC__CROSS_TRADE_WHICH_IS_EXECUTED_PARTIALLY_AND_THE_REST_ = new Field(CrossType.INSTANCE, Values.CROSS_IOC__CROSS_TRADE_WHICH_IS_EXECUTED_PARTIALLY_AND_THE_REST_.getOrdinal());
        public final Field CROSS_AON__CROSS_TRADE_WHICH_IS_EXECUTED_COMPLETELY_OR_NOT_BOTH_ = new Field(CrossType.INSTANCE, Values.CROSS_AON__CROSS_TRADE_WHICH_IS_EXECUTED_COMPLETELY_OR_NOT_BOTH_.getOrdinal());
        public final Field CROSS_SAME_PRICE__CROSS_TRADE_IS_EXECUTED_WITH_EXISTING_ORDERS_W = new Field(CrossType.INSTANCE, Values.CROSS_SAME_PRICE__CROSS_TRADE_IS_EXECUTED_WITH_EXISTING_ORDERS_W.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CROSS_ONE_SIDE__CROSS_TRADE_WHICH_IS_PARTIALLY_EXECUTED_WITH_THE("3"),
        CROSS_IOC__CROSS_TRADE_WHICH_IS_EXECUTED_PARTIALLY_AND_THE_REST_("2"),
        CROSS_AON__CROSS_TRADE_WHICH_IS_EXECUTED_COMPLETELY_OR_NOT_BOTH_("1"),
        CROSS_SAME_PRICE__CROSS_TRADE_IS_EXECUTED_WITH_EXISTING_ORDERS_W("4");

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
