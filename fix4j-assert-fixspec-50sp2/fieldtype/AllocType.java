package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocType extends BaseFieldType {
    public static final AllocType INSTANCE = new AllocType();

    private AllocType() {
        super(
            "AllocType",
            626,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field COMPLETE_GROUP = new Field(AllocType.INSTANCE, Values.COMPLETE_GROUP.getOrdinal());
        public final Field REVERSAL_PENDING = new Field(AllocType.INSTANCE, Values.REVERSAL_PENDING.getOrdinal());
        public final Field ACCEPT_PENDING = new Field(AllocType.INSTANCE, Values.ACCEPT_PENDING.getOrdinal());
        public final Field INCOMPLETE_GROUP = new Field(AllocType.INSTANCE, Values.INCOMPLETE_GROUP.getOrdinal());
        public final Field SELLSIDE_CALCULATED_USING_PRELIMINARY_INCLUDES_MISCFEES_AND_NETM = new Field(AllocType.INSTANCE, Values.SELLSIDE_CALCULATED_USING_PRELIMINARY_INCLUDES_MISCFEES_AND_NETM.getOrdinal());
        public final Field PRELIMINARY_WITHOUT_MISCFEES_AND_NETMONEY = new Field(AllocType.INSTANCE, Values.PRELIMINARY_WITHOUT_MISCFEES_AND_NETMONEY.getOrdinal());
        public final Field CALCULATED_INCLUDES_MISCFEES_AND_NETMONEY = new Field(AllocType.INSTANCE, Values.CALCULATED_INCLUDES_MISCFEES_AND_NETMONEY.getOrdinal());
        public final Field REJECT = new Field(AllocType.INSTANCE, Values.REJECT.getOrdinal());
        public final Field WAREHOUSE_INSTRUCTION = new Field(AllocType.INSTANCE, Values.WAREHOUSE_INSTRUCTION.getOrdinal());
        public final Field BUYSIDE_READYTOBOOK__COMBINED_SET_OF_ORDERS_REPLACED = new Field(AllocType.INSTANCE, Values.BUYSIDE_READYTOBOOK__COMBINED_SET_OF_ORDERS_REPLACED.getOrdinal());
        public final Field READYTOBOOK__SINGLE_ORDER = new Field(AllocType.INSTANCE, Values.READYTOBOOK__SINGLE_ORDER.getOrdinal());
        public final Field SELLSIDE_CALCULATED_WITHOUT_PRELIMINARY_SENT_UNSOLICITED_BY_SELL = new Field(AllocType.INSTANCE, Values.SELLSIDE_CALCULATED_WITHOUT_PRELIMINARY_SENT_UNSOLICITED_BY_SELL.getOrdinal());
        public final Field ACCEPT = new Field(AllocType.INSTANCE, Values.ACCEPT.getOrdinal());
        public final Field REQUEST_TO_INTERMEDIARY = new Field(AllocType.INSTANCE, Values.REQUEST_TO_INTERMEDIARY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        COMPLETE_GROUP("13"),
        REVERSAL_PENDING("14"),
        ACCEPT_PENDING("11"),
        INCOMPLETE_GROUP("12"),
        SELLSIDE_CALCULATED_USING_PRELIMINARY_INCLUDES_MISCFEES_AND_NETM("3"),
        PRELIMINARY_WITHOUT_MISCFEES_AND_NETMONEY("2"),
        CALCULATED_INCLUDES_MISCFEES_AND_NETMONEY("1"),
        REJECT("10"),
        WAREHOUSE_INSTRUCTION("7"),
        BUYSIDE_READYTOBOOK__COMBINED_SET_OF_ORDERS_REPLACED("6"),
        READYTOBOOK__SINGLE_ORDER("5"),
        SELLSIDE_CALCULATED_WITHOUT_PRELIMINARY_SENT_UNSOLICITED_BY_SELL("4"),
        ACCEPT("9"),
        REQUEST_TO_INTERMEDIARY("8");

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
