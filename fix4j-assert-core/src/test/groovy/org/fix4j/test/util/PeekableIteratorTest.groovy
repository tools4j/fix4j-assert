package org.fix4j.test.util

import spock.lang.Specification

/**
 * User: ben
 * Date: 3/09/2014
 * Time: 6:53 PM
 */
class PeekableIteratorTest extends Specification {
    def "simple test"() {
        expect:
        final PeekableIterator<String> i = new PeekableIterator<>(["one", "two", "three"]);
        assert i.hasNext();
        assert i.peek() == "one";
        assert i.peek() == "one";
        assert i.peek() == "one";
        assert i.hasNext();
        assert i.next() == "one";
        assert i.hasNext();
        assert i.next() == "two";
        assert i.hasNext();
        assert i.peek() == "three";
        assert i.hasNext();
        assert i.peek() == "three";
        assert i.hasNext();
        assert i.next() == "three";
        assert !i.hasNext();
    }

    def "test remove"() {
        expect:
        final PeekableIterator<String> i = new PeekableIterator<>(["one", "two", "three"]);
        assert i.hasNext();
        assert i.peek() == "one";
        assert i.peek() == "one";
        assert i.peek() == "one";
        assert i.hasNext();
        i.remove();
        assert i.hasNext();
        assert i.next() == "two";
        assert i.hasNext();
        assert i.peek() == "three";
        assert i.hasNext();
        i.remove();
        assert !i.hasNext();
    }

    def "test next when started full but end up empty"() {
        when:
        final PeekableIterator<String> i = new PeekableIterator<>(["one", "two", "three"]);
        assert i.next() == "one";
        assert i.next() == "two";
        assert i.next() == "three";
        i.next();

        then:
        thrown(NoSuchElementException);
    }

    def "test next when started empty"() {
        when:
        final PeekableIterator<String> i = new PeekableIterator<>([]);
        i.next();

        then:
        thrown(NoSuchElementException);
    }

    def "test peek when started full but end up empty"() {
        when:
        final PeekableIterator<String> i = new PeekableIterator<>(["one", "two", "three"]);
        assert i.next() == "one";
        assert i.next() == "two";
        assert i.next() == "three";
        i.peek();

        then:
        thrown(NoSuchElementException);
    }

    def "test peek when started empty"() {
        when:
        final PeekableIterator<String> i = new PeekableIterator<>([]);
        i.peek();

        then:
        thrown(NoSuchElementException);
    }
}
