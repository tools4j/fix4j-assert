package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class Logon extends BaseMsgType{
    public static final Logon INSTANCE = new Logon();

    private Logon() {
        super(
            "Logon",
            "A",
            "admin",
            FieldTypes.EncryptMethod.required(true),
            FieldTypes.HeartBtInt.required(true),
            FieldTypes.RawDataLength.required(false),
            FieldTypes.RawData.required(false),
            FieldTypes.ResetSeqNumFlag.required(false),
            FieldTypes.NextExpectedMsgSeqNum.required(false),
            FieldTypes.MaxMessageSize.required(false),
            new BaseGroupType(
                FieldTypes.NoMsgTypes.required(false),
                FieldTypes.RefMsgType.required(false),
                FieldTypes.MsgDirection.required(false),
                FieldTypes.RefApplVerID.required(false),
                FieldTypes.RefCstmApplVerID.required(false),
                FieldTypes.RefApplExtID.required(false),
                FieldTypes.DefaultVerIndicator.required(false)
            ),
            FieldTypes.TestMessageIndicator.required(false),
            FieldTypes.Username.required(false),
            FieldTypes.Password.required(false),
            FieldTypes.NewPassword.required(false),
            FieldTypes.EncryptedPasswordMethod.required(false),
            FieldTypes.EncryptedPasswordLen.required(false),
            FieldTypes.EncryptedPassword.required(false),
            FieldTypes.EncryptedNewPasswordLen.required(false),
            FieldTypes.EncryptedNewPassword.required(false),
            FieldTypes.SessionStatus.required(false),
            FieldTypes.DefaultApplVerID.required(true),
            FieldTypes.DefaultApplExtID.required(false),
            FieldTypes.DefaultCstmApplVerID.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
