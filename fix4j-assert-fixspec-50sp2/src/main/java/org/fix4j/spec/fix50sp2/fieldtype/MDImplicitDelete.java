package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MDImplicitDelete extends BaseFieldType {
    public static final MDImplicitDelete INSTANCE = new MDImplicitDelete();

    private MDImplicitDelete() {
        super(
            "MDImplicitDelete",
            547,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SERVER_MUST_SEND_AN_EXPLICIT_DELETE_FOR_BIDS_OR_OFFERS_FALLING_O = new Field(MDImplicitDelete.INSTANCE, Values.SERVER_MUST_SEND_AN_EXPLICIT_DELETE_FOR_BIDS_OR_OFFERS_FALLING_O.getOrdinal());
        public final Field CLIENT_HAS_RESPONSIBILITY_FOR_IMPLICITLY_DELETING_BIDS_OR_OFFERS = new Field(MDImplicitDelete.INSTANCE, Values.CLIENT_HAS_RESPONSIBILITY_FOR_IMPLICITLY_DELETING_BIDS_OR_OFFERS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SERVER_MUST_SEND_AN_EXPLICIT_DELETE_FOR_BIDS_OR_OFFERS_FALLING_O("N"),
        CLIENT_HAS_RESPONSIBILITY_FOR_IMPLICITLY_DELETING_BIDS_OR_OFFERS("Y");

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
