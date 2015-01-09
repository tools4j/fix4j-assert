package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlObligTransType extends BaseFieldType {
    public static final SettlObligTransType INSTANCE = new SettlObligTransType();

    private SettlObligTransType() {
        super(
            "SettlObligTransType",
            1162,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field RESTATE = new Field(SettlObligTransType.INSTANCE, Values.RESTATE.getOrdinal());
        public final Field REPLACE = new Field(SettlObligTransType.INSTANCE, Values.REPLACE.getOrdinal());
        public final Field CANCEL = new Field(SettlObligTransType.INSTANCE, Values.CANCEL.getOrdinal());
        public final Field NEW = new Field(SettlObligTransType.INSTANCE, Values.NEW.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        RESTATE("T"),
        REPLACE("R"),
        CANCEL("C"),
        NEW("N");

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
