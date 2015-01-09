package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class Logout extends BaseMsgType{
    public static final Logout INSTANCE = new Logout();

    private Logout() {
        super(
            "Logout",
            "5",
            "admin",
            FieldTypes.SessionStatus.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
