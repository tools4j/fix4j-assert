package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.GroupType;

import java.util.List;

/**
 * User: ben
 * Date: 16/10/2014
 * Time: 9:21 PM
 */
public interface FieldsAndGroups extends FieldSource, PrettyPrintable{
    List<Field> getFields();
    List<Group> getGroups();
    Field getField(FieldType fieldType);
    Group getGroup(GroupType groupType);
    Field getField(int tag);
    FieldsAndGroups withField(final Field field);
}
