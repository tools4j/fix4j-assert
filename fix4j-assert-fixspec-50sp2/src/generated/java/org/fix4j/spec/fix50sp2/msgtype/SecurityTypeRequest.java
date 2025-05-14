package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class SecurityTypeRequest extends BaseMsgType{
    public static final SecurityTypeRequest INSTANCE = new SecurityTypeRequest();

    private SecurityTypeRequest() {
        super(
            "SecurityTypeRequest",
            "v",
            "app",
            FieldTypes.SecurityReqID.required(true),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false),
            FieldTypes.MarketID.required(false),
            FieldTypes.MarketSegmentID.required(false),
            FieldTypes.TradingSessionID.required(false),
            FieldTypes.TradingSessionSubID.required(false),
            FieldTypes.Product.required(false),
            FieldTypes.SecurityType.required(false),
            FieldTypes.SecuritySubType.required(false)
        );
    }
}
