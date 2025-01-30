//Implement a Custom Hash Map
//Problem: Design and implement a basic hash map class with operations for insertion, deletion, and retrieval.
//Hint: Use an array of linked lists to handle collisions using separate chaining.


// importing linke list as we will store our pair in the form of entry(Template)
import java.util.LinkedList;

class MyHashMap<K, V> {
    // initial size
    private static final int DEFAULT_CAPACITY = 16;
    // increase the size of object dynamically
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList[] buckets;
    private int size;

    // Entry class to hold key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Hash function to change the key into an index
    private int hash(K key) {
//        System.out.println(key.hashCode());
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }

        bucket.add(new Entry<>(key, value)); // Insert new key
        size++;

        // Resize if necessary
        if ((double) size / buckets.length > LOAD_FACTOR) {
            resize();
        }
    }

    // Retrieve the value associated with a key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null; // Key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    // Resize the hash map when the load factor is exceeded
    private void resize() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                put(entry.key, entry.value);
            }
        }
    }

    // Get the number of key-value pairs in the hash map
    public int size() {
        return size;
    }

    // Check if the hash map is empty
    public boolean isEmpty() {
        return size == 0;
    }
}


public class ImplementCustomHashMap {
    public static void main(String[] args) {
        // Example usage
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // putting values in hash map
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // printing the val
        System.out.println("Value for 'one': " + map.get("one"));
        System.out.println("Value for 'two': " + map.get("two"));


        // removing the second entry
        map.remove("two");

        // should be null
        System.out.println("Value for 'two' after removal: " + map.get("two"));

        // the current size of 2
        System.out.println("Size of map: " + map.size());
    }
}