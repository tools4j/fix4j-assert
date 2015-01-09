package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class SettlementObligationReport extends BaseMsgType{
    public static final SettlementObligationReport INSTANCE = new SettlementObligationReport();

    private SettlementObligationReport() {
        super(
            "SettlementObligationReport",
            "BQ",
            "app",
            FieldTypes.ApplID.required(false),
            FieldTypes.ApplSeqNum.required(false),
            FieldTypes.ApplLastSeqNum.required(false),
            FieldTypes.ApplResendFlag.required(false),
            FieldTypes.ClearingBusinessDate.required(false),
            FieldTypes.SettlementCycleNo.required(false),
            FieldTypes.SettlObligMsgID.required(true),
            FieldTypes.SettlObligMode.required(true),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false),
            FieldTypes.TransactTime.required(false),
            new BaseGroupType(
                FieldTypes.NoSettlOblig.required(false),
                FieldTypes.NetGrossInd.required(false),
                FieldTypes.SettlObligID.required(false),
                FieldTypes.SettlObligTransType.required(false),
                FieldTypes.SettlObligRefID.required(false),
                FieldTypes.CcyAmt.required(false),
                FieldTypes.SettlCurrAmt.required(false),
                FieldTypes.Currency.required(false),
                FieldTypes.SettlCurrency.required(false),
                FieldTypes.SettlCurrFxRate.required(false),
                FieldTypes.SettlDate.required(false),
                FieldTypes.EffectiveTime.required(false),
                FieldTypes.ExpireTime.required(false),
                FieldTypes.LastUpdateTime.required(false),
                FieldTypes.Symbol.required(false),
                FieldTypes.SymbolSfx.required(false),
                FieldTypes.SecurityID.required(false),
                FieldTypes.SecurityIDSource.required(false),
                new BaseGroupType(
                    FieldTypes.NoSecurityAltID.required(false),
                    FieldTypes.SecurityAltID.required(false),
                    FieldTypes.SecurityAltIDSource.required(false)
                ),
                FieldTypes.Product.required(false),
                FieldTypes.SecurityGroup.required(false),
                FieldTypes.ProductComplex.required(false),
                FieldTypes.CFICode.required(false),
                FieldTypes.SecurityType.required(false),
                FieldTypes.SecuritySubType.required(false),
                FieldTypes.MaturityMonthYear.required(false),
                FieldTypes.MaturityDate.required(false),
                FieldTypes.SecurityStatus.required(false),
                FieldTypes.SettleOnOpenFlag.required(false),
                FieldTypes.InstrmtAssignmentMethod.required(false),
                FieldTypes.MaturityTime.required(false),
                FieldTypes.CouponPaymentDate.required(false),
                FieldTypes.RestructuringType.required(false),
                FieldTypes.Seniority.required(false),
                FieldTypes.NotionalPercentageOutstanding.required(false),
                FieldTypes.OriginalNotionalPercentageOutstanding.required(false),
                FieldTypes.AttachmentPoint.required(false),
                FieldTypes.DetachmentPoint.required(false),
                FieldTypes.IssueDate.required(false),
                FieldTypes.RepoCollateralSecurityType.required(false),
                FieldTypes.RepurchaseTerm.required(false),
                FieldTypes.RepurchaseRate.required(false),
                FieldTypes.Factor.required(false),
                FieldTypes.CreditRating.required(false),
                FieldTypes.InstrRegistry.required(false),
                FieldTypes.CountryOfIssue.required(false),
                FieldTypes.StateOrProvinceOfIssue.required(false),
                FieldTypes.LocaleOfIssue.required(false),
                FieldTypes.RedemptionDate.required(false),
                FieldTypes.StrikePrice.required(false),
                FieldTypes.StrikeCurrency.required(false),
                FieldTypes.StrikeMultiplier.required(false),
                FieldTypes.StrikeValue.required(false),
                FieldTypes.StrikePriceDeterminationMethod.required(false),
                FieldTypes.StrikePriceBoundaryMethod.required(false),
                FieldTypes.StrikePriceBoundaryPrecision.required(false),
                FieldTypes.UnderlyingPriceDeterminationMethod.required(false),
                FieldTypes.OptAttribute.required(false),
                FieldTypes.ContractMultiplier.required(false),
                FieldTypes.MinPriceIncrement.required(false),
                FieldTypes.UnitOfMeasure.required(false),
                FieldTypes.TimeUnit.required(false),
                FieldTypes.MinPriceIncrementAmount.required(false),
                FieldTypes.UnitOfMeasureQty.required(false),
                FieldTypes.PriceUnitOfMeasure.required(false),
                FieldTypes.PriceUnitOfMeasureQty.required(false),
                FieldTypes.SettlMethod.required(false),
                FieldTypes.ExerciseStyle.required(false),
                FieldTypes.OptPayoutAmount.required(false),
                FieldTypes.PriceQuoteMethod.required(false),
                FieldTypes.ListMethod.required(false),
                FieldTypes.CapPrice.required(false),
                FieldTypes.FloorPrice.required(false),
                FieldTypes.PutOrCall.required(false),
                FieldTypes.FlexibleIndicator.required(false),
                FieldTypes.FlexProductEligibilityIndicator.required(false),
                FieldTypes.ValuationMethod.required(false),
                FieldTypes.ContractMultiplierUnit.required(false),
                FieldTypes.FlowScheduleType.required(false),
                FieldTypes.OptPayoutType.required(false),
                FieldTypes.CouponRate.required(false),
                FieldTypes.SecurityExchange.required(false),
                FieldTypes.PositionLimit.required(false),
                FieldTypes.NTPositionLimit.required(false),
                FieldTypes.Issuer.required(false),
                FieldTypes.EncodedIssuerLen.required(false),
                FieldTypes.EncodedIssuer.required(false),
                FieldTypes.SecurityDesc.required(false),
                FieldTypes.EncodedSecurityDescLen.required(false),
                FieldTypes.EncodedSecurityDesc.required(false),
                FieldTypes.SecurityXMLLen.required(false),
                FieldTypes.SecurityXML.required(false),
                FieldTypes.SecurityXMLSchema.required(false),
                FieldTypes.Pool.required(false),
                FieldTypes.ContractSettlMonth.required(false),
                FieldTypes.CPProgram.required(false),
                FieldTypes.CPRegType.required(false),
                new BaseGroupType(
                    FieldTypes.NoEvents.required(false),
                    FieldTypes.EventType.required(false),
                    FieldTypes.EventDate.required(false),
                    FieldTypes.EventTime.required(false),
                    FieldTypes.EventPx.required(false),
                    FieldTypes.EventText.required(false)
                ),
                FieldTypes.DatedDate.required(false),
                FieldTypes.InterestAccrualDate.required(false),
                new BaseGroupType(
                    FieldTypes.NoInstrumentParties.required(false),
                    FieldTypes.InstrumentPartyID.required(false),
                    FieldTypes.InstrumentPartyIDSource.required(false),
                    FieldTypes.InstrumentPartyRole.required(false),
                    new BaseGroupType(
                        FieldTypes.NoInstrumentPartySubIDs.required(false),
                        FieldTypes.InstrumentPartySubID.required(false),
                        FieldTypes.InstrumentPartySubIDType.required(false)
                    )
                ),
                new BaseGroupType(
                    FieldTypes.NoComplexEvents.required(false),
                    FieldTypes.ComplexEventType.required(false),
                    FieldTypes.ComplexOptPayoutAmount.required(false),
                    FieldTypes.ComplexEventPrice.required(false),
                    FieldTypes.ComplexEventPriceBoundaryMethod.required(false),
                    FieldTypes.ComplexEventPriceBoundaryPrecision.required(false),
                    FieldTypes.ComplexEventPriceTimeType.required(false),
                    FieldTypes.ComplexEventCondition.required(false),
                    new BaseGroupType(
                        FieldTypes.NoComplexEventDates.required(false),
                        FieldTypes.ComplexEventStartDate.required(false),
                        FieldTypes.ComplexEventEndDate.required(false),
                        new BaseGroupType(
                            FieldTypes.NoComplexEventTimes.required(false),
                            FieldTypes.ComplexEventStartTime.required(false),
                            FieldTypes.ComplexEventEndTime.required(false)
                        )
                    )
                ),
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
                new BaseGroupType(
                    FieldTypes.NoSettlDetails.required(false),
                    FieldTypes.SettlObligSource.required(false),
                    new BaseGroupType(
                        FieldTypes.NoSettlPartyIDs.required(false),
                        FieldTypes.SettlPartyID.required(false),
                        FieldTypes.SettlPartyIDSource.required(false),
                        FieldTypes.SettlPartyRole.required(false),
                        new BaseGroupType(
                            FieldTypes.NoSettlPartySubIDs.required(false),
                            FieldTypes.SettlPartySubID.required(false),
                            FieldTypes.SettlPartySubIDType.required(false)
                        )
                    )
                )
            )
        );
    }
}
