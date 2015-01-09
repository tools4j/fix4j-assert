package $packageName;

import ${packageName}.fieldtype.*;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.Tag;
import org.fix4j.test.fixspec.FieldType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class FieldTypes{
    private static final Map<Integer, FieldType> fieldTypesByTagInt = new LinkedHashMap<>();
    private static final Map<String, FieldType> fieldTypesByName = new LinkedHashMap<>();
<%

def it = fields.iterator();
while(it.hasNext()){
    def field = it.next();
    %>    public static final ${field.name} ${field.name} = register(${packageName}.fieldtype.${field.name}.INSTANCE);
<%}%>

    private static <T extends FieldType> T register(final T fieldType) {
        fieldTypesByTagInt.put(fieldType.getTag().getValue(), fieldType);
        fieldTypesByName.put(fieldType.getName(), fieldType);
        return fieldType;
    }

    //Private, as this sucker should not be instantiated
    private FieldTypes(){}

    public static FieldType getFieldTypeByTag(final Tag<Integer> tag) {
        return fieldTypesByTagInt.get(tag.getValue());
    }

    public static FieldType getFieldTypeByName(final String name) {
        return fieldTypesByName.get(name);
    }

    public static FieldType getFieldTypeByTag(final int tag) {
        return fieldTypesByTagInt.get(tag);
    }

    public static FieldType forCustomTag(final int customTag){
        return FieldType.Factory.forCustomTag(customTag);
    }
}
