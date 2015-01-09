package org.fix4j.test.session;

import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.properties.ApplicationProperties;

import java.util.Map;
import java.util.Properties;

/**
 * User: ben
 * Date: 2/12/14
 * Time: 5:35 AM
 */
public interface ContextFactory {
    SessionContext createSessionContext(FixSessionId fixSessionId, FixConnectionMode fixConnectionMode, Map<String,String> sessionProperties);
    FixSpecification getFixSpecification();
}
