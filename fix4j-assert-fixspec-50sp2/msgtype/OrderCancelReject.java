package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class OrderCancelReject extends BaseMsgType{
    public static final OrderCancelReject INSTANCE = new OrderCancelReject();

    private OrderCancelReject() {
        super(
            "OrderCancelReject",
            "9",
            "app",
            FieldTypes.OrderID.required(true),
            FieldTypes.SecondaryOrderID.required(false),
            FieldTypes.SecondaryClOrdID.required(false),
            FieldTypes.ClOrdID.required(true),
            FieldTypes.ClOrdLinkID.required(false),
            FieldTypes.OrigClOrdID.required(false),
            FieldTypes.OrdStatus.required(true),
            FieldTypes.WorkingIndicator.required(false),
            FieldTypes.OrigOrdModTime.required(false),
            FieldTypes.ListID.required(false),
            FieldTypes.Account.required(false),
            FieldTypes.AcctIDSource.required(false),
            FieldTypes.AccountType.required(false),
            FieldTypes.TradeOriginationDate.required(false),
            FieldTypes.TradeDate.required(false),
            FieldTypes.TransactTime.required(false),
            FieldTypes.CxlRejResponseTo.required(true),
            FieldTypes.CxlRejReason.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
