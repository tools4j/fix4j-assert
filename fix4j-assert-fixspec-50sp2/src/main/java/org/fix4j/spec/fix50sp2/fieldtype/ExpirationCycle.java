package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ExpirationCycle extends BaseFieldType {
    public static final ExpirationCycle INSTANCE = new ExpirationCycle();

    private ExpirationCycle() {
        super(
            "ExpirationCycle",
            827,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TRADING_ELIGIBILITY_EXPIRATION_SPECIFIED_IN_THE_DATE_AND_TIME_FI = new Field(ExpirationCycle.INSTANCE, Values.TRADING_ELIGIBILITY_EXPIRATION_SPECIFIED_IN_THE_DATE_AND_TIME_FI.getOrdinal());
        public final Field EXPIRE_ON_TRADING_SESSION_OPEN = new Field(ExpirationCycle.INSTANCE, Values.EXPIRE_ON_TRADING_SESSION_OPEN.getOrdinal());
        public final Field EXPIRE_ON_TRADING_SESSION_CLOSE_DEFAULT = new Field(ExpirationCycle.INSTANCE, Values.EXPIRE_ON_TRADING_SESSION_CLOSE_DEFAULT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TRADING_ELIGIBILITY_EXPIRATION_SPECIFIED_IN_THE_DATE_AND_TIME_FI("2"),
        EXPIRE_ON_TRADING_SESSION_OPEN("1"),
        EXPIRE_ON_TRADING_SESSION_CLOSE_DEFAULT("0");

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
