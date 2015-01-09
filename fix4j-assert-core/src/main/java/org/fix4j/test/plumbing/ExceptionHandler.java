package org.fix4j.test.plumbing;

/**
 * User: ben
 * Date: 22/12/14
 * Time: 3:28 PM
 */
public interface ExceptionHandler {
    public Throwable handle(final Throwable t);
}
