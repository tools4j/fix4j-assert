package org.fix4j.test.session;

import org.fix4j.test.expression.MessageExpressionParser;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.integration.FixEngineSession;
import org.fix4j.test.integration.FixEngineSessionFactory;
import org.fix4j.test.matching.matchers.FixMessageMatcher;
import org.fix4j.test.messageflags.MessageFlagRule;
import org.fix4j.test.messageflags.MessageFlagRules;
import org.fix4j.test.messageflags.SessionLevelRejectMessageFlagRule;
import org.fix4j.test.plumbing.BlockingPipe;
import org.fix4j.test.plumbing.Processor;
import org.fix4j.test.processors.InboundIgnoreProcessor;
import org.fix4j.test.processors.InboundMessageFlagFailureProcessor;
import org.fix4j.test.processors.InboundProcessors;
import org.fix4j.test.processors.InboundRecentMessageProcessor;
import org.fix4j.test.processors.OnFailureReporters;
import org.fix4j.test.processors.OutboundMessageFlagFailureProcessor;
import org.fix4j.test.processors.OutboundProcessors;
import org.fix4j.test.processors.OutboundRecentMessageProcessor;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.properties.CompositePropertyMap;
import org.fix4j.test.properties.MapPropertySource;
import org.fix4j.test.properties.PropertyKeysAndDefaultValues;
import org.fix4j.test.properties.PropertySource;
import org.fix4j.test.properties.SystemEnvVariablePropertySource;
import org.fix4j.test.properties.SystemPropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class AbstractContextFactory implements ContextFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractContextFactory.class);
    private final FixSpecification fixSpecification;

    public AbstractContextFactory (final FixSpecification fixSpecification) {
        this.fixSpecification = fixSpecification;
    }

    protected abstract FixEngineSessionFactory createFixEngineSessionFactory(final FixSpecification fixSpecification, final ApplicationProperties properties);

    @Override
    public SessionContext createSessionContext(final FixSessionId fixSessionId, final FixConnectionMode fixConnectionMode, final Map<String, String> sessionProperties) {
        final ApplicationProperties properties = createApplicationProperties(sessionProperties != null? new MapPropertySource(sessionProperties, "SessionProperties"): null);
        logProperties(fixSessionId, properties);
        final FixEngineSessionFactory fixEngineSessionFactory = createFixEngineSessionFactory(fixSpecification, properties);
        final BlockingPipe<FixMessage> inboundBlockingPipe = new BlockingPipe<>("fromThirdPartyFixEngine");
        final FixEngineSession fixEngineSession = fixEngineSessionFactory.createSession(fixSessionId, fixConnectionMode, inboundBlockingPipe);
        final InboundProcessors inboundProcessors = new InboundProcessors(inboundBlockingPipe, createInboundProcessors(properties));
        final OutboundProcessors outboundProcessors = new OutboundProcessors(fixEngineSession, createOutboundProcessors(properties));
        final SessionConnectors sessionConnectors = new SessionConnectors(inboundProcessors, outboundProcessors);
        final OnFailureReporters onFailReporters = new OnFailureReporters(inboundProcessors, outboundProcessors);
        return new SessionContext(sessionConnectors, fixSessionId, onFailReporters, fixConnectionMode, fixEngineSession, fixSpecification, properties);
    }

    private void logProperties(final FixSessionId fixSessionId, final ApplicationProperties properties) {
        LOGGER.info("***********************************************************************************");
        LOGGER.info("Properties for session: " + fixSessionId);
        LOGGER.info("***********************************************************************************");
        LOGGER.info("\n" + properties.toString());
    }

    /**
     * The properties returned from this method come from a few different sources.  Sources are listed here.  Sources
     * are listed in order of priority, meaning that is a property is specified in both the first source and the second source, the property
     * value from the first source will be used.
     *
     * - Test properties passed into this method
     * - System properties prefixed with "fix4j" or "FIX4J".  See: {@link org.fix4j.test.properties.SystemPropertySource}
     * - Environment variables prefixed with "fix4j" or "FIX4J". See: {@link org.fix4j.test.properties.SystemEnvVariablePropertySource}
     * - Default values specified in {@link org.fix4j.test.properties.PropertyKeysAndDefaultValues}
     *
     * If this method is overridden it is entirely up to the overriding method to define which sources and what
     * order of priority to use.  The implementing code may add a PropertySource which takes properties from entirely different source
     * e.g. a properties file.  (See the examples.)
     *
     * @param testProperties These are the properties that the test code has give specifically for this test.
     * @return Properties which will be used by fix4j-assert
     */
    protected ApplicationProperties createApplicationProperties(final PropertySource testProperties) {
        final CompositePropertyMap.Builder builder = CompositePropertyMap.Builder.create("ALL");
        if(testProperties != null) builder.addLast(testProperties);
        builder.addLast(new SystemPropertySource());
        builder.addLast(new SystemEnvVariablePropertySource());
        builder.addLast(PropertyKeysAndDefaultValues.getDefaultProperties());
        return builder.build();
    }

    /**
     * Outbound processors are called for every outbound {@link org.fix4j.test.fixmodel.FixMessage} that is sent from a test.
     * Processors allow a point to see and/or modify the outgoing FixMessage after the message leaves the test code,
     * and before it reaches the fix layer.
     *
     * A processor can effectively modify the message being sent from the test code by returning a modified FixMessage
     * from the {@link org.fix4j.test.plumbing.Processor#process} method.
     *
     * If the processor wishes to stop a FixMessage from being sent, it can return null from the {@link org.fix4j.test.plumbing.Processor#process}
     * method.
     *
     * A processor does not have to modify or stop the FixMessage.  As in the case of the {@link org.fix4j.test.processors.OutboundRecentMessageProcessor},
     * the fixMessage is simply recorded for later use.
     *
     * Override this method if you wish to alter the list of outbound processors.
     */
    protected List<Processor<FixMessage>> createOutboundProcessors(final ApplicationProperties properties) {
        final MessageFlagRules outboundMessageFlagWarningRules = createOutboundMessageFlagWarningRules();
        final MessageFlagRules outboundMessageFlagFailureRules = createOutboundMessageFlagFailureRules();
        final OutboundRecentMessageProcessor outboundRecentMessageProcessor = new OutboundRecentMessageProcessor(outboundMessageFlagWarningRules);
        final OutboundMessageFlagFailureProcessor outboundMessageFlagFailureProcessor = new OutboundMessageFlagFailureProcessor(outboundMessageFlagFailureRules, properties.getAsBoolean(PropertyKeysAndDefaultValues.FAST_FAIL_ON_TRIGGER_OF_OUTBOUND_MESSAGE_FLAG.getKey()));
        return Arrays.asList(outboundRecentMessageProcessor, outboundMessageFlagFailureProcessor);
    }

    /**
     * Inbound processors are called for every inbound {@link org.fix4j.test.fixmodel.FixMessage} that is received from the fix layer.
     * Processors allow a point to see and/or modify the inbound FixMessage after the message leaves the fix layer, and before it reaches
     * the test code.
     *
     * A processor can effectively modify the message being sent to the test code by returning a modified FixMessage
     * from the {@link org.fix4j.test.plumbing.Processor#process} method.
     *
     * If the processor wishes to stop a FixMessage from being received by the test code, then it can return null from
     * the {@link org.fix4j.test.plumbing.Processor#process method. See: {@link org.fix4j.test.processors.InboundIgnoreProcessor}
     *
     * A processor does not have to modify or stop the FixMessage.  As in the case of the {@link org.fix4j.test.processors.InboundRecentMessageProcessor},
     * the fixMessage is simply recorded for later use.
     *
     * Override this method if you wish to alter the list of outbound processors.
     */
    protected List<Processor<FixMessage>> createInboundProcessors(final ApplicationProperties properties) {
        final FixMessageMatcher defaultMessagesToIgnore = createMatcherForMessagesToIgnore(fixSpecification, properties);
        final MessageFlagRules inboundMessageFlagWarningRules = createInboundMessageFlagWarningRules();
        final MessageFlagRules inboundMessageFlagFailureRules = createInboundMessageFlagFailureRules();

        final InboundIgnoreProcessor inboundIgnoreProcessor = new InboundIgnoreProcessor(defaultMessagesToIgnore);
        final InboundRecentMessageProcessor inboundRecentMessageProcessor = new InboundRecentMessageProcessor(inboundMessageFlagWarningRules);
        final InboundMessageFlagFailureProcessor inboundMessageFlagFailureProcessor = new InboundMessageFlagFailureProcessor(inboundMessageFlagFailureRules, properties.getAsBoolean(PropertyKeysAndDefaultValues.FAST_FAIL_ON_TRIGGER_OF_INCOMING_MESSAGE_FLAG.getKey()));
        return Arrays.asList(inboundIgnoreProcessor, inboundRecentMessageProcessor, inboundMessageFlagFailureProcessor);
    }

    /**
     * Creates a matcher to apply to each incoming FixMessage.  If the matcher matches a given fixMessage, that message is
     * effectively dropped and the test client will not see that message.
     *
     * The method below creates a simple matcher which matches on the pattern given by PropertyKeysAndDefaultValues.DEFAULT_MESSAGES_TO_IGNORE,
     * which at time of writing is "35=0".  35=0 is messageType=Heartbeat, so by default, all heartbeat messages will be ignored/dropped and
     * will not be sent to the test code.
     *
     * If the test code wishes to receive heartbeat messages, there are two approaches:
     * 1. Configure fix4j.default.messages.to.ignore property to be blank. (zero length string).
     * 2. Override this method to return a matcher which does NOT match on heartbeats.  e.g. {@link org.fix4j.test.matching.matchers.MatchNoMessagesMatcher}
     *
     * Likewise if the test code wishes to broaden what is ignored, there are the same two approaches:
     * 1. Configure fix4j.default.messages.to.ignore property to match more messages.  e.g. "35=/(D|A|X)/" will ignore all message types of either D, A or X.
     * 2. Override this method to return a matcher which matches the desired messages.  e.g. implement your own {@link org.fix4j.test.matching.matchers.FixMessageMatcher}.
     *
     * @param fixSpecification
     * @param properties
     */
    protected FixMessageMatcher createMatcherForMessagesToIgnore(final FixSpecification fixSpecification, final ApplicationProperties properties) {
        final MessageExpressionParser parser = new MessageExpressionParser(fixSpecification);
        return parser.parse(properties.getAsString(PropertyKeysAndDefaultValues.DEFAULT_MESSAGES_TO_IGNORE.getKey()));
    }

    /**
     * Create a list of MessageFlagRules to be applied to each outbound FixMessage.
     *
     * If one or more rules are triggered, then the testcase will fail, and the test runner/author will be presented with the
     * detail of each triggered rule.
     */
    protected MessageFlagRules createOutboundMessageFlagFailureRules() {
        final List<MessageFlagRule> rules = new ArrayList<>();
        rules.addAll(MessageFlagRules.fieldsShouldNotBeSet(
                "Field was explicitly set in message. Unless explicitly testing such functionality, this field should be left to the fix engine.",
                fixSpecification.getFieldTypeByName("SenderCompID"),
                fixSpecification.getFieldTypeByName("TargetCompID"),
                fixSpecification.getFieldTypeByName("SendingTime"),
                fixSpecification.getFieldTypeByName("MsgSeqNum"),
                fixSpecification.getFieldTypeByName("BeginString"),
                fixSpecification.getFieldTypeByName("CheckSum"),
                fixSpecification.getFieldTypeByName("BodyLength")));
        return new MessageFlagRules(rules);
    }

    /**
     * Create a list of MessageFlagRules to be applied to each inbound FixMessage.
     *
     * If one or more rules are triggered, then the testcase will fail, and the test runner/author will be presented with the
     * detail of each triggered rule.
     *
     * NOTE: for an inbound rule to trigger, the test case must either:
     * --Be using a test session which automatically 'pushes' received messages into the test case.  (See {@link org.fix4j.test.session.DispatchingSession} or
     *   {@link org.fix4j.test.session.ConsumerSession}
     * --Or call a method on the test session which attempts to fetch the next method. e.g. {@link org.fix4j.test.session.MatchingSession#expect} or
     *   {@link org.fix4j.test.session.BlockingSession#getNextMessage}
     */
    protected MessageFlagRules createInboundMessageFlagFailureRules() {
        final List<MessageFlagRule> rules = new ArrayList<>();
        rules.add(new SessionLevelRejectMessageFlagRule(fixSpecification));
        return new MessageFlagRules(rules);
    }

    /**
     * Create a list of MessageFlagRules to be applied to each outbound FixMessage.
     *
     * If one or more rules are triggered, then the test case will proceed, the details of each triggered rule will be printed out to the fix4j-assert log.
     */
    protected MessageFlagRules createOutboundMessageFlagWarningRules() {
        return MessageFlagRules.EMPTY;
    }

    /**
     * Create a list of MessageFlagRules to be applied to each inbound FixMessage.
     *
     * If one or more rules are triggered, then the test case will proceed, the details of each triggered rule will be printed out to the fix4j-assert log.
     *
     * NOTE: for an inbound rule to trigger, the test case must either:
     * --Be using a test session which automatically 'pushes' received messages into the test case.  (See {@link org.fix4j.test.session.DispatchingSession} or
     *   {@link org.fix4j.test.session.ConsumerSession}
     * --Or call a method on the test session which attempts to fetch the next method. e.g. {@link org.fix4j.test.session.MatchingSession#expect} or
     *   {@link org.fix4j.test.session.BlockingSession#getNextMessage}
     */
    protected MessageFlagRules createInboundMessageFlagWarningRules() {
        return MessageFlagRules.EMPTY;
    }

    @Override
    public final FixSpecification getFixSpecification() {
        return fixSpecification;
    }
}
