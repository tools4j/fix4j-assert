package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PaymentMethod extends BaseFieldType {
    public static final PaymentMethod INSTANCE = new PaymentMethod();

    private PaymentMethod() {
        super(
            "PaymentMethod",
            492,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field HIGH_VALUE_CLEARING_SYSTEM_HVACS = new Field(PaymentMethod.INSTANCE, Values.HIGH_VALUE_CLEARING_SYSTEM_HVACS.getOrdinal());
        public final Field ACH_CREDIT = new Field(PaymentMethod.INSTANCE, Values.ACH_CREDIT.getOrdinal());
        public final Field BPAY = new Field(PaymentMethod.INSTANCE, Values.BPAY.getOrdinal());
        public final Field CREDIT_CARD = new Field(PaymentMethod.INSTANCE, Values.CREDIT_CARD.getOrdinal());
        public final Field ACH_DEBIT = new Field(PaymentMethod.INSTANCE, Values.ACH_DEBIT.getOrdinal());
        public final Field EUROCLEAR = new Field(PaymentMethod.INSTANCE, Values.EUROCLEAR.getOrdinal());
        public final Field NSCC = new Field(PaymentMethod.INSTANCE, Values.NSCC.getOrdinal());
        public final Field CREST = new Field(PaymentMethod.INSTANCE, Values.CREST.getOrdinal());
        public final Field DIRECT_CREDIT_BECS = new Field(PaymentMethod.INSTANCE, Values.DIRECT_CREDIT_BECS.getOrdinal());
        public final Field FED_WIRE = new Field(PaymentMethod.INSTANCE, Values.FED_WIRE.getOrdinal());
        public final Field TELEGRAPHIC_TRANSFER = new Field(PaymentMethod.INSTANCE, Values.TELEGRAPHIC_TRANSFER.getOrdinal());
        public final Field CHEQUE = new Field(PaymentMethod.INSTANCE, Values.CHEQUE.getOrdinal());
        public final Field CLEARSTREAM = new Field(PaymentMethod.INSTANCE, Values.CLEARSTREAM.getOrdinal());
        public final Field DIRECT_DEBIT_BECS = new Field(PaymentMethod.INSTANCE, Values.DIRECT_DEBIT_BECS.getOrdinal());
        public final Field DEBIT_CARD = new Field(PaymentMethod.INSTANCE, Values.DEBIT_CARD.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        HIGH_VALUE_CLEARING_SYSTEM_HVACS("15"),
        ACH_CREDIT("13"),
        BPAY("14"),
        CREDIT_CARD("11"),
        ACH_DEBIT("12"),
        EUROCLEAR("3"),
        NSCC("2"),
        CREST("1"),
        DIRECT_CREDIT_BECS("10"),
        FED_WIRE("7"),
        TELEGRAPHIC_TRANSFER("6"),
        CHEQUE("5"),
        CLEARSTREAM("4"),
        DIRECT_DEBIT_BECS("9"),
        DEBIT_CARD("8");

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
