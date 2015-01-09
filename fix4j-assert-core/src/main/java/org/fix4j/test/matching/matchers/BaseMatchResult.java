package org.fix4j.test.matching.matchers;

import org.fix4j.test.util.BaseReport;
import org.fix4j.test.util.Report;

/**
 * User: ben
 * Date: 20/11/14
 * Time: 9:24 AM
 */
public class BaseMatchResult implements MatchResult{
    private final Report report;
    private final boolean matches;

    public BaseMatchResult(final boolean matches, final Report report) {
        this.report = report;
        this.matches = matches;
    }

    public BaseMatchResult(final boolean matches, final String report) {
        this.report = new BaseReport(report);
        this.matches = matches;
    }

    @Override
    public boolean matches(){
        return matches;
    }

    @Override
    public String getReportAsString() {
        return report.getReportAsString();
    }
}
