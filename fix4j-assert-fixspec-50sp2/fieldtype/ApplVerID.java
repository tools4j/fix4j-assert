package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class ApplVerID extends BaseFieldType {
    public static final ApplVerID INSTANCE = new ApplVerID();

    private ApplVerID() {
        super(
            "ApplVerID",
            1128,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FIX41 = new Field(ApplVerID.INSTANCE, Values.FIX41.getOrdinal());
        public final Field FIX40 = new Field(ApplVerID.INSTANCE, Values.FIX40.getOrdinal());
        public final Field FIX30 = new Field(ApplVerID.INSTANCE, Values.FIX30.getOrdinal());
        public final Field FIX27 = new Field(ApplVerID.INSTANCE, Values.FIX27.getOrdinal());
        public final Field FIX50 = new Field(ApplVerID.INSTANCE, Values.FIX50.getOrdinal());
        public final Field FIX44 = new Field(ApplVerID.INSTANCE, Values.FIX44.getOrdinal());
        public final Field FIX43 = new Field(ApplVerID.INSTANCE, Values.FIX43.getOrdinal());
        public final Field FIX42 = new Field(ApplVerID.INSTANCE, Values.FIX42.getOrdinal());
        public final Field FIX50SP2 = new Field(ApplVerID.INSTANCE, Values.FIX50SP2.getOrdinal());
        public final Field FIX50SP1 = new Field(ApplVerID.INSTANCE, Values.FIX50SP1.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FIX41("3"),
        FIX40("2"),
        FIX30("1"),
        FIX27("0"),
        FIX50("7"),
        FIX44("6"),
        FIX43("5"),
        FIX42("4"),
        FIX50SP2("9"),
        FIX50SP1("8");

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
