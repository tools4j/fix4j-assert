package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MassActionResponse extends BaseFieldType {
    public static final MassActionResponse INSTANCE = new MassActionResponse();

    private MassActionResponse() {
        super(
            "MassActionResponse",
            1375,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ACCEPTED = new Field(MassActionResponse.INSTANCE, Values.ACCEPTED.getOrdinal());
        public final Field REJECTED__SEE_MASSACTIONREJECTREASON1376 = new Field(MassActionResponse.INSTANCE, Values.REJECTED__SEE_MASSACTIONREJECTREASON1376.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ACCEPTED("1"),
        REJECTED__SEE_MASSACTIONREJECTREASON1376("0");

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
