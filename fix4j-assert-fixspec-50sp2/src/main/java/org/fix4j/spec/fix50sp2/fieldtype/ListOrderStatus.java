package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ListOrderStatus extends BaseFieldType {
    public static final ListOrderStatus INSTANCE = new ListOrderStatus();

    private ListOrderStatus() {
        super(
            "ListOrderStatus",
            431,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXECUTING = new Field(ListOrderStatus.INSTANCE, Values.EXECUTING.getOrdinal());
        public final Field RECEIVED_FOR_EXECUTION = new Field(ListOrderStatus.INSTANCE, Values.RECEIVED_FOR_EXECUTION.getOrdinal());
        public final Field IN_BIDDING_PROCESS = new Field(ListOrderStatus.INSTANCE, Values.IN_BIDDING_PROCESS.getOrdinal());
        public final Field REJECT = new Field(ListOrderStatus.INSTANCE, Values.REJECT.getOrdinal());
        public final Field ALL_DONE = new Field(ListOrderStatus.INSTANCE, Values.ALL_DONE.getOrdinal());
        public final Field ALERT = new Field(ListOrderStatus.INSTANCE, Values.ALERT.getOrdinal());
        public final Field CANCELLING = new Field(ListOrderStatus.INSTANCE, Values.CANCELLING.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXECUTING("3"),
        RECEIVED_FOR_EXECUTION("2"),
        IN_BIDDING_PROCESS("1"),
        REJECT("7"),
        ALL_DONE("6"),
        ALERT("5"),
        CANCELLING("4");

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
