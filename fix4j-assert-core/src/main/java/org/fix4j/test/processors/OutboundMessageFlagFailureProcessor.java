package org.fix4j.test.processors;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.Processor;
import org.fix4j.test.session.Failure;
import org.fix4j.test.messageflags.MessageFlagRules;
import org.fix4j.test.messageflags.MessageFlags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 21/11/14
 * Time: 4:49 PM
 */
public class OutboundMessageFlagFailureProcessor implements Processor<FixMessage> {
    private final MessageFlagRules outboundMessageFlagRules;
    private final static Logger LOGGER = LoggerFactory.getLogger(InboundMessageFlagFailureProcessor.class);
    private final boolean fastFailOnTriggerOfOutboundMessageFlag;

    public OutboundMessageFlagFailureProcessor(final MessageFlagRules outboundMessageFlagRules, final boolean fastFailOnTriggerOfOutboundMessageFlag) {
        this.outboundMessageFlagRules = outboundMessageFlagRules;
        this.fastFailOnTriggerOfOutboundMessageFlag = fastFailOnTriggerOfOutboundMessageFlag;
    }

    @Override
    public FixMessage process(final FixMessage message) {
        if(fastFailOnTriggerOfOutboundMessageFlag) {
            final MessageFlags messageFlags = outboundMessageFlagRules.getFlagsForMessage(message);
            if (!messageFlags.isEmpty()) {
                throw new Failure(messageFlags, message);
            } else {
                LOGGER.warn(messageFlags.toPrettyString());
            }
        }
        return message;
    }
}
