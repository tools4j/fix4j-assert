package org.fix4j.test.codegen
/**
 * User: ben
 * Date: 26/08/2014
 * Time: 5:59 AM
 */
public class SpecParser {
    private final static Map FIELD_CLASS_ALIASES = [MULTIPLEVALUESTRING: "MULTIPLESTRINGVALUE"];

    public static void main(String[] args) throws Exception {
        final String specLocationOnClasspath = args[0];
        final String packageName = args[1];

        Asserts.assertTrue("${args.length} parameters specified, 2 required.  Usage: SpecParser <specLocationOnPath> <packageName>\n" +
                "e.g. SpecParser /specifications/FIX44.xml org.fix4j.test.fixspecimpl44 (Note: files will be written to the current working" +
                " directory", args.length == 2);

        File fixSpec = Util.getFileOnClasspath(specLocationOnClasspath);
        Asserts.assertNotNull(fixSpec);
        Asserts.assertTrue(fixSpec.exists());
        Asserts.assertNotNull(packageName);

        (new SpecParser()).parseSpec(fixSpec, packageName);
    }

    public void parseSpec(final File spec, final String packageName) throws Exception {
        final Node xmlRoot = new XmlParser().parseText(spec.getText());

        Node fieldsNode = xmlRoot["fields"][0];
        def (LinkedHashMap fields, Set fieldClasses) = parseFields(fieldsNode)
        final LinkedHashMap messages = parseMessages(xmlRoot["messages"][0]);
        final LinkedHashMap components = getChildrenComponentsGroupsAndFields((Node) xmlRoot["components"][0]);
        final LinkedHashMap headerFields = getChildrenComponentsGroupsAndFields((Node) xmlRoot["header"][0]);
        final LinkedHashMap trailerFields = getChildrenComponentsGroupsAndFields((Node) xmlRoot["trailer"][0]);

        final LinkedHashMap messagesWithComponentsExpanded = messages = substituteComponentsInEntities(messages, components);
        final LinkedHashMap headerFieldsWithComponentsExpanded = substituteComponentsInEntities(headerFields, components);
        final LinkedHashMap trailerFieldsWithComponentsExpanded = substituteComponentsInEntities(trailerFields, components);

        FieldTypeCreator.writeFieldTypesJavaFiles(packageName, fields);
        MsgTypeCreator.writeMsgTypesJavaFiles(packageName, messagesWithComponentsExpanded);
        FieldTypesEnumCreator.writeFieldTypesEnumFile(packageName, fields.values());
        MsgTypesEnumCreator.writeMsgTypesEnumFile(packageName, messagesWithComponentsExpanded.values());
        FixSpecificationClassCreator.writeFixSpecificationFile(packageName);

        StandardHeaderCreator.writeStandardHeaderJavaFile(packageName, headerFieldsWithComponentsExpanded.values());
        StandardTrailerCreator.writeStandardTrailerJavaFile(packageName, trailerFieldsWithComponentsExpanded.values());
    }

    protected List parseFields(Node fieldsNode) {
        final LinkedHashMap fields = new LinkedHashMap();
        final Set fieldClasses = new HashSet();
        fieldsNode.each() { final Node fieldNode ->
            String fieldClass = fieldNode["@type"];
            if(FIELD_CLASS_ALIASES.containsKey(fieldClass)){
                fieldClass = FIELD_CLASS_ALIASES.get(fieldClass);
            }

            final def field = [type: "field", number: fieldNode["@number"], fieldClass: fieldClass, name: fieldNode["@name"]];
            field.enumValues = new ArrayList();
            fields.put(field.name, field);
            fieldClasses.add(fieldNode["@type"]);

            fieldNode.each() { final Node enumNode ->
                final def fieldEnum = [ordinal: enumNode["@enum"], description: enumNode["@description"]];
                field.enumValues.add(fieldEnum);
            }
        }
        return [fields, fieldClasses]
    }

    protected LinkedHashMap parseMessages(Node messagesNode) {
        final LinkedHashMap messages = new LinkedHashMap();
        messagesNode.each() { final Node messageNode ->
            final def message = [type: "message", name: messageNode["@name"], msgType: messageNode["@msgtype"], msgcat: messageNode["@msgcat"]];
            message.children = getChildrenComponentsGroupsAndFields(messageNode);
            messages.put(message.name, message);
        }
        return messages
    }

    LinkedHashMap substituteComponentsInEntities(final LinkedHashMap oldEntities, final LinkedHashMap components) {
        final LinkedHashMap newEntities = new LinkedHashMap();
        oldEntities.values().each() { def entity ->
            if (entity.type == "component") {
                final String componentName = entity.name;
                final def component = components.get(componentName);
                Asserts.assertNotNull(component);
                final LinkedHashMap newComponentChildren = substituteComponentsInEntities(component.children, components);
                newEntities.putAll(newComponentChildren);
            } else {
                if(entity.children != null){
                    entity.children = substituteComponentsInEntities(entity.children, components);
                }
                newEntities.put(entity.name, entity);
            }
        }
        return newEntities;
    }

    private LinkedHashMap getChildrenComponentsGroupsAndFields(final Node node) {
        final LinkedHashMap childComponents = new LinkedHashMap();
        node.each() { final Node childNode ->
            LinkedHashMap<String, Object> child = [type: childNode.name(), name: childNode["@name"], required: childNode["@required"]]
            childComponents.put(child.name, child);
            child.children = getChildrenComponentsGroupsAndFields(childNode)
        }
        return childComponents;
    }
}
