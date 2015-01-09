package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class SettlementInstructionRequest extends BaseMsgType{
    public static final SettlementInstructionRequest INSTANCE = new SettlementInstructionRequest();

    private SettlementInstructionRequest() {
        super(
            "SettlementInstructionRequest",
            "AV",
            "app",
            FieldTypes.SettlInstReqID.required(true),
            FieldTypes.TransactTime.required(true),
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
            FieldTypes.AllocAccount.required(false),
            FieldTypes.AllocAcctIDSource.required(false),
            FieldTypes.Side.required(false),
            FieldTypes.Product.required(false),
            FieldTypes.SecurityType.required(false),
            FieldTypes.CFICode.required(false),
            FieldTypes.SettlCurrency.required(false),
            FieldTypes.EffectiveTime.required(false),
            FieldTypes.ExpireTime.required(false),
            FieldTypes.LastUpdateTime.required(false),
            FieldTypes.StandInstDbType.required(false),
            FieldTypes.StandInstDbName.required(false),
            FieldTypes.StandInstDbID.required(false)
        );
    }
}
