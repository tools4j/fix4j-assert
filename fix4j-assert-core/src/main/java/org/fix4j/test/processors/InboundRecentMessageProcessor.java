package org.fix4j.test.processors;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.messageflags.MessageFlagRules;
import org.fix4j.test.plumbing.Processor;
import org.fix4j.test.plumbing.Provider;
import org.fix4j.test.session.RecentMessages;
import org.fix4j.test.util.CompositeReport;
import org.fix4j.test.util.Report;

/**
 * User: ben
 * Date: 21/11/14
 * Time: 4:49 PM
 */
public class InboundRecentMessageProcessor implements Provider<RecentMessages>, Processor<FixMessage>, OnFailureReporter {
    private final RecentMessages recentMessages;
    private final MessageFlagRules inboundMessageFlagWarningRules;

    public InboundRecentMessageProcessor(final MessageFlagRules inboundMessageFlagWarningRules) {
        this.recentMessages = new RecentMessages(10);
        this.inboundMessageFlagWarningRules = inboundMessageFlagWarningRules;
    }

    @Override
    public FixMessage process(final FixMessage message) {
        recentMessages.add(message);
        return message;
    }

    @Override
    public RecentMessages get() {
        return recentMessages;
    }

    @Override
    public Report getReportOnFailure() {
        final Report recentMessagesReport = recentMessages.getReportWithHeading("RECENT INBOUND MESSAGES");
        final Report messageWarningReport = recentMessages.getReportForFlaggedMessages(inboundMessageFlagWarningRules);
        return new CompositeReport(recentMessagesReport, messageWarningReport);
    }
}
