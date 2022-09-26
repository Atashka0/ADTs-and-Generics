package adts;

import java.util.ArrayList;
import java.util.List;
public class HashTableMap<K, V> implements Map<K, V> {
    private class KVPair {
        public K key;
        public V value;

        KVPair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<KVPair>[] buckets;

    private int size;

    public HashTableMap(int numBuckets) {
        this.buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            this.buckets[i] = new ArrayList<>();
        }
        this.size = 0;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % this.buckets.length;
    }

    private double loadFactor() {
        return (double) size / this.buckets.length;
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        KVPair pair = new KVPair(key, value);

        for (KVPair duo : buckets[index]) {
            if (key.equals(duo.key)) {
                V val = duo.value;
                duo.value = value;
                return val;
            }
        }

        this.buckets[index].add(pair);
        this.size += 1;

        return null;
    }

    public V get(K key) {
        int index = getIndex(key);

        if (buckets[index] == null) {
            return null;
        }

        for (KVPair pair : buckets[index]) {
            if (key.equals(pair.key)) {
                return pair.value;
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);

        if (buckets[index] == null) {
            return false;
        }

        for (KVPair pair : buckets[index]) {
            if (key.equals(pair.key)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        for (int i = 0; i < this.buckets.length; i++) {
            buckets[i].clear();
        }
        this.size = 0;
    }
}


