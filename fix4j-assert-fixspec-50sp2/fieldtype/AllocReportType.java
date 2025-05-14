package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocReportType extends BaseFieldType {
    public static final AllocReportType INSTANCE = new AllocReportType();

    private AllocReportType() {
        super(
            "AllocReportType",
            794,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SELLSIDE_CALCULATED_USING_PRELIMINARY_INCLUDES_MISCFEES_AND_NETM = new Field(AllocReportType.INSTANCE, Values.SELLSIDE_CALCULATED_USING_PRELIMINARY_INCLUDES_MISCFEES_AND_NETM.getOrdinal());
        public final Field PRELIMINARY_REQUEST_TO_INTERMEDIARY = new Field(AllocReportType.INSTANCE, Values.PRELIMINARY_REQUEST_TO_INTERMEDIARY.getOrdinal());
        public final Field REJECT = new Field(AllocReportType.INSTANCE, Values.REJECT.getOrdinal());
        public final Field WAREHOUSE_RECAP = new Field(AllocReportType.INSTANCE, Values.WAREHOUSE_RECAP.getOrdinal());
        public final Field SELLSIDE_CALCULATED_WITHOUT_PRELIMINARY_SENT_UNSOLICITED_BY_SELL = new Field(AllocReportType.INSTANCE, Values.SELLSIDE_CALCULATED_WITHOUT_PRELIMINARY_SENT_UNSOLICITED_BY_SELL.getOrdinal());
        public final Field ACCEPT = new Field(AllocReportType.INSTANCE, Values.ACCEPT.getOrdinal());
        public final Field REQUEST_TO_INTERMEDIARY = new Field(AllocReportType.INSTANCE, Values.REQUEST_TO_INTERMEDIARY.getOrdinal());
        public final Field REVERSE_PENDING = new Field(AllocReportType.INSTANCE, Values.REVERSE_PENDING.getOrdinal());
        public final Field ACCEPT_PENDING = new Field(AllocReportType.INSTANCE, Values.ACCEPT_PENDING.getOrdinal());
        public final Field COMPLETE = new Field(AllocReportType.INSTANCE, Values.COMPLETE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SELLSIDE_CALCULATED_USING_PRELIMINARY_INCLUDES_MISCFEES_AND_NETM("3"),
        PRELIMINARY_REQUEST_TO_INTERMEDIARY("2"),
        REJECT("10"),
        WAREHOUSE_RECAP("5"),
        SELLSIDE_CALCULATED_WITHOUT_PRELIMINARY_SENT_UNSOLICITED_BY_SELL("4"),
        ACCEPT("9"),
        REQUEST_TO_INTERMEDIARY("8"),
        REVERSE_PENDING("14"),
        ACCEPT_PENDING("11"),
        COMPLETE("12");

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
