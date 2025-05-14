package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class NotifyBrokerOfCredit extends BaseFieldType {
    public static final NotifyBrokerOfCredit INSTANCE = new NotifyBrokerOfCredit();

    private NotifyBrokerOfCredit() {
        super(
            "NotifyBrokerOfCredit",
            208,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DETAILS_SHOULT_NOT_BE_COMMUNICATED = new Field(NotifyBrokerOfCredit.INSTANCE, Values.DETAILS_SHOULT_NOT_BE_COMMUNICATED.getOrdinal());
        public final Field DETAILS_SHOULD_BE_COMMUNICATED = new Field(NotifyBrokerOfCredit.INSTANCE, Values.DETAILS_SHOULD_BE_COMMUNICATED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DETAILS_SHOULT_NOT_BE_COMMUNICATED("N"),
        DETAILS_SHOULD_BE_COMMUNICATED("Y");

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
