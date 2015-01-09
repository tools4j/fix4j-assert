package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.GroupType;

import java.util.ArrayList;
import java.util.List;

/**
* User: ben
* Date: 17/10/2014
* Time: 7:54 PM
*/
public class GroupBuilder {
    private GroupType groupType;
    private Field noOfField;
    private List<FieldsAndGroups> repeats = new ArrayList<>();

    public GroupBuilder withGroupType(final GroupType groupType) {
        this.groupType = groupType;
        return this;
    }

    public GroupBuilder withNoOfField(final Field noOfField){
        this.noOfField = noOfField;
        return this;
    }

    public GroupBuilder withRepeat(final FieldsAndGroups fieldsAndGroups){
        this.repeats.add(fieldsAndGroups);
        return this;
    }

    public Group build(){
        return new BaseGroup(groupType, noOfField, repeats);
    }
}
