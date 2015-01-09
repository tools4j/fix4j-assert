package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class RegistrationInstructions extends BaseMsgType{
    public static final RegistrationInstructions INSTANCE = new RegistrationInstructions();

    private RegistrationInstructions() {
        super(
            "RegistrationInstructions",
            "o",
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
            FieldTypes.RegistAcctType.required(false),
            FieldTypes.TaxAdvantageType.required(false),
            FieldTypes.OwnershipType.required(false),
            new BaseGroupType(
                FieldTypes.NoRegistDtls.required(false),
                FieldTypes.RegistDtls.required(false),
                FieldTypes.RegistEmail.required(false),
                FieldTypes.MailingDtls.required(false),
                FieldTypes.MailingInst.required(false),
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
                ),
                FieldTypes.OwnerType.required(false),
                FieldTypes.DateOfBirth.required(false),
                FieldTypes.InvestorCountryOfResidence.required(false)
            ),
            new BaseGroupType(
                FieldTypes.NoDistribInsts.required(false),
                FieldTypes.DistribPaymentMethod.required(false),
                FieldTypes.DistribPercentage.required(false),
                FieldTypes.CashDistribCurr.required(false),
                FieldTypes.CashDistribAgentName.required(false),
                FieldTypes.CashDistribAgentCode.required(false),
                FieldTypes.CashDistribAgentAcctNumber.required(false),
                FieldTypes.CashDistribPayRef.required(false),
                FieldTypes.CashDistribAgentAcctName.required(false)
            )
        );
    }
}
