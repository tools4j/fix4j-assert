package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StreamAsgnRejReason extends BaseFieldType {
    public static final StreamAsgnRejReason INSTANCE = new StreamAsgnRejReason();

    private StreamAsgnRejReason() {
        super(
            "StreamAsgnRejReason",
            1502,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NO_AVAILABLE_STREAM = new Field(StreamAsgnRejReason.INSTANCE, Values.NO_AVAILABLE_STREAM.getOrdinal());
        public final Field UNKNOWN_OR_INVALID_CURRENCY_PAIR = new Field(StreamAsgnRejReason.INSTANCE, Values.UNKNOWN_OR_INVALID_CURRENCY_PAIR.getOrdinal());
        public final Field EXCEEDS_MAXIMUM_SIZE = new Field(StreamAsgnRejReason.INSTANCE, Values.EXCEEDS_MAXIMUM_SIZE.getOrdinal());
        public final Field UNKNOWN_CLIENT = new Field(StreamAsgnRejReason.INSTANCE, Values.UNKNOWN_CLIENT.getOrdinal());
        public final Field OTHER = new Field(StreamAsgnRejReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NO_AVAILABLE_STREAM("3"),
        UNKNOWN_OR_INVALID_CURRENCY_PAIR("2"),
        EXCEEDS_MAXIMUM_SIZE("1"),
        UNKNOWN_CLIENT("0"),
        OTHER("99");

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
