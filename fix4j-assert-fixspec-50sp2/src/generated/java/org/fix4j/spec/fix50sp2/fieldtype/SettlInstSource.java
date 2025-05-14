package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SettlInstSource extends BaseFieldType {
    public static final SettlInstSource INSTANCE = new SettlInstSource();

    private SettlInstSource() {
        super(
            "SettlInstSource",
            165,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INVESTOR_EG_CIV_USE = new Field(SettlInstSource.INSTANCE, Values.INVESTOR_EG_CIV_USE.getOrdinal());
        public final Field INSTITUTIONS_INSTRUCTIONS = new Field(SettlInstSource.INSTANCE, Values.INSTITUTIONS_INSTRUCTIONS.getOrdinal());
        public final Field BROKERS_INSTRUCTIONS = new Field(SettlInstSource.INSTANCE, Values.BROKERS_INSTRUCTIONS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INVESTOR_EG_CIV_USE("3"),
        INSTITUTIONS_INSTRUCTIONS("2"),
        BROKERS_INSTRUCTIONS("1");

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
