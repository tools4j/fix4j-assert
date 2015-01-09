package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class BidRequest extends BaseMsgType{
    public static final BidRequest INSTANCE = new BidRequest();

    private BidRequest() {
        super(
            "BidRequest",
            "k",
            "app",
            FieldTypes.BidID.required(false),
            FieldTypes.ClientBidID.required(true),
            FieldTypes.BidRequestTransType.required(true),
            FieldTypes.ListName.required(false),
            FieldTypes.TotNoRelatedSym.required(true),
            FieldTypes.BidType.required(true),
            FieldTypes.NumTickets.required(false),
            FieldTypes.Currency.required(false),
            FieldTypes.SideValue1.required(false),
            FieldTypes.SideValue2.required(false),
            new BaseGroupType(
                FieldTypes.NoBidDescriptors.required(false),
                FieldTypes.BidDescriptorType.required(false),
                FieldTypes.BidDescriptor.required(false),
                FieldTypes.SideValueInd.required(false),
                FieldTypes.LiquidityValue.required(false),
                FieldTypes.LiquidityNumSecurities.required(false),
                FieldTypes.LiquidityPctLow.required(false),
                FieldTypes.LiquidityPctHigh.required(false),
                FieldTypes.EFPTrackingError.required(false),
                FieldTypes.FairValue.required(false),
                FieldTypes.OutsideIndexPct.required(false),
                FieldTypes.ValueOfFutures.required(false)
            ),
            new BaseGroupType(
                FieldTypes.NoBidComponents.required(false),
                FieldTypes.ListID.required(false),
                FieldTypes.Side.required(false),
                FieldTypes.TradingSessionID.required(false),
                FieldTypes.TradingSessionSubID.required(false),
                FieldTypes.NetGrossInd.required(false),
                FieldTypes.SettlType.required(false),
                FieldTypes.SettlDate.required(false),
                FieldTypes.Account.required(false),
                FieldTypes.AcctIDSource.required(false)
            ),
            FieldTypes.LiquidityIndType.required(false),
            FieldTypes.WtAverageLiquidity.required(false),
            FieldTypes.ExchangeForPhysical.required(false),
            FieldTypes.OutMainCntryUIndex.required(false),
            FieldTypes.CrossPercent.required(false),
            FieldTypes.ProgRptReqs.required(false),
            FieldTypes.ProgPeriodInterval.required(false),
            FieldTypes.IncTaxInd.required(false),
            FieldTypes.ForexReq.required(false),
            FieldTypes.NumBidders.required(false),
            FieldTypes.TradeDate.required(false),
            FieldTypes.BidTradeType.required(true),
            FieldTypes.BasisPxType.required(true),
            FieldTypes.StrikeTime.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
