package org.fix4j.spec.codegen

import groovy.text.GStringTemplateEngine


/**
 * User: ben
 * Date: 26/08/2014
 * Time: 5:59 AM
 */
public class MsgTypesEnumCreator {

    protected static writeMsgTypesEnumFile(final String packageName, final Collection messages) {
        def binding = [packageName: packageName, messages: messages];
        final InputStream inputStream = Util.getFileOnClasspath("/templates/MsgTypes.java");
        def engine = new GStringTemplateEngine()
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        def template = engine.createTemplate(reader).make(binding)

        final String fieldTypeEnumContent = template.toString();
        def fieldClassEnumFile = new File("MsgTypes.java")
        fieldClassEnumFile.write(fieldTypeEnumContent)
        println "Written MsgTypes.java to:" + fieldClassEnumFile.absolutePath;
    }
}
