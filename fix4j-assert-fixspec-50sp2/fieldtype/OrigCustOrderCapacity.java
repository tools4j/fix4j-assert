package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OrigCustOrderCapacity extends BaseFieldType {
    public static final OrigCustOrderCapacity INSTANCE = new OrigCustOrderCapacity();

    private OrigCustOrderCapacity() {
        super(
            "OrigCustOrderCapacity",
            1432,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MEMBER_TRADING_FOR_ANOTHER_MEMBER = new Field(OrigCustOrderCapacity.INSTANCE, Values.MEMBER_TRADING_FOR_ANOTHER_MEMBER.getOrdinal());
        public final Field CLEARING_FIRM_TRADING_FOR_ITS_PROPRIETARY_ACCOUNT = new Field(OrigCustOrderCapacity.INSTANCE, Values.CLEARING_FIRM_TRADING_FOR_ITS_PROPRIETARY_ACCOUNT.getOrdinal());
        public final Field MEMBER_TRADING_FOR_THEIR_OWN_ACCOUNT = new Field(OrigCustOrderCapacity.INSTANCE, Values.MEMBER_TRADING_FOR_THEIR_OWN_ACCOUNT.getOrdinal());
        public final Field ALL_OTHER = new Field(OrigCustOrderCapacity.INSTANCE, Values.ALL_OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MEMBER_TRADING_FOR_ANOTHER_MEMBER("3"),
        CLEARING_FIRM_TRADING_FOR_ITS_PROPRIETARY_ACCOUNT("2"),
        MEMBER_TRADING_FOR_THEIR_OWN_ACCOUNT("1"),
        ALL_OTHER("4");

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
