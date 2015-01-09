package org.fix4j.test.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * User: ben
 * Date: 23/09/2014
 * Time: 5:21 AM
 */
public interface Multimap<K,V> {
    Collection<V> get(K key);
    V getExpectingOne(K key);
    V getFirst(K key);
    void put(K key, V value);
    boolean containsAtLeastOneValueFor(K key);
    boolean containsKey(K key);
    List<V> allValues();
    Iterator<V> values();

    public static class Utils{
        public static <K,V> Multimap<K,V> unmodifiableMultimap(final Multimap<K,V> multimap){
            return new Multimap<K, V>() {
                @Override
                public Collection<V> get(final K key) {
                    //I know that ArrayListMultimap already returns an unmodifiable List.  However not sure
                    //what the implementation is here, so being cautious.
                    return Collections.unmodifiableCollection(multimap.get(key));
                }

                @Override
                public V getExpectingOne(final K key) {
                    return multimap.getExpectingOne(key);
                }

                @Override
                public V getFirst(final K key) {
                    return multimap.getFirst(key);
                }

                @Override
                public void put(final K key, final V value) {
                    throw new UnsupportedOperationException("Cannot modify this multimap as it has been created as Unmodifiable.");
                }

                @Override
                public boolean containsAtLeastOneValueFor(final K key) {
                    return multimap.containsAtLeastOneValueFor(key);
                }

                @Override
                public boolean containsKey(final K key) {
                    return multimap.containsKey(key);
                }

                @Override
                public List<V> allValues() {
                    return multimap.allValues();
                }

                @Override
                public Iterator<V> values() {
                    return allValues().iterator();
                }
            };
        }
    }
}
