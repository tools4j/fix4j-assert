package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class RegistrationInstructionsResponse extends BaseMsgType{
    public static final RegistrationInstructionsResponse INSTANCE = new RegistrationInstructionsResponse();

    private RegistrationInstructionsResponse() {
        super(
            "RegistrationInstructionsResponse",
            "p",
            "app",
            FieldTypes.RegistID.required(true),
            FieldTypes.RegistTransType.required(true),
            FieldTypes.RegistRefID.required(true),
            FieldTypes.ClOrdID.required(false),
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
            FieldTypes.Account.required(false),
            FieldTypes.AcctIDSource.required(false),
            FieldTypes.RegistStatus.required(true),
            FieldTypes.RegistRejReasonCode.required(false),
            FieldTypes.RegistRejReasonText.required(false)
        );
    }
}
