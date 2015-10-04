package org.fix4j.test.session;

import org.fix4j.test.integration.FixEngineSession;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.processors.OnFailureReporters;
import org.fix4j.test.properties.ApplicationProperties;

/**
 * User: ben
 * Date: 25/11/14
 * Time: 5:27 PM
 */
public class SessionContext {
    public final SessionConnectors sessionConnectors;
    public final FixSessionId fixSessionId;
    public final OnFailureReporters onFailureReporters;
    public final FixConnectionMode fixConnectionMode;
    public final FixEngineSession fixEngineSession;
    public final FixSpecification fixSpecification;

    public SessionContext(final SessionConnectors sessionConnectors, final FixSessionId fixSessionId, final OnFailureReporters onFailureReporters, final FixConnectionMode fixConnectionMode, final FixEngineSession fixEngineSession, final FixSpecification fixSpecification) {
        this.sessionConnectors = sessionConnectors;
        this.fixSessionId = fixSessionId;
        this.onFailureReporters = onFailureReporters;
        this.fixConnectionMode = fixConnectionMode;
        this.fixEngineSession = fixEngineSession;
        this.fixSpecification = fixSpecification;
    }

    public Error enrichFailureWithAdditionalReports(final Failure failure) {
        return onFailureReporters.enrichFailureWithAdditionalReports(fixSessionId, failure);
    }
}
