package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlInstReqRejCode extends BaseFieldType {
    public static final SettlInstReqRejCode INSTANCE = new SettlInstReqRejCode();

    private SettlInstReqRejCode() {
        super(
            "SettlInstReqRejCode",
            792,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NO_MATCHING_SETTLEMENT_INSTRUCTIONS_FOUND = new Field(SettlInstReqRejCode.INSTANCE, Values.NO_MATCHING_SETTLEMENT_INSTRUCTIONS_FOUND.getOrdinal());
        public final Field UNKNOWN_ACCOUNT = new Field(SettlInstReqRejCode.INSTANCE, Values.UNKNOWN_ACCOUNT.getOrdinal());
        public final Field UNABLE_TO_PROCESS_REQUEST = new Field(SettlInstReqRejCode.INSTANCE, Values.UNABLE_TO_PROCESS_REQUEST.getOrdinal());
        public final Field OTHER = new Field(SettlInstReqRejCode.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NO_MATCHING_SETTLEMENT_INSTRUCTIONS_FOUND("2"),
        UNKNOWN_ACCOUNT("1"),
        UNABLE_TO_PROCESS_REQUEST("0"),
        OTHER("99");

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
