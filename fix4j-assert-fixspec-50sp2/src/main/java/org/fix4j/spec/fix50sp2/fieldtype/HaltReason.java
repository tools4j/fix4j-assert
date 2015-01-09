package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class HaltReason extends BaseFieldType {
    public static final HaltReason INSTANCE = new HaltReason();

    private HaltReason() {
        super(
            "HaltReason",
            327,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ADDITIONAL_INFORMATION = new Field(HaltReason.INSTANCE, Values.ADDITIONAL_INFORMATION.getOrdinal());
        public final Field ORDER_IMBALANCE = new Field(HaltReason.INSTANCE, Values.ORDER_IMBALANCE.getOrdinal());
        public final Field ORDER_INFLUX = new Field(HaltReason.INSTANCE, Values.ORDER_INFLUX.getOrdinal());
        public final Field NEWS_DISSEMINATION = new Field(HaltReason.INSTANCE, Values.NEWS_DISSEMINATION.getOrdinal());
        public final Field EQUIPMENT_CHANGEOVER = new Field(HaltReason.INSTANCE, Values.EQUIPMENT_CHANGEOVER.getOrdinal());
        public final Field NEWS_PENDING = new Field(HaltReason.INSTANCE, Values.NEWS_PENDING.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ADDITIONAL_INFORMATION("3"),
        ORDER_IMBALANCE("2"),
        ORDER_INFLUX("1"),
        NEWS_DISSEMINATION("0"),
        EQUIPMENT_CHANGEOVER("5"),
        NEWS_PENDING("4");

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
