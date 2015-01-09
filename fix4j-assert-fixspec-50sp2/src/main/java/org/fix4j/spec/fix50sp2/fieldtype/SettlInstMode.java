package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlInstMode extends BaseFieldType {
    public static final SettlInstMode INSTANCE = new SettlInstMode();

    private SettlInstMode() {
        super(
            "SettlInstMode",
            160,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SPECIFIC_ALLOCATION_ACCOUNT_STANDING_REPLACED = new Field(SettlInstMode.INSTANCE, Values.SPECIFIC_ALLOCATION_ACCOUNT_STANDING_REPLACED.getOrdinal());
        public final Field SPECIFIC_ALLOCATION_ACCOUNT_OVERRIDING_REPLACED = new Field(SettlInstMode.INSTANCE, Values.SPECIFIC_ALLOCATION_ACCOUNT_OVERRIDING_REPLACED.getOrdinal());
        public final Field STANDING_INSTRUCTIONS_PROVIDED = new Field(SettlInstMode.INSTANCE, Values.STANDING_INSTRUCTIONS_PROVIDED.getOrdinal());
        public final Field DEFAULT_REPLACED = new Field(SettlInstMode.INSTANCE, Values.DEFAULT_REPLACED.getOrdinal());
        public final Field REQUEST_REJECT = new Field(SettlInstMode.INSTANCE, Values.REQUEST_REJECT.getOrdinal());
        public final Field SPECIFIC_ORDER_FOR_A_SINGLE_ACCOUNT_FOR_CIV = new Field(SettlInstMode.INSTANCE, Values.SPECIFIC_ORDER_FOR_A_SINGLE_ACCOUNT_FOR_CIV.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SPECIFIC_ALLOCATION_ACCOUNT_STANDING_REPLACED("3"),
        SPECIFIC_ALLOCATION_ACCOUNT_OVERRIDING_REPLACED("2"),
        STANDING_INSTRUCTIONS_PROVIDED("1"),
        DEFAULT_REPLACED("0"),
        REQUEST_REJECT("5"),
        SPECIFIC_ORDER_FOR_A_SINGLE_ACCOUNT_FOR_CIV("4");

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
