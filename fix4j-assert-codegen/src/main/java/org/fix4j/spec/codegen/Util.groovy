package org.fix4j.spec.codegen

/**
 * User: ben
 * Date: 5/09/2014
 * Time: 5:39 AM
 */
class Util {
    private Util() {}

    public static File getFileOnClasspath(String specLocationOnClasspath) {
        final URL resource = SpecParser.class.getResource(specLocationOnClasspath);
        final File fixSpec = new File(resource.getFile());
        return fixSpec
    }

}
