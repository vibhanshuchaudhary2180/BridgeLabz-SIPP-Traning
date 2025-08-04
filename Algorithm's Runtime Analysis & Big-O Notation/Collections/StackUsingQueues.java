import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        // Always enqueue to queue2
        queue2.offer(x);
        
        // Enqueue all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        
        // Swap names of queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Removes the element on top of the stack and returns it
    public int pop() {
        if (queue1.isEmpty()) throw new RuntimeException("Stack is empty");
        return queue1.poll();
    }

    // Get the top element without removing it
    public int top() {
        if (queue1.isEmpty()) throw new RuntimeException("Stack is empty");
        return queue1.peek();
    }

    // Check if stack is empty
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.top()); // Output: 2
    }
}
