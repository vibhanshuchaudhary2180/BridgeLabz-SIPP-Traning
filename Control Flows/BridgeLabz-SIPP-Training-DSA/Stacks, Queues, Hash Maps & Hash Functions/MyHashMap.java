import java.util.LinkedList;

public class MyHashMap {

    private static final int SIZE = 1000;

    // Entry class to hold key-value pairs
    static class Entry {
        int key, value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array of buckets
    private LinkedList<Entry>[] map;

    // Constructor
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    private Entry getEntry(int key) {
        int index = getIndex(key);
        LinkedList<Entry> bucket = map[index];
        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key == key) {
                    return entry;
                }
            }
        }
        return null;
    }

    // Insert or update key-value pair
    public void put(int key, int value) {
        int index = getIndex(key);
        if (map[index] == null) {
            map[index] = new LinkedList<>();
        }
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value; // Update
        } else {
            map[index].add(new Entry(key, value)); // Insert
        }
    }

    // Retrieve value for a key
    public int get(int key) {
        Entry entry = getEntry(key);
        return entry != null ? entry.value : -1; // Return -1 if not found
    }

    // Remove key-value pair
    public void remove(int key) {
        int index = getIndex(key);
        LinkedList<Entry> bucket = map[index];
        if (bucket != null) {
            bucket.removeIf(entry -> entry.key == key);
        }
    }

    // Example usage
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1)); // 10
        System.out.println(map.get(3)); // -1 (not found)
        map.put(2, 30);                 // update key 2
        System.out.println(map.get(2)); // 30
        map.remove(2);
        System.out.println(map.get(2)); // -1
    }
}
