package org.fix4j.test.codegen
/**
 * User: ben
 * Date: 26/08/2014
 * Time: 5:59 AM
 */
public class StandardHeaderCreator {

    protected static writeStandardHeaderJavaFile(final String packageName, final Collection headerFields) {
        def file = new File("StandardHeader.java")
        file.write(createStandardHeaderContent(packageName, headerFields));
        println "Written StandardHeader.java to:" + file.absolutePath;
    }

    private static String createStandardHeaderContent(final String packageName, final def fields) {
        final StringBuilder sb = new StringBuilder();
        sb.append("package ${packageName};\n" +
                "\n" +
                "import org.fix4j.test.fixspec.BaseFieldAndGroupTypes;\n" +
                "import org.fix4j.test.fixspec.BaseGroupType;\n" +
                "\n" +
                "public class StandardHeader extends BaseFieldAndGroupTypes {\n" +
                "    public StandardHeader(){\n" +
                "        super(\n");
        CompositeContentHelper.buildGroupChildrenForClass(fields, sb, "        ");
        sb.append("        );\n");
        sb.append("    }\n" +
                "}");
        def str = sb.toString();
        return str
    }
}
