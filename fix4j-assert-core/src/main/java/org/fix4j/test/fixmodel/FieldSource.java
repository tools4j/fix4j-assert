package org.fix4j.test.fixmodel;

import java.util.List;
import java.util.Map;

/**
 * User: ben
 * Date: 16/10/2014
 * Time: 7:48 PM
 */
public interface FieldSource {
    List<Field> getAllFieldsRecursively();
    Map<String, Field> getFieldReferenceMap();
}
