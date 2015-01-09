package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MultiLegRptTypeReq extends BaseFieldType {
    public static final MultiLegRptTypeReq INSTANCE = new MultiLegRptTypeReq();

    private MultiLegRptTypeReq() {
        super(
            "MultiLegRptTypeReq",
            563,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REPORT_BY_INSTRUMENT_LEGS_BELONGING_TO_THE_MULTILEG_SECURITY_ONL = new Field(MultiLegRptTypeReq.INSTANCE, Values.REPORT_BY_INSTRUMENT_LEGS_BELONGING_TO_THE_MULTILEG_SECURITY_ONL.getOrdinal());
        public final Field REPORT_BY_MULTILEG_SECURITY_AND_BY_INSTRUMENT_LEGS_BELONGING_TO_ = new Field(MultiLegRptTypeReq.INSTANCE, Values.REPORT_BY_MULTILEG_SECURITY_AND_BY_INSTRUMENT_LEGS_BELONGING_TO_.getOrdinal());
        public final Field REPORT_BY_MULITLEG_SECURITY_ONLY_DO_NOT_REPORT_LEGS = new Field(MultiLegRptTypeReq.INSTANCE, Values.REPORT_BY_MULITLEG_SECURITY_ONLY_DO_NOT_REPORT_LEGS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REPORT_BY_INSTRUMENT_LEGS_BELONGING_TO_THE_MULTILEG_SECURITY_ONL("2"),
        REPORT_BY_MULTILEG_SECURITY_AND_BY_INSTRUMENT_LEGS_BELONGING_TO_("1"),
        REPORT_BY_MULITLEG_SECURITY_ONLY_DO_NOT_REPORT_LEGS("0");

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
