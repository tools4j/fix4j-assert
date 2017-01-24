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
        def f = Util.getFileOnClasspath("/templates/FieldTypes.java");
        def engine = new GStringTemplateEngine()
        def template = engine.createTemplate(f).make(binding)

        final String fieldTypeEnumContent = template.toString();
        def fieldClassEnumFile = new File("FieldTypes.java")
        fieldClassEnumFile.write(fieldTypeEnumContent)
        println "Written FieldTypes.java to:" + fieldClassEnumFile.absolutePath;
    }
}
