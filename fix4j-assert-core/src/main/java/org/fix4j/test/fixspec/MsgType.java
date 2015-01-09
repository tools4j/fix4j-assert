package org.fix4j.test.fixspec;


import org.fix4j.test.fixmodel.FixMessage;

import java.util.List;

/**
 * User: ben
 * Date: 25/08/2014
 * Time: 10:24 PM
 */
public interface MsgType extends FieldAndGroupTypes, Type {
    String getName();
    List<MemberFieldType> getFieldTypes();
    List<GroupType> getGroupTypes();
    Tag<String> getTag();
    boolean containsChild(FieldType type);
    FixMessage generateExampleMessage(FixSpecification fixSpecification);
}
