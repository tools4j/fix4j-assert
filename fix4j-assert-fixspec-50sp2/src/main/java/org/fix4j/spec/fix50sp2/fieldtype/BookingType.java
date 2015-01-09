package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class BookingType extends BaseFieldType {
    public static final BookingType INSTANCE = new BookingType();

    private BookingType() {
        super(
            "BookingType",
            775,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TOTAL_RETURN_SWAP = new Field(BookingType.INSTANCE, Values.TOTAL_RETURN_SWAP.getOrdinal());
        public final Field CFD_CONTRACT_FOR_DIFFERENCE = new Field(BookingType.INSTANCE, Values.CFD_CONTRACT_FOR_DIFFERENCE.getOrdinal());
        public final Field REGULAR_BOOKING = new Field(BookingType.INSTANCE, Values.REGULAR_BOOKING.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TOTAL_RETURN_SWAP("2"),
        CFD_CONTRACT_FOR_DIFFERENCE("1"),
        REGULAR_BOOKING("0");

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
