package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class MarketDefinitionUpdateReport extends BaseMsgType{
    public static final MarketDefinitionUpdateReport INSTANCE = new MarketDefinitionUpdateReport();

    private MarketDefinitionUpdateReport() {
        super(
            "MarketDefinitionUpdateReport",
            "BV",
            "app",
            FieldTypes.ApplID.required(false),
            FieldTypes.ApplSeqNum.required(false),
            FieldTypes.ApplLastSeqNum.required(false),
            FieldTypes.ApplResendFlag.required(false),
            FieldTypes.MarketReportID.required(true),
            FieldTypes.MarketReqID.required(false),
            FieldTypes.MarketUpdateAction.required(false),
            FieldTypes.MarketID.required(true),
            FieldTypes.MarketSegmentID.required(false),
            FieldTypes.MarketSegmentDesc.required(false),
            FieldTypes.EncodedMktSegmDescLen.required(false),
            FieldTypes.EncodedMktSegmDesc.required(false),
            FieldTypes.ParentMktSegmID.required(false),
            FieldTypes.Currency.required(false),
            FieldTypes.ExpirationCycle.required(false),
            FieldTypes.MinTradeVol.required(false),
            FieldTypes.MaxTradeVol.required(false),
            FieldTypes.MaxPriceVariation.required(false),
            FieldTypes.ImpliedMarketIndicator.required(false),
            FieldTypes.TradingCurrency.required(false),
            new BaseGroupType(
                FieldTypes.NoTickRules.required(false),
                FieldTypes.StartTickPriceRange.required(false),
                FieldTypes.EndTickPriceRange.required(false),
                FieldTypes.TickIncrement.required(false),
                FieldTypes.TickRuleType.required(false)
            ),
            new BaseGroupType(
                FieldTypes.NoLotTypeRules.required(false),
                FieldTypes.LotType.required(false),
                FieldTypes.MinLotSize.required(false)
            ),
            FieldTypes.PriceLimitType.required(false),
            FieldTypes.LowLimitPrice.required(false),
            FieldTypes.HighLimitPrice.required(false),
            FieldTypes.TradingReferencePrice.required(false),
            FieldTypes.RoundLot.required(false),
            FieldTypes.MultilegModel.required(false),
            FieldTypes.MultilegPriceMethod.required(false),
            FieldTypes.PriceType.required(false),
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
            FieldTypes.TransactTime.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
