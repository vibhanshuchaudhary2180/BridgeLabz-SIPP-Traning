import java.util.Arrays;
import java.util.Random;

public class SortPerformanceComparison {

    // Bubble Sort - O(N^2)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // If no swaps, array is sorted
        }
    }

    // Merge Sort - O(N log N)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort - O(N log N) average
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Helper method to generate random int array
    public static int[] generateRandomArray(int size, int maxValue) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(maxValue);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10_000, 100_000}; // Use smaller for Bubble Sort to keep reasonable time
        int maxValue = 1_000_000;

        for (int size : datasetSizes) {
            System.out.println("Dataset size: " + size);

            // Generate array
            int[] original = generateRandomArray(size, maxValue);

            // Bubble Sort (skip large datasets for performance reasons)
            if (size <= 10_000) { // limit Bubble Sort to 10k for demo purposes
                int[] bubbleArr = Arrays.copyOf(original, original.length);
                long start = System.nanoTime();
                bubbleSort(bubbleArr);
                long end = System.nanoTime();
                System.out.printf("Bubble Sort: %.4f ms%n", (end - start) / 1_000_000.0);
            } else {
                System.out.println("Bubble Sort: Skipped due to large dataset");
            }

            // Merge Sort
            int[] mergeArr = Arrays.copyOf(original, original.length);
            long start = System.nanoTime();
            mergeSort(mergeArr, 0, mergeArr.length - 1);
            long end = System.nanoTime();
            System.out.printf("Merge Sort: %.4f ms%n", (end - start) / 1_000_000.0);

            // Quick Sort
            int[] quickArr = Arrays.copyOf(original, original.length);
            start = System.nanoTime();
            quickSort(quickArr, 0, quickArr.length - 1);
            end = System.nanoTime();
            System.out.printf("Quick Sort: %.4f ms%n", (end - start) / 1_000_000.0);

            System.out.println();
        }
    }
}
