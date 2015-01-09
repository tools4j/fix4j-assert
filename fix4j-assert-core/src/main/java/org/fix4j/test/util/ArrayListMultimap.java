package org.fix4j.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: ben
 * Date: 23/09/2014
 * Time: 5:23 AM
 */
public class ArrayListMultimap<K,V> implements Multimap<K,V> {
    private final List<V> EMPTY = Collections.unmodifiableList(new ArrayList<V>());
    private final ConcurrentHashMap<K, List<V>> map = new ConcurrentHashMap<K, List<V>>();

    @Override
    public List<V> get(final K key) {
        final List<V> results = map.get(key);
        if(results == null) return EMPTY;
        else return Collections.unmodifiableList(results);
    }

    @Override
    public V getExpectingOne(final K key) {
        final List<V> results = get(key);
        if(results.size() == 0 || results.size() > 1){
            throw new IllegalStateException("Single result expected, " + results.size() + " found. key:" + key + " values:" + results);
        } else {
            return results.get(0);
        }
    }

    @Override
    public V getFirst(final K key) {
        final List<V> results = get(key);
        if(results.size() == 0){
            throw new IllegalStateException("At least one result expected, none found.  Key:" + key);
        } else {
            return results.get(0);
        }
    }

    @Override
    public void put(final K key, final V value) {
        if(value == null){
            throw new IllegalArgumentException("Value cannot be null");
        }
        List<V> results = map.get(key);
        if(results == null){
            List<V> newList = new ArrayList<V>();
            List<V> alreadyExistingList = map.putIfAbsent(key, newList);
            results = (alreadyExistingList != null) ? alreadyExistingList: newList;
        }
        results.add(value);
    }

    @Override
    public boolean containsAtLeastOneValueFor(final K key){
        //assumes that empty lists will not be stored in the map
        return map.containsKey(key);
    }

    @Override
    public boolean containsKey(final K key){
        return containsAtLeastOneValueFor(key);
    }

    @Override
    public List<V> allValues() {
        final List<V> returnList = new ArrayList<V>();
        for(final K key: map.keySet()){
            returnList.addAll(map.get(key));
        }
        return Collections.unmodifiableList(returnList);
    }

    @Override
    public Iterator<V> values(){
        return allValues().iterator();
    }
}
