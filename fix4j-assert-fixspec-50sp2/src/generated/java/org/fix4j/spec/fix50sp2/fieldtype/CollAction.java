package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CollAction extends BaseFieldType {
    public static final CollAction INSTANCE = new CollAction();

    private CollAction() {
        super(
            "CollAction",
            944,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REMOVE = new Field(CollAction.INSTANCE, Values.REMOVE.getOrdinal());
        public final Field ADD = new Field(CollAction.INSTANCE, Values.ADD.getOrdinal());
        public final Field RETAIN = new Field(CollAction.INSTANCE, Values.RETAIN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REMOVE("2"),
        ADD("1"),
        RETAIN("0");

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
