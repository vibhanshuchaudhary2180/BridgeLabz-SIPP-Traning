import java.util.Arrays;
import java.util.Random;

public class SearchPerformanceComparison {

    // Linear search implementation
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary search implementation (array must be sorted)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Generate random array of given size
    public static int[] generateRandomArray(int size, int maxValue) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(maxValue);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 10_000, 1_000_000};
        int maxValue = 2_000_000; // Range of values in dataset

        Random rand = new Random();

        for (int size : datasetSizes) {
            System.out.println("Dataset size: " + size);

            // Generate random data and pick a random target from the array
            int[] data = generateRandomArray(size, maxValue);
            int target = data[rand.nextInt(size)];

            // Measure Linear Search time
            long start = System.nanoTime();
            int linearIndex = linearSearch(data, target);
            long end = System.nanoTime();
            double linearTimeMs = (end - start) / 1_000_000.0;

            // Sort data for binary search
            Arrays.sort(data);

            // Measure Binary Search time
            start = System.nanoTime();
            int binaryIndex = binarySearch(data, target);
            end = System.nanoTime();
            double binaryTimeMs = (end - start) / 1_000_000.0;

            System.out.printf("Linear Search: index=%d, time=%.4f ms%n", linearIndex, linearTimeMs);
            System.out.printf("Binary Search: index=%d, time=%.6f ms%n", binaryIndex, binaryTimeMs);
            System.out.println();
        }
    }
}
