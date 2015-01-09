package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class FundRenewWaiv extends BaseFieldType {
    public static final FundRenewWaiv INSTANCE = new FundRenewWaiv();

    private FundRenewWaiv() {
        super(
            "FundRenewWaiv",
            497,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NO = new Field(FundRenewWaiv.INSTANCE, Values.NO.getOrdinal());
        public final Field YES = new Field(FundRenewWaiv.INSTANCE, Values.YES.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NO("N"),
        YES("Y");

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
