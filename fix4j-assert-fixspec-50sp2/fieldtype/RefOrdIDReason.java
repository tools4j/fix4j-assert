package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RefOrdIDReason extends BaseFieldType {
    public static final RefOrdIDReason INSTANCE = new RefOrdIDReason();

    private RefOrdIDReason() {
        super(
            "RefOrdIDReason",
            1431,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ORDER_CHANGED = new Field(RefOrdIDReason.INSTANCE, Values.ORDER_CHANGED.getOrdinal());
        public final Field PARTIAL_FILL_REMAINING = new Field(RefOrdIDReason.INSTANCE, Values.PARTIAL_FILL_REMAINING.getOrdinal());
        public final Field GTC_FROM_PREVIOUS_DAY = new Field(RefOrdIDReason.INSTANCE, Values.GTC_FROM_PREVIOUS_DAY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ORDER_CHANGED("2"),
        PARTIAL_FILL_REMAINING("1"),
        GTC_FROM_PREVIOUS_DAY("0");

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
