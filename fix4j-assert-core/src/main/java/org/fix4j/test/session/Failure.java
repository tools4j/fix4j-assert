package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.util.CompositeReport;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.Report;

import java.util.List;

/**
 * User: ben
 * Date: 22/11/14
 * Time: 4:25 AM
 */
public class Failure extends AssertionError {
    private static final long serialVersionUID = -6098281437774175888L;
    private final FixMessage fixMessage;

    public Failure(final Report report, final FixMessage fixMessage) {
        super(report.getReportAsString() + fixMessage.toDelimitedMessageWithDescriptors() + Consts.EOL);
        this.fixMessage = fixMessage;
    }

    public Failure(final FixMessage fixMessage, final Throwable cause) {
        super("Exception when processing messsage: " + fixMessage.toDelimitedMessageWithDescriptors() + Consts.EOL, cause);
        this.fixMessage = fixMessage;
    }

    public Failure(final Report report) {
        super(report.getReportAsString());
        this.fixMessage = null;
    }

    public Failure(final String message) {
        super(message);
        this.fixMessage = null;
    }

    public Failure(final String message, final Throwable cause) {
        super(message, cause);
        this.fixMessage = null;
    }

    public Failure(final Throwable cause) {
        super(cause);
        this.fixMessage = null;
    }

    public Failure(final String heading, final Report report) {
        super(heading + Consts.EOL + report.getReportAsString());
        this.fixMessage = null;
    }

    public Failure(final FixMessage fixMessage, final String message) {
        super(message);
        this.fixMessage = fixMessage;
    }

    public Failure(final String message, final FixMessage fixMessage, final Throwable cause) {
        super(message, cause);
        this.fixMessage = fixMessage;
    }

    public Failure withAdditionalReports(final List<Report> reports) {
        final CompositeReport otherReports = new CompositeReport(reports);
        return new Failure(this.getMessage() + otherReports.getReportAsString(), fixMessage, this.getCause());
    }

    public Failure withHeading(final String heading) {
        return new Failure(heading + Consts.EOL + getMessage(), fixMessage, this.getCause());
    }

    public Failure withPrefixedMessage(final String prefix) {
        return new Failure(prefix + getMessage(), fixMessage, this.getCause());
    }

    public FixMessage getFixMessage() {
        return fixMessage;
    }

    @Override
    public String toString() {
        return "FAILURE: " + super.getMessage() + Consts.EOL;
    }
}
