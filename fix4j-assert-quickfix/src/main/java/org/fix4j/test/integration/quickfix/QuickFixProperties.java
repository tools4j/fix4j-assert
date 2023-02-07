package org.fix4j.test.integration.quickfix;

import org.fix4j.test.util.Keyable;

/**
 * User: ben
 * Date: 17/12/14
 * Time: 5:02 PM
 */
public enum QuickFixProperties implements Keyable<String> {
    SOCKET_CONNECT_HOST("fix4j.quickfix.socket.connect.host"),
    START_TIME("fix4j.quickfix.start.time"),
    END_TIME("fix4j.quickfix.end.time"),
    HEART_BEAT_INTERVAL("fix4j.quickfix.heart.beat.interval"),
    RECONNECT_INTERVAL("fix4j.quickfix.reconnect.interval"),
    USE_DATA_DICTIONARY("fix4j.quickfix.use.data.dictionary"),
    SOCKET_CONNECT_PORT("fix4j.quickfix.socket.connect.port"),
    SOCKET_ACCEPT_PORT("fix4j.quickfix.socket.accept.port"),
    LOG_HEARTBEATS("fix4j.quickfix.log.heartbeats"),
    ALLOW_UNKNOWN_MSG_FIELDS("fix4j.quickfix.allow.unknown.msg.fields"),
    VALIDATE_FIELDS_OUT_OF_ORDER("fix4j.quickfix.validate.fields.out.of.order"),
    VALIDATE_FIELDS_HAVE_VALUES("fix4j.quickfix.validate.fields.have.values"),
    VALIDATE_USER_DEFINED_FIELDS("fix4j.quickfix.validate.user.defined.fields"),
    RESET_ON_LOGON("fix4j.quickfix.reset.on.logon");

    private final String key;

    QuickFixProperties(final String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
