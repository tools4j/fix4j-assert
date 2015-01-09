package org.fix4j.test.util;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a number of requirements, for classes that return a report:
 * --With some classes we want to return a FAIL/WARN/INFO.  e.g. We might want to fail-fast when inbound messages are flagged, i.e. we've received a session
 *   level reject.  Whereas we might have configured the system to just flag it as a warning.
 *
 *   FAIL/WARN/INFO & report
 *
 *
 * --With some classes we want to return matches=true/false.  e.g. a matcher might be used to decide whether to filter out
 *   a message.  Or a matcher might be used to decide whether we have a message which passes our assert.  Using a FAIL for a non-match
 *   in the filter might seem strange.  i.e. we get a FAIL so we don't filter.
 *
 *   MatchResult
 *   true/false & report
 *
 *
 * --With some classes we want to return a "directive" and a report.  e.g. when doing a discardUntilMatch assert, we want
 *   to let the MatchActivity know to discard non matching messages.  When a message matches, then we want to stop discarding
 *   and return a report showing how the match occurred.  So in this case returning a FAIL when it doesn't match, and an INFO
 *   when it does match, does not really make sense.
 *
 *   MatchActivityDirectiveAndReport
 *   directive & report
 *
 *
 *   --In some cases we want to return the matches message and a report.  e.g. when doing message matching for oncoming messages.
 *   MatchActivityResult
 *   message & success & report
 *
 */
public interface Report {
    public static class Util{
        public static List<Report> fetchReportsFromReporters(final List<Reportable> reporters) {
            final ArrayList<Report> reports = new ArrayList<>();
            for (final Reportable reporter : reporters) {
                reports.add(reporter.getReport());
            }
            return reports;
        }
    }
    String getReportAsString();
}
