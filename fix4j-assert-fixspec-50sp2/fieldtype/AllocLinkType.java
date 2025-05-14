package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocLinkType extends BaseFieldType {
    public static final AllocLinkType INSTANCE = new AllocLinkType();

    private AllocLinkType() {
        super(
            "AllocLinkType",
            197,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FX_SWAP = new Field(AllocLinkType.INSTANCE, Values.FX_SWAP.getOrdinal());
        public final Field FX_NETTING = new Field(AllocLinkType.INSTANCE, Values.FX_NETTING.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FX_SWAP("1"),
        FX_NETTING("0");

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
