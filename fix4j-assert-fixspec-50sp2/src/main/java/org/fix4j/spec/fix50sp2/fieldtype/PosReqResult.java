package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PosReqResult extends BaseFieldType {
    public static final PosReqResult INSTANCE = new PosReqResult();

    private PosReqResult() {
        super(
            "PosReqResult",
            728,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NOT_AUTHORIZED_TO_REQUEST_POSITIONS = new Field(PosReqResult.INSTANCE, Values.NOT_AUTHORIZED_TO_REQUEST_POSITIONS.getOrdinal());
        public final Field NO_POSITIONS_FOUND_THAT_MATCH_CRITERIA = new Field(PosReqResult.INSTANCE, Values.NO_POSITIONS_FOUND_THAT_MATCH_CRITERIA.getOrdinal());
        public final Field INVALID_OR_UNSUPPORTED_REQUEST = new Field(PosReqResult.INSTANCE, Values.INVALID_OR_UNSUPPORTED_REQUEST.getOrdinal());
        public final Field VALID_REQUEST = new Field(PosReqResult.INSTANCE, Values.VALID_REQUEST.getOrdinal());
        public final Field REQUEST_FOR_POSITION_NOT_SUPPORTED = new Field(PosReqResult.INSTANCE, Values.REQUEST_FOR_POSITION_NOT_SUPPORTED.getOrdinal());
        public final Field OTHER_USE_TEXT_58_IN_CONJUNCTION_WITH_THIS_CODE_FOR_AN_EXPLAINAT = new Field(PosReqResult.INSTANCE, Values.OTHER_USE_TEXT_58_IN_CONJUNCTION_WITH_THIS_CODE_FOR_AN_EXPLAINAT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NOT_AUTHORIZED_TO_REQUEST_POSITIONS("3"),
        NO_POSITIONS_FOUND_THAT_MATCH_CRITERIA("2"),
        INVALID_OR_UNSUPPORTED_REQUEST("1"),
        VALID_REQUEST("0"),
        REQUEST_FOR_POSITION_NOT_SUPPORTED("4"),
        OTHER_USE_TEXT_58_IN_CONJUNCTION_WITH_THIS_CODE_FOR_AN_EXPLAINAT("99");

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
