package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class BookingUnit extends BaseFieldType {
    public static final BookingUnit INSTANCE = new BookingUnit();

    private BookingUnit() {
        super(
            "BookingUnit",
            590,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field AGGREGATE_EXECUTIONS_FOR_THIS_SYMBOL_SIDE_AND_SETTLEMENT_DATE = new Field(BookingUnit.INSTANCE, Values.AGGREGATE_EXECUTIONS_FOR_THIS_SYMBOL_SIDE_AND_SETTLEMENT_DATE.getOrdinal());
        public final Field AGGREGATE_PARTIAL_EXECUTIONS_ON_THIS_ORDER_AND_BOOK_ONE_TRADE_PE = new Field(BookingUnit.INSTANCE, Values.AGGREGATE_PARTIAL_EXECUTIONS_ON_THIS_ORDER_AND_BOOK_ONE_TRADE_PE.getOrdinal());
        public final Field EACH_PARTIAL_EXECUTION_IS_A_BOOKABLE_UNIT = new Field(BookingUnit.INSTANCE, Values.EACH_PARTIAL_EXECUTION_IS_A_BOOKABLE_UNIT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        AGGREGATE_EXECUTIONS_FOR_THIS_SYMBOL_SIDE_AND_SETTLEMENT_DATE("2"),
        AGGREGATE_PARTIAL_EXECUTIONS_ON_THIS_ORDER_AND_BOOK_ONE_TRADE_PE("1"),
        EACH_PARTIAL_EXECUTION_IS_A_BOOKABLE_UNIT("0");

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
