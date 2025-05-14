package org.fix4j.spec.fix50sp2.fieldtype;


import org.fix4j.test.fixspec.BaseFieldType;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FieldClassLookup;
import org.fix4j.test.fixspec.FieldTypeValueEnum;
import org.fix4j.test.fixmodel.Field;

public class MsgType extends BaseFieldType {
    public static final MsgType INSTANCE = new MsgType();

    private MsgType() {
        super(
            "MsgType",
            35,
            FieldClassLookup.lookup("STRING"),
            Values.class
        );
    }

    public static Field withValue(final String value){ return new Field(INSTANCE, value); }
    public static Field withValue(final long value){ return new Field(INSTANCE, ""+value); }

    public static FieldFactory withValue(){ return new FieldFactory(); }

    public static class FieldFactory{
        public final Field REJECT = new Field(MsgType.INSTANCE, Values.REJECT.getOrdinal());
        public final Field RESENDREQUEST = new Field(MsgType.INSTANCE, Values.RESENDREQUEST.getOrdinal());
        public final Field TESTREQUEST = new Field(MsgType.INSTANCE, Values.TESTREQUEST.getOrdinal());
        public final Field HEARTBEAT = new Field(MsgType.INSTANCE, Values.HEARTBEAT.getOrdinal());
        public final Field ADVERTISEMENT = new Field(MsgType.INSTANCE, Values.ADVERTISEMENT.getOrdinal());
        public final Field IOI = new Field(MsgType.INSTANCE, Values.IOI.getOrdinal());
        public final Field LOGOUT = new Field(MsgType.INSTANCE, Values.LOGOUT.getOrdinal());
        public final Field SEQUENCERESET = new Field(MsgType.INSTANCE, Values.SEQUENCERESET.getOrdinal());
        public final Field ORDERCANCELREJECT = new Field(MsgType.INSTANCE, Values.ORDERCANCELREJECT.getOrdinal());
        public final Field EXECUTIONREPORT = new Field(MsgType.INSTANCE, Values.EXECUTIONREPORT.getOrdinal());
        public final Field NEWORDERSINGLE = new Field(MsgType.INSTANCE, Values.NEWORDERSINGLE.getOrdinal());
        public final Field NEWORDERLIST = new Field(MsgType.INSTANCE, Values.NEWORDERLIST.getOrdinal());
        public final Field ORDERCANCELREQUEST = new Field(MsgType.INSTANCE, Values.ORDERCANCELREQUEST.getOrdinal());
        public final Field ORDERCANCELREPLACEREQUEST = new Field(MsgType.INSTANCE, Values.ORDERCANCELREPLACEREQUEST.getOrdinal());
        public final Field LOGON = new Field(MsgType.INSTANCE, Values.LOGON.getOrdinal());
        public final Field NEWS = new Field(MsgType.INSTANCE, Values.NEWS.getOrdinal());
        public final Field EMAIL = new Field(MsgType.INSTANCE, Values.EMAIL.getOrdinal());
        public final Field LISTEXECUTE = new Field(MsgType.INSTANCE, Values.LISTEXECUTE.getOrdinal());
        public final Field LISTSTATUSREQUEST = new Field(MsgType.INSTANCE, Values.LISTSTATUSREQUEST.getOrdinal());
        public final Field LISTSTATUS = new Field(MsgType.INSTANCE, Values.LISTSTATUS.getOrdinal());
        public final Field ORDERSTATUSREQUEST = new Field(MsgType.INSTANCE, Values.ORDERSTATUSREQUEST.getOrdinal());
        public final Field ALLOCATIONINSTRUCTION = new Field(MsgType.INSTANCE, Values.ALLOCATIONINSTRUCTION.getOrdinal());
        public final Field LISTCANCELREQUEST = new Field(MsgType.INSTANCE, Values.LISTCANCELREQUEST.getOrdinal());
        public final Field SETTLEMENTINSTRUCTIONS = new Field(MsgType.INSTANCE, Values.SETTLEMENTINSTRUCTIONS.getOrdinal());
        public final Field MARKETDATASNAPSHOTFULLREFRESH = new Field(MsgType.INSTANCE, Values.MARKETDATASNAPSHOTFULLREFRESH.getOrdinal());
        public final Field MARKETDATAREQUEST = new Field(MsgType.INSTANCE, Values.MARKETDATAREQUEST.getOrdinal());
        public final Field DONTKNOWTRADEDK = new Field(MsgType.INSTANCE, Values.DONTKNOWTRADEDK.getOrdinal());
        public final Field ALLOCATIONINSTRUCTIONACK = new Field(MsgType.INSTANCE, Values.ALLOCATIONINSTRUCTIONACK.getOrdinal());
        public final Field QUOTE = new Field(MsgType.INSTANCE, Values.QUOTE.getOrdinal());
        public final Field QUOTEREQUEST = new Field(MsgType.INSTANCE, Values.QUOTEREQUEST.getOrdinal());
        public final Field MARKETDATAREQUESTREJECT = new Field(MsgType.INSTANCE, Values.MARKETDATAREQUESTREJECT.getOrdinal());
        public final Field MARKETDATAINCREMENTALREFRESH = new Field(MsgType.INSTANCE, Values.MARKETDATAINCREMENTALREFRESH.getOrdinal());
        public final Field QUOTECANCEL = new Field(MsgType.INSTANCE, Values.QUOTECANCEL.getOrdinal());
        public final Field SECURITYSTATUS = new Field(MsgType.INSTANCE, Values.SECURITYSTATUS.getOrdinal());
        public final Field TRADINGSESSIONSTATUSREQUEST = new Field(MsgType.INSTANCE, Values.TRADINGSESSIONSTATUSREQUEST.getOrdinal());
        public final Field SECURITYDEFINITION = new Field(MsgType.INSTANCE, Values.SECURITYDEFINITION.getOrdinal());
        public final Field SECURITYSTATUSREQUEST = new Field(MsgType.INSTANCE, Values.SECURITYSTATUSREQUEST.getOrdinal());
        public final Field MASSQUOTEACKNOWLEDGEMENT = new Field(MsgType.INSTANCE, Values.MASSQUOTEACKNOWLEDGEMENT.getOrdinal());
        public final Field SECURITYDEFINITIONREQUEST = new Field(MsgType.INSTANCE, Values.SECURITYDEFINITIONREQUEST.getOrdinal());
        public final Field QUOTESTATUSREQUEST = new Field(MsgType.INSTANCE, Values.QUOTESTATUSREQUEST.getOrdinal());
        public final Field XML_NON_FIX = new Field(MsgType.INSTANCE, Values.XML_NON_FIX.getOrdinal());
        public final Field REGISTRATIONINSTRUCTIONS = new Field(MsgType.INSTANCE, Values.REGISTRATIONINSTRUCTIONS.getOrdinal());
        public final Field BIDRESPONSE = new Field(MsgType.INSTANCE, Values.BIDRESPONSE.getOrdinal());
        public final Field LISTSTRIKEPRICE = new Field(MsgType.INSTANCE, Values.LISTSTRIKEPRICE.getOrdinal());
        public final Field BUSINESSMESSAGEREJECT = new Field(MsgType.INSTANCE, Values.BUSINESSMESSAGEREJECT.getOrdinal());
        public final Field BIDREQUEST = new Field(MsgType.INSTANCE, Values.BIDREQUEST.getOrdinal());
        public final Field TRADINGSESSIONSTATUS = new Field(MsgType.INSTANCE, Values.TRADINGSESSIONSTATUS.getOrdinal());
        public final Field MASSQUOTE = new Field(MsgType.INSTANCE, Values.MASSQUOTE.getOrdinal());
        public final Field SECURITYTYPES = new Field(MsgType.INSTANCE, Values.SECURITYTYPES.getOrdinal());
        public final Field SECURITYTYPEREQUEST = new Field(MsgType.INSTANCE, Values.SECURITYTYPEREQUEST.getOrdinal());
        public final Field CROSSORDERCANCELREQUEST = new Field(MsgType.INSTANCE, Values.CROSSORDERCANCELREQUEST.getOrdinal());
        public final Field CROSSORDERCANCELREPLACEREQUEST = new Field(MsgType.INSTANCE, Values.CROSSORDERCANCELREPLACEREQUEST.getOrdinal());
        public final Field NEWORDERCROSS = new Field(MsgType.INSTANCE, Values.NEWORDERCROSS.getOrdinal());
        public final Field ORDERMASSCANCELREPORT = new Field(MsgType.INSTANCE, Values.ORDERMASSCANCELREPORT.getOrdinal());
        public final Field ORDERMASSCANCELREQUEST = new Field(MsgType.INSTANCE, Values.ORDERMASSCANCELREQUEST.getOrdinal());
        public final Field REGISTRATIONINSTRUCTIONSRESPONSE = new Field(MsgType.INSTANCE, Values.REGISTRATIONINSTRUCTIONSRESPONSE.getOrdinal());
        public final Field DERIVATIVESECURITYLISTREQUEST = new Field(MsgType.INSTANCE, Values.DERIVATIVESECURITYLISTREQUEST.getOrdinal());
        public final Field SECURITYLIST = new Field(MsgType.INSTANCE, Values.SECURITYLIST.getOrdinal());
        public final Field SECURITYLISTREQUEST = new Field(MsgType.INSTANCE, Values.SECURITYLISTREQUEST.getOrdinal());
        public final Field ALLOCATIONREPORTACK = new Field(MsgType.INSTANCE, Values.ALLOCATIONREPORTACK.getOrdinal());
        public final Field ALLOCATIONREPORT = new Field(MsgType.INSTANCE, Values.ALLOCATIONREPORT.getOrdinal());
        public final Field TRADECAPTUREREPORTACK = new Field(MsgType.INSTANCE, Values.TRADECAPTUREREPORTACK.getOrdinal());
        public final Field TRADECAPTUREREPORTREQUESTACK = new Field(MsgType.INSTANCE, Values.TRADECAPTUREREPORTREQUESTACK.getOrdinal());
        public final Field COLLATERALREQUEST = new Field(MsgType.INSTANCE, Values.COLLATERALREQUEST.getOrdinal());
        public final Field ASSIGNMENTREPORT = new Field(MsgType.INSTANCE, Values.ASSIGNMENTREPORT.getOrdinal());
        public final Field SETTLEMENTINSTRUCTIONREQUEST = new Field(MsgType.INSTANCE, Values.SETTLEMENTINSTRUCTIONREQUEST.getOrdinal());
        public final Field CONFIRMATION_ACK = new Field(MsgType.INSTANCE, Values.CONFIRMATION_ACK.getOrdinal());
        public final Field COLLATERALRESPONSE = new Field(MsgType.INSTANCE, Values.COLLATERALRESPONSE.getOrdinal());
        public final Field COLLATERALASSIGNMENT = new Field(MsgType.INSTANCE, Values.COLLATERALASSIGNMENT.getOrdinal());
        public final Field COLLATERALREPORT = new Field(MsgType.INSTANCE, Values.COLLATERALREPORT.getOrdinal());
        public final Field MULTILEGORDERCANCELREPLACE = new Field(MsgType.INSTANCE, Values.MULTILEGORDERCANCELREPLACE.getOrdinal());
        public final Field TRADECAPTUREREPORTREQUEST = new Field(MsgType.INSTANCE, Values.TRADECAPTUREREPORTREQUEST.getOrdinal());
        public final Field DERIVATIVESECURITYLIST = new Field(MsgType.INSTANCE, Values.DERIVATIVESECURITYLIST.getOrdinal());
        public final Field NEWORDERMULTILEG = new Field(MsgType.INSTANCE, Values.NEWORDERMULTILEG.getOrdinal());
        public final Field QUOTEREQUESTREJECT = new Field(MsgType.INSTANCE, Values.QUOTEREQUESTREJECT.getOrdinal());
        public final Field RFQREQUEST = new Field(MsgType.INSTANCE, Values.RFQREQUEST.getOrdinal());
        public final Field TRADECAPTUREREPORT = new Field(MsgType.INSTANCE, Values.TRADECAPTUREREPORT.getOrdinal());
        public final Field ORDERMASSSTATUSREQUEST = new Field(MsgType.INSTANCE, Values.ORDERMASSSTATUSREQUEST.getOrdinal());
        public final Field CONFIRMATION = new Field(MsgType.INSTANCE, Values.CONFIRMATION.getOrdinal());
        public final Field POSITIONMAINTENANCEREQUEST = new Field(MsgType.INSTANCE, Values.POSITIONMAINTENANCEREQUEST.getOrdinal());
        public final Field QUOTESTATUSREPORT = new Field(MsgType.INSTANCE, Values.QUOTESTATUSREPORT.getOrdinal());
        public final Field QUOTERESPONSE = new Field(MsgType.INSTANCE, Values.QUOTERESPONSE.getOrdinal());
        public final Field REQUESTFORPOSITIONSACK = new Field(MsgType.INSTANCE, Values.REQUESTFORPOSITIONSACK.getOrdinal());
        public final Field POSITIONREPORT = new Field(MsgType.INSTANCE, Values.POSITIONREPORT.getOrdinal());
        public final Field POSITIONMAINTENANCEREPORT = new Field(MsgType.INSTANCE, Values.POSITIONMAINTENANCEREPORT.getOrdinal());
        public final Field REQUESTFORPOSITIONS = new Field(MsgType.INSTANCE, Values.REQUESTFORPOSITIONS.getOrdinal());
        public final Field APPLICATIONMESSAGEREQUEST = new Field(MsgType.INSTANCE, Values.APPLICATIONMESSAGEREQUEST.getOrdinal());
        public final Field MARKETDEFINITIONUPDATEREPORT = new Field(MsgType.INSTANCE, Values.MARKETDEFINITIONUPDATEREPORT.getOrdinal());
        public final Field APPLICATIONMESSAGEREPORT = new Field(MsgType.INSTANCE, Values.APPLICATIONMESSAGEREPORT.getOrdinal());
        public final Field APPLICATIONMESSAGEREQUESTACK = new Field(MsgType.INSTANCE, Values.APPLICATIONMESSAGEREQUESTACK.getOrdinal());
        public final Field TRADINGSESSIONLISTUPDATEREPORT = new Field(MsgType.INSTANCE, Values.TRADINGSESSIONLISTUPDATEREPORT.getOrdinal());
        public final Field DERIVATIVESECURITYLISTUPDATEREPORT = new Field(MsgType.INSTANCE, Values.DERIVATIVESECURITYLISTUPDATEREPORT.getOrdinal());
        public final Field MARKETDEFINITION = new Field(MsgType.INSTANCE, Values.MARKETDEFINITION.getOrdinal());
        public final Field MARKETDEFINITIONREQUEST = new Field(MsgType.INSTANCE, Values.MARKETDEFINITIONREQUEST.getOrdinal());
        public final Field USERNOTIFICATION = new Field(MsgType.INSTANCE, Values.USERNOTIFICATION.getOrdinal());
        public final Field ORDERMASSACTIONREQUEST = new Field(MsgType.INSTANCE, Values.ORDERMASSACTIONREQUEST.getOrdinal());
        public final Field ORDERMASSACTIONREPORT = new Field(MsgType.INSTANCE, Values.ORDERMASSACTIONREPORT.getOrdinal());
        public final Field USERRESPONSE = new Field(MsgType.INSTANCE, Values.USERRESPONSE.getOrdinal());
        public final Field COLLATERALINQUIRYACK = new Field(MsgType.INSTANCE, Values.COLLATERALINQUIRYACK.getOrdinal());
        public final Field CONFIRMATIONREQUEST = new Field(MsgType.INSTANCE, Values.CONFIRMATIONREQUEST.getOrdinal());
        public final Field TRADINGSESSIONLISTREQUEST = new Field(MsgType.INSTANCE, Values.TRADINGSESSIONLISTREQUEST.getOrdinal());
        public final Field COLLATERALINQUIRY = new Field(MsgType.INSTANCE, Values.COLLATERALINQUIRY.getOrdinal());
        public final Field NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST = new Field(MsgType.INSTANCE, Values.NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST.getOrdinal());
        public final Field NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE = new Field(MsgType.INSTANCE, Values.NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE.getOrdinal());
        public final Field USERREQUEST = new Field(MsgType.INSTANCE, Values.USERREQUEST.getOrdinal());
        public final Field EXECUTIONACKNOWLEDGEMENT = new Field(MsgType.INSTANCE, Values.EXECUTIONACKNOWLEDGEMENT.getOrdinal());
        public final Field CONTRARYINTENTIONREPORT = new Field(MsgType.INSTANCE, Values.CONTRARYINTENTIONREPORT.getOrdinal());
        public final Field SECURITYDEFINITIONUPDATEREPORT = new Field(MsgType.INSTANCE, Values.SECURITYDEFINITIONUPDATEREPORT.getOrdinal());
        public final Field SETTLEMENTOBLIGATIONREPORT = new Field(MsgType.INSTANCE, Values.SETTLEMENTOBLIGATIONREPORT.getOrdinal());
        public final Field TRADINGSESSIONLIST = new Field(MsgType.INSTANCE, Values.TRADINGSESSIONLIST.getOrdinal());
        public final Field SECURITYLISTUPDATEREPORT = new Field(MsgType.INSTANCE, Values.SECURITYLISTUPDATEREPORT.getOrdinal());
        public final Field ADJUSTEDPOSITIONREPORT = new Field(MsgType.INSTANCE, Values.ADJUSTEDPOSITIONREPORT.getOrdinal());
        public final Field ALLOCATIONINSTRUCTIONALERT = new Field(MsgType.INSTANCE, Values.ALLOCATIONINSTRUCTIONALERT.getOrdinal());
        public final Field PARTYDETAILSLISTREPORT = new Field(MsgType.INSTANCE, Values.PARTYDETAILSLISTREPORT.getOrdinal());
        public final Field STREAMASSIGNMENTREPORTACK = new Field(MsgType.INSTANCE, Values.STREAMASSIGNMENTREPORTACK.getOrdinal());
        public final Field PARTYDETAILSLISTREQUEST = new Field(MsgType.INSTANCE, Values.PARTYDETAILSLISTREQUEST.getOrdinal());
        public final Field STREAMASSIGNMENTREQUEST = new Field(MsgType.INSTANCE, Values.STREAMASSIGNMENTREQUEST.getOrdinal());
        public final Field STREAMASSIGNMENTREPORT = new Field(MsgType.INSTANCE, Values.STREAMASSIGNMENTREPORT.getOrdinal());
    }

    public enum Values implements FieldTypeValueEnum {
        REJECT("3"),
        RESENDREQUEST("2"),
        TESTREQUEST("1"),
        HEARTBEAT("0"),
        ADVERTISEMENT("7"),
        IOI("6"),
        LOGOUT("5"),
        SEQUENCERESET("4"),
        ORDERCANCELREJECT("9"),
        EXECUTIONREPORT("8"),
        NEWORDERSINGLE("D"),
        NEWORDERLIST("E"),
        ORDERCANCELREQUEST("F"),
        ORDERCANCELREPLACEREQUEST("G"),
        LOGON("A"),
        NEWS("B"),
        EMAIL("C"),
        LISTEXECUTE("L"),
        LISTSTATUSREQUEST("M"),
        LISTSTATUS("N"),
        ORDERSTATUSREQUEST("H"),
        ALLOCATIONINSTRUCTION("J"),
        LISTCANCELREQUEST("K"),
        SETTLEMENTINSTRUCTIONS("T"),
        MARKETDATASNAPSHOTFULLREFRESH("W"),
        MARKETDATAREQUEST("V"),
        DONTKNOWTRADEDK("Q"),
        ALLOCATIONINSTRUCTIONACK("P"),
        QUOTE("S"),
        QUOTEREQUEST("R"),
        MARKETDATAREQUESTREJECT("Y"),
        MARKETDATAINCREMENTALREFRESH("X"),
        QUOTECANCEL("Z"),
        SECURITYSTATUS("f"),
        TRADINGSESSIONSTATUSREQUEST("g"),
        SECURITYDEFINITION("d"),
        SECURITYSTATUSREQUEST("e"),
        MASSQUOTEACKNOWLEDGEMENT("b"),
        SECURITYDEFINITIONREQUEST("c"),
        QUOTESTATUSREQUEST("a"),
        XML_NON_FIX("n"),
        REGISTRATIONINSTRUCTIONS("o"),
        BIDRESPONSE("l"),
        LISTSTRIKEPRICE("m"),
        BUSINESSMESSAGEREJECT("j"),
        BIDREQUEST("k"),
        TRADINGSESSIONSTATUS("h"),
        MASSQUOTE("i"),
        SECURITYTYPES("w"),
        SECURITYTYPEREQUEST("v"),
        CROSSORDERCANCELREQUEST("u"),
        CROSSORDERCANCELREPLACEREQUEST("t"),
        NEWORDERCROSS("s"),
        ORDERMASSCANCELREPORT("r"),
        ORDERMASSCANCELREQUEST("q"),
        REGISTRATIONINSTRUCTIONSRESPONSE("p"),
        DERIVATIVESECURITYLISTREQUEST("z"),
        SECURITYLIST("y"),
        SECURITYLISTREQUEST("x"),
        ALLOCATIONREPORTACK("AT"),
        ALLOCATIONREPORT("AS"),
        TRADECAPTUREREPORTACK("AR"),
        TRADECAPTUREREPORTREQUESTACK("AQ"),
        COLLATERALREQUEST("AX"),
        ASSIGNMENTREPORT("AW"),
        SETTLEMENTINSTRUCTIONREQUEST("AV"),
        CONFIRMATION_ACK("AU"),
        COLLATERALRESPONSE("AZ"),
        COLLATERALASSIGNMENT("AY"),
        COLLATERALREPORT("BA"),
        MULTILEGORDERCANCELREPLACE("AC"),
        TRADECAPTUREREPORTREQUEST("AD"),
        DERIVATIVESECURITYLIST("AA"),
        NEWORDERMULTILEG("AB"),
        QUOTEREQUESTREJECT("AG"),
        RFQREQUEST("AH"),
        TRADECAPTUREREPORT("AE"),
        ORDERMASSSTATUSREQUEST("AF"),
        CONFIRMATION("AK"),
        POSITIONMAINTENANCEREQUEST("AL"),
        QUOTESTATUSREPORT("AI"),
        QUOTERESPONSE("AJ"),
        REQUESTFORPOSITIONSACK("AO"),
        POSITIONREPORT("AP"),
        POSITIONMAINTENANCEREPORT("AM"),
        REQUESTFORPOSITIONS("AN"),
        APPLICATIONMESSAGEREQUEST("BW"),
        MARKETDEFINITIONUPDATEREPORT("BV"),
        APPLICATIONMESSAGEREPORT("BY"),
        APPLICATIONMESSAGEREQUESTACK("BX"),
        TRADINGSESSIONLISTUPDATEREPORT("BS"),
        DERIVATIVESECURITYLISTUPDATEREPORT("BR"),
        MARKETDEFINITION("BU"),
        MARKETDEFINITIONREQUEST("BT"),
        USERNOTIFICATION("CB"),
        ORDERMASSACTIONREQUEST("CA"),
        ORDERMASSACTIONREPORT("BZ"),
        USERRESPONSE("BF"),
        COLLATERALINQUIRYACK("BG"),
        CONFIRMATIONREQUEST("BH"),
        TRADINGSESSIONLISTREQUEST("BI"),
        COLLATERALINQUIRY("BB"),
        NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST("BC"),
        NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE("BD"),
        USERREQUEST("BE"),
        EXECUTIONACKNOWLEDGEMENT("BN"),
        CONTRARYINTENTIONREPORT("BO"),
        SECURITYDEFINITIONUPDATEREPORT("BP"),
        SETTLEMENTOBLIGATIONREPORT("BQ"),
        TRADINGSESSIONLIST("BJ"),
        SECURITYLISTUPDATEREPORT("BK"),
        ADJUSTEDPOSITIONREPORT("BL"),
        ALLOCATIONINSTRUCTIONALERT("BM"),
        PARTYDETAILSLISTREPORT("CG"),
        STREAMASSIGNMENTREPORTACK("CE"),
        PARTYDETAILSLISTREQUEST("CF"),
        STREAMASSIGNMENTREQUEST("CC"),
        STREAMASSIGNMENTREPORT("CD");

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
