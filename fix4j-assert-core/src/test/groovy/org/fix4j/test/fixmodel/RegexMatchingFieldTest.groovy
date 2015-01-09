package org.fix4j.test.fixmodel

import spock.lang.Specification

/**
 * User: ben
 * Date: 22/12/14
 * Time: 9:13 AM
 */
class RegexMatchingFieldTest extends Specification {
    def "test UnescapeRegexForwardSlashes"() {
        expect:
        assert RegexMatchingField.unescapeRegexForwardSlashes("\\/asdf\\/") == "/asdf/";
        assert RegexMatchingField.unescapeRegexForwardSlashes("\\/\\/") == "//";
        assert RegexMatchingField.unescapeRegexForwardSlashes("\\/.*\\/") == "/.*/";
        assert RegexMatchingField.unescapeRegexForwardSlashes("asdf\\/asdf\\/") == "asdf\\/asdf\\/";
        assert RegexMatchingField.unescapeRegexForwardSlashes("\\/asdf\\/asdf") == "\\/asdf\\/asdf";
    }

    def "test ContainsRegexForwardSlashes"() {
        expect:
        assert RegexMatchingField.containsRegexForwardSlashes("/asdf/");
        assert RegexMatchingField.containsRegexForwardSlashes("//");
        assert !RegexMatchingField.containsRegexForwardSlashes("asdf/asdf/");
        assert !RegexMatchingField.containsRegexForwardSlashes("/asdf");
        assert !RegexMatchingField.containsRegexForwardSlashes("asdf/");
        assert !RegexMatchingField.containsRegexForwardSlashes("");
        assert !RegexMatchingField.containsRegexForwardSlashes(null);
    }

    def "test ContainsEscapedRegexForwardSlashes"() {
        expect:
        assert RegexMatchingField.containsEscapedRegexForwardSlashes("\\/asdf\\/");
        assert RegexMatchingField.containsEscapedRegexForwardSlashes("\\/\\/");
        assert !RegexMatchingField.containsEscapedRegexForwardSlashes("asdf\\/asdf\\/");
        assert !RegexMatchingField.containsEscapedRegexForwardSlashes("\\/asdf");
        assert !RegexMatchingField.containsEscapedRegexForwardSlashes("asdf\\/");
        assert !RegexMatchingField.containsEscapedRegexForwardSlashes("");
        assert !RegexMatchingField.containsEscapedRegexForwardSlashes(null);
    }

    def "test MatchesValueOf"() {
        expect:
        assert matches("/.*/", "asdf");
        assert matches("/.*/", "");
        assert !matches("/.+/", "");
        assert !matches("/.*/", null);
        assert matches("/\\w+/", "asdf");
    }


    def "test exception when creating a RegexMatchingField which does not contain forward slashes"() {
        when:
        new RegexMatchingField(null, "asdf");

        then:
        thrown IllegalArgumentException;
    }

    def matches(final String regexExpected, final String actual) {
        final Field expectedField = new RegexMatchingField(null, regexExpected);
        final Field actualField = new Field(null, actual);
        return expectedField.matchesValueOf(actualField);
    }
}
