package org.fix4j.test.plumbing;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 4:47 PM
 */
public interface Consumer<M> {
    void accept(M m);
}
