package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class CorporateAction extends BaseFieldType {
    public static final CorporateAction INSTANCE = new CorporateAction();

    private CorporateAction() {
        super(
            "CorporateAction",
            292,
            FieldClassLookup.lookup("MULTIPLECHARVALUE"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field NEW = new Field(CorporateAction.INSTANCE, Values.NEW.getOrdinal());
        public final Field EXINTEREST = new Field(CorporateAction.INSTANCE, Values.EXINTEREST.getOrdinal());
        public final Field CASH_DIVIDEND = new Field(CorporateAction.INSTANCE, Values.CASH_DIVIDEND.getOrdinal());
        public final Field STOCK_DIVIDEND = new Field(CorporateAction.INSTANCE, Values.STOCK_DIVIDEND.getOrdinal());
        public final Field EXDIVIDEND = new Field(CorporateAction.INSTANCE, Values.EXDIVIDEND.getOrdinal());
        public final Field EXDISTRIBUTION = new Field(CorporateAction.INSTANCE, Values.EXDISTRIBUTION.getOrdinal());
        public final Field EXRIGHTS = new Field(CorporateAction.INSTANCE, Values.EXRIGHTS.getOrdinal());
        public final Field LIQUIDATION_REORGANIZATION = new Field(CorporateAction.INSTANCE, Values.LIQUIDATION_REORGANIZATION.getOrdinal());
        public final Field MERGER_REORGANIZATION = new Field(CorporateAction.INSTANCE, Values.MERGER_REORGANIZATION.getOrdinal());
        public final Field RIGHTS_OFFERING = new Field(CorporateAction.INSTANCE, Values.RIGHTS_OFFERING.getOrdinal());
        public final Field SHAREHOLDER_MEETING = new Field(CorporateAction.INSTANCE, Values.SHAREHOLDER_MEETING.getOrdinal());
        public final Field NONINTEGER_STOCK_SPLIT = new Field(CorporateAction.INSTANCE, Values.NONINTEGER_STOCK_SPLIT.getOrdinal());
        public final Field REVERSE_STOCK_SPLIT = new Field(CorporateAction.INSTANCE, Values.REVERSE_STOCK_SPLIT.getOrdinal());
        public final Field STANDARDINTEGER_STOCK_SPLIT = new Field(CorporateAction.INSTANCE, Values.STANDARDINTEGER_STOCK_SPLIT.getOrdinal());
        public final Field POSITION_CONSOLIDATION = new Field(CorporateAction.INSTANCE, Values.POSITION_CONSOLIDATION.getOrdinal());
        public final Field CUSIP__NAME_CHANGE = new Field(CorporateAction.INSTANCE, Values.CUSIP__NAME_CHANGE.getOrdinal());
        public final Field SYMBOL_CONVERSION = new Field(CorporateAction.INSTANCE, Values.SYMBOL_CONVERSION.getOrdinal());
        public final Field SUCCESSION_EVENT = new Field(CorporateAction.INSTANCE, Values.SUCCESSION_EVENT.getOrdinal());
        public final Field LEAP_ROLLOVER = new Field(CorporateAction.INSTANCE, Values.LEAP_ROLLOVER.getOrdinal());
        public final Field TENDER_OFFER = new Field(CorporateAction.INSTANCE, Values.TENDER_OFFER.getOrdinal());
        public final Field SPINOFF = new Field(CorporateAction.INSTANCE, Values.SPINOFF.getOrdinal());
        public final Field SPECIAL_ACTION = new Field(CorporateAction.INSTANCE, Values.SPECIAL_ACTION.getOrdinal());
        public final Field WARRANT = new Field(CorporateAction.INSTANCE, Values.WARRANT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        NEW("D"),
        EXINTEREST("E"),
        CASH_DIVIDEND("F"),
        STOCK_DIVIDEND("G"),
        EXDIVIDEND("A"),
        EXDISTRIBUTION("B"),
        EXRIGHTS("C"),
        LIQUIDATION_REORGANIZATION("L"),
        MERGER_REORGANIZATION("M"),
        RIGHTS_OFFERING("N"),
        SHAREHOLDER_MEETING("O"),
        NONINTEGER_STOCK_SPLIT("H"),
        REVERSE_STOCK_SPLIT("I"),
        STANDARDINTEGER_STOCK_SPLIT("J"),
        POSITION_CONSOLIDATION("K"),
        CUSIP__NAME_CHANGE("U"),
        SYMBOL_CONVERSION("T"),
        SUCCESSION_EVENT("W"),
        LEAP_ROLLOVER("V"),
        TENDER_OFFER("Q"),
        SPINOFF("P"),
        SPECIAL_ACTION("S"),
        WARRANT("R");

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
