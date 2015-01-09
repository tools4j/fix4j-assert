package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class WorkingIndicator extends BaseFieldType {
    public static final WorkingIndicator INSTANCE = new WorkingIndicator();

    private WorkingIndicator() {
        super(
            "WorkingIndicator",
            636,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ORDER_HAS_BEEN_ACCEPTED_BUT_NOT_YET_IN_A_WORKING_STATE = new Field(WorkingIndicator.INSTANCE, Values.ORDER_HAS_BEEN_ACCEPTED_BUT_NOT_YET_IN_A_WORKING_STATE.getOrdinal());
        public final Field ORDER_IS_CURRENTLY_BEING_WORKED = new Field(WorkingIndicator.INSTANCE, Values.ORDER_IS_CURRENTLY_BEING_WORKED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ORDER_HAS_BEEN_ACCEPTED_BUT_NOT_YET_IN_A_WORKING_STATE("N"),
        ORDER_IS_CURRENTLY_BEING_WORKED("Y");

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
