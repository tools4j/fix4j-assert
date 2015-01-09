package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ValuationMethod extends BaseFieldType {
    public static final ValuationMethod INSTANCE = new ValuationMethod();

    private ValuationMethod() {
        super(
            "ValuationMethod",
            1197,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FUTURES_STYLE_MARKTOMARKET = new Field(ValuationMethod.INSTANCE, Values.FUTURES_STYLE_MARKTOMARKET.getOrdinal());
        public final Field FUTURES_STYLE_WITH_AN_ATTACHED_CASH_ADJUSTMENT = new Field(ValuationMethod.INSTANCE, Values.FUTURES_STYLE_WITH_AN_ATTACHED_CASH_ADJUSTMENT.getOrdinal());
        public final Field CDS_IN_DELIVERY__USE_RECOVERY_RATE_TO_CALCULATE_OBLIGATION = new Field(ValuationMethod.INSTANCE, Values.CDS_IN_DELIVERY__USE_RECOVERY_RATE_TO_CALCULATE_OBLIGATION.getOrdinal());
        public final Field CDS_STYLE_COLLATERALIZATION_OF_MARKET_TO_MARKET_AND_COUPON = new Field(ValuationMethod.INSTANCE, Values.CDS_STYLE_COLLATERALIZATION_OF_MARKET_TO_MARKET_AND_COUPON.getOrdinal());
        public final Field PREMIUM_STYLE = new Field(ValuationMethod.INSTANCE, Values.PREMIUM_STYLE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FUTURES_STYLE_MARKTOMARKET("FUT"),
        FUTURES_STYLE_WITH_AN_ATTACHED_CASH_ADJUSTMENT("FUTDA"),
        CDS_IN_DELIVERY__USE_RECOVERY_RATE_TO_CALCULATE_OBLIGATION("CDSD"),
        CDS_STYLE_COLLATERALIZATION_OF_MARKET_TO_MARKET_AND_COUPON("CDS"),
        PREMIUM_STYLE("EQTY");

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
