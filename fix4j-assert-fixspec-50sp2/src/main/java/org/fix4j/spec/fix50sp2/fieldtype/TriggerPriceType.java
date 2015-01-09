package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TriggerPriceType extends BaseFieldType {
    public static final TriggerPriceType INSTANCE = new TriggerPriceType();

    private TriggerPriceType() {
        super(
            "TriggerPriceType",
            1107,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BEST_BID = new Field(TriggerPriceType.INSTANCE, Values.BEST_BID.getOrdinal());
        public final Field LAST_TRADE = new Field(TriggerPriceType.INSTANCE, Values.LAST_TRADE.getOrdinal());
        public final Field BEST_OFFER = new Field(TriggerPriceType.INSTANCE, Values.BEST_OFFER.getOrdinal());
        public final Field BEST_MID = new Field(TriggerPriceType.INSTANCE, Values.BEST_MID.getOrdinal());
        public final Field BEST_OFFER_OR_LAST_TRADE = new Field(TriggerPriceType.INSTANCE, Values.BEST_OFFER_OR_LAST_TRADE.getOrdinal());
        public final Field BEST_BID_OR_LAST_TRADE = new Field(TriggerPriceType.INSTANCE, Values.BEST_BID_OR_LAST_TRADE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BEST_BID("3"),
        LAST_TRADE("2"),
        BEST_OFFER("1"),
        BEST_MID("6"),
        BEST_OFFER_OR_LAST_TRADE("5"),
        BEST_BID_OR_LAST_TRADE("4");

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
