package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class LocateReqd extends BaseFieldType {
    public static final LocateReqd INSTANCE = new LocateReqd();

    private LocateReqd() {
        super(
            "LocateReqd",
            114,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INDICATES_THE_BROKER_IS_NOT_REQUIRED_TO_LOCATE = new Field(LocateReqd.INSTANCE, Values.INDICATES_THE_BROKER_IS_NOT_REQUIRED_TO_LOCATE.getOrdinal());
        public final Field INDICATES_THE_BROKER_IS_RESPONSIBLE_FOR_LOCATING_THE_STOCK = new Field(LocateReqd.INSTANCE, Values.INDICATES_THE_BROKER_IS_RESPONSIBLE_FOR_LOCATING_THE_STOCK.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INDICATES_THE_BROKER_IS_NOT_REQUIRED_TO_LOCATE("N"),
        INDICATES_THE_BROKER_IS_RESPONSIBLE_FOR_LOCATING_THE_STOCK("Y");

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
