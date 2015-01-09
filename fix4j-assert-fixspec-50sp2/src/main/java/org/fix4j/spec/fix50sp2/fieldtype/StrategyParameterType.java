package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class StrategyParameterType extends BaseFieldType {
    public static final StrategyParameterType INSTANCE = new StrategyParameterType();

    private StrategyParameterType() {
        super(
            "StrategyParameterType",
            959,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field UTCTIMESTAMP = new Field(StrategyParameterType.INSTANCE, Values.UTCTIMESTAMP.getOrdinal());
        public final Field EXCHANGE = new Field(StrategyParameterType.INSTANCE, Values.EXCHANGE.getOrdinal());
        public final Field MONTHYEAR = new Field(StrategyParameterType.INSTANCE, Values.MONTHYEAR.getOrdinal());
        public final Field MULTIPLECHARVALUE = new Field(StrategyParameterType.INSTANCE, Values.MULTIPLECHARVALUE.getOrdinal());
        public final Field CURRENCY = new Field(StrategyParameterType.INSTANCE, Values.CURRENCY.getOrdinal());
        public final Field BOOLEAN = new Field(StrategyParameterType.INSTANCE, Values.BOOLEAN.getOrdinal());
        public final Field STRING = new Field(StrategyParameterType.INSTANCE, Values.STRING.getOrdinal());
        public final Field PERCENTAGE = new Field(StrategyParameterType.INSTANCE, Values.PERCENTAGE.getOrdinal());
        public final Field CHAR = new Field(StrategyParameterType.INSTANCE, Values.CHAR.getOrdinal());
        public final Field LOCALMKTDATE = new Field(StrategyParameterType.INSTANCE, Values.LOCALMKTDATE.getOrdinal());
        public final Field UTCTIMEONLY = new Field(StrategyParameterType.INSTANCE, Values.UTCTIMEONLY.getOrdinal());
        public final Field UTCDATEONLY = new Field(StrategyParameterType.INSTANCE, Values.UTCDATEONLY.getOrdinal());
        public final Field DATA = new Field(StrategyParameterType.INSTANCE, Values.DATA.getOrdinal());
        public final Field MULTIPLESTRINGVALUE = new Field(StrategyParameterType.INSTANCE, Values.MULTIPLESTRINGVALUE.getOrdinal());
        public final Field COUNTRY = new Field(StrategyParameterType.INSTANCE, Values.COUNTRY.getOrdinal());
        public final Field LANGUAGE = new Field(StrategyParameterType.INSTANCE, Values.LANGUAGE.getOrdinal());
        public final Field TZTIMEONLY = new Field(StrategyParameterType.INSTANCE, Values.TZTIMEONLY.getOrdinal());
        public final Field TZTIMESTAMP = new Field(StrategyParameterType.INSTANCE, Values.TZTIMESTAMP.getOrdinal());
        public final Field TENOR = new Field(StrategyParameterType.INSTANCE, Values.TENOR.getOrdinal());
        public final Field NUMINGROUP = new Field(StrategyParameterType.INSTANCE, Values.NUMINGROUP.getOrdinal());
        public final Field LENGTH = new Field(StrategyParameterType.INSTANCE, Values.LENGTH.getOrdinal());
        public final Field AMT = new Field(StrategyParameterType.INSTANCE, Values.AMT.getOrdinal());
        public final Field INT = new Field(StrategyParameterType.INSTANCE, Values.INT.getOrdinal());
        public final Field QTY = new Field(StrategyParameterType.INSTANCE, Values.QTY.getOrdinal());
        public final Field FLOAT = new Field(StrategyParameterType.INSTANCE, Values.FLOAT.getOrdinal());
        public final Field TAGNUM = new Field(StrategyParameterType.INSTANCE, Values.TAGNUM.getOrdinal());
        public final Field SEQNUM = new Field(StrategyParameterType.INSTANCE, Values.SEQNUM.getOrdinal());
        public final Field PRICEOFFSET = new Field(StrategyParameterType.INSTANCE, Values.PRICEOFFSET.getOrdinal());
        public final Field PRICE = new Field(StrategyParameterType.INSTANCE, Values.PRICE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        UTCTIMESTAMP("19"),
        EXCHANGE("17"),
        MONTHYEAR("18"),
        MULTIPLECHARVALUE("15"),
        CURRENCY("16"),
        BOOLEAN("13"),
        STRING("14"),
        PERCENTAGE("11"),
        CHAR("12"),
        LOCALMKTDATE("21"),
        UTCTIMEONLY("20"),
        UTCDATEONLY("22"),
        DATA("23"),
        MULTIPLESTRINGVALUE("24"),
        COUNTRY("25"),
        LANGUAGE("26"),
        TZTIMEONLY("27"),
        TZTIMESTAMP("28"),
        TENOR("29"),
        NUMINGROUP("3"),
        LENGTH("2"),
        AMT("10"),
        INT("1"),
        QTY("7"),
        FLOAT("6"),
        TAGNUM("5"),
        SEQNUM("4"),
        PRICEOFFSET("9"),
        PRICE("8");

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
