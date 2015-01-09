package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class UserStatus extends BaseFieldType {
    public static final UserStatus INSTANCE = new UserStatus();

    private UserStatus() {
        super(
            "UserStatus",
            926,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field USER_NOT_RECOGNISED = new Field(UserStatus.INSTANCE, Values.USER_NOT_RECOGNISED.getOrdinal());
        public final Field NOT_LOGGED_IN = new Field(UserStatus.INSTANCE, Values.NOT_LOGGED_IN.getOrdinal());
        public final Field LOGGED_IN = new Field(UserStatus.INSTANCE, Values.LOGGED_IN.getOrdinal());
        public final Field FORCED_USER_LOGOUT_BY_EXCHANGE = new Field(UserStatus.INSTANCE, Values.FORCED_USER_LOGOUT_BY_EXCHANGE.getOrdinal());
        public final Field OTHER = new Field(UserStatus.INSTANCE, Values.OTHER.getOrdinal());
        public final Field PASSWORD_CHANGED = new Field(UserStatus.INSTANCE, Values.PASSWORD_CHANGED.getOrdinal());
        public final Field PASSWORD_INCORRECT = new Field(UserStatus.INSTANCE, Values.PASSWORD_INCORRECT.getOrdinal());
        public final Field SESSION_SHUTDOWN_WARNING = new Field(UserStatus.INSTANCE, Values.SESSION_SHUTDOWN_WARNING.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        USER_NOT_RECOGNISED("3"),
        NOT_LOGGED_IN("2"),
        LOGGED_IN("1"),
        FORCED_USER_LOGOUT_BY_EXCHANGE("7"),
        OTHER("6"),
        PASSWORD_CHANGED("5"),
        PASSWORD_INCORRECT("4"),
        SESSION_SHUTDOWN_WARNING("8");

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
