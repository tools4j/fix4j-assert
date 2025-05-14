package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CollInquiryStatus extends BaseFieldType {
    public static final CollInquiryStatus INSTANCE = new CollInquiryStatus();

    private CollInquiryStatus() {
        super(
            "CollInquiryStatus",
            945,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field COMPLETED_WITH_WARNINGS = new Field(CollInquiryStatus.INSTANCE, Values.COMPLETED_WITH_WARNINGS.getOrdinal());
        public final Field COMPLETED = new Field(CollInquiryStatus.INSTANCE, Values.COMPLETED.getOrdinal());
        public final Field ACCEPTED_WITH_WARNINGS = new Field(CollInquiryStatus.INSTANCE, Values.ACCEPTED_WITH_WARNINGS.getOrdinal());
        public final Field ACCEPTED = new Field(CollInquiryStatus.INSTANCE, Values.ACCEPTED.getOrdinal());
        public final Field REJECTED = new Field(CollInquiryStatus.INSTANCE, Values.REJECTED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        COMPLETED_WITH_WARNINGS("3"),
        COMPLETED("2"),
        ACCEPTED_WITH_WARNINGS("1"),
        ACCEPTED("0"),
        REJECTED("4");

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
