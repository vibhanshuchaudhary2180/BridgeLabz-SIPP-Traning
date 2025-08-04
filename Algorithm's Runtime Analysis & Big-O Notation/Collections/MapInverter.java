import java.util.*;

public class MapInverter {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> original) {
        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : original.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = Map.of(
            "A", 1,
            "B", 2,
            "C", 1
        );

        Map<Integer, List<String>> output = invertMap(input);

        System.out.println(output);
        // Output: {1=[A, C], 2=[B]}
    }
}
