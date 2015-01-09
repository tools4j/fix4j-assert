package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DistribPaymentMethod extends BaseFieldType {
    public static final DistribPaymentMethod INSTANCE = new DistribPaymentMethod();

    private DistribPaymentMethod() {
        super(
            "DistribPaymentMethod",
            477,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EUROCLEAR = new Field(DistribPaymentMethod.INSTANCE, Values.EUROCLEAR.getOrdinal());
        public final Field NSCC = new Field(DistribPaymentMethod.INSTANCE, Values.NSCC.getOrdinal());
        public final Field BPAY = new Field(DistribPaymentMethod.INSTANCE, Values.BPAY.getOrdinal());
        public final Field CREST = new Field(DistribPaymentMethod.INSTANCE, Values.CREST.getOrdinal());
        public final Field FED_WIRE = new Field(DistribPaymentMethod.INSTANCE, Values.FED_WIRE.getOrdinal());
        public final Field TELEGRAPHIC_TRANSFER = new Field(DistribPaymentMethod.INSTANCE, Values.TELEGRAPHIC_TRANSFER.getOrdinal());
        public final Field CHEQUE = new Field(DistribPaymentMethod.INSTANCE, Values.CHEQUE.getOrdinal());
        public final Field CLEARSTREAM = new Field(DistribPaymentMethod.INSTANCE, Values.CLEARSTREAM.getOrdinal());
        public final Field ACH_CREDIT = new Field(DistribPaymentMethod.INSTANCE, Values.ACH_CREDIT.getOrdinal());
        public final Field DIRECT_CREDIT_BECS_BACS = new Field(DistribPaymentMethod.INSTANCE, Values.DIRECT_CREDIT_BECS_BACS.getOrdinal());
        public final Field HIGH_VALUE_CLEARING_SYSTEM_HVACS = new Field(DistribPaymentMethod.INSTANCE, Values.HIGH_VALUE_CLEARING_SYSTEM_HVACS.getOrdinal());
        public final Field REINVEST_IN_FUND = new Field(DistribPaymentMethod.INSTANCE, Values.REINVEST_IN_FUND.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EUROCLEAR("3"),
        NSCC("2"),
        BPAY("10"),
        CREST("1"),
        FED_WIRE("7"),
        TELEGRAPHIC_TRANSFER("6"),
        CHEQUE("5"),
        CLEARSTREAM("4"),
        ACH_CREDIT("9"),
        DIRECT_CREDIT_BECS_BACS("8"),
        HIGH_VALUE_CLEARING_SYSTEM_HVACS("11"),
        REINVEST_IN_FUND("12");

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
