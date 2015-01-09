package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ForexReq extends BaseFieldType {
    public static final ForexReq INSTANCE = new ForexReq();

    private ForexReq() {
        super(
            "ForexReq",
            121,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DO_NOT_EXECUTE_FOREX_AFTER_SECURITY_TRADE = new Field(ForexReq.INSTANCE, Values.DO_NOT_EXECUTE_FOREX_AFTER_SECURITY_TRADE.getOrdinal());
        public final Field EXECUTE_FOREX_AFTER_SECURITY_TRADE = new Field(ForexReq.INSTANCE, Values.EXECUTE_FOREX_AFTER_SECURITY_TRADE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DO_NOT_EXECUTE_FOREX_AFTER_SECURITY_TRADE("N"),
        EXECUTE_FOREX_AFTER_SECURITY_TRADE("Y");

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
