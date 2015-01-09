package org.fix4j.test.plumbing;

import org.fix4j.test.util.DateUtils;

/**
 * User: ben
 * Date: 21/11/14
 * Time: 4:49 PM
 */
public abstract class AbstractChainedSupplier<M> implements Supplier<M>, Processor<M>{
    private final Supplier<M> source;

    public AbstractChainedSupplier(final Supplier<M> source) {
        this.source = source;
    }

    @Override
    public M get(final long timeoutInMillis) {
        final long startTime = DateUtils.now();
        while(DateUtils.timeSince(startTime) < timeoutInMillis) {
            long timeRemaining = timeoutInMillis - DateUtils.timeSince(startTime);
            final M message = source.get(timeRemaining);
            if(message == null){
                return null;
            }
            final M entity = process(message);
            if(entity != null){
                return message;
            }
        }
        return null;
    }
}
