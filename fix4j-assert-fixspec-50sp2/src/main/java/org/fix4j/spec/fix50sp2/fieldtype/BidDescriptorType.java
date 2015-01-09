package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class BidDescriptorType extends BaseFieldType {
    public static final BidDescriptorType INSTANCE = new BidDescriptorType();

    private BidDescriptorType() {
        super(
            "BidDescriptorType",
            399,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INDEX = new Field(BidDescriptorType.INSTANCE, Values.INDEX.getOrdinal());
        public final Field COUNTRY = new Field(BidDescriptorType.INSTANCE, Values.COUNTRY.getOrdinal());
        public final Field SECTOR = new Field(BidDescriptorType.INSTANCE, Values.SECTOR.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INDEX("3"),
        COUNTRY("2"),
        SECTOR("1");

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
