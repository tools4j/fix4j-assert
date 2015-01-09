package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlObligMode extends BaseFieldType {
    public static final SettlObligMode INSTANCE = new SettlObligMode();

    private SettlObligMode() {
        super(
            "SettlObligMode",
            1159,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FINAL = new Field(SettlObligMode.INSTANCE, Values.FINAL.getOrdinal());
        public final Field PRELIMINARY = new Field(SettlObligMode.INSTANCE, Values.PRELIMINARY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FINAL("2"),
        PRELIMINARY("1");

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
