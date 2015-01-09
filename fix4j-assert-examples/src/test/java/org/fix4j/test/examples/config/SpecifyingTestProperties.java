package org.fix4j.test.examples.config;

import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.integration.quickfix.QuickFixProperties;
import org.fix4j.test.properties.PropertyKeysAndDefaultValues;
import org.fix4j.test.properties.PropertyUtils;
import org.fix4j.test.session.ContextFactory;
import org.fix4j.test.session.DispatchingSession;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.MatchingSession;
import org.fix4j.test.session.TestSessionHelper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * Shows some different ways of passing properties to the test framework.
 *
 * One method not shown here is by using environment variables.
 *
 * @see org.fix4j.test.properties.SystemEnvVariablePropertySource
 * @see org.fix4j.test.properties.SystemPropertySource
 *
 * User: ben
 */
public class SpecifyingTestProperties {

    @Test
    public void setSystemProperties() {
        //Although I am setting these properties programatically, they can also be specified on the command line
        System.setProperty(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS.getKey(), "11111");
        System.setProperty(QuickFixProperties.RECONNECT_INTERVAL.getKey(), "11");

        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
        final MatchingSession session = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID_1", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);
        assertEquals("11111", session.getProperties().getAsString(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS));
        assertEquals("11", session.getProperties().getAsString(QuickFixProperties.RECONNECT_INTERVAL));
    }

    @Test
    public void getPropertiesFromAMap(){
        final Map<String, String> properties = new HashMap<>();
        properties.put(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS.getKey(), "22222");
        properties.put(QuickFixProperties.RECONNECT_INTERVAL.getKey(), "22");

        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
        final MatchingSession session = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID_1", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR, properties);

        assertEquals("22222", session.getProperties().getAsString(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS));
        assertEquals("22", session.getProperties().getAsString(QuickFixProperties.RECONNECT_INTERVAL));
    }

    @Test
    public void setFromPropertiesFile() throws IOException {
        final Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/foo.properties"));

        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
        final MatchingSession session = helper.createMatchingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID_1", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR, PropertyUtils.convertObjectMapToStringMap(properties));

        assertEquals("33333", session.getProperties().getAsString(PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS));
        assertEquals("33", session.getProperties().getAsString(QuickFixProperties.RECONNECT_INTERVAL));
    }
}
