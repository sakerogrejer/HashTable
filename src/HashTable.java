import java.util.*;

public class HashTable<K, V> implements java.util.Map
{

    LinkedList<EntrySet<K, V>>[] data = new LinkedList[32];

    public int hash(K key)
    {
        return key.hashCode();
    }

    public int mapTo(int i)
    {
        return i % data.length;
    }

    @Override
    public int size()
    {
        int i = 0;
        for(LinkedList l : data)
        {
            if(l != null) {
                i += l.size();
            }
        }
        return i;
    }

    @Override
    public String toString()
    {
        String s = "";
        for(LinkedList l : data)
        {
            if(l != null) {

                for(Object e : l)
                {
                   s += e.toString();
                }
                s += "\n";
            }
        }
        return s;
    }

    @Override
    public boolean isEmpty() {
        return data == null;
    }

    @Override
    public boolean containsKey(Object key) {
        if(isEmpty())
        {
            return false;
        }
        for(LinkedList l : data)
        {
            if(l != null) {

                for(Object e : l)
                {
                    if(((EntrySet<?, ?>) e).key == key)
                    {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if(isEmpty())
        {
            return false;
        }
        for(LinkedList l : data)
        {
            if(l != null) {

                for(Object e : l)
                {
                    if(((EntrySet<?, ?>) e).value == value)
                    {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        if(isEmpty())
        {
            return null;
        }
        for(LinkedList l : data)
        {
            if(l != null) {

                for(Object e : l)
                {
                    if(((EntrySet<?, ?>) e).key == key)
                    {
                        return ((EntrySet<?, ?>) e).value;
                    }
                }

            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int hash = key.hashCode();
        hash = mapTo(hash);
        if(hash > data.length)
        {
            return null;
        }

        int prevValue = 0;

        if(data[hash] == null)
        {
            data[hash] = new LinkedList<EntrySet<K, V>>();
        }

        data[hash].add(new EntrySet<>((K)key, (V)value));

        return prevValue;

    }

    @Override
    public Object remove(Object key) {
        if(isEmpty())
        {
            return null;
        }
        for(LinkedList l : data)
        {
            if(l != null) {

                for(Object e : l)
                {
                    if(((EntrySet<?, ?>) e).key == key)
                    {
                        EntrySet<K, V> temp = (EntrySet<K, V>) e;
                        l.remove(e);
                        return temp;
                    }
                }

            }
        }
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {
        for(LinkedList l : data)
        {
            if(l != null) {

                for(Object e : l)
                {
                    l.remove(e);
                }
            }
        }
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
