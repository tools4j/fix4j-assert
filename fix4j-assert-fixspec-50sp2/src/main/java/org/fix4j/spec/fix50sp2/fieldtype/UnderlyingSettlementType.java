package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class UnderlyingSettlementType extends BaseFieldType {
    public static final UnderlyingSettlementType INSTANCE = new UnderlyingSettlementType();

    private UnderlyingSettlementType() {
        super(
            "UnderlyingSettlementType",
            975,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field T1 = new Field(UnderlyingSettlementType.INSTANCE, Values.T1.getOrdinal());
        public final Field T4 = new Field(UnderlyingSettlementType.INSTANCE, Values.T4.getOrdinal());
        public final Field T3 = new Field(UnderlyingSettlementType.INSTANCE, Values.T3.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        T1("2"),
        T4("5"),
        T3("4");

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
