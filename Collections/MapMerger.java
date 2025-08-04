import java.util.*;

public class MapMerger {

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> merged = new HashMap<>(map1); // start with all entries from map1

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            merged.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return merged;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2);
        Map<String, Integer> map2 = Map.of("B", 3, "C", 4);

        Map<String, Integer> mergedMap = mergeMaps(map1, map2);
        System.out.println(mergedMap); // Output: {A=1, B=5, C=4}
    }
}
