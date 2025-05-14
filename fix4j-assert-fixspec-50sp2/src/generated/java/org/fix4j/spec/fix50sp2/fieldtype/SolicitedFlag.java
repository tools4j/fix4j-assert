package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SolicitedFlag extends BaseFieldType {
    public static final SolicitedFlag INSTANCE = new SolicitedFlag();

    private SolicitedFlag() {
        super(
            "SolicitedFlag",
            377,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field WAS_NOT_SOLICITED = new Field(SolicitedFlag.INSTANCE, Values.WAS_NOT_SOLICITED.getOrdinal());
        public final Field WAS_SOLICITED = new Field(SolicitedFlag.INSTANCE, Values.WAS_SOLICITED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        WAS_NOT_SOLICITED("N"),
        WAS_SOLICITED("Y");

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
