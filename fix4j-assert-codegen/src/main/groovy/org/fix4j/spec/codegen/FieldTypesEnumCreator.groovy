package org.fix4j.spec.codegen

import groovy.text.GStringTemplateEngine

/**
 * User: ben
 * Date: 26/08/2014
 * Time: 5:59 AM
 */
public class FieldTypesEnumCreator {

    protected static writeFieldTypesEnumFile(final String packageName, final Collection fields) {
        def binding = [packageName: packageName, fields: fields];
        final InputStream inputStream = Util.getFileOnClasspath("/templates/FieldTypes.java");
        def engine = new GStringTemplateEngine()
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        def template = engine.createTemplate(reader).make(binding)

        final String fieldTypeEnumContent = template.toString();
        def packagePath = packageName.replace('.', File.separator)
        def outputDir = new File("src/generated/java/${packagePath}")
        if (!outputDir.exists()) outputDir.mkdirs()
        def fieldClassEnumFile = new File(outputDir, "FieldTypes.java")
        fieldClassEnumFile.write(fieldTypeEnumContent)
        println "Written FieldTypes.java to:" + fieldClassEnumFile.absolutePath;
    }
}
