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

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 5:44 PM
 */
public class QuickFixTestSessionFactory implements FixEngineSessionFactory {
    private final FixSpecification fixSpecification;

    public QuickFixTestSessionFactory(final FixSpecification fixSpecification) {
        this.fixSpecification = fixSpecification;
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
            settings.setString("SocketConnectHost", ApplicationProperties.Singleton.instance().getAsString(QuickFixProperties.SOCKET_CONNECT_HOST, "localhost"));
            settings.setString("StartTime", ApplicationProperties.Singleton.instance().getAsString("quickfix.start.time", "00:00:00"));
            settings.setString("EndTime", ApplicationProperties.Singleton.instance().getAsString("quickfix.end.time", "00:00:00"));
            settings.setString("HeartBtInt", ApplicationProperties.Singleton.instance().getAsString("quickfix.heart.beat.interval", "10"));
            settings.setString("BeginString", quickfixSessionId.getBeginString());
            settings.setString("ReconnectInterval", ApplicationProperties.Singleton.instance().getAsString("quickfix.reconnect.interval", "5"));
            settings.setString("UseDataDictionary", ApplicationProperties.Singleton.instance().getAsString("quickfix.use.data.dictionary", "Y"));

            if(fixConnectionMode == FixConnectionMode.INITIATOR) {
                settings.setString(quickfixSessionId, "SocketConnectPort", ApplicationProperties.Singleton.instance().getAsString("quickfix.socket.connect.port", "9880"));
            } else if(fixConnectionMode == FixConnectionMode.ACCEPTOR){
                settings.setString(quickfixSessionId, "SocketAcceptPort", ApplicationProperties.Singleton.instance().getAsString("quickfix.socket.accept.port", "9880"));
            } else {
                throw new IllegalArgumentException("Unknown mode:" + fixConnectionMode);
            }

            final boolean logHeartbeats = ApplicationProperties.Singleton.instance().getAsBoolean("quickfix.log.heartbeats", true);
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
