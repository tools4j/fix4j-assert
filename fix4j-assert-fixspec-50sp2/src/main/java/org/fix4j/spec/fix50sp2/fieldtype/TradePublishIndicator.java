package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradePublishIndicator extends BaseFieldType {
    public static final TradePublishIndicator INSTANCE = new TradePublishIndicator();

    private TradePublishIndicator() {
        super(
            "TradePublishIndicator",
            1390,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DEFERRED_PUBLICATION = new Field(TradePublishIndicator.INSTANCE, Values.DEFERRED_PUBLICATION.getOrdinal());
        public final Field PUBLISH_TRADE = new Field(TradePublishIndicator.INSTANCE, Values.PUBLISH_TRADE.getOrdinal());
        public final Field DO_NOT_PUBLISH_TRADE = new Field(TradePublishIndicator.INSTANCE, Values.DO_NOT_PUBLISH_TRADE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DEFERRED_PUBLICATION("2"),
        PUBLISH_TRADE("1"),
        DO_NOT_PUBLISH_TRADE("0");

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
