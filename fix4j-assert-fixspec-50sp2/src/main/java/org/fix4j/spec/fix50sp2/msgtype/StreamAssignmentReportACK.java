package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class StreamAssignmentReportACK extends BaseMsgType{
    public static final StreamAssignmentReportACK INSTANCE = new StreamAssignmentReportACK();

    private StreamAssignmentReportACK() {
        super(
            "StreamAssignmentReportACK",
            "CE",
            "app",
            FieldTypes.StreamAsgnAckType.required(true),
            FieldTypes.StreamAsgnRptID.required(true),
            FieldTypes.StreamAsgnRejReason.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}
