package org.fix4j.spec.fix50sp2;

import org.fix4j.spec.fix50sp2.msgtype.*;
import org.fix4j.test.fixspec.GroupKey;
import org.fix4j.test.fixspec.GroupType;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.fixspec.Tag;
import java.util.LinkedHashMap;
import java.util.Map;

public class MsgTypes {
    private static final Map<String, MsgType> msgTypesByTagStr = new LinkedHashMap<>();
    private static final Map<String, MsgType> msgTypesByName = new LinkedHashMap<>();
    private static final Map<GroupKey, GroupType> groupTypesByKey = new LinkedHashMap<>();
    
    public static final Heartbeat Heartbeat = register(org.fix4j.spec.fix50sp2.msgtype.Heartbeat.INSTANCE);
    public static final TestRequest TestRequest = register(org.fix4j.spec.fix50sp2.msgtype.TestRequest.INSTANCE);
    public static final ResendRequest ResendRequest = register(org.fix4j.spec.fix50sp2.msgtype.ResendRequest.INSTANCE);
    public static final Reject Reject = register(org.fix4j.spec.fix50sp2.msgtype.Reject.INSTANCE);
    public static final SequenceReset SequenceReset = register(org.fix4j.spec.fix50sp2.msgtype.SequenceReset.INSTANCE);
    public static final Logout Logout = register(org.fix4j.spec.fix50sp2.msgtype.Logout.INSTANCE);
    public static final IOI IOI = register(org.fix4j.spec.fix50sp2.msgtype.IOI.INSTANCE);
    public static final Advertisement Advertisement = register(org.fix4j.spec.fix50sp2.msgtype.Advertisement.INSTANCE);
    public static final ExecutionReport ExecutionReport = register(org.fix4j.spec.fix50sp2.msgtype.ExecutionReport.INSTANCE);
    public static final OrderCancelReject OrderCancelReject = register(org.fix4j.spec.fix50sp2.msgtype.OrderCancelReject.INSTANCE);
    public static final Logon Logon = register(org.fix4j.spec.fix50sp2.msgtype.Logon.INSTANCE);
    public static final News News = register(org.fix4j.spec.fix50sp2.msgtype.News.INSTANCE);
    public static final Email Email = register(org.fix4j.spec.fix50sp2.msgtype.Email.INSTANCE);
    public static final NewOrderSingle NewOrderSingle = register(org.fix4j.spec.fix50sp2.msgtype.NewOrderSingle.INSTANCE);
    public static final NewOrderList NewOrderList = register(org.fix4j.spec.fix50sp2.msgtype.NewOrderList.INSTANCE);
    public static final OrderCancelRequest OrderCancelRequest = register(org.fix4j.spec.fix50sp2.msgtype.OrderCancelRequest.INSTANCE);
    public static final OrderCancelReplaceRequest OrderCancelReplaceRequest = register(org.fix4j.spec.fix50sp2.msgtype.OrderCancelReplaceRequest.INSTANCE);
    public static final OrderStatusRequest OrderStatusRequest = register(org.fix4j.spec.fix50sp2.msgtype.OrderStatusRequest.INSTANCE);
    public static final AllocationInstruction AllocationInstruction = register(org.fix4j.spec.fix50sp2.msgtype.AllocationInstruction.INSTANCE);
    public static final ListCancelRequest ListCancelRequest = register(org.fix4j.spec.fix50sp2.msgtype.ListCancelRequest.INSTANCE);
    public static final ListExecute ListExecute = register(org.fix4j.spec.fix50sp2.msgtype.ListExecute.INSTANCE);
    public static final ListStatusRequest ListStatusRequest = register(org.fix4j.spec.fix50sp2.msgtype.ListStatusRequest.INSTANCE);
    public static final ListStatus ListStatus = register(org.fix4j.spec.fix50sp2.msgtype.ListStatus.INSTANCE);
    public static final AllocationInstructionAck AllocationInstructionAck = register(org.fix4j.spec.fix50sp2.msgtype.AllocationInstructionAck.INSTANCE);
    public static final DontKnowTradeDK DontKnowTradeDK = register(org.fix4j.spec.fix50sp2.msgtype.DontKnowTradeDK.INSTANCE);
    public static final QuoteRequest QuoteRequest = register(org.fix4j.spec.fix50sp2.msgtype.QuoteRequest.INSTANCE);
    public static final Quote Quote = register(org.fix4j.spec.fix50sp2.msgtype.Quote.INSTANCE);
    public static final SettlementInstructions SettlementInstructions = register(org.fix4j.spec.fix50sp2.msgtype.SettlementInstructions.INSTANCE);
    public static final MarketDataRequest MarketDataRequest = register(org.fix4j.spec.fix50sp2.msgtype.MarketDataRequest.INSTANCE);
    public static final MarketDataSnapshotFullRefresh MarketDataSnapshotFullRefresh = register(org.fix4j.spec.fix50sp2.msgtype.MarketDataSnapshotFullRefresh.INSTANCE);
    public static final MarketDataIncrementalRefresh MarketDataIncrementalRefresh = register(org.fix4j.spec.fix50sp2.msgtype.MarketDataIncrementalRefresh.INSTANCE);
    public static final MarketDataRequestReject MarketDataRequestReject = register(org.fix4j.spec.fix50sp2.msgtype.MarketDataRequestReject.INSTANCE);
    public static final QuoteCancel QuoteCancel = register(org.fix4j.spec.fix50sp2.msgtype.QuoteCancel.INSTANCE);
    public static final QuoteStatusRequest QuoteStatusRequest = register(org.fix4j.spec.fix50sp2.msgtype.QuoteStatusRequest.INSTANCE);
    public static final MassQuoteAcknowledgement MassQuoteAcknowledgement = register(org.fix4j.spec.fix50sp2.msgtype.MassQuoteAcknowledgement.INSTANCE);
    public static final SecurityDefinitionRequest SecurityDefinitionRequest = register(org.fix4j.spec.fix50sp2.msgtype.SecurityDefinitionRequest.INSTANCE);
    public static final SecurityDefinition SecurityDefinition = register(org.fix4j.spec.fix50sp2.msgtype.SecurityDefinition.INSTANCE);
    public static final SecurityStatusRequest SecurityStatusRequest = register(org.fix4j.spec.fix50sp2.msgtype.SecurityStatusRequest.INSTANCE);
    public static final SecurityStatus SecurityStatus = register(org.fix4j.spec.fix50sp2.msgtype.SecurityStatus.INSTANCE);
    public static final TradingSessionStatusRequest TradingSessionStatusRequest = register(org.fix4j.spec.fix50sp2.msgtype.TradingSessionStatusRequest.INSTANCE);
    public static final TradingSessionStatus TradingSessionStatus = register(org.fix4j.spec.fix50sp2.msgtype.TradingSessionStatus.INSTANCE);
    public static final MassQuote MassQuote = register(org.fix4j.spec.fix50sp2.msgtype.MassQuote.INSTANCE);
    public static final BusinessMessageReject BusinessMessageReject = register(org.fix4j.spec.fix50sp2.msgtype.BusinessMessageReject.INSTANCE);
    public static final BidRequest BidRequest = register(org.fix4j.spec.fix50sp2.msgtype.BidRequest.INSTANCE);
    public static final BidResponse BidResponse = register(org.fix4j.spec.fix50sp2.msgtype.BidResponse.INSTANCE);
    public static final ListStrikePrice ListStrikePrice = register(org.fix4j.spec.fix50sp2.msgtype.ListStrikePrice.INSTANCE);
    public static final RegistrationInstructions RegistrationInstructions = register(org.fix4j.spec.fix50sp2.msgtype.RegistrationInstructions.INSTANCE);
    public static final RegistrationInstructionsResponse RegistrationInstructionsResponse = register(org.fix4j.spec.fix50sp2.msgtype.RegistrationInstructionsResponse.INSTANCE);
    public static final OrderMassCancelRequest OrderMassCancelRequest = register(org.fix4j.spec.fix50sp2.msgtype.OrderMassCancelRequest.INSTANCE);
    public static final OrderMassCancelReport OrderMassCancelReport = register(org.fix4j.spec.fix50sp2.msgtype.OrderMassCancelReport.INSTANCE);
    public static final NewOrderCross NewOrderCross = register(org.fix4j.spec.fix50sp2.msgtype.NewOrderCross.INSTANCE);
    public static final CrossOrderCancelReplaceRequest CrossOrderCancelReplaceRequest = register(org.fix4j.spec.fix50sp2.msgtype.CrossOrderCancelReplaceRequest.INSTANCE);
    public static final CrossOrderCancelRequest CrossOrderCancelRequest = register(org.fix4j.spec.fix50sp2.msgtype.CrossOrderCancelRequest.INSTANCE);
    public static final SecurityTypeRequest SecurityTypeRequest = register(org.fix4j.spec.fix50sp2.msgtype.SecurityTypeRequest.INSTANCE);
    public static final SecurityTypes SecurityTypes = register(org.fix4j.spec.fix50sp2.msgtype.SecurityTypes.INSTANCE);
    public static final SecurityListRequest SecurityListRequest = register(org.fix4j.spec.fix50sp2.msgtype.SecurityListRequest.INSTANCE);
    public static final SecurityList SecurityList = register(org.fix4j.spec.fix50sp2.msgtype.SecurityList.INSTANCE);
    public static final DerivativeSecurityListRequest DerivativeSecurityListRequest = register(org.fix4j.spec.fix50sp2.msgtype.DerivativeSecurityListRequest.INSTANCE);
    public static final DerivativeSecurityList DerivativeSecurityList = register(org.fix4j.spec.fix50sp2.msgtype.DerivativeSecurityList.INSTANCE);
    public static final NewOrderMultileg NewOrderMultileg = register(org.fix4j.spec.fix50sp2.msgtype.NewOrderMultileg.INSTANCE);
    public static final MultilegOrderCancelReplace MultilegOrderCancelReplace = register(org.fix4j.spec.fix50sp2.msgtype.MultilegOrderCancelReplace.INSTANCE);
    public static final TradeCaptureReportRequest TradeCaptureReportRequest = register(org.fix4j.spec.fix50sp2.msgtype.TradeCaptureReportRequest.INSTANCE);
    public static final TradeCaptureReport TradeCaptureReport = register(org.fix4j.spec.fix50sp2.msgtype.TradeCaptureReport.INSTANCE);
    public static final OrderMassStatusRequest OrderMassStatusRequest = register(org.fix4j.spec.fix50sp2.msgtype.OrderMassStatusRequest.INSTANCE);
    public static final QuoteRequestReject QuoteRequestReject = register(org.fix4j.spec.fix50sp2.msgtype.QuoteRequestReject.INSTANCE);
    public static final RFQRequest RFQRequest = register(org.fix4j.spec.fix50sp2.msgtype.RFQRequest.INSTANCE);
    public static final QuoteStatusReport QuoteStatusReport = register(org.fix4j.spec.fix50sp2.msgtype.QuoteStatusReport.INSTANCE);
    public static final QuoteResponse QuoteResponse = register(org.fix4j.spec.fix50sp2.msgtype.QuoteResponse.INSTANCE);
    public static final Confirmation Confirmation = register(org.fix4j.spec.fix50sp2.msgtype.Confirmation.INSTANCE);
    public static final PositionMaintenanceRequest PositionMaintenanceRequest = register(org.fix4j.spec.fix50sp2.msgtype.PositionMaintenanceRequest.INSTANCE);
    public static final PositionMaintenanceReport PositionMaintenanceReport = register(org.fix4j.spec.fix50sp2.msgtype.PositionMaintenanceReport.INSTANCE);
    public static final RequestForPositions RequestForPositions = register(org.fix4j.spec.fix50sp2.msgtype.RequestForPositions.INSTANCE);
    public static final RequestForPositionsAck RequestForPositionsAck = register(org.fix4j.spec.fix50sp2.msgtype.RequestForPositionsAck.INSTANCE);
    public static final PositionReport PositionReport = register(org.fix4j.spec.fix50sp2.msgtype.PositionReport.INSTANCE);
    public static final TradeCaptureReportRequestAck TradeCaptureReportRequestAck = register(org.fix4j.spec.fix50sp2.msgtype.TradeCaptureReportRequestAck.INSTANCE);
    public static final TradeCaptureReportAck TradeCaptureReportAck = register(org.fix4j.spec.fix50sp2.msgtype.TradeCaptureReportAck.INSTANCE);
    public static final AllocationReport AllocationReport = register(org.fix4j.spec.fix50sp2.msgtype.AllocationReport.INSTANCE);
    public static final AllocationReportAck AllocationReportAck = register(org.fix4j.spec.fix50sp2.msgtype.AllocationReportAck.INSTANCE);
    public static final Confirmation_Ack Confirmation_Ack = register(org.fix4j.spec.fix50sp2.msgtype.Confirmation_Ack.INSTANCE);
    public static final SettlementInstructionRequest SettlementInstructionRequest = register(org.fix4j.spec.fix50sp2.msgtype.SettlementInstructionRequest.INSTANCE);
    public static final AssignmentReport AssignmentReport = register(org.fix4j.spec.fix50sp2.msgtype.AssignmentReport.INSTANCE);
    public static final CollateralRequest CollateralRequest = register(org.fix4j.spec.fix50sp2.msgtype.CollateralRequest.INSTANCE);
    public static final CollateralAssignment CollateralAssignment = register(org.fix4j.spec.fix50sp2.msgtype.CollateralAssignment.INSTANCE);
    public static final CollateralResponse CollateralResponse = register(org.fix4j.spec.fix50sp2.msgtype.CollateralResponse.INSTANCE);
    public static final CollateralReport CollateralReport = register(org.fix4j.spec.fix50sp2.msgtype.CollateralReport.INSTANCE);
    public static final CollateralInquiry CollateralInquiry = register(org.fix4j.spec.fix50sp2.msgtype.CollateralInquiry.INSTANCE);
    public static final NetworkCounterpartySystemStatusRequest NetworkCounterpartySystemStatusRequest = register(org.fix4j.spec.fix50sp2.msgtype.NetworkCounterpartySystemStatusRequest.INSTANCE);
    public static final NetworkCounterpartySystemStatusResponse NetworkCounterpartySystemStatusResponse = register(org.fix4j.spec.fix50sp2.msgtype.NetworkCounterpartySystemStatusResponse.INSTANCE);
    public static final UserRequest UserRequest = register(org.fix4j.spec.fix50sp2.msgtype.UserRequest.INSTANCE);
    public static final UserResponse UserResponse = register(org.fix4j.spec.fix50sp2.msgtype.UserResponse.INSTANCE);
    public static final CollateralInquiryAck CollateralInquiryAck = register(org.fix4j.spec.fix50sp2.msgtype.CollateralInquiryAck.INSTANCE);
    public static final ConfirmationRequest ConfirmationRequest = register(org.fix4j.spec.fix50sp2.msgtype.ConfirmationRequest.INSTANCE);
    public static final ContraryIntentionReport ContraryIntentionReport = register(org.fix4j.spec.fix50sp2.msgtype.ContraryIntentionReport.INSTANCE);
    public static final SecurityDefinitionUpdateReport SecurityDefinitionUpdateReport = register(org.fix4j.spec.fix50sp2.msgtype.SecurityDefinitionUpdateReport.INSTANCE);
    public static final SecurityListUpdateReport SecurityListUpdateReport = register(org.fix4j.spec.fix50sp2.msgtype.SecurityListUpdateReport.INSTANCE);
    public static final AdjustedPositionReport AdjustedPositionReport = register(org.fix4j.spec.fix50sp2.msgtype.AdjustedPositionReport.INSTANCE);
    public static final AllocationInstructionAlert AllocationInstructionAlert = register(org.fix4j.spec.fix50sp2.msgtype.AllocationInstructionAlert.INSTANCE);
    public static final ExecutionAcknowledgement ExecutionAcknowledgement = register(org.fix4j.spec.fix50sp2.msgtype.ExecutionAcknowledgement.INSTANCE);
    public static final TradingSessionList TradingSessionList = register(org.fix4j.spec.fix50sp2.msgtype.TradingSessionList.INSTANCE);
    public static final TradingSessionListRequest TradingSessionListRequest = register(org.fix4j.spec.fix50sp2.msgtype.TradingSessionListRequest.INSTANCE);
    public static final SettlementObligationReport SettlementObligationReport = register(org.fix4j.spec.fix50sp2.msgtype.SettlementObligationReport.INSTANCE);
    public static final DerivativeSecurityListUpdateReport DerivativeSecurityListUpdateReport = register(org.fix4j.spec.fix50sp2.msgtype.DerivativeSecurityListUpdateReport.INSTANCE);
    public static final TradingSessionListUpdateReport TradingSessionListUpdateReport = register(org.fix4j.spec.fix50sp2.msgtype.TradingSessionListUpdateReport.INSTANCE);
    public static final MarketDefinitionRequest MarketDefinitionRequest = register(org.fix4j.spec.fix50sp2.msgtype.MarketDefinitionRequest.INSTANCE);
    public static final MarketDefinition MarketDefinition = register(org.fix4j.spec.fix50sp2.msgtype.MarketDefinition.INSTANCE);
    public static final MarketDefinitionUpdateReport MarketDefinitionUpdateReport = register(org.fix4j.spec.fix50sp2.msgtype.MarketDefinitionUpdateReport.INSTANCE);
    public static final UserNotification UserNotification = register(org.fix4j.spec.fix50sp2.msgtype.UserNotification.INSTANCE);
    public static final OrderMassActionReport OrderMassActionReport = register(org.fix4j.spec.fix50sp2.msgtype.OrderMassActionReport.INSTANCE);
    public static final OrderMassActionRequest OrderMassActionRequest = register(org.fix4j.spec.fix50sp2.msgtype.OrderMassActionRequest.INSTANCE);
    public static final ApplicationMessageRequest ApplicationMessageRequest = register(org.fix4j.spec.fix50sp2.msgtype.ApplicationMessageRequest.INSTANCE);
    public static final ApplicationMessageRequestAck ApplicationMessageRequestAck = register(org.fix4j.spec.fix50sp2.msgtype.ApplicationMessageRequestAck.INSTANCE);
    public static final ApplicationMessageReport ApplicationMessageReport = register(org.fix4j.spec.fix50sp2.msgtype.ApplicationMessageReport.INSTANCE);
    public static final StreamAssignmentRequest StreamAssignmentRequest = register(org.fix4j.spec.fix50sp2.msgtype.StreamAssignmentRequest.INSTANCE);
    public static final StreamAssignmentReport StreamAssignmentReport = register(org.fix4j.spec.fix50sp2.msgtype.StreamAssignmentReport.INSTANCE);
    public static final StreamAssignmentReportACK StreamAssignmentReportACK = register(org.fix4j.spec.fix50sp2.msgtype.StreamAssignmentReportACK.INSTANCE);
    public static final PartyDetailsListRequest PartyDetailsListRequest = register(org.fix4j.spec.fix50sp2.msgtype.PartyDetailsListRequest.INSTANCE);
    public static final PartyDetailsListReport PartyDetailsListReport = register(org.fix4j.spec.fix50sp2.msgtype.PartyDetailsListReport.INSTANCE);

    private static <T extends MsgType> T register(final T msgType) {
        msgTypesByTagStr.put(msgType.getTag().getValue(), msgType);
        msgTypesByName.put(msgType.getName(), msgType);
        for(final GroupType groupType: msgType.getAllGroupTypesRecursively()){
            groupTypesByKey.put(groupType.getGroupKey(msgType), groupType);
        }
        return msgType;
    }

    //Private, as this sucker should not be instantiated
    private MsgTypes(){}

    public static MsgType getMsgTypeByTag(final Tag<String> tag) {
        return msgTypesByTagStr.get(tag.getValue());
    }

    public static GroupType getGroupTypeByKey(final GroupKey groupKey) {
        return groupTypesByKey.get(groupKey);
    }

    public static MsgType getMsgTypeByName(final String msgTypeName) {
        return msgTypesByName.get(msgTypeName);
    }
}
