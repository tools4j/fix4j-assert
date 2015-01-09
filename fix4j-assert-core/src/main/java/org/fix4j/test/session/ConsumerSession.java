package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.plumbing.ShuntFromSupplierToConsumer;

/**
 * User: ben
 * Date: 21/08/2014
 * Time: 5:26 AM
 */
public class ConsumerSession implements TestClientSession{
    private final SimpleOutboundSession outboundSession;
    private final SessionContext sessionContext;

    public ConsumerSession(final SessionContext sessionContext, final Consumer<FixMessage> toTestClient) {
        new ShuntFromSupplierToConsumer<>("fromNetwork-to-testClient", sessionContext.sessionConnectors.inboundSupplier, toTestClient).start();
        this.outboundSession = new SimpleOutboundSession(sessionContext.fixSpecification, sessionContext.sessionConnectors.outboundConsumer);
        this.sessionContext = sessionContext;
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
    public void shutdown(){
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
}
