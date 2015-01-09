package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlPriceType extends BaseFieldType {
    public static final SettlPriceType INSTANCE = new SettlPriceType();

    private SettlPriceType() {
        super(
            "SettlPriceType",
            731,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field THEORETICAL = new Field(SettlPriceType.INSTANCE, Values.THEORETICAL.getOrdinal());
        public final Field FINAL = new Field(SettlPriceType.INSTANCE, Values.FINAL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        THEORETICAL("2"),
        FINAL("1");

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
