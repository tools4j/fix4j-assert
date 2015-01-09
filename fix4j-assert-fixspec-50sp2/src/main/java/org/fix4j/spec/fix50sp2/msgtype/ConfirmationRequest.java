package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class ConfirmationRequest extends BaseMsgType{
    public static final ConfirmationRequest INSTANCE = new ConfirmationRequest();

    private ConfirmationRequest() {
        super(
            "ConfirmationRequest",
            "BH",
            "app",
            FieldTypes.ConfirmReqID.required(true),
            FieldTypes.ConfirmType.required(true),
            new BaseGroupType(
                FieldTypes.NoOrders.required(false),
                FieldTypes.ClOrdID.required(false),
                FieldTypes.OrderID.required(false),
                FieldTypes.SecondaryOrderID.required(false),
                FieldTypes.SecondaryClOrdID.required(false),
                FieldTypes.ListID.required(false),
                new BaseGroupType(
                    FieldTypes.NoNested2PartyIDs.required(false),
                    FieldTypes.Nested2PartyID.required(false),
                    FieldTypes.Nested2PartyIDSource.required(false),
                    FieldTypes.Nested2PartyRole.required(false),
                    new BaseGroupType(
                        FieldTypes.NoNested2PartySubIDs.required(false),
                        FieldTypes.Nested2PartySubID.required(false),
                        FieldTypes.Nested2PartySubIDType.required(false)
                    )
                ),
                FieldTypes.OrderQty.required(false),
                FieldTypes.OrderAvgPx.required(false),
                FieldTypes.OrderBookingQty.required(false)
            ),
            FieldTypes.AllocID.required(false),
            FieldTypes.SecondaryAllocID.required(false),
            FieldTypes.IndividualAllocID.required(false),
            FieldTypes.TransactTime.required(true),
            FieldTypes.AllocAccount.required(false),
            FieldTypes.AllocAcctIDSource.required(false),
            FieldTypes.AllocAccountType.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
