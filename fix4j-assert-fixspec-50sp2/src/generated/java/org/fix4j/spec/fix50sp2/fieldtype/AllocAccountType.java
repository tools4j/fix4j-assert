package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocAccountType extends BaseFieldType {
    public static final AllocAccountType INSTANCE = new AllocAccountType();

    private AllocAccountType() {
        super(
            "AllocAccountType",
            798,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field HOUSE_TRADER = new Field(AllocAccountType.INSTANCE, Values.HOUSE_TRADER.getOrdinal());
        public final Field ACCOUNT_IS_CARRIED_ON_NONCUSTOMER_SIDE_OF_BOOKS = new Field(AllocAccountType.INSTANCE, Values.ACCOUNT_IS_CARRIED_ON_NONCUSTOMER_SIDE_OF_BOOKS.getOrdinal());
        public final Field ACCOUNT_IS_CARRIED_PN_CUSTOMER_SIDE_OF_BOOKS = new Field(AllocAccountType.INSTANCE, Values.ACCOUNT_IS_CARRIED_PN_CUSTOMER_SIDE_OF_BOOKS.getOrdinal());
        public final Field ACCOUNT_IS_HOUSE_TRADER_AND_IS_CROSS_MARGINED = new Field(AllocAccountType.INSTANCE, Values.ACCOUNT_IS_HOUSE_TRADER_AND_IS_CROSS_MARGINED.getOrdinal());
        public final Field ACCOUNT_IS_CARRIED_ON_NONCUSTOMER_SIDE_OF_BOOKS_AND_IS_CROSS_MAR = new Field(AllocAccountType.INSTANCE, Values.ACCOUNT_IS_CARRIED_ON_NONCUSTOMER_SIDE_OF_BOOKS_AND_IS_CROSS_MAR.getOrdinal());
        public final Field FLOOR_TRADER = new Field(AllocAccountType.INSTANCE, Values.FLOOR_TRADER.getOrdinal());
        public final Field JOINT_BACK_OFFICE_ACCOUNT_JBO = new Field(AllocAccountType.INSTANCE, Values.JOINT_BACK_OFFICE_ACCOUNT_JBO.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        HOUSE_TRADER("3"),
        ACCOUNT_IS_CARRIED_ON_NONCUSTOMER_SIDE_OF_BOOKS("2"),
        ACCOUNT_IS_CARRIED_PN_CUSTOMER_SIDE_OF_BOOKS("1"),
        ACCOUNT_IS_HOUSE_TRADER_AND_IS_CROSS_MARGINED("7"),
        ACCOUNT_IS_CARRIED_ON_NONCUSTOMER_SIDE_OF_BOOKS_AND_IS_CROSS_MAR("6"),
        FLOOR_TRADER("4"),
        JOINT_BACK_OFFICE_ACCOUNT_JBO("8");

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
