package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class BidType extends BaseFieldType {
    public static final BidType INSTANCE = new BidType();

    private BidType() {
        super(
            "BidType",
            394,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NO_BIDDING_PROCESS = new Field(BidType.INSTANCE, Values.NO_BIDDING_PROCESS.getOrdinal());
        public final Field DISCLOSED_SYTLE_EG_JAPANESE = new Field(BidType.INSTANCE, Values.DISCLOSED_SYTLE_EG_JAPANESE.getOrdinal());
        public final Field NON_DISCLOSED_STYLE_EG_USEUROPEAN = new Field(BidType.INSTANCE, Values.NON_DISCLOSED_STYLE_EG_USEUROPEAN.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NO_BIDDING_PROCESS("3"),
        DISCLOSED_SYTLE_EG_JAPANESE("2"),
        NON_DISCLOSED_STYLE_EG_USEUROPEAN("1");

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
