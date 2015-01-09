package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ApplQueueAction extends BaseFieldType {
    public static final ApplQueueAction INSTANCE = new ApplQueueAction();

    private ApplQueueAction() {
        super(
            "ApplQueueAction",
            815,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field END_SESSION = new Field(ApplQueueAction.INSTANCE, Values.END_SESSION.getOrdinal());
        public final Field OVERLAY_LAST = new Field(ApplQueueAction.INSTANCE, Values.OVERLAY_LAST.getOrdinal());
        public final Field QUEUE_FLUSHED = new Field(ApplQueueAction.INSTANCE, Values.QUEUE_FLUSHED.getOrdinal());
        public final Field NO_ACTION_TAKEN = new Field(ApplQueueAction.INSTANCE, Values.NO_ACTION_TAKEN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        END_SESSION("3"),
        OVERLAY_LAST("2"),
        QUEUE_FLUSHED("1"),
        NO_ACTION_TAKEN("0");

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
