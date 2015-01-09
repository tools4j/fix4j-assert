package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class GTBookingInst extends BaseFieldType {
    public static final GTBookingInst INSTANCE = new GTBookingInst();

    private GTBookingInst() {
        super(
            "GTBookingInst",
            427,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ACCUMULATE_UNTIL_VERBALLLY_NOTIFIED_OTHERWISE = new Field(GTBookingInst.INSTANCE, Values.ACCUMULATE_UNTIL_VERBALLLY_NOTIFIED_OTHERWISE.getOrdinal());
        public final Field ACCUMULATE_EXECTUIONS_UNTIL_FORDER_IS_FILLED_OR_EXPIRES = new Field(GTBookingInst.INSTANCE, Values.ACCUMULATE_EXECTUIONS_UNTIL_FORDER_IS_FILLED_OR_EXPIRES.getOrdinal());
        public final Field BOOK_OUT_ALL_TRADES_ON_DAY_OF_EXECUTION = new Field(GTBookingInst.INSTANCE, Values.BOOK_OUT_ALL_TRADES_ON_DAY_OF_EXECUTION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ACCUMULATE_UNTIL_VERBALLLY_NOTIFIED_OTHERWISE("2"),
        ACCUMULATE_EXECTUIONS_UNTIL_FORDER_IS_FILLED_OR_EXPIRES("1"),
        BOOK_OUT_ALL_TRADES_ON_DAY_OF_EXECUTION("0");

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
