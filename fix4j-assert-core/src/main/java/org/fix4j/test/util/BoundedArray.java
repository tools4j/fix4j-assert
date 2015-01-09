package org.fix4j.test.util;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * User: ben
 * Date: 27/09/2014
 * Time: 4:53 AM
 */
public class BoundedArray<T> implements Iterable<T> {
    private final ConcurrentLinkedDeque<T> list;
    private final int capacity;
    private boolean capacityWasHit = false;

    public BoundedArray(final int capacity) {
        this.list = new ConcurrentLinkedDeque<>();
        this.capacity = capacity;
    }

    public synchronized void add(T element) {
        if(capacity == 0) return;
        if(list.size() >= capacity){
            capacityWasHit = true;
            list.removeFirst();
        }
        list.add(element);
    }

    public synchronized void addAll(final Iterator<T> i) {
        if(capacity == 0) return;
        while(i.hasNext()){
            add(i.next());
        }
    }

    @Override
    public Iterator<T> iterator(){
        return list.iterator();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean wasAddedToWhenAtCapacity(){
        return capacityWasHit;
    }
}
