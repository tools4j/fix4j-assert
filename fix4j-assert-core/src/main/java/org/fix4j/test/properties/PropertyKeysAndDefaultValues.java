package org.fix4j.test.properties;

import org.fix4j.test.util.Keyable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: ben
 * Date: 4/12/14
 * Time: 4:56 PM
 */
public enum PropertyKeysAndDefaultValues implements Keyable<String> {
    DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS("fix4j.default.fix.msg.wait.timeout.ms", "2000"),
    POLL_PERIOD_MS("fix4j.poll.period.ms", "100"),
    SIZE_OF_RECENTLY_SENT_MESSAGES("fix4j.size.of.recently.sent.messages", "5"),
    SIZE_OF_DISCARDED_MESSAGES("fix4j.size.of.discarded.messages", "5"),
    DISPLAY_INCOMING_MESSAGE_FLAGS("fix4j.display.incoming.message.flags", "true"),
    FAST_FAIL_ON_TRIGGER_OF_INCOMING_MESSAGE_FLAG("fix4j.fast.fail.on.trigger.of.incoming.message.flag", "true"),
    FAST_FAIL_ON_TRIGGER_OF_OUTBOUND_MESSAGE_FLAG("fix4j.fast.fail.on.trigger.of.outbound.message.flag", "true"),
    FIX_FIELD_DELIM("fix4j.fix.field.delim", "(\\||\\^A|\\u0001)"),
    DEFAULT_MESSAGES_TO_IGNORE("fix4j.default.messages.to.ignore", "35=0");

    private final String defaultValue;
    private final String key;

    private PropertyKeysAndDefaultValues(final String key, final String defaultValue) {
        this.defaultValue = defaultValue;
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    public static PropertySource getDefaultProperties(){
        final Map<String, String> properties = new LinkedHashMap<>(PropertyKeysAndDefaultValues.values().length);
        for (final PropertyKeysAndDefaultValues key : values()) {
            properties.put(key.getKey(), key.defaultValue);
        }
        return new MapPropertySource(properties, "DefaultValues");
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
