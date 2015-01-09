package org.fix4j.test.util

import spock.lang.Specification

/**
 * User: ben
 * Date: 23/09/2014
 * Time: 5:36 AM
 */
class ArrayListMultimapTest extends Specification {
    def "Get"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");
        map.put("Hi", "Mr");

        final List<String> list = map.get("Hi");

        then:
        assert list != null;
        assert list.size() == 2;
        assert list.get(0) == "There";
        assert list.get(1) == "Mr";
    }

    def "Get returns unmodifiable list"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        final List<String> list = map.get("Hi");
        list.add("Test")

        then:
        thrown UnsupportedOperationException.class
    }

    def "GetExpectingOne"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");

        then:
        assert map.getExpectingOne("Hi") == "There"
    }

    def "GetExpectingOne, zero entries"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");
        map.getExpectingOne("Blah")

        then:
        thrown IllegalStateException.class
    }

    def "GetExpectingOne, more than one entry"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");
        map.put("Hi", "Mr");
        map.getExpectingOne("Hi")

        then:
        thrown IllegalStateException.class
    }

    def "GetFirst"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");
        map.put("Hi", "Mr");

        then:
        assert map.getFirst("Hi") == "There"
    }

    def "GetFirst, no entries for key"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");
        map.put("Hi", "Mr");
        map.getFirst("Blah")

        then:
        thrown IllegalStateException.class
    }

    def "Put, null value as second value"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");
        map.put("Hi", null);

        then:
        thrown IllegalArgumentException.class
    }

    def "Put, null value as first value"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Blah", "One");
        map.put("Hi", null);

        then:
        thrown IllegalArgumentException.class
    }

    def "ContainsAtLeastOneValueFor, no values"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();

        then:
        assert ! map.containsAtLeastOneValueFor("Hi");
        assert ! map.containsKey("Hi");
    }

    def "ContainsAtLeastOneValueFor, one value"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");

        then:
        assert map.containsAtLeastOneValueFor("Hi");
        assert map.containsKey("Hi");
    }

    def "ContainsAtLeastOneValueFor, two values"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");
        map.put("Hi", "Mr");

        then:
        assert map.containsAtLeastOneValueFor("Hi");
        assert map.containsKey("Hi");
    }

    def "getAllValues, no values"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();

        then:
        assert map.allValues().isEmpty();
    }

    def "getAllValues, one value"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");

        then:
        assert map.allValues() == ["There"]
    }

    def "getAllValues, two values"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");
        map.put("Hi", "Mr");

        then:
        assert map.allValues() == ["There", "Mr"]

    }

    def "getAllValues, three values"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");
        map.put("Hi", "Mr");
        map.put("Buddy", "Mate");

        then:
        assert map.allValues() == ["There", "Mr", "Mate"]
    }

    def "values(), three values"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();
        map.put("Hi", "There");
        map.put("Hi", "Mr");
        map.put("Buddy", "Mate");

        then:
        def valuesIterator = map.values()
        assert valuesIterator.next() == "There";
        assert valuesIterator.next() == "Mr";
        assert valuesIterator.next() == "Mate";
        assert !valuesIterator.hasNext();
    }

    def "values(), no values"() {
        when:
        final Multimap<String, String> map = new ArrayListMultimap<>();

        then:
        def valuesIterator = map.values()
        assert !valuesIterator.hasNext();
    }
}
