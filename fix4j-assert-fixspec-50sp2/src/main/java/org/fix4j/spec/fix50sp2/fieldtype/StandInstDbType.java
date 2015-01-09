package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StandInstDbType extends BaseFieldType {
    public static final StandInstDbType INSTANCE = new StandInstDbType();

    private StandInstDbType() {
        super(
            "StandInstDbType",
            169,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field A_GLOBAL_CUSTODIAN_STANDINSTDBNAME_70_MUST_BE_PROVIDED = new Field(StandInstDbType.INSTANCE, Values.A_GLOBAL_CUSTODIAN_STANDINSTDBNAME_70_MUST_BE_PROVIDED.getOrdinal());
        public final Field THOMSON_ALERT = new Field(StandInstDbType.INSTANCE, Values.THOMSON_ALERT.getOrdinal());
        public final Field DTC_SID = new Field(StandInstDbType.INSTANCE, Values.DTC_SID.getOrdinal());
        public final Field OTHER = new Field(StandInstDbType.INSTANCE, Values.OTHER.getOrdinal());
        public final Field ACCOUNTNET = new Field(StandInstDbType.INSTANCE, Values.ACCOUNTNET.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        A_GLOBAL_CUSTODIAN_STANDINSTDBNAME_70_MUST_BE_PROVIDED("3"),
        THOMSON_ALERT("2"),
        DTC_SID("1"),
        OTHER("0"),
        ACCOUNTNET("4");

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
