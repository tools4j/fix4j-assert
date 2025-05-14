package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ProgRptReqs extends BaseFieldType {
    public static final ProgRptReqs INSTANCE = new ProgRptReqs();

    private ProgRptReqs() {
        super(
            "ProgRptReqs",
            414,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REALTIME_EXECUTION_REPORTS_TO_BE_DISCOURAGE = new Field(ProgRptReqs.INSTANCE, Values.REALTIME_EXECUTION_REPORTS_TO_BE_DISCOURAGE.getOrdinal());
        public final Field SELLSIDE_PERIODICALLY_SENDS_STATUS_USING_LIST_STATUS_PERIOD_OPTI = new Field(ProgRptReqs.INSTANCE, Values.SELLSIDE_PERIODICALLY_SENDS_STATUS_USING_LIST_STATUS_PERIOD_OPTI.getOrdinal());
        public final Field BUYSIDE_EXPLICITLY_REQUESTS_STATUS_USING_STATUE_REQUEST_DEFAULT_ = new Field(ProgRptReqs.INSTANCE, Values.BUYSIDE_EXPLICITLY_REQUESTS_STATUS_USING_STATUE_REQUEST_DEFAULT_.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REALTIME_EXECUTION_REPORTS_TO_BE_DISCOURAGE("3"),
        SELLSIDE_PERIODICALLY_SENDS_STATUS_USING_LIST_STATUS_PERIOD_OPTI("2"),
        BUYSIDE_EXPLICITLY_REQUESTS_STATUS_USING_STATUE_REQUEST_DEFAULT_("1");

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
