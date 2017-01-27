package org.fix4j.spec.codegen

import groovy.text.GStringTemplateEngine

/**
 * User: ben
 * Date: 26/08/2014
 * Time: 5:59 AM
 */
public class FixSpecificationClassCreator {

    protected static writeFixSpecificationFile(final String packageName) {
        def binding = [packageName: packageName];
        final InputStream inputStream = Util.getFileOnClasspath("/templates/FixSpec.java");
        def engine = new GStringTemplateEngine()
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        def template = engine.createTemplate(reader).make(binding)

        final String fileContent = template.toString();
        def file = new File("FixSpec.java")
        file.write(fileContent)
        println "Written FixSpec.java to:" + file.absolutePath;
    }
}
