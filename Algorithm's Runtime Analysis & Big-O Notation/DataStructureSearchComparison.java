import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1_000, 100_000, 1_000_000};

        for (int n : sizes) {
            System.out.println("Dataset size: " + n);

            // Prepare data
            int[] array = new int[n];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            // Fill data structures with values 0 to n-1
            for (int i = 0; i < n; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            // Target element to search (worst case: last element)
            int target = n - 1;

            // Array linear search
            long start = System.nanoTime();
            boolean foundInArray = linearSearch(array, target);
            long end = System.nanoTime();
            System.out.printf("Array search found: %b, Time taken: %.6f ms%n",
                              foundInArray, (end - start) / 1_000_000.0);

            // HashSet search
            start = System.nanoTime();
            boolean foundInHashSet = hashSet.contains(target);
            end = System.nanoTime();
            System.out.printf("HashSet search found: %b, Time taken: %.6f ms%n",
                              foundInHashSet, (end - start) / 1_000_000.0);

            // TreeSet search
            start = System.nanoTime();
            boolean foundInTreeSet = treeSet.contains(target);
            end = System.nanoTime();
            System.out.printf("TreeSet search found: %b, Time taken: %.6f ms%n",
                              foundInTreeSet, (end - start) / 1_000_000.0);

            System.out.println("-----------------------------");
        }
    }

    // Linear search in array
    public static boolean linearSearch(int[] arr, int target) {
        for (int val : arr) {
            if (val == target) return true;
        }
        return false;
    }
}
