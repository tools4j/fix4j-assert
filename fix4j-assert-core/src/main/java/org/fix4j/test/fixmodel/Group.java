package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.GroupType;
import org.fix4j.test.fixspec.Tag;

import java.util.List;

/**
 * User: ben
 * Date: 26/09/2014
 * Time: 5:33 AM
 */
public interface Group extends FieldSource, PrettyPrintable {
    GroupType getType();
    Field getNoOfField();
    List<FieldsAndGroups> getRepeats();
    Tag<Integer> getTag();
}
