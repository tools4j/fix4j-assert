package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class PutOrCall extends BaseFieldType {
    public static final PutOrCall INSTANCE = new PutOrCall();

    private PutOrCall() {
        super(
            "PutOrCall",
            201,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field CALL = new Field(PutOrCall.INSTANCE, Values.CALL.getOrdinal());
        public final Field PUT = new Field(PutOrCall.INSTANCE, Values.PUT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        CALL("1"),
        PUT("0");

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
