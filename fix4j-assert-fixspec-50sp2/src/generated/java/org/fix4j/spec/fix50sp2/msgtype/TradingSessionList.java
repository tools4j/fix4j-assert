package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class TradingSessionList extends BaseMsgType{
    public static final TradingSessionList INSTANCE = new TradingSessionList();

    private TradingSessionList() {
        super(
            "TradingSessionList",
            "BJ",
            "app",
            FieldTypes.ApplID.required(false),
            FieldTypes.ApplSeqNum.required(false),
            FieldTypes.ApplLastSeqNum.required(false),
            FieldTypes.ApplResendFlag.required(false),
            FieldTypes.TradSesReqID.required(false),
            new BaseGroupType(
                FieldTypes.NoTradingSessions.required(true),
                FieldTypes.TradingSessionID.required(true),
                FieldTypes.TradingSessionSubID.required(false),
                FieldTypes.SecurityExchange.required(false),
                FieldTypes.TradSesMethod.required(false),
                FieldTypes.TradSesMode.required(false),
                FieldTypes.UnsolicitedIndicator.required(false),
                FieldTypes.TradSesStatus.required(true),
                FieldTypes.TradSesStatusRejReason.required(false),
                FieldTypes.TradSesStartTime.required(false),
                FieldTypes.MarketID.required(false),
                FieldTypes.MarketSegmentID.required(false),
                FieldTypes.TradingSessionDesc.required(false),
                FieldTypes.TradSesUpdateAction.required(false),
                FieldTypes.TradSesOpenTime.required(false),
                FieldTypes.TradSesPreCloseTime.required(false),
                FieldTypes.TradSesCloseTime.required(false),
                FieldTypes.TradSesEndTime.required(false),
                FieldTypes.TotalVolumeTraded.required(false),
                FieldTypes.Text.required(false),
                FieldTypes.EncodedTextLen.required(false),
                FieldTypes.EncodedText.required(false),
                FieldTypes.TransactTime.required(false),
                new BaseGroupType(
                    FieldTypes.NoOrdTypeRules.required(false),
                    FieldTypes.OrdType.required(false)
                ),
                new BaseGroupType(
                    FieldTypes.NoTimeInForceRules.required(false),
                    FieldTypes.TimeInForce.required(false)
                ),
                new BaseGroupType(
                    FieldTypes.NoExecInstRules.required(false),
                    FieldTypes.ExecInstValue.required(false)
                ),
                new BaseGroupType(
                    FieldTypes.NoMatchRules.required(false),
                    FieldTypes.MatchAlgorithm.required(false),
                    FieldTypes.MatchType.required(false)
                ),
                new BaseGroupType(
                    FieldTypes.NoMDFeedTypes.required(false),
                    FieldTypes.MDFeedType.required(false),
                    FieldTypes.MarketDepth.required(false),
                    FieldTypes.MDBookType.required(false)
                )
            )
        );
    }
}
