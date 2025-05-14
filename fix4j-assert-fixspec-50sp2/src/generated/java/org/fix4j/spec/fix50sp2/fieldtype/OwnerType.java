package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OwnerType extends BaseFieldType {
    public static final OwnerType INSTANCE = new OwnerType();

    private OwnerType() {
        super(
            "OwnerType",
            522,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NOMINEE = new Field(OwnerType.INSTANCE, Values.NOMINEE.getOrdinal());
        public final Field NONPROFIT_ORGANIZATION = new Field(OwnerType.INSTANCE, Values.NONPROFIT_ORGANIZATION.getOrdinal());
        public final Field CORPORATE_BODY = new Field(OwnerType.INSTANCE, Values.CORPORATE_BODY.getOrdinal());
        public final Field PRIVATE_COMPANY = new Field(OwnerType.INSTANCE, Values.PRIVATE_COMPANY.getOrdinal());
        public final Field PUBLIC_COMPANY = new Field(OwnerType.INSTANCE, Values.PUBLIC_COMPANY.getOrdinal());
        public final Field INDIVIDUAL_INVESTOR = new Field(OwnerType.INSTANCE, Values.INDIVIDUAL_INVESTOR.getOrdinal());
        public final Field NETWORKING_SUBACCOUNT = new Field(OwnerType.INSTANCE, Values.NETWORKING_SUBACCOUNT.getOrdinal());
        public final Field CUSTODIAN_UNDER_GIFTS_TO_MINORS_ACT = new Field(OwnerType.INSTANCE, Values.CUSTODIAN_UNDER_GIFTS_TO_MINORS_ACT.getOrdinal());
        public final Field PENSION_PLAN = new Field(OwnerType.INSTANCE, Values.PENSION_PLAN.getOrdinal());
        public final Field COMPANY_TRUSTEE = new Field(OwnerType.INSTANCE, Values.COMPANY_TRUSTEE.getOrdinal());
        public final Field INDIVIDUAL_TRUSTEE = new Field(OwnerType.INSTANCE, Values.INDIVIDUAL_TRUSTEE.getOrdinal());
        public final Field FIDUCIARIES = new Field(OwnerType.INSTANCE, Values.FIDUCIARIES.getOrdinal());
        public final Field TRUSTS = new Field(OwnerType.INSTANCE, Values.TRUSTS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NOMINEE("13"),
        NONPROFIT_ORGANIZATION("11"),
        CORPORATE_BODY("12"),
        PRIVATE_COMPANY("3"),
        PUBLIC_COMPANY("2"),
        INDIVIDUAL_INVESTOR("1"),
        NETWORKING_SUBACCOUNT("10"),
        CUSTODIAN_UNDER_GIFTS_TO_MINORS_ACT("7"),
        PENSION_PLAN("6"),
        COMPANY_TRUSTEE("5"),
        INDIVIDUAL_TRUSTEE("4"),
        FIDUCIARIES("9"),
        TRUSTS("8");

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
