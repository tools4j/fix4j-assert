package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ImpliedMarketIndicator extends BaseFieldType {
    public static final ImpliedMarketIndicator INSTANCE = new ImpliedMarketIndicator();

    private ImpliedMarketIndicator() {
        super(
            "ImpliedMarketIndicator",
            1144,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BOTH_IMPLIEDIN_AND_IMPLIEDOUT = new Field(ImpliedMarketIndicator.INSTANCE, Values.BOTH_IMPLIEDIN_AND_IMPLIEDOUT.getOrdinal());
        public final Field IMPLIEDOUT__THE_EXISTENCE_OF_THE_UNDERLYING_LEGS_ARE_IMPLIED_BY_ = new Field(ImpliedMarketIndicator.INSTANCE, Values.IMPLIEDOUT__THE_EXISTENCE_OF_THE_UNDERLYING_LEGS_ARE_IMPLIED_BY_.getOrdinal());
        public final Field IMPLIEDIN__THE_EXISTENCE_OF_A_MULTILEG_INSTRUMENT_IS_IMPLIED_BY_ = new Field(ImpliedMarketIndicator.INSTANCE, Values.IMPLIEDIN__THE_EXISTENCE_OF_A_MULTILEG_INSTRUMENT_IS_IMPLIED_BY_.getOrdinal());
        public final Field NOT_IMPLIED = new Field(ImpliedMarketIndicator.INSTANCE, Values.NOT_IMPLIED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BOTH_IMPLIEDIN_AND_IMPLIEDOUT("3"),
        IMPLIEDOUT__THE_EXISTENCE_OF_THE_UNDERLYING_LEGS_ARE_IMPLIED_BY_("2"),
        IMPLIEDIN__THE_EXISTENCE_OF_A_MULTILEG_INSTRUMENT_IS_IMPLIED_BY_("1"),
        NOT_IMPLIED("0");

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
