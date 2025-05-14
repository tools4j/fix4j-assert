package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CashMargin extends BaseFieldType {
    public static final CashMargin INSTANCE = new CashMargin();

    private CashMargin() {
        super(
            "CashMargin",
            544,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MARGIN_CLOSE = new Field(CashMargin.INSTANCE, Values.MARGIN_CLOSE.getOrdinal());
        public final Field MARGIN_OPEN = new Field(CashMargin.INSTANCE, Values.MARGIN_OPEN.getOrdinal());
        public final Field CASH = new Field(CashMargin.INSTANCE, Values.CASH.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MARGIN_CLOSE("3"),
        MARGIN_OPEN("2"),
        CASH("1");

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
