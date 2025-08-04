import java.util.LinkedList;
import java.util.Queue;

public class QueueReverser {

    // Recursive function to reverse the queue
    public static <T> void reverseQueue(Queue<T> queue) {
        if (queue.isEmpty()) {
            return;
        }

        // Remove front element
        T front = queue.remove();

        // Recursively reverse remaining queue
        reverseQueue(queue);

        // Add removed element to the back
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
