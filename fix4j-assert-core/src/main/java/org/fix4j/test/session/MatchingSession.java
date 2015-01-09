package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.matching.MatchingInboundSession;
import org.fix4j.test.properties.ApplicationProperties;

/**
 * MatchingSession allows the user to send messages, as well as specify criteria for asserting
 * incoming messages.
 *
 * User: ben
 */
public class MatchingSession implements TestClientSession {
    private final MatchingInboundSession inboundSession;
    private final SimpleOutboundSession outboundSession;
    private final SessionContext sessionContext;

    public MatchingSession(final SessionContext sessionContext) {
        this.inboundSession = new MatchingInboundSession(sessionContext.fixSpecification, sessionContext.sessionConnectors.inboundSupplier, sessionContext.applicationProperties);
        this.outboundSession = new SimpleOutboundSession(sessionContext.fixSpecification, sessionContext.sessionConnectors.outboundConsumer);
        this.sessionContext = sessionContext;
    }

    /**
     * @see org.fix4j.test.expression.MessageExpression
     * @param messageExpression
     */
    public void send(final String messageExpression) {
        try {
            outboundSession.send(messageExpression);
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

    /**
     * @see org.fix4j.test.expression.MessageExpression
     * @param messageExpression
     * @return The FixMessage which matches the given expression.
     * @throws org.fix4j.test.session.Failure if: The next message to arrive does NOT match the given expression, or
     * if the next message does not arrive within the timeout period specified by the property: DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS
     */
    public FixMessage expect(final String messageExpression) {
        try {
            return inboundSession.expect(messageExpression).getMessage();
        } catch (final Failure failure) {
            throw sessionContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    /**
     * @param msgType
     * @return The FixMessage which matches the given MsgType.
     * @throws org.fix4j.test.session.Failure if: The next message to arrive is NOT of the given MsgType, or
     * if the next message does not arrive within the timeout period specified by the property: DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS
     */
    public FixMessage expect(final MsgType msgType) {
        try {
            return inboundSession.expect(msgType).getMessage();
        } catch (final Failure failure) {
            throw sessionContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    /**
     * Discards incoming messages until a message arrives which matches the given expression.  If a matching message
     * does not arrive within the timeout period, a Failure exception is thrown.
     * @see org.fix4j.test.expression.MessageExpression
     * @param messageExpression
     * @return The FixMessage which matches the given expression.
     * @throws org.fix4j.test.session.Failure if: A matching messages does not arrive within the timeout period
     * specified by the property: DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS
     */
    public FixMessage discardUntil(final String messageExpression) {
        try {
            return inboundSession.discardUntilExpected(messageExpression).getMessage();
        } catch (final Failure failure) {
            throw sessionContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    /**
     * Discards incoming messages until a message arrives of the given MsgType.  If a message of the given type
     * does not arrive within the timeout period, a Failure exception is thrown.
     * @param msgType
     * @return The FixMessage of the given MsgType
     * @throws org.fix4j.test.session.Failure if: A message of the given type does not arrive within the timeout period
     * specified by the property: DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS
     */
    public FixMessage discardUntil(final MsgType msgType) {
        try {
            return inboundSession.discardUntilTypeOfMessageReceived(msgType).getMessage();
        } catch (final Failure failure) {
            throw sessionContext.enrichFailureWithAdditionalReports(failure);
        }
    }

    /**
     * Discards incoming messages until a message arrives of the given MsgType.  Once a message of the given type
     * arrives, it is asserted against the given messageExpression.  If the message does NOT match the given
     * messageExpression, then a Failure exception is thrown.
     * @see org.fix4j.test.expression.MessageExpression
     * @param msgType
     * @param messageExpression
     * @return The FixMessage of the given MsgType
     * @throws org.fix4j.test.session.Failure if: A message of the given MsgType does not arrive within the timeout period
     * or, if a message DOES arrive of the given type, but it does not match the given messageExpression.
     */
    public FixMessage discardUntil(final MsgType msgType, final String messageExpression) {
        try {
            return inboundSession.discardUntilTypeOfMsgReceived(msgType, messageExpression).getMessage();
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

    public ApplicationProperties getProperties(){
        return sessionContext.applicationProperties;
    }
}
