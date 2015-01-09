package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class TradingSessionStatusRequest extends BaseMsgType{
    public static final TradingSessionStatusRequest INSTANCE = new TradingSessionStatusRequest();

    private TradingSessionStatusRequest() {
        super(
            "TradingSessionStatusRequest",
            "g",
            "app",
            FieldTypes.TradSesReqID.required(true),
            FieldTypes.MarketID.required(false),
            FieldTypes.MarketSegmentID.required(false),
            FieldTypes.TradingSessionID.required(false),
            FieldTypes.TradingSessionSubID.required(false),
            FieldTypes.TradSesMethod.required(false),
            FieldTypes.TradSesMode.required(false),
            FieldTypes.SubscriptionRequestType.required(true),
            FieldTypes.SecurityExchange.required(false)
        );
    }
}
