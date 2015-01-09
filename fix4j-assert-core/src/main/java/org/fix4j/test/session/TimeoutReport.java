package org.fix4j.test.session;

import org.fix4j.test.matching.matchers.FixMessageMatcher;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.Report;

/**
 * User: ben
 * Date: 7/11/2014
 * Time: 6:31 PM
 */
public class TimeoutReport implements Report {
    private final FixMessageMatcher matcher;

    public TimeoutReport(final FixMessageMatcher matcher) {
        this.matcher = matcher;
    }

    public TimeoutReport() {
        this.matcher = null;
    }

    @Override
    public String getReportAsString() {
        if(matcher == null){
            return "Timeout waiting for next message" + Consts.EOL;
        } else {
            return "Timeout waiting for message which matches: " + matcher.toString() + Consts.EOL;
        }
    }
}
