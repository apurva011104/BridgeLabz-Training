import java.util.LinkedList;
class HashMapImplementation<Key, Value> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Pair<Key, Value>>[] table;

    public HashMapImplementation() {
        table = new LinkedList[INITIAL_CAPACITY];
    }
    
    private static class Pair<K, V> {
        K key;
        V value;
        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(Key key) {
        return key.hashCode() % table.length;
    }
   
    public void put(Key key, Value value) {
        int index = hash(key);
        
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        
        for (Pair<Key, Value> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        table[index].add(new Pair<>(key, value));
    }
    

    public Value getKey(Key key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Pair<Key, Value> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }
    

    public void remove(Key key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Pair<Key, Value> entry : table[index]) {
                if (entry.key.equals(key)) {
                    table[index].remove(entry);
                    return;
                }
            }
        }
    }

    public int size() {
        int size = 0;
        for (LinkedList<Pair<Key, Value>> bucket : table) {
            if (bucket != null) {
                size += bucket.size();
            }
        }
        return size;
    }
   
    public void display() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Pair<Key, Value> entry : table[i]) {
                    System.out.print("[" + entry.key + " = " + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
    
        HashMapImplementation<Integer, Integer> map = new HashMapImplementation<>();
        
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(7, 50); 
        map.put(2, 80);
    
        map.display();
        System.out.println("Value for '2': " + map.getKey(2));
        System.out.println("Value for 7: " + map.getKey(7));
        map.remove(3);
        map.display();
        System.out.println("Size of map: " + map.size());
    }
}