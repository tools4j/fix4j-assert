package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ReportToExch extends BaseFieldType {
    public static final ReportToExch INSTANCE = new ReportToExch();

    private ReportToExch() {
        super(
            "ReportToExch",
            113,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INDICATES_THE_PARTY_SENDING_MESSAGE_WILL_REPORT_TRADE = new Field(ReportToExch.INSTANCE, Values.INDICATES_THE_PARTY_SENDING_MESSAGE_WILL_REPORT_TRADE.getOrdinal());
        public final Field INDICATES_THE_PARTY_RECEIVING_MESSAGE_MUST_REPORT_TRADE = new Field(ReportToExch.INSTANCE, Values.INDICATES_THE_PARTY_RECEIVING_MESSAGE_MUST_REPORT_TRADE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INDICATES_THE_PARTY_SENDING_MESSAGE_WILL_REPORT_TRADE("N"),
        INDICATES_THE_PARTY_RECEIVING_MESSAGE_MUST_REPORT_TRADE("Y");

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
