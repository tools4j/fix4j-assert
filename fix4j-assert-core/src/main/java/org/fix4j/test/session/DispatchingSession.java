package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.Handler;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.plumbing.ExceptionHandler;
import org.fix4j.test.plumbing.ShuntFromSupplierToConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 21/08/2014
 * Time: 5:26 AM
 */
public class DispatchingSession implements TestClientSession, ExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(DispatchingSession.class);
    private final SimpleOutboundSession outboundSession;
    private final SessionContext sessionContext;

    public DispatchingSession(final SessionContext sessionContext, final Handler messageHandler) {
        this.sessionContext = sessionContext;
        final MessageDispatcher messageDispatcher = new MessageDispatcher(sessionContext.fixSpecification, messageHandler);
        new ShuntFromSupplierToConsumer<>("fromNetwork-to-messageDispatcher", sessionContext.sessionConnectors.inboundSupplier, messageDispatcher, this).start();
        this.outboundSession = new SimpleOutboundSession(sessionContext.fixSpecification, sessionContext.sessionConnectors.outboundConsumer);
    }

    public void send(final String messageStr) {
        try {
            outboundSession.send(messageStr);
        } catch (final Failure failure) {
            throw sessionContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    public void send(final FixMessage message){
        try {
            outboundSession.send(message);
        } catch (final Failure failure) {
            throw sessionContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    @Override
    public void shutdown() {
        sessionContext.fixEngineSession.shutdown();
    }

    @Override
    public FixSpecification getFixSpecification() {
        return sessionContext.fixSpecification;
    }

    @Override
    public FixSessionId getSessionId() {
        return sessionContext.fixSessionId;
    }

    @Override
    public Throwable handle(final Throwable t) {
        LOGGER.error("Exception occurred whilst receiving messages.  Shutting down session.", t);
        this.shutdown();
        return t;
    }
}
