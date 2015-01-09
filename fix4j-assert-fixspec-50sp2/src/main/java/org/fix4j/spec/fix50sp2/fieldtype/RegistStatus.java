package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RegistStatus extends BaseFieldType {
    public static final RegistStatus INSTANCE = new RegistStatus();

    private RegistStatus() {
        super(
            "RegistStatus",
            506,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ACCEPTED = new Field(RegistStatus.INSTANCE, Values.ACCEPTED.getOrdinal());
        public final Field REJECTED = new Field(RegistStatus.INSTANCE, Values.REJECTED.getOrdinal());
        public final Field REMINDER__IE_REGISTRATION_INSTRUCTIONS_ARE_STILL_OUTSTANDING = new Field(RegistStatus.INSTANCE, Values.REMINDER__IE_REGISTRATION_INSTRUCTIONS_ARE_STILL_OUTSTANDING.getOrdinal());
        public final Field HELD = new Field(RegistStatus.INSTANCE, Values.HELD.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ACCEPTED("A"),
        REJECTED("R"),
        REMINDER__IE_REGISTRATION_INSTRUCTIONS_ARE_STILL_OUTSTANDING("N"),
        HELD("H");

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
