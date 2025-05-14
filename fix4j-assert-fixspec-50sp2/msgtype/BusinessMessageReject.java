package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class BusinessMessageReject extends BaseMsgType{
    public static final BusinessMessageReject INSTANCE = new BusinessMessageReject();

    private BusinessMessageReject() {
        super(
            "BusinessMessageReject",
            "j",
            "app",
            FieldTypes.RefSeqNum.required(false),
            FieldTypes.RefMsgType.required(true),
            FieldTypes.RefApplVerID.required(false),
            FieldTypes.RefApplExtID.required(false),
            FieldTypes.RefCstmApplVerID.required(false),
            FieldTypes.BusinessRejectRefID.required(false),
            FieldTypes.BusinessRejectReason.required(true),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
