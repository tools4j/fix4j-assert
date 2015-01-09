package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PriceQuoteMethod extends BaseFieldType {
    public static final PriceQuoteMethod INSTANCE = new PriceQuoteMethod();

    private PriceQuoteMethod() {
        super(
            "PriceQuoteMethod",
            1196,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PERCENT_OF_PAR = new Field(PriceQuoteMethod.INSTANCE, Values.PERCENT_OF_PAR.getOrdinal());
        public final Field STANDARD_MONEY_PER_UNIT_OF_A_PHYSICAL = new Field(PriceQuoteMethod.INSTANCE, Values.STANDARD_MONEY_PER_UNIT_OF_A_PHYSICAL.getOrdinal());
        public final Field INTEREST_RATE_INDEX = new Field(PriceQuoteMethod.INSTANCE, Values.INTEREST_RATE_INDEX.getOrdinal());
        public final Field INDEX = new Field(PriceQuoteMethod.INSTANCE, Values.INDEX.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PERCENT_OF_PAR("PCTPAR"),
        STANDARD_MONEY_PER_UNIT_OF_A_PHYSICAL("STD"),
        INTEREST_RATE_INDEX("INT"),
        INDEX("INX");

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
