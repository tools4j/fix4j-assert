package org.fix4j.test.matching.matchactivity;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.matching.matchers.FixMessageMatcher;
import org.fix4j.test.matching.matchers.MatchResult;
import org.fix4j.test.session.Failure;
import org.fix4j.test.session.TimeoutReport;
import org.fix4j.test.util.Report;

/**
 * User: ben
 * Date: 7/11/2014
 * Time: 5:11 AM
 */
public class DiscardUntilMatchProcessor implements MatchActivityMessageProcessor {
    private final FixMessageMatcher fixMessageMatcher;

    public DiscardUntilMatchProcessor(final FixMessageMatcher fixMessageMatcher) {
        this.fixMessageMatcher = fixMessageMatcher;
    }

    @Override
    public MatchActivityDirectiveAndReport processMessage(final FixMessage message) {
        final MatchResult result = fixMessageMatcher.getMatchResult(message);
        if(result.matches()){
            return MatchActivityDirectiveAndReport.finish(result);
        } else {
            return MatchActivityDirectiveAndReport.discardAndContinue();
        }
    }

    @Override
    public Report handleTimeout() {
        throw new Failure(new TimeoutReport(fixMessageMatcher));
    }
}
