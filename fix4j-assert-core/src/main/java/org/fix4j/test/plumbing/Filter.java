package org.fix4j.test.plumbing;

/**
 * User: ben
 * Date: 29/09/2014
 * Time: 2:05 PM
 */
public interface Filter<T> {
    boolean accept(T t);
}
