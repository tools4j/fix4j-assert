package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class DeskType extends BaseFieldType {
    public static final DeskType INSTANCE = new DeskType();

    private DeskType() {
        super(
            "DeskType",
            1033,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PROGRAM_TRADING = new Field(DeskType.INSTANCE, Values.PROGRAM_TRADING.getOrdinal());
        public final Field DERIVATIVES = new Field(DeskType.INSTANCE, Values.DERIVATIVES.getOrdinal());
        public final Field TRADING = new Field(DeskType.INSTANCE, Values.TRADING.getOrdinal());
        public final Field ARBITRAGE = new Field(DeskType.INSTANCE, Values.ARBITRAGE.getOrdinal());
        public final Field INTERNATIONAL = new Field(DeskType.INSTANCE, Values.INTERNATIONAL.getOrdinal());
        public final Field AGENCY = new Field(DeskType.INSTANCE, Values.AGENCY.getOrdinal());
        public final Field SALES = new Field(DeskType.INSTANCE, Values.SALES.getOrdinal());
        public final Field PROPRIETARY = new Field(DeskType.INSTANCE, Values.PROPRIETARY.getOrdinal());
        public final Field PREFERRED_TRADING = new Field(DeskType.INSTANCE, Values.PREFERRED_TRADING.getOrdinal());
        public final Field INSTITUTIONAL = new Field(DeskType.INSTANCE, Values.INSTITUTIONAL.getOrdinal());
        public final Field OTHER = new Field(DeskType.INSTANCE, Values.OTHER.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PROGRAM_TRADING("PT"),
        DERIVATIVES("D"),
        TRADING("T"),
        ARBITRAGE("AR"),
        INTERNATIONAL("IN"),
        AGENCY("A"),
        SALES("S"),
        PROPRIETARY("PR"),
        PREFERRED_TRADING("PF"),
        INSTITUTIONAL("IS"),
        OTHER("O");

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
