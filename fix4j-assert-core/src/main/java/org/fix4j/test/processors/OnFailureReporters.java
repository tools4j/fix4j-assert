package org.fix4j.test.processors;

import org.fix4j.test.session.Failure;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.util.Report;

import java.util.Arrays;
import java.util.List;

/**
 * User: ben
 * Date: 2/12/14
 * Time: 5:42 AM
 */
public class OnFailureReporters {
    private final List<OnFailureReporter> reporters;

    public OnFailureReporters(final OnFailureReporter ... reporters) {
        this.reporters = Arrays.asList(reporters);
    }

    public Error enrichFailureWithAdditionalReports(final FixSessionId fixSessionId, final Failure failure) {
        final List<Report> reports = OnFailureReporter.Util.fetchReportsFromReporters(reporters);
        return failure.withPrefixedMessage(fixSessionId.toString() + ": ").withAdditionalReports(reports);
    }
}
