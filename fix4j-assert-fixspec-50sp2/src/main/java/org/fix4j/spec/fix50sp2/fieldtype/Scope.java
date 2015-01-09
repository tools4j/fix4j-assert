package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class Scope extends BaseFieldType {
    public static final Scope INSTANCE = new Scope();

    private Scope() {
        super(
            "Scope",
            546,
            FieldClassLookup.lookup("MULTIPLECHARVALUE"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field GLOBAL = new Field(Scope.INSTANCE, Values.GLOBAL.getOrdinal());
        public final Field NATIONAL = new Field(Scope.INSTANCE, Values.NATIONAL.getOrdinal());
        public final Field LOCAL_MARKET_EXCHANGE_ECN_ATS = new Field(Scope.INSTANCE, Values.LOCAL_MARKET_EXCHANGE_ECN_ATS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        GLOBAL("3"),
        NATIONAL("2"),
        LOCAL_MARKET_EXCHANGE_ECN_ATS("1");

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
