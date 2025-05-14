package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SessionStatus extends BaseFieldType {
    public static final SessionStatus INSTANCE = new SessionStatus();

    private SessionStatus() {
        super(
            "SessionStatus",
            1409,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NEW_SESSION_PASSWORD_DOES_NOT_COMPLY_WITH_POLICY = new Field(SessionStatus.INSTANCE, Values.NEW_SESSION_PASSWORD_DOES_NOT_COMPLY_WITH_POLICY.getOrdinal());
        public final Field SESSION_PASSWORD_DUE_TO_EXPIRE = new Field(SessionStatus.INSTANCE, Values.SESSION_PASSWORD_DUE_TO_EXPIRE.getOrdinal());
        public final Field SESSION_PASSWORD_CHANGED = new Field(SessionStatus.INSTANCE, Values.SESSION_PASSWORD_CHANGED.getOrdinal());
        public final Field SESSION_ACTIVE = new Field(SessionStatus.INSTANCE, Values.SESSION_ACTIVE.getOrdinal());
        public final Field LOGONS_ARE_NOT_ALLOWED_AT_THIS_TIME = new Field(SessionStatus.INSTANCE, Values.LOGONS_ARE_NOT_ALLOWED_AT_THIS_TIME.getOrdinal());
        public final Field ACCOUNT_LOCKED = new Field(SessionStatus.INSTANCE, Values.ACCOUNT_LOCKED.getOrdinal());
        public final Field INVALID_USERNAME_OR_PASSWORD = new Field(SessionStatus.INSTANCE, Values.INVALID_USERNAME_OR_PASSWORD.getOrdinal());
        public final Field SESSION_LOGOUT_COMPLETE = new Field(SessionStatus.INSTANCE, Values.SESSION_LOGOUT_COMPLETE.getOrdinal());
        public final Field PASSWORD_EXPIRED = new Field(SessionStatus.INSTANCE, Values.PASSWORD_EXPIRED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NEW_SESSION_PASSWORD_DOES_NOT_COMPLY_WITH_POLICY("3"),
        SESSION_PASSWORD_DUE_TO_EXPIRE("2"),
        SESSION_PASSWORD_CHANGED("1"),
        SESSION_ACTIVE("0"),
        LOGONS_ARE_NOT_ALLOWED_AT_THIS_TIME("7"),
        ACCOUNT_LOCKED("6"),
        INVALID_USERNAME_OR_PASSWORD("5"),
        SESSION_LOGOUT_COMPLETE("4"),
        PASSWORD_EXPIRED("8");

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
