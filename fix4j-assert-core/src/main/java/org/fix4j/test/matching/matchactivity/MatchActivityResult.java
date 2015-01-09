package org.fix4j.test.matching.matchactivity;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.util.CompositeReport;
import org.fix4j.test.util.Report;
import org.fix4j.test.util.Reportable;

import java.util.Arrays;

/**
 * User: ben
 * Date: 10/11/2014
 * Time: 5:58 AM
 */
public class MatchActivityResult implements Reportable {
    private final Report report;
    private final FixMessage message;
    private final boolean success;

    public MatchActivityResult(final boolean success, final FixMessage message, final Report report) {
        this.success = success;
        this.report = report;
        this.message = message;
    }

    public MatchActivityResult(final boolean success, final FixMessage message, final Report ... reports) {
        this.success = success;
        this.report = new CompositeReport(Arrays.asList(reports));
        this.message = message;
    }

    public FixMessage getMessage() {
        return message;
    }

    @Override
    public Report getReport() {
        return report;
    }

    public boolean isSuccess() {
        return success;
    }
}
