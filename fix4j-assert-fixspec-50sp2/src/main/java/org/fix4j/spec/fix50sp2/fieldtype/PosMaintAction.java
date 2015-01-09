package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PosMaintAction extends BaseFieldType {
    public static final PosMaintAction INSTANCE = new PosMaintAction();

    private PosMaintAction() {
        super(
            "PosMaintAction",
            712,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CANCEL__USED_TO_REMOVE_THE_OVERALL_TRANSACTION_OR_SPECIFIC_ADD_M = new Field(PosMaintAction.INSTANCE, Values.CANCEL__USED_TO_REMOVE_THE_OVERALL_TRANSACTION_OR_SPECIFIC_ADD_M.getOrdinal());
        public final Field REPLACE__USED_TO_OVERRIDE_THE_OVERALL_TRANSACTION_QUANTITY_OR_SP = new Field(PosMaintAction.INSTANCE, Values.REPLACE__USED_TO_OVERRIDE_THE_OVERALL_TRANSACTION_QUANTITY_OR_SP.getOrdinal());
        public final Field NEW__USED_TO_INCREMENT_THE_OVERALL_TRANSACTION_QUANTITY = new Field(PosMaintAction.INSTANCE, Values.NEW__USED_TO_INCREMENT_THE_OVERALL_TRANSACTION_QUANTITY.getOrdinal());
        public final Field REVERSE__USED_TO_COMPLETELLY_BACKOUT_THE_TRANSACTION_SUCH_THAT_T = new Field(PosMaintAction.INSTANCE, Values.REVERSE__USED_TO_COMPLETELLY_BACKOUT_THE_TRANSACTION_SUCH_THAT_T.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CANCEL__USED_TO_REMOVE_THE_OVERALL_TRANSACTION_OR_SPECIFIC_ADD_M("3"),
        REPLACE__USED_TO_OVERRIDE_THE_OVERALL_TRANSACTION_QUANTITY_OR_SP("2"),
        NEW__USED_TO_INCREMENT_THE_OVERALL_TRANSACTION_QUANTITY("1"),
        REVERSE__USED_TO_COMPLETELLY_BACKOUT_THE_TRANSACTION_SUCH_THAT_T("4");

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
