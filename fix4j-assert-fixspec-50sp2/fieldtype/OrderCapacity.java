package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class OrderCapacity extends BaseFieldType {
    public static final OrderCapacity INSTANCE = new OrderCapacity();

    private OrderCapacity() {
        super(
            "OrderCapacity",
            528,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field AGENT_FOR_OTHER_MEMBER = new Field(OrderCapacity.INSTANCE, Values.AGENT_FOR_OTHER_MEMBER.getOrdinal());
        public final Field PROPRIETARY = new Field(OrderCapacity.INSTANCE, Values.PROPRIETARY.getOrdinal());
        public final Field PRINCIPAL_NOTE_FOR_CMS_PURPOSES_PRINCIPAL_INCLUDES_PROPRIETARY = new Field(OrderCapacity.INSTANCE, Values.PRINCIPAL_NOTE_FOR_CMS_PURPOSES_PRINCIPAL_INCLUDES_PROPRIETARY.getOrdinal());
        public final Field AGENCY = new Field(OrderCapacity.INSTANCE, Values.AGENCY.getOrdinal());
        public final Field RISKLESS_PRINCIPAL = new Field(OrderCapacity.INSTANCE, Values.RISKLESS_PRINCIPAL.getOrdinal());
        public final Field INDIVIDUAL = new Field(OrderCapacity.INSTANCE, Values.INDIVIDUAL.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        AGENT_FOR_OTHER_MEMBER("W"),
        PROPRIETARY("G"),
        PRINCIPAL_NOTE_FOR_CMS_PURPOSES_PRINCIPAL_INCLUDES_PROPRIETARY("P"),
        AGENCY("A"),
        RISKLESS_PRINCIPAL("R"),
        INDIVIDUAL("I");

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
