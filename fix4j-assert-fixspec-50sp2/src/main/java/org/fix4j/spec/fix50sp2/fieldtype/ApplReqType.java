package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ApplReqType extends BaseFieldType {
    public static final ApplReqType INSTANCE = new ApplReqType();

    private ApplReqType() {
        super(
            "ApplReqType",
            1347,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REQUEST_VALID_SET_OF_APPLICATIONS = new Field(ApplReqType.INSTANCE, Values.REQUEST_VALID_SET_OF_APPLICATIONS.getOrdinal());
        public final Field REQUEST_FOR_THE_LAST_APPLLASTSEQNUM_PUBLISHED_FOR_THE_SPECIFIED_ = new Field(ApplReqType.INSTANCE, Values.REQUEST_FOR_THE_LAST_APPLLASTSEQNUM_PUBLISHED_FOR_THE_SPECIFIED_.getOrdinal());
        public final Field SUBSCRIPTION_TO_THE_SPECIFIED_APPLICATIONS = new Field(ApplReqType.INSTANCE, Values.SUBSCRIPTION_TO_THE_SPECIFIED_APPLICATIONS.getOrdinal());
        public final Field RETRANSMISSION_OF_APPLICATION_MESSAGES_FOR_THE_SPECIFIED_APPLICA = new Field(ApplReqType.INSTANCE, Values.RETRANSMISSION_OF_APPLICATION_MESSAGES_FOR_THE_SPECIFIED_APPLICA.getOrdinal());
        public final Field CANCEL_RETRANSMISSION_AND_UNSUBSCRIBE_TO_THE_SPECIFIED_APPLICATI = new Field(ApplReqType.INSTANCE, Values.CANCEL_RETRANSMISSION_AND_UNSUBSCRIBE_TO_THE_SPECIFIED_APPLICATI.getOrdinal());
        public final Field CANCEL_RETRANSMISSION = new Field(ApplReqType.INSTANCE, Values.CANCEL_RETRANSMISSION.getOrdinal());
        public final Field UNSUBSCRIBE_TO_THE_SPECIFIED_APPLICATIONS = new Field(ApplReqType.INSTANCE, Values.UNSUBSCRIBE_TO_THE_SPECIFIED_APPLICATIONS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REQUEST_VALID_SET_OF_APPLICATIONS("3"),
        REQUEST_FOR_THE_LAST_APPLLASTSEQNUM_PUBLISHED_FOR_THE_SPECIFIED_("2"),
        SUBSCRIPTION_TO_THE_SPECIFIED_APPLICATIONS("1"),
        RETRANSMISSION_OF_APPLICATION_MESSAGES_FOR_THE_SPECIFIED_APPLICA("0"),
        CANCEL_RETRANSMISSION_AND_UNSUBSCRIBE_TO_THE_SPECIFIED_APPLICATI("6"),
        CANCEL_RETRANSMISSION("5"),
        UNSUBSCRIBE_TO_THE_SPECIFIED_APPLICATIONS("4");

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
