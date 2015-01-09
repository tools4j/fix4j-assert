package org.fix4j.test.matching.matchers;

import org.fix4j.test.util.Report;
import org.fix4j.test.util.Reportable;

/**
 * User: ben
 * Date: 20/11/14
 * Time: 9:24 AM
 */
public class SimpleMatchResult implements Reportable {
    private final boolean matches;
    private final Report report;

    public SimpleMatchResult(final boolean matches, final Report report) {
        this.matches = matches;
        this.report = report;
    }

    public boolean matches() {
        return matches;
    }

    public Report getReport() {
        return report;
    }
}
