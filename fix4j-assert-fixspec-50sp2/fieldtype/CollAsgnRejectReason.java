package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CollAsgnRejectReason extends BaseFieldType {
    public static final CollAsgnRejectReason INSTANCE = new CollAsgnRejectReason();

    private CollAsgnRejectReason() {
        super(
            "CollAsgnRejectReason",
            906,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INSUFFICIENT_COLLATERAL = new Field(CollAsgnRejectReason.INSTANCE, Values.INSUFFICIENT_COLLATERAL.getOrdinal());
        public final Field UNAUTHORIZED_TRANSACTION = new Field(CollAsgnRejectReason.INSTANCE, Values.UNAUTHORIZED_TRANSACTION.getOrdinal());
        public final Field UNKNOWN_OR_INVALID_INSTRUMENT = new Field(CollAsgnRejectReason.INSTANCE, Values.UNKNOWN_OR_INVALID_INSTRUMENT.getOrdinal());
        public final Field UNKNOWN_DEAL_ORDER__TRADE = new Field(CollAsgnRejectReason.INSTANCE, Values.UNKNOWN_DEAL_ORDER__TRADE.getOrdinal());
        public final Field EXCESSIVE_SUBSTITUTION = new Field(CollAsgnRejectReason.INSTANCE, Values.EXCESSIVE_SUBSTITUTION.getOrdinal());
        public final Field INVALID_TYPE_OF_COLLATERAL = new Field(CollAsgnRejectReason.INSTANCE, Values.INVALID_TYPE_OF_COLLATERAL.getOrdinal());
        public final Field OTHER = new Field(CollAsgnRejectReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INSUFFICIENT_COLLATERAL("3"),
        UNAUTHORIZED_TRANSACTION("2"),
        UNKNOWN_OR_INVALID_INSTRUMENT("1"),
        UNKNOWN_DEAL_ORDER__TRADE("0"),
        EXCESSIVE_SUBSTITUTION("5"),
        INVALID_TYPE_OF_COLLATERAL("4"),
        OTHER("99");

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
