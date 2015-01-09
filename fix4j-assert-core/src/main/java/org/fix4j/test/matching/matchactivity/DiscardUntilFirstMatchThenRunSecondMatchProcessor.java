package org.fix4j.test.matching.matchactivity;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.matching.matchers.FixMessageMatcher;
import org.fix4j.test.matching.matchers.MatchResult;
import org.fix4j.test.session.Failure;
import org.fix4j.test.session.TimeoutReport;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.Report;

/**
 * User: ben
 * Date: 7/11/2014
 * Time: 5:11 AM
 */
public class DiscardUntilFirstMatchThenRunSecondMatchProcessor implements MatchActivityMessageProcessor {
    private final FixMessageMatcher firstMatch;
    private final FixMessageMatcher secondMatch;

    public DiscardUntilFirstMatchThenRunSecondMatchProcessor(final FixMessageMatcher firstMatch, final FixMessageMatcher secondMatch) {
        this.firstMatch = firstMatch;
        this.secondMatch = secondMatch;
    }

    @Override
    public MatchActivityDirectiveAndReport processMessage(final FixMessage fixMessage) {
        final MatchResult firstMatchResult = firstMatch.getMatchResult(fixMessage);
        if(firstMatchResult.matches()){
            final MatchResult secondMatchResult = secondMatch.getMatchResult(fixMessage);
            if(!secondMatchResult.matches()){
                final String failureText =
                          "1. Found message that matches: " + firstMatch + Consts.EOL
                        + "2. But message does not match: " + secondMatch + Consts.EOL;

                throw new Failure(fixMessage, (new MatchFailureTextFactory()).generateFailureMessage(fixMessage, secondMatchResult, failureText));
            }
            return MatchActivityDirectiveAndReport.finish(secondMatchResult);
        } else {
            return MatchActivityDirectiveAndReport.discardAndContinue();
        }
    }

    @Override
    public Report handleTimeout() {
        throw new Failure(new TimeoutReport(firstMatch));
    }
}
