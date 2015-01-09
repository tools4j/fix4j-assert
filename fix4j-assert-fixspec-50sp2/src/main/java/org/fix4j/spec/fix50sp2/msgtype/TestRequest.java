package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class TestRequest extends BaseMsgType{
    public static final TestRequest INSTANCE = new TestRequest();

    private TestRequest() {
        super(
            "TestRequest",
            "1",
            "admin",
            FieldTypes.TestReqID.required(true)
        );
    }
}
