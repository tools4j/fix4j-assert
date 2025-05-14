package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DlvyInstType extends BaseFieldType {
    public static final DlvyInstType INSTANCE = new DlvyInstType();

    private DlvyInstType() {
        super(
            "DlvyInstType",
            787,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SECURITIES = new Field(DlvyInstType.INSTANCE, Values.SECURITIES.getOrdinal());
        public final Field CASH = new Field(DlvyInstType.INSTANCE, Values.CASH.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SECURITIES("S"),
        CASH("C");

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
