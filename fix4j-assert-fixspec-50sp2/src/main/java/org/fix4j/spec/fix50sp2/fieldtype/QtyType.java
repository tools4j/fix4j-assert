package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class QtyType extends BaseFieldType {
    public static final QtyType INSTANCE = new QtyType();

    private QtyType() {
        super(
            "QtyType",
            854,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field UNITS_OF_MEASURE_PER_TIME_UNIT_IF_USED__MUST_SPECIFY_UNITOFMEASU = new Field(QtyType.INSTANCE, Values.UNITS_OF_MEASURE_PER_TIME_UNIT_IF_USED__MUST_SPECIFY_UNITOFMEASU.getOrdinal());
        public final Field CONTRACTS_IF_USED__MUST_SPECIFY_CONTRACTMULTIPLIER_TAG_231 = new Field(QtyType.INSTANCE, Values.CONTRACTS_IF_USED__MUST_SPECIFY_CONTRACTMULTIPLIER_TAG_231.getOrdinal());
        public final Field UNITS_SHARES_PAR_CURRENCY = new Field(QtyType.INSTANCE, Values.UNITS_SHARES_PAR_CURRENCY.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        UNITS_OF_MEASURE_PER_TIME_UNIT_IF_USED__MUST_SPECIFY_UNITOFMEASU("2"),
        CONTRACTS_IF_USED__MUST_SPECIFY_CONTRACTMULTIPLIER_TAG_231("1"),
        UNITS_SHARES_PAR_CURRENCY("0");

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
