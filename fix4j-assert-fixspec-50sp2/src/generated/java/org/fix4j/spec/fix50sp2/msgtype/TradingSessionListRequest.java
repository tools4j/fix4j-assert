package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class TradingSessionListRequest extends BaseMsgType{
    public static final TradingSessionListRequest INSTANCE = new TradingSessionListRequest();

    private TradingSessionListRequest() {
        super(
            "TradingSessionListRequest",
            "BI",
            "app",
            FieldTypes.TradSesReqID.required(true),
            FieldTypes.MarketID.required(false),
            FieldTypes.MarketSegmentID.required(false),
            FieldTypes.TradingSessionID.required(false),
            FieldTypes.TradingSessionSubID.required(false),
            FieldTypes.SecurityExchange.required(false),
            FieldTypes.TradSesMethod.required(false),
            FieldTypes.TradSesMode.required(false),
            FieldTypes.SubscriptionRequestType.required(true)
        );
    }
}
