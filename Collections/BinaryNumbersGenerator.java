import java.util.*;

public class BinaryNumbersGenerator {

    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        
        // Start with the first binary number "1"
        queue.add("1");
        
        for (int i = 0; i < N; i++) {
            // Dequeue front element
            String current = queue.poll();
            result.add(current);
            
            // Enqueue current + "0" and current + "1"
            queue.add(current + "0");
            queue.add(current + "1");
        }
        
        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println(binaryNumbers);  // Output: [1, 10, 11, 100, 101]
    }
}
