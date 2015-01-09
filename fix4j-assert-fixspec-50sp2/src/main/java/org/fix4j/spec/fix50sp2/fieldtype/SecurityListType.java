package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityListType extends BaseFieldType {
    public static final SecurityListType INSTANCE = new SecurityListType();

    private SecurityListType() {
        super(
            "SecurityListType",
            1470,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MARKET__MARKET_SEGMENT_LIST = new Field(SecurityListType.INSTANCE, Values.MARKET__MARKET_SEGMENT_LIST.getOrdinal());
        public final Field TRADING_LIST = new Field(SecurityListType.INSTANCE, Values.TRADING_LIST.getOrdinal());
        public final Field INDUSTRY_CLASSIFICATION = new Field(SecurityListType.INSTANCE, Values.INDUSTRY_CLASSIFICATION.getOrdinal());
        public final Field NEWSPAPER_LIST = new Field(SecurityListType.INSTANCE, Values.NEWSPAPER_LIST.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MARKET__MARKET_SEGMENT_LIST("3"),
        TRADING_LIST("2"),
        INDUSTRY_CLASSIFICATION("1"),
        NEWSPAPER_LIST("4");

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
