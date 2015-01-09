package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExecTransType extends BaseFieldType {
    public static final ExecTransType INSTANCE = new ExecTransType();

    private ExecTransType() {
        super(
            "ExecTransType",
            20,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field STATUS = new Field(ExecTransType.INSTANCE, Values.STATUS.getOrdinal());
        public final Field CORRECT = new Field(ExecTransType.INSTANCE, Values.CORRECT.getOrdinal());
        public final Field CANCEL = new Field(ExecTransType.INSTANCE, Values.CANCEL.getOrdinal());
        public final Field NEW = new Field(ExecTransType.INSTANCE, Values.NEW.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        STATUS("3"),
        CORRECT("2"),
        CANCEL("1"),
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
