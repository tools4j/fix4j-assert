package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RiskInstrumentOperator extends BaseFieldType {
    public static final RiskInstrumentOperator INSTANCE = new RiskInstrumentOperator();

    private RiskInstrumentOperator() {
        super(
            "RiskInstrumentOperator",
            1535,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field EXCLUDE = new Field(RiskInstrumentOperator.INSTANCE, Values.EXCLUDE.getOrdinal());
        public final Field INCLUDE = new Field(RiskInstrumentOperator.INSTANCE, Values.INCLUDE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        EXCLUDE("2"),
        INCLUDE("1");

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
