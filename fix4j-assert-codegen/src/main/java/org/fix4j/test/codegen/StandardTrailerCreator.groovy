package org.fix4j.test.codegen
/**
 * User: ben
 * Date: 26/08/2014
 * Time: 5:59 AM
 */
public class StandardTrailerCreator {

    protected static writeStandardTrailerJavaFile(final String packageName, final Collection trailerFields) {
        def file = new File("StandardTrailer.java")
        file.write(createStandardHeaderContent(packageName, trailerFields));
        println "Written StandardTrailer.java to:" + file.absolutePath;
    }

    private static String createStandardHeaderContent(final String packageName, final def fields) {
        final StringBuilder sb = new StringBuilder();
        sb.append("package ${packageName};\n" +
                "\n" +
                "import org.fix4j.test.fixspec.BaseFieldAndGroupTypes;\n" +
                "import org.fix4j.test.fixspec.BaseGroupType;\n" +
                "\n" +
                "public class StandardTrailer extends BaseFieldAndGroupTypes {\n" +
                "    public StandardTrailer(){\n" +
                "        super(\n");
        CompositeContentHelper.buildGroupChildrenForClass(fields, sb, "        ");
        sb.append("        );\n");
        sb.append("    }\n" +
                "}");
        def str = sb.toString();
        return str
    }
}
