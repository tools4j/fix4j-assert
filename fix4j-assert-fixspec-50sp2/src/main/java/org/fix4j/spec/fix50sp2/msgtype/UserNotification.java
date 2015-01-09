package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class UserNotification extends BaseMsgType{
    public static final UserNotification INSTANCE = new UserNotification();

    private UserNotification() {
        super(
            "UserNotification",
            "CB",
            "app",
            new BaseGroupType(
                FieldTypes.NoUsernames.required(false),
                FieldTypes.Username.required(false)
            ),
            FieldTypes.UserStatus.required(true),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
