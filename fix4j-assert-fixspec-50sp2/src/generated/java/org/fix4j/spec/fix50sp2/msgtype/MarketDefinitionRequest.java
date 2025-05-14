package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class MarketDefinitionRequest extends BaseMsgType{
    public static final MarketDefinitionRequest INSTANCE = new MarketDefinitionRequest();

    private MarketDefinitionRequest() {
        super(
            "MarketDefinitionRequest",
            "BT",
            "app",
            FieldTypes.MarketReqID.required(true),
            FieldTypes.SubscriptionRequestType.required(true),
            FieldTypes.MarketID.required(false),
            FieldTypes.MarketSegmentID.required(false),
            FieldTypes.ParentMktSegmID.required(false)
        );
    }
}
