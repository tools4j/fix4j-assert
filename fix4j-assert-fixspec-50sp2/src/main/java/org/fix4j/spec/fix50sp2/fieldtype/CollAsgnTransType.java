package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CollAsgnTransType extends BaseFieldType {
    public static final CollAsgnTransType INSTANCE = new CollAsgnTransType();

    private CollAsgnTransType() {
        super(
            "CollAsgnTransType",
            903,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field RELEASE = new Field(CollAsgnTransType.INSTANCE, Values.RELEASE.getOrdinal());
        public final Field CANCEL = new Field(CollAsgnTransType.INSTANCE, Values.CANCEL.getOrdinal());
        public final Field REPLACE = new Field(CollAsgnTransType.INSTANCE, Values.REPLACE.getOrdinal());
        public final Field NEW = new Field(CollAsgnTransType.INSTANCE, Values.NEW.getOrdinal());
        public final Field REVERSE = new Field(CollAsgnTransType.INSTANCE, Values.REVERSE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        RELEASE("3"),
        CANCEL("2"),
        REPLACE("1"),
        NEW("0"),
        REVERSE("4");

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
