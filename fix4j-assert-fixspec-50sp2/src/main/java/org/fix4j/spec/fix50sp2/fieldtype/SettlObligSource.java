package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlObligSource extends BaseFieldType {
    public static final SettlObligSource INSTANCE = new SettlObligSource();

    private SettlObligSource() {
        super(
            "SettlObligSource",
            1164,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INVESTOR = new Field(SettlObligSource.INSTANCE, Values.INVESTOR.getOrdinal());
        public final Field INSTRUCTIONS_FOR_INSTITUTION = new Field(SettlObligSource.INSTANCE, Values.INSTRUCTIONS_FOR_INSTITUTION.getOrdinal());
        public final Field INSTRUCTIONS_OF_BROKER = new Field(SettlObligSource.INSTANCE, Values.INSTRUCTIONS_OF_BROKER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INVESTOR("3"),
        INSTRUCTIONS_FOR_INSTITUTION("2"),
        INSTRUCTIONS_OF_BROKER("1");

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
