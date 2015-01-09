package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class PartyDetailsListRequest extends BaseMsgType{
    public static final PartyDetailsListRequest INSTANCE = new PartyDetailsListRequest();

    private PartyDetailsListRequest() {
        super(
            "PartyDetailsListRequest",
            "CF",
            "app",
            FieldTypes.PartyDetailsListRequestID.required(true),
            new BaseGroupType(
                FieldTypes.NoPartyListResponseTypes.required(true),
                FieldTypes.PartyListResponseType.required(true)
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
            new BaseGroupType(
                FieldTypes.NoRequestedPartyRoles.required(false),
                FieldTypes.RequestedPartyRole.required(false)
            ),
            new BaseGroupType(
                FieldTypes.NoPartyRelationships.required(false),
                FieldTypes.PartyRelationship.required(false)
            ),
            FieldTypes.SubscriptionRequestType.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
