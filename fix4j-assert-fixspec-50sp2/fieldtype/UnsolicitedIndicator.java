package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class UnsolicitedIndicator extends BaseFieldType {
    public static final UnsolicitedIndicator INSTANCE = new UnsolicitedIndicator();

    private UnsolicitedIndicator() {
        super(
            "UnsolicitedIndicator",
            325,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MESSAGE_IS_BEING_SENT_AS_A_RESULT_OF_A_PRIOR_REQUEST = new Field(UnsolicitedIndicator.INSTANCE, Values.MESSAGE_IS_BEING_SENT_AS_A_RESULT_OF_A_PRIOR_REQUEST.getOrdinal());
        public final Field MESSAGE_IS_BEING_SENT_UNSOLICITED = new Field(UnsolicitedIndicator.INSTANCE, Values.MESSAGE_IS_BEING_SENT_UNSOLICITED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MESSAGE_IS_BEING_SENT_AS_A_RESULT_OF_A_PRIOR_REQUEST("N"),
        MESSAGE_IS_BEING_SENT_UNSOLICITED("Y");

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
