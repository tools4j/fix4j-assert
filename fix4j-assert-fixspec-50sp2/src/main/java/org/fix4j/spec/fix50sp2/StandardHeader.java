package org.fix4j.spec.fix50sp2;

import org.fix4j.test.fixspec.BaseFieldAndGroupTypes;
import org.fix4j.test.fixspec.BaseGroupType;

public class StandardHeader extends BaseFieldAndGroupTypes {
    public StandardHeader(){
        super(
            FieldTypes.BeginString.required(true),
            FieldTypes.BodyLength.required(true),
            FieldTypes.MsgType.required(true),
            FieldTypes.ApplVerID.required(false),
            FieldTypes.CstmApplVerID.required(false),
            FieldTypes.ApplExtID.required(false),
            FieldTypes.SenderCompID.required(true),
            FieldTypes.TargetCompID.required(true),
            FieldTypes.OnBehalfOfCompID.required(false),
            FieldTypes.DeliverToCompID.required(false),
            FieldTypes.SecureDataLen.required(false),
            FieldTypes.SecureData.required(false),
            FieldTypes.MsgSeqNum.required(true),
            FieldTypes.SenderSubID.required(false),
            FieldTypes.SenderLocationID.required(false),
            FieldTypes.TargetSubID.required(false),
            FieldTypes.TargetLocationID.required(false),
            FieldTypes.OnBehalfOfSubID.required(false),
            FieldTypes.OnBehalfOfLocationID.required(false),
            FieldTypes.DeliverToSubID.required(false),
            FieldTypes.DeliverToLocationID.required(false),
            FieldTypes.PossDupFlag.required(false),
            FieldTypes.PossResend.required(false),
            FieldTypes.SendingTime.required(true),
            FieldTypes.OrigSendingTime.required(false),
            FieldTypes.XmlDataLen.required(false),
            FieldTypes.XmlData.required(false),
            FieldTypes.MessageEncoding.required(false),
            FieldTypes.LastMsgSeqNumProcessed.required(false),
            new BaseGroupType(
                FieldTypes.NoHops.required(false),
                FieldTypes.HopCompID.required(false),
                FieldTypes.HopSendingTime.required(false),
                FieldTypes.HopRefID.required(false)
            )
        );
    }
}
