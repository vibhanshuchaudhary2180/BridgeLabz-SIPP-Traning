public class CircularBuffer {
    private int[] buffer;
    private int capacity;
    private int head = 0; // points to the oldest element
    private int tail = 0; // points to the next write position
    private int size = 0;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    // Insert an element, overwriting oldest if buffer is full
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            // Buffer full, move head forward to overwrite oldest element
            head = (head + 1) % capacity;
        }
    }

    // Get the current contents of the buffer in order from oldest to newest
    public int[] getBufferContents() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(head + i) % capacity];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println(java.util.Arrays.toString(cb.getBufferContents())); // [1, 2, 3]

        cb.insert(4); // Overwrites oldest element (1)
        System.out.println(java.util.Arrays.toString(cb.getBufferContents())); // [2, 3, 4]
    }
}
