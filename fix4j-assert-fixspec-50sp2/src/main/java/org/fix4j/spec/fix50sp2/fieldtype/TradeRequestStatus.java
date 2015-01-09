package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TradeRequestStatus extends BaseFieldType {
    public static final TradeRequestStatus INSTANCE = new TradeRequestStatus();

    private TradeRequestStatus() {
        super(
            "TradeRequestStatus",
            750,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REJECTED = new Field(TradeRequestStatus.INSTANCE, Values.REJECTED.getOrdinal());
        public final Field COMPLETED = new Field(TradeRequestStatus.INSTANCE, Values.COMPLETED.getOrdinal());
        public final Field ACCEPTED = new Field(TradeRequestStatus.INSTANCE, Values.ACCEPTED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REJECTED("2"),
        COMPLETED("1"),
        ACCEPTED("0");

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
