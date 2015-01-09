package org.fix4j.test.matching.matchactivity;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.Supplier;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.properties.PropertyKeysAndDefaultValues;
import org.fix4j.test.session.RecentMessages;
import org.fix4j.test.util.BaseReport;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 5/11/2014
 * Time: 4:44 PM
 */
public class MatchActivity {
    private final static Logger LOGGER = LoggerFactory.getLogger(MatchActivity.class);
    private final Supplier<FixMessage> messages;
    private final MatchActivityMessageProcessor messageProcessor;
    private final ApplicationProperties testProperties;

    public MatchActivity(
            final Supplier<FixMessage> messages,
            final MatchActivityMessageProcessor messageProcessor,
            final ApplicationProperties testProperties) {

        this.messages = messages;
        this.messageProcessor = messageProcessor;
        this.testProperties = testProperties;
    }

    public MatchActivityResult run() {
        final RecentMessages discardedMessages = new RecentMessages(testProperties.getAsInt(PropertyKeysAndDefaultValues.SIZE_OF_DISCARDED_MESSAGES.getKey()));
        final long timeStarted = DateUtils.now();

        while((DateUtils.timeSince(timeStarted) < testProperties.getAsLong(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS.getKey()))){
            long timeRemaining = testProperties.getAsLong(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS.getKey()) - DateUtils.timeSince(timeStarted);
            final FixMessage message = messages.get(timeRemaining);

            if(message == null) {
                messageProcessor.handleTimeout();
            }

            //Message processing
            MatchActivityDirectiveAndReport matchActivityDirectiveAndReport = messageProcessor.processMessage(message);
            if(matchActivityDirectiveAndReport.discardThisMessage()) {
                LOGGER.info("<<<<<< Discarding message " + message.toDelimitedMessageWithDescriptors());
                discardedMessages.add(message);
            }
            if(matchActivityDirectiveAndReport.finished()){
                LOGGER.info("<<<<<< Match!" + Consts.EOL + matchActivityDirectiveAndReport.getReport().getReportAsString() + message.toPrettyString());
                return new MatchActivityResult(true, message, matchActivityDirectiveAndReport.getReport(), new DiscardedMessageReport(discardedMessages));
            }
        }
        messageProcessor.handleTimeout();

        //We should rarely get to this point.  Only if the tester is testing that no messages are received up to a timeout
        //occurs.  Usually the handleTimeout() would throw an exception.
        return new MatchActivityResult(true, null, new BaseReport("Timeout has occurred."));
    }

}
