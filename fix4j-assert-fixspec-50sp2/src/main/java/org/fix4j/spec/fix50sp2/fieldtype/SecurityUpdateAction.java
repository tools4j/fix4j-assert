package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityUpdateAction extends BaseFieldType {
    public static final SecurityUpdateAction INSTANCE = new SecurityUpdateAction();

    private SecurityUpdateAction() {
        super(
            "SecurityUpdateAction",
            980,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DELETE = new Field(SecurityUpdateAction.INSTANCE, Values.DELETE.getOrdinal());
        public final Field ADD = new Field(SecurityUpdateAction.INSTANCE, Values.ADD.getOrdinal());
        public final Field MODIFY = new Field(SecurityUpdateAction.INSTANCE, Values.MODIFY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DELETE("D"),
        ADD("A"),
        MODIFY("M");

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
