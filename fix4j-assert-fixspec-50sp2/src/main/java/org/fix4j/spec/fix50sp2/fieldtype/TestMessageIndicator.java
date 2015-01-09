package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class TestMessageIndicator extends BaseFieldType {
    public static final TestMessageIndicator INSTANCE = new TestMessageIndicator();

    private TestMessageIndicator() {
        super(
            "TestMessageIndicator",
            464,
            FieldClassLookup.lookup("BOOLEAN"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field FALES_PRODUCTION = new Field(TestMessageIndicator.INSTANCE, Values.FALES_PRODUCTION.getOrdinal());
        public final Field TRUE_TEST = new Field(TestMessageIndicator.INSTANCE, Values.TRUE_TEST.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        FALES_PRODUCTION("N"),
        TRUE_TEST("Y");

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
