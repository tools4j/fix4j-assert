package org.fix4j.test.codegen;

import java.io.File;
import java.util.Collection;

/**
 * User: ben
 * Date: 5/09/2014
 * Time: 5:46 AM
 */
public class FieldClassEnumCreator {
    protected static void writeFieldClassEnumJavaFile(final String packageName, final Collection fieldClasses) {
        final String fieldClassEnumContent = createFieldClassEnum(packageName, fieldClasses);
        def fieldClassEnumFile = new File("FieldClass.java")
        fieldClassEnumFile.write(fieldClassEnumContent)
        println "Written FieldClass.java to:" + fieldClassEnumFile.absolutePath;
    }

    private static String createFieldClassEnum(final String packageName, final Collection fieldClasses){
        final StringBuilder sb = new StringBuilder();
        sb.append("package $packageName;\n" +
                "\n" +
                "\n" +
                "public enum FieldClass {\n");

        def it = fieldClasses.iterator();
        while(it.hasNext()){
            def fieldClass = it.next();
            sb.append("    ${fieldClass}");
            if(it.hasNext()) sb.append(",\n");
            else sb.append(";\n")
        }

        sb.append("}");
        return sb.toString();
    }
}
