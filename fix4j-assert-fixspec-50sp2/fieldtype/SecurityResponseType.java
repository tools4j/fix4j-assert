package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class SecurityResponseType extends BaseFieldType {
    public static final SecurityResponseType INSTANCE = new SecurityResponseType();

    private SecurityResponseType() {
        super(
            "SecurityResponseType",
            323,
            FieldClassLookup.lookup("INT"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field LIST_OF_SECURITY_TYPES_RETURNED_PER_REQUEST = new Field(SecurityResponseType.INSTANCE, Values.LIST_OF_SECURITY_TYPES_RETURNED_PER_REQUEST.getOrdinal());
        public final Field ACCEPT_SECURITY_PROPOSAL_WITH_REVISIONS_AS_INDICATED_IN_THE_MESS = new Field(SecurityResponseType.INSTANCE, Values.ACCEPT_SECURITY_PROPOSAL_WITH_REVISIONS_AS_INDICATED_IN_THE_MESS.getOrdinal());
        public final Field ACCEPT_SECURITY_PROPOSAL_ASIS = new Field(SecurityResponseType.INSTANCE, Values.ACCEPT_SECURITY_PROPOSAL_ASIS.getOrdinal());
        public final Field CANNOT_MATCH_SELECTION_CRITERIA = new Field(SecurityResponseType.INSTANCE, Values.CANNOT_MATCH_SELECTION_CRITERIA.getOrdinal());
        public final Field REJECT_SECURITY_PROPOSAL = new Field(SecurityResponseType.INSTANCE, Values.REJECT_SECURITY_PROPOSAL.getOrdinal());
        public final Field LIST_OF_SECURITIES_RETURNED_PER_REQUEST = new Field(SecurityResponseType.INSTANCE, Values.LIST_OF_SECURITIES_RETURNED_PER_REQUEST.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        LIST_OF_SECURITY_TYPES_RETURNED_PER_REQUEST("3"),
        ACCEPT_SECURITY_PROPOSAL_WITH_REVISIONS_AS_INDICATED_IN_THE_MESS("2"),
        ACCEPT_SECURITY_PROPOSAL_ASIS("1"),
        CANNOT_MATCH_SELECTION_CRITERIA("6"),
        REJECT_SECURITY_PROPOSAL("5"),
        LIST_OF_SECURITIES_RETURNED_PER_REQUEST("4");

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
