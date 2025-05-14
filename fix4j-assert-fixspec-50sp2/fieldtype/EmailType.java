package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class EmailType extends BaseFieldType {
    public static final EmailType INSTANCE = new EmailType();

    private EmailType() {
        super(
            "EmailType",
            94,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ADMIN_REPLY = new Field(EmailType.INSTANCE, Values.ADMIN_REPLY.getOrdinal());
        public final Field REPLY = new Field(EmailType.INSTANCE, Values.REPLY.getOrdinal());
        public final Field NEW = new Field(EmailType.INSTANCE, Values.NEW.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ADMIN_REPLY("2"),
        REPLY("1"),
        NEW("0");

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
