package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class ApplicationMessageRequestAck extends BaseMsgType{
    public static final ApplicationMessageRequestAck INSTANCE = new ApplicationMessageRequestAck();

    private ApplicationMessageRequestAck() {
        super(
            "ApplicationMessageRequestAck",
            "BX",
            "app",
            FieldTypes.ApplResponseID.required(true),
            FieldTypes.ApplReqID.required(false),
            FieldTypes.ApplReqType.required(false),
            FieldTypes.ApplResponseType.required(false),
            FieldTypes.ApplTotalMessageCount.required(false),
            new BaseGroupType(
                FieldTypes.NoApplIDs.required(false),
                FieldTypes.RefApplID.required(false),
                FieldTypes.RefApplReqID.required(false),
                FieldTypes.ApplBegSeqNum.required(false),
                FieldTypes.ApplEndSeqNum.required(false),
                FieldTypes.RefApplLastSeqNum.required(false),
                FieldTypes.ApplResponseError.required(false),
                new BaseGroupType(
                    FieldTypes.NoNestedPartyIDs.required(false),
                    FieldTypes.NestedPartyID.required(false),
                    FieldTypes.NestedPartyIDSource.required(false),
                    FieldTypes.NestedPartyRole.required(false),
                    new BaseGroupType(
                        FieldTypes.NoNestedPartySubIDs.required(false),
                        FieldTypes.NestedPartySubID.required(false),
                        FieldTypes.NestedPartySubIDType.required(false)
                    )
                )
            ),
            new BaseGroupType(
                FieldTypes.NoPartyIDs.required(false),
                FieldTypes.PartyID.required(false),
                FieldTypes.PartyIDSource.required(false),
                FieldTypes.PartyRole.required(false),
                new BaseGroupType(
                    FieldTypes.NoPartySubIDs.required(false),
                    FieldTypes.PartySubID.required(false),
                    FieldTypes.PartySubIDType.required(false)
                )
            ),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
