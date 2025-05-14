package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PegLimitType extends BaseFieldType {
    public static final PegLimitType INSTANCE = new PegLimitType();

    private PegLimitType() {
        super(
            "PegLimitType",
            837,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field OR_WORSE__FOR_A_BUY_THE_PEG_LIMIT_IS_A_MINIMUM_AND_FOR_A_SELL_TH = new Field(PegLimitType.INSTANCE, Values.OR_WORSE__FOR_A_BUY_THE_PEG_LIMIT_IS_A_MINIMUM_AND_FOR_A_SELL_TH.getOrdinal());
        public final Field STRICT__LIMIT_IS_A_STRICT_LIMIT = new Field(PegLimitType.INSTANCE, Values.STRICT__LIMIT_IS_A_STRICT_LIMIT.getOrdinal());
        public final Field OR_BETTER_DEFAULT__PRICE_IMPROVEMENT_ALLOWED = new Field(PegLimitType.INSTANCE, Values.OR_BETTER_DEFAULT__PRICE_IMPROVEMENT_ALLOWED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        OR_WORSE__FOR_A_BUY_THE_PEG_LIMIT_IS_A_MINIMUM_AND_FOR_A_SELL_TH("2"),
        STRICT__LIMIT_IS_A_STRICT_LIMIT("1"),
        OR_BETTER_DEFAULT__PRICE_IMPROVEMENT_ALLOWED("0");

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
