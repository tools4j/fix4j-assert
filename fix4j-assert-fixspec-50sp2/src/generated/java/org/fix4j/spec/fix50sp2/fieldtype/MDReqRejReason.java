package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MDReqRejReason extends BaseFieldType {
    public static final MDReqRejReason INSTANCE = new MDReqRejReason();

    private MDReqRejReason() {
        super(
            "MDReqRejReason",
            281,
            FieldClassLookup.lookup("CHAR"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field INSUFFICIENT_CREDIT = new Field(MDReqRejReason.INSTANCE, Values.INSUFFICIENT_CREDIT.getOrdinal());
        public final Field UNSUPPORTED_SCOPE = new Field(MDReqRejReason.INSTANCE, Values.UNSUPPORTED_SCOPE.getOrdinal());
        public final Field UNSUPPORTED_OPENCLOSESETTLEFLAG = new Field(MDReqRejReason.INSTANCE, Values.UNSUPPORTED_OPENCLOSESETTLEFLAG.getOrdinal());
        public final Field UNSUPPORTED_MDIMPLICITDELETE = new Field(MDReqRejReason.INSTANCE, Values.UNSUPPORTED_MDIMPLICITDELETE.getOrdinal());
        public final Field INSUFFICIENT_PERMISSIONS = new Field(MDReqRejReason.INSTANCE, Values.INSUFFICIENT_PERMISSIONS.getOrdinal());
        public final Field INSUFFICIENT_BANDWIDTH = new Field(MDReqRejReason.INSTANCE, Values.INSUFFICIENT_BANDWIDTH.getOrdinal());
        public final Field DUPLICATE_MDREQID = new Field(MDReqRejReason.INSTANCE, Values.DUPLICATE_MDREQID.getOrdinal());
        public final Field UNKNOWN_SYMBOL = new Field(MDReqRejReason.INSTANCE, Values.UNKNOWN_SYMBOL.getOrdinal());
        public final Field UNSUPPORTED_AGGREGATEDBOOK = new Field(MDReqRejReason.INSTANCE, Values.UNSUPPORTED_AGGREGATEDBOOK.getOrdinal());
        public final Field UNSUPPORTED_MDUPDATETYPE = new Field(MDReqRejReason.INSTANCE, Values.UNSUPPORTED_MDUPDATETYPE.getOrdinal());
        public final Field UNSUPPORTED_MARKETDEPTH = new Field(MDReqRejReason.INSTANCE, Values.UNSUPPORTED_MARKETDEPTH.getOrdinal());
        public final Field UNSUPPORTED_SUBSCRIPTIONREQUESTTYPE = new Field(MDReqRejReason.INSTANCE, Values.UNSUPPORTED_SUBSCRIPTIONREQUESTTYPE.getOrdinal());
        public final Field UNSUPPORTED_TRADINGSESSIONID = new Field(MDReqRejReason.INSTANCE, Values.UNSUPPORTED_TRADINGSESSIONID.getOrdinal());
        public final Field UNSUPPORTED_MDENTRYTYPE = new Field(MDReqRejReason.INSTANCE, Values.UNSUPPORTED_MDENTRYTYPE.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        INSUFFICIENT_CREDIT("D"),
        UNSUPPORTED_SCOPE("A"),
        UNSUPPORTED_OPENCLOSESETTLEFLAG("B"),
        UNSUPPORTED_MDIMPLICITDELETE("C"),
        INSUFFICIENT_PERMISSIONS("3"),
        INSUFFICIENT_BANDWIDTH("2"),
        DUPLICATE_MDREQID("1"),
        UNKNOWN_SYMBOL("0"),
        UNSUPPORTED_AGGREGATEDBOOK("7"),
        UNSUPPORTED_MDUPDATETYPE("6"),
        UNSUPPORTED_MARKETDEPTH("5"),
        UNSUPPORTED_SUBSCRIPTIONREQUESTTYPE("4"),
        UNSUPPORTED_TRADINGSESSIONID("9"),
        UNSUPPORTED_MDENTRYTYPE("8");

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
