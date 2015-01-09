package org.fix4j.test.util

import spock.lang.Specification

/**
 * User: ben
 * Date: 25/08/2014
 * Time: 6:15 AM
 */
class StringUtilsTest extends Specification {

    def "test substituteVariables"(){
        expect:
        assert sub('asdf ${blah} asdf', [blah:"hello"]) == 'asdf hello asdf'
        assert sub('asdf ${one}${two}', [one:"hello",two:"there"]) == 'asdf hellothere'
        assert sub('asdf ${one} asdf ${two}', [one:"hello",two:"there"]) == 'asdf hello asdf there'
        assert sub('asdf ${one} asdf \\${two} asdf ${two}', [one:"hello",two:"there"]) == 'asdf hello asdf ${two} asdf there'
        assert sub('asdf ${one}\nasdf ${two}', [one:"hello",two:"there"]) == 'asdf hello\nasdf there'
        assert sub('there are no variables in this string', [blah:"hello"]) == 'there are no variables in this string'
        assert sub('', [blah:"hello"]) == ''

    }

    def "test containsAtLeastOneVariable"(){
        expect:
        assert StringUtils.containsAtLeastOneVariable('asdf ${blah} asdf');
        assert StringUtils.containsAtLeastOneVariable('asdf ${blah} asdf ${blah2}');
        assert !StringUtils.containsAtLeastOneVariable('nothing to see here');
        assert !StringUtils.containsAtLeastOneVariable('');
    }

    def "test substituteVariables variableNotFound"(){
        when:
        sub('asdf ${notfound} asdf', [blah:"hello"]);

        then:
        thrown IllegalArgumentException;
    }

    private static String sub(final String input, final Map<String,String> variables){
        return StringUtils.substituteVariables(input, variables);
    }


    //PAD LEFT WITH SPACES
    def "pad left with spaces, non zero length string"() {
        expect:
        assert StringUtils.padLeft("blah", 0) == "blah";
        assert StringUtils.padLeft("blah", 3) == "blah";
        assert StringUtils.padLeft("blah", 4) == "blah";
        assert StringUtils.padLeft("blah", 5) == " blah";
        assert StringUtils.padLeft("blah", 10) == "      blah";
    }

    def "pad left with spaces, zero length string"() {
        expect:
        assert StringUtils.padLeft("", 0) == "";
        assert StringUtils.padLeft("", 3) == "   ";
    }

    def "pad left with spaces, null string"() {
        when:
        assert StringUtils.padLeft(null, 0);

        then:
        final IllegalArgumentException ex = thrown();
        assert ex.message == "Given string cannot be null";
    }

    //PAD RIGHT WITH SPACES
    def "pad right with spaces, non zero length string"() {
        expect:
        assert StringUtils.padRight("blah", 0) == "blah";
        assert StringUtils.padRight("blah", 3) == "blah";
        assert StringUtils.padRight("blah", 4) == "blah";
        assert StringUtils.padRight("blah", 5) == "blah ";
        assert StringUtils.padRight("blah", 10) == "blah      ";
    }

    def "pad right with spaces, zero length string"() {
        expect:
        assert StringUtils.padRight("", 0) == "";
        assert StringUtils.padRight("", 3) == "   ";
    }

    def "pad right with spaces, null string"() {
        when:
        assert StringUtils.padRight(null, 0);

        then:
        final IllegalArgumentException ex = thrown();
        assert ex.message == "Given string cannot be null";
    }

    //PAD LEFT WITH CHARS
    def "pad left with chars, non zero length string"() {
        expect:
        assert StringUtils.padLeft("blah", ".", 0) == "blah";
        assert StringUtils.padLeft("blah", ".", 3) == "blah";
        assert StringUtils.padLeft("blah", ".", 4) == "blah";
        assert StringUtils.padLeft("blah", ".", 5) == ".blah";
        assert StringUtils.padLeft("blah", ".", 10) == "......blah";
        assert StringUtils.padLeft("blah", ".", 10) == "......blah";
    }

    def "pad left with chars, zero length string"() {
        expect:
        assert StringUtils.padLeft("", ".", 0) == "";
        assert StringUtils.padLeft("", ".", 3) == "...";
    }

    def "pad left with chars, null string"() {
        when:
        assert StringUtils.padLeft(null, ".", 0);

        then:
        final IllegalArgumentException ex = thrown();
        assert ex.message == "Given string cannot be null";
    }

    //PAD RIGHT WITH CHARS
    def "pad right with chars, non zero length string"() {
        expect:
        assert StringUtils.padRight("blah", ".", 0) == "blah";
        assert StringUtils.padRight("blah", ".", 3) == "blah";
        assert StringUtils.padRight("blah", ".", 4) == "blah";
        assert StringUtils.padRight("blah", ".", 5) == "blah.";
        assert StringUtils.padRight("blah", ".", 10) == "blah......";
    }

    def "pad right with chars, zero length string"() {
        expect:
        assert StringUtils.padRight("", ".", 0) == "";
        assert StringUtils.padRight("", ".", 3) == "...";
    }

    def "pad right with chars, zero length pad"() {
        when:
        assert StringUtils.padRight("blah", "", 20);

        then:
        final IllegalArgumentException ex = thrown();
        assert ex.message == "Given pad String must be of length 1";
    }

    def "pad right with chars, null string"() {
        when:
        assert StringUtils.padRight(null, ".", 0);

        then:
        final IllegalArgumentException ex = thrown();
        assert ex.message == "Given string cannot be null";
    }

    def "pad right with chars, pad longer than one character"() {
        when:
        assert StringUtils.padRight("blah", "..", 20);

        then:
        final IllegalArgumentException ex = thrown();
        assert ex.message == "Given pad String must be of length 1";
    }

    def "left, given string is null"() {
        when:
        assert StringUtils.left(null, 1);

        then:
        final IllegalArgumentException ex = thrown();
        assert ex.message == "Given String cannot be null. [n=1]";
    }

    def "left, n is negative"() {
        when:
        assert StringUtils.left("12345", -1);

        then:
        final IllegalArgumentException ex = thrown();
        assert ex.message == "n must be greater than or equal to zero. [n=-1, s=12345]";
    }

    def "left, positive tests"() {
        expect:
        assert StringUtils.left("12345", 3) == "123";
        assert StringUtils.left("12345", 1) == "1";
        assert StringUtils.left("12345", 5) == "12345";
        assert StringUtils.left("12345", 10) == "12345";
        assert StringUtils.left("12345", 0) == "";
        assert StringUtils.left("", 0) == "";
        assert StringUtils.left("", 10) == "";
    }


    def "right, given string is null"() {
        when:
        assert StringUtils.right(null, 1);

        then:
        final IllegalArgumentException ex = thrown();
        assert ex.message == "Given String cannot be null. [n=1]";
    }

    def "right, n is negative"() {
        when:
        assert StringUtils.right("12345", -1);

        then:
        final IllegalArgumentException ex = thrown();
        assert ex.message == "n must be greater than or equal to zero. [n=-1, s=12345]";
    }

    def "right, positive tests"() {
        expect:
        assert StringUtils.right("12345", 3) == "345";
        assert StringUtils.right("12345", 1) == "5";
        assert StringUtils.right("12345", 5) == "12345";
        assert StringUtils.right("12345", 10) == "12345";
        assert StringUtils.right("12345", 0) == "";
        assert StringUtils.right("", 0) == "";
        assert StringUtils.right("", 10) == "";
    }

    def "test repeat"(){
        expect:
        StringUtils.repeat(0, "blah") == "";
        StringUtils.repeat(1, "blah") == "blah";
        StringUtils.repeat(2, "blah") == "blahblah";
        StringUtils.repeat(2, "") == "";
    }


    def "test single indent"() {
        when:
        final String input =
                "to be\n" +
                        "or not to be\n" +
                        "that\n" +
                        "is\n" +
                        "\n" +
                        "the\n" +
                        "question\n";

        then:
        final String expectedOutput =
                "${Consts.INDENT}to be\n" +
                        "${Consts.INDENT}or not to be\n" +
                        "${Consts.INDENT}that\n" +
                        "${Consts.INDENT}is\n" +
                        "\n" +
                        "${Consts.INDENT}the" +
                        "\n${Consts.INDENT}question\n";
        assert StringUtils.indentAllLines(1, input) == expectedOutput;
    }

    def "test double indent"() {
        when:
        final String input =
                "to be\n" +
                        "or not to be\n" +
                        "that\n" +
                        "is\n" +
                        "\n" +
                        "the\n" +
                        "question\n";

        then:
        final String expectedOutput =
                "${Consts.DOUBLE_INDENT}to be\n" +
                        "${Consts.DOUBLE_INDENT}or not to be\n" +
                        "${Consts.DOUBLE_INDENT}that\n" +
                        "${Consts.DOUBLE_INDENT}is\n" +
                        "\n" +
                        "${Consts.DOUBLE_INDENT}the" +
                        "\n${Consts.DOUBLE_INDENT}question\n";

        assert StringUtils.indentAllLines(2, input) == expectedOutput;
    }

    def "test zero indent"() {
        when:
        final String input =
                "to be\n" +
                        "or not to be\n" +
                        "that\n" +
                        "is\n" +
                        "\n" +
                        "the\n" +
                        "question\n";

        then:
        assert StringUtils.indentAllLines(0, input) == input;
    }

    def "test indent with special indent on the first line"() {
        when:
        final String input =
                "to be\n" +
                        "or not to be\n" +
                        "that\n" +
                        "is\n" +
                        "\n" +
                        "the\n" +
                        "question\n";

        then:
        final String expectedOutput =
                "   >to be\n" +           //<----Note this special indent is ending in the '>' char
                        "    or not to be\n" +
                        "    that\n" +
                        "    is\n" +
                        "\n" +
                        "    the\n" +
                        "    question\n";

        assert StringUtils.indentAllLinesWithFirstLinesIndentEndingIn(">", input) == expectedOutput;
    }

    def "test indent with special indent on the first line, zero length special indent given"() {
        when:
        final String input =
                "to be\n" +
                        "or not to be\n" +
                        "that\n" +
                        "is\n" +
                        "\n" +
                        "the\n" +
                        "question\n";

        then:
        final String expectedOutput =
                "    to be\n" +           //<----Note there is no special indent, as we have passed a zero length string as the special indent
                        "    or not to be\n" +
                        "    that\n" +
                        "    is\n" +
                        "\n" +
                        "    the\n" +
                        "    question\n";

        assert StringUtils.indentAllLinesWithFirstLinesIndentEndingIn("", input) == expectedOutput;
    }


    def "test indent with special indent on the first line, single line"() {
        when:
        final String input = "to be or not to be";

        then:
        final String expectedOutput = "   >to be or not to be";

        assert StringUtils.indentAllLinesWithFirstLinesIndentEndingIn(">", input) == expectedOutput;
    }

    def "test indent with special indent on the first line, zero length string"() {
        when:
        final String input = "";

        then:
        final String expectedOutput = "";

        assert StringUtils.indentAllLinesWithFirstLinesIndentEndingIn(">", input) == expectedOutput;
    }

    def "test GetIndentEndingIn 1"() {
        expect:
        assert StringUtils.getIndentEndingIn(">").equals('   >');
        assert StringUtils.getIndentEndingIn(">").length() == Consts.INDENT.length();
    }

    def "test GetIndentEndingIn 2"() {
        expect:
        assert StringUtils.getIndentEndingIn("blah").equals('blah');
        assert StringUtils.getIndentEndingIn(">").length() == Consts.INDENT.length();
    }

    def "test GetIndentEndingIn 3"() {
        expect:
        assert StringUtils.getIndentEndingIn("").equals(Consts.INDENT);
        assert StringUtils.getIndentEndingIn("").length() == Consts.INDENT.length();
    }

    def "test parseMap"() {
        when:
        final Map<String, String> properties = StringUtils.parseMap("keyone:one,keytwo:two,keythree:three");

        then:
        assert properties == [keyone:"one", keytwo:"two", keythree:"three"];
    }

    def "test parseMap with spaces"() {
        when:
        final Map<String, String> properties = StringUtils.parseMap("keyone:one, keytwo:two, keythree:three");

        then:
        assert properties == [keyone:"one", keytwo:"two", keythree:"three"];
    }

    def "test parseMap single property"() {
        when:
        final Map<String, String> properties = StringUtils.parseMap("keyone:one");

        then:
        assert properties == [keyone:"one"];
    }

    def "test listToMap"() {
        when:
        final Map<String, String> properties = StringUtils.listToMap("keyone", "one", "keytwo", "two", "keythree", "three");

        then:
        assert properties == [keyone:"one", keytwo:"two", keythree:"three"];
    }
}
