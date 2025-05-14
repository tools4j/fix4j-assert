package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class ListStatusRequest extends BaseMsgType{
    public static final ListStatusRequest INSTANCE = new ListStatusRequest();

    private ListStatusRequest() {
        super(
            "ListStatusRequest",
            "M",
            "app",
            FieldTypes.ListID.required(true),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
