package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ClearingFeeIndicator extends BaseFieldType {
    public static final ClearingFeeIndicator INSTANCE = new ClearingFeeIndicator();

    private ClearingFeeIndicator() {
        super(
            "ClearingFeeIndicator",
            635,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EQUITY_MEMBER_AND_CLEARING_MEMBER = new Field(ClearingFeeIndicator.INSTANCE, Values.EQUITY_MEMBER_AND_CLEARING_MEMBER.getOrdinal());
        public final Field FULL_AND_ASSOCIATE_MEMBER_TRADING_FOR_OWN_ACCOUNT_AND_AS_FLOOR_B = new Field(ClearingFeeIndicator.INSTANCE, Values.FULL_AND_ASSOCIATE_MEMBER_TRADING_FOR_OWN_ACCOUNT_AND_AS_FLOOR_B.getOrdinal());
        public final Field CBOE_MEMBER = new Field(ClearingFeeIndicator.INSTANCE, Values.CBOE_MEMBER.getOrdinal());
        public final Field NONMEMBER_AND_CUSTOMER = new Field(ClearingFeeIndicator.INSTANCE, Values.NONMEMBER_AND_CUSTOMER.getOrdinal());
        public final Field LESSEE_106F_EMPLOYEES = new Field(ClearingFeeIndicator.INSTANCE, Values.LESSEE_106F_EMPLOYEES.getOrdinal());
        public final Field ALL_OTHER_OWNERSHIP_TYPES = new Field(ClearingFeeIndicator.INSTANCE, Values.ALL_OTHER_OWNERSHIP_TYPES.getOrdinal());
        public final Field I106H_AND_106J_FIRMS = new Field(ClearingFeeIndicator.INSTANCE, Values.I106H_AND_106J_FIRMS.getOrdinal());
        public final Field GIM_IDEM_AND_COM_MEMBERSHIP_INTEREST_HOLDERS = new Field(ClearingFeeIndicator.INSTANCE, Values.GIM_IDEM_AND_COM_MEMBERSHIP_INTEREST_HOLDERS.getOrdinal());
        public final Field I3RD_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT = new Field(ClearingFeeIndicator.INSTANCE, Values.I3RD_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT.getOrdinal());
        public final Field I2ND_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT = new Field(ClearingFeeIndicator.INSTANCE, Values.I2ND_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT.getOrdinal());
        public final Field I1ST_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT = new Field(ClearingFeeIndicator.INSTANCE, Values.I1ST_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT.getOrdinal());
        public final Field I5TH_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT = new Field(ClearingFeeIndicator.INSTANCE, Values.I5TH_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT.getOrdinal());
        public final Field I4TH_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT = new Field(ClearingFeeIndicator.INSTANCE, Values.I4TH_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT.getOrdinal());
        public final Field I6TH_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT = new Field(ClearingFeeIndicator.INSTANCE, Values.I6TH_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EQUITY_MEMBER_AND_CLEARING_MEMBER("E"),
        FULL_AND_ASSOCIATE_MEMBER_TRADING_FOR_OWN_ACCOUNT_AND_AS_FLOOR_B("F"),
        CBOE_MEMBER("B"),
        NONMEMBER_AND_CUSTOMER("C"),
        LESSEE_106F_EMPLOYEES("L"),
        ALL_OTHER_OWNERSHIP_TYPES("M"),
        I106H_AND_106J_FIRMS("H"),
        GIM_IDEM_AND_COM_MEMBERSHIP_INTEREST_HOLDERS("I"),
        I3RD_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT("3"),
        I2ND_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT("2"),
        I1ST_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT("1"),
        I5TH_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT("5"),
        I4TH_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT("4"),
        I6TH_YEAR_DELEGATE_TRADING_FOR_OWN_ACCOUNT("9");

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
