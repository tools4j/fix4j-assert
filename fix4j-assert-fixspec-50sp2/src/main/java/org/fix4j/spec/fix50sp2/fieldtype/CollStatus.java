package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CollStatus extends BaseFieldType {
    public static final CollStatus INSTANCE = new CollStatus();

    private CollStatus() {
        super(
            "CollStatus",
            910,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ASSIGNED_ACCEPTED = new Field(CollStatus.INSTANCE, Values.ASSIGNED_ACCEPTED.getOrdinal());
        public final Field ASSIGNMENT_PROPOSED = new Field(CollStatus.INSTANCE, Values.ASSIGNMENT_PROPOSED.getOrdinal());
        public final Field PARTIALLY_ASSIGNED = new Field(CollStatus.INSTANCE, Values.PARTIALLY_ASSIGNED.getOrdinal());
        public final Field UNASSIGNED = new Field(CollStatus.INSTANCE, Values.UNASSIGNED.getOrdinal());
        public final Field CHALLENGED = new Field(CollStatus.INSTANCE, Values.CHALLENGED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ASSIGNED_ACCEPTED("3"),
        ASSIGNMENT_PROPOSED("2"),
        PARTIALLY_ASSIGNED("1"),
        UNASSIGNED("0"),
        CHALLENGED("4");

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
