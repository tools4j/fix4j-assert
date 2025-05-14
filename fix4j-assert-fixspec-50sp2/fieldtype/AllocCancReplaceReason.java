package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocCancReplaceReason extends BaseFieldType {
    public static final AllocCancReplaceReason INSTANCE = new AllocCancReplaceReason();

    private AllocCancReplaceReason() {
        super(
            "AllocCancReplaceReason",
            796,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CHANGE_IN_UNDERLYING_ORDER_DETAILS = new Field(AllocCancReplaceReason.INSTANCE, Values.CHANGE_IN_UNDERLYING_ORDER_DETAILS.getOrdinal());
        public final Field ORIGINAL_DETAILS_INCOMPLETEINCORRECT = new Field(AllocCancReplaceReason.INSTANCE, Values.ORIGINAL_DETAILS_INCOMPLETEINCORRECT.getOrdinal());
        public final Field OTHER = new Field(AllocCancReplaceReason.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CHANGE_IN_UNDERLYING_ORDER_DETAILS("2"),
        ORIGINAL_DETAILS_INCOMPLETEINCORRECT("1"),
        OTHER("99");

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
