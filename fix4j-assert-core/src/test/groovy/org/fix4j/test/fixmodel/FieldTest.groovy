package org.fix4j.test.fixmodel

import spock.lang.Specification

/**
 * User: ben
 * Date: 9/12/14
 * Time: 5:32 PM
 */
class FieldTest extends Specification {

    def "test matchesValueOf"(){
        expect:
        assert matches("blah", "blah");
        assert !matches("\\w+", "asdfasdf");
        assert matches("", "");
        assert matches(null, "");
        assert matches("", null);
        assert matches(null, null);
        assert !matches("asdf", null);
        assert !matches(null, "asdf");
    }

    boolean matches(final String expected, final String actual) {
        final Field expectedField = new Field(null, expected);
        final Field actualField = new Field(null, actual);
        return expectedField.matchesValueOf(actualField);
    }
}
