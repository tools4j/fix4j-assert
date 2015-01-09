package org.fix4j.test.util;

import java.util.Iterator;

/**
 * User: ben
 * Date: 3/09/2014
 * Time: 6:50 PM
 */
public class PeekableIterator<T> implements Iterator<T> {
    private final Iterator<? extends T> iterator;
    private T peekedValue = null;

    public PeekableIterator(final Iterator<? extends T> iterator) {
        this.iterator = iterator;
    }

    public PeekableIterator(final Iterable<? extends T> iterable) {
        this.iterator = iterable.iterator();
    }

    @Override
    public boolean hasNext() {
        return peekedValue != null || iterator.hasNext();
    }

    @Override
    public T next() {
        if(peekedValue != null){
            final T returnValue = peekedValue;
            peekedValue = null;
            return returnValue;
        } else {
            return iterator.next();
        }
    }

    @Override
    public void remove() {
        if(peekedValue != null){
            final T returnValue = peekedValue;
            peekedValue = null;
        } else {
            iterator.remove();
        }
    }

    public T peek(){
        if(peekedValue != null){
            return peekedValue;
        } else {
            peekedValue = iterator.next();
            return peekedValue;
        }
    }
}
