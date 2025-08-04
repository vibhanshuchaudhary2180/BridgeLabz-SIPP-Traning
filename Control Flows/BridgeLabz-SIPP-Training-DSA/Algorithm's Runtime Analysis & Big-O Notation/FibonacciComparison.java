public class FibonacciComparison {

    public static void main(String[] args) {
        int[] testValues = {10, 30, 40}; // Test with different N (50 is too large for recursion)

        for (int n : testValues) {
            System.out.println("Fibonacci number for n = " + n);

            // Measure Recursive
            long startTime = System.nanoTime();
            int fibRec = fibonacciRecursive(n);
            long endTime = System.nanoTime();
            System.out.printf("Recursive result: %d, Time taken: %.6f ms%n",
                              fibRec, (endTime - startTime) / 1_000_000.0);

            // Measure Iterative
            startTime = System.nanoTime();
            int fibIter = fibonacciIterative(n);
            endTime = System.nanoTime();
            System.out.printf("Iterative result: %d, Time taken: %.6f ms%n",
                              fibIter, (endTime - startTime) / 1_000_000.0);

            System.out.println("-------------------------");
        }
    }

    // Recursive Fibonacci (exponential time)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (linear time)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
