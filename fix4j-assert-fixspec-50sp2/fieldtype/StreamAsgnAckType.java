package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StreamAsgnAckType extends BaseFieldType {
    public static final StreamAsgnAckType INSTANCE = new StreamAsgnAckType();

    private StreamAsgnAckType() {
        super(
            "StreamAsgnAckType",
            1503,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ASSIGNMENT_REJECTED = new Field(StreamAsgnAckType.INSTANCE, Values.ASSIGNMENT_REJECTED.getOrdinal());
        public final Field ASSIGNMENT_ACCEPTED = new Field(StreamAsgnAckType.INSTANCE, Values.ASSIGNMENT_ACCEPTED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ASSIGNMENT_REJECTED("1"),
        ASSIGNMENT_ACCEPTED("0");

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
