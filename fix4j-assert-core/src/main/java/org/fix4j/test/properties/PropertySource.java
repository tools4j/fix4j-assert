package org.fix4j.test.properties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: ben
 * Date: 3/12/14
 * Time: 5:05 PM
 */
public interface PropertySource {
    Map<String, String> getProperties();
    public String getSourceName();
}
