package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DiscretionLimitType extends BaseFieldType {
    public static final DiscretionLimitType INSTANCE = new DiscretionLimitType();

    private DiscretionLimitType() {
        super(
            "DiscretionLimitType",
            843,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field OR_WORSE__FOR_A_BUY_THE_DISCRETION_PRICE_IS_A_MINIMUM_AND_FOR_A_ = new Field(DiscretionLimitType.INSTANCE, Values.OR_WORSE__FOR_A_BUY_THE_DISCRETION_PRICE_IS_A_MINIMUM_AND_FOR_A_.getOrdinal());
        public final Field STRICT__LIMIT_IS_A_STRICT_LIMIT = new Field(DiscretionLimitType.INSTANCE, Values.STRICT__LIMIT_IS_A_STRICT_LIMIT.getOrdinal());
        public final Field OR_BETTER_DEFAULT__PRICE_IMPROVEMENT_ALLOWED = new Field(DiscretionLimitType.INSTANCE, Values.OR_BETTER_DEFAULT__PRICE_IMPROVEMENT_ALLOWED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        OR_WORSE__FOR_A_BUY_THE_DISCRETION_PRICE_IS_A_MINIMUM_AND_FOR_A_("2"),
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
