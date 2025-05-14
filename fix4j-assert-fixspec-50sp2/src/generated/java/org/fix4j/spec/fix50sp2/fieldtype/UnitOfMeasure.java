package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class UnitOfMeasure extends BaseFieldType {
    public static final UnitOfMeasure INSTANCE = new UnitOfMeasure();

    private UnitOfMeasure() {
        super(
            "UnitOfMeasure",
            996,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TONS_US = new Field(UnitOfMeasure.INSTANCE, Values.TONS_US.getOrdinal());
        public final Field GALLONS = new Field(UnitOfMeasure.INSTANCE, Values.GALLONS.getOrdinal());
        public final Field BUSHELS = new Field(UnitOfMeasure.INSTANCE, Values.BUSHELS.getOrdinal());
        public final Field MEGAWATT_HOURS = new Field(UnitOfMeasure.INSTANCE, Values.MEGAWATT_HOURS.getOrdinal());
        public final Field ONE_MILLION_BTU = new Field(UnitOfMeasure.INSTANCE, Values.ONE_MILLION_BTU.getOrdinal());
        public final Field ALLOWANCES = new Field(UnitOfMeasure.INSTANCE, Values.ALLOWANCES.getOrdinal());
        public final Field MILLION_BARRELS = new Field(UnitOfMeasure.INSTANCE, Values.MILLION_BARRELS.getOrdinal());
        public final Field METRIC_TONS_AKA_TONNE = new Field(UnitOfMeasure.INSTANCE, Values.METRIC_TONS_AKA_TONNE.getOrdinal());
        public final Field BARRELS = new Field(UnitOfMeasure.INSTANCE, Values.BARRELS.getOrdinal());
        public final Field US_DOLLARS = new Field(UnitOfMeasure.INSTANCE, Values.US_DOLLARS.getOrdinal());
        public final Field TROY_OUNCES = new Field(UnitOfMeasure.INSTANCE, Values.TROY_OUNCES.getOrdinal());
        public final Field POUNDS = new Field(UnitOfMeasure.INSTANCE, Values.POUNDS.getOrdinal());
        public final Field BILLION_CUBIC_FEET = new Field(UnitOfMeasure.INSTANCE, Values.BILLION_CUBIC_FEET.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TONS_US("tn"),
        GALLONS("Gal"),
        BUSHELS("Bu"),
        MEGAWATT_HOURS("MWh"),
        ONE_MILLION_BTU("MMBtu"),
        ALLOWANCES("Alw"),
        MILLION_BARRELS("MMbbl"),
        METRIC_TONS_AKA_TONNE("t"),
        BARRELS("Bbl"),
        US_DOLLARS("USD"),
        TROY_OUNCES("oz_tr"),
        POUNDS("lbs"),
        BILLION_CUBIC_FEET("Bcf");

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
