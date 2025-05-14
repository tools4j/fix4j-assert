package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class BenchmarkCurveName extends BaseFieldType {
    public static final BenchmarkCurveName INSTANCE = new BenchmarkCurveName();

    private BenchmarkCurveName() {
        super(
            "BenchmarkCurveName",
            221,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field SONIA = new Field(BenchmarkCurveName.INSTANCE, Values.SONIA.getOrdinal());
        public final Field TREASURY = new Field(BenchmarkCurveName.INSTANCE, Values.TREASURY.getOrdinal());
        public final Field OTHER = new Field(BenchmarkCurveName.INSTANCE, Values.OTHER.getOrdinal());
        public final Field LIBOR_LONDON_INTERBANK_OFFER = new Field(BenchmarkCurveName.INSTANCE, Values.LIBOR_LONDON_INTERBANK_OFFER.getOrdinal());
        public final Field PFANDBRIEFE = new Field(BenchmarkCurveName.INSTANCE, Values.PFANDBRIEFE.getOrdinal());
        public final Field SWAP = new Field(BenchmarkCurveName.INSTANCE, Values.SWAP.getOrdinal());
        public final Field LIBID = new Field(BenchmarkCurveName.INSTANCE, Values.LIBID.getOrdinal());
        public final Field MUNIAAA = new Field(BenchmarkCurveName.INSTANCE, Values.MUNIAAA.getOrdinal());
        public final Field EURIBOR = new Field(BenchmarkCurveName.INSTANCE, Values.EURIBOR.getOrdinal());
        public final Field EUREPO = new Field(BenchmarkCurveName.INSTANCE, Values.EUREPO.getOrdinal());
        public final Field FUTURESWAP = new Field(BenchmarkCurveName.INSTANCE, Values.FUTURESWAP.getOrdinal());
        public final Field EONIA = new Field(BenchmarkCurveName.INSTANCE, Values.EONIA.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        SONIA("SONIA"),
        TREASURY("Treasury"),
        OTHER("OTHER"),
        LIBOR_LONDON_INTERBANK_OFFER("LIBOR"),
        PFANDBRIEFE("Pfandbriefe"),
        SWAP("SWAP"),
        LIBID("LIBID"),
        MUNIAAA("MuniAAA"),
        EURIBOR("Euribor"),
        EUREPO("EUREPO"),
        FUTURESWAP("FutureSWAP"),
        EONIA("EONIA");

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
