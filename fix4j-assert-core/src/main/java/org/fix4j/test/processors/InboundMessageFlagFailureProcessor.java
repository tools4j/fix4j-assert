package org.fix4j.test.processors;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.messageflags.MessageFlagRules;
import org.fix4j.test.messageflags.MessageFlags;
import org.fix4j.test.plumbing.Processor;
import org.fix4j.test.session.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 21/11/14
 * Time: 4:49 PM
 */
public class InboundMessageFlagFailureProcessor implements Processor<FixMessage>{
    private final static Logger LOGGER = LoggerFactory.getLogger(InboundMessageFlagFailureProcessor.class);
    private final MessageFlagRules inboundMessageFlagRules;
    private final boolean fastFailOnTriggerOfIncomingMessageFlag;

    public InboundMessageFlagFailureProcessor(final MessageFlagRules inboundMessageFlagRules, final boolean fastFailOnTriggerOfIncomingMessageFlag) {
        this.inboundMessageFlagRules = inboundMessageFlagRules;
        this.fastFailOnTriggerOfIncomingMessageFlag = fastFailOnTriggerOfIncomingMessageFlag;
    }

    @Override
    public FixMessage process(final FixMessage message) {
        final MessageFlags messageFlags = inboundMessageFlagRules.getFlagsForMessage(message);
        if (!messageFlags.isEmpty()) {
            if(fastFailOnTriggerOfIncomingMessageFlag) {
                throw new Failure(messageFlags, message);
            } else {
                LOGGER.warn(messageFlags.toPrettyString());
            }
        }
        return message;
    }
}
