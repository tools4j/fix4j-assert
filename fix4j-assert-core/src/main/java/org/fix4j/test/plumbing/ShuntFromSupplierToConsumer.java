package org.fix4j.test.plumbing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 4:52 PM
 */
public class ShuntFromSupplierToConsumer<M> implements Runnable {
    private final static Logger LOGGER = LoggerFactory.getLogger(BlockingPipe.class);
    private final Consumer<M> consumer;
    private final Supplier<M> supplier;
    private final String id;
    private final ExceptionHandler exceptionHandler;
    private ExecutorService executorService;

    public ShuntFromSupplierToConsumer(final String id, final Supplier<M> supplier, final Consumer<M> consumer) {
        this.id = id;
        this.consumer = consumer;
        this.supplier = supplier;
        this.exceptionHandler = null;
    }

    public ShuntFromSupplierToConsumer(final String id, final Supplier<M> supplier, final Consumer<M> consumer, final ExceptionHandler exceptionHandler) {
        this.id = id;
        this.consumer = consumer;
        this.supplier = supplier;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void run(){
        try {
            while(true){
                try {
                    LOGGER.debug("[" + id + "] Waiting for next message from supplier");
                    final M m = supplier.get(Long.MAX_VALUE);
                    LOGGER.debug("[" + id + "] Shunting message:" + m + " from:" + supplier + " to " + consumer);
                    consumer.accept(m);
                } catch(Throwable e){
                    if(exceptionHandler != null) {
                        final Throwable throwable = exceptionHandler.handle(e);
                        if (throwable != null) {
                            throw throwable;
                        }
                    } else {
                        throw e;
                    }
                }
            }
        } catch (Throwable throwable) {
            executorService.shutdown();
            throw new RuntimeException(throwable);
        }
    }

    public void start() {
        this.executorService = Executors.newSingleThreadExecutor();
        executorService.submit(this);
    }
}
