package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class PartyDetailsListReport extends BaseMsgType{
    public static final PartyDetailsListReport INSTANCE = new PartyDetailsListReport();

    private PartyDetailsListReport() {
        super(
            "PartyDetailsListReport",
            "CG",
            "app",
            FieldTypes.ApplID.required(false),
            FieldTypes.ApplSeqNum.required(false),
            FieldTypes.ApplLastSeqNum.required(false),
            FieldTypes.ApplResendFlag.required(false),
            FieldTypes.PartyDetailsListReportID.required(true),
            FieldTypes.PartyDetailsListRequestID.required(false),
            FieldTypes.PartyDetailsRequestResult.required(false),
            FieldTypes.TotNoPartyList.required(false),
            FieldTypes.LastFragment.required(false),
            new BaseGroupType(
                FieldTypes.NoPartyList.required(false),
                FieldTypes.PartyID.required(true),
                FieldTypes.PartyIDSource.required(true),
                FieldTypes.PartyRole.required(true),
                new BaseGroupType(
                    FieldTypes.NoPartySubIDs.required(false),
                    FieldTypes.PartySubID.required(false),
                    FieldTypes.PartySubIDType.required(false)
                ),
                new BaseGroupType(
                    FieldTypes.NoPartyAltIDs.required(false),
                    FieldTypes.PartyAltID.required(false),
                    FieldTypes.PartyAltIDSource.required(false),
                    new BaseGroupType(
                        FieldTypes.NoPartyAltSubIDs.required(false),
                        FieldTypes.PartyAltSubID.required(false),
                        FieldTypes.PartyAltSubIDType.required(false)
                    )
                ),
                new BaseGroupType(
                    FieldTypes.NoContextPartyIDs.required(false),
                    FieldTypes.ContextPartyID.required(false),
                    FieldTypes.ContextPartyIDSource.required(false),
                    FieldTypes.ContextPartyRole.required(false),
                    new BaseGroupType(
                        FieldTypes.NoContextPartySubIDs.required(false),
                        FieldTypes.ContextPartySubID.required(false),
                        FieldTypes.ContextPartySubIDType.required(false)
                    )
                ),
                new BaseGroupType(
                    FieldTypes.NoRiskLimits.required(false),
                    FieldTypes.RiskLimitType.required(false),
                    FieldTypes.RiskLimitAmount.required(false),
                    FieldTypes.RiskLimitCurrency.required(false),
                    FieldTypes.RiskLimitPlatform.required(false),
                    new BaseGroupType(
                        FieldTypes.NoRiskInstruments.required(false),
                        FieldTypes.RiskInstrumentOperator.required(false),
                        FieldTypes.RiskSymbol.required(false),
                        FieldTypes.RiskSymbolSfx.required(false),
                        FieldTypes.RiskSecurityID.required(false),
                        FieldTypes.RiskSecurityIDSource.required(false),
                        new BaseGroupType(
                            FieldTypes.NoRiskSecurityAltID.required(false),
                            FieldTypes.NoRiskSecurityAltID.required(false),
                            FieldTypes.RiskSecurityAltID.required(false),
                            FieldTypes.RiskSecurityAltIDSource.required(false)
                        ),
                        FieldTypes.RiskProduct.required(false),
                        FieldTypes.RiskProductComplex.required(false),
                        FieldTypes.RiskSecurityGroup.required(false),
                        FieldTypes.RiskCFICode.required(false),
                        FieldTypes.RiskSecurityType.required(false),
                        FieldTypes.RiskSecuritySubType.required(false),
                        FieldTypes.RiskMaturityMonthYear.required(false),
                        FieldTypes.RiskMaturityTime.required(false),
                        FieldTypes.RiskRestructuringType.required(false),
                        FieldTypes.RiskSeniority.required(false),
                        FieldTypes.RiskPutOrCall.required(false),
                        FieldTypes.RiskFlexibleIndicator.required(false),
                        FieldTypes.RiskCouponRate.required(false),
                        FieldTypes.RiskSecurityExchange.required(false),
                        FieldTypes.RiskSecurityDesc.required(false),
                        FieldTypes.RiskEncodedSecurityDescLen.required(false),
                        FieldTypes.RiskEncodedSecurityDesc.required(false),
                        FieldTypes.RiskInstrumentSettlType.required(false),
                        FieldTypes.RiskInstrumentMultiplier.required(false)
                    ),
                    new BaseGroupType(
                        FieldTypes.NoRiskWarningLevels.required(false),
                        FieldTypes.RiskWarningLevelPercent.required(false),
                        FieldTypes.RiskWarningLevelName.required(false)
                    )
                ),
                new BaseGroupType(
                    FieldTypes.NoRelatedPartyIDs.required(false),
                    FieldTypes.RelatedPartyID.required(false),
                    FieldTypes.RelatedPartyIDSource.required(false),
                    FieldTypes.RelatedPartyRole.required(false),
                    new BaseGroupType(
                        FieldTypes.NoRelatedPartySubIDs.required(false),
                        FieldTypes.RelatedPartySubID.required(false),
                        FieldTypes.RelatedPartySubIDType.required(false)
                    ),
                    new BaseGroupType(
                        FieldTypes.NoRelatedPartyAltIDs.required(false),
                        FieldTypes.RelatedPartyAltID.required(false),
                        FieldTypes.RelatedPartyAltIDSource.required(false),
                        new BaseGroupType(
                            FieldTypes.NoRelatedPartyAltSubIDs.required(false),
                            FieldTypes.RelatedPartyAltSubID.required(false),
                            FieldTypes.RelatedPartyAltSubIDType.required(false)
                        )
                    ),
                    new BaseGroupType(
                        FieldTypes.NoRelatedContextPartyIDs.required(false),
                        FieldTypes.RelatedContextPartyID.required(false),
                        FieldTypes.RelatedContextPartyIDSource.required(false),
                        FieldTypes.RelatedContextPartyRole.required(false),
                        new BaseGroupType(
                            FieldTypes.NoRelatedContextPartySubIDs.required(false),
                            FieldTypes.RelatedContextPartySubID.required(false),
                            FieldTypes.RelatedContextPartySubIDType.required(false)
                        )
                    ),
                    new BaseGroupType(
                        FieldTypes.NoRelationshipRiskLimits.required(false),
                        FieldTypes.RelationshipRiskLimitType.required(false),
                        FieldTypes.RelationshipRiskLimitAmount.required(false),
                        FieldTypes.RelationshipRiskLimitCurrency.required(false),
                        FieldTypes.RelationshipRiskLimitPlatform.required(false),
                        new BaseGroupType(
                            FieldTypes.NoRelationshipRiskInstruments.required(false),
                            FieldTypes.RelationshipRiskInstrumentOperator.required(false),
                            FieldTypes.RelationshipRiskSymbol.required(false),
                            FieldTypes.RelationshipRiskSymbolSfx.required(false),
                            FieldTypes.RelationshipRiskSecurityID.required(false),
                            FieldTypes.RelationshipRiskSecurityIDSource.required(false),
                            new BaseGroupType(
                                FieldTypes.NoRelationshipRiskSecurityAltID.required(false),
                                FieldTypes.NoRelationshipRiskSecurityAltID.required(false),
                                FieldTypes.RelationshipRiskSecurityAltID.required(false),
                                FieldTypes.RelationshipRiskSecurityAltIDSource.required(false)
                            ),
                            FieldTypes.RelationshipRiskProduct.required(false),
                            FieldTypes.RelationshipRiskProductComplex.required(false),
                            FieldTypes.RelationshipRiskSecurityGroup.required(false),
                            FieldTypes.RelationshipRiskCFICode.required(false),
                            FieldTypes.RelationshipRiskSecurityType.required(false),
                            FieldTypes.RelationshipRiskSecuritySubType.required(false),
                            FieldTypes.RelationshipRiskMaturityMonthYear.required(false),
                            FieldTypes.RelationshipRiskMaturityTime.required(false),
                            FieldTypes.RelationshipRiskRestructuringType.required(false),
                            FieldTypes.RelationshipRiskSeniority.required(false),
                            FieldTypes.RelationshipRiskPutOrCall.required(false),
                            FieldTypes.RelationshipRiskFlexibleIndicator.required(false),
                            FieldTypes.RelationshipRiskCouponRate.required(false),
                            FieldTypes.RelationshipRiskSecurityExchange.required(false),
                            FieldTypes.RelationshipRiskSecurityDesc.required(false),
                            FieldTypes.RelationshipRiskEncodedSecurityDescLen.required(false),
                            FieldTypes.RelationshipRiskEncodedSecurityDesc.required(false),
                            FieldTypes.RelationshipRiskInstrumentSettlType.required(false),
                            FieldTypes.RelationshipRiskInstrumentMultiplier.required(false)
                        ),
                        new BaseGroupType(
                            FieldTypes.NoRelationshipRiskWarningLevels.required(false),
                            FieldTypes.RelationshipRiskWarningLevelPercent.required(false),
                            FieldTypes.RelationshipRiskWarningLevelName.required(false)
                        )
                    ),
                    new BaseGroupType(
                        FieldTypes.NoPartyRelationships.required(false),
                        FieldTypes.PartyRelationship.required(false)
                    )
                )
            ),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
