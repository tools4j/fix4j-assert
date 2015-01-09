package org.fix4j.test.util;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
* User: ben
* Date: 19/08/2014
* Time: 6:02 PM
*/
public class Utils {
    public static int[] toIntArray(List<Integer> list)  {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list)
            ret[i++] = e;
        return ret;
    }

    public static <V> V executeUntilNonNullOrTimeout(final long timeoutMs, final long timeBetweenPollsMs, final Callable<V> callable) throws InterruptedException {
        final long started = new Date().getTime();
        long elapsedTime = 0;
        while (elapsedTime < timeoutMs) {
            final V value;
            try {
                value = callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (value != null) {
                return value;
            } else {
                elapsedTime = (new Date().getTime()) - started;
            }
            Thread.sleep(timeBetweenPollsMs);
        }
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * @return the head of this queue, or null if this queue is empty
     * @throws InterruptedException
     */
    public static <T> T peek(final BlockingQueue<T> queue, final long timeoutMs, final long timeBetweenPollsMs) throws InterruptedException {
        return Utils.executeUntilNonNullOrTimeout(timeoutMs, timeBetweenPollsMs, new Callable<T>() {
            @Override
            public T call() throws Exception {
                return queue.peek();
            }
        });
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * @return the head of this queue, or null if this queue is empty
     * @throws InterruptedException
     */
    public static <T> T poll(final BlockingQueue<T> queue, final long timeoutMs, final long timeBetweenPollsMs) throws InterruptedException {
        return Utils.executeUntilNonNullOrTimeout(timeoutMs, timeBetweenPollsMs, new Callable<T>() {
            @Override
            public T call() throws Exception {
                return queue.poll();
            }
        });
    }
}
