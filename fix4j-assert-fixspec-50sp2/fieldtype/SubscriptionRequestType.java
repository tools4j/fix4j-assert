package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SubscriptionRequestType extends BaseFieldType {
    public static final SubscriptionRequestType INSTANCE = new SubscriptionRequestType();

    private SubscriptionRequestType() {
        super(
            "SubscriptionRequestType",
            263,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DISABLE_PREVIOUS_SNAPSHOT__UPDATE_REQUEST_UNSUBSCRIBE = new Field(SubscriptionRequestType.INSTANCE, Values.DISABLE_PREVIOUS_SNAPSHOT__UPDATE_REQUEST_UNSUBSCRIBE.getOrdinal());
        public final Field SNAPSHOT__UPDATES_SUBSCRIBE = new Field(SubscriptionRequestType.INSTANCE, Values.SNAPSHOT__UPDATES_SUBSCRIBE.getOrdinal());
        public final Field SNAPSHOT = new Field(SubscriptionRequestType.INSTANCE, Values.SNAPSHOT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DISABLE_PREVIOUS_SNAPSHOT__UPDATE_REQUEST_UNSUBSCRIBE("2"),
        SNAPSHOT__UPDATES_SUBSCRIBE("1"),
        SNAPSHOT("0");

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
