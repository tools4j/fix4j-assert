package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ListExecInstType extends BaseFieldType {
    public static final ListExecInstType INSTANCE = new ListExecInstType();

    private ListExecInstType() {
        super(
            "ListExecInstType",
            433,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXCHANGESWITCH_CIV_ORDER__SELL_DRIVEN = new Field(ListExecInstType.INSTANCE, Values.EXCHANGESWITCH_CIV_ORDER__SELL_DRIVEN.getOrdinal());
        public final Field WAIT_FOR_EXECUT_INSTRUCTION_IE_A_LIST_EXECUT_MESSAGE_OR_PHONE_CA = new Field(ListExecInstType.INSTANCE, Values.WAIT_FOR_EXECUT_INSTRUCTION_IE_A_LIST_EXECUT_MESSAGE_OR_PHONE_CA.getOrdinal());
        public final Field IMMEDIATE = new Field(ListExecInstType.INSTANCE, Values.IMMEDIATE.getOrdinal());
        public final Field EXCHANGESWITCH_CIV_ORDER__BUY_DRIVEN_CASH_WITHDRAW_IE_ADDITIONAL = new Field(ListExecInstType.INSTANCE, Values.EXCHANGESWITCH_CIV_ORDER__BUY_DRIVEN_CASH_WITHDRAW_IE_ADDITIONAL.getOrdinal());
        public final Field EXCHANGESWITCH_CIV_ORDER__BUY_DRIVEN_CASH_TOPUP_IE_ADDITIONAL_CA = new Field(ListExecInstType.INSTANCE, Values.EXCHANGESWITCH_CIV_ORDER__BUY_DRIVEN_CASH_TOPUP_IE_ADDITIONAL_CA.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXCHANGESWITCH_CIV_ORDER__SELL_DRIVEN("3"),
        WAIT_FOR_EXECUT_INSTRUCTION_IE_A_LIST_EXECUT_MESSAGE_OR_PHONE_CA("2"),
        IMMEDIATE("1"),
        EXCHANGESWITCH_CIV_ORDER__BUY_DRIVEN_CASH_WITHDRAW_IE_ADDITIONAL("5"),
        EXCHANGESWITCH_CIV_ORDER__BUY_DRIVEN_CASH_TOPUP_IE_ADDITIONAL_CA("4");

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
