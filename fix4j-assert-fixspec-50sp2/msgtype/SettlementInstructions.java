package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class SettlementInstructions extends BaseMsgType{
    public static final SettlementInstructions INSTANCE = new SettlementInstructions();

    private SettlementInstructions() {
        super(
            "SettlementInstructions",
            "T",
            "app",
            FieldTypes.SettlInstMsgID.required(true),
            FieldTypes.SettlInstReqID.required(false),
            FieldTypes.SettlInstMode.required(true),
            FieldTypes.SettlInstReqRejCode.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false),
            FieldTypes.ClOrdID.required(false),
            FieldTypes.TransactTime.required(true),
            new BaseGroupType(
                FieldTypes.NoSettlInst.required(false),
                FieldTypes.SettlInstID.required(false),
                FieldTypes.SettlInstTransType.required(false),
                FieldTypes.SettlInstRefID.required(false),
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
                FieldTypes.Side.required(false),
                FieldTypes.Product.required(false),
                FieldTypes.SecurityType.required(false),
                FieldTypes.CFICode.required(false),
                FieldTypes.SettlCurrency.required(false),
                FieldTypes.EffectiveTime.required(false),
                FieldTypes.ExpireTime.required(false),
                FieldTypes.LastUpdateTime.required(false),
                FieldTypes.SettlDeliveryType.required(false),
                FieldTypes.StandInstDbType.required(false),
                FieldTypes.StandInstDbName.required(false),
                FieldTypes.StandInstDbID.required(false),
                new BaseGroupType(
                    FieldTypes.NoDlvyInst.required(false),
                    FieldTypes.SettlInstSource.required(false),
                    FieldTypes.DlvyInstType.required(false),
                    new BaseGroupType(
                        FieldTypes.NoSettlPartyIDs.required(false),
                        FieldTypes.SettlPartyID.required(false),
                        FieldTypes.SettlPartyIDSource.required(false),
                        FieldTypes.SettlPartyRole.required(false),
                        new BaseGroupType(
                            FieldTypes.NoSettlPartySubIDs.required(false),
                            FieldTypes.SettlPartySubID.required(false),
                            FieldTypes.SettlPartySubIDType.required(false)
                        )
                    )
                ),
                FieldTypes.PaymentMethod.required(false),
                FieldTypes.PaymentRef.required(false),
                FieldTypes.CardHolderName.required(false),
                FieldTypes.CardNumber.required(false),
                FieldTypes.CardStartDate.required(false),
                FieldTypes.CardExpDate.required(false),
                FieldTypes.CardIssNum.required(false),
                FieldTypes.PaymentDate.required(false),
                FieldTypes.PaymentRemitterID.required(false)
            )
        );
    }
}
