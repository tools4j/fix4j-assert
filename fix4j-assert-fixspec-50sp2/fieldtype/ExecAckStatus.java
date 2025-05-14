package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExecAckStatus extends BaseFieldType {
    public static final ExecAckStatus INSTANCE = new ExecAckStatus();

    private ExecAckStatus() {
        super(
            "ExecAckStatus",
            1036,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DONT_KNOW__REJECTED = new Field(ExecAckStatus.INSTANCE, Values.DONT_KNOW__REJECTED.getOrdinal());
        public final Field ACCEPTED = new Field(ExecAckStatus.INSTANCE, Values.ACCEPTED.getOrdinal());
        public final Field RECEIVED_NOT_YET_PROCESSED = new Field(ExecAckStatus.INSTANCE, Values.RECEIVED_NOT_YET_PROCESSED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DONT_KNOW__REJECTED("2"),
        ACCEPTED("1"),
        RECEIVED_NOT_YET_PROCESSED("0");

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
