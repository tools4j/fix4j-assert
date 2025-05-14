package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityRequestResult extends BaseFieldType {
    public static final SecurityRequestResult INSTANCE = new SecurityRequestResult();

    private SecurityRequestResult() {
        super(
            "SecurityRequestResult",
            560,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NOT_AUTHORIZED_TO_RETRIEVE_INSTRUMENT_DATA = new Field(SecurityRequestResult.INSTANCE, Values.NOT_AUTHORIZED_TO_RETRIEVE_INSTRUMENT_DATA.getOrdinal());
        public final Field NO_INSTRUMENTS_FOUND_THAT_MATCH_SELECTION_CRITERIA = new Field(SecurityRequestResult.INSTANCE, Values.NO_INSTRUMENTS_FOUND_THAT_MATCH_SELECTION_CRITERIA.getOrdinal());
        public final Field INVALID_OR_UNSUPPORTED_REQUEST = new Field(SecurityRequestResult.INSTANCE, Values.INVALID_OR_UNSUPPORTED_REQUEST.getOrdinal());
        public final Field VALID_REQUEST = new Field(SecurityRequestResult.INSTANCE, Values.VALID_REQUEST.getOrdinal());
        public final Field REQUEST_FOR_INSTRUMENT_DATA_NOT_SUPPORTED = new Field(SecurityRequestResult.INSTANCE, Values.REQUEST_FOR_INSTRUMENT_DATA_NOT_SUPPORTED.getOrdinal());
        public final Field INSTRUMENT_DATA_TEMPORARILY_UNAVAILABLE = new Field(SecurityRequestResult.INSTANCE, Values.INSTRUMENT_DATA_TEMPORARILY_UNAVAILABLE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NOT_AUTHORIZED_TO_RETRIEVE_INSTRUMENT_DATA("3"),
        NO_INSTRUMENTS_FOUND_THAT_MATCH_SELECTION_CRITERIA("2"),
        INVALID_OR_UNSUPPORTED_REQUEST("1"),
        VALID_REQUEST("0"),
        REQUEST_FOR_INSTRUMENT_DATA_NOT_SUPPORTED("5"),
        INSTRUMENT_DATA_TEMPORARILY_UNAVAILABLE("4");

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
