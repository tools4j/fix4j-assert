package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class AllocationReportAck extends BaseMsgType{
    public static final AllocationReportAck INSTANCE = new AllocationReportAck();

    private AllocationReportAck() {
        super(
            "AllocationReportAck",
            "AT",
            "app",
            FieldTypes.AllocReportID.required(true),
            FieldTypes.AllocID.required(false),
            FieldTypes.ClearingBusinessDate.required(false),
            FieldTypes.AvgPxIndicator.required(false),
            FieldTypes.Quantity.required(false),
            FieldTypes.AllocTransType.required(false),
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
            FieldTypes.SecondaryAllocID.required(false),
            FieldTypes.TradeDate.required(false),
            FieldTypes.TransactTime.required(false),
            FieldTypes.AllocStatus.required(false),
            FieldTypes.AllocRejCode.required(false),
            FieldTypes.AllocReportType.required(false),
            FieldTypes.AllocIntermedReqType.required(false),
            FieldTypes.MatchStatus.required(false),
            FieldTypes.Product.required(false),
            FieldTypes.SecurityType.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false),
            new BaseGroupType(
                FieldTypes.NoAllocs.required(false),
                FieldTypes.AllocAccount.required(false),
                FieldTypes.AllocAcctIDSource.required(false),
                FieldTypes.AllocPrice.required(false),
                FieldTypes.AllocPositionEffect.required(false),
                FieldTypes.IndividualAllocID.required(false),
                FieldTypes.IndividualAllocRejCode.required(false),
                new BaseGroupType(
                    FieldTypes.NoNestedPartyIDs.required(false),
                    FieldTypes.NestedPartyID.required(false),
                    FieldTypes.NestedPartyIDSource.required(false),
                    FieldTypes.NestedPartyRole.required(false),
                    new BaseGroupType(
                        FieldTypes.NoNestedPartySubIDs.required(false),
                        FieldTypes.NestedPartySubID.required(false),
                        FieldTypes.NestedPartySubIDType.required(false)
                    )
                ),
                FieldTypes.AllocText.required(false),
                FieldTypes.EncodedAllocTextLen.required(false),
                FieldTypes.EncodedAllocText.required(false),
                FieldTypes.SecondaryIndividualAllocID.required(false),
                FieldTypes.AllocCustomerCapacity.required(false),
                FieldTypes.IndividualAllocType.required(false),
                FieldTypes.AllocQty.required(false)
            )
        );
    }
}
