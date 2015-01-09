package org.fix4j.test.plumbing;

/**
 * Simple Supplier interface.
 */
public interface Supplier<M> {
    /**
     * @param timeoutInMillis
     * @return null if timeout is reached before the next object becomes available.  Non-null if
     * an object becomes available before timeout is reached.
     */
    M get(long timeoutInMillis);
}
