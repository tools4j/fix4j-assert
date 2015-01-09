package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class Reject extends BaseMsgType{
    public static final Reject INSTANCE = new Reject();

    private Reject() {
        super(
            "Reject",
            "3",
            "admin",
            FieldTypes.RefSeqNum.required(true),
            FieldTypes.RefTagID.required(false),
            FieldTypes.RefMsgType.required(false),
            FieldTypes.RefApplVerID.required(false),
            FieldTypes.RefApplExtID.required(false),
            FieldTypes.RefCstmApplVerID.required(false),
            FieldTypes.SessionRejectReason.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
