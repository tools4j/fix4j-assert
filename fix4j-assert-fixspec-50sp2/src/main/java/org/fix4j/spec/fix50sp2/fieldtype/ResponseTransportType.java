package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ResponseTransportType extends BaseFieldType {
    public static final ResponseTransportType INSTANCE = new ResponseTransportType();

    private ResponseTransportType() {
        super(
            "ResponseTransportType",
            725,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field OUT_OF_BAND__PREARRANGED_OUTOFBAND_DELIVERY_MECHANIZM_IE_FTP_HTT = new Field(ResponseTransportType.INSTANCE, Values.OUT_OF_BAND__PREARRANGED_OUTOFBAND_DELIVERY_MECHANIZM_IE_FTP_HTT.getOrdinal());
        public final Field INBAND__TRANSPORT_THE_REQUEST_WAS_SENT_OVER_DEFAULT = new Field(ResponseTransportType.INSTANCE, Values.INBAND__TRANSPORT_THE_REQUEST_WAS_SENT_OVER_DEFAULT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        OUT_OF_BAND__PREARRANGED_OUTOFBAND_DELIVERY_MECHANIZM_IE_FTP_HTT("1"),
        INBAND__TRANSPORT_THE_REQUEST_WAS_SENT_OVER_DEFAULT("0");

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
