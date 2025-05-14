package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class GapFillFlag extends BaseFieldType {
    public static final GapFillFlag INSTANCE = new GapFillFlag();

    private GapFillFlag() {
        super(
            "GapFillFlag",
            123,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SEQUENCE_RESET_IGNORE_MSG_SEQ_NUM_NA_FOR_FIXML__NOT_USED = new Field(GapFillFlag.INSTANCE, Values.SEQUENCE_RESET_IGNORE_MSG_SEQ_NUM_NA_FOR_FIXML__NOT_USED.getOrdinal());
        public final Field GAP_FILL_MESSAGE_MSG_SEQ_NUM_FIELD_VALID = new Field(GapFillFlag.INSTANCE, Values.GAP_FILL_MESSAGE_MSG_SEQ_NUM_FIELD_VALID.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SEQUENCE_RESET_IGNORE_MSG_SEQ_NUM_NA_FOR_FIXML__NOT_USED("N"),
        GAP_FILL_MESSAGE_MSG_SEQ_NUM_FIELD_VALID("Y");

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
