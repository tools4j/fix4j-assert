package org.fix4j.spec.codegen

/**
 * User: ben
 * Date: 5/09/2014
 * Time: 5:39 AM
 */
class Util {
    private Util() {}

    public static InputStream getFileOnClasspath(String fileLocationOnClasspath) {
        return SpecParser.class.getResourceAsStream(fileLocationOnClasspath);
    }
}
