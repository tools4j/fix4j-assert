package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class NewsCategory extends BaseFieldType {
    public static final NewsCategory INSTANCE = new NewsCategory();

    private NewsCategory() {
        super(
            "NewsCategory",
            1473,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field TECHNICAL_NEWS = new Field(NewsCategory.INSTANCE, Values.TECHNICAL_NEWS.getOrdinal());
        public final Field FINANCIAL_MARKET_NEWS = new Field(NewsCategory.INSTANCE, Values.FINANCIAL_MARKET_NEWS.getOrdinal());
        public final Field MARKETPLACE_NEWS = new Field(NewsCategory.INSTANCE, Values.MARKETPLACE_NEWS.getOrdinal());
        public final Field COMPANY_NEWS = new Field(NewsCategory.INSTANCE, Values.COMPANY_NEWS.getOrdinal());
        public final Field OTHER_NEWS = new Field(NewsCategory.INSTANCE, Values.OTHER_NEWS.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        TECHNICAL_NEWS("3"),
        FINANCIAL_MARKET_NEWS("2"),
        MARKETPLACE_NEWS("1"),
        COMPANY_NEWS("0"),
        OTHER_NEWS("99");

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
