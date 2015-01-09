package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.Handler;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.properties.PropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * This is the main entry point into the fix4j-assert framework.
 *
 * Users can use this class to create one or more testing sessions.
 *
 * e.g.
 * <code>
 * final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
 *
 * final MatchingSession client = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);
 * </code>
 */
public class TestSessionHelper {
    private final static Logger LOGGER = LoggerFactory.getLogger(TestSessionHelper.class);
    private final ContextFactory contextFactory;

    /**
     * Creates a new instance using the given contextFactory.
     * @param contextFactory
     */
    public TestSessionHelper(final ContextFactory contextFactory) {
        this.contextFactory = contextFactory;
    }

    /**
     * @see org.fix4j.test.session.MatchingSession
     * @param fixSessionId
     * @param fixConnectionMode
     * @return A MatchingSession.
     */
    public MatchingSession createMatchingSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode) {
        final SessionContext sessionContext = contextFactory.createSessionContext(fixSessionId, fixConnectionMode, null);
        sessionContext.fixEngineSession.startup();
        return new MatchingSession(sessionContext);
    }

    /**
     * @see org.fix4j.test.session.MatchingSession
     * @param fixSessionId
     * @param fixConnectionMode
     * @param properties Properties specific to this session
     * @return A MatchingSession.
     */
    public MatchingSession createMatchingSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode, final Map<String, String> properties ) {
        final SessionContext sessionContext = contextFactory.createSessionContext(fixSessionId, fixConnectionMode, properties);
        sessionContext.fixEngineSession.startup();
        return new MatchingSession(sessionContext);
    }


    /**
     * @see org.fix4j.test.session.DispatchingSession
     * @param fixSessionId
     * @param fixConnectionMode
     * @param messageHandler The message handler that will be called on each incoming message.
     * @return A DispatchingSession.
     */
    public DispatchingSession createDispatchingSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode, final Handler messageHandler) {
        final SessionContext sessionContext = contextFactory.createSessionContext(fixSessionId, fixConnectionMode, null);
        sessionContext.fixEngineSession.startup();
        return new DispatchingSession(sessionContext, messageHandler);
    }

    /**
     * @see org.fix4j.test.session.DispatchingSession
     * @param fixSessionId
     * @param fixConnectionMode
     * @param properties Properties specific to this session
     * @param messageHandler The message handler that will be called on each incoming message.
     * @return A DispatchingSession.
     */
    public DispatchingSession createDispatchingSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode, final Map<String, String> properties, final Handler messageHandler) {
        final SessionContext sessionContext = contextFactory.createSessionContext(fixSessionId, fixConnectionMode, properties);
        sessionContext.fixEngineSession.startup();
        return new DispatchingSession(sessionContext, messageHandler);
    }

    /**
     * @see org.fix4j.test.session.ConsumerSession
     * @param fixSessionId
     * @param fixConnectionMode
     * @param messageHandler The consumer that will be called on each incoming message.
     * @return A ConsumerSession.
     */
    public ConsumerSession createConsumerSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode, final Consumer<FixMessage> messageHandler) {
        final SessionContext sessionContext = contextFactory.createSessionContext(fixSessionId, fixConnectionMode, null);
        sessionContext.fixEngineSession.startup();
        return new ConsumerSession(sessionContext, messageHandler);
    }

    /**
     * @see org.fix4j.test.session.ConsumerSession
     * @param fixSessionId
     * @param fixConnectionMode
     * @param messageHandler The consumer that will be called on each incoming message.
     * @return A ConsumerSession.
     */
    public ConsumerSession createConsumerSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode, final Map<String, String> properties, final Consumer<FixMessage> messageHandler) {
        final SessionContext sessionContext = contextFactory.createSessionContext(fixSessionId, fixConnectionMode, properties);
        sessionContext.fixEngineSession.startup();
        return new ConsumerSession(sessionContext, messageHandler);
    }

    /**
     * @see org.fix4j.test.session.BlockingSession
     * @param fixSessionId
     * @param fixConnectionMode
     * @return A BlockingSession.
     */
    public BlockingSession createBlockingSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode) {
        final SessionContext sessionContext = contextFactory.createSessionContext(fixSessionId, fixConnectionMode, null);
        sessionContext.fixEngineSession.startup();
        return new BlockingSession(sessionContext);
    }

    /**
     * @see org.fix4j.test.session.BlockingSession
     * @param fixSessionId
     * @param fixConnectionMode
     * @return A BlockingSession.
     */
    public BlockingSession createBlockingSession(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode, final Map<String, String> properties) {
        final SessionContext sessionContext = contextFactory.createSessionContext(fixSessionId, fixConnectionMode, properties);
        sessionContext.fixEngineSession.startup();
        return new BlockingSession(sessionContext);
    }

    public FixMessage parse(final String expression) {
        return contextFactory.getFixSpecification().parse(expression);
    }

    public FixSpecification getFixSpecification(){
        return contextFactory.getFixSpecification();
    }
}
