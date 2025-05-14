package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocRejCode extends BaseFieldType {
    public static final AllocRejCode INSTANCE = new AllocRejCode();

    private AllocRejCode() {
        super(
            "AllocRejCode",
            88,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field WAREHOUSE_REQUEST_REJECTED = new Field(AllocRejCode.INSTANCE, Values.WAREHOUSE_REQUEST_REJECTED.getOrdinal());
        public final Field MISMATCHED_DATA = new Field(AllocRejCode.INSTANCE, Values.MISMATCHED_DATA.getOrdinal());
        public final Field UNKNOWN_CLORDID = new Field(AllocRejCode.INSTANCE, Values.UNKNOWN_CLORDID.getOrdinal());
        public final Field UNKNOWN_EXECUTING_BROKER_MNEMONIC = new Field(AllocRejCode.INSTANCE, Values.UNKNOWN_EXECUTING_BROKER_MNEMONIC.getOrdinal());
        public final Field INCORRECT_AVERAGEG_PRICE = new Field(AllocRejCode.INSTANCE, Values.INCORRECT_AVERAGEG_PRICE.getOrdinal());
        public final Field INCORRECT_QUANTITY = new Field(AllocRejCode.INSTANCE, Values.INCORRECT_QUANTITY.getOrdinal());
        public final Field UNKNOWN_OR_STALE_EXECID = new Field(AllocRejCode.INSTANCE, Values.UNKNOWN_OR_STALE_EXECID.getOrdinal());
        public final Field UNKNOWN_ACCOUNTS = new Field(AllocRejCode.INSTANCE, Values.UNKNOWN_ACCOUNTS.getOrdinal());
        public final Field OTHER_FURTHER_IN_TEXT_58 = new Field(AllocRejCode.INSTANCE, Values.OTHER_FURTHER_IN_TEXT_58.getOrdinal());
        public final Field UNKNOWN_LISTID_66 = new Field(AllocRejCode.INSTANCE, Values.UNKNOWN_LISTID_66.getOrdinal());
        public final Field UNKNOWN_ORDERID_37 = new Field(AllocRejCode.INSTANCE, Values.UNKNOWN_ORDERID_37.getOrdinal());
        public final Field COMMISSION_DIFFERENCE = new Field(AllocRejCode.INSTANCE, Values.COMMISSION_DIFFERENCE.getOrdinal());
        public final Field CALCULATION_DIFFERENCE = new Field(AllocRejCode.INSTANCE, Values.CALCULATION_DIFFERENCE.getOrdinal());
        public final Field INCORRECT_ALLOCATED_QUANTITY = new Field(AllocRejCode.INSTANCE, Values.INCORRECT_ALLOCATED_QUANTITY.getOrdinal());
        public final Field OTHER = new Field(AllocRejCode.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        WAREHOUSE_REQUEST_REJECTED("13"),
        MISMATCHED_DATA("11"),
        UNKNOWN_CLORDID("12"),
        UNKNOWN_EXECUTING_BROKER_MNEMONIC("3"),
        INCORRECT_AVERAGEG_PRICE("2"),
        INCORRECT_QUANTITY("1"),
        UNKNOWN_OR_STALE_EXECID("10"),
        UNKNOWN_ACCOUNTS("0"),
        OTHER_FURTHER_IN_TEXT_58("7"),
        UNKNOWN_LISTID_66("6"),
        UNKNOWN_ORDERID_37("5"),
        COMMISSION_DIFFERENCE("4"),
        CALCULATION_DIFFERENCE("9"),
        INCORRECT_ALLOCATED_QUANTITY("8"),
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
