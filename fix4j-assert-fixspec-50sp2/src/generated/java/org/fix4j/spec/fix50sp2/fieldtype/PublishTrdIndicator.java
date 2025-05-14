package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PublishTrdIndicator extends BaseFieldType {
    public static final PublishTrdIndicator INSTANCE = new PublishTrdIndicator();

    private PublishTrdIndicator() {
        super(
            "PublishTrdIndicator",
            852,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DO_NOT_REPORT_TRADE = new Field(PublishTrdIndicator.INSTANCE, Values.DO_NOT_REPORT_TRADE.getOrdinal());
        public final Field REPORT_TRADE = new Field(PublishTrdIndicator.INSTANCE, Values.REPORT_TRADE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DO_NOT_REPORT_TRADE("N"),
        REPORT_TRADE("Y");

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
