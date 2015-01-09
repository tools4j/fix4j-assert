package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class UserRequestType extends BaseFieldType {
    public static final UserRequestType INSTANCE = new UserRequestType();

    private UserRequestType() {
        super(
            "UserRequestType",
            924,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CHANGE_PASSWORD_FOR_USER = new Field(UserRequestType.INSTANCE, Values.CHANGE_PASSWORD_FOR_USER.getOrdinal());
        public final Field LOG_OFF_USER = new Field(UserRequestType.INSTANCE, Values.LOG_OFF_USER.getOrdinal());
        public final Field LOG_ON_USER = new Field(UserRequestType.INSTANCE, Values.LOG_ON_USER.getOrdinal());
        public final Field REQUEST_INDIVIDUAL_USER_STATUS = new Field(UserRequestType.INSTANCE, Values.REQUEST_INDIVIDUAL_USER_STATUS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CHANGE_PASSWORD_FOR_USER("3"),
        LOG_OFF_USER("2"),
        LOG_ON_USER("1"),
        REQUEST_INDIVIDUAL_USER_STATUS("4");

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
