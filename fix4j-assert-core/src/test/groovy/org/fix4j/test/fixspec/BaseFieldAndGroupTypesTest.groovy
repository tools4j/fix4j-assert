package org.fix4j.test.fixspec

import spock.lang.Specification

/**
 * User: ben
 * Date: 16/01/15
 * Time: 6:30 AM
 */
class BaseFieldAndGroupTypesTest extends Specification {
    def "ToPrettyString"() {
        expect:
        ExampleTypes.fieldAndGroupTypes1.toPrettyString() ==
                "[fieldTypeGroup1Field1]4\n" +
                "[fieldTypeGroup1Field2]5\n" +
                "[fieldTypeNoOfGroup2]6\n" +
                "    [fieldTypeGroup2Field1]7\n" +
                "    [fieldTypeGroup2Field2]8\n";
    }
}
