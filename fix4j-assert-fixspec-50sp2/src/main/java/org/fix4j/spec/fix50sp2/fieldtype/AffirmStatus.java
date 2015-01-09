package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AffirmStatus extends BaseFieldType {
    public static final AffirmStatus INSTANCE = new AffirmStatus();

    private AffirmStatus() {
        super(
            "AffirmStatus",
            940,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field AFFIRMED = new Field(AffirmStatus.INSTANCE, Values.AFFIRMED.getOrdinal());
        public final Field CONFIRM_REJECTED_IE_NOT_AFFIRMED = new Field(AffirmStatus.INSTANCE, Values.CONFIRM_REJECTED_IE_NOT_AFFIRMED.getOrdinal());
        public final Field RECEIVED = new Field(AffirmStatus.INSTANCE, Values.RECEIVED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        AFFIRMED("3"),
        CONFIRM_REJECTED_IE_NOT_AFFIRMED("2"),
        RECEIVED("1");

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
