package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AcctIDSource extends BaseFieldType {
    public static final AcctIDSource INSTANCE = new AcctIDSource();

    private AcctIDSource() {
        super(
            "AcctIDSource",
            660,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TFM_GSPTA = new Field(AcctIDSource.INSTANCE, Values.TFM_GSPTA.getOrdinal());
        public final Field SID_CODE = new Field(AcctIDSource.INSTANCE, Values.SID_CODE.getOrdinal());
        public final Field BIC = new Field(AcctIDSource.INSTANCE, Values.BIC.getOrdinal());
        public final Field DTCC_CODE = new Field(AcctIDSource.INSTANCE, Values.DTCC_CODE.getOrdinal());
        public final Field OMGEO_ALERT_ID = new Field(AcctIDSource.INSTANCE, Values.OMGEO_ALERT_ID.getOrdinal());
        public final Field OTHER_CUSTOM_OR_PROPRIETARY = new Field(AcctIDSource.INSTANCE, Values.OTHER_CUSTOM_OR_PROPRIETARY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TFM_GSPTA("3"),
        SID_CODE("2"),
        BIC("1"),
        DTCC_CODE("5"),
        OMGEO_ALERT_ID("4"),
        OTHER_CUSTOM_OR_PROPRIETARY("99");

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
