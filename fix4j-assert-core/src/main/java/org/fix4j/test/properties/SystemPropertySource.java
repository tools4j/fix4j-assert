package org.fix4j.test.properties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Provides a source of properties from the JVMs list of system properties.
 *
 * These are the properties that are usually available by calling System.getProperty(key)
 *
 * These properties can be specified programatically, e.g.
 * <code>
 *     System.setProperty("fix4j.first.property", "blah");
 * </code>
 * ...or via the command line:
 * java -Dfix4j.first.property=blah MyAppOrTest
 *
 * Please note, only keys prefixed with "fix4j" or "FIX4J" will be available.
 *
 * User: ben
 */
public class SystemPropertySource implements PropertySource {
    private final static String SOURCE_NAME = "SYSTEM_PROPERTIES";

    @Override
    public String getSourceName() {
        return SOURCE_NAME;
    }

    @Override
    public Map<String, String> getProperties() {
        return PropertyUtils.getPropertiesWithFix4jKeyPrefix(PropertyUtils.convertObjectMapToStringMap(System.getProperties()));
    }
}
