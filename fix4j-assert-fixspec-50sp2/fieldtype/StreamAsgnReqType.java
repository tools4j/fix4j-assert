package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StreamAsgnReqType extends BaseFieldType {
    public static final StreamAsgnReqType INSTANCE = new StreamAsgnReqType();

    private StreamAsgnReqType() {
        super(
            "StreamAsgnReqType",
            1498,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field STREAM_ASSIGNMENT_FOR_EXISTING_CUSTOMERS = new Field(StreamAsgnReqType.INSTANCE, Values.STREAM_ASSIGNMENT_FOR_EXISTING_CUSTOMERS.getOrdinal());
        public final Field STREAM_ASSIGNMENT_FOR_NEW_CUSTOMERS = new Field(StreamAsgnReqType.INSTANCE, Values.STREAM_ASSIGNMENT_FOR_NEW_CUSTOMERS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        STREAM_ASSIGNMENT_FOR_EXISTING_CUSTOMERS("2"),
        STREAM_ASSIGNMENT_FOR_NEW_CUSTOMERS("1");

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
