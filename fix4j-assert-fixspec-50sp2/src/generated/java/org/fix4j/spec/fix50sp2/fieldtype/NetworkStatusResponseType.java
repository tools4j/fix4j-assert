package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class NetworkStatusResponseType extends BaseFieldType {
    public static final NetworkStatusResponseType INSTANCE = new NetworkStatusResponseType();

    private NetworkStatusResponseType() {
        super(
            "NetworkStatusResponseType",
            937,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INCREMENTAL_UPDATE = new Field(NetworkStatusResponseType.INSTANCE, Values.INCREMENTAL_UPDATE.getOrdinal());
        public final Field FULL = new Field(NetworkStatusResponseType.INSTANCE, Values.FULL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INCREMENTAL_UPDATE("2"),
        FULL("1");

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
