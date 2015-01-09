package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.PrettyPrintable;
import org.fix4j.test.messageflags.MessageFlagRules;
import org.fix4j.test.messageflags.MessageFlags;
import org.fix4j.test.util.BoundedArray;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.Report;

import java.util.Iterator;

import static org.fix4j.test.util.Consts.EOL;
import static org.fix4j.test.util.Consts.INDENT;

/**
 * User: ben
 * Date: 27/09/2014
 * Time: 5:03 AM
 */
public class RecentMessages implements PrettyPrintable {
    private final BoundedArray<FixMessage> messages;
    public final static RecentMessages EMPTY = new RecentMessages(0);

    public RecentMessages(final int capacity) {
        messages = new BoundedArray<>(capacity);
    }

    public void add(FixMessage message){
        messages.add(message);
    }

    public void addAll(final RecentMessages recentMessages) {
        messages.addAll(recentMessages.iterator());
    }

    @Override
    public String toPrettyString() {
        if(!messages.isEmpty()){
            final StringBuilder sb = new StringBuilder();
            final Iterator<FixMessage> messages = this.messages.iterator();
            int i = 1;
            if(this.messages.wasAddedToWhenAtCapacity()){
                sb.append(INDENT).append("[note: only the most recent messages are displayed]").append(EOL);
            }
            while (messages.hasNext()) {
                final FixMessage fixMessage = messages.next();
                sb.append(INDENT).append(i++).append(". ").append(fixMessage.toDelimitedMessageWithDescriptors()).append(EOL);
            }
            return sb.toString();
        } else {
            return INDENT + "<none>" + Consts.EOL;
        }
    }

    public Report getReportForFlaggedMessages(final MessageFlagRules messageFlagRules) {
        return new Report() {
            @Override
            public String getReportAsString() {
                final StringBuilder sb = new StringBuilder();
                int i=1;
                for(final FixMessage message: RecentMessages.this.messages){
                    final MessageFlags messageFlags = messageFlagRules.getFlagsForMessage(message);
                    if(!messageFlags.isEmpty()){
                        sb.append(INDENT).append(i++).append(". ").append(messageFlags.toPrettyString());
                    }
                }
                return sb.toString();
            }
        };
    }

    public Iterator<FixMessage> iterator() {
        return messages.iterator();
    }

    public boolean isEmpty() {
        return messages.isEmpty();
    }

    public Report getReportWithHeading(final String heading) {
        return new Report() {
            @Override
            public String getReportAsString() {
                return heading + Consts.EOL + toPrettyString();
            }
        };
    }
}
