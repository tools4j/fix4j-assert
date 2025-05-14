package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MatchStatus extends BaseFieldType {
    public static final MatchStatus INSTANCE = new MatchStatus();

    private MatchStatus() {
        super(
            "MatchStatus",
            573,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ADVISORY_OR_ALERT = new Field(MatchStatus.INSTANCE, Values.ADVISORY_OR_ALERT.getOrdinal());
        public final Field UNCOMPARED_UNMATCHED_OR_UNAFFIRMED = new Field(MatchStatus.INSTANCE, Values.UNCOMPARED_UNMATCHED_OR_UNAFFIRMED.getOrdinal());
        public final Field COMPARED_MATCHED_OR_AFFIRMED = new Field(MatchStatus.INSTANCE, Values.COMPARED_MATCHED_OR_AFFIRMED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ADVISORY_OR_ALERT("2"),
        UNCOMPARED_UNMATCHED_OR_UNAFFIRMED("1"),
        COMPARED_MATCHED_OR_AFFIRMED("0");

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
