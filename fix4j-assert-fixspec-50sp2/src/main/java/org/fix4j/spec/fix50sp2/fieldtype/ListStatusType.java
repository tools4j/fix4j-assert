package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ListStatusType extends BaseFieldType {
    public static final ListStatusType INSTANCE = new ListStatusType();

    private ListStatusType() {
        super(
            "ListStatusType",
            429,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TIMED = new Field(ListStatusType.INSTANCE, Values.TIMED.getOrdinal());
        public final Field RESPONSE = new Field(ListStatusType.INSTANCE, Values.RESPONSE.getOrdinal());
        public final Field ACK = new Field(ListStatusType.INSTANCE, Values.ACK.getOrdinal());
        public final Field ALERT = new Field(ListStatusType.INSTANCE, Values.ALERT.getOrdinal());
        public final Field ALL_DONE = new Field(ListStatusType.INSTANCE, Values.ALL_DONE.getOrdinal());
        public final Field EXEC_STARTED = new Field(ListStatusType.INSTANCE, Values.EXEC_STARTED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TIMED("3"),
        RESPONSE("2"),
        ACK("1"),
        ALERT("6"),
        ALL_DONE("5"),
        EXEC_STARTED("4");

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
