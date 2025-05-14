package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class Confirmation_Ack extends BaseMsgType{
    public static final Confirmation_Ack INSTANCE = new Confirmation_Ack();

    private Confirmation_Ack() {
        super(
            "Confirmation_Ack",
            "AU",
            "app",
            FieldTypes.ConfirmID.required(true),
            FieldTypes.TradeDate.required(true),
            FieldTypes.TransactTime.required(true),
            FieldTypes.AffirmStatus.required(true),
            FieldTypes.ConfirmRejReason.required(false),
            FieldTypes.MatchStatus.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
