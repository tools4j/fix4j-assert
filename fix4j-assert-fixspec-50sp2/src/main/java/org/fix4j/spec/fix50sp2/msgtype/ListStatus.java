package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class ListStatus extends BaseMsgType{
    public static final ListStatus INSTANCE = new ListStatus();

    private ListStatus() {
        super(
            "ListStatus",
            "N",
            "app",
            FieldTypes.ListID.required(true),
            FieldTypes.ListStatusType.required(true),
            FieldTypes.NoRpts.required(true),
            FieldTypes.ListOrderStatus.required(true),
            FieldTypes.ContingencyType.required(false),
            FieldTypes.ListRejectReason.required(false),
            FieldTypes.RptSeq.required(true),
            FieldTypes.ListStatusText.required(false),
            FieldTypes.EncodedListStatusTextLen.required(false),
            FieldTypes.EncodedListStatusText.required(false),
            FieldTypes.TransactTime.required(false),
            FieldTypes.TotNoOrders.required(true),
            FieldTypes.LastFragment.required(false),
            new BaseGroupType(
                FieldTypes.NoOrders.required(true),
                FieldTypes.ClOrdID.required(false),
                FieldTypes.OrderID.required(false),
                FieldTypes.SecondaryClOrdID.required(false),
                FieldTypes.CumQty.required(true),
                FieldTypes.OrdStatus.required(true),
                FieldTypes.WorkingIndicator.required(false),
                FieldTypes.LeavesQty.required(true),
                FieldTypes.CxlQty.required(true),
                FieldTypes.AvgPx.required(true),
                FieldTypes.OrdRejReason.required(false),
                FieldTypes.Text.required(false),
                FieldTypes.EncodedTextLen.required(false),
                FieldTypes.EncodedText.required(false)
            )
        );
    }
}
