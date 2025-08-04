import java.util.Stack;

public class SortStack {
    
    // Main function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();             // Pop top element
            sortStack(stack);                  // Sort remaining stack
            insertInSortedOrder(stack, top);   // Insert popped element in sorted order
        }
    }

    // Helper function to insert an element in sorted order
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int top = stack.pop();                      // Remove top to insert element below it
            insertInSortedOrder(stack, element);        // Recursive call
            stack.push(top);                            // Push top back after insertion
        }
    }

    // Utility to print stack
    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("Sorted stack:");
        printStack(stack); // Output should be ascending from bottom to top
    }
}
