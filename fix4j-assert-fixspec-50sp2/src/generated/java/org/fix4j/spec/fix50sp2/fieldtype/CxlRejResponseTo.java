package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CxlRejResponseTo extends BaseFieldType {
    public static final CxlRejResponseTo INSTANCE = new CxlRejResponseTo();

    private CxlRejResponseTo() {
        super(
            "CxlRejResponseTo",
            434,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ORDER_CANCELREPLACE_REQUEST = new Field(CxlRejResponseTo.INSTANCE, Values.ORDER_CANCELREPLACE_REQUEST.getOrdinal());
        public final Field ORDER_CANCEL_REQUEST = new Field(CxlRejResponseTo.INSTANCE, Values.ORDER_CANCEL_REQUEST.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ORDER_CANCELREPLACE_REQUEST("2"),
        ORDER_CANCEL_REQUEST("1");

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
