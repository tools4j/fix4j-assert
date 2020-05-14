package org.fix4j.test.integration.quickfix;

import org.fix4j.test.integration.FixEngineSession;
import org.fix4j.test.integration.FixEngineSessionFactory;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import quickfix.Connector;
import quickfix.DefaultMessageFactory;
import quickfix.MemoryStoreFactory;
import quickfix.ScreenLogFactory;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;
import quickfix.SocketInitiator;

import java.util.Map;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 5:44 PM
 */
public class QuickFixTestSessionFactory implements FixEngineSessionFactory {
    private final FixSpecification fixSpecification;
    private final ApplicationProperties properties;
    private final Map additionalQuickFixProperties;

    public QuickFixTestSessionFactory(final FixSpecification fixSpecification,
                                      final ApplicationProperties properties,
                                      final Map additionalQuickFixProperties) {
        this.fixSpecification = fixSpecification;
        this.properties = properties;
        this.additionalQuickFixProperties = additionalQuickFixProperties;
    }

    @Override
    public FixEngineSession createSession(final FixSessionId sessionId, final FixConnectionMode fixConnectionMode, final Consumer<FixMessage> toTestClient) {
        final QuickFixApplication app = new QuickFixApplication();
        final SessionID quickfixSessionId = (new QuickFixSessionIdConverter()).fromFixSessionId(sessionId);
        final Connector connector = create(quickfixSessionId, app, fixConnectionMode);
        return new QuickFixTestSession(toTestClient, quickfixSessionId, app, fixSpecification, connector);
    }

    private Connector create(final SessionID quickfixSessionId, final QuickFixApplication app, final FixConnectionMode fixConnectionMode){
        try {
            final SessionSettings settings = new SessionSettings();
            settings.setString("ConnectionType", (fixConnectionMode == FixConnectionMode.INITIATOR ? "initiator": "acceptor"));
            settings.setString("SenderCompID", quickfixSessionId.getSenderCompID());
            settings.setString("TargetCompID", quickfixSessionId.getTargetCompID());
            settings.setString("SocketConnectHost", properties.getAsString(QuickFixProperties.SOCKET_CONNECT_HOST, "localhost"));
            settings.setString("StartTime", properties.getAsString(QuickFixProperties.START_TIME, "00:00:00"));
            settings.setString("EndTime", properties.getAsString(QuickFixProperties.END_TIME, "00:00:00"));
            settings.setString("HeartBtInt", properties.getAsString(QuickFixProperties.HEART_BEAT_INTERVAL, "10"));
            settings.setString("BeginString", quickfixSessionId.getBeginString());
            settings.setString("ReconnectInterval", properties.getAsString(QuickFixProperties.RECONNECT_INTERVAL, "5"));
            settings.setString("UseDataDictionary", properties.getAsString(QuickFixProperties.USE_DATA_DICTIONARY, "Y"));
            settings.setString("AllowUnknownMsgFields", properties.getAsString(QuickFixProperties.ALLOW_UNKNOWN_MSG_FIELDS, "Y"));
            settings.setString("ValidateFieldsOutOfOrder", properties.getAsString(QuickFixProperties.VALIDATE_FIELDS_OUT_OF_ORDER, "N"));
            settings.setString("ValidateFieldsHaveValues", properties.getAsString(QuickFixProperties.VALIDATE_FIELDS_HAVE_VALUES, "N"));
            settings.setString("ValidateUserDefinedFields", properties.getAsString(QuickFixProperties.VALIDATE_USER_DEFINED_FIELDS, "N"));
            settings.setString("ResetOnLogon", properties.getAsString(QuickFixProperties.RESET_ON_LOGON, "N"));
            settings.set(additionalQuickFixProperties);

            if(fixConnectionMode == FixConnectionMode.INITIATOR) {
                settings.setString(quickfixSessionId, "SocketConnectPort", properties.getAsString(QuickFixProperties.SOCKET_CONNECT_PORT, "9880"));
            } else if(fixConnectionMode == FixConnectionMode.ACCEPTOR){
                settings.setString(quickfixSessionId, "SocketAcceptPort", properties.getAsString(QuickFixProperties.SOCKET_ACCEPT_PORT, "9880"));
            } else {
                throw new IllegalArgumentException("Unknown mode:" + fixConnectionMode);
            }

            final boolean logHeartbeats = properties.getAsBoolean(QuickFixProperties.LOG_HEARTBEATS, true);
            final MemoryStoreFactory messageStoreFactory = new MemoryStoreFactory();
            final ScreenLogFactory logFactory = new ScreenLogFactory(true, true, true, logHeartbeats);
            final DefaultMessageFactory messageFactory = new DefaultMessageFactory();

            final Connector socket;
            if(fixConnectionMode == FixConnectionMode.INITIATOR) {
                socket = new SocketInitiator(app, messageStoreFactory, settings, logFactory, messageFactory);
            } else if(fixConnectionMode == FixConnectionMode.ACCEPTOR){
                socket = new SocketAcceptor(app, messageStoreFactory, settings, logFactory, messageFactory);
            } else {
                throw new IllegalArgumentException("Unknown mode:" + fixConnectionMode);
            }
            return socket;

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
