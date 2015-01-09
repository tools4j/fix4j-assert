package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class SequenceReset extends BaseMsgType{
    public static final SequenceReset INSTANCE = new SequenceReset();

    private SequenceReset() {
        super(
            "SequenceReset",
            "4",
            "admin",
            FieldTypes.GapFillFlag.required(false),
            FieldTypes.NewSeqNo.required(true)
        );
    }
}
