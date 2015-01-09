package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MoneyLaunderingStatus extends BaseFieldType {
    public static final MoneyLaunderingStatus INSTANCE = new MoneyLaunderingStatus();

    private MoneyLaunderingStatus() {
        super(
            "MoneyLaunderingStatus",
            481,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXEMPT__AUTHORISED_CREDIT_OR_FINANCIAL_INSTITUTION = new Field(MoneyLaunderingStatus.INSTANCE, Values.EXEMPT__AUTHORISED_CREDIT_OR_FINANCIAL_INSTITUTION.getOrdinal());
        public final Field EXEMPT__CLIENT_MONEY_TYPE_EXEMPTION = new Field(MoneyLaunderingStatus.INSTANCE, Values.EXEMPT__CLIENT_MONEY_TYPE_EXEMPTION.getOrdinal());
        public final Field EXEMPT__BELOW_THE_LIMIT = new Field(MoneyLaunderingStatus.INSTANCE, Values.EXEMPT__BELOW_THE_LIMIT.getOrdinal());
        public final Field NOT_CHECKED = new Field(MoneyLaunderingStatus.INSTANCE, Values.NOT_CHECKED.getOrdinal());
        public final Field PASSED = new Field(MoneyLaunderingStatus.INSTANCE, Values.PASSED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXEMPT__AUTHORISED_CREDIT_OR_FINANCIAL_INSTITUTION("3"),
        EXEMPT__CLIENT_MONEY_TYPE_EXEMPTION("2"),
        EXEMPT__BELOW_THE_LIMIT("1"),
        NOT_CHECKED("N"),
        PASSED("Y");

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
