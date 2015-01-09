package org.fix4j.test.codegen

import groovy.text.GStringTemplateEngine


/**
 * User: ben
 * Date: 26/08/2014
 * Time: 5:59 AM
 */
public class MsgTypesEnumCreator {

    protected static writeMsgTypesEnumFile(final String packageName, final Collection messages) {
        def binding = [packageName: packageName, messages: messages];
        def f = Util.getFileOnClasspath("/templates/MsgTypes.java");
        def engine = new GStringTemplateEngine()
        def template = engine.createTemplate(f).make(binding)

        final String fieldTypeEnumContent = template.toString();
        def fieldClassEnumFile = new File("MsgTypes.java")
        fieldClassEnumFile.write(fieldTypeEnumContent)
        println "Written MsgTypes.java to:" + fieldClassEnumFile.absolutePath;
    }
}
