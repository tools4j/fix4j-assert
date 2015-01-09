package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class LegalConfirm extends BaseFieldType {
    public static final LegalConfirm INSTANCE = new LegalConfirm();

    private LegalConfirm() {
        super(
            "LegalConfirm",
            650,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DOES_NOT_CONSITUTE_A_LEGAL_CONFIRM = new Field(LegalConfirm.INSTANCE, Values.DOES_NOT_CONSITUTE_A_LEGAL_CONFIRM.getOrdinal());
        public final Field LEGAL_CONFIRM = new Field(LegalConfirm.INSTANCE, Values.LEGAL_CONFIRM.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DOES_NOT_CONSITUTE_A_LEGAL_CONFIRM("N"),
        LEGAL_CONFIRM("Y");

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
