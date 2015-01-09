package org.fix4j.test.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User: ben
 * Date: 19/11/14
 * Time: 4:41 PM
 */
public class CompositeReport implements Report {
    private final List<Report> reports;

    public CompositeReport(final List<? extends Report> reports) {
        this.reports = Collections.unmodifiableList(reports);
    }

    public CompositeReport(final Report ... reports) {
        this.reports = Collections.unmodifiableList(Arrays.asList(reports));
    }

    public String getReportAsString(){
        final StringBuilder sb = new StringBuilder();
        for (final Report report : reports) {
            sb.append(report.getReportAsString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "CompositeReport{" +
                "reports=" + reports +
                '}';
    }

    public static class CompositeReportBuilder{
        private final List<Report> reports = new ArrayList<>();

        public CompositeReportBuilder add(final Report report){
            this.reports.add(report);
            return this;
        }

        public CompositeReport build(){
            return new CompositeReport(reports);
        }
    }
}
