package org.fix4j.test.matching.matchactivity;

import org.fix4j.test.session.RecentMessages;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.Report;

/**
 * User: ben
 * Date: 5/11/2014
 * Time: 5:33 PM
 */
public class DiscardedMessageReport implements Report {
    private final RecentMessages discardedMessages;

    public DiscardedMessageReport(final RecentMessages discardedMessages) {
        this.discardedMessages = discardedMessages;
    }

    @Override
    public String getReportAsString() {
        if(!discardedMessages.isEmpty()) {
            return "DISCARDED MESSAGES (oldest to newest):" + Consts.EOL + discardedMessages.toPrettyString();
        } else {
            return "";
        }
    }
}
