package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class UserResponse extends BaseMsgType{
    public static final UserResponse INSTANCE = new UserResponse();

    private UserResponse() {
        super(
            "UserResponse",
            "BF",
            "app",
            FieldTypes.UserRequestID.required(true),
            FieldTypes.Username.required(true),
            FieldTypes.UserStatus.required(false),
            FieldTypes.UserStatusText.required(false)
        );
    }
}
