package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class ApplicationMessageReport extends BaseMsgType{
    public static final ApplicationMessageReport INSTANCE = new ApplicationMessageReport();

    private ApplicationMessageReport() {
        super(
            "ApplicationMessageReport",
            "BY",
            "app",
            FieldTypes.ApplReportID.required(true),
            FieldTypes.ApplReqID.required(false),
            FieldTypes.ApplReportType.required(true),
            new BaseGroupType(
                FieldTypes.NoApplIDs.required(false),
                FieldTypes.RefApplID.required(false),
                FieldTypes.ApplNewSeqNum.required(false),
                FieldTypes.RefApplLastSeqNum.required(false)
            ),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
