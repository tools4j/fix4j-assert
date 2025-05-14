package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CollInquiryQualifier extends BaseFieldType {
    public static final CollInquiryQualifier INSTANCE = new CollInquiryQualifier();

    private CollInquiryQualifier() {
        super(
            "CollInquiryQualifier",
            896,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SUBSTITUTION_ELIGIBLE = new Field(CollInquiryQualifier.INSTANCE, Values.SUBSTITUTION_ELIGIBLE.getOrdinal());
        public final Field COLLATERAL_INSTRUMENT = new Field(CollInquiryQualifier.INSTANCE, Values.COLLATERAL_INSTRUMENT.getOrdinal());
        public final Field GC_INSTRUMENT = new Field(CollInquiryQualifier.INSTANCE, Values.GC_INSTRUMENT.getOrdinal());
        public final Field TRADE_DATE = new Field(CollInquiryQualifier.INSTANCE, Values.TRADE_DATE.getOrdinal());
        public final Field OUTSTANDING_TRADES_TODAY__END_DATE = new Field(CollInquiryQualifier.INSTANCE, Values.OUTSTANDING_TRADES_TODAY__END_DATE.getOrdinal());
        public final Field FULLY_ASSIGNED = new Field(CollInquiryQualifier.INSTANCE, Values.FULLY_ASSIGNED.getOrdinal());
        public final Field PARTIALLY_ASSIGNED = new Field(CollInquiryQualifier.INSTANCE, Values.PARTIALLY_ASSIGNED.getOrdinal());
        public final Field NOT_ASSIGNED = new Field(CollInquiryQualifier.INSTANCE, Values.NOT_ASSIGNED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SUBSTITUTION_ELIGIBLE("3"),
        COLLATERAL_INSTRUMENT("2"),
        GC_INSTRUMENT("1"),
        TRADE_DATE("0"),
        OUTSTANDING_TRADES_TODAY__END_DATE("7"),
        FULLY_ASSIGNED("6"),
        PARTIALLY_ASSIGNED("5"),
        NOT_ASSIGNED("4");

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
