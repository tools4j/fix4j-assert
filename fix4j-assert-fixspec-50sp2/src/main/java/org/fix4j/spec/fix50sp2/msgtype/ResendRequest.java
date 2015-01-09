package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class ResendRequest extends BaseMsgType{
    public static final ResendRequest INSTANCE = new ResendRequest();

    private ResendRequest() {
        super(
            "ResendRequest",
            "2",
            "admin",
            FieldTypes.BeginSeqNo.required(true),
            FieldTypes.EndSeqNo.required(true)
        );
    }
}
