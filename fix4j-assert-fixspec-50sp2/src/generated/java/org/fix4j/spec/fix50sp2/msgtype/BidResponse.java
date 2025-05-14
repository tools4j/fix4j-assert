package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class BidResponse extends BaseMsgType{
    public static final BidResponse INSTANCE = new BidResponse();

    private BidResponse() {
        super(
            "BidResponse",
            "l",
            "app",
            FieldTypes.BidID.required(false),
            FieldTypes.ClientBidID.required(false),
            new BaseGroupType(
                FieldTypes.NoBidComponents.required(true),
                FieldTypes.Commission.required(false),
                FieldTypes.CommType.required(false),
                FieldTypes.CommCurrency.required(false),
                FieldTypes.FundRenewWaiv.required(false),
                FieldTypes.ListID.required(false),
                FieldTypes.Country.required(false),
                FieldTypes.Side.required(false),
                FieldTypes.Price.required(false),
                FieldTypes.PriceType.required(false),
                FieldTypes.FairValue.required(false),
                FieldTypes.NetGrossInd.required(false),
                FieldTypes.SettlType.required(false),
                FieldTypes.SettlDate.required(false),
                FieldTypes.TradingSessionID.required(false),
                FieldTypes.TradingSessionSubID.required(false),
                FieldTypes.Text.required(false),
                FieldTypes.EncodedTextLen.required(false),
                FieldTypes.EncodedText.required(false)
            )
        );
    }
}
