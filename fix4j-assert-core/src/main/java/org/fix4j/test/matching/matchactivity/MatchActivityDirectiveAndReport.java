package org.fix4j.test.matching.matchactivity;

import org.fix4j.test.util.Report;
import org.fix4j.test.util.Reportable;

/**
 * User: ben
 * Date: 7/11/2014
 * Time: 5:19 AM
 */
public class MatchActivityDirectiveAndReport implements Reportable {
    private final ResultDirective resultDirective;
    private final Report report;

    public static MatchActivityDirectiveAndReport discardAndContinue(){ return new MatchActivityDirectiveAndReport(ResultDirective.DISCARD_AND_CONTINUE); }
    public static MatchActivityDirectiveAndReport finish(final Report report){ return new MatchActivityDirectiveAndReport(ResultDirective.FINISH, report);}

    private MatchActivityDirectiveAndReport(final ResultDirective resultDirective, final Report report) {
        this.resultDirective = resultDirective;
        this.report = report;
    }

    private MatchActivityDirectiveAndReport(final ResultDirective resultDirective) {
        this.resultDirective = resultDirective;
        this.report = null;
    }

    public boolean discardThisMessage(){
        return resultDirective.discardThisMessage();
    }

    public boolean finished(){
        return resultDirective.finished();
    }

    @Override
    public Report getReport() {
        return report;
    }

    enum ResultDirective {
        DISCARD_AND_CONTINUE(false, true),
        FINISH(true, false);

        private final boolean finish;
        private final boolean logAsDiscarded;

        ResultDirective(final boolean finish, final boolean logAsDiscarded) {
            this.finish = finish;
            this.logAsDiscarded = logAsDiscarded;
        }

        public boolean finished() {
            return finish;
        }

        public boolean discardThisMessage() {
            return logAsDiscarded;
        }
    }
}
