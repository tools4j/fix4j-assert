package org.fix4j.test.integration.quickfix;

import org.fix4j.test.integration.FixEngineSession;
import org.fix4j.test.integration.MessageConverter;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.plumbing.BlockingPipe;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.plumbing.ShuntFromSupplierToConsumer;
import org.fix4j.test.session.TestSessionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.ConfigError;
import quickfix.Connector;
import quickfix.Message;
import quickfix.Session;
import quickfix.SessionID;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 5:48 AM
 */
public class QuickFixTestSession implements FixEngineSession {
    private final static Logger LOGGER = LoggerFactory.getLogger(TestSessionHelper.class);
    private final QuickFixApplication application;
    private final SessionID sessionId;
    private final Consumer<FixMessage> outboundConsumer;
    private final Connector connector;

    public QuickFixTestSession(final Consumer<FixMessage> toTestClient, final SessionID sessionId, final QuickFixApplication quickFixApplication, final FixSpecification fixSpecification, final Connector connector) {
        this.sessionId = sessionId;
        this.connector = connector;

        //Messages FROM:quickfix -> TO:testFramework, i.e. INBOUND
        final FromQuickFixMessageConverter fromQuickFixMessageConverter = new FromQuickFixMessageConverter(fixSpecification);
        final Consumer<quickfix.Message> fromQuickFixConvertingPipe = fromQuickFixMessageConverter.convertAndSendMessagesTo(toTestClient);
        this.application = quickFixApplication;
        quickFixApplication.register(sessionId, fromQuickFixConvertingPipe);

        //Messages FROM:testFramework -> TO:quickfix, i.e. OUTBOUND
        this.outboundConsumer = getOutboundConsumer(sessionId, fixSpecification);
    }

    public Consumer<FixMessage> getOutboundConsumer(final SessionID sessionId, final FixSpecification fixSpecification) {
        final MessageConverter<FixMessage, Message> toQuickFixMessageConverter = new ToQuickFixMessageConverter(fixSpecification);
        final BlockingPipe<Message> outboundQueueBetweenFixSessionAndFixApplication = new BlockingPipe<Message>("queueBetweenThisFixSessionAndFixApplication");

        final Consumer<Message> fixApplicationConsumer = new Consumer<Message>() {
            @Override
            public void accept(final Message message) {
                application.send(message, sessionId);
            }
        };
        final Consumer<FixMessage> toQuickFixConvertingPipe = toQuickFixMessageConverter.convertAndSendMessagesTo(outboundQueueBetweenFixSessionAndFixApplication);

        final Consumer<FixMessage> outboundConsumer = new Consumer<FixMessage>() {
            public void accept(final FixMessage fixMessage) {
                toQuickFixConvertingPipe.accept(fixMessage);
            }
        };

        new ShuntFromSupplierToConsumer<>("fromTestFrameworkSupplier-to-simpleMessageConsumerToQuickFixConverter", outboundQueueBetweenFixSessionAndFixApplication, fixApplicationConsumer).start();

        return outboundConsumer;
    }

    @Override
    public synchronized void logon() {
        LOGGER.info("About to login to: " + sessionId);
        Session.lookupSession(sessionId).logon();
        LOGGER.info("Logged into: " + sessionId);
    }

    @Override
    public void logout() {
        Session.lookupSession(sessionId).logout("user requested");
    }

    @Override
    public void accept(final FixMessage fixMessage) {
        outboundConsumer.accept(fixMessage);
    }

    @Override
    public void shutdown() {
        connector.stop();
    }

    @Override
    public void shutdown(boolean force) {
        connector.stop(force);
    }

    @Override
    public void startup(){
        try {
            connector.start();
        } catch (ConfigError configError) {
            throw new RuntimeException(configError);
        }
    }
}
