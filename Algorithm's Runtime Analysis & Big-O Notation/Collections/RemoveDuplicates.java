import java.util.*;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicates(List<T> input) {
        Set<T> seen = new LinkedHashSet<>();
        for (T item : input) {
            seen.add(item); // LinkedHashSet maintains insertion order
        }
        return new ArrayList<>(seen);
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> result = removeDuplicates(input);

        System.out.println("Original List: " + input);
        System.out.println("Without Duplicates: " + result);
    }
}
