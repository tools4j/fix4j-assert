package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ContingencyType extends BaseFieldType {
    public static final ContingencyType INSTANCE = new ContingencyType();

    private ContingencyType() {
        super(
            "ContingencyType",
            1385,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ONE_UPDATES_THE_OTHER_OUO__ABSOLUTE_QUANTITY_REDUCTION = new Field(ContingencyType.INSTANCE, Values.ONE_UPDATES_THE_OTHER_OUO__ABSOLUTE_QUANTITY_REDUCTION.getOrdinal());
        public final Field ONE_TRIGGERS_THE_OTHER_OTO = new Field(ContingencyType.INSTANCE, Values.ONE_TRIGGERS_THE_OTHER_OTO.getOrdinal());
        public final Field ONE_CANCELS_THE_OTHER_OCO = new Field(ContingencyType.INSTANCE, Values.ONE_CANCELS_THE_OTHER_OCO.getOrdinal());
        public final Field ONE_UPDATES_THE_OTHER_OUO__PROPORTIONAL_QUANTITY_REDUCTION = new Field(ContingencyType.INSTANCE, Values.ONE_UPDATES_THE_OTHER_OUO__PROPORTIONAL_QUANTITY_REDUCTION.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ONE_UPDATES_THE_OTHER_OUO__ABSOLUTE_QUANTITY_REDUCTION("3"),
        ONE_TRIGGERS_THE_OTHER_OTO("2"),
        ONE_CANCELS_THE_OTHER_OCO("1"),
        ONE_UPDATES_THE_OTHER_OUO__PROPORTIONAL_QUANTITY_REDUCTION("4");

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
