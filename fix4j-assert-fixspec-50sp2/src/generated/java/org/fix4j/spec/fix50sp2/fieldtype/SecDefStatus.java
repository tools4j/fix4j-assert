package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecDefStatus extends BaseFieldType {
    public static final SecDefStatus INSTANCE = new SecDefStatus();

    private SecDefStatus() {
        super(
            "SecDefStatus",
            653,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field UNAUTHORIZED_REQUEST = new Field(SecDefStatus.INSTANCE, Values.UNAUTHORIZED_REQUEST.getOrdinal());
        public final Field REJECTED = new Field(SecDefStatus.INSTANCE, Values.REJECTED.getOrdinal());
        public final Field APPROVED_ACCEPTED = new Field(SecDefStatus.INSTANCE, Values.APPROVED_ACCEPTED.getOrdinal());
        public final Field PENDING_APPROVAL = new Field(SecDefStatus.INSTANCE, Values.PENDING_APPROVAL.getOrdinal());
        public final Field INVALID_DEFINITION_REQUEST = new Field(SecDefStatus.INSTANCE, Values.INVALID_DEFINITION_REQUEST.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        UNAUTHORIZED_REQUEST("3"),
        REJECTED("2"),
        APPROVED_ACCEPTED("1"),
        PENDING_APPROVAL("0"),
        INVALID_DEFINITION_REQUEST("4");

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
