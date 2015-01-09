package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.util.ArrayListMultimap;
import org.fix4j.test.util.Multimap;

import java.util.Collection;

/**
 * User: ben
 * Date: 23/09/2014
 * Time: 5:49 AM
 */
public class FixMessageUnflattener {
    private FixMessageUnflattener() {}

    public static Multimap<FieldType, String> unflatten(final Collection<Field> fields){
        final Multimap<FieldType, String> map = new ArrayListMultimap<FieldType, String>();
        for(final Field field: fields){
            map.put(field.getFieldType(), field.getValue());
        }
        return map;
    }
}
