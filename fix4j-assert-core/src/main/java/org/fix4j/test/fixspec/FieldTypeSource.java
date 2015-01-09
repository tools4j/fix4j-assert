package org.fix4j.test.fixspec;

import java.util.Map;
import java.util.Set;

/**
 * User: ben
 * Date: 31/10/2014
 * Time: 8:54 PM
 */
public interface FieldTypeSource {
    Set<MemberFieldType> getAllFieldTypesRecursively();
    Map<Integer, MemberFieldType> getAllFieldTypesByTagRecursively();
    Set<GroupType> getAllGroupTypesRecursively();
    Map<Integer, GroupType> getAllGroupTypesByTagRecursively();
}
