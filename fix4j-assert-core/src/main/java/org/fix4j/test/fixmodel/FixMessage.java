package org.fix4j.test.fixmodel;


import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.fixspec.Tag;
import org.fix4j.test.session.FixSessionId;

import java.util.List;

public interface FixMessage extends FieldSource, PrettyPrintable {
    boolean isOfType(MsgType msgType);
    MsgType getTypeOfMessage();
    FieldsAndGroups getHeader();
    FieldsAndGroups getTrailer();
    FieldsAndGroups getBody();
    String toDelimitedMessageWithDescriptors();
    String toDelimitedMessage();
    FixSessionId getSessionId();
    String getSenderAndTargetCompIds();
    Field getField(FieldType fieldType);
    Field getField(int tag);
    List<Field> getFields(FieldType fieldType);
    List<Field> getFields(int tag);
    Field getField(String reference);
}
