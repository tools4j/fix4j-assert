package org.fix4j.spec.codegen
/**
 * User: ben
 * Date: 26/08/2014
 * Time: 5:59 AM
 */
public class MsgTypeCreator {

    public static void writeMsgTypesJavaFiles(final String packageName, final LinkedHashMap messages) {
        def it = messages.values().iterator();
        while(it.hasNext()){
            def message = it.next();
            final File parentDir = new File("msgtype");
            if(!parentDir.exists()) parentDir.mkdir();
            final File file = new File("msgtype/" + message.name + ".java");
            file.write(createMsgTypeClassContent(packageName, message));
        }
    }

    private static String createMsgTypeClassContent(final String packageName, final def message) {
        final StringBuilder sb = new StringBuilder();
        sb.append("package ${packageName}.msgtype;\n" +
                "\n" +
                "import org.fix4j.test.fixspec.BaseGroupType;\n" +
                "import org.fix4j.test.fixspec.BaseMsgType;\n" +
                "import ${packageName}.FieldTypes;\n" +
                "\n" +
                "public class ${message.name} extends BaseMsgType{\n" +
                "    public static final ${message.name} INSTANCE = new ${message.name}();\n\n" +
                "    private ${message.name}() {\n" +
                "        super(\n" +
                "            \"${message.name}\",\n" +
                "            \"${message.msgType}\",\n" +
                "            \"${message.msgcat}\",\n");

        CompositeContentHelper.buildGroupChildrenForClass(message.children.values(), sb, "        ");
        sb.append("        );\n" +
                "    }\n" +
                "}\n");
        def str = sb.toString()
        return str
    }
}
