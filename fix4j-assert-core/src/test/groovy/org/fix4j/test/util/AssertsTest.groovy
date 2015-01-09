package org.fix4j.test.util

import spock.lang.Specification

/**
 * User: ben
 * Date: 8/12/14
 * Time: 4:37 PM
 */
class AssertsTest extends Specification {
    def "AssertTrue"() {
        when:
        Asserts.assertTrue(true);

        then:
        notThrown(IllegalArgumentException);
    }

    def "AssertTrue fail"() {
        when:
        Asserts.assertTrue(false);

        then:
        thrown(IllegalArgumentException);
    }

    def "AssertFalse"() {
        when:
        Asserts.assertFalse(false);

        then:
        notThrown(IllegalArgumentException);
    }

    def "AssertFalse fail"() {
        when:
        Asserts.assertFalse(true);

        then:
        thrown(IllegalArgumentException);
    }

    def "AssertNull"() {
        when:
        Asserts.assertNull(null);

        then:
        notThrown(IllegalArgumentException);
    }

    def "AssertNull fail"() {
        when:
        Asserts.assertNull("blah");

        then:
        thrown(IllegalArgumentException);
    }

    def "AssertNotNull"() {
        when:
        Asserts.assertNotNull("blah");

        then:
        notThrown(IllegalArgumentException);
    }

    def "AssertNotNull fail"() {
        when:
        Asserts.assertNotNull(null);

        then:
        thrown(IllegalArgumentException);
    }

    def "AssertTrue withMessage"() {
        when:
        Asserts.assertTrue("myMessage", true);

        then:
        notThrown(IllegalArgumentException);
    }

    def "AssertTrue withMessage fail"() {
        when:
        Asserts.assertTrue("myMessage", false);

        then:
        def e = thrown(IllegalArgumentException);
        assert e.message == "myMessage"
    }

    def "AssertFalse withMessage"() {
        when:
        Asserts.assertFalse("myMessage", false);

        then:
        notThrown(IllegalArgumentException);
    }

    def "AssertFalse withMessage fail"() {
        when:
        Asserts.assertFalse("myMessage", true);

        then:
        def e = thrown(IllegalArgumentException);
        assert e.message == "myMessage"
    }

    def "AssertNull withMessage"() {
        when:
        Asserts.assertNull("myMessage", null);

        then:
        notThrown(IllegalArgumentException);
    }

    def "AssertNull withMessage fail"() {
        when:
        Asserts.assertNull("myMessage", "blah");

        then:
        def e = thrown(IllegalArgumentException);
        assert e.message == "myMessage"
    }

    def "AssertNotNull withMessage"() {
        when:
        Asserts.assertNotNull("myMessage", "blah");

        then:
        notThrown(IllegalArgumentException);
    }

    def "AssertNotNull withMessage fail"() {
        when:
        Asserts.assertNotNull("myMessage", null);

        then:
        def e = thrown(IllegalArgumentException);
        assert e.message == "myMessage"
    }

    def "AssertEquals"() {
        when:
        Asserts.assertEquals("blah", "blah");
        Asserts.assertEquals(new String("blah"), new String("blah"));

        then:
        notThrown(IllegalArgumentException);
    }

    def "AssertEquals fail"() {
        when:
        Asserts.assertEquals("asdf", "qwerty");

        then:
        thrown(IllegalArgumentException);
    }

    def "AssertEquals withMessage"() {
        when:
        Asserts.assertEquals("myMessage", new String("blah"), new String("blah"));

        then:
        notThrown(IllegalArgumentException);
    }

    def "AssertEquals withMessage fail"() {
        when:
        Asserts.assertEquals("myMessage", "asdf", "qwer");

        then:
        def e = thrown(IllegalArgumentException);
        assert e.message.contains("myMessage");
    }
}
