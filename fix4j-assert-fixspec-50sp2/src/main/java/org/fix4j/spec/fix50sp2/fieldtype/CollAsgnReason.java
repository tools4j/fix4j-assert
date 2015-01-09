package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CollAsgnReason extends BaseFieldType {
    public static final CollAsgnReason INSTANCE = new CollAsgnReason();

    private CollAsgnReason() {
        super(
            "CollAsgnReason",
            895,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field MARGIN_DEFICIENCY = new Field(CollAsgnReason.INSTANCE, Values.MARGIN_DEFICIENCY.getOrdinal());
        public final Field TIME_WARNING = new Field(CollAsgnReason.INSTANCE, Values.TIME_WARNING.getOrdinal());
        public final Field SCHEDULED = new Field(CollAsgnReason.INSTANCE, Values.SCHEDULED.getOrdinal());
        public final Field INITIAL = new Field(CollAsgnReason.INSTANCE, Values.INITIAL.getOrdinal());
        public final Field ADVERSE_TAX_EVENT = new Field(CollAsgnReason.INSTANCE, Values.ADVERSE_TAX_EVENT.getOrdinal());
        public final Field EVENT_OF_DEFAULT = new Field(CollAsgnReason.INSTANCE, Values.EVENT_OF_DEFAULT.getOrdinal());
        public final Field FORWARD_COLLATERAL_DEMAND = new Field(CollAsgnReason.INSTANCE, Values.FORWARD_COLLATERAL_DEMAND.getOrdinal());
        public final Field MARGIN_EXCESS = new Field(CollAsgnReason.INSTANCE, Values.MARGIN_EXCESS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        MARGIN_DEFICIENCY("3"),
        TIME_WARNING("2"),
        SCHEDULED("1"),
        INITIAL("0"),
        ADVERSE_TAX_EVENT("7"),
        EVENT_OF_DEFAULT("6"),
        FORWARD_COLLATERAL_DEMAND("5"),
        MARGIN_EXCESS("4");

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
