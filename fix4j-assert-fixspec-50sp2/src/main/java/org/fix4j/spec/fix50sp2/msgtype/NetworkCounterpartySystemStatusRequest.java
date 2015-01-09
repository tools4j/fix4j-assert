package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class NetworkCounterpartySystemStatusRequest extends BaseMsgType{
    public static final NetworkCounterpartySystemStatusRequest INSTANCE = new NetworkCounterpartySystemStatusRequest();

    private NetworkCounterpartySystemStatusRequest() {
        super(
            "NetworkCounterpartySystemStatusRequest",
            "BC",
            "app",
            FieldTypes.NetworkRequestType.required(true),
            FieldTypes.NetworkRequestID.required(true),
            new BaseGroupType(
                FieldTypes.NoCompIDs.required(false),
                FieldTypes.RefCompID.required(false),
                FieldTypes.RefSubID.required(false),
                FieldTypes.LocationID.required(false),
                FieldTypes.DeskID.required(false)
            )
        );
    }
}
