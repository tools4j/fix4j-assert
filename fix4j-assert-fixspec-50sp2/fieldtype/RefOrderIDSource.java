package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RefOrderIDSource extends BaseFieldType {
    public static final RefOrderIDSource INSTANCE = new RefOrderIDSource();

    private RefOrderIDSource() {
        super(
            "RefOrderIDSource",
            1081,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field QUOTEENTRYID299 = new Field(RefOrderIDSource.INSTANCE, Values.QUOTEENTRYID299.getOrdinal());
        public final Field MDENTRYID278 = new Field(RefOrderIDSource.INSTANCE, Values.MDENTRYID278.getOrdinal());
        public final Field ORDERID37 = new Field(RefOrderIDSource.INSTANCE, Values.ORDERID37.getOrdinal());
        public final Field SECONDARYORDERID198 = new Field(RefOrderIDSource.INSTANCE, Values.SECONDARYORDERID198.getOrdinal());
        public final Field ORIGINAL_ORDER_ID = new Field(RefOrderIDSource.INSTANCE, Values.ORIGINAL_ORDER_ID.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        QUOTEENTRYID299("3"),
        MDENTRYID278("2"),
        ORDERID37("1"),
        SECONDARYORDERID198("0"),
        ORIGINAL_ORDER_ID("4");

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
