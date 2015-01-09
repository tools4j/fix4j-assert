package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DeleteReason extends BaseFieldType {
    public static final DeleteReason INSTANCE = new DeleteReason();

    private DeleteReason() {
        super(
            "DeleteReason",
            285,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ERROR = new Field(DeleteReason.INSTANCE, Values.ERROR.getOrdinal());
        public final Field CANCELLATION__TRADE_BUST = new Field(DeleteReason.INSTANCE, Values.CANCELLATION__TRADE_BUST.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ERROR("1"),
        CANCELLATION__TRADE_BUST("0");

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
