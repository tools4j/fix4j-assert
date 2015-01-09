package org.fix4j.test.processors;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.matching.matchers.FixMessageMatcher;
import org.fix4j.test.plumbing.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 21/11/14
 * Time: 4:49 PM
 */
public class InboundIgnoreProcessor implements Processor<FixMessage> {
    private final static Logger LOGGER = LoggerFactory.getLogger(InboundIgnoreProcessor.class);
    private final FixMessageMatcher messagesToIgnore;

    public InboundIgnoreProcessor(final FixMessageMatcher messagesToIgnore) {
        this.messagesToIgnore = messagesToIgnore;
    }

    @Override
    public FixMessage process(final FixMessage message) {
        if(messagesToIgnore.getMatchResult(message).matches()){
            LOGGER.info("Ignoring: " + message.toDelimitedMessageWithDescriptors());
            return null;
        }
        return message;
    }
}
