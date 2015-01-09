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
public class OutboundRecentMessageProcessor implements OnFailureReporter, Provider<RecentMessages>, Processor<FixMessage> {
    private final RecentMessages recentMessages;
    private final MessageFlagRules outboundMessageFlagWarningRules;

    public OutboundRecentMessageProcessor(final MessageFlagRules outboundMessageFlagWarningRules) {
        this.recentMessages = new RecentMessages(10);
        this.outboundMessageFlagWarningRules = outboundMessageFlagWarningRules;
    }

    @Override
    public FixMessage process(final FixMessage message) {
        recentMessages.add(message);
        return message;
    }

    @Override
    public Report getReportOnFailure() {
        final Report recentMessagesReport = recentMessages.getReportWithHeading("RECENT OUTBOUND MESSAGES");
        final Report messageWarnings = recentMessages.getReportForFlaggedMessages(outboundMessageFlagWarningRules);
        return new CompositeReport(recentMessagesReport, messageWarnings);
    }

    @Override
    public RecentMessages get() {
        return recentMessages;
    }
}
