package org.fix4j.test.matching.matchactivity;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.matching.matchers.MatchResult;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.StringUtils;

/**
 * User: ben
 * Date: 28/11/14
 * Time: 6:09 AM
 */
public class MatchFailureTextFactory {
    public String generateFailureMessage(final FixMessage message, final MatchResult matchResult, final String failureText) {
        return Consts.EOL
                + StringUtils.indentAllLines(1, failureText)
                + StringUtils.indentAllLines(1, "MATCH DETAILS::" + Consts.EOL)
                + StringUtils.indentAllLines(2, matchResult.getReportAsString())
                + StringUtils.indentAllLines(1, "MESSAGE RECEIVED::" + Consts.EOL)
                + StringUtils.indentAllLines(2, message.toPrettyString());
    }
}
