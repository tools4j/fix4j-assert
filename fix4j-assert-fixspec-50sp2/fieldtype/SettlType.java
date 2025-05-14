package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlType extends BaseFieldType {
    public static final SettlType INSTANCE = new SettlType();

    private SettlType() {
        super(
            "SettlType",
            63,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field T2 = new Field(SettlType.INSTANCE, Values.T2.getOrdinal());
        public final Field NEXT_DAY_TOM__T1 = new Field(SettlType.INSTANCE, Values.NEXT_DAY_TOM__T1.getOrdinal());
        public final Field CASH_TOD__T0 = new Field(SettlType.INSTANCE, Values.CASH_TOD__T0.getOrdinal());
        public final Field REGULAR__FX_SPOT_SETTLEMENT_T1_OR_T2_DEPENDING_ON_CURRENCY = new Field(SettlType.INSTANCE, Values.REGULAR__FX_SPOT_SETTLEMENT_T1_OR_T2_DEPENDING_ON_CURRENCY.getOrdinal());
        public final Field WHEN_AND_IF_ISSUED = new Field(SettlType.INSTANCE, Values.WHEN_AND_IF_ISSUED.getOrdinal());
        public final Field FUTURE = new Field(SettlType.INSTANCE, Values.FUTURE.getOrdinal());
        public final Field BROKEN_DATE__FOR_FX_EXPRESSING_NONSTANDARD_TENOR_SETTLDATE_64_MU = new Field(SettlType.INSTANCE, Values.BROKEN_DATE__FOR_FX_EXPRESSING_NONSTANDARD_TENOR_SETTLDATE_64_MU.getOrdinal());
        public final Field T4 = new Field(SettlType.INSTANCE, Values.T4.getOrdinal());
        public final Field FX_SPOT_NEXT_SETTLEMENT_SPOT1_AKA_NEXT_DAY = new Field(SettlType.INSTANCE, Values.FX_SPOT_NEXT_SETTLEMENT_SPOT1_AKA_NEXT_DAY.getOrdinal());
        public final Field T3 = new Field(SettlType.INSTANCE, Values.T3.getOrdinal());
        public final Field T5 = new Field(SettlType.INSTANCE, Values.T5.getOrdinal());
        public final Field SELLERS_OPTION = new Field(SettlType.INSTANCE, Values.SELLERS_OPTION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        T2("3"),
        NEXT_DAY_TOM__T1("2"),
        CASH_TOD__T0("1"),
        REGULAR__FX_SPOT_SETTLEMENT_T1_OR_T2_DEPENDING_ON_CURRENCY("0"),
        WHEN_AND_IF_ISSUED("7"),
        FUTURE("6"),
        BROKEN_DATE__FOR_FX_EXPRESSING_NONSTANDARD_TENOR_SETTLDATE_64_MU("B"),
        T4("5"),
        FX_SPOT_NEXT_SETTLEMENT_SPOT1_AKA_NEXT_DAY("C"),
        T3("4"),
        T5("9"),
        SELLERS_OPTION("8");

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
