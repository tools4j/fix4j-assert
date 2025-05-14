package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocIntermedReqType extends BaseFieldType {
    public static final AllocIntermedReqType INSTANCE = new AllocIntermedReqType();

    private AllocIntermedReqType() {
        super(
            "AllocIntermedReqType",
            808,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PENDING_REVERSAL = new Field(AllocIntermedReqType.INSTANCE, Values.PENDING_REVERSAL.getOrdinal());
        public final Field PENDING_RELEASE = new Field(AllocIntermedReqType.INSTANCE, Values.PENDING_RELEASE.getOrdinal());
        public final Field PENDING_ACCEPT = new Field(AllocIntermedReqType.INSTANCE, Values.PENDING_ACCEPT.getOrdinal());
        public final Field ACCOUNT_LEVEL_REJECT = new Field(AllocIntermedReqType.INSTANCE, Values.ACCOUNT_LEVEL_REJECT.getOrdinal());
        public final Field BLOCK_LEVEL_REJECT = new Field(AllocIntermedReqType.INSTANCE, Values.BLOCK_LEVEL_REJECT.getOrdinal());
        public final Field ACCEPT = new Field(AllocIntermedReqType.INSTANCE, Values.ACCEPT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PENDING_REVERSAL("3"),
        PENDING_RELEASE("2"),
        PENDING_ACCEPT("1"),
        ACCOUNT_LEVEL_REJECT("6"),
        BLOCK_LEVEL_REJECT("5"),
        ACCEPT("4");

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
