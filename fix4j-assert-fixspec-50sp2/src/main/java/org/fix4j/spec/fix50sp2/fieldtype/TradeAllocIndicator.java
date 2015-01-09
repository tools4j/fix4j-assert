package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradeAllocIndicator extends BaseFieldType {
    public static final TradeAllocIndicator INSTANCE = new TradeAllocIndicator();

    private TradeAllocIndicator() {
        super(
            "TradeAllocIndicator",
            826,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ALLOCATION_GIVEUP_EXECUTOR = new Field(TradeAllocIndicator.INSTANCE, Values.ALLOCATION_GIVEUP_EXECUTOR.getOrdinal());
        public final Field USE_ALLOCATION_PROVIDED_WITH_THE_TRADE = new Field(TradeAllocIndicator.INSTANCE, Values.USE_ALLOCATION_PROVIDED_WITH_THE_TRADE.getOrdinal());
        public final Field ALLOCATION_REQUIRED_GIVEUP_TRADE_ALLOCATION_INFORMATION_NOT_PROV = new Field(TradeAllocIndicator.INSTANCE, Values.ALLOCATION_REQUIRED_GIVEUP_TRADE_ALLOCATION_INFORMATION_NOT_PROV.getOrdinal());
        public final Field ALLOCATION_NOT_REQUIRED = new Field(TradeAllocIndicator.INSTANCE, Values.ALLOCATION_NOT_REQUIRED.getOrdinal());
        public final Field ALLOCATION_TO_CLAIM_ACCOUNT = new Field(TradeAllocIndicator.INSTANCE, Values.ALLOCATION_TO_CLAIM_ACCOUNT.getOrdinal());
        public final Field ALLOCATION_FROM_EXECUTOR = new Field(TradeAllocIndicator.INSTANCE, Values.ALLOCATION_FROM_EXECUTOR.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ALLOCATION_GIVEUP_EXECUTOR("3"),
        USE_ALLOCATION_PROVIDED_WITH_THE_TRADE("2"),
        ALLOCATION_REQUIRED_GIVEUP_TRADE_ALLOCATION_INFORMATION_NOT_PROV("1"),
        ALLOCATION_NOT_REQUIRED("0"),
        ALLOCATION_TO_CLAIM_ACCOUNT("5"),
        ALLOCATION_FROM_EXECUTOR("4");

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
