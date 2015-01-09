package org.fix4j.test.properties

import spock.lang.Specification

/**
 * User: ben
 * Date: 17/12/14
 * Time: 11:23 PM
 */
class SystemEnvVariablePropertySourceTest extends Specification {
    def "test GetAndFormatRelevantEnvironmentVariables"() {
        given:
        def map = [FIX4J_BLAH_ONE: "blah", FIX4J_BLAH_TWO: "blah2", FIX4J__three: "blah", FIX_BLAH: "asdf" ];

        when:
        def processed = (new SystemEnvVariablePropertySource()).getAndFormatRelevantEnvironmentVariables(map);

        then:
        assert processed == ["fix4j.blah.one": "blah", "fix4j.blah.two": "blah2", "fix4j..three": "blah" ];
    }
}
