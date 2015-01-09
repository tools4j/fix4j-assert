package org.fix4j.test.properties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Provides a source of properties from the JVMs list of environment variables.
 *
 * Only environment variables starting with "fix4j" or "FIX4J" will be sourced.
 *
 * Also, keys will be formatted using the following two rules:
 *  -Underscores are replaces with periods '.'
 *  -The key is converted to lowercase (value is left as is)
 *
 *  For example, the environment variables:
 *  FIX4J_FIRST_PROPERTY=blah1
 *  FIX4J_SECOND_PROPERTY=BLAH2
 *  fix4j_third_property=blah3
 *  RANDOM_PROPERTY=dunno
 *
 *  Will become available in the property source as:
 *  fix4.first.property=blah1
 *  fix4.second.property=BLAH2
 *  fix4.third.property=blah1
 *
 * User: ben
 */
public class SystemEnvVariablePropertySource implements PropertySource {
    private final static String SOURCE_NAME = "ENVIRONMENT_VARIABLES";

    @Override
    public String getSourceName() {
        return SOURCE_NAME;
    }

    @Override
    public Map<String, String> getProperties() {
        return getAndFormatRelevantEnvironmentVariables(System.getenv());
    }

    public Map<String, String> getAndFormatRelevantEnvironmentVariables(final Map<String, String> environmentVariables) {
        return PropertyUtils.formatKeys(PropertyUtils.getPropertiesWithFix4jKeyPrefix(environmentVariables));
    }
}
