package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class RespondentType extends BaseFieldType {
    public static final RespondentType INSTANCE = new RespondentType();

    private RespondentType() {
        super(
            "RespondentType",
            1172,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field ALL_MARKET_MAKERS = new Field(RespondentType.INSTANCE, Values.ALL_MARKET_MAKERS.getOrdinal());
        public final Field SPECIFIED_MARKET_PARTICIPANTS = new Field(RespondentType.INSTANCE, Values.SPECIFIED_MARKET_PARTICIPANTS.getOrdinal());
        public final Field ALL_MARKET_PARTICIPANTS = new Field(RespondentType.INSTANCE, Values.ALL_MARKET_PARTICIPANTS.getOrdinal());
        public final Field PRIMARY_MARKET_MAKERS = new Field(RespondentType.INSTANCE, Values.PRIMARY_MARKET_MAKERS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        ALL_MARKET_MAKERS("3"),
        SPECIFIED_MARKET_PARTICIPANTS("2"),
        ALL_MARKET_PARTICIPANTS("1"),
        PRIMARY_MARKET_MAKERS("4");

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
