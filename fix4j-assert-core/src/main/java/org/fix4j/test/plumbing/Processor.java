package org.fix4j.test.plumbing;

/**
 * User: ben
 * Date: 1/12/14
 * Time: 5:59 AM
 */
public interface Processor<T> {
    /**
     * The process method accepts an entity to be processed, and should return the processed entity.
     *
     * If the processor wishes to halt further processing of the entity, then null should be returned.
     *
     * @param entity The entity that is to be processed.
     * @return The entity that should be used from now onwards.
     */
    T process(T entity);
}
