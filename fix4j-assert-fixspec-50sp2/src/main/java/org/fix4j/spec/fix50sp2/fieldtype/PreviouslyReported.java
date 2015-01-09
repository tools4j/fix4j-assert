package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PreviouslyReported extends BaseFieldType {
    public static final PreviouslyReported INSTANCE = new PreviouslyReported();

    private PreviouslyReported() {
        super(
            "PreviouslyReported",
            570,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NOT_REPORTED_TO_COUNTERPARTY = new Field(PreviouslyReported.INSTANCE, Values.NOT_REPORTED_TO_COUNTERPARTY.getOrdinal());
        public final Field PERVIOUSLY_REPORTED_TO_COUNTERPARTY = new Field(PreviouslyReported.INSTANCE, Values.PERVIOUSLY_REPORTED_TO_COUNTERPARTY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NOT_REPORTED_TO_COUNTERPARTY("N"),
        PERVIOUSLY_REPORTED_TO_COUNTERPARTY("Y");

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
