package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TriggerAction extends BaseFieldType {
    public static final TriggerAction INSTANCE = new TriggerAction();

    private TriggerAction() {
        super(
            "TriggerAction",
            1101,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CANCEL = new Field(TriggerAction.INSTANCE, Values.CANCEL.getOrdinal());
        public final Field MODIFY = new Field(TriggerAction.INSTANCE, Values.MODIFY.getOrdinal());
        public final Field ACTIVATE = new Field(TriggerAction.INSTANCE, Values.ACTIVATE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CANCEL("3"),
        MODIFY("2"),
        ACTIVATE("1");

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
