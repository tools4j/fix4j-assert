package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class UserRequest extends BaseMsgType{
    public static final UserRequest INSTANCE = new UserRequest();

    private UserRequest() {
        super(
            "UserRequest",
            "BE",
            "app",
            FieldTypes.UserRequestID.required(true),
            FieldTypes.UserRequestType.required(true),
            FieldTypes.Username.required(true),
            FieldTypes.Password.required(false),
            FieldTypes.NewPassword.required(false),
            FieldTypes.EncryptedPasswordMethod.required(false),
            FieldTypes.EncryptedPasswordLen.required(false),
            FieldTypes.EncryptedPassword.required(false),
            FieldTypes.EncryptedNewPasswordLen.required(false),
            FieldTypes.EncryptedNewPassword.required(false),
            FieldTypes.RawDataLength.required(false),
            FieldTypes.RawData.required(false)
        );
    }
}
