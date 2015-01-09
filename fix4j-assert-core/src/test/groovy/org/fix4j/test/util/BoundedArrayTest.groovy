package org.fix4j.test.util

import spock.lang.Specification

/**
 * User: ben
 * Date: 8/12/14
 * Time: 4:56 PM
 */
class BoundedArrayTest extends Specification {
    def "Add"() {
        when:
        BoundedArray<String> array = new BoundedArray<>(3);
        array.add("one");
        array.add("two");
        array.add("three");
        array.add("four");

        then:
        def iterator = array.iterator()
        assert iterator.next() == "two"
        assert iterator.next() == "three"
        assert iterator.next() == "four"

    }

    def "AddAll"() {
        when:
        BoundedArray<String> array = new BoundedArray<>(3);
        array.addAll(["one", "two", "three", "four"].iterator());

        then:
        def iterator = array.iterator()
        assert iterator.next() == "two"
        assert iterator.next() == "three"
        assert iterator.next() == "four"
    }


    def "IsEmpty"() {
        when:
        BoundedArray<String> array = new BoundedArray<>(3);

        then:
        assert array.isEmpty()

        when:
        array.add("one");

        then:
        assert !array.isEmpty()

        when:
        array.add("two");

        then:
        assert !array.isEmpty()

        when:
        array.add("three");

        then:
        assert !array.isEmpty()

        when:
        array.add("four");

        then:
        assert !array.isEmpty()
    }

    def "WasAddedToWhenAtCapacity"() {
        when:
        BoundedArray<String> array = new BoundedArray<>(3);

        then:
        assert !array.wasAddedToWhenAtCapacity()

        when:
        array.add("one");

        then:
        assert !array.wasAddedToWhenAtCapacity()

        when:
        array.add("two");

        then:
        assert !array.wasAddedToWhenAtCapacity()

        when:
        array.add("three");

        then:
        assert !array.wasAddedToWhenAtCapacity()

        when:
        array.add("four");

        then:
        assert array.wasAddedToWhenAtCapacity()
    }
}
