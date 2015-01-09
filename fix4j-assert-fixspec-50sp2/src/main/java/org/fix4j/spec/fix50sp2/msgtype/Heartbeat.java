package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class Heartbeat extends BaseMsgType{
    public static final Heartbeat INSTANCE = new Heartbeat();

    private Heartbeat() {
        super(
            "Heartbeat",
            "0",
            "admin",
            FieldTypes.TestReqID.required(false)
        );
    }
}
