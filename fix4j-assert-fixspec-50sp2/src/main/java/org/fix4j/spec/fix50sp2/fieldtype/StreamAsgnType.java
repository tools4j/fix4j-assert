package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StreamAsgnType extends BaseFieldType {
    public static final StreamAsgnType INSTANCE = new StreamAsgnType();

    private StreamAsgnType() {
        super(
            "StreamAsgnType",
            1617,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TERMINATEUNASSIGN = new Field(StreamAsgnType.INSTANCE, Values.TERMINATEUNASSIGN.getOrdinal());
        public final Field REJECTED = new Field(StreamAsgnType.INSTANCE, Values.REJECTED.getOrdinal());
        public final Field ASSIGNMENT = new Field(StreamAsgnType.INSTANCE, Values.ASSIGNMENT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TERMINATEUNASSIGN("3"),
        REJECTED("2"),
        ASSIGNMENT("1");

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
