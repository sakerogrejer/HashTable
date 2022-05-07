public class EntrySet<K, V>
{

    public K key;
    public V value;

    public EntrySet(K k, V v)
    {
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "<Key: " + key + " Value: " + value + "> ";
    }

}
