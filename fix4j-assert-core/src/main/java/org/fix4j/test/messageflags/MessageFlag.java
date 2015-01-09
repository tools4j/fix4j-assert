package org.fix4j.test.messageflags;

import org.fix4j.test.fixmodel.Field;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.PrettyPrintable;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 */
public class MessageFlag implements PrettyPrintable {
    private final FixMessage fixMessage;
    private final String alert;

    public MessageFlag(final FixMessage fixMessage, final String alert) {
        this.fixMessage = fixMessage;
        this.alert = alert;
    }

    @Override
    public String toString() {
        return toPrettyString();
    }

    public FixMessage getFixMessage() {
        return fixMessage;
    }

    @Override
    public String toPrettyString() {
        if(StringUtils.containsAtLeastOneVariable(alert)){
            final Map<String,Field> fieldMap = fixMessage.getFieldReferenceMap();
            final Map<String,String> fieldValueMap = new LinkedHashMap<>(fieldMap.size());
            for (final String key : fieldMap.keySet()) {
                fieldValueMap.put(key, fieldMap.get(key).getFormattedValue());
            }
            return StringUtils.substituteVariables(alert, fieldValueMap) + Consts.EOL;
        } else {
            return alert + Consts.EOL;
        }
    }
}
