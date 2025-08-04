import java.util.*;

public class MaxValueKeyFinder {

    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return null; // or throw exception based on your needs
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = Map.of(
            "A", 10,
            "B", 20,
            "C", 15
        );

        System.out.println(findKeyWithMaxValue(input)); // Output: B
    }
}
