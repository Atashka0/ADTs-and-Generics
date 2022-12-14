package adts;

public interface Map<K, V> {

    public V put(K key, V value);

    public V get(K key);

    public boolean containsKey(K key);

    public int size();

    public void clear();

}

