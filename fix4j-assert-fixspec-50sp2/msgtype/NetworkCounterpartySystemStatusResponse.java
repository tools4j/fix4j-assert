package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class NetworkCounterpartySystemStatusResponse extends BaseMsgType{
    public static final NetworkCounterpartySystemStatusResponse INSTANCE = new NetworkCounterpartySystemStatusResponse();

    private NetworkCounterpartySystemStatusResponse() {
        super(
            "NetworkCounterpartySystemStatusResponse",
            "BD",
            "app",
            FieldTypes.NetworkStatusResponseType.required(true),
            FieldTypes.NetworkRequestID.required(false),
            FieldTypes.NetworkResponseID.required(true),
            FieldTypes.LastNetworkResponseID.required(false),
            new BaseGroupType(
                FieldTypes.NoCompIDs.required(true),
                FieldTypes.RefCompID.required(true),
                FieldTypes.RefSubID.required(false),
                FieldTypes.LocationID.required(false),
                FieldTypes.DeskID.required(false),
                FieldTypes.StatusValue.required(true),
                FieldTypes.StatusText.required(false)
            )
        );
    }
}
