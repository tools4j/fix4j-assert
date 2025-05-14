package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SideMultiLegReportingType extends BaseFieldType {
    public static final SideMultiLegReportingType INSTANCE = new SideMultiLegReportingType();

    private SideMultiLegReportingType() {
        super(
            "SideMultiLegReportingType",
            752,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MULTILEG_SECURITY = new Field(SideMultiLegReportingType.INSTANCE, Values.MULTILEG_SECURITY.getOrdinal());
        public final Field INDIVIDUAL_LEG_OF_A_MULTILEG_SECURITY = new Field(SideMultiLegReportingType.INSTANCE, Values.INDIVIDUAL_LEG_OF_A_MULTILEG_SECURITY.getOrdinal());
        public final Field SINGLE_SECURITY_DEFAULT_IF_NOT_SPECIFIED = new Field(SideMultiLegReportingType.INSTANCE, Values.SINGLE_SECURITY_DEFAULT_IF_NOT_SPECIFIED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MULTILEG_SECURITY("3"),
        INDIVIDUAL_LEG_OF_A_MULTILEG_SECURITY("2"),
        SINGLE_SECURITY_DEFAULT_IF_NOT_SPECIFIED("1");

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
