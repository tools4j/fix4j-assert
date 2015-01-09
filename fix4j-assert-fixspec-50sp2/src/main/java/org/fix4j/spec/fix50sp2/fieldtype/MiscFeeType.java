package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MiscFeeType extends BaseFieldType {
    public static final MiscFeeType INSTANCE = new MiscFeeType();

    private MiscFeeType() {
        super(
            "MiscFeeType",
            139,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TRANSFER_FEE = new Field(MiscFeeType.INSTANCE, Values.TRANSFER_FEE.getOrdinal());
        public final Field SECURITY_LENDING = new Field(MiscFeeType.INSTANCE, Values.SECURITY_LENDING.getOrdinal());
        public final Field CONVERSION = new Field(MiscFeeType.INSTANCE, Values.CONVERSION.getOrdinal());
        public final Field AGENT = new Field(MiscFeeType.INSTANCE, Values.AGENT.getOrdinal());
        public final Field LOCAL_COMMISSION = new Field(MiscFeeType.INSTANCE, Values.LOCAL_COMMISSION.getOrdinal());
        public final Field TAX = new Field(MiscFeeType.INSTANCE, Values.TAX.getOrdinal());
        public final Field REGULATORY_EG_SEC = new Field(MiscFeeType.INSTANCE, Values.REGULATORY_EG_SEC.getOrdinal());
        public final Field PER_TRANSACTION = new Field(MiscFeeType.INSTANCE, Values.PER_TRANSACTION.getOrdinal());
        public final Field OTHER = new Field(MiscFeeType.INSTANCE, Values.OTHER.getOrdinal());
        public final Field LEVY = new Field(MiscFeeType.INSTANCE, Values.LEVY.getOrdinal());
        public final Field STAMP = new Field(MiscFeeType.INSTANCE, Values.STAMP.getOrdinal());
        public final Field EXCHANGE_FEES = new Field(MiscFeeType.INSTANCE, Values.EXCHANGE_FEES.getOrdinal());
        public final Field CONSUMPTION_TAX = new Field(MiscFeeType.INSTANCE, Values.CONSUMPTION_TAX.getOrdinal());
        public final Field MARKUP = new Field(MiscFeeType.INSTANCE, Values.MARKUP.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TRANSFER_FEE("13"),
        SECURITY_LENDING("14"),
        CONVERSION("11"),
        AGENT("12"),
        LOCAL_COMMISSION("3"),
        TAX("2"),
        REGULATORY_EG_SEC("1"),
        PER_TRANSACTION("10"),
        OTHER("7"),
        LEVY("6"),
        STAMP("5"),
        EXCHANGE_FEES("4"),
        CONSUMPTION_TAX("9"),
        MARKUP("8");

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
