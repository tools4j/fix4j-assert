package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class ListExecute extends BaseMsgType{
    public static final ListExecute INSTANCE = new ListExecute();

    private ListExecute() {
        super(
            "ListExecute",
            "L",
            "app",
            FieldTypes.ListID.required(true),
            FieldTypes.ClientBidID.required(false),
            FieldTypes.BidID.required(false),
            FieldTypes.TransactTime.required(true),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
