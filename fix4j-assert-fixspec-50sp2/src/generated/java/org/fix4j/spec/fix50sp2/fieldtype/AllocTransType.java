package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class AllocTransType extends BaseFieldType {
    public static final AllocTransType INSTANCE = new AllocTransType();

    private AllocTransType() {
        super(
            "AllocTransType",
            71,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field PRELIMINARY_WITHOUT_MISCFEES_AND_NETMONEY_REMOVEDREPLACED = new Field(AllocTransType.INSTANCE, Values.PRELIMINARY_WITHOUT_MISCFEES_AND_NETMONEY_REMOVEDREPLACED.getOrdinal());
        public final Field CANCEL = new Field(AllocTransType.INSTANCE, Values.CANCEL.getOrdinal());
        public final Field REPLACE = new Field(AllocTransType.INSTANCE, Values.REPLACE.getOrdinal());
        public final Field NEW = new Field(AllocTransType.INSTANCE, Values.NEW.getOrdinal());
        public final Field REVERSAL = new Field(AllocTransType.INSTANCE, Values.REVERSAL.getOrdinal());
        public final Field CALCULATED_WITHOUT_PRELIMINARY_SENT_UNSOLICITED_BY_BROKER_INCLUD = new Field(AllocTransType.INSTANCE, Values.CALCULATED_WITHOUT_PRELIMINARY_SENT_UNSOLICITED_BY_BROKER_INCLUD.getOrdinal());
        public final Field CALCULATED_INCLUDES_MISCFEES_AND_NETMONEY_REMOVEDREPLACED = new Field(AllocTransType.INSTANCE, Values.CALCULATED_INCLUDES_MISCFEES_AND_NETMONEY_REMOVEDREPLACED.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        PRELIMINARY_WITHOUT_MISCFEES_AND_NETMONEY_REMOVEDREPLACED("3"),
        CANCEL("2"),
        REPLACE("1"),
        NEW("0"),
        REVERSAL("6"),
        CALCULATED_WITHOUT_PRELIMINARY_SENT_UNSOLICITED_BY_BROKER_INCLUD("5"),
        CALCULATED_INCLUDES_MISCFEES_AND_NETMONEY_REMOVEDREPLACED("4");

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
