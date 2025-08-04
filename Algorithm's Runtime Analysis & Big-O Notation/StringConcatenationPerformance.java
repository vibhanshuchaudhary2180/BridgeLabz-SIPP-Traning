public class StringConcatenationPerformance {

    public static void main(String[] args) {
        int n = 1_000_000;
        String toAppend = "a";

        // 1. Using String (inefficient, O(N^2))
        long startTime = System.nanoTime();
        String resultString = "";
        for (int i = 0; i < n; i++) {
            resultString += toAppend;
        }
        long endTime = System.nanoTime();
        System.out.printf("String concatenation time: %.3f seconds%n", (endTime - startTime) / 1_000_000_000.0);

        // 2. Using StringBuilder (efficient, O(N))
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(toAppend);
        }
        String resultBuilder = sb.toString();
        endTime = System.nanoTime();
        System.out.printf("StringBuilder concatenation time: %.3f seconds%n", (endTime - startTime) / 1_000_000_000.0);

        // 3. Using StringBuffer (thread-safe, slightly slower)
        startTime = System.nanoTime();
        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuffer.append(toAppend);
        }
        String resultBuffer = sbuffer.toString();
        endTime = System.nanoTime();
        System.out.printf("StringBuffer concatenation time: %.3f seconds%n", (endTime - startTime) / 1_000_000_000.0);
    }
}
