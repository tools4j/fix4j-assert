package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class Benchmark extends BaseFieldType {
    public static final Benchmark INSTANCE = new Benchmark();

    private Benchmark() {
        super(
            "Benchmark",
            219,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field OLD5 = new Field(Benchmark.INSTANCE, Values.OLD5.getOrdinal());
        public final Field I5YR = new Field(Benchmark.INSTANCE, Values.I5YR.getOrdinal());
        public final Field CURVE = new Field(Benchmark.INSTANCE, Values.CURVE.getOrdinal());
        public final Field OLD30 = new Field(Benchmark.INSTANCE, Values.OLD30.getOrdinal());
        public final Field I30YR = new Field(Benchmark.INSTANCE, Values.I30YR.getOrdinal());
        public final Field OLD10 = new Field(Benchmark.INSTANCE, Values.OLD10.getOrdinal());
        public final Field I10YR = new Field(Benchmark.INSTANCE, Values.I10YR.getOrdinal());
        public final Field I6MOLIBOR = new Field(Benchmark.INSTANCE, Values.I6MOLIBOR.getOrdinal());
        public final Field I3MOLIBOR = new Field(Benchmark.INSTANCE, Values.I3MOLIBOR.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        OLD5("3"),
        I5YR("2"),
        CURVE("1"),
        OLD30("7"),
        I30YR("6"),
        OLD10("5"),
        I10YR("4"),
        I6MOLIBOR("9"),
        I3MOLIBOR("8");

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
