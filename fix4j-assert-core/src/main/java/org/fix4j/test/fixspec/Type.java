package org.fix4j.test.fixspec;

/**
 * User: ben
 * Date: 27/08/2014
 * Time: 8:22 PM
 */
public interface Type<T> {
    String getName();
    Tag<T> getTag();
    String toPrettyString();
}
