package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocStatus extends BaseFieldType {
    public static final AllocStatus INSTANCE = new AllocStatus();

    private AllocStatus() {
        super(
            "AllocStatus",
            87,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field RECEIVED_RECEIVED_NOT_YET_PROCESSED = new Field(AllocStatus.INSTANCE, Values.RECEIVED_RECEIVED_NOT_YET_PROCESSED.getOrdinal());
        public final Field ACCOUNT_LEVEL_REJECT = new Field(AllocStatus.INSTANCE, Values.ACCOUNT_LEVEL_REJECT.getOrdinal());
        public final Field BLOCK_LEVEL_REJECT = new Field(AllocStatus.INSTANCE, Values.BLOCK_LEVEL_REJECT.getOrdinal());
        public final Field ACCEPTED_SUCCESSFULLY_PROCESSED = new Field(AllocStatus.INSTANCE, Values.ACCEPTED_SUCCESSFULLY_PROCESSED.getOrdinal());
        public final Field REVERSED = new Field(AllocStatus.INSTANCE, Values.REVERSED.getOrdinal());
        public final Field ALLOCATION_PENDING = new Field(AllocStatus.INSTANCE, Values.ALLOCATION_PENDING.getOrdinal());
        public final Field REJECTED_BY_INTERMEDIARY = new Field(AllocStatus.INSTANCE, Values.REJECTED_BY_INTERMEDIARY.getOrdinal());
        public final Field INCOMPLETE = new Field(AllocStatus.INSTANCE, Values.INCOMPLETE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        RECEIVED_RECEIVED_NOT_YET_PROCESSED("3"),
        ACCOUNT_LEVEL_REJECT("2"),
        BLOCK_LEVEL_REJECT("1"),
        ACCEPTED_SUCCESSFULLY_PROCESSED("0"),
        REVERSED("7"),
        ALLOCATION_PENDING("6"),
        REJECTED_BY_INTERMEDIARY("5"),
        INCOMPLETE("4");

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
