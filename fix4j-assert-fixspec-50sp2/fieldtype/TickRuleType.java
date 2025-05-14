package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TickRuleType extends BaseFieldType {
    public static final TickRuleType INSTANCE = new TickRuleType();

    private TickRuleType() {
        super(
            "TickRuleType",
            1209,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TRADED_AS_A_SPREAD_LEG = new Field(TickRuleType.INSTANCE, Values.TRADED_AS_A_SPREAD_LEG.getOrdinal());
        public final Field FIXED = new Field(TickRuleType.INSTANCE, Values.FIXED.getOrdinal());
        public final Field VARIABLE = new Field(TickRuleType.INSTANCE, Values.VARIABLE.getOrdinal());
        public final Field REGULAR = new Field(TickRuleType.INSTANCE, Values.REGULAR.getOrdinal());
        public final Field SETTLED_AS_A_SPREAD_LEG = new Field(TickRuleType.INSTANCE, Values.SETTLED_AS_A_SPREAD_LEG.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TRADED_AS_A_SPREAD_LEG("3"),
        FIXED("2"),
        VARIABLE("1"),
        REGULAR("0"),
        SETTLED_AS_A_SPREAD_LEG("4");

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
