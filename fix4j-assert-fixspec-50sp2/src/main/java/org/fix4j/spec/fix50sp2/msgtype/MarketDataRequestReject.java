package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class MarketDataRequestReject extends BaseMsgType{
    public static final MarketDataRequestReject INSTANCE = new MarketDataRequestReject();

    private MarketDataRequestReject() {
        super(
            "MarketDataRequestReject",
            "Y",
            "app",
            FieldTypes.MDReqID.required(true),
            new BaseGroupType(
                FieldTypes.NoPartyIDs.required(false),
                FieldTypes.PartyID.required(false),
                FieldTypes.PartyIDSource.required(false),
                FieldTypes.PartyRole.required(false),
                new BaseGroupType(
                    FieldTypes.NoPartySubIDs.required(false),
                    FieldTypes.PartySubID.required(false),
                    FieldTypes.PartySubIDType.required(false)
                )
            ),
            FieldTypes.MDReqRejReason.required(false),
            new BaseGroupType(
                FieldTypes.NoAltMDSource.required(false),
                FieldTypes.AltMDSourceID.required(false)
            ),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
