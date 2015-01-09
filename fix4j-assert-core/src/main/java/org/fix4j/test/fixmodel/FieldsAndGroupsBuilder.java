package org.fix4j.test.fixmodel;

import java.util.ArrayList;
import java.util.List;

/**
* User: ben
* Date: 17/10/2014
* Time: 7:55 PM
*/
public class FieldsAndGroupsBuilder {
    private final List<Group> groups = new ArrayList<>();
    private final List<Field> fields = new ArrayList<>();

    public FieldsAndGroupsBuilder withField(final Field field){
        fields.add(field);
        return this;
    }

    public FieldsAndGroupsBuilder withGroup(final Group group){
        groups.add(group);
        return this;
    }

    public FieldsAndGroups build(){
        return new BaseFieldsAndGroups(fields, groups);
    }
}
