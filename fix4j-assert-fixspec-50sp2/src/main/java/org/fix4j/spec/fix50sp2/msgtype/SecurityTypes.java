package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class SecurityTypes extends BaseMsgType{
    public static final SecurityTypes INSTANCE = new SecurityTypes();

    private SecurityTypes() {
        super(
            "SecurityTypes",
            "w",
            "app",
            FieldTypes.ApplID.required(false),
            FieldTypes.ApplSeqNum.required(false),
            FieldTypes.ApplLastSeqNum.required(false),
            FieldTypes.ApplResendFlag.required(false),
            FieldTypes.SecurityReqID.required(true),
            FieldTypes.SecurityResponseID.required(true),
            FieldTypes.SecurityResponseType.required(true),
            FieldTypes.TotNoSecurityTypes.required(false),
            FieldTypes.LastFragment.required(false),
            new BaseGroupType(
                FieldTypes.NoSecurityTypes.required(false),
                FieldTypes.SecurityType.required(false),
                FieldTypes.SecuritySubType.required(false),
                FieldTypes.Product.required(false),
                FieldTypes.CFICode.required(false),
                FieldTypes.TransactTime.required(false)
            ),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false),
            FieldTypes.MarketID.required(false),
            FieldTypes.MarketSegmentID.required(false),
            FieldTypes.TradingSessionID.required(false),
            FieldTypes.TradingSessionSubID.required(false),
            FieldTypes.SubscriptionRequestType.required(false)
        );
    }
}
