package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TriggerOrderType extends BaseFieldType {
    public static final TriggerOrderType INSTANCE = new TriggerOrderType();

    private TriggerOrderType() {
        super(
            "TriggerOrderType",
            1111,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field LIMIT = new Field(TriggerOrderType.INSTANCE, Values.LIMIT.getOrdinal());
        public final Field MARKET = new Field(TriggerOrderType.INSTANCE, Values.MARKET.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        LIMIT("2"),
        MARKET("1");

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
