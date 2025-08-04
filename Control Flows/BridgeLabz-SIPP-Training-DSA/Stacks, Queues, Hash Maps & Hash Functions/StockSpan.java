import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop all elements smaller than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, all previous prices are smaller
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current day index to stack
            stack.push(i);
        }

        return span;
    }

    // Example usage
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        System.out.println("Stock spans:");
        for (int s : span) {
            System.out.print(s + " ");
        }
        // Output: 1 1 1 2 1 4 6
    }
}
