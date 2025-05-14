package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AggressorIndicator extends BaseFieldType {
    public static final AggressorIndicator INSTANCE = new AggressorIndicator();

    private AggressorIndicator() {
        super(
            "AggressorIndicator",
            1057,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ORDER_INITIATOR_IS_PASSIVE = new Field(AggressorIndicator.INSTANCE, Values.ORDER_INITIATOR_IS_PASSIVE.getOrdinal());
        public final Field ORDER_INITIATOR_IS_AGGRESSOR = new Field(AggressorIndicator.INSTANCE, Values.ORDER_INITIATOR_IS_AGGRESSOR.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ORDER_INITIATOR_IS_PASSIVE("N"),
        ORDER_INITIATOR_IS_AGGRESSOR("Y");

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
