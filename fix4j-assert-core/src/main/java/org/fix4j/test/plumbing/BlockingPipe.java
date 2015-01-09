package org.fix4j.test.plumbing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 4:48 PM
 */
public class BlockingPipe<M> implements Consumer<M>, Supplier<M> {
    private final static Logger LOGGER = LoggerFactory.getLogger(BlockingPipe.class);
    private final BlockingQueue<M> blockingQueue;
    private final String id;

    public BlockingPipe(final String id) {
        this.id = id;
        this.blockingQueue = new LinkedBlockingQueue<M>();
    }

    @Override
    public void accept(final M m) {
        try {
            LOGGER.info("Adding message to pipe [" + id + "]:" + m);
            blockingQueue.put(m);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public M get(long timeoutInMillis) {
        try {
            LOGGER.info( "[" + id + "] Polling for (waiting for " + timeoutInMillis + "ms) message from pipe");
            final M message = blockingQueue.poll(timeoutInMillis, TimeUnit.MILLISECONDS);
            if(message == null){
                LOGGER.info("[" + id + "] Timed out wait for message from pipe");
            } else {
                LOGGER.info("[" + id + "] Polled message from pipe: " + message);
            }
            return message;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
