package org.fix4j.test.fixspec;

import org.fix4j.test.fixmodel.PrettyPrintable;

import java.util.List;

/**
 * User: ben
 * Date: 16/10/2014
 * Time: 9:21 PM
 */
public interface FieldAndGroupTypes extends PrettyPrintable, FieldTypeSource{
    List<MemberFieldType> getFieldTypes();
    List<GroupType> getGroupTypes();
    GroupType getGroupType(int tag);
    boolean containsChild(FieldType type);
    boolean containsRecursively(FieldType type);
    List<Integer> getFieldOrder();
}
