package org.fix4j.test.properties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: ben
 * Date: 17/12/14
 * Time: 11:50 PM
 */
public class PropertyUtils {
    private PropertyUtils() {
    }

    public static Map<String, String> getPropertiesWithFix4jKeyPrefix(final Map<String, String> environmentVariables) {
        final Map<String, String> processedVariables = new LinkedHashMap<>();
        for (final String key : environmentVariables.keySet()) {
            if(key.toUpperCase().startsWith("FIX4J")){
                processedVariables.put(key, environmentVariables.get(key));
            }
        }
        return processedVariables;
    }

    public static Map<String, String> formatKeys(final Map<String, String> environmentVariables) {
        final Map<String, String> processedVariables = new LinkedHashMap<>();
        for (final String envVarKey : environmentVariables.keySet()) {
            final String newKey = envVarKey.replace('_', '.').toLowerCase();
            processedVariables.put(newKey, environmentVariables.get(envVarKey));
        }
        return processedVariables;
    }

    public static Map<String, String> convertObjectMapToStringMap(final Map<Object, Object> properties) {
        final Map<String, String> stringProperties = new LinkedHashMap<>();
        for (final Object key : properties.keySet()) {
            stringProperties.put(key.toString(), properties.get(key).toString());
        }
        return stringProperties;
    }
}
