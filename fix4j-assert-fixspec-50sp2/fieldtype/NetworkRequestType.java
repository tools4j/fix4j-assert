package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class NetworkRequestType extends BaseFieldType {
    public static final NetworkRequestType INSTANCE = new NetworkRequestType();

    private NetworkRequestType() {
        super(
            "NetworkRequestType",
            935,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SUBSCRIBE = new Field(NetworkRequestType.INSTANCE, Values.SUBSCRIBE.getOrdinal());
        public final Field SNAPSHOT = new Field(NetworkRequestType.INSTANCE, Values.SNAPSHOT.getOrdinal());
        public final Field STOP_SUBSCRIBING = new Field(NetworkRequestType.INSTANCE, Values.STOP_SUBSCRIBING.getOrdinal());
        public final Field LEVEL_OF_DETAIL_THEN_NOCOMPIDS_BECOMES_REQUIRED = new Field(NetworkRequestType.INSTANCE, Values.LEVEL_OF_DETAIL_THEN_NOCOMPIDS_BECOMES_REQUIRED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SUBSCRIBE("2"),
        SNAPSHOT("1"),
        STOP_SUBSCRIBING("4"),
        LEVEL_OF_DETAIL_THEN_NOCOMPIDS_BECOMES_REQUIRED("8");

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
