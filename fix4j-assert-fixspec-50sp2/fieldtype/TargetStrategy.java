package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TargetStrategy extends BaseFieldType {
    public static final TargetStrategy INSTANCE = new TargetStrategy();

    private TargetStrategy() {
        super(
            "TargetStrategy",
            847,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MININIZE_MARKET_IMPACT = new Field(TargetStrategy.INSTANCE, Values.MININIZE_MARKET_IMPACT.getOrdinal());
        public final Field PARTICIPATE_IE_AIM_TO_BE_X_PERCENT_OF_THE_MARKET_VOLUME = new Field(TargetStrategy.INSTANCE, Values.PARTICIPATE_IE_AIM_TO_BE_X_PERCENT_OF_THE_MARKET_VOLUME.getOrdinal());
        public final Field VWAP = new Field(TargetStrategy.INSTANCE, Values.VWAP.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MININIZE_MARKET_IMPACT("3"),
        PARTICIPATE_IE_AIM_TO_BE_X_PERCENT_OF_THE_MARKET_VOLUME("2"),
        VWAP("1");

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
