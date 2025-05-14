package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QuoteRespType extends BaseFieldType {
    public static final QuoteRespType INSTANCE = new QuoteRespType();

    private QuoteRespType() {
        super(
            "QuoteRespType",
            694,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXPIRED = new Field(QuoteRespType.INSTANCE, Values.EXPIRED.getOrdinal());
        public final Field COUNTER = new Field(QuoteRespType.INSTANCE, Values.COUNTER.getOrdinal());
        public final Field HITLIFT = new Field(QuoteRespType.INSTANCE, Values.HITLIFT.getOrdinal());
        public final Field END_TRADE = new Field(QuoteRespType.INSTANCE, Values.END_TRADE.getOrdinal());
        public final Field PASS = new Field(QuoteRespType.INSTANCE, Values.PASS.getOrdinal());
        public final Field DONE_AWAY = new Field(QuoteRespType.INSTANCE, Values.DONE_AWAY.getOrdinal());
        public final Field COVER = new Field(QuoteRespType.INSTANCE, Values.COVER.getOrdinal());
        public final Field TIMED_OUT = new Field(QuoteRespType.INSTANCE, Values.TIMED_OUT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXPIRED("3"),
        COUNTER("2"),
        HITLIFT("1"),
        END_TRADE("7"),
        PASS("6"),
        DONE_AWAY("5"),
        COVER("4"),
        TIMED_OUT("8");

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
