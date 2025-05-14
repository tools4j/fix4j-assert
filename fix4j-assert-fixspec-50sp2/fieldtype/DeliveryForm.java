package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DeliveryForm extends BaseFieldType {
    public static final DeliveryForm INSTANCE = new DeliveryForm();

    private DeliveryForm() {
        super(
            "DeliveryForm",
            668,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field BEARER = new Field(DeliveryForm.INSTANCE, Values.BEARER.getOrdinal());
        public final Field BOOK_ENTRY_DEFAULT = new Field(DeliveryForm.INSTANCE, Values.BOOK_ENTRY_DEFAULT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        BEARER("2"),
        BOOK_ENTRY_DEFAULT("1");

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
