package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class UnderlyingFXRateCalc extends BaseFieldType {
    public static final UnderlyingFXRateCalc INSTANCE = new UnderlyingFXRateCalc();

    private UnderlyingFXRateCalc() {
        super(
            "UnderlyingFXRateCalc",
            1046,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field DIVIDE = new Field(UnderlyingFXRateCalc.INSTANCE, Values.DIVIDE.getOrdinal());
        public final Field MULTIPLY = new Field(UnderlyingFXRateCalc.INSTANCE, Values.MULTIPLY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        DIVIDE("D"),
        MULTIPLY("M");

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
