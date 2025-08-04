import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    // Constructor
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // Enqueue operation (push element to the end)
    public void enqueue(int x) {
        stackIn.push(x);
    }

    // Dequeue operation (remove element from front)
    public int dequeue() {
        shiftStacks();
        if (stackOut.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stackOut.pop();
    }

    // Peek operation (view front element without removing)
    public int peek() {
        shiftStacks();
        if (stackOut.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stackOut.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // Helper method to move elements from stackIn to stackOut if needed
    private void shiftStacks() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
public class Main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // 10
        System.out.println(q.peek());    // 20
        System.out.println(q.dequeue()); // 20
        System.out.println(q.isEmpty()); // false
    }
  }
}
