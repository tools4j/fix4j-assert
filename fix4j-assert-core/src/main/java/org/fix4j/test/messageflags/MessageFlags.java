package org.fix4j.test.messageflags;


import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.PrettyPrintable;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.Report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: ben
 * Date: 7/11/2014
 * Time: 5:58 PM
 */
public class MessageFlags implements PrettyPrintable, Report {
    public static final MessageFlags EMPTY = new MessageFlags(null, new ArrayList<MessageFlag>());
    private final List<MessageFlag> flags;
    private final FixMessage fixMessage;

    public MessageFlags(final FixMessage fixMessage, final List<MessageFlag> flags) {
        this.fixMessage = fixMessage;
        this.flags = flags;
    }

    public boolean isEmpty(){
        return flags.isEmpty();
    }

    public FixMessage getFixMessage() {
        return fixMessage;
    }

    @Override
    public String toString() {
        return "MessageFlags{" +
                "flags=" + flags +
                '}';
    }

    @Override
    public String toPrettyString(){
        if(fixMessage == null) return "";
        final StringBuilder sb = new StringBuilder();
        if(flags.size() > 0) {
            int i=1;
            sb.append(fixMessage).append(Consts.EOL);
            for (final MessageFlag triggeredFlag : flags) {
                sb.append(Consts.INDENT).append(i++).append(".   ").append(triggeredFlag.toPrettyString());
            }
        }
        return sb.toString();
    }

    public void addAll(final MessageFlags msgFlags){
        this.flags.addAll(msgFlags.flags);
    }

    public static MessageFlags singleFlag(final FixMessage fixMessage, final String message) {
        final List<MessageFlag> flags = Collections.singletonList(new MessageFlag(fixMessage, message));
        return new MessageFlags(fixMessage, flags);
    }

    public List<MessageFlag> getFlags() {
        return flags;
    }

    @Override
    public String getReportAsString() {
        return toPrettyString();
    }
}
