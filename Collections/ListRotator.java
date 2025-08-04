import java.util.*;

public class ListRotator {

    public static <T> List<T> rotateLeft(List<T> list, int positions) {
        int size = list.size();
        if (list == null || size == 0 || positions <= 0) return list;

        // Normalize positions in case it's greater than size
        positions = positions % size;

        List<T> rotated = new ArrayList<>();

        // Add elements from positions to end
        for (int i = positions; i < size; i++) {
            rotated.add(list.get(i));
        }

        // Add the initial part (0 to positions - 1)
        for (int i = 0; i < positions; i++) {
            rotated.add(list.get(i));
        }

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        List<Integer> result = rotateLeft(input, rotateBy);
        System.out.println("Original List: " + input);
        System.out.println("Rotated List: " + result);
    }
}
