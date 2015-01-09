package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class Seniority extends BaseFieldType {
    public static final Seniority INSTANCE = new Seniority();

    private Seniority() {
        super(
            "Seniority",
            1450,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SENIOR_SECURED = new Field(Seniority.INSTANCE, Values.SENIOR_SECURED.getOrdinal());
        public final Field SENIOR = new Field(Seniority.INSTANCE, Values.SENIOR.getOrdinal());
        public final Field SUBORDINATED = new Field(Seniority.INSTANCE, Values.SUBORDINATED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SENIOR_SECURED("SD"),
        SENIOR("SR"),
        SUBORDINATED("SB");

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
