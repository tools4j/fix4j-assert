package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MDUpdateAction extends BaseFieldType {
    public static final MDUpdateAction INSTANCE = new MDUpdateAction();

    private MDUpdateAction() {
        super(
            "MDUpdateAction",
            279,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DELETE_THRU = new Field(MDUpdateAction.INSTANCE, Values.DELETE_THRU.getOrdinal());
        public final Field DELETE = new Field(MDUpdateAction.INSTANCE, Values.DELETE.getOrdinal());
        public final Field CHANGE = new Field(MDUpdateAction.INSTANCE, Values.CHANGE.getOrdinal());
        public final Field NEW = new Field(MDUpdateAction.INSTANCE, Values.NEW.getOrdinal());
        public final Field OVERLAY = new Field(MDUpdateAction.INSTANCE, Values.OVERLAY.getOrdinal());
        public final Field DELETE_FROM = new Field(MDUpdateAction.INSTANCE, Values.DELETE_FROM.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DELETE_THRU("3"),
        DELETE("2"),
        CHANGE("1"),
        NEW("0"),
        OVERLAY("5"),
        DELETE_FROM("4");

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
