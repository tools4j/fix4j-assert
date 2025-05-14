package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CollAsgnRespType extends BaseFieldType {
    public static final CollAsgnRespType INSTANCE = new CollAsgnRespType();

    private CollAsgnRespType() {
        super(
            "CollAsgnRespType",
            905,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REJECTED = new Field(CollAsgnRespType.INSTANCE, Values.REJECTED.getOrdinal());
        public final Field DECLINED = new Field(CollAsgnRespType.INSTANCE, Values.DECLINED.getOrdinal());
        public final Field ACCEPTED = new Field(CollAsgnRespType.INSTANCE, Values.ACCEPTED.getOrdinal());
        public final Field RECEIVED = new Field(CollAsgnRespType.INSTANCE, Values.RECEIVED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REJECTED("3"),
        DECLINED("2"),
        ACCEPTED("1"),
        RECEIVED("0");

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
