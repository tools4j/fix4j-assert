package org.fix4j.test.processors;

import org.fix4j.test.util.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * User: bens
 * Date: 1/12/14
 * Time: 5:39 PM
 */
public interface OnFailureReporter {
    public static class Util{
        public static List<Report> fetchReportsFromReporters(final List<OnFailureReporter> reporters) {
            final ArrayList<Report> reports = new ArrayList<>();
            for (final OnFailureReporter reporter : reporters) {
                reports.add(reporter.getReportOnFailure());
            }
            return reports;
        }
    }
    Report getReportOnFailure();
}
