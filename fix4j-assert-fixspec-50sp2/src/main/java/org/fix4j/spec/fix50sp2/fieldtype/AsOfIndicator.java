package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AsOfIndicator extends BaseFieldType {
    public static final AsOfIndicator INSTANCE = new AsOfIndicator();

    private AsOfIndicator() {
        super(
            "AsOfIndicator",
            1015,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TRUE__TRADE_IS_AN_ASOF_TRADE = new Field(AsOfIndicator.INSTANCE, Values.TRUE__TRADE_IS_AN_ASOF_TRADE.getOrdinal());
        public final Field FALSE__TRADE_IS_NOT_AN_ASOF_TRADE = new Field(AsOfIndicator.INSTANCE, Values.FALSE__TRADE_IS_NOT_AN_ASOF_TRADE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TRUE__TRADE_IS_AN_ASOF_TRADE("1"),
        FALSE__TRADE_IS_NOT_AN_ASOF_TRADE("0");

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
