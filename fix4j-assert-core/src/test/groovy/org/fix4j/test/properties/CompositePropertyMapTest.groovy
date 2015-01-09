package org.fix4j.test.properties

import spock.lang.Specification

/**
 * User: ben
 * Date: 4/12/14
 * Time: 10:25 AM
 */
class CompositePropertyMapTest extends Specification {
    private PropertySource source1 = new MapPropertySource([one: "blah1", two: "blah2"], "firstSource");
    private PropertySource source2 = new MapPropertySource([one: "dog1", three: "dog3"], "secondSource");
    private PropertySource source3 = new MapPropertySource([one: "cat1", three: "cat3", four: "cat4"], "thirdSource");
    private PropertySource withTypes = new MapPropertySource([aString: "blah", anInt: "1234", aLong: "12345", aBoolean: "true", aDouble: "0.1234"], "thirdSource");

    def "test toString"(){
        given:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite")
                .addLast(source1).addLast(source2).addLast(source3).build();

        expect:
        assert map.toString().contains(
                "    one=blah1 [firstSource]\n" +
                "    two=blah2 [firstSource]\n" +
                "    three=dog3 [secondSource]\n" +
                "    four=cat4 [thirdSource]\n");
    }

    def "test Composite behaviour"() {
        when:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite")
                .addLast(source1).addLast(source2).addLast(source3).build();

        then:
        assert map.getAsString("one") == "blah1";
        assert map.getAsString("two") == "blah2";
        assert map.getAsString("three") == "dog3";
        assert map.getAsString("four") == "cat4";
    }

    def "get using typed methods"() {
        when:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite")
                .addLast(withTypes).build();

        then:
        assert map.getAsString("aString") == "blah";
        assert map.getAsInt("anInt") == 1234;
        assert map.getAsLong("aLong") == 12345L;
        assert map.getAsDouble("aDouble") == 0.1234;
        assert map.getAsBoolean("aBoolean") == true;
    }

    def "GetAsInt failure"() {
        given:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite").addLast(source1).build();

        when:
        map.getAsInt("one");

        then:
        thrown IllegalArgumentException;

    }

    def "GetAsDouble failure"() {
        given:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite").addLast(source1).build();

        when:
        map.getAsDouble("one");

        then:
        thrown IllegalArgumentException;
    }

    def "GetAsLong failure"() {
        given:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite").addLast(source1).build();

        when:
        map.getAsLong("one");

        then:
        thrown IllegalArgumentException;
    }

    def "GetAsBoolean failure"() {
        given:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite").addLast(source1).build();

        when:
        map.getAsBoolean("one");

        then:
        thrown IllegalArgumentException;
    }

    def "GetAsInt null"() {
        given:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite").addLast(source1).build();

        expect:
        assert map.getAsInt("doesNotExist") == null;
    }

    def "GetAsDouble null"() {
        given:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite").addLast(source1).build();

        expect:
        assert map.getAsDouble("doesNotExist") == null;
    }

    def "GetAsLong null"() {
        given:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite").addLast(source1).build();

        expect:
        assert map.getAsLong("doesNotExist") == null;
    }

    def "GetAsBoolean null"() {
        given:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite").addLast(source1).build();

        expect:
        assert map.getAsBoolean("doesNotExist") == null;
    }

    def "GetAsString null"() {
        given:
        final CompositePropertyMap map = CompositePropertyMap.Builder.create("composite").addLast(source1).build();

        expect:
        assert map.getAsString("doesNotExist") == null;
    }
}
