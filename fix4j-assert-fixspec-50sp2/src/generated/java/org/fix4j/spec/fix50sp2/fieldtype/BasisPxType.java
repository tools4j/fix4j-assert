package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class BasisPxType extends BaseFieldType {
    public static final BasisPxType INSTANCE = new BasisPxType();

    private BasisPxType() {
        super(
            "BasisPxType",
            419,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field OPEN = new Field(BasisPxType.INSTANCE, Values.OPEN.getOrdinal());
        public final Field VWAP_THROUGH_A_MORNING_SESSION_EXCEPT_YORI_AN_OPENING_AUCTION = new Field(BasisPxType.INSTANCE, Values.VWAP_THROUGH_A_MORNING_SESSION_EXCEPT_YORI_AN_OPENING_AUCTION.getOrdinal());
        public final Field VWAP_THROUGH_AN_AFTERNOON_SESSION_EXCEPT_YORI_AN_OPENING_AUCTION = new Field(BasisPxType.INSTANCE, Values.VWAP_THROUGH_AN_AFTERNOON_SESSION_EXCEPT_YORI_AN_OPENING_AUCTION.getOrdinal());
        public final Field STRIKE = new Field(BasisPxType.INSTANCE, Values.STRIKE.getOrdinal());
        public final Field CLOSING_PRICE = new Field(BasisPxType.INSTANCE, Values.CLOSING_PRICE.getOrdinal());
        public final Field CLOSING_PRICE_AT_MORNINGN_SESSION = new Field(BasisPxType.INSTANCE, Values.CLOSING_PRICE_AT_MORNINGN_SESSION.getOrdinal());
        public final Field VWAP_THROUGH_A_MORNING_SESSION = new Field(BasisPxType.INSTANCE, Values.VWAP_THROUGH_A_MORNING_SESSION.getOrdinal());
        public final Field VWAP_THROUGH_A_DAY = new Field(BasisPxType.INSTANCE, Values.VWAP_THROUGH_A_DAY.getOrdinal());
        public final Field SQ = new Field(BasisPxType.INSTANCE, Values.SQ.getOrdinal());
        public final Field CURRENT_PRICE = new Field(BasisPxType.INSTANCE, Values.CURRENT_PRICE.getOrdinal());
        public final Field VWAP_THROUGH_A_DAY_EXCEPT_YORI_AN_OPENING_AUCTION = new Field(BasisPxType.INSTANCE, Values.VWAP_THROUGH_A_DAY_EXCEPT_YORI_AN_OPENING_AUCTION.getOrdinal());
        public final Field VWAP_THROUGH_AN_AFTERNOON_SESSION = new Field(BasisPxType.INSTANCE, Values.VWAP_THROUGH_AN_AFTERNOON_SESSION.getOrdinal());
        public final Field OTHERS = new Field(BasisPxType.INSTANCE, Values.OTHERS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        OPEN("D"),
        VWAP_THROUGH_A_MORNING_SESSION_EXCEPT_YORI_AN_OPENING_AUCTION("A"),
        VWAP_THROUGH_AN_AFTERNOON_SESSION_EXCEPT_YORI_AN_OPENING_AUCTION("B"),
        STRIKE("C"),
        CLOSING_PRICE("3"),
        CLOSING_PRICE_AT_MORNINGN_SESSION("2"),
        VWAP_THROUGH_A_MORNING_SESSION("7"),
        VWAP_THROUGH_A_DAY("6"),
        SQ("5"),
        CURRENT_PRICE("4"),
        VWAP_THROUGH_A_DAY_EXCEPT_YORI_AN_OPENING_AUCTION("9"),
        VWAP_THROUGH_AN_AFTERNOON_SESSION("8"),
        OTHERS("Z");

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
